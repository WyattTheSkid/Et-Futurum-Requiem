package ganymedes01.etfuturum.offhand;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import ganymedes01.etfuturum.configuration.configs.ConfigFunctions;
import ganymedes01.etfuturum.core.utils.Logger;
import ganymedes01.etfuturum.network.OffhandNetwork;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class OffhandEventHandler {
	public static final OffhandEventHandler INSTANCE = new OffhandEventHandler();

	private static final String LAST_SYNC_HASH_KEY = "etfu$offhandLastSyncHash";

	private OffhandEventHandler() {
	}

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event) {
		if (event.player instanceof EntityPlayerMP player) {
			syncAll(player);
			if (ConfigFunctions.offhandDebugLogging) {
				Logger.info("Offhand synced to player " + player.getCommandSenderName() + " on login");
			}
		}
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (event.player instanceof EntityPlayerMP player) {
			syncAll(player);
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerChangedDimensionEvent event) {
		if (event.player instanceof EntityPlayerMP player) {
			syncAll(player);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase != TickEvent.Phase.END || event.player.worldObj.isRemote || !(event.player instanceof EntityPlayerMP player)) return;

		int currentHash = getStackSyncHash(OffhandInventory.getOffhandStack(player));
		int lastHash = player.getEntityData().getInteger(LAST_SYNC_HASH_KEY);
		if (currentHash != lastHash) {
			player.getEntityData().setInteger(LAST_SYNC_HASH_KEY, currentHash);
			OffhandNetwork.syncOffhandChanged(player);
		}

		if (player.ticksExisted % 100 == 0) {
			OffhandNetwork.syncVisibleOffhandsToPlayer(player);
		}
	}

	private static void syncAll(EntityPlayerMP player) {
		OffhandNetwork.syncOffhandToPlayer(player);
		OffhandNetwork.syncOffhandToTracking(player);
		OffhandNetwork.syncVisibleOffhandsToPlayer(player);
		player.getEntityData().setInteger(LAST_SYNC_HASH_KEY, getStackSyncHash(OffhandInventory.getOffhandStack(player)));
	}

	private static int getStackSyncHash(ItemStack stack) {
		stack = OffhandInventory.normalizeStack(stack);
		if (stack == null) return 0;

		int hash = Item.getIdFromItem(stack.getItem());
		hash = 31 * hash + stack.stackSize;
		hash = 31 * hash + stack.getItemDamage();
		hash = 31 * hash + (stack.stackTagCompound != null ? stack.stackTagCompound.hashCode() : 0);
		return hash;
	}
}
