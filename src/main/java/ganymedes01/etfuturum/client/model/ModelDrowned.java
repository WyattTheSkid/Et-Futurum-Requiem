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

		if (entity instanceof EntityDrowned) {
			EntityDrowned drowned = (EntityDrowned) entity;
			if (isThrowingTrident(entity)) {
				bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - (float) Math.PI;
				bipedRightArm.rotateAngleY = 0.0F;
			} else {
				// Reset arms to normal ModelBiped walk angles so they hang down instead of being raised like a zombie
				bipedRightArm.rotateAngleX = net.minecraft.util.MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
				bipedLeftArm.rotateAngleX = net.minecraft.util.MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
				
				bipedRightArm.rotateAngleZ = 0.0F;
				bipedLeftArm.rotateAngleZ = 0.0F;
				bipedRightArm.rotateAngleY = 0.0F;
				bipedLeftArm.rotateAngleY = 0.0F;
				
				// Standard idle/walking arm bobbing (from ModelBiped)
				bipedRightArm.rotateAngleZ += net.minecraft.util.MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= net.minecraft.util.MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += net.minecraft.util.MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= net.minecraft.util.MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			}
		}
	}

	private boolean isThrowingTrident(Entity entity) {
		if (!(entity instanceof EntityDrowned)) {
			return false;
		}

		ItemStack stack = ((EntityDrowned) entity).getHeldItem();
		return stack != null && ModItems.TRIDENT.isEnabled() && stack.getItem() == ModItems.TRIDENT.get() && ((EntityDrowned) entity).isThrowingTrident();
	}
}
