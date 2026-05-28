package ganymedes01.etfuturum.core.handlers.creativetabs;

import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModernCreativeTabs {
    public static final CreativeTabs BUILDING_BLOCKS = new ModernCreativeTab("buildingBlocks", new ItemStack(Blocks.brick_block), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs COLORED_BLOCKS = new ModernCreativeTab("coloredBlocks", new ItemStack(Blocks.wool, 1, 9), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static void init() {
        // Just initializing the classes to register the tabs
    }
}
