package ganymedes01.etfuturum.recipebook;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class RecipeBookRecipes {
	private static List<RecipeBookRecipe> recipes;
	private static Field shapedWidth;
	private static Field shapedHeight;
	private static Field shapedItems;
	private static Field shapelessItems;
	private static final Set<Integer> unlockedRecipes = new HashSet<>();
	private static final Set<Integer> defaultUnlockedRecipes = new HashSet<>();

	public static Set<Integer> getUnlockedRecipes() {
		return unlockedRecipes;
	}

	public static void setUnlockedRecipes(int[] ids) {
		unlockedRecipes.clear();
		for (int id : ids) {
			unlockedRecipes.add(id);
		}
	}

	public static boolean isUnlocked(int id) {
		return defaultUnlockedRecipes.contains(id) || unlockedRecipes.contains(id);
	}

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

	/**
	 * Returns a unique key for an ItemStack based on item + damage for dedup purposes.
	 */
	private static String getOutputKey(ItemStack stack) {
		if (stack == null || stack.getItem() == null) return null;
		return net.minecraft.item.Item.itemRegistry.getNameForObject(stack.getItem()) + ":" + stack.getItemDamage();
	}

	public static void rebuild() {
		recipes = new ArrayList<RecipeBookRecipe>();
		defaultUnlockedRecipes.clear();
		@SuppressWarnings("unchecked")
		List<IRecipe> craftingRecipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < craftingRecipes.size(); ++i) {
			IRecipe recipe = craftingRecipes.get(i);
			RecipeBookRecipe entry = createEntry(i, recipe);
			if (entry != null) {
				recipes.add(entry);
				// Crafting table recipe is always unlocked by default
				if (entry.getOutput() != null && entry.getOutput().getItem() == net.minecraft.item.Item.getItemFromBlock(net.minecraft.init.Blocks.crafting_table)) {
					defaultUnlockedRecipes.add(entry.getId());
				}
			}
		}

		int nextId = recipes.size();

		// Furnace smelting recipes - deduplicate by output item+damage
		nextId = addSmeltingRecipes(nextId, 1, null);

		// Smoker recipes
		nextId = addSmeltingRecipes(nextId, 2, "smoker");

		// Blast furnace recipes
		nextId = addSmeltingRecipes(nextId, 3, "blastfurnace");
	}

	/**
	 * Add smelting recipes for a given type, deduplicating by output.
	 * In vanilla 1.21.4, all smelting recipes are unlocked by obtaining any of their input items,
	 * so we auto-unlock all of them by default.
	 */
	@SuppressWarnings("unchecked")
	private static int addSmeltingRecipes(int nextId, int recipeType, String furnaceType) {
		try {
			java.util.Map<ItemStack, ItemStack> smeltingList;
			if (furnaceType == null) {
				smeltingList = net.minecraft.item.crafting.FurnaceRecipes.smelting().getSmeltingList();
			} else if ("smoker".equals(furnaceType)) {
				if (ganymedes01.etfuturum.recipes.SmokerRecipes.smelting() == null) return nextId;
				smeltingList = ganymedes01.etfuturum.recipes.SmokerRecipes.smelting().smeltingList;
			} else if ("blastfurnace".equals(furnaceType)) {
				if (ganymedes01.etfuturum.recipes.BlastFurnaceRecipes.smelting() == null) return nextId;
				smeltingList = ganymedes01.etfuturum.recipes.BlastFurnaceRecipes.smelting().smeltingList;
			} else {
				return nextId;
			}

			if (smeltingList == null) return nextId;

			// Deduplicate by output item+damage - only keep the first recipe for each unique output
			Set<String> seenOutputs = new HashSet<>();
			for (java.util.Map.Entry<ItemStack, ItemStack> entry : smeltingList.entrySet()) {
				ItemStack input = entry.getKey();
				ItemStack output = entry.getValue();
				if (input == null || output == null) continue;

				String outputKey = getOutputKey(output);
				if (outputKey == null || seenOutputs.contains(outputKey)) continue;
				seenOutputs.add(outputKey);

				int id = nextId++;
				recipes.add(new RecipeBookRecipe(id, null, output, new ItemStack[]{input}, 1, 1, true, recipeType));
				// Auto-unlock all smelting recipes (vanilla behavior: unlocked by obtaining any input)
				defaultUnlockedRecipes.add(id);
			}
		} catch (Exception ignore) {}
		return nextId;
	}

	private static RecipeBookRecipe createEntry(int id, IRecipe recipe) {
		if (recipe == null || recipe.getRecipeOutput() == null || recipe.getRecipeOutput().getItem() == null) return null;
		ItemStack[] ingredients = null;
		int width = 0;
		int height = 0;
		boolean shapeless = false;

		if (recipe instanceof ShapedRecipes) {
			ShapedRecipes shaped = (ShapedRecipes) recipe;
			try {
				if (shapedWidth == null) {
					shapedWidth = ReflectionHelper.findField(ShapedRecipes.class, "recipeWidth", "field_77576_b");
					shapedHeight = ReflectionHelper.findField(ShapedRecipes.class, "recipeHeight", "field_77577_c");
					shapedItems = ReflectionHelper.findField(ShapedRecipes.class, "recipeItems", "field_77574_d");
				}
				width = shapedWidth.getInt(shaped);
				height = shapedHeight.getInt(shaped);
				if (width > 3 || height > 3) return null;
				ItemStack[] raw = (ItemStack[]) shapedItems.get(shaped);
				ingredients = new ItemStack[width * height];
				for (int i = 0; i < ingredients.length; ++i) {
					ingredients[i] = raw[i] != null ? raw[i].copy() : null;
				}
			} catch (Exception e) {
				return null;
			}
		} else if (recipe instanceof ShapelessRecipes) {
			shapeless = true;
			try {
				if (shapelessItems == null) {
					shapelessItems = ReflectionHelper.findField(ShapelessRecipes.class, "recipeItems", "field_77579_b");
				}
				@SuppressWarnings("unchecked")
				List<ItemStack> raw = (List<ItemStack>) shapelessItems.get(recipe);
				if (raw == null || raw.size() > 9) return null;
				ingredients = new ItemStack[raw.size()];
				for (int i = 0; i < raw.size(); ++i) {
					ingredients[i] = raw.get(i) != null ? raw.get(i).copy() : null;
				}
			} catch (Exception e) {
				return null;
			}
		} else {
			String className = recipe.getClass().getName();
			if (className.endsWith("ShapedOreRecipe")) {
				try {
					Field widthField = ReflectionHelper.findField(recipe.getClass(), "width");
					Field heightField = ReflectionHelper.findField(recipe.getClass(), "height");
					Field inputField = ReflectionHelper.findField(recipe.getClass(), "input");
					width = widthField.getInt(recipe);
					height = heightField.getInt(recipe);
					if (width > 3 || height > 3) return null;
					Object[] raw = (Object[]) inputField.get(recipe);
					ingredients = new ItemStack[width * height];
					for (int i = 0; i < ingredients.length; ++i) {
						ingredients[i] = firstStack(raw[i]);
					}
				} catch (Exception e) {
					return null;
				}
			} else if (className.endsWith("ShapelessOreRecipe")) {
				shapeless = true;
				try {
					Field inputField = ReflectionHelper.findField(recipe.getClass(), "input");
					@SuppressWarnings("unchecked")
					List<Object> raw = (List<Object>) inputField.get(recipe);
					if (raw == null || raw.size() > 9) return null;
					ingredients = new ItemStack[raw.size()];
					for (int i = 0; i < raw.size(); ++i) {
						ingredients[i] = firstStack(raw.get(i));
					}
				} catch (Exception e) {
					return null;
				}
			} else {
				return null;
			}
		}

		if (ingredients == null) return null;
		return new RecipeBookRecipe(id, recipe, recipe.getRecipeOutput().copy(), ingredients, width, height, shapeless);
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
