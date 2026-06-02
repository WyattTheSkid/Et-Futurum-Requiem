package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.management.ServerConfigurationManager;

import java.util.List;

public final class OffhandNetwork {
	public static final int PACKET_SWAP_HANDS = 8;
	public static final int PACKET_SYNC_OFFHAND = 9;
	public static final int PACKET_OFFHAND_USE = 10;
	public static final int PACKET_SYNC_TRACKING = 11;
	public static final int PACKET_OFFHAND_SWING = 12;

	private OffhandNetwork() {
	}

	public static void register() {
		EtFuturum.networkWrapper.registerMessage(OffhandSwapMessage.Handler.class, OffhandSwapMessage.class, PACKET_SWAP_HANDS, Side.SERVER);
		EtFuturum.proxy.registerOffhandClientPacketHandlers();
		EtFuturum.networkWrapper.registerMessage(OffhandUseMessage.Handler.class, OffhandUseMessage.class, PACKET_OFFHAND_USE, Side.SERVER);
	}

	public static void syncOffhandToPlayer(EntityPlayerMP player) {
		if (player == null || player.playerNetServerHandler == null) return;
		EtFuturum.networkWrapper.sendTo(new OffhandSyncMessage(OffhandInventory.getOffhandStack(player)), player);
	}

	public static void syncOffhandToTracking(EntityPlayerMP player) {
		if (player == null || player.mcServer == null) return;

		ItemStack stack = OffhandInventory.getOffhandStack(player);
		OffhandTrackingMessage packet = new OffhandTrackingMessage(player.getEntityId(), stack);
		ServerConfigurationManager manager = player.mcServer.getConfigurationManager();
		@SuppressWarnings("unchecked")
		List<EntityPlayerMP> allPlayers = manager.playerEntityList;
		for (EntityPlayerMP other : allPlayers) {
			if (other != player && other.dimension == player.dimension && other.getDistanceSqToEntity(player) < 256.0D * 256.0D) {
				EtFuturum.networkWrapper.sendTo(packet, other);
			}
		}
	}

	public static void syncVisibleOffhandsToPlayer(EntityPlayerMP viewer) {
		if (viewer == null || viewer.mcServer == null || viewer.playerNetServerHandler == null) return;

		ServerConfigurationManager manager = viewer.mcServer.getConfigurationManager();
		@SuppressWarnings("unchecked")
		List<EntityPlayerMP> allPlayers = manager.playerEntityList;
		for (EntityPlayerMP other : allPlayers) {
			if (other == viewer || other.dimension != viewer.dimension) continue;
			if (viewer.getDistanceSqToEntity(other) < 256.0D * 256.0D) {
				EtFuturum.networkWrapper.sendTo(new OffhandTrackingMessage(other.getEntityId(), OffhandInventory.getOffhandStack(other)), viewer);
			}
		}
	}

	public static void syncOffhandChanged(EntityPlayerMP player) {
		syncOffhandToPlayer(player);
		syncOffhandToTracking(player);
	}

	public static void sendOffhandSwing(EntityPlayerMP player) {
		if (player == null || player.mcServer == null || player.playerNetServerHandler == null) return;

		OffhandSwingMessage packet = new OffhandSwingMessage(player.getEntityId());
		EtFuturum.networkWrapper.sendTo(packet, player);

		ServerConfigurationManager manager = player.mcServer.getConfigurationManager();
		@SuppressWarnings("unchecked")
		List<EntityPlayerMP> allPlayers = manager.playerEntityList;
		for (EntityPlayerMP other : allPlayers) {
			if (other != player && other.dimension == player.dimension && other.getDistanceSqToEntity(player) < 64.0D * 64.0D) {
				EtFuturum.networkWrapper.sendTo(packet, other);
			}
		}
	}

	public static class NoopOffhandSyncHandler implements IMessageHandler<OffhandSyncMessage, IMessage> {
		@Override
		public IMessage onMessage(OffhandSyncMessage message, MessageContext ctx) {
			return null;
		}
	}

	public static class NoopOffhandTrackingHandler implements IMessageHandler<OffhandTrackingMessage, IMessage> {
		@Override
		public IMessage onMessage(OffhandTrackingMessage message, MessageContext ctx) {
			return null;
		}
	}

	public static class NoopOffhandSwingHandler implements IMessageHandler<OffhandSwingMessage, IMessage> {
		@Override
		public IMessage onMessage(OffhandSwingMessage message, MessageContext ctx) {
			return null;
		}
	}
}
