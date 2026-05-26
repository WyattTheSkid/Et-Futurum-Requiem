package ganymedes01.etfuturum;

import baubles.common.lib.PlayerHandler;
import ganymedes01.etfuturum.compat.ModsList;
import ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems;
import ganymedes01.etfuturum.configuration.configs.ConfigEnchantsPotions;
import ganymedes01.etfuturum.configuration.configs.ConfigModCompat;
import ganymedes01.etfuturum.enchantment.Channeling;
import ganymedes01.etfuturum.enchantment.FrostWalker;
import ganymedes01.etfuturum.enchantment.Impaling;
import ganymedes01.etfuturum.enchantment.Loyalty;
import ganymedes01.etfuturum.enchantment.Mending;
import ganymedes01.etfuturum.enchantment.Riptide;
import ganymedes01.etfuturum.enchantment.SwiftSneak;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ModEnchantments {

	public static Enchantment frostWalker;
	public static Enchantment mending;
	public static Enchantment swiftSneak;
	public static Enchantment loyalty;
	public static Enchantment impaling;
	public static Enchantment riptide;
	public static Enchantment channeling;

	private static final Map<EntityLivingBase, double[]> prevMoveCache = new WeakHashMap<>();
	private static final Map<EntityPlayer, Integer> riptideSpinTicks = new WeakHashMap<>();

	public static void init() {
		if (ConfigEnchantsPotions.enableFrostWalker)
			frostWalker = new FrostWalker();
		if (ConfigEnchantsPotions.enableMending)
			mending = new Mending();
		if (ConfigEnchantsPotions.enableSwiftSneak)
			swiftSneak = new SwiftSneak();
		if (ConfigBlocksItems.enableTrident && ConfigEnchantsPotions.enableLoyalty)
			loyalty = new Loyalty();
		if (ConfigBlocksItems.enableTrident && ConfigEnchantsPotions.enableImpaling)
			impaling = new Impaling();
		if (ConfigBlocksItems.enableTrident && ConfigEnchantsPotions.enableRiptide)
			riptide = new Riptide();
		if (ConfigBlocksItems.enableTrident && ConfigEnchantsPotions.enableChanneling)
			channeling = new Channeling();
	}

	public static int getLoyaltyModifier(ItemStack stack) {
		return getTridentEnchantmentLevel(loyalty, stack);
	}

	public static int getImpalingModifier(ItemStack stack) {
		return getTridentEnchantmentLevel(impaling, stack);
	}

	public static int getRiptideModifier(ItemStack stack) {
		return getTridentEnchantmentLevel(riptide, stack);
	}

	public static boolean hasChanneling(ItemStack stack) {
		return getTridentEnchantmentLevel(channeling, stack) > 0;
	}

	public static float getImpalingDamage(ItemStack stack, EntityLivingBase target) {
		return isAquatic(target) ? getImpalingModifier(stack) * 2.5F : 0.0F;
	}

	public static void onLivingHurt(LivingHurtEvent event) {
		Entity source = event.source.getEntity();
		if (source instanceof EntityLivingBase && event.source.getSourceOfDamage() == source) {
			ItemStack stack = ((EntityLivingBase) source).getHeldItem();
			event.ammount += getImpalingDamage(stack, event.entityLiving);
		}
	}

	public static void startRiptideSpin(EntityPlayer player) {
		if (!player.worldObj.isRemote) {
			riptideSpinTicks.put(player, 20);
		}
	}

	private static int getTridentEnchantmentLevel(Enchantment enchantment, ItemStack stack) {
		return enchantment == null || stack == null ? 0 : EnchantmentHelper.getEnchantmentLevel(enchantment.effectId, stack);
	}

	private static boolean isAquatic(EntityLivingBase target) {
		return target instanceof EntityWaterMob;
	}

	private static void updateRiptideSpin(EntityLivingBase entity) {
		if (!(entity instanceof EntityPlayer)) {
			return;
		}

		EntityPlayer player = (EntityPlayer) entity;
		Integer ticks = riptideSpinTicks.get(player);
		if (ticks == null) {
			return;
		}

		if (ticks <= 0 || player.isCollidedHorizontally) {
			riptideSpinTicks.remove(player);
			return;
		}

		AxisAlignedBB spinBounds = player.boundingBox.addCoord(player.motionX, player.motionY, player.motionZ).expand(0.5D, 0.5D, 0.5D);
		List entities = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, spinBounds);
		for (Object object : entities) {
			if (object instanceof EntityLivingBase) {
				player.attackTargetEntityWithCurrentItem((Entity) object);
				player.motionX *= -0.2D;
				player.motionY *= -0.2D;
				player.motionZ *= -0.2D;
				riptideSpinTicks.remove(player);
				return;
			}
		}

		riptideSpinTicks.put(player, ticks - 1);
	}

	// Frost Walker logic
	public static void onLivingUpdate(EntityLivingBase entity) {
		if (entity.worldObj.isRemote)
			return;

		updateRiptideSpin(entity);

		if (!ConfigEnchantsPotions.enableFrostWalker)
			return;

		ItemStack boots = entity.getEquipmentInSlot(1);
		int level = 0;
		if ((level = EnchantmentHelper.getEnchantmentLevel(frostWalker.effectId, boots)) > 0 && entity.onGround) {
			double[] prevCoords = prevMoveCache.get(entity);
			if (prevCoords == null || (Math.abs(prevCoords[0] - entity.posX) > 0.003D && Math.abs(prevCoords[1] - entity.posZ) > 0.003D)) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;

				int radius = Math.min(16, 2 + level);

				for (int i = -radius; i <= radius; i++) {
					for (int j = -radius; j <= radius; j++) {
						if (i * i + j * j <= radius * radius) {
							Block block = entity.worldObj.getBlock(x + i, y - 1, z + j);
							Block blockUp = entity.worldObj.getBlock(x + i, y, z + j);
							if (!blockUp.isNormalCube() && blockUp.getMaterial() != Material.water && (block == Blocks.water || block == Blocks.flowing_water)) {
								if (entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, AxisAlignedBB.getBoundingBox(x + i, y - 1, z + j, x + i + 1, y, z + j + 1)).isEmpty()) {
									entity.worldObj.setBlock(x + i, y - 1, z + j, ModBlocks.FROSTED_ICE.get());
								}
							}
						}
					}
				}
				prevMoveCache.put(entity, new double[]{entity.posX, entity.posZ});
			}
		} else {
			prevMoveCache.remove(entity);
		}
	}

	// Mending logic
	public static void onPlayerPickupXP(PlayerPickupXpEvent event) {
		EntityPlayer player = event.entityPlayer;
		EntityXPOrb orb = event.orb;
		if (player.worldObj.isRemote)
			return;
		if (!ConfigEnchantsPotions.enableMending)
			return;

		ArrayList<ItemStack> stacks = new ArrayList<>();
		stacks.add(player.getCurrentEquippedItem()); // held
		stacks.add(player.getEquipmentInSlot(1)); // boots
		stacks.add(player.getEquipmentInSlot(2)); // leggings
		stacks.add(player.getEquipmentInSlot(3)); // chestplate
		stacks.add(player.getEquipmentInSlot(4)); // helmet
		if (ModsList.BAUBLES.isLoaded() && ConfigModCompat.baublesMending) {
			ItemStack[] baubles = PlayerHandler.getPlayerBaubles(player).stackList;
			if (baubles != null) {
				Collections.addAll(stacks, baubles);
			}
		}

		for (ItemStack stack : stacks)
			if (stack != null && stack.getItemDamage() > 0 && EnchantmentHelper.getEnchantmentLevel(mending.effectId, stack) > 0) {
				Item item = stack.getItem();
				if (item == null || !item.isRepairable()) continue;
				int xp = orb.xpValue;
				while (xp > 0 && stack.getItemDamage() > 0) {
					stack.setItemDamage(stack.getItemDamage() - 2);
					xp--;
				}
				if (xp <= 0) {
					orb.setDead();
					event.setCanceled(true);
					return;
				}
			}
	}
}
