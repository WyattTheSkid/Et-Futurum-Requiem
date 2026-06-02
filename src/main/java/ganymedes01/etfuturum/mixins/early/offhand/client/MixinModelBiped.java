package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.client.offhand.OffhandClientCache;
import ganymedes01.etfuturum.offhand.Hand;
import ganymedes01.etfuturum.offhand.IOffhandEntity;
import ganymedes01.etfuturum.offhand.IOffhandModel;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBiped.class)
public abstract class MixinModelBiped implements IOffhandModel {
	@Shadow
	public ModelRenderer bipedHead;
	@Shadow
	public ModelRenderer bipedBody;
	@Shadow
	public ModelRenderer bipedRightArm;
	@Shadow
	public ModelRenderer bipedLeftArm;

	@Unique
	private float etfu$offhandSwingProgress;

	@Override
	public void etfu$setOffhandSwing(float swing) {
		etfu$offhandSwingProgress = swing;
	}

	@Inject(method = "setRotationAngles", at = @At("RETURN"))
	private void etfu$applyOffhandArmAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity, CallbackInfo ci) {
		if (etfu$offhandSwingProgress > 0.0F) {
			float swing = etfu$offhandSwingProgress;

			if (bipedBody.rotateAngleY != 0.0F) {
				bipedLeftArm.rotateAngleY -= bipedBody.rotateAngleY;
				bipedLeftArm.rotateAngleX -= bipedBody.rotateAngleY;
			}

			bipedBody.rotateAngleY = -MathHelper.sin(MathHelper.sqrt_float(swing) * (float) Math.PI * 2.0F) * 0.2F;
			bipedLeftArm.rotationPointZ = -MathHelper.sin(bipedBody.rotateAngleY) * 5.0F;
			bipedLeftArm.rotationPointX = MathHelper.cos(bipedBody.rotateAngleY) * 5.0F;

			float swingInv = 1.0F - swing;
			swingInv = 1.0F - swingInv * swingInv * swingInv;
			float swingMath1 = MathHelper.sin(swingInv * (float) Math.PI);
			float swingMath2 = MathHelper.sin(swing * (float) Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
			bipedLeftArm.rotateAngleX -= swingMath1 * 1.2F + swingMath2;
			bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 3.0F;
			bipedLeftArm.rotateAngleZ = MathHelper.sin(swing * (float) Math.PI) * -0.4F;
		}

		if (etfu$isActiveOffhandBow(entity)) {
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleY = 0.1F + bipedHead.rotateAngleY;
			bipedRightArm.rotateAngleY = -0.5F + bipedHead.rotateAngleY;
			bipedLeftArm.rotateAngleX = -((float) Math.PI / 2.0F) + bipedHead.rotateAngleX - 0.4F;
			bipedRightArm.rotateAngleX = -((float) Math.PI / 2.0F) + bipedHead.rotateAngleX - 0.4F;
			bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}
	}

	@Unique
	private boolean etfu$isActiveOffhandBow(Entity entity) {
		if (!(entity instanceof EntityPlayer player) || !(entity instanceof IOffhandEntity)) return false;
		if (((IOffhandEntity) entity).etfu$getActiveHand() != Hand.OFF_HAND) return false;

		ItemStack offhand = player == net.minecraft.client.Minecraft.getMinecraft().thePlayer ? OffhandInventory.getOffhandStack(player) : OffhandClientCache.getOffhandForPlayer(player);
		return offhand != null && offhand.getItem() != null && offhand.getItemUseAction() == EnumAction.bow;
	}
}
