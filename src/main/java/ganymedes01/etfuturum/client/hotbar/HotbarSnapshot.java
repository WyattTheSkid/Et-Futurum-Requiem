package ganymedes01.etfuturum.client.hotbar;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class HotbarSnapshot extends ArrayList<ItemStack> {
	public static final int HOTBAR_SIZE = 9;

	public HotbarSnapshot() {
		this.ensureCapacity(HOTBAR_SIZE);
		for (int i = 0; i < HOTBAR_SIZE; ++i) {
			this.add(null);
		}
	}

	public NBTTagList writeToNBT() {
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < HOTBAR_SIZE; ++i) {
			NBTTagCompound compound = new NBTTagCompound();
			ItemStack stack = this.get(i);
			if (stack != null) {
				stack.writeToNBT(compound);
			}
			list.appendTag(compound);
		}
		return list;
	}

	public void readFromNBT(NBTTagList list) {
		for (int i = 0; i < HOTBAR_SIZE; ++i) {
			ItemStack stack = null;
			if (i < list.tagCount()) {
				stack = ItemStack.loadItemStackFromNBT(list.getCompoundTagAt(i));
			}
			this.set(i, stack);
		}
	}

	public void copyFromInventory(InventoryPlayer inventory) {
		for (int i = 0; i < HOTBAR_SIZE; ++i) {
			ItemStack stack = inventory.getStackInSlot(i);
			this.set(i, stack != null ? stack.copy() : null);
		}
	}

	public boolean isEmpty() {
		for (int i = 0; i < HOTBAR_SIZE; ++i) {
			ItemStack stack = this.get(i);
			if (stack != null && stack.getItem() != null) {
				return false;
			}
		}
		return true;
	}
}
