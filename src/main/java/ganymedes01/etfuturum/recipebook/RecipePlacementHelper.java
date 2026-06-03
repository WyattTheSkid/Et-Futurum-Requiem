package ganymedes01.etfuturum.recipebook;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public final class RecipePlacementHelper {
	private RecipePlacementHelper() {
	}

	public static boolean placeRecipe(EntityPlayerMP player, int recipeId) {
		return placeRecipe(player, recipeId, false);
	}

	public static boolean placeRecipe(EntityPlayerMP player, int recipeId, boolean craftAll) {
		Container openContainer = player.openContainer;
		int matrixSize;
		int gridWidth;
		int gridHeight;
		IInventory craftMatrix;
		boolean isFurnace = openContainer instanceof net.minecraft.inventory.ContainerFurnace ||
				openContainer instanceof ganymedes01.etfuturum.inventory.ContainerSmoker ||
				openContainer instanceof ganymedes01.etfuturum.inventory.ContainerBlastFurnace;
		int slotOffset = isFurnace ? 0 : 1;
		
		if (openContainer instanceof ContainerPlayer) {
			matrixSize = 4;
			gridWidth = 2;
			gridHeight = 2;
			craftMatrix = ((ContainerPlayer) openContainer).craftMatrix;
		} else if (openContainer instanceof ContainerWorkbench) {
			matrixSize = 9;
			gridWidth = 3;
			gridHeight = 3;
			craftMatrix = ((ContainerWorkbench) openContainer).craftMatrix;
		} else if (isFurnace) {
			matrixSize = 1;
			gridWidth = 1;
			gridHeight = 1;
			craftMatrix = null;
		} else {
			return false;
		}

		RecipeBookRecipe recipe = RecipeBookRecipes.getRecipe(recipeId);
		if (recipe == null) return false;
		if (!recipe.matchesGrid(gridWidth, gridHeight)) return false;

		ItemStack[] inventorySnapshot = copyInventory(player.inventory.mainInventory);
		ItemStack[] craftSnapshot = new ItemStack[matrixSize];
		for (int i = 0; i < matrixSize; ++i) {
			craftSnapshot[i] = copyStack(openContainer.getSlot(slotOffset + i).getStack());
		}

		if (!clearCraftingGrid(player, openContainer, matrixSize, slotOffset)) {
			restore(player, openContainer, inventorySnapshot, craftSnapshot, slotOffset);
			return false;
		}

		int amount = craftAll ? recipe.getCraftableCount(player.inventory, recipe.getMaxIngredientStackSize()) : recipe.isCraftable(player.inventory) ? 1 : 0;
		if (amount <= 0) {
			restore(player, openContainer, inventorySnapshot, craftSnapshot, slotOffset);
			return false;
		}

		for (int i = 0; i < matrixSize; ++i) {
			ItemStack ingredient = recipe.getIngredientForSlot(i, gridWidth, gridHeight);
			if (ingredient == null) continue;
			ItemStack placed = removeMatching(player, ingredient, amount);
			if (placed == null) {
				restore(player, openContainer, inventorySnapshot, craftSnapshot, slotOffset);
				return false;
			}
			openContainer.getSlot(slotOffset + i).putStack(placed);
		}

		if (craftMatrix != null) {
			openContainer.onCraftMatrixChanged(craftMatrix);
		}
		openContainer.detectAndSendChanges();
		return true;
	}

	private static boolean clearCraftingGrid(EntityPlayerMP player, Container container, int matrixSize, int slotOffset) {
		for (int i = 0; i < matrixSize; ++i) {
			Slot slot = container.getSlot(slotOffset + i);
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

	private static void restore(EntityPlayerMP player, Container container, ItemStack[] inventorySnapshot, ItemStack[] craftSnapshot, int slotOffset) {
		for (int i = 0; i < inventorySnapshot.length; ++i) {
			player.inventory.mainInventory[i] = copyStack(inventorySnapshot[i]);
		}
		for (int i = 0; i < craftSnapshot.length; ++i) {
			container.getSlot(slotOffset + i).putStack(copyStack(craftSnapshot[i]));
		}
		if (container instanceof ContainerPlayer) {
			container.onCraftMatrixChanged(((ContainerPlayer) container).craftMatrix);
		} else if (container instanceof ContainerWorkbench) {
			container.onCraftMatrixChanged(((ContainerWorkbench) container).craftMatrix);
		}
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
