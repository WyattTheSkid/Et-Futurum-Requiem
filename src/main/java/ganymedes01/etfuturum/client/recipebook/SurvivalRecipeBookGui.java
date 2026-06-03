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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
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

	private int getGridWidth(Minecraft mc) {
		if (mc.thePlayer == null) return 2;
		net.minecraft.inventory.Container container = mc.thePlayer.openContainer;
		if (container instanceof ContainerWorkbench) {
			return 3;
		}
		if (container instanceof net.minecraft.inventory.ContainerFurnace ||
				container instanceof ganymedes01.etfuturum.inventory.ContainerSmoker ||
				container instanceof ganymedes01.etfuturum.inventory.ContainerBlastFurnace) {
			return 1;
		}
		return 2;
	}

	private int getGridHeight(Minecraft mc) {
		if (mc.thePlayer == null) return 2;
		net.minecraft.inventory.Container container = mc.thePlayer.openContainer;
		if (container instanceof ContainerWorkbench) {
			return 3;
		}
		if (container instanceof net.minecraft.inventory.ContainerFurnace ||
				container instanceof ganymedes01.etfuturum.inventory.ContainerSmoker ||
				container instanceof ganymedes01.etfuturum.inventory.ContainerBlastFurnace) {
			return 1;
		}
		return 2;
	}

	private void checkCategoryVisibility(Minecraft mc) {
		List<Integer> visibleTabs = getVisibleTabs(mc);
		if (!visibleTabs.contains(category)) {
			category = 0;
			page = 0;
		}
	}

	private void etfu$setup2DRenderStates() {
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
	}

	public void render(Minecraft mc, int guiLeft, int guiTop, int mouseX, int mouseY, float partialTicks) {
		if (!open) return;

		checkCategoryVisibility(mc);

		etfu$setup2DRenderStates();

		int x = getBookLeft(guiLeft);
		int y = guiTop;
		mc.getTextureManager().bindTexture(TEXTURE);
		drawTexturedModalRect(x, y, 1, 1, WIDTH, HEIGHT);

		drawSearchBox(mc, x, y);
		drawCategoryTabs(mc, x, y, mouseX, mouseY);
		drawFilterButton(mc, x, y, mouseX, mouseY);
		drawRecipeButtons(mc, x, y, mouseX, mouseY);
		drawPageButtons(mc, x, y, mouseX, mouseY);
	}

	public void renderGhost(Minecraft mc, int guiLeft, int guiTop) {
		if (!open || ghostRecipe == null) return;

		RenderHelper.enableGUIStandardItemLighting();
		RenderItem renderItem = RenderItem.getInstance();
		int gridW = getGridWidth(mc);
		int gridH = getGridHeight(mc);

		// Determine correct slot positions based on container type
		int startX;
		int startY;
		net.minecraft.inventory.Container container = mc.thePlayer != null ? mc.thePlayer.openContainer : null;
		boolean isFurnace = container instanceof net.minecraft.inventory.ContainerFurnace ||
				container instanceof ganymedes01.etfuturum.inventory.ContainerSmoker ||
				container instanceof ganymedes01.etfuturum.inventory.ContainerBlastFurnace;

		if (isFurnace) {
			// Furnace input slot position (slot 0 in vanilla furnace GUI)
			startX = 56;
			startY = 17;
		} else if (container instanceof ContainerWorkbench) {
			// Crafting table grid starts at 30, 17
			startX = 30;
			startY = 17;
		} else {
			// Player inventory 2x2 crafting grid
			startX = OffhandLayout.SURVIVAL_CRAFTING_GRID_X;
			startY = OffhandLayout.SURVIVAL_CRAFTING_GRID_Y;
		}

		int matrixSize = gridW * gridH;
		for (int i = 0; i < matrixSize; ++i) {
			ItemStack stack = ghostRecipe.getIngredientForSlot(i, gridW, gridH);
			if (stack == null) continue;
			int x = guiLeft + startX + (i % gridW) * 18;
			int y = guiTop + startY + (i / gridW) * 18;
			drawRect(x, y, x + 16, y + 16, 0x4DFFFFFF);
			renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), stack, x, y);
			drawRect(x, y, x + 16, y + 16, 0x4DFFFFFF);
		}
		RenderHelper.disableStandardItemLighting();
	}

	public List<String> getTooltip(Minecraft mc, int guiLeft, int guiTop, int mouseX, int mouseY) {
		if (!open) return null;

		int x = getBookLeft(guiLeft);
		int y = guiTop;

		// Filter button tooltip
		if (isInside(mouseX, mouseY, x + 110, y + 12, 26, 16)) {
			List<String> list = new ArrayList<String>();
			list.add(translate("gui.recipebook.toggleRecipes.craftable", "Showing Craftable"));
			return list;
		}

		// Tab tooltips
		List<Integer> visibleTabs = getVisibleTabs(mc);
		for (int idx = 0; idx < visibleTabs.size(); ++idx) {
			int i = visibleTabs.get(idx);
			int tabX = x - (i == category ? 32 : 30);
			int tabY = y + 3 + idx * 27;
			if (isInside(mouseX, mouseY, tabX, tabY, 30, 27)) {
				List<String> list = new ArrayList<String>();
				if (i == 0) list.add(translate("gui.recipebook.toggleRecipes.all", "Showing All"));
				else if (i == 1) list.add(translate("itemGroup.buildingBlocks", "Blocks"));
				else if (i == 2) list.add("Tools & Combat");
				else if (i == 3) list.add("Misc & Food");
				else if (i == 4) list.add(translate("itemGroup.redstone", "Redstone"));
				return list;
			}
		}

		// Recipe button tooltips
		List<RecipeBookRecipe> recipes = getFilteredRecipes(mc);
		for (int i = 0; i < RECIPES_PER_PAGE; ++i) {
			int recipeIndex = page * RECIPES_PER_PAGE + i;
			if (recipeIndex >= recipes.size()) break;
			RecipeBookRecipe recipe = recipes.get(recipeIndex);
			int buttonX = x + 11 + 25 * (i % 5);
			int buttonY = y + 31 + 25 * (i / 5);
			if (isInside(mouseX, mouseY, buttonX, buttonY, 25, 25)) {
				@SuppressWarnings("unchecked")
				List<String> tooltip = recipe.getOutput().getTooltip(mc.thePlayer, mc.gameSettings.advancedItemTooltips);
				return tooltip;
			}
		}

		return null;
	}

	public boolean mouseClicked(Minecraft mc, int guiLeft, int guiTop, int mouseX, int mouseY, int mouseButton) {
		if (!open) return false;

		checkCategoryVisibility(mc);

		int x = getBookLeft(guiLeft);
		int y = guiTop;
		List<Integer> visibleTabs = getVisibleTabs(mc);
		for (int idx = 0; idx < visibleTabs.size(); ++idx) {
			int i = visibleTabs.get(idx);
			int tabX = x - (i == category ? 32 : 30);
			int tabY = y + 3 + idx * 27;
			if (isInside(mouseX, mouseY, tabX, tabY, (i == category ? 32 : 30), 27)) {
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
		if (search.isEmpty() && !searchFocused) {
			mc.fontRenderer.drawString(translate("gui.recipebook.search_hint", "Search..."), x + 28, y + 17, 0x707070);
		} else {
			String text = searchFocused && (Minecraft.getSystemTime() / 300L) % 2L == 0L ? search + "_" : search;
			mc.fontRenderer.drawString(text, x + 28, y + 17, 0xE0E0E0);
		}
	}

	private void drawFilterButton(Minecraft mc, int x, int y, int mouseX, int mouseY) {
		etfu$setup2DRenderStates();
		mc.getTextureManager().bindTexture(TEXTURE);
		int u = 152 + (craftableOnly ? 28 : 0);
		boolean hover = isInside(mouseX, mouseY, x + 110, y + 12, 26, 16);
		int v = 41 + (hover ? 18 : 0);
		drawTexturedModalRect(x + 110, y + 12, u, v, 26, 16);
	}

	private void drawCategoryTabs(Minecraft mc, int x, int y, int mouseX, int mouseY) {
		List<Integer> visibleTabs = getVisibleTabs(mc);

		// 1. Draw all tab backgrounds first
		etfu$setup2DRenderStates();
		mc.getTextureManager().bindTexture(TEXTURE);
		for (int idx = 0; idx < visibleTabs.size(); ++idx) {
			int i = visibleTabs.get(idx);
			boolean isSelected = (i == category);
			int tabX = x - (isSelected ? 32 : 30);
			int tabY = y + 3 + idx * 27;

			int u = isSelected ? 188 : 153;
			drawTexturedModalRect(tabX, tabY, u, 2, 35, 27);
		}

		// 2. Draw all tab icons with proper lighting
		RenderHelper.enableGUIStandardItemLighting();
		RenderItem renderItem = RenderItem.getInstance();
		for (int idx = 0; idx < visibleTabs.size(); ++idx) {
			int i = visibleTabs.get(idx);
			boolean isSelected = (i == category);
			int tabX = x - (isSelected ? 32 : 30);
			int tabY = y + 3 + idx * 27;
			int offset = isSelected ? -2 : 0;
			if (i == 0) {
				renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(Items.compass), tabX + 9 + offset, tabY + 5);
			} else if (i == 1) {
				renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(Blocks.brick_block), tabX + 9 + offset, tabY + 5);
			} else if (i == 2) {
				renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(Items.iron_axe), tabX + 3 + offset, tabY + 5);
				renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(Items.iron_sword), tabX + 14 + offset, tabY + 5);
			} else if (i == 3) {
				renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(Items.lava_bucket), tabX + 3 + offset, tabY + 5);
				renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(Items.apple), tabX + 14 + offset, tabY + 5);
			} else if (i == 4) {
				renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(Items.redstone), tabX + 9 + offset, tabY + 5);
			}
		}

		RenderHelper.disableStandardItemLighting();
	}

	private void drawRecipeButtons(Minecraft mc, int x, int y, int mouseX, int mouseY) {
		List<RecipeBookRecipe> recipes = getFilteredRecipes(mc);
		int pages = getPageCount(recipes);
		if (page >= pages) page = Math.max(0, pages - 1);

		etfu$setup2DRenderStates();

		mc.getTextureManager().bindTexture(TEXTURE);
		for (int i = 0; i < RECIPES_PER_PAGE; ++i) {
			int recipeIndex = page * RECIPES_PER_PAGE + i;
			if (recipeIndex >= recipes.size()) break;
			RecipeBookRecipe recipe = recipes.get(recipeIndex);
			int buttonX = x + 11 + 25 * (i % 5);
			int buttonY = y + 31 + 25 * (i / 5);
			boolean craftable = recipe.isCraftable(mc.thePlayer.inventory);

			int u = 29;
			if (!craftable) {
				u += 25;
			}
			int v = 206;
			drawTexturedModalRect(buttonX, buttonY, u, v, 25, 25);
		}

		RenderHelper.enableGUIStandardItemLighting();
		RenderItem renderItem = RenderItem.getInstance();
		for (int i = 0; i < RECIPES_PER_PAGE; ++i) {
			int recipeIndex = page * RECIPES_PER_PAGE + i;
			if (recipeIndex >= recipes.size()) break;
			RecipeBookRecipe recipe = recipes.get(recipeIndex);
			int buttonX = x + 11 + 25 * (i % 5);
			int buttonY = y + 31 + 25 * (i / 5);

			renderItem.renderItemAndEffectIntoGUI(mc.fontRenderer, mc.getTextureManager(), recipe.getOutput(), buttonX + 4, buttonY + 4);
			renderItem.renderItemOverlayIntoGUI(mc.fontRenderer, mc.getTextureManager(), recipe.getOutput(), buttonX + 4, buttonY + 4);
		}
		RenderHelper.disableStandardItemLighting();

		GL11.glDisable(GL11.GL_LIGHTING);
		for (int i = 0; i < RECIPES_PER_PAGE; ++i) {
			int recipeIndex = page * RECIPES_PER_PAGE + i;
			if (recipeIndex >= recipes.size()) break;
			int buttonX = x + 11 + 25 * (i % 5);
			int buttonY = y + 31 + 25 * (i / 5);
			if (isInside(mouseX, mouseY, buttonX, buttonY, 25, 25)) {
				drawRect(buttonX, buttonY, buttonX + 25, buttonY + 25, 0x30FFFFFF);
			}
		}
	}

	private void drawPageButtons(Minecraft mc, int x, int y, int mouseX, int mouseY) {
		List<RecipeBookRecipe> recipes = getFilteredRecipes(mc);
		int pages = getPageCount(recipes);
		if (pages > 1) {
			String pageText = (page + 1) + "/" + pages;
			mc.fontRenderer.drawString(pageText, x + 73 - mc.fontRenderer.getStringWidth(pageText) / 2, y + 141, 0xFFFFFF);

			etfu$setup2DRenderStates();
			mc.getTextureManager().bindTexture(TEXTURE);
			if (page > 0) {
				boolean hover = isInside(mouseX, mouseY, x + 38, y + 137, 12, 17);
				int u = 14;
				int v = 208 + (hover ? 18 : 0);
				drawTexturedModalRect(x + 38, y + 137, u, v, 12, 17);
			}
			if (page < pages - 1) {
				boolean hover = isInside(mouseX, mouseY, x + 93, y + 137, 12, 17);
				int u = 1;
				int v = 208 + (hover ? 18 : 0);
				drawTexturedModalRect(x + 93, y + 137, u, v, 12, 17);
			}
		}
	}

	private List<RecipeBookRecipe> getFilteredRecipes(Minecraft mc) {
		List<RecipeBookRecipe> filtered = new ArrayList<RecipeBookRecipe>();
		int gridW = getGridWidth(mc);
		int gridH = getGridHeight(mc);
		int targetType = 0;
		if (mc.thePlayer != null && mc.thePlayer.openContainer != null) {
			net.minecraft.inventory.Container open = mc.thePlayer.openContainer;
			if (open instanceof net.minecraft.inventory.ContainerFurnace) {
				targetType = 1;
			} else if (open instanceof ganymedes01.etfuturum.inventory.ContainerSmoker) {
				targetType = 2;
			} else if (open instanceof ganymedes01.etfuturum.inventory.ContainerBlastFurnace) {
				targetType = 3;
			}
		}
		boolean isCreative = mc.thePlayer != null && mc.thePlayer.capabilities.isCreativeMode;
		for (RecipeBookRecipe recipe : RecipeBookRecipes.getRecipes()) {
			if (recipe.getRecipeType() != targetType) continue;
			if (!isCreative && !RecipeBookRecipes.isUnlocked(recipe.getId())) continue;
			if (!recipe.matchesGrid(gridW, gridH)) continue;
			if (!matchesCategory(recipe)) continue;
			if (!recipe.matchesSearch(search)) continue;
			if (craftableOnly && !recipe.isCraftable(mc.thePlayer.inventory)) continue;
			filtered.add(recipe);
		}
		return filtered;
	}

	private boolean matchesCategory(RecipeBookRecipe recipe) {
		return matchesCategory(recipe, category);
	}

	private boolean matchesCategory(RecipeBookRecipe recipe, int catIndex) {
		if (catIndex == 0) return true;
		CreativeTabs tab = recipe.getOutput().getItem().getCreativeTab();
		switch (catIndex) {
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

	private boolean isTabVisible(Minecraft mc, int tabIndex) {
		if (tabIndex == 0) return true;
		int gridW = getGridWidth(mc);
		int gridH = getGridHeight(mc);
		int targetType = 0;
		if (mc.thePlayer != null && mc.thePlayer.openContainer != null) {
			net.minecraft.inventory.Container open = mc.thePlayer.openContainer;
			if (open instanceof net.minecraft.inventory.ContainerFurnace) {
				targetType = 1;
			} else if (open instanceof ganymedes01.etfuturum.inventory.ContainerSmoker) {
				targetType = 2;
			} else if (open instanceof ganymedes01.etfuturum.inventory.ContainerBlastFurnace) {
				targetType = 3;
			}
		}
		boolean isCreative = mc.thePlayer != null && mc.thePlayer.capabilities.isCreativeMode;
		for (RecipeBookRecipe recipe : RecipeBookRecipes.getRecipes()) {
			if (recipe.getRecipeType() != targetType) continue;
			if (!isCreative && !RecipeBookRecipes.isUnlocked(recipe.getId())) continue;
			if (recipe.matchesGrid(gridW, gridH) && matchesCategory(recipe, tabIndex)) {
				return true;
			}
		}
		return false;
	}

	private List<Integer> getVisibleTabs(Minecraft mc) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; ++i) {
			if (isTabVisible(mc, i)) {
				list.add(i);
			}
		}
		return list;
	}

	private int getPageCount(List<RecipeBookRecipe> recipes) {
		return Math.max(1, (recipes.size() + RECIPES_PER_PAGE - 1) / RECIPES_PER_PAGE);
	}

	private int getBookLeft(int guiLeft) {
		return guiLeft - WIDTH;
	}

	private boolean isInside(int mouseX, int mouseY, int x, int y, int width, int height) {
		return mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
	}

	private String translate(String key, String fallback) {
		String translated = StatCollector.translateToLocal(key);
		return (translated == null || translated.equals(key)) ? fallback : translated;
	}
}
