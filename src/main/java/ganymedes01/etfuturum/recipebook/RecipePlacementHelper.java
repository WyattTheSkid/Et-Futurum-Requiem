package ganymedes01.etfuturum.recipebook;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public final class RecipePlacementHelper {
	private RecipePlacementHelper() {
	}

	public static boolean placeRecipe(EntityPlayerMP player, int recipeId) {
		return placeRecipe(player, recipeId, false);
	}

	public static boolean placeRecipe(EntityPlayerMP player, int recipeId, boolean craftAll) {
		if (!(player.openContainer instanceof ContainerPlayer)) return false;
		RecipeBookRecipe recipe = RecipeBookRecipes.getRecipe(recipeId);
		if (recipe == null) return false;

		ContainerPlayer container = (ContainerPlayer) player.openContainer;
		ItemStack[] inventorySnapshot = copyInventory(player.inventory.mainInventory);
		ItemStack[] craftSnapshot = new ItemStack[4];
		for (int i = 0; i < 4; ++i) {
			craftSnapshot[i] = copyStack(container.getSlot(1 + i).getStack());
		}

		if (!clearCraftingGrid(player, container)) {
			restore(player, container, inventorySnapshot, craftSnapshot);
			return false;
		}

		int amount = craftAll ? recipe.getCraftableCount(player.inventory, recipe.getMaxIngredientStackSize()) : recipe.isCraftable(player.inventory) ? 1 : 0;
		if (amount <= 0) {
			restore(player, container, inventorySnapshot, craftSnapshot);
			return false;
		}

		for (int i = 0; i < 4; ++i) {
			ItemStack ingredient = recipe.getIngredient(i);
			if (ingredient == null) continue;
			ItemStack placed = removeMatching(player, ingredient, amount);
			if (placed == null) {
				restore(player, container, inventorySnapshot, craftSnapshot);
				return false;
			}
			container.getSlot(1 + i).putStack(placed);
		}

		container.onCraftMatrixChanged(container.craftMatrix);
		container.detectAndSendChanges();
		return true;
	}

	private static boolean clearCraftingGrid(EntityPlayerMP player, ContainerPlayer container) {
		for (int i = 0; i < 4; ++i) {
			Slot slot = container.getSlot(1 + i);
			ItemStack stack = slot.getStack();
			if (stack != null) {
				slot.putStack(null);
				if (!player.inventory.addItemStackToInventory(stack)) {
					return false;
				}
			}
		}
		return true;
	}

	private static ItemStack removeMatching(EntityPlayerMP player, ItemStack ingredient, int amount) {
		ItemStack placed = null;
		int remaining = amount;
		for (int i = 0; i < player.inventory.mainInventory.length; ++i) {
			ItemStack stack = player.inventory.mainInventory[i];
			if (stack != null && stack.stackSize > 0 && RecipeBookRecipe.matches(ingredient, stack) && canStackForPlacement(placed, stack)) {
				if (placed == null) {
					placed = stack.copy();
					placed.stackSize = 0;
				}
				int moved = Math.min(remaining, stack.stackSize);
				placed.stackSize += moved;
				remaining -= moved;
				stack.stackSize -= moved;
				if (stack.stackSize <= 0) {
					player.inventory.mainInventory[i] = null;
				}
				if (remaining <= 0) return placed;
			}
		}
		return null;
	}

	private static boolean canStackForPlacement(ItemStack placed, ItemStack stack) {
		if (placed == null) return true;
		if (placed.getItem() != stack.getItem()) return false;
		if (placed.getItemDamage() != stack.getItemDamage()) return false;
		return ItemStack.areItemStackTagsEqual(placed, stack);
	}

	private static void restore(EntityPlayerMP player, ContainerPlayer container, ItemStack[] inventorySnapshot, ItemStack[] craftSnapshot) {
		for (int i = 0; i < inventorySnapshot.length; ++i) {
			player.inventory.mainInventory[i] = copyStack(inventorySnapshot[i]);
		}
		for (int i = 0; i < craftSnapshot.length; ++i) {
			container.getSlot(1 + i).putStack(copyStack(craftSnapshot[i]));
		}
		container.onCraftMatrixChanged(container.craftMatrix);
		container.detectAndSendChanges();
	}

	private static ItemStack[] copyInventory(ItemStack[] inventory) {
		ItemStack[] copy = new ItemStack[inventory.length];
		for (int i = 0; i < inventory.length; ++i) {
			copy[i] = copyStack(inventory[i]);
		}
		return copy;
	}

	private static ItemStack copyStack(ItemStack stack) {
		return stack != null ? stack.copy() : null;
	}
}
