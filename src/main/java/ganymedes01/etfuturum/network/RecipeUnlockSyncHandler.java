package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import ganymedes01.etfuturum.recipebook.RecipeBookRecipes;

public class RecipeUnlockSyncHandler implements IMessageHandler<RecipeUnlockSyncMessage, IMessage> {
	@Override
	public IMessage onMessage(RecipeUnlockSyncMessage message, MessageContext ctx) {
		RecipeBookRecipes.setUnlockedRecipes(message.recipeIds);
		return null;
	}
}
