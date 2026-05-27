package ganymedes01.etfuturum.entities;

import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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

	private boolean hasNautilusShell;

	public EntityDrowned(World world) {
		super(world);
		stepHeight = 1.0F;
		getNavigator().setBreakDoors(false);
		tasks.addTask(1, new AIGoToWater(this, 1.0D));
		tasks.addTask(1, new AITridentAttack(this, 1.0D, 40, 10.0F));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(21, Byte.valueOf((byte) 0));
	}

	public boolean isThrowingTrident() {
		return dataWatcher.getWatchableObjectByte(21) == 1;
	}

	public void setThrowingTrident(boolean throwing) {
		dataWatcher.updateObject(21, Byte.valueOf((byte) (throwing ? 1 : 0)));
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
		super.func_146070_a(false);
	}

	@Override
	public boolean func_146072_bX() {
		return false;
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
		if (hasBiomeType(biome, Type.RIVER)) {
			if (rand.nextInt(15) != 0) {
				return false;
			}
		} else if (rand.nextInt(40) != 0 || boundingBox.minY >= SEA_LEVEL - 5) {
			return false;
		}

		return worldObj.checkNoEntityCollision(boundingBox);
	}

	@Override
	public void setAttackTarget(EntityLivingBase target) {
		super.setAttackTarget(shouldAttack(target) ? target : null);
	}

	@Override
	public void onLivingUpdate() {
		if (!worldObj.isRemote) {
			EntityLivingBase target = getAttackTarget();
			if (!shouldAttack(target)) {
				setAttackTarget(null);
			} else if (target != null && isInWater() && (target.isInWater() || !worldObj.isDaytime())) {
				swimToward(target.posX, target.boundingBox.minY + (double) target.height * 0.3333333333333333D, target.posZ, 0.01D);
			} else if (target == null && isInWater() && !worldObj.isDaytime() && posY < SEA_LEVEL - 2) {
				motionY += 0.005D;
			}

			if (DEBUG_DROWNED && ticksExisted % 40 == 0) {
				String mode = isHoldingTrident() ? "ranged" : "melee";
				double dist = target != null ? getDistanceToEntity(target) : -1.0D;
				boolean canSee = target != null && getEntitySenses().canSee(target);
				boolean isThrowing = isThrowingTrident();
				System.out.println(String.format(
					"[DrownedDebug] ID: %d, Held: %s, HasTrident: %b, Target: %s, Dist: %.2f, CanSee: %b, AI: %s, isThrowing: %b",
					getEntityId(), getHeldItem() != null ? getHeldItem().getDisplayName() : "none", isHoldingTrident(),
					target != null ? target.toString() : "null", dist, canSee, mode, isThrowing
				));
			}
		}

		super.onLivingUpdate();
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
			return true;
		}
		if (target == getAITarget()) {
			return true;
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
			return shouldExecute() || !drowned.getNavigator().noPath();
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
}
