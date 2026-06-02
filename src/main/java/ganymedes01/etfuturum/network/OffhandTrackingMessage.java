package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;

public class OffhandTrackingMessage implements IMessage {
	private int entityId;
	private ItemStack offhandStack;

	public OffhandTrackingMessage() {
	}

	public OffhandTrackingMessage(int entityId, ItemStack stack) {
		this.entityId = entityId;
		offhandStack = OffhandInventory.copyStack(stack);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityId = buf.readInt();
		offhandStack = ByteBufUtils.readItemStack(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityId);
		ByteBufUtils.writeItemStack(buf, offhandStack);
	}

	public int getEntityId() {
		return entityId;
	}

	public ItemStack getOffhandStack() {
		return offhandStack;
	}
}
