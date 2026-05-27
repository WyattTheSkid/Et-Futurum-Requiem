package ganymedes01.etfuturum.mixins.early.trident.client;

import ganymedes01.etfuturum.items.equipment.ItemTrident;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBiped.class)
public class MixinModelBiped {

	@Shadow
	public ModelRenderer bipedRightArm;

	@Inject(method = "setRotationAngles", at = @At("RETURN"))
	private void setTridentThrowingArmPose(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity, CallbackInfo ci) {
		if (!(entity instanceof EntityPlayer)) {
			return;
		}

		EntityPlayer player = (EntityPlayer) entity;
		ItemStack stack = player.getItemInUse();
		if (player.getItemInUseCount() <= 0 || stack == null || !(stack.getItem() instanceof ItemTrident)) {
			return;
		}

		bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - (float) Math.PI;
		bipedRightArm.rotateAngleY = 0.0F;
	}
}
