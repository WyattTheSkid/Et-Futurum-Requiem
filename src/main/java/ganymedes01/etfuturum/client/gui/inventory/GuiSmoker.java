package ganymedes01.etfuturum.client.gui.inventory;

import ganymedes01.etfuturum.inventory.ContainerSmoker;
import ganymedes01.etfuturum.tileentities.TileEntitySmoker;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiSmoker extends GuiContainer {
	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/smoker.png");
	private final TileEntitySmoker tileFurnace;

	private static final ResourceLocation INVENTORY_TEXTURE = new ResourceLocation("textures/gui/container/inventory.png");
	private static final int RECIPE_BOOK_BUTTON_ID = 10;
	private final ganymedes01.etfuturum.client.recipebook.SurvivalRecipeBookGui etfu$recipeBook = new ganymedes01.etfuturum.client.recipebook.SurvivalRecipeBookGui();

	public GuiSmoker(InventoryPlayer p_i1091_1_, TileEntitySmoker p_i1091_2_) {
		super(new ContainerSmoker(p_i1091_1_, p_i1091_2_));
		this.tileFurnace = p_i1091_2_;
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(new net.minecraft.client.gui.GuiButton(RECIPE_BOOK_BUTTON_ID, this.guiLeft + 20, this.guiTop + 35, ganymedes01.etfuturum.offhand.OffhandLayout.RECIPE_BOOK_BUTTON_WIDTH, ganymedes01.etfuturum.offhand.OffhandLayout.RECIPE_BOOK_BUTTON_HEIGHT, "") {
			@Override
			public void drawButton(net.minecraft.client.Minecraft mc, int mouseX, int mouseY) {
				if (!this.visible) return;
				boolean hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
				int textureY = ganymedes01.etfuturum.offhand.OffhandLayout.RECIPE_BOOK_BUTTON_TEXTURE_Y;
				if (hovered) {
					textureY += ganymedes01.etfuturum.offhand.OffhandLayout.RECIPE_BOOK_BUTTON_HOVER_Y_OFFSET;
				}
				mc.getTextureManager().bindTexture(INVENTORY_TEXTURE);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				this.drawTexturedModalRect(this.xPosition, this.yPosition, ganymedes01.etfuturum.offhand.OffhandLayout.RECIPE_BOOK_BUTTON_TEXTURE_X, textureY, this.width, this.height);
			}
		});
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
	protected void actionPerformed(net.minecraft.client.gui.GuiButton button) {
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
			if (obj instanceof net.minecraft.client.gui.GuiButton) {
				net.minecraft.client.gui.GuiButton btn = (net.minecraft.client.gui.GuiButton) obj;
				if (btn.id == RECIPE_BOOK_BUTTON_ID) {
					btn.xPosition = this.guiLeft + 20;
					btn.yPosition = this.guiTop + 35;
				}
			}
		}
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName());
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
		int k = this.guiLeft;
		int l = this.guiTop;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		if (this.tileFurnace.isBurning()) {
			int i1 = this.tileFurnace.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
			i1 = this.tileFurnace.getCookProgressScaled(24);
			this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
		}
	}
}