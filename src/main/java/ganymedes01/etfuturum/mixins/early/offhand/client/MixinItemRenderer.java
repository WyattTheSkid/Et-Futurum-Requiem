package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.client.offhand.OffhandClientCache;
import ganymedes01.etfuturum.configuration.configs.ConfigFunctions;
import ganymedes01.etfuturum.offhand.Hand;
import ganymedes01.etfuturum.offhand.IOffhandEntity;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer {
	@Shadow
	private Minecraft mc;

	@Unique
	private ItemRenderer etfu$offhandFirstPersonRenderer;
	@Unique
	private static boolean etfu$renderingOffhand;
	@Unique
	private static boolean etfu$updatingOffhandRenderer;

	@Unique
	private ItemRenderer etfu$getOffhandFirstPersonRenderer() {
		if (etfu$offhandFirstPersonRenderer == null) {
			etfu$offhandFirstPersonRenderer = new ItemRenderer(mc);
		}
		return etfu$offhandFirstPersonRenderer;
	}

	@Unique
	private boolean etfu$isOffhandActive(EntityClientPlayerMP player) {
		return player instanceof IOffhandEntity && ((IOffhandEntity) player).etfu$getActiveHand() == Hand.OFF_HAND;
	}

	@Unique
	private boolean etfu$isActiveOffhandBow(EntityClientPlayerMP player) {
		ItemStack offhand = OffhandInventory.getOffhandStack(player);
		return etfu$isOffhandActive(player) && offhand != null && offhand.getItem() != null && offhand.getItemUseAction() == EnumAction.bow;
	}

	@Inject(method = "renderItemInFirstPerson", at = @At("RETURN"))
	private void etfu$renderOffhandItemInFirstPerson(float partialTicks, CallbackInfo ci) {
		if (etfu$renderingOffhand || !ConfigFunctions.offhandFirstPersonRender || mc.thePlayer == null) return;

		ItemStack offhandStack = OffhandInventory.getOffhandStack(mc.thePlayer);
		if (offhandStack == null) return;

		EntityClientPlayerMP player = mc.thePlayer;
		int previousSlot = player.inventory.currentItem;
		boolean cullEnabled = GL11.glIsEnabled(GL11.GL_CULL_FACE);
		int previousCullFace = GL11.glGetInteger(GL11.GL_CULL_FACE_MODE);

		GL11.glPushMatrix();
		try {
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glCullFace(GL11.GL_FRONT);
			GL11.glScalef(-1.0F, 1.0F, 1.0F);

			float armPitch = player.prevRenderArmPitch + (player.renderArmPitch - player.prevRenderArmPitch) * partialTicks;
			float armYaw = player.prevRenderArmYaw + (player.renderArmYaw - player.prevRenderArmYaw) * partialTicks;
			GL11.glRotatef((player.rotationPitch - armPitch) * -0.1F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef((player.rotationYaw - armYaw) * -0.1F, 0.0F, 1.0F, 0.0F);

			etfu$renderingOffhand = true;
			player.inventory.currentItem = OffhandInventory.OFFHAND_INVENTORY_INDEX;
			etfu$getOffhandFirstPersonRenderer().renderItemInFirstPerson(partialTicks);
		} finally {
			player.inventory.currentItem = previousSlot;
			etfu$renderingOffhand = false;
			GL11.glCullFace(previousCullFace);
			if (!cullEnabled) {
				GL11.glDisable(GL11.GL_CULL_FACE);
			}
			GL11.glPopMatrix();
		}
	}

	@Inject(method = "updateEquippedItem", at = @At("TAIL"))
	private void etfu$updateOffhandEquippedItem(CallbackInfo ci) {
		if (etfu$updatingOffhandRenderer || mc.thePlayer == null) return;

		EntityClientPlayerMP player = mc.thePlayer;
		int previousSlot = player.inventory.currentItem;
		try {
			etfu$updatingOffhandRenderer = true;
			player.inventory.currentItem = OffhandInventory.OFFHAND_INVENTORY_INDEX;
			if (OffhandClientCache.triggerOffhandEquipReset) {
				etfu$getOffhandFirstPersonRenderer().resetEquippedProgress();
				OffhandClientCache.triggerOffhandEquipReset = false;
			}
			etfu$getOffhandFirstPersonRenderer().updateEquippedItem();
		} finally {
			player.inventory.currentItem = previousSlot;
			etfu$updatingOffhandRenderer = false;
		}
	}

	@Redirect(method = "renderItemInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityClientPlayerMP;getSwingProgress(F)F"))
	private float etfu$getOffhandSwingProgress(EntityClientPlayerMP player, float partialTicks) {
		if (etfu$renderingOffhand && player instanceof IOffhandEntity) {
			return ((IOffhandEntity) player).etfu$getOffhandSwingProgress(partialTicks);
		}
		return player.getSwingProgress(partialTicks);
	}

	@Redirect(method = "renderItemInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityClientPlayerMP;getItemInUseCount()I"))
	private int etfu$getItemInUseCountForHand(EntityClientPlayerMP player) {
		if (etfu$renderingOffhand) {
			return etfu$isOffhandActive(player) ? player.getItemInUseCount() : 0;
		}
		return etfu$isOffhandActive(player) ? 0 : player.getItemInUseCount();
	}

	@Redirect(method = "updateEquippedItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/InventoryPlayer;getCurrentItem()Lnet/minecraft/item/ItemStack;"))
	private ItemStack etfu$getCurrentItemForEquippedUpdate(InventoryPlayer inventory) {
		if (!etfu$updatingOffhandRenderer && mc.thePlayer != null && etfu$isActiveOffhandBow(mc.thePlayer)) {
			return null;
		}
		return inventory.getCurrentItem();
	}
}
