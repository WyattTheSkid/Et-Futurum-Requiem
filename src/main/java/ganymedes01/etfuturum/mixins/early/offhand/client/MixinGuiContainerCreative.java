package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.offhand.OffhandInventory;
import ganymedes01.etfuturum.offhand.OffhandLayout;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiContainerCreative.class)
public abstract class MixinGuiContainerCreative extends InventoryEffectRenderer {
	@Shadow
	private static int selectedTabIndex;

	public MixinGuiContainerCreative(Container container) {
		super(container);
	}

	@Inject(method = "func_147050_b", at = @At("TAIL"))
	private void etfu$positionOffhandInventorySlot(CreativeTabs tab, CallbackInfo ci) {
		if (selectedTabIndex != CreativeTabs.tabInventory.getTabIndex()) return;

		for (Object object : this.inventorySlots.inventorySlots) {
			Slot slot = (Slot) object;
			if (slot.isSlotInInventory(net.minecraft.client.Minecraft.getMinecraft().thePlayer.inventory, OffhandInventory.OFFHAND_INVENTORY_INDEX)) {
				slot.xDisplayPosition = OffhandLayout.CREATIVE_OFFHAND_X;
				slot.yDisplayPosition = OffhandLayout.CREATIVE_OFFHAND_Y;
			}
		}

		positionSlotByListIndex(5, OffhandLayout.CREATIVE_ARMOR_LEFT_X, OffhandLayout.CREATIVE_ARMOR_TOP_Y);
		positionSlotByListIndex(6, OffhandLayout.CREATIVE_ARMOR_LEFT_X, OffhandLayout.CREATIVE_ARMOR_BOTTOM_Y);
		positionSlotByListIndex(7, OffhandLayout.CREATIVE_ARMOR_RIGHT_X, OffhandLayout.CREATIVE_ARMOR_TOP_Y);
		positionSlotByListIndex(8, OffhandLayout.CREATIVE_ARMOR_RIGHT_X, OffhandLayout.CREATIVE_ARMOR_BOTTOM_Y);
	}

	@Redirect(method = "drawGuiContainerBackgroundLayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/inventory/GuiInventory;func_147046_a(IIIFFLnet/minecraft/entity/EntityLivingBase;)V"))
	private void etfu$drawCreativePlayerInModernSlot(int x, int y, int scale, float mouseX, float mouseY, EntityLivingBase entity, float partialTicks, int originalMouseX, int originalMouseY) {
		int modelX = this.guiLeft + OffhandLayout.CREATIVE_PLAYER_MODEL_X;
		int modelY = this.guiTop + OffhandLayout.CREATIVE_PLAYER_MODEL_Y;
		GuiInventory.func_147046_a(
				modelX,
				modelY,
				OffhandLayout.CREATIVE_PLAYER_MODEL_SCALE,
				(float) modelX - originalMouseX,
				(float) (modelY - OffhandLayout.CREATIVE_PLAYER_MODEL_MOUSE_Y_OFFSET) - originalMouseY,
				entity);
	}

	private void positionSlotByListIndex(int index, int x, int y) {
		if (this.inventorySlots.inventorySlots.size() > index) {
			Slot slot = (Slot) this.inventorySlots.inventorySlots.get(index);
			slot.xDisplayPosition = x;
			slot.yDisplayPosition = y;
		}
	}
}
