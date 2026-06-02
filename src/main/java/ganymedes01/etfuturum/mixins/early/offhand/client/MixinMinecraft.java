package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.network.OffhandUseMessage;
import ganymedes01.etfuturum.offhand.Hand;
import ganymedes01.etfuturum.offhand.IOffhandEntity;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MovingObjectPosition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
	@Shadow
	private int rightClickDelayTimer;

	@Inject(method = "func_147121_ag", at = @At("HEAD"), cancellable = true, remap = false)
	private void etfu$rightClickWithOffhandFallback(CallbackInfo ci) {
		ci.cancel();
		Minecraft mc = Minecraft.getMinecraft();
		rightClickDelayTimer = 4;

		EntityPlayer player = mc.thePlayer;
		if (player == null) return;

		boolean mainHandConsumed = etfu$doVanillaRightClick(mc, player);
		if (!mainHandConsumed && OffhandInventory.getOffhandStack(player) != null) {
			etfu$useOffhand(mc, player);
		}
	}

	@Unique
	private boolean etfu$doVanillaRightClick(Minecraft mc, EntityPlayer player) {
		MovingObjectPosition hit = mc.objectMouseOver;
		ItemStack heldItem = player.inventory.getCurrentItem();

		if (hit != null) {
			switch (hit.typeOfHit) {
				case ENTITY:
					if (mc.playerController.interactWithEntitySendPacket(player, hit.entityHit)) {
						return true;
					}
					break;
				case BLOCK:
					int x = hit.blockX;
					int y = hit.blockY;
					int z = hit.blockZ;
					if (mc.theWorld.getBlock(x, y, z).getMaterial() != Material.air) {
						int stackSizeBefore = heldItem != null ? heldItem.stackSize : 0;
						if (mc.playerController.onPlayerRightClick(player, mc.theWorld, heldItem, x, y, z, hit.sideHit, hit.hitVec)) {
							player.swingItem();
							if (heldItem != null) {
								if (heldItem.stackSize == 0) {
									player.inventory.mainInventory[player.inventory.currentItem] = null;
								} else if (heldItem.stackSize != stackSizeBefore || mc.playerController.isInCreativeMode()) {
									mc.entityRenderer.itemRenderer.resetEquippedProgress();
								}
							}
							return true;
						}
						if (heldItem != null && heldItem.stackSize == 0) {
							player.inventory.mainInventory[player.inventory.currentItem] = null;
						}
					}
					break;
				default:
					break;
			}
		}

		ItemStack current = player.inventory.getCurrentItem();
		if (current != null && mc.playerController.sendUseItem(player, mc.theWorld, current)) {
			mc.entityRenderer.itemRenderer.resetEquippedProgress2();
			return true;
		}
		return false;
	}

	@Unique
	private void etfu$useOffhand(Minecraft mc, EntityPlayer player) {
		ItemStack offhandStack = OffhandInventory.getOffhandStack(player);
		if (offhandStack == null) return;

		MovingObjectPosition hit = mc.objectMouseOver;
		if (hit != null) {
			switch (hit.typeOfHit) {
				case BLOCK:
					EtFuturum.networkWrapper.sendToServer(OffhandUseMessage.blockUse(hit.blockX, hit.blockY, hit.blockZ, hit.sideHit, hit.hitVec));
					break;
				case ENTITY:
					if (hit.entityHit != null) {
						EtFuturum.networkWrapper.sendToServer(OffhandUseMessage.entityUse(hit.entityHit.getEntityId()));
					} else {
						EtFuturum.networkWrapper.sendToServer(OffhandUseMessage.airUse());
					}
					break;
				default:
					EtFuturum.networkWrapper.sendToServer(OffhandUseMessage.airUse());
					break;
			}
		} else {
			EtFuturum.networkWrapper.sendToServer(OffhandUseMessage.airUse());
		}

		etfu$predictHeldOffhandUse(mc, player, offhandStack);
	}

	@Unique
	private void etfu$predictHeldOffhandUse(Minecraft mc, EntityPlayer player, ItemStack stack) {
		stack = OffhandInventory.normalizeStack(stack);
		if (stack == null || stack.getMaxItemUseDuration() <= 0 || !(player instanceof IOffhandEntity offhandEntity)) return;

		int stackSizeBefore = stack.stackSize;
		int damageBefore = stack.getItemDamage();
		offhandEntity.etfu$setActiveHand(Hand.OFF_HAND);

		ItemStack result = stack;
		if (!(stack.getItem() instanceof ItemSword)) {
			result = stack.useItemRightClick(mc.theWorld, player);
		}

		boolean usingOffhand = player.isUsingItem() && (player.getItemInUse() == stack || player.getItemInUse() == result);
		if (!usingOffhand) {
			offhandEntity.etfu$setActiveHand(Hand.MAIN_HAND);
		}

		boolean changed = result != stack || OffhandInventory.normalizeStack(result) == null || result.stackSize != stackSizeBefore || result.getItemDamage() != damageBefore;
		if (changed) {
			if (mc.playerController.isInCreativeMode() && result != null) {
				result.stackSize = stackSizeBefore;
				if (result.isItemStackDamageable()) {
					result.setItemDamage(damageBefore);
				}
			}
			OffhandInventory.setOffhandStack(player, result);
		}
	}
}
