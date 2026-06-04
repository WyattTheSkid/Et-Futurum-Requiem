package ganymedes01.etfuturum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import ganymedes01.etfuturum.offhand.Hand;
import ganymedes01.etfuturum.offhand.IOffhandEntity;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldServer;

public class OffhandUseMessage implements IMessage {
	private int interactionType;
	private int blockX;
	private int blockY;
	private int blockZ;
	private int side;
	private float hitX;
	private float hitY;
	private float hitZ;
	private int entityId;

	public OffhandUseMessage() {
	}

	public static OffhandUseMessage airUse() {
		OffhandUseMessage message = new OffhandUseMessage();
		message.interactionType = 0;
		return message;
	}

	public static OffhandUseMessage blockUse(int x, int y, int z, int side, Vec3 hitVec) {
		OffhandUseMessage message = new OffhandUseMessage();
		message.interactionType = 1;
		message.blockX = x;
		message.blockY = y;
		message.blockZ = z;
		message.side = side;
		message.hitX = (float) hitVec.xCoord;
		message.hitY = (float) hitVec.yCoord;
		message.hitZ = (float) hitVec.zCoord;
		return message;
	}

	public static OffhandUseMessage entityUse(int entityId) {
		OffhandUseMessage message = new OffhandUseMessage();
		message.interactionType = 2;
		message.entityId = entityId;
		return message;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		interactionType = buf.readByte();
		if (interactionType == 1) {
			blockX = buf.readInt();
			blockY = buf.readShort();
			blockZ = buf.readInt();
			side = buf.readByte();
			hitX = buf.readFloat();
			hitY = buf.readFloat();
			hitZ = buf.readFloat();
		} else if (interactionType == 2) {
			entityId = buf.readInt();
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeByte(interactionType);
		if (interactionType == 1) {
			buf.writeInt(blockX);
			buf.writeShort(blockY);
			buf.writeInt(blockZ);
			buf.writeByte(side);
			buf.writeFloat(hitX);
			buf.writeFloat(hitY);
			buf.writeFloat(hitZ);
		} else if (interactionType == 2) {
			buf.writeInt(entityId);
		}
	}

	public static class Handler implements IMessageHandler<OffhandUseMessage, IMessage> {
		@Override
		public IMessage onMessage(OffhandUseMessage message, MessageContext ctx) {
			EntityPlayerMP player = ctx.getServerHandler().playerEntity;
			if (player == null || player.isDead) return null;
			if (player.isUsingItem()) {
				if (player instanceof IOffhandEntity && ((IOffhandEntity) player).etfu$getActiveHand() == Hand.OFF_HAND) return null;
				player.clearItemInUse();
			}
			if (OffhandInventory.getOffhandStack(player) == null) return null;

			WorldServer world = player.mcServer.worldServerForDimension(player.dimension);
			boolean success = switch (message.interactionType) {
				case 0 -> handleAirUse(player, world);
				case 1 -> handleBlockUse(player, world, message);
				case 2 -> handleEntityUse(player, world, message);
				default -> false;
			};

			boolean activeOffhandUse = player.isUsingItem() && player instanceof IOffhandEntity && ((IOffhandEntity) player).etfu$getActiveHand() == Hand.OFF_HAND;
			if (!activeOffhandUse) {
				player.inventoryContainer.detectAndSendChanges();
				OffhandNetwork.syncOffhandChanged(player);
			}

			if (success && message.interactionType == 1) {
				OffhandNetwork.sendOffhandSwing(player);
			}
			return null;
		}

		private static boolean handleAirUse(EntityPlayerMP player, WorldServer world) {
			return useOffhandItemRightClick(player, world, OffhandInventory.getOffhandStack(player));
		}

		private static boolean handleBlockUse(EntityPlayerMP player, WorldServer world, OffhandUseMessage message) {
			if (player.getDistanceSq(message.blockX + 0.5D, message.blockY + 0.5D, message.blockZ + 0.5D) > 64.0D) {
				return false;
			}

			boolean blockUsed = useOffhandTemporarily(player, () -> player.theItemInWorldManager.activateBlockOrUseItem(player, world, player.inventory.getCurrentItem(), message.blockX, message.blockY, message.blockZ, message.side, message.hitX, message.hitY, message.hitZ));
			return blockUsed || handleAirUse(player, world);
		}

		private static boolean handleEntityUse(EntityPlayerMP player, WorldServer world, OffhandUseMessage message) {
			Entity entity = world.getEntityByID(message.entityId);
			if (entity == null || player.getDistanceSqToEntity(entity) > 36.0D) return false;
			return useOffhandTemporarily(player, () -> player.interactWith(entity));
		}

		private static boolean useOffhandItemRightClick(EntityPlayerMP player, WorldServer world, ItemStack stack) {
			stack = OffhandInventory.normalizeStack(stack);
			if (stack == null) return false;

			int stackSizeBefore = stack.stackSize;
			int damageBefore = stack.getItemDamage();
			IOffhandEntity offhandEntity = player instanceof IOffhandEntity ? (IOffhandEntity) player : null;
			if (offhandEntity != null) {
				offhandEntity.etfu$setActiveHand(Hand.OFF_HAND);
			}

			ItemStack result = stack;
			if (!(stack.getItem() instanceof ItemSword)) {
				result = stack.useItemRightClick(world, player);
			}

			boolean usingOffhand = player.isUsingItem() && (player.getItemInUse() == stack || player.getItemInUse() == result);
			if (!usingOffhand && offhandEntity != null) {
				offhandEntity.etfu$setActiveHand(Hand.MAIN_HAND);
			}

			boolean changed = result != stack || OffhandInventory.normalizeStack(result) == null || result.stackSize != stackSizeBefore || result.getItemDamage() != damageBefore;
			if (changed) {
				if (player.theItemInWorldManager.isCreative() && result != null) {
					result.stackSize = stackSizeBefore;
					if (result.isItemStackDamageable()) {
						result.setItemDamage(damageBefore);
					}
				}
				OffhandInventory.setOffhandStack(player, result);
			}
			return usingOffhand || changed;
		}

		private static boolean useOffhandTemporarily(EntityPlayerMP player, OffhandAction action) {
			ItemStack offhandStack = OffhandInventory.getOffhandStack(player);
			if (offhandStack == null) return false;

			int hotbarSlot = player.inventory.currentItem;
			ItemStack savedMainHand = player.inventory.mainInventory[hotbarSlot];
			player.inventory.mainInventory[hotbarSlot] = offhandStack;
			OffhandInventory.setOffhandStack(player, savedMainHand);

			try {
				return action.run();
			} finally {
				ItemStack resultOffhand = player.inventory.mainInventory[hotbarSlot];
				ItemStack restoredMainHand = OffhandInventory.getOffhandStack(player);
				player.inventory.mainInventory[hotbarSlot] = restoredMainHand;
				OffhandInventory.setOffhandStack(player, resultOffhand);
			}
		}

		private interface OffhandAction {
			boolean run();
		}
	}
}
