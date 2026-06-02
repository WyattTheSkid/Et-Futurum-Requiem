package ganymedes01.etfuturum.client.offhand;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.network.OffhandSwingMessage;
import ganymedes01.etfuturum.offhand.IOffhandEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class OffhandSwingClientHandler implements IMessageHandler<OffhandSwingMessage, IMessage> {
	@Override
	public IMessage onMessage(OffhandSwingMessage message, MessageContext ctx) {
		Minecraft.getMinecraft().func_152344_a(() -> {
			Minecraft mc = Minecraft.getMinecraft();
			if (mc.theWorld == null) return;
			Entity entity = mc.theWorld.getEntityByID(message.getEntityId());
			if (entity instanceof IOffhandEntity offhandEntity) {
				offhandEntity.etfu$swingOffhand();
			}
		});
		return null;
	}
}
