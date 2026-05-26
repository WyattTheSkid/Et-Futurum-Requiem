package ganymedes01.etfuturum.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrident extends ModelBase {

	private final ModelRenderer root;

	public ModelTrident() {
		textureWidth = 32;
		textureHeight = 32;

		root = new ModelRenderer(this, 0, 0);
		root.addBox(-0.5F, -4.0F, -0.5F, 1, 31, 1, 0.0F);

		ModelRenderer centerProng = new ModelRenderer(this, 4, 0);
		centerProng.addBox(-1.5F, 0.0F, -0.5F, 3, 2, 1);
		root.addChild(centerProng);

		ModelRenderer leftProng = new ModelRenderer(this, 4, 3);
		leftProng.addBox(-2.5F, -3.0F, -0.5F, 1, 4, 1);
		root.addChild(leftProng);

		ModelRenderer rightProng = new ModelRenderer(this, 4, 3);
		rightProng.mirror = true;
		rightProng.addBox(1.5F, -3.0F, -0.5F, 1, 4, 1);
		root.addChild(rightProng);
	}

	public void renderer() {
		root.render(0.0625F);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		root.render(scale);
	}
}
