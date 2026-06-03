package ganymedes01.etfuturum.recipebook;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeBookRecipe {
	private final int id;
	private final IRecipe recipe;
	private final ItemStack output;
	private final ItemStack[] ingredients;
	private final String searchText;
	private final int width;
	private final int height;
	private final boolean shapeless;

	private final int recipeType;

	public RecipeBookRecipe(int id, IRecipe recipe, ItemStack output, ItemStack[] ingredients, int width, int height, boolean shapeless) {
		this(id, recipe, output, ingredients, width, height, shapeless, 0);
	}

	public RecipeBookRecipe(int id, IRecipe recipe, ItemStack output, ItemStack[] ingredients, int width, int height, boolean shapeless, int recipeType) {
		this.id = id;
		this.recipe = recipe;
		this.output = output;
		this.ingredients = ingredients;
		this.searchText = output.getDisplayName().toLowerCase();
		this.width = width;
		this.height = height;
		this.shapeless = shapeless;
		this.recipeType = recipeType;
	}

	public int getRecipeType() {
		return recipeType;
	}

	public int getId() {
		return id;
	}

	public IRecipe getRecipe() {
		return recipe;
	}

	public ItemStack getOutput() {
		return output;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isShapeless() {
		return shapeless;
	}

	public boolean matchesGrid(int gridWidth, int gridHeight) {
		if (shapeless) {
			return ingredients.length <= gridWidth * gridHeight;
		}
		return width <= gridWidth && height <= gridHeight;
	}

	public ItemStack[] getIngredients() {
		return ingredients;
	}

	public ItemStack getIngredient(int slot) {
		if (slot >= ingredients.length) return null;
		return ingredients[slot];
	}

	public ItemStack getIngredientForSlot(int slot, int gridWidth, int gridHeight) {
		if (shapeless) {
			return slot < ingredients.length ? ingredients[slot] : null;
		}
		int row = slot / gridWidth;
		int col = slot % gridWidth;
		if (col < width && row < height) {
			int idx = col + row * width;
			if (idx < ingredients.length) {
				return ingredients[idx];
			}
		}
		return null;
	}

	public boolean matchesSearch(String search) {
		return search == null || search.isEmpty() || searchText.contains(search.toLowerCase());
	}

	public boolean isCraftable(InventoryPlayer inventory) {
		return getCraftableCount(inventory, 1) > 0;
	}

	public int getCraftableCount(InventoryPlayer inventory, int limit) {
		List<ItemStack> available = new ArrayList<ItemStack>();
		for (int i = 0; i < inventory.mainInventory.length; ++i) {
			ItemStack stack = inventory.mainInventory[i];
			if (stack != null && stack.getItem() != null) {
				available.add(stack.copy());
			}
		}

		int count = 0;
		while (count < limit && consumeIngredients(available)) {
			++count;
		}
		return count;
	}

	public int getMaxIngredientStackSize() {
		int max = 64;
		for (ItemStack ingredient : ingredients) {
			if (ingredient != null) {
				max = Math.min(max, ingredient.getMaxStackSize());
			}
		}
		return max;
	}

	private boolean consumeIngredients(List<ItemStack> available) {
		for (ItemStack ingredient : ingredients) {
			if (ingredient == null) continue;
			boolean matched = false;
			for (ItemStack stack : available) {
				if (stack.stackSize > 0 && matches(ingredient, stack)) {
					--stack.stackSize;
					matched = true;
					break;
				}
			}
			if (!matched) return false;
		}
		return true;
	}

	public static boolean matches(ItemStack ingredient, ItemStack stack) {
		if (ingredient == null || stack == null || ingredient.getItem() != stack.getItem()) return false;
		if (ingredient.getItemDamage() != 32767 && ingredient.getItemDamage() != stack.getItemDamage()) return false;
		if (ingredient.hasTagCompound()) {
			return ItemStack.areItemStackTagsEqual(ingredient, stack);
		}
		return true;
	}
}
