package ganymedes01.etfuturum.mixins.early.zombie;

import ganymedes01.etfuturum.Tags;
import ganymedes01.etfuturum.configuration.configs.ConfigEntities;
import ganymedes01.etfuturum.entities.EntityDrowned;
import ganymedes01.etfuturum.entities.EntityHusk;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityZombie.class)
public class MixinEntityZombieDrownedConversion extends EntityMob {

	@Unique
	private static final int etfuturum$DROWNED_CONVERSION_START_TIME = 600;
	@Unique
	private static final int etfuturum$DROWNED_CONVERSION_TIME = 300;

	@Unique
	private int etfuturum$inWaterTime;
	@Unique
	private int etfuturum$drownedConversionTime = -1;
	@Unique
	private boolean etfuturum$drowning;

	public MixinEntityZombieDrownedConversion(World world) {
		super(world);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return etfuturum$shouldConvertToDrowned() || super.canBreatheUnderwater();
	}

	@Inject(method = "onUpdate", at = @At("HEAD"), cancellable = true)
	private void etfuturum$updateDrownedConversion(CallbackInfo ci) {
		if (worldObj.isRemote || !etfuturum$shouldConvertToDrowned() || isDead) {
			return;
		}

		if (etfuturum$drowning) {
			--etfuturum$drownedConversionTime;
			if (etfuturum$drownedConversionTime < 0) {
				etfuturum$convertToDrowned();
				ci.cancel();
			}
		} else if (etfuturum$isEyeInWater()) {
			++etfuturum$inWaterTime;
			if (etfuturum$inWaterTime >= etfuturum$DROWNED_CONVERSION_START_TIME) {
				etfuturum$startDrowning(etfuturum$DROWNED_CONVERSION_TIME);
			}
		} else {
			etfuturum$inWaterTime = -1;
		}
	}

	@Inject(method = "writeEntityToNBT", at = @At("RETURN"))
	private void etfuturum$writeDrownedConversion(NBTTagCompound nbt, CallbackInfo ci) {
		nbt.setInteger("InWaterTime", etfuturum$isEyeInWater() ? etfuturum$inWaterTime : -1);
		nbt.setInteger("DrownedConversionTime", etfuturum$drowning ? etfuturum$drownedConversionTime : -1);
	}

	@Inject(method = "readEntityFromNBT", at = @At("RETURN"))
	private void etfuturum$readDrownedConversion(NBTTagCompound nbt, CallbackInfo ci) {
		etfuturum$inWaterTime = nbt.getInteger("InWaterTime");
		if (etfuturum$shouldConvertToDrowned() && nbt.hasKey("DrownedConversionTime", 99) && nbt.getInteger("DrownedConversionTime") > -1) {
			etfuturum$startDrowning(nbt.getInteger("DrownedConversionTime"));
		}
	}

	@Unique
	private boolean etfuturum$isEyeInWater() {
		return worldObj.getBlock(MathHelper.floor_double(posX), MathHelper.floor_double(posY + getEyeHeight()), MathHelper.floor_double(posZ)).getMaterial() == Material.water;
	}

	@Unique
	private boolean etfuturum$shouldConvertToDrowned() {
		Class<?> clazz = ((Object) this).getClass();
		return ConfigEntities.enableDrowned && (clazz == EntityZombie.class || clazz == EntityHusk.class);
	}

	@Unique
	private void etfuturum$startDrowning(int conversionTime) {
		etfuturum$drownedConversionTime = conversionTime;
		etfuturum$drowning = true;
	}

	@Unique
	private void etfuturum$convertToDrowned() {
		EntityZombie zombie = (EntityZombie) (Object) this;
		
		if (zombie instanceof EntityHusk) {
			EntityZombie newZombie = new EntityZombie(worldObj);
			newZombie.copyLocationAndAnglesFrom(zombie);
			newZombie.setCanPickUpLoot(zombie.canPickUpLoot());
			newZombie.setChild(zombie.isChild());
			newZombie.func_146070_a(zombie.func_146072_bX());
			newZombie.setHealth(zombie.getHealth());
			newZombie.setAttackTarget(zombie.getAttackTarget());

			for (int slot = 0; slot < 5; ++slot) {
				ItemStack stack = zombie.getEquipmentInSlot(slot);
				if (stack != null) {
					newZombie.setCurrentItemOrArmor(slot, stack);
					newZombie.setEquipmentDropChance(slot, equipmentDropChances[slot]);
				}
			}

			if (hasCustomNameTag()) {
				newZombie.setCustomNameTag(getCustomNameTag());
				newZombie.setAlwaysRenderNameTag(getAlwaysRenderNameTag());
			}

			if (isNoDespawnRequired()) {
				newZombie.func_110163_bv();
			}

			newZombie.clearActivePotions();
			for (Object obj : zombie.getActivePotionEffects()) {
				PotionEffect effect = (PotionEffect) obj;
				newZombie.addPotionEffect(new PotionEffect(effect.getPotionID(), effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient()));
			}

			worldObj.spawnEntityInWorld(newZombie);
			setDead();
			worldObj.playSoundAtEntity(newZombie, Tags.MC_ASSET_VER + ":entity.husk.converted_to_zombie", 1.0F, 1.0F);
		} else {
			EntityDrowned drowned = new EntityDrowned(worldObj);
			drowned.copyLocationAndAnglesFrom(zombie);
			drowned.setCanPickUpLoot(zombie.canPickUpLoot());
			drowned.setChild(zombie.isChild());
			drowned.func_146070_a(zombie.func_146072_bX());
			drowned.setHealth(zombie.getHealth());
			drowned.setAttackTarget(zombie.getAttackTarget());

			for (int slot = 0; slot < 5; ++slot) {
				ItemStack stack = zombie.getEquipmentInSlot(slot);
				if (stack != null) {
					drowned.setCurrentItemOrArmor(slot, stack);
					drowned.setEquipmentDropChance(slot, equipmentDropChances[slot]);
				}
			}

			if (hasCustomNameTag()) {
				drowned.setCustomNameTag(getCustomNameTag());
				drowned.setAlwaysRenderNameTag(getAlwaysRenderNameTag());
			}

			if (isNoDespawnRequired()) {
				drowned.func_110163_bv();
			}

			drowned.clearActivePotions();
			for (Object obj : zombie.getActivePotionEffects()) {
				PotionEffect effect = (PotionEffect) obj;
				drowned.addPotionEffect(new PotionEffect(effect.getPotionID(), effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient()));
			}

			worldObj.spawnEntityInWorld(drowned);
			setDead();
			worldObj.playSoundAtEntity(drowned, Tags.MC_ASSET_VER + ":entity.zombie.converted_to_drowned", 1.0F, 1.0F);
		}
	}
}
