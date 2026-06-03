package ganymedes01.etfuturum.client.model;

import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.entities.EntityDrowned;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

/**
 * Drowned model ported from vanilla Minecraft 1.21.4 DrownedModel and 1.13.2 ModelDrowned.
 * 
 * Key differences from ModelZombie:
 * - Drowned arms hang at sides (like ModelBiped) instead of raised zombie pose, unless attacking
 * - Swimming animation: arms sweep back, legs kick, head tilts forward
 * - Trident throwing pose: arm raised overhead
 * - Correct texture UV offsets for right arm and right leg (32,48 and 16,48 respectively)
 * 
 * Animation sources:
 * - Swimming pose math from 1.21.4 DrownedModel.setupAnim() and 1.13.2 ModelDrowned.setRotationAngles()
 * - rotLerpRad from 1.21.4 Mth.rotLerpRad()
 * - Zombie arm animation from 1.21.4 AnimationUtils.animateZombieArms()
 */
public class ModelDrowned extends ModelZombie {

	public ModelDrowned(float size, float yOffset, int width, int height) {
		super(size, yOffset, width, height);

		// Drowned uses unique texture UVs for right arm and right leg
		// Source: vanilla 1.13.2 ModelDrowned constructor, 1.21.4 DrownedModel.createBodyLayer()
		bipedRightArm = new ModelRenderer(this, 32, 48).setTextureSize(width, height);
		bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, size);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F + yOffset, 0.0F);

		bipedRightLeg = new ModelRenderer(this, 16, 48).setTextureSize(width, height);
		bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, size);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F + yOffset, 0.0F);
	}

	public ModelDrowned(float size, boolean armor) {
		this(size, 0.0F, 64, armor ? 32 : 64);
	}

	public void copyAttributes(ModelDrowned model) {
		isChild = model.isChild;
		isRiding = model.isRiding;
		onGround = model.onGround;
		heldItemLeft = model.heldItemLeft;
		heldItemRight = model.heldItemRight;
		aimedBow = model.aimedBow;
		isSneak = model.isSneak;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		// First apply standard ModelBiped base animations (walk cycle, head rotation, etc.)
		// We intentionally call super (ModelZombie.setRotationAngles) which applies zombie arm poses.
		// Then we override arms with drowned-specific behavior below.
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);

		if (!(entity instanceof EntityDrowned)) {
			return;
		}

		EntityDrowned drowned = (EntityDrowned) entity;
		boolean throwingTrident = isThrowingTrident(drowned);
		boolean isAggressive = drowned.isAggressive();
		float swimAmount = drowned.getSwimAmount();

		if (!isAggressive && !throwingTrident) {
			// Drowned uses normal ModelBiped arm poses (arms at sides) when not attacking
			// Override the zombie raised-arm animation from super.setRotationAngles()
			// Source: vanilla drowned does NOT extend zombie arm raise — it uses HumanoidModel base
			// In 1.21.4 AbstractZombieModel, arms are only raised when isAggressive is true
			bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
			bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
			bipedRightArm.rotateAngleY = 0.0F;
			bipedLeftArm.rotateAngleY = 0.0F;

			if (this.heldItemRight != 0) {
				this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 5F) * (float)this.heldItemRight;
			}
			if (this.heldItemLeft != 0) {
				this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 5F) * (float)this.heldItemLeft;
			}

			// Standard idle/walking arm bobbing from ModelBiped
			// Source: 1.21.4 AnimationUtils.bobArms() / 1.13.2 ModelBiped lines 237-240
			bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}
		// When isAggressive and not throwing, keep the zombie arm animation from super
		// (arms raised at -PI/1.5 with swing progress). This matches vanilla 1.21.4 behavior where
		// AbstractZombieModel.setupAnim() calls animateZombieArms() when isAggressive.

		// Apply trident throwing pose
		// Source: 1.21.4 DrownedModel.setupAnim() lines 45-48, 1.13.2 ModelDrowned lines 52-55
		if (throwingTrident) {
			// Right arm: half the current angle minus PI (arm raised overhead pointing back)
			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - (float) Math.PI;
			bipedRightArm.rotateAngleY = 0.0F;
		}

		// Apply swimming animation
		// Source: 1.21.4 DrownedModel.setupAnim() lines 50-61, 1.13.2 ModelDrowned lines 57-65
		// -2.5132742F = -(float)(Math.PI * 4.0 / 5.0) = -144 degrees in radians
		if (swimAmount > 0.0F) {
			// Arms sweep back and slightly oscillate
			if (!throwingTrident) {
				bipedRightArm.rotateAngleX = rotLerpRad(swimAmount, bipedRightArm.rotateAngleX, -2.5132742F)
						+ swimAmount * 0.35F * MathHelper.sin(0.1F * ageInTicks);
				bipedRightArm.rotateAngleZ = rotLerpRad(swimAmount, bipedRightArm.rotateAngleZ, -0.15F);
			}
			bipedLeftArm.rotateAngleX = rotLerpRad(swimAmount, bipedLeftArm.rotateAngleX, -2.5132742F)
					- swimAmount * 0.35F * MathHelper.sin(0.1F * ageInTicks);

			// Arms angle slightly inward
			bipedLeftArm.rotateAngleZ = rotLerpRad(swimAmount, bipedLeftArm.rotateAngleZ, 0.15F);

			// Legs kick gently
			bipedLeftLeg.rotateAngleX -= swimAmount * 0.55F * MathHelper.sin(0.1F * ageInTicks);
			bipedRightLeg.rotateAngleX += swimAmount * 0.55F * MathHelper.sin(0.1F * ageInTicks);

			// Head faces forward when swimming (overrides look-at-target)
			bipedHead.rotateAngleX = 0.0F;
		}
	}

	/**
	 * Linearly interpolates between two angles in radians, wrapping the difference to [-PI, PI].
	 * Direct port of 1.21.4 Mth.rotLerpRad() and 1.13.2 ModelBiped.func_205060_a().
	 * 
	 * @param delta interpolation factor (0.0 = from, 1.0 = to)
	 * @param from  starting angle in radians
	 * @param to    target angle in radians
	 * @return interpolated angle
	 */
	private static float rotLerpRad(float delta, float from, float to) {
		float diff = to - from;
		while (diff < -(float) Math.PI) {
			diff += (float) (Math.PI * 2.0);
		}
		while (diff >= (float) Math.PI) {
			diff -= (float) (Math.PI * 2.0);
		}
		return from + delta * diff;
	}

	private boolean isThrowingTrident(EntityDrowned drowned) {
		ItemStack stack = drowned.getHeldItem();
		return stack != null && ModItems.TRIDENT.isEnabled() && stack.getItem() == ModItems.TRIDENT.get() && drowned.isThrowingTrident();
	}
}
