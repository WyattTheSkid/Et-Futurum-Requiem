package ganymedes01.etfuturum.client.offhand;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SideOnly(Side.CLIENT)
public final class OffhandClientCache {
	private static final Map<UUID, ItemStack> OTHER_PLAYERS_OFFHAND = new HashMap<>();

	public static boolean triggerOffhandEquipReset;

	private OffhandClientCache() {
	}

	public static ItemStack getOffhandForPlayer(EntityPlayer player) {
		if (player == null) return null;
		UUID uuid = player.getUniqueID();
		ItemStack stack = OTHER_PLAYERS_OFFHAND.get(uuid);
		if (OffhandInventory.normalizeStack(stack) == null) {
			OTHER_PLAYERS_OFFHAND.remove(uuid);
			return null;
		}
		return stack;
	}

	public static void setOffhandForPlayer(UUID uuid, ItemStack stack) {
		if (uuid == null) return;
		stack = OffhandInventory.normalizeStack(stack);
		if (stack == null) {
			OTHER_PLAYERS_OFFHAND.remove(uuid);
		} else {
			OTHER_PLAYERS_OFFHAND.put(uuid, stack.copy());
		}
	}

	public static void clear() {
		OTHER_PLAYERS_OFFHAND.clear();
		triggerOffhandEquipReset = true;
	}
}
