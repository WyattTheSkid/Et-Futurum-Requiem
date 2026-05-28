package ganymedes01.etfuturum.core.handlers.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import java.util.List;

public class ModernCreativeTab extends CreativeTabs {
    private final ItemStack icon;
    private final CreativeTabPopulator populator;

    public ModernCreativeTab(String label, ItemStack icon, CreativeTabPopulator populator) {
        super(label);
        this.icon = icon;
        this.populator = populator;
    }

    @Override
    public Item getTabIconItem() {
        return icon.getItem();
    }

    @Override
    public int func_151243_f() {
        return icon.getItemDamage();
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void displayAllReleventItems(final List list) {
        populator.populate(new CreativeTabDisplayBuilder() {
            @Override
            public void accept(ItemStack stack) {
                if (stack != null && stack.getItem() != null) {
                    list.add(stack);
                }
            }
        });
    }
}
