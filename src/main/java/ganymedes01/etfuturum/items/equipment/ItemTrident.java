package ganymedes01.etfuturum.items.equipment;

import com.google.common.collect.Multimap;
import ganymedes01.etfuturum.ModEnchantments;
import ganymedes01.etfuturum.Tags;
import ganymedes01.etfuturum.entities.EntityTrident;
import ganymedes01.etfuturum.items.BaseItem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemTrident extends BaseItem {

	private static final float ATTACK_DAMAGE = 8.0F;
	private static final int MAX_USE_DURATION = 72000;
	private static final int MIN_THROW_USE_TICKS = 10;

	public ItemTrident() {
		super("trident");
		maxStackSize = 1;
		setMaxDamage(250);
		setFull3D();
	}

	@Override
	public String getTextureDomain() {
		return "minecraft_1.13.2";
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int timeLeft) {
		if (stack.getItemDamage() >= stack.getMaxDamage()) {
			return;
		}

		int useTicks = getMaxItemUseDuration(stack) - timeLeft;
		if (useTicks < MIN_THROW_USE_TICKS) {
			return;
		}

		int riptide = ModEnchantments.getRiptideModifier(stack);
		if (riptide > 0 && !player.isWet()) {
			return;
		}

		if (!world.isRemote) {
			stack.damageItem(1, player);

			if (riptide == 0) {
				EntityTrident trident = new EntityTrident(world, player, stack);
				if (player.capabilities.isCreativeMode) {
					trident.canBePickedUp = 2;
				}

				world.spawnEntityInWorld(trident);

				if (!player.capabilities.isCreativeMode) {
					removeThrownStackFromInventory(stack, player);
				}
			} else {
				ModEnchantments.startRiptideSpin(player);
			}
		}

		if (riptide > 0) {
			applyRiptideMovement(player, riptide);
		}

		world.playSoundAtEntity(player, getUseSound(riptide), 1.0F, 1.0F);

		player.addStat(StatList.objectUseStats[Item.getIdFromItem(this)], 1);
	}

	private String getUseSound(int riptide) {
		if (riptide >= 3) {
			return Tags.MC_ASSET_VER + ":item.trident.riptide_3";
		}
		if (riptide == 2) {
			return Tags.MC_ASSET_VER + ":item.trident.riptide_2";
		}
		if (riptide == 1) {
			return Tags.MC_ASSET_VER + ":item.trident.riptide_1";
		}

		return Tags.MC_ASSET_VER + ":item.trident.throw";
	}

	private void applyRiptideMovement(EntityPlayer player, int riptide) {
		float yaw = player.rotationYaw;
		float pitch = player.rotationPitch;
		float motionX = -MathHelper.sin(yaw * (float) Math.PI / 180.0F) * MathHelper.cos(pitch * (float) Math.PI / 180.0F);
		float motionY = -MathHelper.sin(pitch * (float) Math.PI / 180.0F);
		float motionZ = MathHelper.cos(yaw * (float) Math.PI / 180.0F) * MathHelper.cos(pitch * (float) Math.PI / 180.0F);
		float length = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
		float force = 3.0F * ((1.0F + (float) riptide) / 4.0F);

		player.addVelocity((double) (motionX * (force / length)), (double) (motionY * (force / length)), (double) (motionZ * (force / length)));
		player.velocityChanged = true;

		if (player.onGround) {
			player.moveEntity(0.0D, 1.1999999D, 0.0D);
		}
	}

	private void removeThrownStackFromInventory(ItemStack stack, EntityPlayer player) {
		if (player.getCurrentEquippedItem() == stack) {
			player.inventory.mainInventory[player.inventory.currentItem] = null;
		} else {
			--stack.stackSize;
			if (stack.stackSize <= 0) {
				stack.stackSize = 0;
			}
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (stack.getItemDamage() < stack.getMaxDamage() && (ModEnchantments.getRiptideModifier(stack) <= 0 || player.isWet())) {
			player.setItemInUse(stack, getMaxItemUseDuration(stack));
		}

		return stack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return MAX_USE_DURATION;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.none;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		if ((double) block.getBlockHardness(world, x, y, z) != 0.0D) {
			stack.damageItem(2, entity);
		}

		return true;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		return player.capabilities.isCreativeMode;
	}

	@Override
	public int getItemEnchantability() {
		return 1;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public Multimap getItemAttributeModifiers() {
		Multimap modifiers = super.getItemAttributeModifiers();
		modifiers.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", ATTACK_DAMAGE, 0));
		return modifiers;
	}
}
