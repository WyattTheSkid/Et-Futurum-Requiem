package ganymedes01.etfuturum.entities;

import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.Tags;
import ganymedes01.etfuturum.entities.ai.FlyingPathNavigator;
import ganymedes01.etfuturum.entities.ai.ExtendedEntityMoveHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.Random;

public class EntityDrowned extends EntityZombie implements IRangedAttackMob {

	private static final float EQUIPMENT_CHANCE = 0.1F;
	private static final float GOLD_INGOT_DROP_CHANCE = 0.05F;
	private static final float GOLD_INGOT_LOOTING_BONUS = 0.01F;
	private static final float NAUTILUS_SHELL_CHANCE = 0.03F;
	private static final int SEA_LEVEL = 63;

	public static final boolean DEBUG_DROWNED = false;
	private static final boolean DEBUG_DROWNED_AI = false;

	private boolean hasNautilusShell;

	// Swim animation state - mirrors 1.21.4 LivingEntity.swimAmount / 1.13.2 getSwimAnimation()
	// Smoothly transitions 0.0 (standing) to 1.0 (fully swimming) for animation blending
	private float swimAmount;
	private float swimAmountO;

	// Mirrors 1.21.4 Drowned.searchingForLand - true when swimming up to surface
	private boolean searchingForLand;

	private PathNavigate waterNavigation;
	private PathNavigate groundNavigation;

	public EntityDrowned(World world) {
		super(world);
		stepHeight = 1.0F;
		getNavigator().setBreakDoors(false);

		// Remove default melee and swimming tasks so they don't float and only melee when not holding a trident
		java.util.Iterator<net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry> iterator = tasks.taskEntries.iterator();
		while (iterator.hasNext()) {
			net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry entry = iterator.next();
			if (entry.action instanceof net.minecraft.entity.ai.EntityAIAttackOnCollide || entry.action instanceof net.minecraft.entity.ai.EntityAISwimming) {
				iterator.remove();
			}
		}

		// Clear default target tasks to apply drowned-specific targeting
		targetTasks.taskEntries.clear();
		targetTasks.addTask(1, new net.minecraft.entity.ai.EntityAIHurtByTarget(this, true));
		targetTasks.addTask(2, new AITargetPlayer(this, EntityPlayer.class, 0, true));
		targetTasks.addTask(3, new net.minecraft.entity.ai.EntityAINearestAttackableTarget(this, net.minecraft.entity.passive.EntityVillager.class, 0, false));
		targetTasks.addTask(3, new net.minecraft.entity.ai.EntityAINearestAttackableTarget(this, net.minecraft.entity.monster.EntityIronGolem.class, 0, true));
		// TODO: Target Axolotls when backported
		// targetTasks.addTask(3, new net.minecraft.entity.ai.EntityAINearestAttackableTarget(this, EntityAxolotl.class, 10, true, false, null));
		// TODO: Target baby Turtles on land when backported
		// targetTasks.addTask(3, new net.minecraft.entity.ai.EntityAINearestAttackableTarget(this, EntityTurtle.class, 10, true, false, EntityTurtle.BABY_ON_LAND_SELECTOR));

		tasks.addTask(1, new AIGoToWater(this, 1.0D));
		// TODO: Avoid Axolotls when backported
		// tasks.addTask(2, new net.minecraft.entity.ai.EntityAIAvoidEntity(this, EntityAxolotl.class, 6.0F, 1.0D, 1.2D));
		// TODO: Destroy Turtle Eggs when backported
		// tasks.addTask(3, new AIDrownedDestroyEgg(Blocks.TURTLE_EGG, this, 1.0D, 16));
		tasks.addTask(2, new AITridentAttack(this, 1.0D, 40, 10.0F));
		tasks.addTask(2, new AIDrownedMeleeAttack(this, EntityPlayer.class, 1.0D, false));
		tasks.addTask(4, new AIDrownedMeleeAttack(this, net.minecraft.entity.passive.EntityVillager.class, 1.0D, true));
		tasks.addTask(5, new AIGoToBeach(this, 1.0D));
		tasks.addTask(6, new AISwimUp(this, 1.0D, SEA_LEVEL));

		this.moveHelper = new DrownedMoveHelper(this);
		this.waterNavigation = new DrownedWaterPathNavigator(this, worldObj);
		this.waterNavigation.setCanSwim(true);
		this.waterNavigation.setAvoidsWater(false);
		this.groundNavigation = this.navigator;
		this.groundNavigation.setAvoidsWater(false);
	}

	public boolean hasNautilusShell() {
		return hasNautilusShell;
	}

	public void setHasNautilusShell(boolean hasNautilusShell) {
		this.hasNautilusShell = hasNautilusShell;
	}

	/**
	 * Returns the swim animation amount (0.0 = standing, 1.0 = fully swimming).
	 * Used by ModelDrowned for blending between standing and swimming poses.
	 */
	public float getSwimAmount() {
		return swimAmount;
	}

	public void setSearchingForLand(boolean searching) {
		this.searchingForLand = searching;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(21, Byte.valueOf((byte) 0));
		dataWatcher.addObject(22, Byte.valueOf((byte) 0));
		dataWatcher.addObject(23, Byte.valueOf((byte) 0));
	}

	public boolean isThrowingTrident() {
		return dataWatcher.getWatchableObjectByte(21) == 1;
	}

	public void setThrowingTrident(boolean throwing) {
		dataWatcher.updateObject(21, Byte.valueOf((byte) (throwing ? 1 : 0)));
	}

	public boolean isSwimming() {
		return dataWatcher.getWatchableObjectByte(22) == 1;
	}

	public void setSwimming(boolean swimming) {
		dataWatcher.updateObject(22, Byte.valueOf((byte) (swimming ? 1 : 0)));
	}

	public boolean isAggressive() {
		return dataWatcher.getWatchableObjectByte(23) == 1;
	}

	public void setAggressive(boolean aggressive) {
		dataWatcher.updateObject(23, Byte.valueOf((byte) (aggressive ? 1 : 0)));
	}

	public boolean wantsToSwim() {
		if (searchingForLand) {
			return true;
		}
		EntityLivingBase target = getAttackTarget();
		return target != null && target.isInWater();
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean isVillager() {
		return false;
	}

	@Override
	public void setVillager(boolean villager) {
	}

	@Override
	public void func_146070_a(boolean enabled) {
		super.func_146070_a(enabled);
	}

	@Override
	protected void addRandomArmor() {
		if (rand.nextFloat() < EQUIPMENT_CHANCE) {
			if (rand.nextInt(16) < 10 && ModItems.TRIDENT.isEnabled()) {
				setCurrentItemOrArmor(0, ModItems.TRIDENT.newItemStack());
			} else {
				setCurrentItemOrArmor(0, new ItemStack(Items.fishing_rod));
			}
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData spawnData = super.onSpawnWithEgg(data);
		if (ModItems.NAUTILUS_SHELL.isEnabled() && rand.nextFloat() < NAUTILUS_SHELL_CHANCE) {
			hasNautilusShell = true;
		}
		return spawnData;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (worldObj.difficultySetting == EnumDifficulty.PEACEFUL || !worldObj.spawnHostileMobs || !isSpawnPositionInWater()) {
			return false;
		}

		int x = MathHelper.floor_double(posX);
		int z = MathHelper.floor_double(posZ);
		BiomeGenBase biome = worldObj.getBiomeGenForCoords(x, z);

		boolean flag = isValidLightLevel() && worldObj.checkNoEntityCollision(boundingBox);
		if (!flag) {
			return false;
		}

		if (hasBiomeType(biome, Type.RIVER)) {
			if (rand.nextInt(15) != 0) {
				return false;
			}
		} else if (rand.nextInt(40) != 0 || boundingBox.minY >= SEA_LEVEL - 5) {
			return false;
		}

		return true;
	}

	@Override
	public void onLivingUpdate() {
		// Update swim animation amount - drowned always swim-pose when submerged in water and wanting to swim
		// Source: 1.21.4 LivingEntity swim amount update
		swimAmountO = swimAmount;
		if (isSwimming()) {
			swimAmount = Math.min(1.0F, swimAmount + 0.09F);
		} else {
			swimAmount = Math.max(0.0F, swimAmount - 0.09F);
		}

		if (!worldObj.isRemote) {
			setSwimming(isInWater() && wantsToSwim());
			setAggressive(getAttackTarget() != null);

			if (isSwimming()) {
				this.navigator = this.waterNavigation;
			} else {
				this.navigator = this.groundNavigation;
			}

			EntityLivingBase target = getAttackTarget();

			if (DEBUG_DROWNED_AI && ticksExisted % 40 == 0) {
				double dist = target != null ? getDistanceToEntity(target) : -1.0D;
				System.out.println(String.format(
					"[DrownedAI] ID: %d, Target: %s, Dist: %.2f, Daytime: %b, TargetInWater: %b, shouldAttack: %b, HeldTrident: %b",
					getEntityId(), target != null ? target.getClass().getSimpleName() : "null", dist, worldObj.isDaytime(),
					target != null && target.isInWater(), shouldAttack(target), isHoldingTrident()
				));
			}

			// Custom Trident pickup logic
			if (canPickUpLoot() && !dead && worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
				java.util.List items = worldObj.getEntitiesWithinAABB(net.minecraft.entity.item.EntityItem.class, boundingBox.expand(1.0D, 0.0D, 1.0D));
				for (Object obj : items) {
					net.minecraft.entity.item.EntityItem itemEntity = (net.minecraft.entity.item.EntityItem) obj;
					if (!itemEntity.isDead && itemEntity.getEntityItem() != null) {
						ItemStack stack = itemEntity.getEntityItem();
						if (ModItems.TRIDENT.isEnabled() && stack.getItem() == ModItems.TRIDENT.get()) {
							ItemStack current = getEquipmentInSlot(0);
							boolean shouldPickup = false;
							if (current == null) {
								shouldPickup = true;
							} else if (current.getItem() == ModItems.TRIDENT.get()) {
								if (stack.getItemDamage() < current.getItemDamage() || (stack.hasTagCompound() && !current.hasTagCompound())) {
									shouldPickup = true;
								}
							}
							
							if (shouldPickup) {
								if (current != null && rand.nextFloat() - 0.1F < equipmentDropChances[0]) {
									entityDropItem(current, 0.0F);
								}
								setCurrentItemOrArmor(0, stack);
								equipmentDropChances[0] = 2.0F;
								onItemPickup(itemEntity, 1);
								itemEntity.setDead();
							}
						}
					}
				}
			}
		}

		super.onLivingUpdate();
	}

	@Override
	public boolean handleWaterMovement() {
		if (isSwimming()) {
			double oldMotionX = motionX;
			double oldMotionY = motionY;
			double oldMotionZ = motionZ;
			boolean inWater = super.handleWaterMovement();
			motionX = oldMotionX;
			motionY = oldMotionY;
			motionZ = oldMotionZ;
			return inWater;
		}
		return super.handleWaterMovement();
	}

	@Override
	public float getBlockPathWeight(int x, int y, int z) {
		return worldObj.getBlock(x, y, z).getMaterial() == Material.water ? 10.0F : super.getBlockPathWeight(x, y, z);
	}

	@Override
	public void moveEntityWithHeading(float strafe, float forward) {
		if (this.isAIEnabled() && this.isInWater() && this.wantsToSwim()) {
			this.moveFlying(strafe, forward, 0.01F);
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.9D;
			this.motionY *= 0.9D;
			this.motionZ *= 0.9D;
		} else {
			super.moveEntityWithHeading(strafe, forward);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return !isHoldingTrident() && super.attackEntityAsMob(entity);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (DEBUG_DROWNED) {
			System.out.println("[DrownedDebug] attackEntityWithRangedAttack called for Drowned " + getEntityId() + " targeting " + target);
		}
		if (!isHoldingTrident()) {
			return;
		}

		EntityTrident trident = new EntityTrident(worldObj, this, ModItems.TRIDENT.newItemStack());
		double x = target.posX - posX;
		double y = target.boundingBox.minY + (double) target.height * 0.3333333333333333D - trident.posY;
		double z = target.posZ - posZ;
		double horizontalDistance = MathHelper.sqrt_double(x * x + z * z);
		trident.setThrowableHeading(x, y + horizontalDistance * 0.2D, z, 1.6F, 14 - worldObj.difficultySetting.getDifficultyId() * 4);
		playSound(Tags.MC_ASSET_VER + ":entity.drowned.shoot", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
		worldObj.spawnEntityInWorld(trident);
	}

	public boolean shouldAttack(EntityLivingBase target) {
		if (target == null) {
			return false;
		}
		return !(target instanceof EntityPlayer) || !worldObj.isDaytime() || target.isInWater();
	}

	@Override
	protected void dropFewItems(boolean recentlyHit, int lootingLevel) {
		super.dropFewItems(recentlyHit, lootingLevel);

		if (recentlyHit && rand.nextFloat() < GOLD_INGOT_DROP_CHANCE + (float) lootingLevel * GOLD_INGOT_LOOTING_BONUS) {
			dropItem(Items.gold_ingot, 1);
		}

		if (hasNautilusShell && ModItems.NAUTILUS_SHELL.isEnabled()) {
			entityDropItem(ModItems.NAUTILUS_SHELL.newItemStack(), 0.0F);
		}
	}

	@Override
	protected void dropRareDrop(int lootingLevel) {
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		nbt.setBoolean("HasNautilusShell", hasNautilusShell);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);
		hasNautilusShell = nbt.getBoolean("HasNautilusShell");
	}

	@Override
	protected String getLivingSound() {
		return Tags.MC_ASSET_VER + (isInWater() ? ":entity.drowned.ambient_water" : ":entity.drowned.ambient");
	}

	@Override
	protected String getHurtSound() {
		return Tags.MC_ASSET_VER + (isInWater() ? ":entity.drowned.hurt_water" : ":entity.drowned.hurt");
	}

	@Override
	protected String getDeathSound() {
		return Tags.MC_ASSET_VER + (isInWater() ? ":entity.drowned.death_water" : ":entity.drowned.death");
	}

	@Override
	protected void func_145780_a(int x, int y, int z, Block blockIn) {
		playSound(Tags.MC_ASSET_VER + ":entity.drowned.step", 0.15F, 1.0F);
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition target) {
		return ModEntityList.getEggFromEntity(this);
	}

	private boolean isHoldingTrident() {
		ItemStack stack = getHeldItem();
		return stack != null && ModItems.TRIDENT.isEnabled() && stack.getItem() == ModItems.TRIDENT.get();
	}

	private boolean isSpawnPositionInWater() {
		int x = MathHelper.floor_double(posX);
		int y = MathHelper.floor_double(boundingBox.minY);
		int z = MathHelper.floor_double(posZ);
		return worldObj.getBlock(x, y, z).getMaterial() == Material.water && worldObj.getBlock(x, y - 1, z).getMaterial() == Material.water && !worldObj.getBlock(x, y + 1, z).isNormalCube();
	}

	private boolean hasBiomeType(BiomeGenBase biome, Type type) {
		for (Type biomeType : BiomeDictionary.getTypesForBiome(biome)) {
			if (biomeType == type) {
				return true;
			}
		}
		return false;
	}

	private void swimToward(double x, double y, double z, double speed) {
		double xDiff = x - posX;
		double yDiff = y - posY;
		double zDiff = z - posZ;
		double distance = MathHelper.sqrt_double(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
		if (distance < 0.0001D) {
			return;
		}

		motionX += xDiff / distance * speed;
		motionY += yDiff / distance * speed;
		motionZ += zDiff / distance * speed;
	}

	private static class AITridentAttack extends EntityAIBase {
		private final EntityDrowned drowned;
		private EntityLivingBase attackTarget;
		private int attackCooldown = -1;
		private double speed;
		private int attackInterval;
		private float maxDistanceSq;
		private int seeTime;

		private AITridentAttack(EntityDrowned drowned, double speed, int attackInterval, float maxDistance) {
			this.drowned = drowned;
			this.speed = speed;
			this.attackInterval = attackInterval;
			this.maxDistanceSq = maxDistance * maxDistance;
			this.setMutexBits(3);
		}

		@Override
		public boolean shouldExecute() {
			EntityLivingBase target = drowned.getAttackTarget();
			if (target == null) {
				return false;
			}
			this.attackTarget = target;
			return drowned.isHoldingTrident() && drowned.shouldAttack(target);
		}

		@Override
		public boolean continueExecuting() {
			return shouldExecute() || (attackTarget != null && !drowned.getNavigator().noPath() && drowned.isHoldingTrident() && drowned.shouldAttack(attackTarget));
		}

		@Override
		public void resetTask() {
			this.attackTarget = null;
			this.seeTime = 0;
			this.attackCooldown = -1;
			drowned.setThrowingTrident(false);
		}

		@Override
		public void updateTask() {
			double distSq = drowned.getDistanceSq(attackTarget.posX, attackTarget.boundingBox.minY, attackTarget.posZ);
			boolean canSee = drowned.getEntitySenses().canSee(attackTarget);

			if (canSee) {
				++seeTime;
			} else {
				seeTime = 0;
			}

			if (distSq <= maxDistanceSq && seeTime >= 20) {
				drowned.getNavigator().clearPathEntity();
			} else {
				drowned.getNavigator().tryMoveToEntityLiving(attackTarget, speed);
			}

			drowned.getLookHelper().setLookPositionWithEntity(attackTarget, 30.0F, 30.0F);

			if (--attackCooldown == 0) {
				if (distSq > maxDistanceSq || !canSee) {
					attackCooldown = attackInterval;
					drowned.setThrowingTrident(false);
					return;
				}

				float factor = MathHelper.sqrt_double(distSq) / (float)Math.sqrt(maxDistanceSq);
				drowned.attackEntityWithRangedAttack(attackTarget, factor);
				attackCooldown = attackInterval;
				drowned.setThrowingTrident(false);
			} else if (attackCooldown < 0) {
				attackCooldown = attackInterval;
			}

			if (attackCooldown <= 24 && canSee && distSq <= maxDistanceSq) {
				drowned.setThrowingTrident(true);
			} else {
				drowned.setThrowingTrident(false);
			}
		}
	}

	private static class AIGoToWater extends EntityAIBase {
		private final EntityCreature creature;
		private final World world;
		private final double speed;
		private double targetX;
		private double targetY;
		private double targetZ;

		private AIGoToWater(EntityCreature creature, double speed) {
			this.creature = creature;
			this.world = creature.worldObj;
			this.speed = speed;
			setMutexBits(1);
		}

		@Override
		public boolean shouldExecute() {
			if (!world.isDaytime() || creature.isInWater()) {
				return false;
			}

			Vec3 water = findWaterTarget();
			if (water == null) {
				return false;
			}

			targetX = water.xCoord;
			targetY = water.yCoord;
			targetZ = water.zCoord;
			return true;
		}

		@Override
		public boolean continueExecuting() {
			return !creature.getNavigator().noPath() && !creature.isInWater();
		}

		@Override
		public void startExecuting() {
			creature.getNavigator().tryMoveToXYZ(targetX, targetY, targetZ, speed);
		}

		private Vec3 findWaterTarget() {
			Random random = creature.getRNG();
			int x = MathHelper.floor_double(creature.posX);
			int y = MathHelper.floor_double(creature.boundingBox.minY);
			int z = MathHelper.floor_double(creature.posZ);

			for (int i = 0; i < 10; ++i) {
				int targetX = x + random.nextInt(20) - 10;
				int targetY = y + 2 - random.nextInt(8);
				int targetZ = z + random.nextInt(20) - 10;
				if (world.getBlock(targetX, targetY, targetZ).getMaterial() == Material.water) {
					return Vec3.createVectorHelper(targetX, targetY, targetZ);
				}
			}

			return null;
		}
	}

	private static class AIDrownedMeleeAttack extends net.minecraft.entity.ai.EntityAIAttackOnCollide {
		private final EntityDrowned drowned;

		public AIDrownedMeleeAttack(EntityDrowned drowned, Class<? extends net.minecraft.entity.Entity> targetClass, double speed, boolean longMemory) {
			super(drowned, targetClass, speed, longMemory);
			this.drowned = drowned;
		}

		@Override
		public boolean shouldExecute() {
			return !drowned.isHoldingTrident() && drowned.shouldAttack(drowned.getAttackTarget()) && super.shouldExecute();
		}

		@Override
		public boolean continueExecuting() {
			return !drowned.isHoldingTrident() && drowned.shouldAttack(drowned.getAttackTarget()) && super.continueExecuting();
		}
	}

	private static class AITargetPlayer extends net.minecraft.entity.ai.EntityAINearestAttackableTarget {
		private final EntityDrowned drowned;

		public AITargetPlayer(EntityDrowned drowned, Class targetClass, int targetChance, boolean shouldCheckSight) {
			super(drowned, targetClass, targetChance, shouldCheckSight);
			this.drowned = drowned;
		}

		@Override
		protected boolean isSuitableTarget(EntityLivingBase target, boolean checkSight) {
			return super.isSuitableTarget(target, checkSight) && drowned.shouldAttack(target);
		}
	}

	private static class AIGoToBeach extends net.minecraft.entity.ai.EntityAIBase {
		private final EntityDrowned drowned;
		private final double speed;
		private double targetX, targetY, targetZ;

		public AIGoToBeach(EntityDrowned drowned, double speed) {
			this.drowned = drowned;
			this.speed = speed;
			this.setMutexBits(1);
		}

		@Override
		public boolean shouldExecute() {
			if (drowned.worldObj.isDaytime() || !drowned.isInWater() || drowned.posY < SEA_LEVEL - 3) {
				return false;
			}
			Vec3 target = findBeach();
			if (target == null) {
				return false;
			}
			this.targetX = target.xCoord;
			this.targetY = target.yCoord;
			this.targetZ = target.zCoord;
			return true;
		}

		@Override
		public boolean continueExecuting() {
			return !drowned.getNavigator().noPath();
		}

		@Override
		public void startExecuting() {
			// Source: 1.21.4 DrownedGoToBeachGoal.start()
			drowned.setSearchingForLand(false);
			drowned.getNavigator().tryMoveToXYZ(targetX, targetY, targetZ, speed);
		}

		private Vec3 findBeach() {
			Random random = drowned.getRNG();
			int x = net.minecraft.util.MathHelper.floor_double(drowned.posX);
			int y = net.minecraft.util.MathHelper.floor_double(drowned.boundingBox.minY);
			int z = net.minecraft.util.MathHelper.floor_double(drowned.posZ);

			for (int i = 0; i < 10; ++i) {
				int targetX = x + random.nextInt(20) - 10;
				int targetY = y + random.nextInt(6) - 3;
				int targetZ = z + random.nextInt(20) - 10;
				if (drowned.worldObj.getBlock(targetX, targetY, targetZ).isNormalCube() && drowned.worldObj.getBlock(targetX, targetY + 1, targetZ).getMaterial() == Material.air && drowned.worldObj.getBlock(targetX, targetY + 2, targetZ).getMaterial() == Material.air) {
					return Vec3.createVectorHelper(targetX, targetY + 1, targetZ);
				}
			}
			return null;
		}
	}

	private static class AISwimUp extends net.minecraft.entity.ai.EntityAIBase {
		private final EntityDrowned drowned;
		private final double speed;
		private final int targetY;
		private boolean obstructed;

		public AISwimUp(EntityDrowned drowned, double speed, int targetY) {
			this.drowned = drowned;
			this.speed = speed;
			this.targetY = targetY;
			this.setMutexBits(1);
		}

		@Override
		public boolean shouldExecute() {
			return !drowned.worldObj.isDaytime() && drowned.isInWater() && drowned.posY < targetY - 2;
		}

		@Override
		public boolean continueExecuting() {
			return shouldExecute() && !obtested();
		}

		private boolean obtested() {
			return obstructed;
		}

		@Override
		public void updateTask() {
			if (drowned.posY < targetY - 1 && (drowned.getNavigator().noPath() || isCloseToPathTarget())) {
				Vec3 vec = net.minecraft.entity.ai.RandomPositionGenerator.findRandomTargetBlockTowards(drowned, 4, 8, Vec3.createVectorHelper(drowned.posX, targetY - 1, drowned.posZ));
				if (vec == null) {
					obstructed = true;
					return;
				}
				drowned.getNavigator().tryMoveToXYZ(vec.xCoord, vec.yCoord, vec.zCoord, speed);
			}
		}

		@Override
		public void startExecuting() {
			// Source: 1.21.4 DrownedSwimUpGoal.start()
			drowned.setSearchingForLand(true);
			obstructed = false;
		}

		@Override
		public void resetTask() {
			// Source: 1.21.4 DrownedSwimUpGoal.stop()
			drowned.setSearchingForLand(false);
		}

		private boolean isCloseToPathTarget() {
			net.minecraft.pathfinding.PathEntity path = drowned.getNavigator().getPath();
			if (path != null) {
				net.minecraft.pathfinding.PathPoint point = path.getFinalPathPoint();
				if (point != null) {
					double sqDist = drowned.getDistanceSq(point.xCoord, point.yCoord, point.zCoord);
					if (sqDist < 4.0D) {
						return true;
					}
				}
			}
			return false;
		}
	}

	private static class DrownedWaterPathNavigator extends FlyingPathNavigator {
		public DrownedWaterPathNavigator(EntityLiving entity, World world) {
			super(entity, world);
		}

		@Override
		protected boolean canNavigate() {
			return this.theEntity.isInWater();
		}

		@Override
		public boolean isSafeToStandAt(int x, int y, int z, int sizeX, int sizeY, int sizeZ, Vec3 pos, double motionX, double motionZ) {
			return this.isPositionClear(x, y, z, sizeX, sizeY, sizeZ, pos, motionX, motionZ);
		}
	}

	private static class DrownedMoveHelper extends ExtendedEntityMoveHelper {
		private final EntityDrowned drowned;

		public DrownedMoveHelper(EntityDrowned drowned) {
			super(drowned);
			this.drowned = drowned;
		}

		@Override
		public void onUpdateMoveHelper() {
			EntityLivingBase target = drowned.getAttackTarget();
			if (drowned.wantsToSwim() && drowned.isInWater()) {
				if (target != null && target.posY > drowned.posY || drowned.searchingForLand) {
					drowned.motionY += 0.002D;
				}

				if (this.action != ExtendedEntityMoveHelper.Action.MOVE_TO || drowned.getNavigator().noPath()) {
					drowned.setAIMoveSpeed(0.0F);
					this.action = ExtendedEntityMoveHelper.Action.WAIT;
					return;
				}

				double d0 = this.posX - drowned.posX;
				double d1 = this.posY - drowned.posY;
				double d2 = this.posZ - drowned.posZ;
				double d3 = MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
				d1 /= d3;
				float f = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
				drowned.rotationYaw = this.limitAngle(drowned.rotationYaw, f, 90.0F);
				drowned.renderYawOffset = drowned.rotationYaw;
				float f1 = (float) (this.speed * drowned.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
				float f2 = drowned.getAIMoveSpeed() + 0.125F * (f1 - drowned.getAIMoveSpeed());
				drowned.setAIMoveSpeed(f2);
				drowned.motionX += (double) f2 * d0 * 0.005D;
				drowned.motionY += (double) f2 * d1 * 0.1D;
				drowned.motionZ += (double) f2 * d2 * 0.005D;
				this.action = ExtendedEntityMoveHelper.Action.WAIT;
			} else {
				if (!drowned.onGround) {
					drowned.motionY -= 0.008D;
				}
				super.onUpdateMoveHelper();
			}
		}
	}
}
