package ganymedes01.etfuturum.mixins.early.offhand;

import ganymedes01.etfuturum.offhand.OffhandInventory;
import ganymedes01.etfuturum.offhand.OffhandLayout;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ContainerPlayer.class)
public abstract class MixinContainerPlayer extends Container {
	@Inject(method = "<init>", at = @At("RETURN"))
	private void etfu$addOffhandSlot(InventoryPlayer inventory, boolean localWorld, EntityPlayer player, CallbackInfo ci) {
		positionSlot(0, OffhandLayout.SURVIVAL_CRAFT_RESULT_X, OffhandLayout.SURVIVAL_CRAFT_RESULT_Y);
		for (int row = 0; row < 2; ++row) {
			for (int column = 0; column < 2; ++column) {
				positionSlot(1 + column + row * 2, OffhandLayout.SURVIVAL_CRAFTING_GRID_X + column * 18, OffhandLayout.SURVIVAL_CRAFTING_GRID_Y + row * 18);
			}
		}

		this.addSlotToContainer(new Slot(player.inventory, OffhandInventory.OFFHAND_INVENTORY_INDEX, OffhandLayout.SURVIVAL_OFFHAND_X, OffhandLayout.SURVIVAL_OFFHAND_Y));
	}

	private void positionSlot(int index, int x, int y) {
		if (this.inventorySlots.size() > index) {
			Slot slot = (Slot) this.inventorySlots.get(index);
			slot.xDisplayPosition = x;
			slot.yDisplayPosition = y;
		}
	}

	@Inject(method = "transferStackInSlot", at = @At("HEAD"), cancellable = true)
	private void etfu$transferStackIncludingOffhand(EntityPlayer player, int slotIndex, CallbackInfoReturnable<ItemStack> cir) {
		ItemStack returnStack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack()) {
			ItemStack slotStack = slot.getStack();
			returnStack = slotStack.copy();

			if (slotIndex == 0) {
				if (!this.mergeItemStack(slotStack, 9, 45, true) && !this.mergeItemStack(slotStack, 45, 46, false)) {
					cir.setReturnValue(null);
					return;
				}
				slot.onSlotChange(slotStack, returnStack);
			} else if (slotIndex >= 1 && slotIndex < 5) {
				if (!this.mergeItemStack(slotStack, 9, 46, false)) {
					cir.setReturnValue(null);
					return;
				}
			} else if (slotIndex >= 5 && slotIndex < 9) {
				if (!this.mergeItemStack(slotStack, 9, 46, false)) {
					cir.setReturnValue(null);
					return;
				}
			} else if (slotIndex == OffhandInventory.OFFHAND_CONTAINER_SLOT) {
				if (!this.mergeItemStack(slotStack, 9, 45, false)) {
					cir.setReturnValue(null);
					return;
				}
			} else if (returnStack.getItem() instanceof ItemArmor && !((Slot) this.inventorySlots.get(5 + ((ItemArmor) returnStack.getItem()).armorType)).getHasStack()) {
				int armorSlot = 5 + ((ItemArmor) returnStack.getItem()).armorType;
				if (!this.mergeItemStack(slotStack, armorSlot, armorSlot + 1, false)) {
					cir.setReturnValue(null);
					return;
				}
			} else if (slotIndex >= 9 && slotIndex < 36) {
				if (!this.mergeItemStack(slotStack, 36, 46, false)) {
					cir.setReturnValue(null);
					return;
				}
			} else if (slotIndex >= 36 && slotIndex < 45) {
				if (!this.mergeItemStack(slotStack, 9, 36, false)) {
					cir.setReturnValue(null);
					return;
				}
			} else if (!this.mergeItemStack(slotStack, 9, 46, false)) {
				cir.setReturnValue(null);
				return;
			}

			if (slotStack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}

			if (slotStack.stackSize == returnStack.stackSize) {
				cir.setReturnValue(null);
				return;
			}

			slot.onPickupFromSlot(player, slotStack);
		}

		cir.setReturnValue(returnStack);
	}
}
