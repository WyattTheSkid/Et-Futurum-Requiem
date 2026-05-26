package ganymedes01.etfuturum.client.renderer.item;

import ganymedes01.etfuturum.client.model.ModelTrident;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class ItemTridentRenderer implements IItemRenderer {

	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/trident.png");
	private final ModelTrident model = new ModelTrident();

	@Override
	public boolean handleRenderType(ItemStack stack, ItemRenderType type) {
		return type != ItemRenderType.FIRST_PERSON_MAP;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack stack, ItemRendererHelper helper) {
		return type == ItemRenderType.ENTITY && (helper == ItemRendererHelper.ENTITY_BOBBING || helper == ItemRendererHelper.ENTITY_ROTATION);
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		switch (type) {
			case INVENTORY:
				GL11.glTranslatef(8.0F, 8.0F, 0.0F);
				GL11.glRotatef(-45.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(15.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(8.0F, -8.0F, 8.0F);
				break;
			case ENTITY:
				GL11.glScalef(0.8F, -0.8F, -0.8F);
				break;
			case EQUIPPED_FIRST_PERSON:
				applyFirstPersonTransform(stack);
				break;
			case EQUIPPED:
				applyThirdPersonTransform(data);
				break;
			default:
				break;
		}

		model.renderer();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	private void applyFirstPersonTransform(ItemStack stack) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player != null && player.getItemInUse() == stack) {
			float ticks = Math.min(10.0F, (float) player.getItemInUseDuration() + Minecraft.getMinecraft().timer.renderPartialTicks);
			GL11.glTranslatef(-0.8F - 0.07F * ticks, 2.2F, 1.0F + 0.015F * ticks);
			GL11.glRotatef(-60.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
		} else {
			GL11.glTranslatef(0.0F, -0.3F, 0.85F);
			GL11.glRotatef(75.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-5.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-10.0F, 0.0F, 0.0F, 1.0F);
		}
		GL11.glScalef(2.0F, 2.0F, 2.0F);
	}

	private void applyThirdPersonTransform(Object... data) {
		if (data.length >= 2 && data[1] instanceof EntityPlayer && ((EntityPlayer) data[1]).isUsingItem()) {
			GL11.glTranslatef(-0.2F, 0.5F, 0.9F);
			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(40.0F, 0.0F, 0.0F, 1.0F);
		} else {
			GL11.glTranslatef(-0.2F, 1.0F, 0.875F);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(18.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-10.0F, 0.0F, 0.0F, 1.0F);
		}
		GL11.glScalef(2.5F, 2.5F, 2.5F);
	}
}
