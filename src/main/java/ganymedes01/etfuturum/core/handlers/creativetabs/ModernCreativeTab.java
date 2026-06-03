package ganymedes01.etfuturum.core.handlers.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import java.util.List;
import java.util.function.Supplier;

public class ModernCreativeTab extends CreativeTabs {
	private final Supplier<ItemStack> iconSupplier;
	private ItemStack iconStack;
	private final CreativeTabPopulator populator;
	private final boolean allowEmptyEntries;

	public ModernCreativeTab(String label, Supplier<ItemStack> iconSupplier, CreativeTabPopulator populator) {
		this(label, iconSupplier, populator, false);
	}

	public ModernCreativeTab(String label, Supplier<ItemStack> iconSupplier, CreativeTabPopulator populator, boolean allowEmptyEntries) {
		super(label);
		this.iconSupplier = iconSupplier;
		this.populator = populator;
		this.allowEmptyEntries = allowEmptyEntries;
	}
    public int getTabPage() {
        return 0;
    }

    @Override
    public ItemStack getIconItemStack() {
        if (iconStack == null || iconStack.getItem() == null) {
            iconStack = iconSupplier.get();
        }
        return iconStack;
    }

    @Override
    public Item getTabIconItem() {
        return getIconItemStack().getItem();
    }

    @Override
    public int func_151243_f() {
        return getIconItemStack().getItemDamage();
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void displayAllReleventItems(final List list) {
		populator.populate(new CreativeTabDisplayBuilder() {
			@Override
			public void accept(ItemStack stack) {
				if (allowEmptyEntries && stack == null) {
					list.add(null);
					return;
				}
				if (stack != null && stack.getItem() != null) {
                    if (Item.itemRegistry.getNameForObject(stack.getItem()) != null) {
                        list.add(stack);
                    }
                }
            }
        });
    }
}
