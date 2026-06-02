package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class OffhandSwingMessage implements IMessage {
	private int entityId;

	public OffhandSwingMessage() {
	}

	public OffhandSwingMessage(int entityId) {
		this.entityId = entityId;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityId = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityId);
	}

	public int getEntityId() {
		return entityId;
	}
}
