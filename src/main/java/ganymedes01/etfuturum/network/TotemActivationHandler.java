package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.ModItems;
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
				for (int i = 0; i < 150; ++i) {
					double d0 = world.rand.nextGaussian() * 0.02D;
					double d1 = world.rand.nextGaussian() * 0.02D;
					double d2 = world.rand.nextGaussian() * 0.02D;
					double px = entity.posX + (double) (world.rand.nextFloat() * entity.width * 2.0F) - (double) entity.width;
					double py = entity.posY + (double) (world.rand.nextFloat() * entity.height);
					double pz = entity.posZ + (double) (world.rand.nextFloat() * entity.width * 2.0F) - (double) entity.width;
					CustomParticles.spawnTotemParticle(world, px, py, pz, d0, d1, d2);
				}

				if (entity.getEntityId() == mc.thePlayer.getEntityId()) {
					ganymedes01.etfuturum.client.offhand.OffhandClientEventHandler.displayItemActivation(new ItemStack(ModItems.TOTEM_OF_UNDYING.get()));
				}
			}
		}
		return null;
	}
}
