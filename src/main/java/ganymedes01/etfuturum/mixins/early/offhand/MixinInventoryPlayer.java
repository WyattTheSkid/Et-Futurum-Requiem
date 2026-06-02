package ganymedes01.etfuturum.mixins.early.offhand;

import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InventoryPlayer.class)
public abstract class MixinInventoryPlayer {
	@Shadow
	public EntityPlayer player;

	@Inject(method = "getCurrentItem", at = @At("HEAD"), cancellable = true)
	private void etfu$getCurrentOffhandItem(CallbackInfoReturnable<ItemStack> cir) {
		InventoryPlayer self = (InventoryPlayer) (Object) this;
		if (self.currentItem == OffhandInventory.OFFHAND_INVENTORY_INDEX) {
			cir.setReturnValue(OffhandInventory.getOffhandStack(player));
		}
	}

	@Inject(method = "getStackInSlot", at = @At("HEAD"), cancellable = true)
	private void etfu$getOffhandStackInSlot(int index, CallbackInfoReturnable<ItemStack> cir) {
		if (index == OffhandInventory.OFFHAND_INVENTORY_INDEX) {
			cir.setReturnValue(OffhandInventory.getOffhandStack(player));
		}
	}

	@Inject(method = "setInventorySlotContents", at = @At("HEAD"), cancellable = true)
	private void etfu$setOffhandStackInSlot(int index, ItemStack stack, CallbackInfo ci) {
		if (index == OffhandInventory.OFFHAND_INVENTORY_INDEX) {
			OffhandInventory.setOffhandStack(player, stack);
			ci.cancel();
		}
	}

	@Inject(method = "decrStackSize", at = @At("HEAD"), cancellable = true)
	private void etfu$decrOffhandStack(int index, int amount, CallbackInfoReturnable<ItemStack> cir) {
		if (index == OffhandInventory.OFFHAND_INVENTORY_INDEX) {
			cir.setReturnValue(OffhandInventory.decrOffhandStack(player, amount));
		}
	}

	@Inject(method = "getStackInSlotOnClosing", at = @At("HEAD"), cancellable = true)
	private void etfu$getOffhandStackOnClosing(int index, CallbackInfoReturnable<ItemStack> cir) {
		if (index == OffhandInventory.OFFHAND_INVENTORY_INDEX) {
			cir.setReturnValue(OffhandInventory.getOffhandStack(player));
		}
	}

	@Inject(method = "dropAllItems", at = @At("TAIL"))
	private void etfu$dropOffhand(CallbackInfo ci) {
		OffhandInventory.dropOffhand(player);
	}

	@Inject(method = "copyInventory", at = @At("TAIL"))
	private void etfu$copyOffhand(InventoryPlayer other, CallbackInfo ci) {
		OffhandInventory.setOffhandStack(player, OffhandInventory.copyStack(OffhandInventory.getOffhandStack(other)));
	}

	@Inject(method = "hasItemStack", at = @At("HEAD"), cancellable = true)
	private void etfu$hasOffhandItemStack(ItemStack target, CallbackInfoReturnable<Boolean> cir) {
		ItemStack offhand = OffhandInventory.getOffhandStack(player);
		if (target != null && offhand != null && offhand.isItemEqual(target)) {
			cir.setReturnValue(true);
		}
	}

	@Inject(method = "clearInventory", at = @At("RETURN"), cancellable = true)
	private void etfu$clearOffhand(Item item, int meta, CallbackInfoReturnable<Integer> cir) {
		ItemStack offhand = OffhandInventory.getOffhandStack(player);
		if (offhand != null && (item == null || offhand.getItem() == item) && (meta <= -1 || offhand.getItemDamage() == meta)) {
			int cleared = offhand.stackSize;
			OffhandInventory.setOffhandStack(player, null);
			cir.setReturnValue(cir.getReturnValue() + cleared);
		}
	}
}
