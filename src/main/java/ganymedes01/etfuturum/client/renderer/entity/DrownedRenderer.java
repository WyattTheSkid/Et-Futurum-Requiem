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
import net.minecraft.util.MathHelper;
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

	/**
	 * Applies swimming body tilt rotation.
	 * Source: 1.21.4 DrownedRenderer.setupRotations() lines 47-52
	 * When swimming, the drowned's body tilts forward (face down).
	 * The tilt is proportional to swimAmount and offset by -10 degrees minus head pitch.
	 */
	@Override
	protected void rotateCorpse(EntityLivingBase entity, float ageInTicks, float headYaw, float partialTicks) {
		super.rotateCorpse(entity, ageInTicks, headYaw, partialTicks);
		if (entity instanceof EntityDrowned) {
			float swimAmount = ((EntityDrowned) entity).getSwimAmount();
			if (swimAmount > 0.0F) {
				// Source: 1.21.4 DrownedRenderer.setupRotations()
				// f1 = -10.0F - entity.xRot (head pitch)
				// f2 = lerp(swimAmount, 0, f1)
				// Rotates around the vertical center of the bounding box
				float targetTilt = -10.0F - entity.rotationPitch;
				float tilt = swimAmount * targetTilt;
				GL11.glRotatef(tilt, 1.0F, 0.0F, 0.0F);
			}
		}
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
	public void doRender(EntityLiving entity, double x, double y, double z, float yaw, float partialTicks) {
		boolean hasNautilus = false;
		if (entity instanceof EntityDrowned) {
			EntityDrowned drowned = (EntityDrowned) entity;
			hasNautilus = drowned.hasNautilusShell() && ModItems.NAUTILUS_SHELL.isEnabled();
		}
		
		int leftPose = hasNautilus ? 1 : 0;
		this.drownedModel.heldItemLeft = leftPose;
		this.outerModel.heldItemLeft = leftPose;
		if (this.field_82423_g != null) {
			this.field_82423_g.heldItemLeft = leftPose;
		}
		if (this.field_82425_h != null) {
			this.field_82425_h.heldItemLeft = leftPose;
		}

		super.doRender(entity, x, y, z, yaw, partialTicks);
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

		if (entity instanceof EntityDrowned) {
			EntityDrowned drowned = (EntityDrowned) entity;
			if (drowned.hasNautilusShell() && ModItems.NAUTILUS_SHELL.isEnabled()) {
				ItemStack shellStack = ModItems.NAUTILUS_SHELL.newItemStack();
				
				GL11.glPushMatrix();
				int previousFrontFace = GL11.glGetInteger(GL11.GL_FRONT_FACE);
				try {
					this.drownedModel.bipedLeftArm.postRender(0.0625F);
					GL11.glTranslatef(-this.drownedModel.bipedLeftArm.rotationPointX * 0.0625F, -this.drownedModel.bipedLeftArm.rotationPointY * 0.0625F, -this.drownedModel.bipedLeftArm.rotationPointZ * 0.0625F);
					GL11.glScalef(-1.0F, 1.0F, 1.0F);
					GL11.glTranslatef(-this.drownedModel.bipedLeftArm.rotationPointX * 0.0625F, this.drownedModel.bipedLeftArm.rotationPointY * 0.0625F, -this.drownedModel.bipedLeftArm.rotationPointZ * 0.0625F);
					GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
					GL11.glFrontFace(GL11.GL_CW);

					float scale = 0.375F;
					GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
					GL11.glScalef(scale, scale, scale);
					GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
					GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);

					net.minecraft.client.renderer.ItemRenderer itemRenderer = net.minecraft.client.renderer.entity.RenderManager.instance.itemRenderer;
					int color = shellStack.getItem().getColorFromItemStack(shellStack, 0);
					float red = (color >> 16 & 255) / 255.0F;
					float green = (color >> 8 & 255) / 255.0F;
					float blue = (color & 255) / 255.0F;
					GL11.glColor4f(red, green, blue, 1.0F);
					itemRenderer.renderItem(drowned, shellStack, 0);
				} finally {
					GL11.glFrontFace(previousFrontFace);
					GL11.glPopMatrix();
				}
			}
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURE;
	}
}
