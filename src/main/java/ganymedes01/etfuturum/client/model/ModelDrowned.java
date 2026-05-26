package ganymedes01.etfuturum.client.model;

import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.entities.EntityDrowned;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ModelDrowned extends ModelZombie {

	public ModelDrowned(float size, float yOffset, int width, int height) {
		super(size, yOffset, width, height);

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
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);

		if (isThrowingTrident(entity)) {
			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - (float) Math.PI;
			bipedRightArm.rotateAngleY = 0.0F;
		}
	}

	private boolean isThrowingTrident(Entity entity) {
		if (!(entity instanceof EntityDrowned)) {
			return false;
		}

		ItemStack stack = ((EntityDrowned) entity).getHeldItem();
		return stack != null && ModItems.TRIDENT.isEnabled() && stack.getItem() == ModItems.TRIDENT.get() && ((EntityDrowned) entity).getAttackTarget() != null;
	}
}
