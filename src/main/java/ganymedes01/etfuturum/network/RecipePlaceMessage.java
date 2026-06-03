package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import ganymedes01.etfuturum.recipebook.RecipePlacementHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;

public class RecipePlaceMessage implements IMessage {
	private int recipeId;
	private boolean craftAll;

	public RecipePlaceMessage() {
	}

	public RecipePlaceMessage(int recipeId) {
		this(recipeId, false);
	}

	public RecipePlaceMessage(int recipeId, boolean craftAll) {
		this.recipeId = recipeId;
		this.craftAll = craftAll;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		recipeId = buf.readInt();
		craftAll = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(recipeId);
		buf.writeBoolean(craftAll);
	}

	public static class Handler implements IMessageHandler<RecipePlaceMessage, IMessage> {
		@Override
		public IMessage onMessage(RecipePlaceMessage message, MessageContext ctx) {
			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			RecipePlacementHelper.placeRecipe(player, message.recipeId, message.craftAll);
			return null;
		}
	}
}
