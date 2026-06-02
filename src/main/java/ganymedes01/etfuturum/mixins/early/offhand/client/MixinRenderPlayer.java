package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.client.offhand.OffhandClientCache;
import ganymedes01.etfuturum.configuration.configs.ConfigFunctions;
import ganymedes01.etfuturum.offhand.Hand;
import ganymedes01.etfuturum.offhand.IOffhandEntity;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderPlayer.class)
public abstract class MixinRenderPlayer {
	@Shadow
	private ModelBiped modelBipedMain;
	@Shadow
	private ModelBiped modelArmorChestplate;
	@Shadow
	private ModelBiped modelArmor;

	@Unique
	private ItemStack etfu$getOffhandStack(EntityPlayer player) {
		return player == Minecraft.getMinecraft().thePlayer ? OffhandInventory.getOffhandStack(player) : OffhandClientCache.getOffhandForPlayer(player);
	}

	@Unique
	private boolean etfu$isOffhandActive(EntityPlayer player) {
		return player instanceof IOffhandEntity && ((IOffhandEntity) player).etfu$getActiveHand() == Hand.OFF_HAND;
	}

	@Inject(method = "renderEquippedItems", at = @At("RETURN"))
	private void etfu$renderOffhandEquippedItem(AbstractClientPlayer player, float partialTicks, CallbackInfo ci) {
		if (!ConfigFunctions.offhandThirdPersonRender) return;

		ItemStack stack = etfu$getOffhandStack(player);
		if (stack == null || stack.getItem() == null) return;

		GL11.glPushMatrix();
		int previousFrontFace = GL11.glGetInteger(GL11.GL_FRONT_FACE);
		try {
			modelBipedMain.bipedLeftArm.postRender(0.0625F);
			GL11.glTranslatef(-modelBipedMain.bipedLeftArm.rotationPointX * 0.0625F, -modelBipedMain.bipedLeftArm.rotationPointY * 0.0625F, -modelBipedMain.bipedLeftArm.rotationPointZ * 0.0625F);
			GL11.glScalef(-1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(-modelBipedMain.bipedLeftArm.rotationPointX * 0.0625F, modelBipedMain.bipedLeftArm.rotationPointY * 0.0625F, -modelBipedMain.bipedLeftArm.rotationPointZ * 0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			GL11.glFrontFace(GL11.GL_CW);

			boolean isBlock = stack.getItem() instanceof ItemBlock && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(stack.getItem()).getRenderType());
			boolean isBow = stack.getItem() == Items.bow;
			boolean isFull3D = stack.getItem().isFull3D();
			net.minecraft.client.renderer.ItemRenderer itemRenderer = RenderManager.instance.itemRenderer;

			if (isBlock) {
				float scale = 0.375F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(-scale, -scale, scale);
			} else if (isBow) {
				float scale = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(scale, -scale, scale);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else if (isFull3D) {
				float scale = 0.625F;
				if (stack.getItem().shouldRotateAroundWhenRendering()) {
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}

				if (etfu$isOffhandActive(player) && stack.getItemUseAction() == EnumAction.block) {
					GL11.glTranslatef(0.05F, 0.0F, -0.1F);
					GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
				}

				GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
				GL11.glScalef(scale, -scale, scale);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else {
				float scale = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			if (stack.getItem().requiresMultipleRenderPasses()) {
				for (int pass = 0; pass <= 1; pass++) {
					renderItemPass(player, stack, itemRenderer, pass);
				}
			} else {
				renderItemPass(player, stack, itemRenderer, 0);
			}
		} finally {
			GL11.glFrontFace(previousFrontFace);
			GL11.glPopMatrix();
		}
	}

	@Unique
	private static void renderItemPass(AbstractClientPlayer player, ItemStack stack, net.minecraft.client.renderer.ItemRenderer itemRenderer, int pass) {
		int color = stack.getItem().getColorFromItemStack(stack, pass);
		float red = (color >> 16 & 255) / 255.0F;
		float green = (color >> 8 & 255) / 255.0F;
		float blue = (color & 255) / 255.0F;
		GL11.glColor4f(red, green, blue, 1.0F);
		itemRenderer.renderItem(player, stack, pass);
	}

	@Inject(method = "doRender", at = @At("HEAD"))
	private void etfu$setOffhandLeftArmPose(AbstractClientPlayer player, double x, double y, double z, float yaw, float partialTicks, CallbackInfo ci) {
		if (!ConfigFunctions.offhandThirdPersonRender) return;

		ItemStack offhand = etfu$getOffhandStack(player);
		int leftPose = offhand != null ? 1 : 0;
		if (offhand != null && etfu$isOffhandActive(player) && offhand.getItemUseAction() == EnumAction.block) {
			leftPose = 3;
		}
		modelBipedMain.heldItemLeft = leftPose;
		modelArmorChestplate.heldItemLeft = leftPose;
		modelArmor.heldItemLeft = leftPose;
	}

	@Inject(method = "doRender", at = @At("RETURN"))
	private void etfu$clearOffhandLeftArmPose(AbstractClientPlayer player, double x, double y, double z, float yaw, float partialTicks, CallbackInfo ci) {
		modelBipedMain.heldItemLeft = 0;
		modelArmorChestplate.heldItemLeft = 0;
		modelArmor.heldItemLeft = 0;
	}
}
