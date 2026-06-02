package ganymedes01.etfuturum.client.offhand;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.network.OffhandSyncMessage;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

@SideOnly(Side.CLIENT)
public class OffhandSyncClientHandler implements IMessageHandler<OffhandSyncMessage, IMessage> {
	@Override
	public IMessage onMessage(OffhandSyncMessage message, MessageContext ctx) {
		Minecraft.getMinecraft().func_152344_a(() -> {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			if (player == null) return;

			ItemStack oldStack = OffhandInventory.getOffhandStack(player);
			ItemStack newStack = OffhandInventory.normalizeStack(message.getOffhandStack());
			boolean itemChanged = oldStack == null && newStack != null || oldStack != null && newStack == null;
			if (!itemChanged && oldStack != null) {
				itemChanged = oldStack.getItem() != newStack.getItem() || oldStack.getItemDamage() != newStack.getItemDamage() || !ItemStack.areItemStackTagsEqual(oldStack, newStack);
			}

			OffhandInventory.setOffhandStack(player, OffhandInventory.copyStack(newStack));
			if (itemChanged) {
				OffhandClientCache.triggerOffhandEquipReset = true;
			}
		});
		return null;
	}
}
