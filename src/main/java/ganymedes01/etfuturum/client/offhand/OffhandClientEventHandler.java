package ganymedes01.etfuturum.client.offhand;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.configuration.configs.ConfigFunctions;
import ganymedes01.etfuturum.network.OffhandSwapMessage;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public final class OffhandClientEventHandler {
	public static final OffhandClientEventHandler INSTANCE = new OffhandClientEventHandler();

	private static final ResourceLocation WIDGETS_TEXTURE = new ResourceLocation("textures/gui/widgets.png");
	private boolean hadWorld;

	private OffhandClientEventHandler() {
	}

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if (event.phase != TickEvent.Phase.END) return;
		boolean hasWorld = Minecraft.getMinecraft().theWorld != null;
		if (!hasWorld && hadWorld) {
			OffhandClientCache.clear();
		}
		hadWorld = hasWorld;
	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		if (!ConfigFunctions.offhandSwapKeyEnabled) return;

		boolean pressed = false;
		while (OffhandKeyBindings.SWAP_HANDS.isPressed()) {
			pressed = true;
		}

		if (pressed && mc.thePlayer != null && mc.currentScreen == null) {
			EtFuturum.networkWrapper.sendToServer(new OffhandSwapMessage());
		}
	}

	@SubscribeEvent
	public void onRenderHotbar(RenderGameOverlayEvent.Post event) {
		if (event.type != RenderGameOverlayEvent.ElementType.HOTBAR || !ConfigFunctions.offhandHudEnabled) return;

		Minecraft mc = Minecraft.getMinecraft();
		if (mc.thePlayer == null) return;

		ItemStack offhandStack = OffhandInventory.getOffhandStack(mc.thePlayer);
		if (offhandStack == null) return;

		ScaledResolution resolution = event.resolution;
		int centerX = resolution.getScaledWidth() / 2;
		int screenHeight = resolution.getScaledHeight();
		int slotBgX = centerX - 91 - 29;
		int slotBgY = screenHeight - 23;
		int slotX = centerX - 91 - 26;
		int slotY = screenHeight - 19;

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(WIDGETS_TEXTURE);
		drawTexturedModalRect(slotBgX, slotBgY, 24, 22, 29, 24);

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableGUIStandardItemLighting();
		renderInventorySlot(mc, offhandStack, slotX, slotY, event.partialTicks);
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	private static void renderInventorySlot(Minecraft mc, ItemStack stack, int x, int y, float partialTicks) {
		float animation = stack.animationsToGo - partialTicks;
		if (animation > 0.0F) {
			GL11.glPushMatrix();
			float scale = 1.0F + animation / 5.0F;
			GL11.glTranslatef(x + 8, y + 12, 0.0F);
			GL11.glScalef(1.0F / scale, (scale + 1.0F) / 2.0F, 1.0F);
			GL11.glTranslatef(-(x + 8), -(y + 12), 0.0F);
		}

		RenderItem renderItem = RenderItem.getInstance();
		renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.renderEngine, stack, x, y);
		if (animation > 0.0F) {
			GL11.glPopMatrix();
		}
		renderItem.renderItemOverlayIntoGUI(mc.fontRenderer, mc.renderEngine, stack, x, y);
	}

	private static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
		float scale = 1.0F / 256.0F;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x, y + height, -90.0D, (textureX) * scale, (textureY + height) * scale);
		tessellator.addVertexWithUV(x + width, y + height, -90.0D, (textureX + width) * scale, (textureY + height) * scale);
		tessellator.addVertexWithUV(x + width, y, -90.0D, (textureX + width) * scale, textureY * scale);
		tessellator.addVertexWithUV(x, y, -90.0D, textureX * scale, textureY * scale);
		tessellator.draw();
	}
}
