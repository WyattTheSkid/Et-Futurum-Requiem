package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.Tags;
import ganymedes01.etfuturum.client.particle.CustomParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TotemActivationHandler implements IMessageHandler<TotemActivationMessage, IMessage> {

	@Override
	@SideOnly(Side.CLIENT)
	public IMessage onMessage(TotemActivationMessage message, MessageContext ctx) {
		Minecraft mc = Minecraft.getMinecraft();
		World world = mc.theWorld;
		if (world != null) {
			Entity entity = world.getEntityByID(message.entityID);
			if (entity != null) {
				CustomParticles.spawnTotemParticleEmitter(world, entity, 30);
				world.playSound(entity.posX, entity.posY, entity.posZ, Tags.MC_ASSET_VER + ":item.totem.use", 1.0F, 1.0F, false);

				if (mc.thePlayer != null && entity == mc.thePlayer) {
					ganymedes01.etfuturum.client.offhand.OffhandClientEventHandler.displayItemActivation(new ItemStack(ModItems.TOTEM_OF_UNDYING.get()));
				}
			}
		}
		return null;
	}
}
