package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.client.recipebook.SurvivalRecipeBookGui;
import ganymedes01.etfuturum.offhand.OffhandLayout;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiFurnace.class)
public abstract class MixinGuiFurnace extends GuiContainer {
	private static final ResourceLocation INVENTORY_TEXTURE = new ResourceLocation("textures/gui/container/inventory.png");
	private static final int RECIPE_BOOK_BUTTON_ID = 10;
	private final SurvivalRecipeBookGui etfu$recipeBook = new SurvivalRecipeBookGui();

	public MixinGuiFurnace(Container container) {
		super(container);
	}

	private net.minecraft.tileentity.TileEntityFurnace etfu$getTileEntity() {
		try {
			for (java.lang.reflect.Field f : GuiFurnace.class.getDeclaredFields()) {
				if (f.getType() == net.minecraft.tileentity.TileEntityFurnace.class) {
					f.setAccessible(true);
					return (net.minecraft.tileentity.TileEntityFurnace) f.get(this);
				}
			}
		} catch (Exception ignore) {}
		return null;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/furnace.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		net.minecraft.tileentity.TileEntityFurnace tile = etfu$getTileEntity();
		if (tile != null && tile.isBurning()) {
			int var6 = tile.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(this.guiLeft + 56, this.guiTop + 36 + 12 - var6, 176, 12 - var6, 14, var6 + 1);
			var6 = tile.getCookProgressScaled(24);
			this.drawTexturedModalRect(this.guiLeft + 79, this.guiTop + 34, 176, 14, var6 + 1, 16);
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(new RecipeBookButton(RECIPE_BOOK_BUTTON_ID, this.guiLeft + 20, this.guiTop + 35));
		etfu$updatePositions();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		etfu$updatePositions();
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		etfu$recipeBook.render(this.mc, this.guiLeft, this.guiTop, mouseX, mouseY, partialTicks);
		etfu$recipeBook.renderGhost(this.mc, this.guiLeft, this.guiTop);
		
		java.util.List<String> tooltip = etfu$recipeBook.getTooltip(this.mc, this.guiLeft, this.guiTop, mouseX, mouseY);
		if (tooltip != null && !tooltip.isEmpty()) {
			this.drawHoveringText(tooltip, mouseX, mouseY, this.fontRendererObj);
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (button.id == RECIPE_BOOK_BUTTON_ID) {
			etfu$recipeBook.toggle();
			etfu$updatePositions();
		} else {
			super.actionPerformed(button);
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (etfu$recipeBook.mouseClicked(this.mc, this.guiLeft, this.guiTop, mouseX, mouseY, mouseButton)) {
			return;
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) {
		if (etfu$recipeBook.keyTyped(typedChar, keyCode)) {
			return;
		}
		super.keyTyped(typedChar, keyCode);
	}

	private void etfu$updatePositions() {
		boolean isBookOpen = etfu$recipeBook.isOpen();
		boolean isNarrow = this.width < 379;
		if (isBookOpen && !isNarrow) {
			this.guiLeft = 177 + (this.width - this.xSize - 200) / 2;
		} else {
			this.guiLeft = (this.width - this.xSize) / 2;
		}

		for (Object obj : this.buttonList) {
			if (obj instanceof GuiButton) {
				GuiButton btn = (GuiButton) obj;
				if (btn.id == RECIPE_BOOK_BUTTON_ID) {
					btn.xPosition = this.guiLeft + 20;
					btn.yPosition = this.guiTop + 35;
				}
			}
		}
	}

	private static class RecipeBookButton extends GuiButton {
		private RecipeBookButton(int id, int x, int y) {
			super(id, x, y, OffhandLayout.RECIPE_BOOK_BUTTON_WIDTH, OffhandLayout.RECIPE_BOOK_BUTTON_HEIGHT, "");
		}

		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY) {
			if (!this.visible) return;

			boolean hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			int textureY = OffhandLayout.RECIPE_BOOK_BUTTON_TEXTURE_Y;
			if (hovered) {
				textureY += OffhandLayout.RECIPE_BOOK_BUTTON_HOVER_Y_OFFSET;
			}

			mc.getTextureManager().bindTexture(INVENTORY_TEXTURE);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.drawTexturedModalRect(this.xPosition, this.yPosition, OffhandLayout.RECIPE_BOOK_BUTTON_TEXTURE_X, textureY, this.width, this.height);
		}
	}
}
