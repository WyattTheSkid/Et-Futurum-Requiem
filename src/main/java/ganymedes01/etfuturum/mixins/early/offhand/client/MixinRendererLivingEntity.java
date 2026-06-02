package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.offhand.IOffhandEntity;
import ganymedes01.etfuturum.offhand.IOffhandModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RendererLivingEntity.class)
public abstract class MixinRendererLivingEntity {
	@Shadow
	protected ModelBase mainModel;
	@Shadow
	protected ModelBase renderPassModel;

	@Inject(method = "doRender(Lnet/minecraft/entity/EntityLivingBase;DDDFF)V", at = @At("HEAD"))
	private void etfu$setOffhandSwingOnModels(EntityLivingBase entity, double x, double y, double z, float yaw, float partialTicks, CallbackInfo ci) {
		if (entity instanceof IOffhandEntity offhandEntity) {
			float offhandSwing = offhandEntity.etfu$getOffhandSwingProgress(partialTicks);
			if (mainModel instanceof IOffhandModel model) {
				model.etfu$setOffhandSwing(offhandSwing);
			}
			if (renderPassModel instanceof IOffhandModel model) {
				model.etfu$setOffhandSwing(offhandSwing);
			}
		}
	}
}
