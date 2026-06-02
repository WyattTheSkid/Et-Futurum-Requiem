package ganymedes01.etfuturum.mixins.early.offhand;

import ganymedes01.etfuturum.network.OffhandNetwork;
import ganymedes01.etfuturum.offhand.Hand;
import ganymedes01.etfuturum.offhand.IOffhandEntity;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public abstract class MixinEntityPlayer implements IOffhandEntity {
	@Shadow
	private ItemStack itemInUse;

	@Shadow
	protected abstract void updateItemUse(ItemStack stack, int count);

	@Unique
	private boolean etfu$offhandSwingInProgress;
	@Unique
	private int etfu$offhandSwingProgressInt;
	@Unique
	private float etfu$offhandSwingProgress;
	@Unique
	private float etfu$prevOffhandSwingProgress;
	@Unique
	private Hand etfu$activeHand = Hand.MAIN_HAND;

	@Override
	public Hand etfu$getActiveHand() {
		return etfu$activeHand;
	}

	@Override
	public void etfu$setActiveHand(Hand hand) {
		etfu$activeHand = hand == null ? Hand.MAIN_HAND : hand;
	}

	@Inject(method = "onItemUseFinish", at = @At("HEAD"), cancellable = true)
	private void etfu$finishOffhandUse(CallbackInfo ci) {
		if (etfu$activeHand != Hand.OFF_HAND) return;

		EntityPlayer self = (EntityPlayer) (Object) this;
		if (itemInUse != null) {
			this.updateItemUse(itemInUse, 16);
			int stackSizeBefore = itemInUse.stackSize;
			ItemStack result = itemInUse.onFoodEaten(self.worldObj, self);
			if (result != itemInUse || result != null && result.stackSize != stackSizeBefore) {
				OffhandInventory.setOffhandStack(self, result);
			} else {
				OffhandInventory.setOffhandStack(self, itemInUse);
			}
			self.clearItemInUse();
		}
		ci.cancel();
	}

	@Inject(method = "clearItemInUse", at = @At("HEAD"))
	private void etfu$syncOffhandWhenClearingUse(CallbackInfo ci) {
		if (etfu$activeHand == Hand.OFF_HAND) {
			EntityPlayer self = (EntityPlayer) (Object) this;
			if (self instanceof EntityPlayerMP player) {
				player.inventoryContainer.detectAndSendChanges();
				OffhandNetwork.syncOffhandChanged(player);
			}
		}
		etfu$activeHand = Hand.MAIN_HAND;
	}

	@Inject(method = "stopUsingItem", at = @At("TAIL"))
	private void etfu$stopOffhandUsingItem(CallbackInfo ci) {
		etfu$activeHand = Hand.MAIN_HAND;
	}

	@Redirect(method = "onUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/InventoryPlayer;getCurrentItem()Lnet/minecraft/item/ItemStack;"))
	private ItemStack etfu$getCurrentItemForActiveHand(InventoryPlayer inventory) {
		if (etfu$activeHand == Hand.OFF_HAND) {
			return OffhandInventory.getOffhandStack(inventory);
		}
		return inventory.getCurrentItem();
	}

	@Inject(method = "onUpdate", at = @At("TAIL"))
	private void etfu$updateOffhandSwing(CallbackInfo ci) {
		EntityPlayer self = (EntityPlayer) (Object) this;
		int armSwingAnimationEnd = self.isPotionActive(Potion.digSpeed)
				? 6 - (1 + self.getActivePotionEffect(Potion.digSpeed).getAmplifier())
				: self.isPotionActive(Potion.digSlowdown) ? 6 + (1 + self.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6;

		etfu$prevOffhandSwingProgress = etfu$offhandSwingProgress;
		if (etfu$offhandSwingInProgress) {
			++etfu$offhandSwingProgressInt;
			if (etfu$offhandSwingProgressInt >= armSwingAnimationEnd) {
				etfu$offhandSwingProgressInt = 0;
				etfu$offhandSwingInProgress = false;
			}
		} else {
			etfu$offhandSwingProgressInt = 0;
		}
		etfu$offhandSwingProgress = (float) etfu$offhandSwingProgressInt / armSwingAnimationEnd;
	}

	@Override
	public void etfu$swingOffhand() {
		EntityPlayer self = (EntityPlayer) (Object) this;
		int armSwingAnimationEnd = self.isPotionActive(Potion.digSpeed)
				? 6 - (1 + self.getActivePotionEffect(Potion.digSpeed).getAmplifier())
				: self.isPotionActive(Potion.digSlowdown) ? 6 + (1 + self.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6;

		if (!etfu$offhandSwingInProgress || etfu$offhandSwingProgressInt >= armSwingAnimationEnd / 2 || etfu$offhandSwingProgressInt < 0) {
			etfu$offhandSwingProgressInt = -1;
			etfu$offhandSwingInProgress = true;
		}
	}

	@Override
	public float etfu$getOffhandSwingProgress(float partialTicks) {
		float progress = etfu$offhandSwingProgress - etfu$prevOffhandSwingProgress;
		if (progress < 0.0F) {
			++progress;
		}
		return etfu$prevOffhandSwingProgress + progress * partialTicks;
	}
}
