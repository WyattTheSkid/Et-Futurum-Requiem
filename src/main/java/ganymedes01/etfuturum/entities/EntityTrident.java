package ganymedes01.etfuturum.entities;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import ganymedes01.etfuturum.ModEnchantments;
import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.Tags;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.io.IOException;
import java.util.List;

public class EntityTrident extends EntityArrow implements IEntityAdditionalSpawnData {

	private static final int LOYALTY_WATCHER_ID = 17;
	private static final float THROW_VELOCITY = 2.5F;
	private static final float THROW_INACCURACY = 1.0F;
	private static final float BASE_DAMAGE = 8.0F;
	private static final int DESPAWN_TICKS = 1200;

	private int stuckX = -1;
	private int stuckY = -1;
	private int stuckZ = -1;
	private Block stuckBlock;
	private int stuckMeta;
	private int ticksInAir;
	private ItemStack tridentStack;
	private boolean dealtDamage;
	private String throwerName;
	public int returningTicks;

	public EntityTrident(World world) {
		super(world);
		initTrident();
	}

	public EntityTrident(World world, double x, double y, double z) {
		super(world, x, y, z);
		initTrident();
	}

	public EntityTrident(World world, EntityLivingBase shooter, ItemStack stack) {
		super(world);
		shootingEntity = shooter;
		initTrident();
		setTridentStack(stack);

		if (shooter instanceof EntityPlayer) {
			canBePickedUp = 1;
			throwerName = ((EntityPlayer) shooter).getCommandSenderName();
		}

		setLocationAndAngles(shooter.posX, shooter.posY + (double) shooter.getEyeHeight(), shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);
		posX -= (double) (MathHelper.cos(rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
		posY -= 0.10000000149011612D;
		posZ -= (double) (MathHelper.sin(rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
		setPosition(posX, posY, posZ);
		yOffset = 0.0F;
		motionX = (double) (-MathHelper.sin(rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float) Math.PI));
		motionZ = (double) (MathHelper.cos(rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float) Math.PI));
		motionY = (double) (-MathHelper.sin(rotationPitch / 180.0F * (float) Math.PI));
		setThrowableHeading(motionX, motionY, motionZ, THROW_VELOCITY, THROW_INACCURACY);
	}

	private void initTrident() {
		renderDistanceWeight = 10.0D;
		setSize(0.5F, 0.5F);
		yOffset = 0.0F;
		setTridentStack(null);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(LOYALTY_WATCHER_ID, Byte.valueOf((byte) 0));
	}

	public ItemStack getTridentStack() {
		return getStoredTridentStack().copy();
	}

	public void setTridentStack(ItemStack stack) {
		tridentStack = stack == null ? ModItems.TRIDENT.newItemStack() : stack.copy();
		tridentStack.stackSize = 1;
		if (dataWatcher != null) {
			dataWatcher.updateObject(LOYALTY_WATCHER_ID, Byte.valueOf((byte) getLoyaltyLevel(tridentStack)));
		}
	}

	private ItemStack getStoredTridentStack() {
		if (tridentStack == null || tridentStack.getItem() == null) {
			tridentStack = ModItems.TRIDENT.newItemStack();
		}

		tridentStack.stackSize = 1;
		return tridentStack;
	}

	private int getLoyaltyLevel(ItemStack stack) {
		return ModEnchantments.getLoyaltyModifier(stack);
	}

	private int getSyncedLoyaltyLevel() {
		return dataWatcher.getWatchableObjectByte(LOYALTY_WATCHER_ID) & 255;
	}

	@Override
	public void onUpdate() {
		onEntityUpdate();

		if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F) {
			float horizontalMotion = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
			prevRotationYaw = rotationYaw = (float) (Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
			prevRotationPitch = rotationPitch = (float) (Math.atan2(motionY, (double) horizontalMotion) * 180.0D / Math.PI);
		}

		Block block = getStuckBlock();
		if (!noClip && !inGround && block.getMaterial() != Material.air) {
			block.setBlockBoundsBasedOnState(worldObj, stuckX, stuckY, stuckZ);
			AxisAlignedBB blockBounds = block.getCollisionBoundingBoxFromPool(worldObj, stuckX, stuckY, stuckZ);
			if (blockBounds != null && blockBounds.isVecInside(Vec3.createVectorHelper(posX, posY, posZ))) {
				inGround = true;
			}
		}

		if (arrowShake > 0) {
			--arrowShake;
		}

		if (ticksInGround > 4) {
			dealtDamage = true;
		}

		if (updateLoyaltyReturn()) {
			return;
		}

		if (inGround) {
			updateInGround(block);
		} else {
			updateInAir();
		}
	}

	private boolean updateLoyaltyReturn() {
		int loyalty = getSyncedLoyaltyLevel();
		if (loyalty <= 0 || !dealtDamage && !inGround) {
			return false;
		}

		Entity thrower = getThrowerEntity();
		if (thrower == null || !thrower.isEntityAlive()) {
			if (!worldObj.isRemote && canBePickedUp == 1) {
				entityDropItem(getTridentStack(), 0.1F);
			}
			setDead();
			return true;
		}

		inGround = false;
		noClip = true;
		Vec3 returnVector = Vec3.createVectorHelper(thrower.posX - posX, getReturnTargetY(thrower) - posY, thrower.posZ - posZ);
		posY += returnVector.yCoord * 0.015D * (double) loyalty;

		if (returnVector.lengthVector() > 0.0D) {
			returnVector = returnVector.normalize();
			double acceleration = 0.05D * (double) loyalty;
			motionX += returnVector.xCoord * acceleration - motionX * 0.05D;
			motionY += returnVector.yCoord * acceleration - motionY * 0.05D;
			motionZ += returnVector.zCoord * acceleration - motionZ * 0.05D;
		}

		if (returningTicks == 0) {
			playSound(Tags.MC_ASSET_VER + ":item.trident.return", 10.0F, 1.0F);
		}

		++returningTicks;
		moveThroughAir();
		return true;
	}

	private Entity getThrowerEntity() {
		if (shootingEntity == null && throwerName != null) {
			shootingEntity = worldObj.getPlayerEntityByName(throwerName);
		}

		return shootingEntity;
	}

	private double getReturnTargetY(Entity entity) {
		return entity instanceof EntityLivingBase ? entity.posY + (double) ((EntityLivingBase) entity).getEyeHeight() : entity.posY + (double) entity.height * 0.5D;
	}

	private Block getStuckBlock() {
		return stuckY < 0 ? Block.getBlockById(0) : worldObj.getBlock(stuckX, stuckY, stuckZ);
	}

	private void updateInGround(Block block) {
		int meta = worldObj.getBlockMetadata(stuckX, stuckY, stuckZ);
		if (block == stuckBlock && meta == stuckMeta) {
			++ticksInGround;
			if (ticksInGround > 4) {
				dealtDamage = true;
			}

			if (ticksInGround >= DESPAWN_TICKS && getSyncedLoyaltyLevel() <= 0) {
				setDead();
			}
		} else {
			inGround = false;
			motionX *= (double) (rand.nextFloat() * 0.2F);
			motionY *= (double) (rand.nextFloat() * 0.2F);
			motionZ *= (double) (rand.nextFloat() * 0.2F);
			ticksInGround = 0;
			ticksInAir = 0;
		}
	}

	private void updateInAir() {
		++ticksInAir;
		Vec3 start = Vec3.createVectorHelper(posX, posY, posZ);
		Vec3 end = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
		MovingObjectPosition hit = worldObj.func_147447_a(start, end, false, true, false);
		start = Vec3.createVectorHelper(posX, posY, posZ);
		end = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);

		if (hit != null) {
			end = Vec3.createVectorHelper(hit.hitVec.xCoord, hit.hitVec.yCoord, hit.hitVec.zCoord);
		}

		Entity entityHit = findEntityOnPath(start, end);
		if (entityHit != null) {
			hit = new MovingObjectPosition(entityHit);
		}

		if (hit != null && hit.entityHit instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) hit.entityHit;
			if (player.capabilities.disableDamage || shootingEntity instanceof EntityPlayer && !((EntityPlayer) shootingEntity).canAttackPlayer(player)) {
				hit = null;
			}
		}

		if (hit != null) {
			if (hit.entityHit != null) {
				onHitEntity(hit.entityHit);
			} else {
				onHitBlock(hit);
			}
		}

		moveThroughAir();
	}

	private Entity findEntityOnPath(Vec3 start, Vec3 end) {
		if (dealtDamage) {
			return null;
		}

		Entity closest = null;
		double closestDistance = 0.0D;
		List entities = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));

		for (Object object : entities) {
			Entity entity = (Entity) object;
			if (entity.canBeCollidedWith() && (entity != shootingEntity || ticksInAir >= 5)) {
				AxisAlignedBB bounds = entity.boundingBox.expand(0.3D, 0.3D, 0.3D);
				MovingObjectPosition intercept = bounds.calculateIntercept(start, end);
				if (intercept != null) {
					double distance = start.distanceTo(intercept.hitVec);
					if (distance < closestDistance || closestDistance == 0.0D) {
						closest = entity;
						closestDistance = distance;
					}
				}
			}
		}

		return closest;
	}

	private void onHitEntity(Entity target) {
		dealtDamage = true;
		Entity source = shootingEntity == null ? this : shootingEntity;
		DamageSource damageSource = new EntityDamageSourceIndirect("trident", this, source).setProjectile();
		float damage = BASE_DAMAGE;
		if (target instanceof EntityLivingBase) {
			damage += ModEnchantments.getImpalingDamage(getStoredTridentStack(), (EntityLivingBase) target);
		}

		boolean damaged = target.attackEntityFrom(damageSource, damage);

		if (damaged && target instanceof EntityLivingBase) {
			EntityLivingBase livingTarget = (EntityLivingBase) target;
			if (shootingEntity instanceof EntityLivingBase) {
				EnchantmentHelper.func_151384_a(livingTarget, shootingEntity);
				EnchantmentHelper.func_151385_b((EntityLivingBase) shootingEntity, livingTarget);
			}

			if (shootingEntity != null && target != shootingEntity && target instanceof EntityPlayer && shootingEntity instanceof EntityPlayerMP) {
				((EntityPlayerMP) shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
			}
		}

		motionX *= (double) -0.01F;
		motionY *= (double) -0.1F;
		motionZ *= (double) -0.01F;
		if (tryChanneling(target)) {
			playSound(Tags.MC_ASSET_VER + ":item.trident.thunder", 5.0F, 1.0F);
		} else {
			playSound(Tags.MC_ASSET_VER + ":item.trident.hit", 1.0F, 1.0F);
		}
	}

	private boolean tryChanneling(Entity target) {
		if (worldObj.isRemote || !worldObj.isThundering() || !ModEnchantments.hasChanneling(getStoredTridentStack())) {
			return false;
		}

		int x = MathHelper.floor_double(target.posX);
		int y = MathHelper.floor_double(target.posY);
		int z = MathHelper.floor_double(target.posZ);
		if (!worldObj.canBlockSeeTheSky(x, y, z)) {
			return false;
		}

		worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, (double) x + 0.5D, (double) y, (double) z + 0.5D));
		return true;
	}

	private void onHitBlock(MovingObjectPosition hit) {
		stuckX = hit.blockX;
		stuckY = hit.blockY;
		stuckZ = hit.blockZ;
		stuckBlock = worldObj.getBlock(stuckX, stuckY, stuckZ);
		stuckMeta = worldObj.getBlockMetadata(stuckX, stuckY, stuckZ);
		motionX = (double) ((float) (hit.hitVec.xCoord - posX));
		motionY = (double) ((float) (hit.hitVec.yCoord - posY));
		motionZ = (double) ((float) (hit.hitVec.zCoord - posZ));
		float motionLength = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
		posX -= motionX / (double) motionLength * 0.05000000074505806D;
		posY -= motionY / (double) motionLength * 0.05000000074505806D;
		posZ -= motionZ / (double) motionLength * 0.05000000074505806D;
		playSound(Tags.MC_ASSET_VER + ":item.trident.hit_ground", 1.0F, 1.0F);
		inGround = true;
		arrowShake = 7;

		if (stuckBlock.getMaterial() != Material.air) {
			stuckBlock.onEntityCollidedWithBlock(worldObj, stuckX, stuckY, stuckZ, this);
		}
	}

	private void moveThroughAir() {
		posX += motionX;
		posY += motionY;
		posZ += motionZ;
		float horizontalMotion = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
		rotationYaw = noClip ? (float) (Math.atan2(-motionX, -motionZ) * 180.0D / Math.PI) : (float) (Math.atan2(motionX, motionZ) * 180.0D / Math.PI);

		for (rotationPitch = (float) (Math.atan2(motionY, (double) horizontalMotion) * 180.0D / Math.PI); rotationPitch - prevRotationPitch < -180.0F; prevRotationPitch -= 360.0F) {
		}

		while (rotationPitch - prevRotationPitch >= 180.0F) {
			prevRotationPitch += 360.0F;
		}

		while (rotationYaw - prevRotationYaw < -180.0F) {
			prevRotationYaw -= 360.0F;
		}

		while (rotationYaw - prevRotationYaw >= 180.0F) {
			prevRotationYaw += 360.0F;
		}

		rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
		rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
		float drag = 0.99F;

		if (isInWater()) {
			for (int i = 0; i < 4; ++i) {
				worldObj.spawnParticle("bubble", posX - motionX * 0.25D, posY - motionY * 0.25D, posZ - motionZ * 0.25D, motionX, motionY, motionZ);
			}
		}

		if (isWet()) {
			extinguish();
		}

		motionX *= (double) drag;
		motionY *= (double) drag;
		motionZ *= (double) drag;
		if (!noClip) {
			motionY -= 0.05000000074505806D;
		}
		setPosition(posX, posY, posZ);
		if (!noClip) {
			func_145775_I();
		}
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		if (!worldObj.isRemote && (inGround || noClip) && arrowShake <= 0 && canPlayerPickUp(player)) {
			boolean returningToOwner = noClip && isReturningToOwner(player);
			boolean canPickUp = canBePickedUp == 1 || canBePickedUp == 2 && player.capabilities.isCreativeMode || returningToOwner;
			ItemStack stack = getTridentStack();

			if (canBePickedUp == 1 && !player.inventory.addItemStackToInventory(stack)) {
				canPickUp = false;
			}

			if (canPickUp) {
				playSound("random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				player.onItemPickup(this, 1);
				setDead();
			}
		}
	}

	private boolean canPlayerPickUp(EntityPlayer player) {
		if (shootingEntity instanceof EntityPlayer && shootingEntity != player) {
			return false;
		}

		return throwerName == null || throwerName.equals(player.getCommandSenderName());
	}

	private boolean isReturningToOwner(EntityPlayer player) {
		Entity thrower = getThrowerEntity();
		return thrower instanceof EntityPlayer && ((EntityPlayer) thrower).getCommandSenderName().equals(player.getCommandSenderName());
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setShort("xTile", (short) stuckX);
		compound.setShort("yTile", (short) stuckY);
		compound.setShort("zTile", (short) stuckZ);
		compound.setShort("life", (short) ticksInGround);
		compound.setByte("inTile", (byte) (stuckBlock == null ? 0 : Block.getIdFromBlock(stuckBlock)));
		compound.setByte("inData", (byte) stuckMeta);
		compound.setByte("shake", (byte) arrowShake);
		compound.setByte("inGround", (byte) (inGround ? 1 : 0));
		compound.setByte("pickup", (byte) canBePickedUp);
		compound.setBoolean("DealtDamage", dealtDamage);
		compound.setTag("Trident", getStoredTridentStack().writeToNBT(new NBTTagCompound()));
		if (throwerName != null) {
			compound.setString("OwnerName", throwerName);
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		stuckX = compound.getShort("xTile");
		stuckY = compound.getShort("yTile");
		stuckZ = compound.getShort("zTile");
		ticksInGround = compound.getShort("life");
		stuckBlock = Block.getBlockById(compound.getByte("inTile") & 255);
		stuckMeta = compound.getByte("inData") & 255;
		arrowShake = compound.getByte("shake") & 255;
		inGround = compound.getByte("inGround") == 1;
		canBePickedUp = compound.hasKey("pickup", 99) ? compound.getByte("pickup") : canBePickedUp;
		dealtDamage = compound.getBoolean("DealtDamage");

		if (compound.hasKey("Trident", 10)) {
			setTridentStack(ItemStack.loadItemStackFromNBT(compound.getCompoundTag("Trident")));
		} else {
			setTridentStack(null);
		}

		if (compound.hasKey("OwnerName")) {
			throwerName = compound.getString("OwnerName");
			shootingEntity = worldObj.getPlayerEntityByName(throwerName);
		}
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeInt(shootingEntity == null ? -1 : shootingEntity.getEntityId());
		buffer.writeDouble(motionX);
		buffer.writeDouble(motionY);
		buffer.writeDouble(motionZ);
		buffer.writeFloat(rotationYaw);
		buffer.writeFloat(rotationPitch);

		PacketBuffer packetBuffer = new PacketBuffer(buffer);
		try {
			packetBuffer.writeItemStackToBuffer(getStoredTridentStack());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void readSpawnData(ByteBuf buffer) {
		int shooterId = buffer.readInt();
		shootingEntity = shooterId >= 0 ? worldObj.getEntityByID(shooterId) : null;
		motionX = buffer.readDouble();
		motionY = buffer.readDouble();
		motionZ = buffer.readDouble();
		rotationYaw = buffer.readFloat();
		rotationPitch = buffer.readFloat();
		prevRotationYaw = rotationYaw;
		prevRotationPitch = rotationPitch;

		PacketBuffer packetBuffer = new PacketBuffer(buffer);
		try {
			setTridentStack(packetBuffer.readItemStackFromBuffer());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
