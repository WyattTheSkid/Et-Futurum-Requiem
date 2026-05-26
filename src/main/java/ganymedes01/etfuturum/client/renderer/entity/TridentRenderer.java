package ganymedes01.etfuturum.client.renderer.entity;

import ganymedes01.etfuturum.client.model.ModelTrident;
import ganymedes01.etfuturum.entities.EntityTrident;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TridentRenderer extends Render {

	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/trident.png");
	private final ModelTrident model = new ModelTrident();

	public void doRender(EntityTrident trident, double x, double y, double z, float yaw, float partialTicks) {
		bindEntityTexture(trident);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(trident.prevRotationYaw + (trident.rotationYaw - trident.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(trident.prevRotationPitch + (trident.rotationPitch - trident.prevRotationPitch) * partialTicks + 90.0F, 0.0F, 0.0F, 1.0F);

		float shake = trident.arrowShake - partialTicks;
		if (shake > 0.0F) {
			float shakeRotation = -MathHelper.sin(shake * 3.0F) * shake;
			GL11.glRotatef(shakeRotation, 0.0F, 0.0F, 1.0F);
		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		model.renderer();
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
		doRender((EntityTrident) entity, x, y, z, yaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURE;
	}
}
