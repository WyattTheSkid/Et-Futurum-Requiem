package ganymedes01.etfuturum.client.renderer.item;

import java.nio.FloatBuffer;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemPortalRenderer implements IItemRenderer {

	private static final ResourceLocation END_SKY_TEXTURE = new ResourceLocation("textures/environment/end_sky.png");
	private static final ResourceLocation END_PORTAL_TEXTURE = new ResourceLocation("textures/entity/end_portal.png");
	private static final Random RANDOM = new Random(31100L);
	private static final FloatBuffer MODELVIEW = GLAllocation.createDirectFloatBuffer(16);
	private static final FloatBuffer PROJECTION = GLAllocation.createDirectFloatBuffer(16);
	private final FloatBuffer buffer = GLAllocation.createDirectFloatBuffer(16);

	private final boolean isEndPortal;

	public ItemPortalRenderer(boolean isEndPortal) {
		this.isEndPortal = isEndPortal;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.INVENTORY ||
		       type == ItemRenderType.EQUIPPED ||
		       type == ItemRenderType.EQUIPPED_FIRST_PERSON ||
		       type == ItemRenderType.ENTITY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if (isEndPortal) {
			renderEndPortal(type);
		} else {
			renderNetherPortal(type);
		}
	}

	private void renderNetherPortal(ItemRenderType type) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);

		GL11.glPushMatrix();
		if (type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY) {
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		}

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_LIGHTING);

		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();

		IIcon icon = Blocks.portal.getIcon(0, 0);
		if (icon == null) {
			tessellator.draw();
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
			return;
		}

		float minU = icon.getMinU();
		float maxU = icon.getMaxU();
		float minV = icon.getMinV();
		float maxV = icon.getMaxV();

		double min = 0.0D;
		double max = 1.0D;

		// Down face (y = 0.0)
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		tessellator.addVertexWithUV(min, min, max, minU, maxV);
		tessellator.addVertexWithUV(min, min, min, minU, minV);
		tessellator.addVertexWithUV(max, min, min, maxU, minV);
		tessellator.addVertexWithUV(max, min, max, maxU, maxV);

		// Up face (y = 1.0)
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		tessellator.addVertexWithUV(max, max, max, minU, minV);
		tessellator.addVertexWithUV(max, max, min, maxU, minV);
		tessellator.addVertexWithUV(min, max, min, maxU, maxV);
		tessellator.addVertexWithUV(min, max, max, minU, maxV);

		// North face (z = 0.0)
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		tessellator.addVertexWithUV(min, max, min, maxU, minV);
		tessellator.addVertexWithUV(max, max, min, minU, minV);
		tessellator.addVertexWithUV(max, min, min, minU, maxV);
		tessellator.addVertexWithUV(min, min, min, maxU, maxV);

		// South face (z = 1.0)
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		tessellator.addVertexWithUV(max, max, max, maxU, minV);
		tessellator.addVertexWithUV(min, max, max, minU, minV);
		tessellator.addVertexWithUV(min, min, max, minU, maxV);
		tessellator.addVertexWithUV(max, min, max, maxU, maxV);

		// West face (x = 0.0)
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		tessellator.addVertexWithUV(min, max, max, maxU, minV);
		tessellator.addVertexWithUV(min, max, min, minU, minV);
		tessellator.addVertexWithUV(min, min, min, minU, maxV);
		tessellator.addVertexWithUV(min, min, max, maxU, maxV);

		// East face (x = 1.0)
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		tessellator.addVertexWithUV(max, max, min, maxU, minV);
		tessellator.addVertexWithUV(max, max, max, minU, minV);
		tessellator.addVertexWithUV(max, min, max, minU, maxV);
		tessellator.addVertexWithUV(max, min, min, maxU, maxV);

		tessellator.draw();

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	private void renderEndPortal(ItemRenderType type) {
		GL11.glPushMatrix();
		if (type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY) {
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		}

		GL11.glDisable(GL11.GL_LIGHTING);
		RANDOM.setSeed(31100L);
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, MODELVIEW);
		GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, PROJECTION);

		for (int k = 0; k < 16; ++k) {
			GL11.glPushMatrix();
			float f5 = 2.0F / (float) (18 - k);

			if (k == 0) {
				Minecraft.getMinecraft().getTextureManager().bindTexture(END_SKY_TEXTURE);
				f5 = 0.15F;
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			}

			if (k >= 1) {
				Minecraft.getMinecraft().getTextureManager().bindTexture(END_PORTAL_TEXTURE);
			}

			if (k == 1) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			}

			GL11.glTexGeni(GL11.GL_S, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_EYE_LINEAR);
			GL11.glTexGeni(GL11.GL_T, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_EYE_LINEAR);
			GL11.glTexGeni(GL11.GL_R, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_EYE_LINEAR);
			GL11.glTexGen(GL11.GL_S, GL11.GL_EYE_PLANE, this.func_147525_a(1.0F, 0.0F, 0.0F, 0.0F));
			GL11.glTexGen(GL11.GL_T, GL11.GL_EYE_PLANE, this.func_147525_a(0.0F, 1.0F, 0.0F, 0.0F));
			GL11.glTexGen(GL11.GL_R, GL11.GL_EYE_PLANE, this.func_147525_a(0.0F, 0.0F, 1.0F, 0.0F));
			GL11.glEnable(GL11.GL_TEXTURE_GEN_S);
			GL11.glEnable(GL11.GL_TEXTURE_GEN_T);
			GL11.glEnable(GL11.GL_TEXTURE_GEN_R);
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_TEXTURE);
			GL11.glPushMatrix();
			GL11.glLoadIdentity();
			GL11.glTranslatef(0.5F, 0.5F, 0.0F);
			GL11.glScalef(0.5F, 0.5F, 1.0F);
			float f1 = (float) (k + 1);
			GL11.glTranslatef(17.0F / f1, (2.0F + f1 / 1.5F) * ((float) Minecraft.getSystemTime() % 800000.0F / 800000.0F), 0.0F);
			GL11.glRotatef((f1 * f1 * 4321.0F + f1 * 9.0F) * 2.0F, 0.0F, 0.0F, 1.0F);
			GL11.glScalef(4.5F - f1 / 4.0F, 4.5F - f1 / 4.0F, 1.0F);
			GL11.glMultMatrix(PROJECTION);
			GL11.glMultMatrix(MODELVIEW);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawingQuads();
			float f2 = (RANDOM.nextFloat() * 0.5F + 0.1F) * f5;
			float f3 = (RANDOM.nextFloat() * 0.5F + 0.4F) * f5;
			float f4 = (RANDOM.nextFloat() * 0.5F + 0.5F) * f5;

			if (k == 0) {
				f2 = f3 = f4 = f5;
			}

			tessellator.setColorOpaque_F(f2, f3, f4);

			double min = 0.0D;
			double max = 1.0D;

			// Down
			tessellator.addVertex(min, min, min);
			tessellator.addVertex(max, min, min);
			tessellator.addVertex(max, min, max);
			tessellator.addVertex(min, min, max);

			// Up
			tessellator.addVertex(min, max, max);
			tessellator.addVertex(max, max, max);
			tessellator.addVertex(max, max, min);
			tessellator.addVertex(min, max, min);

			// North
			tessellator.addVertex(min, max, min);
			tessellator.addVertex(max, max, min);
			tessellator.addVertex(max, min, min);
			tessellator.addVertex(min, min, min);

			// South
			tessellator.addVertex(max, max, max);
			tessellator.addVertex(min, max, max);
			tessellator.addVertex(min, min, max);
			tessellator.addVertex(max, min, max);

			// West
			tessellator.addVertex(min, max, max);
			tessellator.addVertex(min, max, min);
			tessellator.addVertex(min, min, min);
			tessellator.addVertex(min, min, max);

			// East
			tessellator.addVertex(max, max, min);
			tessellator.addVertex(max, max, max);
			tessellator.addVertex(max, min, max);
			tessellator.addVertex(max, min, min);

			tessellator.draw();
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_GEN_S);
		GL11.glDisable(GL11.GL_TEXTURE_GEN_T);
		GL11.glDisable(GL11.GL_TEXTURE_GEN_R);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	private FloatBuffer func_147525_a(float p_147525_1_, float p_147525_2_, float p_147525_3_, float p_147525_4_) {
		this.buffer.clear();
		this.buffer.put(p_147525_1_).put(p_147525_2_).put(p_147525_3_).put(p_147525_4_);
		this.buffer.flip();
		return this.buffer;
	}
}
