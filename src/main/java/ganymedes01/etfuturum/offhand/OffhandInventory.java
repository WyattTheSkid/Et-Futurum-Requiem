package ganymedes01.etfuturum.offhand;

import ganymedes01.etfuturum.storage.EtFuturumPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public final class OffhandInventory {
	public static final int OFFHAND_INVENTORY_INDEX = 40;
	public static final int OFFHAND_CONTAINER_SLOT = 45;

	private OffhandInventory() {
	}

	public static ItemStack getOffhandStack(EntityPlayer player) {
		if (player == null) return null;
		return EtFuturumPlayer.get(player).getOffhandStack();
	}

	public static void setOffhandStack(EntityPlayer player, ItemStack stack) {
		if (player == null) return;
		EtFuturumPlayer.get(player).setOffhandStack(normalizeStack(stack));
	}

	public static ItemStack getOffhandStack(InventoryPlayer inventory) {
		return inventory == null ? null : getOffhandStack(inventory.player);
	}

	public static void setOffhandStack(InventoryPlayer inventory, ItemStack stack) {
		if (inventory != null) {
			setOffhandStack(inventory.player, stack);
		}
	}

	public static ItemStack decrOffhandStack(EntityPlayer player, int amount) {
		ItemStack stack = getOffhandStack(player);
		if (stack == null) return null;

		if (stack.stackSize <= amount) {
			setOffhandStack(player, null);
			return stack;
		}

		ItemStack result = stack.splitStack(amount);
		if (stack.stackSize <= 0) {
			setOffhandStack(player, null);
		}
		return result;
	}

	public static void dropOffhand(EntityPlayer player) {
		ItemStack stack = getOffhandStack(player);
		if (stack != null) {
			player.func_146097_a(stack, true, false);
			setOffhandStack(player, null);
		}
	}

	public static ItemStack normalizeStack(ItemStack stack) {
		if (stack == null || stack.stackSize <= 0 || stack.getItem() == null) return null;
		return stack;
	}

	public static ItemStack copyStack(ItemStack stack) {
		stack = normalizeStack(stack);
		return stack == null ? null : stack.copy();
	}
}
