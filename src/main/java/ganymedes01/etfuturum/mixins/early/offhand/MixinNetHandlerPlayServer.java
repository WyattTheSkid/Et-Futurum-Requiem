package ganymedes01.etfuturum.mixins.early.offhand;

import ganymedes01.etfuturum.network.OffhandNetwork;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetHandlerPlayServer.class)
public abstract class MixinNetHandlerPlayServer {
	@Shadow
	public EntityPlayerMP playerEntity;

	@Inject(method = "func_147344_a", at = @At("HEAD"), cancellable = true, remap = false)
	private void etfu$handleCreativeOffhandSlot(C10PacketCreativeInventoryAction packet, CallbackInfo ci) {
		if (packet.func_149627_c() != OffhandInventory.OFFHAND_CONTAINER_SLOT) return;
		ci.cancel();

		if (!playerEntity.theItemInWorldManager.isCreative()) return;

		ItemStack stack = packet.func_149625_d();
		boolean validItem = stack == null || stack.getItem() != null;
		boolean validStack = stack == null || stack.getItemDamage() >= 0 && stack.stackSize <= 64 && stack.stackSize > 0;
		if (validItem && validStack) {
			playerEntity.inventoryContainer.putStackInSlot(OffhandInventory.OFFHAND_CONTAINER_SLOT, stack);
			playerEntity.inventoryContainer.detectAndSendChanges();
			OffhandNetwork.syncOffhandChanged(playerEntity);
		}
	}
}
