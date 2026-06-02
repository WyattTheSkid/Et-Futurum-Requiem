package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class OffhandSwapMessage implements IMessage {
	public OffhandSwapMessage() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
	}

	public static class Handler implements IMessageHandler<OffhandSwapMessage, IMessage> {
		@Override
		public IMessage onMessage(OffhandSwapMessage message, MessageContext ctx) {
			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			if (player == null || player.isDead || player.isUsingItem()) return null;

			int hotbarSlot = player.inventory.currentItem;
			ItemStack mainHandStack = player.inventory.getStackInSlot(hotbarSlot);
			ItemStack offhandStack = OffhandInventory.getOffhandStack(player);

			player.inventory.mainInventory[hotbarSlot] = offhandStack;
			OffhandInventory.setOffhandStack(player, mainHandStack);
			player.inventoryContainer.detectAndSendChanges();
			OffhandNetwork.syncOffhandChanged(player);
			return null;
		}
	}
}
