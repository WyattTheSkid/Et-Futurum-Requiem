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
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public final class OffhandClientEventHandler {
	public static final OffhandClientEventHandler INSTANCE = new OffhandClientEventHandler();

	private static ItemStack itemActivationItem;
	private static int itemActivationTicks;
	private static float itemActivationOffX;
	private static float itemActivationOffY;

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

		if (itemActivationTicks > 0) {
			--itemActivationTicks;
			if (itemActivationTicks == 0) {
				itemActivationItem = null;
			}
		}
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

	public static void displayItemActivation(ItemStack stack) {
		System.out.println("[TotemDebug] displayItemActivation called with " + stack);
		itemActivationItem = stack;
		itemActivationTicks = 40;
		Minecraft mc = Minecraft.getMinecraft();
		if (mc.theWorld != null) {
			java.util.Random rand = mc.theWorld.rand;
			itemActivationOffX = rand.nextFloat() * 2.0F - 1.0F;
			itemActivationOffY = rand.nextFloat() * 2.0F - 1.0F;
		}
	}

	@SubscribeEvent
	public void onRenderTotem(RenderGameOverlayEvent.Post event) {
		if (event.type != RenderGameOverlayEvent.ElementType.HOTBAR) return;
		if (itemActivationItem == null || itemActivationTicks <= 0) return;

		Minecraft mc = Minecraft.getMinecraft();
		float partialTicks = event.partialTicks;
		ScaledResolution resolution = event.resolution;
		int width = resolution.getScaledWidth();
		int height = resolution.getScaledHeight();

		int i = 40 - itemActivationTicks;
		float f = ((float)i + partialTicks) / 40.0F;
		float f1 = f * f;
		float f2 = f * f1;
		float f3 = 10.25F * f2 * f1 - 24.95F * f1 * f1 + 25.5F * f2 - 13.8F * f1 + 4.0F * f;
		float f4 = f3 * (float)Math.PI;
		float f5 = itemActivationOffX * (float)(width / 4);
		float f6 = itemActivationOffY * (float)(height / 4);

		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_CULL_FACE);
		RenderHelper.enableStandardItemLighting();
		GL11.glTranslatef((float)(width / 2) + f5 * MathHelper.abs(MathHelper.sin(f4 * 2.0F)), (float)(height / 2) + f6 * MathHelper.abs(MathHelper.sin(f4 * 2.0F)), -50.0F);
		float f7 = 50.0F + 175.0F * MathHelper.sin(f4);
		GL11.glScalef(f7, -f7, f7);
		GL11.glRotatef(900.0F * MathHelper.abs(MathHelper.sin(f4)), 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(6.0F * MathHelper.cos(f * 8.0F), 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(6.0F * MathHelper.cos(f * 8.0F), 0.0F, 0.0F, 1.0F);
		net.minecraft.client.renderer.entity.RenderManager.instance.itemRenderer.renderItem(mc.thePlayer, itemActivationItem, 0);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glEnable(GL11.GL_CULL_FACE);
	}
}
