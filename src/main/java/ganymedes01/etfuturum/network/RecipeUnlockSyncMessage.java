package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class RecipeUnlockSyncMessage implements IMessage {
	public int[] recipeIds;

	public RecipeUnlockSyncMessage() {
	}

	public RecipeUnlockSyncMessage(int[] ids) {
		this.recipeIds = ids;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		int len = buf.readInt();
		recipeIds = new int[len];
		for (int i = 0; i < len; ++i) {
			recipeIds[i] = buf.readInt();
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(recipeIds.length);
		for (int id : recipeIds) {
			buf.writeInt(id);
		}
	}
}
