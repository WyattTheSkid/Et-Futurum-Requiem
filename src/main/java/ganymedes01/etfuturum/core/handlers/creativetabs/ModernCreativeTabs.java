package ganymedes01.etfuturum.core.handlers.creativetabs;

import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModernCreativeTabs {
    public static final CreativeTabs BUILDING_BLOCKS = new ModernCreativeTab("buildingBlocks", () -> new ItemStack(Blocks.brick_block), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            // OAK
            p.accept(new ItemStack(Blocks.log, 1, 0));
            p.accept(new ItemStack(ModBlocks.BARK.get(), 1, 0));
            p.accept(new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 0));
            p.accept(new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 0));
            p.accept(new ItemStack(Blocks.planks, 1, 0));
            p.accept(new ItemStack(Blocks.oak_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 0));
            p.accept(new ItemStack(Blocks.fence));
            p.accept(new ItemStack(Blocks.fence_gate));
            p.accept(new ItemStack(Items.wooden_door));
            p.accept(new ItemStack(Blocks.trapdoor));
            p.accept(new ItemStack(Blocks.wooden_pressure_plate));
            p.accept(new ItemStack(Blocks.wooden_button));

            // SPRUCE
            p.accept(new ItemStack(Blocks.log, 1, 1));
            p.accept(new ItemStack(ModBlocks.BARK.get(), 1, 1));
            p.accept(new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 1));
            p.accept(new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 1));
            p.accept(new ItemStack(Blocks.planks, 1, 1));
            p.accept(new ItemStack(Blocks.spruce_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 1));
            p.accept(new ItemStack(ModBlocks.FENCE_SPRUCE.get()));
            p.accept(new ItemStack(ModBlocks.FENCE_GATE_SPRUCE.get()));
            p.accept(new ItemStack(ModBlocks.DOOR_SPRUCE.get()));
            p.accept(new ItemStack(ModBlocks.TRAPDOOR_SPRUCE.get()));
            p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_SPRUCE.get()));
            p.accept(new ItemStack(ModBlocks.BUTTON_SPRUCE.get()));

            // BIRCH
            p.accept(new ItemStack(Blocks.log, 1, 2));
            p.accept(new ItemStack(ModBlocks.BARK.get(), 1, 2));
            p.accept(new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 2));
            p.accept(new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 2));
            p.accept(new ItemStack(Blocks.planks, 1, 2));
            p.accept(new ItemStack(Blocks.birch_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 2));
            p.accept(new ItemStack(ModBlocks.FENCE_BIRCH.get()));
            p.accept(new ItemStack(ModBlocks.FENCE_GATE_BIRCH.get()));
            p.accept(new ItemStack(ModBlocks.DOOR_BIRCH.get()));
            p.accept(new ItemStack(ModBlocks.TRAPDOOR_BIRCH.get()));
            p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_BIRCH.get()));
            p.accept(new ItemStack(ModBlocks.BUTTON_BIRCH.get()));

            // JUNGLE
            p.accept(new ItemStack(Blocks.log, 1, 3));
            p.accept(new ItemStack(ModBlocks.BARK.get(), 1, 3));
            p.accept(new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 3));
            p.accept(new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 3));
            p.accept(new ItemStack(Blocks.planks, 1, 3));
            p.accept(new ItemStack(Blocks.jungle_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 3));
            p.accept(new ItemStack(ModBlocks.FENCE_JUNGLE.get()));
            p.accept(new ItemStack(ModBlocks.FENCE_GATE_JUNGLE.get()));
            p.accept(new ItemStack(ModBlocks.DOOR_JUNGLE.get()));
            p.accept(new ItemStack(ModBlocks.TRAPDOOR_JUNGLE.get()));
            p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_JUNGLE.get()));
            p.accept(new ItemStack(ModBlocks.BUTTON_JUNGLE.get()));

            // ACACIA
            p.accept(new ItemStack(Blocks.log2, 1, 0));
            p.accept(new ItemStack(ModBlocks.BARK2.get(), 1, 0));
            p.accept(new ItemStack(ModBlocks.LOG2_STRIPPED.get(), 1, 0));
            p.accept(new ItemStack(ModBlocks.WOOD2_STRIPPED.get(), 1, 0));
            p.accept(new ItemStack(Blocks.planks, 1, 4));
            p.accept(new ItemStack(Blocks.acacia_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 4));
            p.accept(new ItemStack(ModBlocks.FENCE_ACACIA.get()));
            p.accept(new ItemStack(ModBlocks.FENCE_GATE_ACACIA.get()));
            p.accept(new ItemStack(ModBlocks.DOOR_ACACIA.get()));
            p.accept(new ItemStack(ModBlocks.TRAPDOOR_ACACIA.get()));
            p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_ACACIA.get()));
            p.accept(new ItemStack(ModBlocks.BUTTON_ACACIA.get()));

            // DARK OAK
            p.accept(new ItemStack(Blocks.log2, 1, 1));
            p.accept(new ItemStack(ModBlocks.BARK2.get(), 1, 1));
            p.accept(new ItemStack(ModBlocks.LOG2_STRIPPED.get(), 1, 1));
            p.accept(new ItemStack(ModBlocks.WOOD2_STRIPPED.get(), 1, 1));
            p.accept(new ItemStack(Blocks.planks, 1, 5));
            p.accept(new ItemStack(Blocks.dark_oak_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 5));
            p.accept(new ItemStack(ModBlocks.FENCE_DARK_OAK.get()));
            p.accept(new ItemStack(ModBlocks.FENCE_GATE_DARK_OAK.get()));
            p.accept(new ItemStack(ModBlocks.DOOR_DARK_OAK.get()));
            p.accept(new ItemStack(ModBlocks.TRAPDOOR_DARK_OAK.get()));
            p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_DARK_OAK.get()));
            p.accept(new ItemStack(ModBlocks.BUTTON_DARK_OAK.get()));
        }
    });

    public static final CreativeTabs COLORED_BLOCKS = new ModernCreativeTab("coloredBlocks", () -> new ItemStack(Blocks.wool, 1, 9), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs NATURAL_BLOCKS = new ModernCreativeTab("naturalBlocks", () -> new ItemStack(Blocks.grass), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs FUNCTIONAL_BLOCKS = new ModernCreativeTab("functionalBlocks", () -> new ItemStack(Items.sign), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs REDSTONE_BLOCKS = new ModernCreativeTab("redstoneBlocks", () -> new ItemStack(Items.redstone), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs HOTBAR = new ModernCreativeTab("hotbar", () -> new ItemStack(Blocks.bookshelf), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs TOOLS = new ModernCreativeTab("tools", () -> new ItemStack(Items.diamond_pickaxe), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs COMBAT = new ModernCreativeTab("combat", () -> ConfigBlocksItems.enableNetherite ? new ItemStack(ModItems.NETHERITE_SWORD.get()) : new ItemStack(Items.diamond_sword), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs FOOD_AND_DRINKS = new ModernCreativeTab("food", () -> new ItemStack(Items.golden_apple), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs INGREDIENTS = new ModernCreativeTab("ingredients", () -> new ItemStack(Items.iron_ingot), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs SPAWN_EGGS = new ModernCreativeTab("spawnEgg", () -> new ItemStack(Items.spawn_egg, 1, 90), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static final CreativeTabs OP = new ModernCreativeTab("op", () -> new ItemStack(Blocks.command_block), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
        }
    });

    public static void init() {
        // Just initializing the classes to register the tabs
    }
}
