package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.client.recipebook.SurvivalRecipeBookGui;
import ganymedes01.etfuturum.offhand.OffhandLayout;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiInventory.class)
public abstract class MixinGuiInventory extends InventoryEffectRenderer {
	private static final ResourceLocation INVENTORY_TEXTURE = new ResourceLocation("textures/gui/container/inventory.png");
	private static final int RECIPE_BOOK_BUTTON_ID = 10;
	private final SurvivalRecipeBookGui etfu$recipeBook = new SurvivalRecipeBookGui();

	public MixinGuiInventory(Container container) {
		super(container);
	}

	@Inject(method = "initGui", at = @At("TAIL"))
	private void etfu$addRecipeBookPlaceholder(CallbackInfo ci) {
		if (this.mc.playerController.isInCreativeMode()) return;

		this.buttonList.add(new RecipeBookButton(RECIPE_BOOK_BUTTON_ID, this.guiLeft + OffhandLayout.SURVIVAL_RECIPE_BOOK_BUTTON_X, this.guiTop + OffhandLayout.SURVIVAL_RECIPE_BOOK_BUTTON_Y));
	}

	@Inject(method = "drawGuiContainerForegroundLayer", at = @At("HEAD"), cancellable = true)
	private void etfu$drawModernCraftingLabel(int mouseX, int mouseY, CallbackInfo ci) {
		this.fontRendererObj.drawString(I18n.format("container.crafting"), OffhandLayout.SURVIVAL_TITLE_X, OffhandLayout.SURVIVAL_TITLE_Y, 4210752);
		ci.cancel();
	}

	@Inject(method = "drawScreen", at = @At("RETURN"))
	private void etfu$drawRecipeBook(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
		etfu$recipeBook.render(this.mc, this.guiLeft, this.guiTop, mouseX, mouseY, partialTicks);
		etfu$recipeBook.renderGhost(this.mc, this.guiLeft, this.guiTop);
	}

	@Inject(method = "actionPerformed", at = @At("HEAD"), cancellable = true)
	private void etfu$toggleRecipeBook(GuiButton button, CallbackInfo ci) {
		if (button.id == RECIPE_BOOK_BUTTON_ID) {
			etfu$recipeBook.toggle();
			ci.cancel();
		}
	}

	@Inject(method = "mouseClicked", at = @At("HEAD"), cancellable = true)
	private void etfu$recipeBookMouseClicked(int mouseX, int mouseY, int mouseButton, CallbackInfo ci) {
		if (etfu$recipeBook.mouseClicked(this.mc, this.guiLeft, this.guiTop, mouseX, mouseY, mouseButton)) {
			ci.cancel();
		}
	}

	@Inject(method = "keyTyped", at = @At("HEAD"), cancellable = true)
	private void etfu$recipeBookKeyTyped(char typedChar, int keyCode, CallbackInfo ci) {
		if (etfu$recipeBook.keyTyped(typedChar, keyCode)) {
			ci.cancel();
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
