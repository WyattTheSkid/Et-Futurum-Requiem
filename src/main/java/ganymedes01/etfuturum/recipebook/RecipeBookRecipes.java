package ganymedes01.etfuturum.recipebook;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class RecipeBookRecipes {
	private static List<RecipeBookRecipe> recipes;
	private static Field shapedWidth;
	private static Field shapedHeight;
	private static Field shapedItems;
	private static Field shapelessItems;

	private RecipeBookRecipes() {
	}

	public static List<RecipeBookRecipe> getRecipes() {
		if (recipes == null) {
			rebuild();
		}
		return recipes;
	}

	public static RecipeBookRecipe getRecipe(int id) {
		List<RecipeBookRecipe> all = getRecipes();
		for (RecipeBookRecipe recipe : all) {
			if (recipe.getId() == id) return recipe;
		}
		return null;
	}

	public static void rebuild() {
		recipes = new ArrayList<RecipeBookRecipe>();
		@SuppressWarnings("unchecked")
		List<IRecipe> craftingRecipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < craftingRecipes.size(); ++i) {
			IRecipe recipe = craftingRecipes.get(i);
			RecipeBookRecipe entry = createEntry(i, recipe);
			if (entry != null) {
				recipes.add(entry);
			}
		}
	}

	private static RecipeBookRecipe createEntry(int id, IRecipe recipe) {
		if (recipe == null || recipe.getRecipeOutput() == null || recipe.getRecipeOutput().getItem() == null) return null;
		ItemStack[] ingredients = getIngredients(recipe);
		if (ingredients == null) return null;
		return new RecipeBookRecipe(id, recipe, recipe.getRecipeOutput().copy(), ingredients);
	}

	private static ItemStack[] getIngredients(IRecipe recipe) {
		if (recipe instanceof ShapedRecipes) {
			return getShapedIngredients((ShapedRecipes) recipe);
		}
		if (recipe instanceof ShapelessRecipes) {
			return getShapelessIngredients(recipe);
		}

		String className = recipe.getClass().getName();
		if (className.endsWith("ShapedOreRecipe")) {
			return getForgeShapedIngredients(recipe);
		}
		if (className.endsWith("ShapelessOreRecipe")) {
			return getForgeShapelessIngredients(recipe);
		}
		return null;
	}

	private static ItemStack[] getShapedIngredients(ShapedRecipes recipe) {
		try {
			if (shapedWidth == null) {
				shapedWidth = ReflectionHelper.findField(ShapedRecipes.class, "recipeWidth", "field_77576_b");
				shapedHeight = ReflectionHelper.findField(ShapedRecipes.class, "recipeHeight", "field_77577_c");
				shapedItems = ReflectionHelper.findField(ShapedRecipes.class, "recipeItems", "field_77574_d");
			}
			int width = shapedWidth.getInt(recipe);
			int height = shapedHeight.getInt(recipe);
			if (width > 2 || height > 2) return null;
			ItemStack[] raw = (ItemStack[]) shapedItems.get(recipe);
			ItemStack[] ingredients = new ItemStack[4];
			for (int y = 0; y < height; ++y) {
				for (int x = 0; x < width; ++x) {
					ItemStack stack = raw[x + y * width];
					ingredients[x + y * 2] = stack != null ? stack.copy() : null;
				}
			}
			return ingredients;
		} catch (Exception ignored) {
			return null;
		}
	}

	private static ItemStack[] getShapelessIngredients(IRecipe recipe) {
		try {
			if (shapelessItems == null) {
				shapelessItems = ReflectionHelper.findField(ShapelessRecipes.class, "recipeItems", "field_77579_b");
			}
			@SuppressWarnings("unchecked")
			List<ItemStack> raw = (List<ItemStack>) shapelessItems.get(recipe);
			return getShapelessIngredients(raw);
		} catch (Exception ignored) {
			return null;
		}
	}

	private static ItemStack[] getForgeShapedIngredients(IRecipe recipe) {
		try {
			Field widthField = ReflectionHelper.findField(recipe.getClass(), "width");
			Field heightField = ReflectionHelper.findField(recipe.getClass(), "height");
			Field inputField = ReflectionHelper.findField(recipe.getClass(), "input");
			int width = widthField.getInt(recipe);
			int height = heightField.getInt(recipe);
			if (width > 2 || height > 2) return null;
			Object[] raw = (Object[]) inputField.get(recipe);
			ItemStack[] ingredients = new ItemStack[4];
			for (int y = 0; y < height; ++y) {
				for (int x = 0; x < width; ++x) {
					ingredients[x + y * 2] = firstStack(raw[x + y * width]);
				}
			}
			return ingredients;
		} catch (Exception ignored) {
			return null;
		}
	}

	private static ItemStack[] getForgeShapelessIngredients(IRecipe recipe) {
		try {
			Field inputField = ReflectionHelper.findField(recipe.getClass(), "input");
			@SuppressWarnings("unchecked")
			List<Object> raw = (List<Object>) inputField.get(recipe);
			return getShapelessIngredients(raw);
		} catch (Exception ignored) {
			return null;
		}
	}

	private static ItemStack[] getShapelessIngredients(List<?> raw) {
		if (raw == null || raw.size() > 4) return null;
		ItemStack[] ingredients = new ItemStack[4];
		for (int i = 0; i < raw.size(); ++i) {
			ingredients[i] = firstStack(raw.get(i));
			if (ingredients[i] == null) return null;
		}
		return ingredients;
	}

	private static ItemStack firstStack(Object ingredient) {
		if (ingredient == null) return null;
		if (ingredient instanceof ItemStack) return ((ItemStack) ingredient).copy();
		if (ingredient instanceof List) {
			for (Object object : (List<?>) ingredient) {
				if (object instanceof ItemStack) {
					return ((ItemStack) object).copy();
				}
			}
		}
		return null;
	}
}
