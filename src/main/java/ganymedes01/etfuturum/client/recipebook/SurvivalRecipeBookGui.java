package ganymedes01.etfuturum.client.recipebook;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.network.RecipePlaceMessage;
import ganymedes01.etfuturum.offhand.OffhandLayout;
import ganymedes01.etfuturum.recipebook.RecipeBookRecipe;
import ganymedes01.etfuturum.recipebook.RecipeBookRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class SurvivalRecipeBookGui extends Gui {
	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/recipe_book.png");
	private static final int WIDTH = 147;
	private static final int HEIGHT = 166;
	private static final int RECIPES_PER_PAGE = 20;

	private boolean open;
	private boolean searchFocused;
	private boolean craftableOnly;
	private String search = "";
	private int page;
	private int category;
	private RecipeBookRecipe ghostRecipe;

	public boolean isOpen() {
		return open;
	}

	public void toggle() {
		open = !open;
		if (!open) {
			searchFocused = false;
		}
	}

	public void render(Minecraft mc, int guiLeft, int guiTop, int mouseX, int mouseY, float partialTicks) {
		if (!open) return;

		int x = getBookLeft(guiLeft);
		int y = guiTop;
		mc.getTextureManager().bindTexture(TEXTURE);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(x, y, 1, 1, WIDTH, HEIGHT);

		drawSearchBox(mc, x, y);
		drawCategoryTabs(mc, x, y);
		drawFilterButton(mc, x, y);
		drawRecipeButtons(mc, x, y, mouseX, mouseY);
		drawPageButtons(mc, x, y);
	}

	public void renderGhost(Minecraft mc, int guiLeft, int guiTop) {
		if (!open || ghostRecipe == null) return;

		RenderHelper.enableGUIStandardItemLighting();
		RenderItem renderItem = RenderItem.getInstance();
		for (int i = 0; i < 4; ++i) {
			ItemStack stack = ghostRecipe.getIngredient(i);
			if (stack == null) continue;
			int x = guiLeft + OffhandLayout.SURVIVAL_CRAFTING_GRID_X + (i % 2) * 18;
			int y = guiTop + OffhandLayout.SURVIVAL_CRAFTING_GRID_Y + (i / 2) * 18;
			drawRect(x, y, x + 16, y + 16, 0x4DFFFFFF);
			renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), stack, x, y);
			drawRect(x, y, x + 16, y + 16, 0x4DFFFFFF);
		}
		RenderHelper.disableStandardItemLighting();
	}

	public boolean mouseClicked(Minecraft mc, int guiLeft, int guiTop, int mouseX, int mouseY, int mouseButton) {
		if (!open) return false;

		int x = getBookLeft(guiLeft);
		int y = guiTop;
		for (int i = 0; i < 5; ++i) {
			if (isInside(mouseX, mouseY, x - 27, y + 3 + i * 27, 24, 24)) {
				if (mouseButton != 0) return true;
				category = i;
				page = 0;
				searchFocused = false;
				return true;
			}
		}

		if (mouseX < x || mouseY < y || mouseX >= x + WIDTH || mouseY >= y + HEIGHT) {
			searchFocused = false;
			return false;
		}

		if (mouseButton != 0) return true;
		if (isInside(mouseX, mouseY, x + 25, y + 14, 80, 12)) {
			searchFocused = true;
			return true;
		}
		searchFocused = false;

		if (isInside(mouseX, mouseY, x + 110, y + 12, 26, 16)) {
			craftableOnly = !craftableOnly;
			page = 0;
			return true;
		}

		List<RecipeBookRecipe> recipes = getFilteredRecipes(mc);
		int pages = getPageCount(recipes);
		if (pages > 1 && isInside(mouseX, mouseY, x + 38, y + 137, 12, 17) && page > 0) {
			--page;
			return true;
		}
		if (pages > 1 && isInside(mouseX, mouseY, x + 93, y + 137, 12, 17) && page < pages - 1) {
			++page;
			return true;
		}

		for (int i = 0; i < RECIPES_PER_PAGE; ++i) {
			int recipeIndex = page * RECIPES_PER_PAGE + i;
			if (recipeIndex >= recipes.size()) break;
			int buttonX = x + 11 + 25 * (i % 5);
			int buttonY = y + 31 + 25 * (i / 5);
			if (isInside(mouseX, mouseY, buttonX, buttonY, 25, 25)) {
				RecipeBookRecipe recipe = recipes.get(recipeIndex);
				if (recipe.isCraftable(mc.thePlayer.inventory)) {
					ghostRecipe = null;
					EtFuturum.networkWrapper.sendToServer(new RecipePlaceMessage(recipe.getId(), GuiScreen.isShiftKeyDown()));
				} else {
					ghostRecipe = recipe;
				}
				return true;
			}
		}

		return true;
	}

	public boolean keyTyped(char typedChar, int keyCode) {
		if (!open || !searchFocused) return false;

		if (keyCode == Keyboard.KEY_BACK) {
			if (!search.isEmpty()) {
				search = search.substring(0, search.length() - 1);
				page = 0;
			}
			return true;
		}

		if (keyCode == Keyboard.KEY_ESCAPE || keyCode == Keyboard.KEY_RETURN) {
			searchFocused = false;
			return true;
		}

		if (ChatAllowedCharacters.isAllowedCharacter(typedChar) && search.length() < 50) {
			search += typedChar;
			page = 0;
			return true;
		}
		return false;
	}

	private void drawSearchBox(Minecraft mc, int x, int y) {
		drawRect(x + 24, y + 13, x + 106, y + 27, searchFocused ? 0xFFFFFFFF : 0xFFA0A0A0);
		drawRect(x + 25, y + 14, x + 105, y + 26, 0xFF000000);
		String text = searchFocused && (Minecraft.getSystemTime() / 300L) % 2L == 0L ? search + "_" : search;
		mc.fontRenderer.drawString(text, x + 28, y + 17, 0xFFFFFF);
	}

	private void drawFilterButton(Minecraft mc, int x, int y) {
		drawRect(x + 110, y + 12, x + 136, y + 28, craftableOnly ? 0xFF55AA55 : 0xFF777777);
		mc.fontRenderer.drawString("?", x + 120, y + 16, 0xFFFFFF);
	}

	private void drawCategoryTabs(Minecraft mc, int x, int y) {
		String[] labels = new String[]{"*", "B", "T", "M", "R"};
		for (int i = 0; i < labels.length; ++i) {
			int tabX = x - 27;
			int tabY = y + 3 + i * 27;
			drawRect(tabX, tabY, tabX + 24, tabY + 24, i == category ? 0xFFFFFFFF : 0xFF808080);
			drawRect(tabX + 1, tabY + 1, tabX + 23, tabY + 23, i == category ? 0xFF606060 : 0xFF303030);
			mc.fontRenderer.drawString(labels[i], tabX + 9, tabY + 8, 0xFFFFFF);
		}
	}

	private void drawRecipeButtons(Minecraft mc, int x, int y, int mouseX, int mouseY) {
		List<RecipeBookRecipe> recipes = getFilteredRecipes(mc);
		int pages = getPageCount(recipes);
		if (page >= pages) page = Math.max(0, pages - 1);

		RenderHelper.enableGUIStandardItemLighting();
		RenderItem renderItem = RenderItem.getInstance();
		for (int i = 0; i < RECIPES_PER_PAGE; ++i) {
			int recipeIndex = page * RECIPES_PER_PAGE + i;
			if (recipeIndex >= recipes.size()) break;
			RecipeBookRecipe recipe = recipes.get(recipeIndex);
			int buttonX = x + 11 + 25 * (i % 5);
			int buttonY = y + 31 + 25 * (i / 5);
			boolean craftable = recipe.isCraftable(mc.thePlayer.inventory);
			int color = craftable ? 0xFFB0B0B0 : 0xFF705050;
			if (isInside(mouseX, mouseY, buttonX, buttonY, 25, 25)) color = craftable ? 0xFFFFFFFF : 0xFFFF8080;
			drawRect(buttonX, buttonY, buttonX + 25, buttonY + 25, 0xFF000000);
			drawRect(buttonX + 1, buttonY + 1, buttonX + 24, buttonY + 24, color);
			renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), recipe.getOutput(), buttonX + 4, buttonY + 4);
			renderItem.renderItemOverlayIntoGUI(mc.fontRenderer, mc.getTextureManager(), recipe.getOutput(), buttonX + 4, buttonY + 4);
		}
		RenderHelper.disableStandardItemLighting();
	}

	private void drawPageButtons(Minecraft mc, int x, int y) {
		List<RecipeBookRecipe> recipes = getFilteredRecipes(mc);
		int pages = getPageCount(recipes);
		if (pages > 1) {
			String pageText = (page + 1) + "/" + pages;
			mc.fontRenderer.drawString(pageText, x + 73 - mc.fontRenderer.getStringWidth(pageText) / 2, y + 141, 0xFFFFFF);
			if (page > 0) drawRect(x + 38, y + 137, x + 50, y + 154, 0xFFFFFFFF);
			if (page < pages - 1) drawRect(x + 93, y + 137, x + 105, y + 154, 0xFFFFFFFF);
		}
	}

	private List<RecipeBookRecipe> getFilteredRecipes(Minecraft mc) {
		List<RecipeBookRecipe> filtered = new ArrayList<RecipeBookRecipe>();
		for (RecipeBookRecipe recipe : RecipeBookRecipes.getRecipes()) {
			if (!matchesCategory(recipe)) continue;
			if (!recipe.matchesSearch(search)) continue;
			if (craftableOnly && !recipe.isCraftable(mc.thePlayer.inventory)) continue;
			filtered.add(recipe);
		}
		return filtered;
	}

	private boolean matchesCategory(RecipeBookRecipe recipe) {
		if (category == 0) return true;
		CreativeTabs tab = recipe.getOutput().getItem().getCreativeTab();
		switch (category) {
			case 1:
				return tab == CreativeTabs.tabBlock || tab == CreativeTabs.tabDecorations;
			case 2:
				return tab == CreativeTabs.tabTools || tab == CreativeTabs.tabCombat;
			case 3:
				return tab == CreativeTabs.tabMisc || tab == CreativeTabs.tabMaterials || tab == CreativeTabs.tabFood;
			case 4:
				return tab == CreativeTabs.tabRedstone;
			default:
				return true;
		}
	}

	private int getPageCount(List<RecipeBookRecipe> recipes) {
		return Math.max(1, (recipes.size() + RECIPES_PER_PAGE - 1) / RECIPES_PER_PAGE);
	}

	private int getBookLeft(int guiLeft) {
		int left = guiLeft - WIDTH;
		return left >= 0 ? left : guiLeft + 176;
	}

	private boolean isInside(int mouseX, int mouseY, int x, int y, int width, int height) {
		return mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
	}
}
