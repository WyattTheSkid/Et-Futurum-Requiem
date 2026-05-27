package ganymedes01.etfuturum.client.renderer.entity;

import ganymedes01.etfuturum.client.model.ModelDrowned;
import ganymedes01.etfuturum.client.renderer.item.ItemTridentRenderer;
import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.entities.EntityDrowned;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DrownedRenderer extends RenderBiped {

	public static final boolean DEBUG_DROWNED_TRIDENT = false;
	private static long lastDrownedDebugTime = 0;

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
	protected void renderEquippedItems(EntityLiving entity, float partialTicks) {
		ItemStack stack = entity.getHeldItem();
		boolean hasTrident = stack != null && ModItems.TRIDENT.isEnabled() && stack.getItem() == ModItems.TRIDENT.get();

		if (EntityDrowned.DEBUG_DROWNED) {
			long now = System.currentTimeMillis();
			if (now - lastDrownedDebugTime >= 1000) {
				lastDrownedDebugTime = now;
				boolean aiHolds = false;
				boolean isThrowing = false;
				if (entity instanceof EntityDrowned) {
					EntityDrowned drowned = (EntityDrowned) entity;
					aiHolds = drowned.getHeldItem() != null && drowned.getHeldItem().getItem() == ModItems.TRIDENT.get();
					isThrowing = drowned.isThrowingTrident();
				}
				System.out.println(String.format(
					"[DrownedDebug] Render: %s, Renderer: DrownedRenderer, Model: ModelDrowned, hasTridentEquipped: %b, isThrowingTrident: %b, path: DrownedRenderer.renderEquippedItems, transform: RightArm postRender space, activeTransform: %s",
					entity.toString(), hasTrident, isThrowing, isThrowing ? "THROW" : "IDLE"
				));
			}
		}

		if (hasTrident) {
			GL11.glPushMatrix();
			this.drownedModel.bipedRightArm.postRender(0.0625F);
			
			ItemTridentRenderer.renderDrownedTrident(this.drownedModel, entity, stack);
			
			GL11.glPopMatrix();

			// Temporarily remove held item so RenderBiped doesn't render it
			entity.setCurrentItemOrArmor(0, null);
			super.renderEquippedItems(entity, partialTicks);
			entity.setCurrentItemOrArmor(0, stack);
		} else {
			super.renderEquippedItems(entity, partialTicks);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURE;
	}
}
