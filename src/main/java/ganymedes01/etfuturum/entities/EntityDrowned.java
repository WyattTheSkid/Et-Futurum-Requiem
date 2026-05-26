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

	private boolean hasNautilusShell;

	public EntityDrowned(World world) {
		super(world);
		stepHeight = 1.0F;
		getNavigator().setBreakDoors(false);
		tasks.addTask(1, new AIGoToWater(this, 1.0D));
		tasks.addTask(1, new AITridentAttack(this, 1.0D, 40, 10.0F));
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
		}

		super.onLivingUpdate();
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return !isHoldingTrident() && super.attackEntityAsMob(entity);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
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
		return target == null || !(target instanceof EntityPlayer) || !worldObj.isDaytime() || target.isInWater();
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

	private static class AITridentAttack extends EntityAIArrowAttack {
		private final EntityDrowned drowned;

		private AITridentAttack(EntityDrowned drowned, double speed, int attackInterval, float maxDistance) {
			super(drowned, speed, attackInterval, maxDistance);
			this.drowned = drowned;
		}

		@Override
		public boolean shouldExecute() {
			return super.shouldExecute() && drowned.isHoldingTrident() && drowned.shouldAttack(drowned.getAttackTarget());
		}

		@Override
		public boolean continueExecuting() {
			return super.continueExecuting() && drowned.isHoldingTrident() && drowned.shouldAttack(drowned.getAttackTarget());
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
