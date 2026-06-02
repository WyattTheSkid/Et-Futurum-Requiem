package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;

public class OffhandSyncMessage implements IMessage {
	private ItemStack offhandStack;

	public OffhandSyncMessage() {
	}

	public OffhandSyncMessage(ItemStack stack) {
		offhandStack = OffhandInventory.copyStack(stack);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		offhandStack = ByteBufUtils.readItemStack(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeItemStack(buf, offhandStack);
	}

	public ItemStack getOffhandStack() {
		return offhandStack;
	}
}
