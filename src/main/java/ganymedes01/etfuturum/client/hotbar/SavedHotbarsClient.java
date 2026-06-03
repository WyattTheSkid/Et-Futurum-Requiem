package ganymedes01.etfuturum.client.hotbar;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.core.handlers.creativetabs.CreativeTabDisplayBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@SideOnly(Side.CLIENT)
public final class SavedHotbarsClient {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final HotbarSnapshot[] HOTBARS = new HotbarSnapshot[9];
	private static boolean loaded;

	private SavedHotbarsClient() {
	}

	public static void load(Minecraft mc) {
		ensureDefaults();
		File file = getHotbarFile(mc);
		if (!file.exists()) {
			loaded = true;
			return;
		}

		FileInputStream stream = null;
		try {
			stream = new FileInputStream(file);
			NBTTagCompound compound = CompressedStreamTools.readCompressed(stream);
			if (compound != null) {
				for (int i = 0; i < HOTBARS.length; ++i) {
					HOTBARS[i].readFromNBT(compound.getTagList(String.valueOf(i), 10));
				}
			}
		} catch (Exception e) {
			LOGGER.error("Failed to load creative hotbars", e);
			ensureDefaults();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (Exception ignored) {
				}
			}
			loaded = true;
		}
	}

	public static void save(Minecraft mc) {
		ensureLoaded(mc);
		FileOutputStream stream = null;
		try {
			NBTTagCompound compound = new NBTTagCompound();
			for (int i = 0; i < HOTBARS.length; ++i) {
				compound.setTag(String.valueOf(i), HOTBARS[i].writeToNBT());
			}

			File file = getHotbarFile(mc);
			stream = new FileOutputStream(file);
			CompressedStreamTools.writeCompressed(compound, stream);
		} catch (Exception e) {
			LOGGER.error("Failed to save creative hotbars", e);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (Exception ignored) {
				}
			}
		}
	}

	public static HotbarSnapshot getHotbar(Minecraft mc, int index) {
		ensureLoaded(mc);
		return HOTBARS[index];
	}

	public static void saveCurrentHotbar(Minecraft mc, int index) {
		ensureLoaded(mc);
		HOTBARS[index].copyFromInventory(mc.thePlayer.inventory);
		save(mc);

		String hotbarKey = GameSettings.getKeyDisplayString(mc.gameSettings.keyBindsHotbar[index].getKeyCode());
		String loadKey = GameSettings.getKeyDisplayString(SavedHotbarKeyBindings.LOAD_HOTBAR.getKeyCode());
		mc.ingameGUI.func_110326_a(I18n.format("inventory.hotbarSaved", loadKey, hotbarKey), false);
	}

	public static void loadHotbar(Minecraft mc, int index) {
		ensureLoaded(mc);
		HotbarSnapshot hotbar = HOTBARS[index];
		for (int i = 0; i < HotbarSnapshot.HOTBAR_SIZE; ++i) {
			ItemStack stack = hotbar.get(i);
			ItemStack copy = stack != null ? stack.copy() : null;
			mc.thePlayer.inventory.setInventorySlotContents(i, copy);
			mc.playerController.sendSlotPacket(copy, 36 + i);
		}
		mc.thePlayer.inventoryContainer.detectAndSendChanges();
	}

	public static void populateCreativeTab(CreativeTabDisplayBuilder builder) {
		Minecraft mc = Minecraft.getMinecraft();
		ensureLoaded(mc);
		for (int hotbarIndex = 0; hotbarIndex < HOTBARS.length; ++hotbarIndex) {
			HotbarSnapshot hotbar = HOTBARS[hotbarIndex];
			if (hotbar.isEmpty()) {
				populateEmptyHotbar(builder, hotbarIndex, mc);
			} else {
				for (int slot = 0; slot < HotbarSnapshot.HOTBAR_SIZE; ++slot) {
					ItemStack stack = hotbar.get(slot);
					builder.accept(stack != null ? stack.copy() : null);
				}
			}
		}
	}

	private static void populateEmptyHotbar(CreativeTabDisplayBuilder builder, int hotbarIndex, Minecraft mc) {
		for (int slot = 0; slot < HotbarSnapshot.HOTBAR_SIZE; ++slot) {
			if (slot == hotbarIndex) {
				ItemStack info = new ItemStack(Items.paper);
				info.setTagCompound(new NBTTagCompound());
				info.getTagCompound().setBoolean("CustomCreativeLock", true);
				String hotbarKey = GameSettings.getKeyDisplayString(mc.gameSettings.keyBindsHotbar[hotbarIndex].getKeyCode());
				String saveKey = GameSettings.getKeyDisplayString(SavedHotbarKeyBindings.SAVE_HOTBAR.getKeyCode());
				info.setStackDisplayName(I18n.format("inventory.hotbarInfo", saveKey, hotbarKey));
				builder.accept(info);
			} else {
				builder.accept(null);
			}
		}
	}

	private static void ensureLoaded(Minecraft mc) {
		if (!loaded) {
			load(mc);
		}
	}

	private static void ensureDefaults() {
		for (int i = 0; i < HOTBARS.length; ++i) {
			if (HOTBARS[i] == null) {
				HOTBARS[i] = new HotbarSnapshot();
			}
		}
	}

	private static File getHotbarFile(Minecraft mc) {
		return new File(mc.mcDataDir, "hotbar.nbt");
	}
}
