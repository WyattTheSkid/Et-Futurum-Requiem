package ganymedes01.etfuturum.client.renderer.entity;

import ganymedes01.etfuturum.client.model.ModelDrowned;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DrownedRenderer extends RenderBiped {

	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/zombie/drowned.png");
	private static final ResourceLocation OUTER_TEXTURE = new ResourceLocation("textures/entity/zombie/drowned_outer_layer.png");
	private final ModelDrowned drownedModel;
	private final ModelDrowned outerModel = new ModelDrowned(0.25F, 0.0F, 64, 64);

	public DrownedRenderer() {
		this(new ModelDrowned(0.0F, 0.0F, 64, 64));
	}

	private DrownedRenderer(ModelDrowned model) {
		super(model, 0.5F);
		drownedModel = model;
	}

	@Override
	protected void func_82421_b() {
		field_82423_g = new ModelDrowned(1.0F, true);
		field_82425_h = new ModelDrowned(0.5F, true);
	}

	@Override
	protected void renderModel(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.renderModel(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		if (!entity.isInvisible()) {
			outerModel.copyAttributes(drownedModel);
			outerModel.setLivingAnimations(entity, limbSwing, limbSwingAmount, ageInTicks);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			bindTexture(OUTER_TEXTURE);
			outerModel.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURE;
	}
}
