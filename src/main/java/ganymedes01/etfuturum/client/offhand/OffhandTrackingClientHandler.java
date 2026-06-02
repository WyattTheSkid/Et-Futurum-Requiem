package ganymedes01.etfuturum.client.offhand;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.network.OffhandTrackingMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

@SideOnly(Side.CLIENT)
public class OffhandTrackingClientHandler implements IMessageHandler<OffhandTrackingMessage, IMessage> {
	@Override
	public IMessage onMessage(OffhandTrackingMessage message, MessageContext ctx) {
		Minecraft.getMinecraft().func_152344_a(() -> {
			Minecraft mc = Minecraft.getMinecraft();
			if (mc.theWorld == null) return;
			Entity entity = mc.theWorld.getEntityByID(message.getEntityId());
			if (entity instanceof EntityPlayer player) {
				OffhandClientCache.setOffhandForPlayer(player.getUniqueID(), message.getOffhandStack());
			}
		});
		return null;
	}
}
