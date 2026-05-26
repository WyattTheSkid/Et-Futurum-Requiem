package ganymedes01.etfuturum.mixins.early.zombie;

import ganymedes01.etfuturum.Tags;
import ganymedes01.etfuturum.configuration.configs.ConfigEntities;
import ganymedes01.etfuturum.entities.EntityDrowned;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
		} else if (isInsideOfMaterial(Material.water)) {
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
		nbt.setInteger("InWaterTime", isInsideOfMaterial(Material.water) ? etfuturum$inWaterTime : -1);
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
	private boolean etfuturum$shouldConvertToDrowned() {
		return ConfigEntities.enableDrowned && ((Object) this).getClass() == EntityZombie.class;
	}

	@Unique
	private void etfuturum$startDrowning(int conversionTime) {
		etfuturum$drownedConversionTime = conversionTime;
		etfuturum$drowning = true;
	}

	@Unique
	private void etfuturum$convertToDrowned() {
		EntityZombie zombie = (EntityZombie) (Object) this;
		EntityDrowned drowned = new EntityDrowned(worldObj);

		drowned.copyLocationAndAnglesFrom(zombie);
		drowned.setCanPickUpLoot(zombie.canPickUpLoot());
		drowned.setChild(zombie.isChild());
		drowned.func_146070_a(zombie.func_146072_bX());

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

		worldObj.spawnEntityInWorld(drowned);
		setDead();
		worldObj.playSoundAtEntity(drowned, Tags.MC_ASSET_VER + ":entity.zombie.converted_to_drowned", 1.0F, 1.0F);
	}
}
