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
            p.accept(new ItemStack(Blocks.log, 1, 0));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARK.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 0));
            }
            p.accept(new ItemStack(Blocks.planks, 1, 0));
            p.accept(new ItemStack(Blocks.oak_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 0));
            p.accept(new ItemStack(Blocks.fence));
            p.accept(new ItemStack(Blocks.fence_gate));
            p.accept(new ItemStack(Items.wooden_door));
            p.accept(new ItemStack(Blocks.trapdoor));
            p.accept(new ItemStack(Blocks.wooden_pressure_plate));
            p.accept(new ItemStack(Blocks.wooden_button));
            p.accept(new ItemStack(Blocks.log, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARK.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 1));
            }
            p.accept(new ItemStack(Blocks.planks, 1, 1));
            p.accept(new ItemStack(Blocks.spruce_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_SPRUCE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_GATE_SPRUCE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DOOR_SPRUCE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TRAPDOOR_SPRUCE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_SPRUCE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BUTTON_SPRUCE.get()));
            }
            p.accept(new ItemStack(Blocks.log, 1, 2));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARK.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 2));
            }
            p.accept(new ItemStack(Blocks.planks, 1, 2));
            p.accept(new ItemStack(Blocks.birch_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 2));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_BIRCH.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_GATE_BIRCH.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DOOR_BIRCH.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TRAPDOOR_BIRCH.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_BIRCH.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BUTTON_BIRCH.get()));
            }
            p.accept(new ItemStack(Blocks.log, 1, 3));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARK.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 3));
            }
            p.accept(new ItemStack(Blocks.planks, 1, 3));
            p.accept(new ItemStack(Blocks.jungle_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 3));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_JUNGLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_GATE_JUNGLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DOOR_JUNGLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TRAPDOOR_JUNGLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_JUNGLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BUTTON_JUNGLE.get()));
            }
            p.accept(new ItemStack(Blocks.log2, 1, 0));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARK2.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LOG2_STRIPPED.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD2_STRIPPED.get(), 1, 0));
            }
            p.accept(new ItemStack(Blocks.planks, 1, 4));
            p.accept(new ItemStack(Blocks.acacia_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 4));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_ACACIA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_GATE_ACACIA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DOOR_ACACIA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TRAPDOOR_ACACIA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_ACACIA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BUTTON_ACACIA.get()));
            }
            p.accept(new ItemStack(Blocks.log2, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARK2.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LOG2_STRIPPED.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD2_STRIPPED.get(), 1, 1));
            }
            p.accept(new ItemStack(Blocks.planks, 1, 5));
            p.accept(new ItemStack(Blocks.dark_oak_stairs));
            p.accept(new ItemStack(Blocks.wooden_slab, 1, 5));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_DARK_OAK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FENCE_GATE_DARK_OAK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DOOR_DARK_OAK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TRAPDOOR_DARK_OAK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRESSURE_PLATE_DARK_OAK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BUTTON_DARK_OAK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_LOG.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_LOG.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_LOG.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_FENCE_GATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_PRESSURE_PLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_BUTTON.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_LOG.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_LOG.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_LOG.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_FENCE_GATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_PRESSURE_PLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_BUTTON.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_BLOCK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_BLOCK.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_MOSAIC.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_MOSAIC_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_MOSAIC_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_FENCE_GATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_PRESSURE_PLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_BUTTON.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_STEM.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_FENCE_GATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_PRESSURE_PLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_BUTTON.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_STEM.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_FENCE_GATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_PRESSURE_PLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_BUTTON.get()));
            }
            p.accept(new ItemStack(Blocks.stone, 1, 0));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_SLAB.get()));
            }
            p.accept(new ItemStack(Blocks.cobblestone));
            p.accept(new ItemStack(Blocks.mossy_cobblestone));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MOSSY_COBBLESTONE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_STONE.get()));
            }
            p.accept(new ItemStack(Blocks.stone_slab, 1, 8));
            p.accept(new ItemStack(Blocks.stonebrick, 1, 0));
            p.accept(new ItemStack(Blocks.stonebrick, 1, 2));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_WALL.get(), 1, 0));
            }
            p.accept(new ItemStack(Blocks.stonebrick, 1, 3));
            p.accept(new ItemStack(Blocks.stonebrick, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MOSSY_STONE_BRICK_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_WALL.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.GRANITE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_GRANITE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DIORITE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_DIORITE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ANDESITE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 6));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_ANDESITE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COBBLED_DEEPSLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COBBLED_DEEPSLATE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_SLAB.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_WALL.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_DEEPSLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_DEEPSLATE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_SLAB.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_WALL.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_BRICK_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_BRICK_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_BRICK_WALL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_TILE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_BRICK_SLAB.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TUFF.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TUFF_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TUFF_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TUFF_WALL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_TUFF_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TUFF_BRICK_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_WALL.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PACKED_MUD.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MUD_BRICK_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MUD_BRICK_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MUD_BRICK_WALL.get()));
            }
            p.accept(new ItemStack(Blocks.sandstone, 1, 0));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE_WALL.get(), 1, 2));
            }
            p.accept(new ItemStack(Blocks.sandstone, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_SANDSTONE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_SANDSTONE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_SANDSTONE_SLAB.get()));
            }
            p.accept(new ItemStack(Blocks.sandstone, 1, 2));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_SANDSTONE.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_SANDSTONE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_SANDSTONE_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_SANDSTONE_WALL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_SANDSTONE.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_RED_SANDSTONE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_RED_SANDSTONE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_RED_SANDSTONE_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_SANDSTONE.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_SANDSTONE_SLAB.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SEA_LANTERN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_BLOCK.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_WALL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_BLOCK.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_STAIRS_BRICK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_BLOCK.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_STAIRS_DARK.get()));
            }
            p.accept(new ItemStack(Blocks.netherrack));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_BRICK_WALL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_NETHERBRICK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_NETHERBRICK_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_NETHERBRICK_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_NETHER_BRICK_WALL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BASALT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_BASALT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLACKSTONE.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.GILDED_BLACKSTONE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLACKSTONE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLACKSTONE_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLACKSTONE_WALL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_BLACKSTONE_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_BLACKSTONE_PRESSURE_PLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_BLACKSTONE_BUTTON.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POLISHED_BLACKSTONE_BRICK_STAIRS.get()));
            }
            p.accept(new ItemStack(Blocks.end_stone));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.END_BRICKS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.END_BRICK_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.END_BRICK_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.END_BRICK_WALL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PURPUR_BLOCK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PURPUR_PILLAR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PURPUR_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PURPUR_SLAB.get()));
            }
            p.accept(new ItemStack(Blocks.coal_block));
            p.accept(new ItemStack(Blocks.iron_block));
            p.accept(new ItemStack(Blocks.iron_bars));
            p.accept(new ItemStack(Items.iron_door));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.IRON_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHAIN.get()));
            }
            p.accept(new ItemStack(Blocks.gold_block));
            p.accept(new ItemStack(Blocks.redstone_block));
            p.accept(new ItemStack(Blocks.emerald_block));
            p.accept(new ItemStack(Blocks.lapis_block));
            p.accept(new ItemStack(Blocks.diamond_block));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHERITE_BLOCK.get()));
            }
            p.accept(new ItemStack(Blocks.quartz_block, 1, 0));
            p.accept(new ItemStack(Blocks.quartz_block, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.QUARTZ_BRICKS.get()));
            }
            p.accept(new ItemStack(Blocks.quartz_block, 1, 2));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_QUARTZ.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_QUARTZ_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOOTH_QUARTZ_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AMETHYST_BLOCK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHISELED_COPPER.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_GRATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_SLAB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BULB.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.EXPOSED_CUT_COPPER_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.EXPOSED_COPPER_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.EXPOSED_COPPER_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 6));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WEATHERED_CUT_COPPER_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WEATHERED_COPPER_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WEATHERED_COPPER_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 7));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.OXIDIZED_CUT_COPPER_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.OXIDIZED_COPPER_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 8));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_CUT_COPPER_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_COPPER_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_COPPER_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 9));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 13));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 10));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 6));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 6));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 14));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 6));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 11));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 7));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 7));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 15));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 7));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableNetherite) {
                    p.accept(new ItemStack(ModBlocks.NETHERITE_STAIRS.get()));
                }
            }
}
    });

    public static final CreativeTabs COLORED_BLOCKS = new ModernCreativeTab("coloredBlocks", () -> new ItemStack(Blocks.wool, 1, 9), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Blocks.wool, 1, 0));
            p.accept(new ItemStack(Blocks.wool, 1, 8));
            p.accept(new ItemStack(Blocks.wool, 1, 7));
            p.accept(new ItemStack(Blocks.wool, 1, 15));
            p.accept(new ItemStack(Blocks.wool, 1, 12));
            p.accept(new ItemStack(Blocks.wool, 1, 14));
            p.accept(new ItemStack(Blocks.wool, 1, 1));
            p.accept(new ItemStack(Blocks.wool, 1, 4));
            p.accept(new ItemStack(Blocks.wool, 1, 5));
            p.accept(new ItemStack(Blocks.wool, 1, 13));
            p.accept(new ItemStack(Blocks.wool, 1, 9));
            p.accept(new ItemStack(Blocks.wool, 1, 3));
            p.accept(new ItemStack(Blocks.wool, 1, 11));
            p.accept(new ItemStack(Blocks.wool, 1, 10));
            p.accept(new ItemStack(Blocks.wool, 1, 2));
            p.accept(new ItemStack(Blocks.wool, 1, 6));
            p.accept(new ItemStack(Blocks.carpet, 1, 0));
            p.accept(new ItemStack(Blocks.carpet, 1, 8));
            p.accept(new ItemStack(Blocks.carpet, 1, 7));
            p.accept(new ItemStack(Blocks.carpet, 1, 15));
            p.accept(new ItemStack(Blocks.carpet, 1, 12));
            p.accept(new ItemStack(Blocks.carpet, 1, 14));
            p.accept(new ItemStack(Blocks.carpet, 1, 1));
            p.accept(new ItemStack(Blocks.carpet, 1, 4));
            p.accept(new ItemStack(Blocks.carpet, 1, 5));
            p.accept(new ItemStack(Blocks.carpet, 1, 13));
            p.accept(new ItemStack(Blocks.carpet, 1, 9));
            p.accept(new ItemStack(Blocks.carpet, 1, 3));
            p.accept(new ItemStack(Blocks.carpet, 1, 11));
            p.accept(new ItemStack(Blocks.carpet, 1, 10));
            p.accept(new ItemStack(Blocks.carpet, 1, 2));
            p.accept(new ItemStack(Blocks.carpet, 1, 6));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 8));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 7));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 15));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 12));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 14));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 13));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 9));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 11));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 10));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE.get(), 1, 6));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 8));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 7));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 15));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 12));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 14));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 4));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 13));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 9));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 11));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 10));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 6));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WHITE_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.GRAY_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLACK_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BROWN_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ORANGE_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.YELLOW_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIME_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.GREEN_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CYAN_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLUE_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PURPLE_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MAGENTA_GLAZED_TERRACOTTA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PINK_GLAZED_TERRACOTTA.get()));
            }
            p.accept(new ItemStack(Blocks.glass));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 0));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 8));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 7));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 15));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 12));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 14));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 1));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 4));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 5));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 13));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 9));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 3));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 11));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 10));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 2));
            p.accept(new ItemStack(Blocks.stained_glass, 1, 6));
            p.accept(new ItemStack(Blocks.glass_pane));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 0));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 8));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 7));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 15));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 12));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 14));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 1));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 4));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 5));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 13));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 9));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 3));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 11));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 10));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 2));
            p.accept(new ItemStack(Blocks.stained_glass_pane, 1, 6));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WHITE_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIGHT_GRAY_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.GRAY_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLACK_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BROWN_BED.get()));
            }
            p.accept(new ItemStack(Items.bed));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ORANGE_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.YELLOW_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIME_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.GREEN_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CYAN_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIGHT_BLUE_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLUE_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PURPLE_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MAGENTA_BED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PINK_BED.get()));
            }
}
    });

    public static final CreativeTabs NATURAL_BLOCKS = new ModernCreativeTab("naturalBlocks", () -> new ItemStack(Blocks.grass), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Blocks.grass));
            p.accept(new ItemStack(Blocks.dirt, 1, 2));
            p.accept(new ItemStack(Blocks.mycelium));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.GRASS_PATH.get()));
            }
            p.accept(new ItemStack(Blocks.dirt, 1, 0));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COARSE_DIRT.get()));
            }
            p.accept(new ItemStack(Blocks.farmland));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MUD.get()));
            }
            p.accept(new ItemStack(Blocks.clay));
            p.accept(new ItemStack(Blocks.gravel));
            p.accept(new ItemStack(Blocks.sand, 1, 0));
            p.accept(new ItemStack(Blocks.sandstone, 1, 0));
            p.accept(new ItemStack(Blocks.sand, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_SANDSTONE.get(), 1, 0));
            }
            p.accept(new ItemStack(Blocks.ice));
            p.accept(new ItemStack(Blocks.packed_ice));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLUE_ICE.get()));
            }
            p.accept(new ItemStack(Blocks.snow));
            p.accept(new ItemStack(Blocks.snow_layer));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MOSS_BLOCK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MOSS_CARPET.get()));
            }
            p.accept(new ItemStack(Blocks.stone, 1, 0));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONE.get(), 1, 5));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CALCITE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TUFF.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DRIPSTONE_BLOCK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.POINTED_DRIPSTONE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PRISMARINE_BLOCK.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MAGMA.get()));
            }
            p.accept(new ItemStack(Blocks.obsidian));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRYING_OBSIDIAN.get()));
            }
            p.accept(new ItemStack(Blocks.netherrack));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NYLIUM.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NYLIUM.get(), 1, 1));
            }
            p.accept(new ItemStack(Blocks.soul_sand));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SOUL_SOIL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BONE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLACKSTONE.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BASALT.get()));
            }
            p.accept(new ItemStack(Blocks.end_stone));
            p.accept(new ItemStack(Blocks.coal_ore));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_COAL_ORE.get()));
            }
            p.accept(new ItemStack(Blocks.iron_ore));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_IRON_ORE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_ORE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_COPPER_ORE.get()));
            }
            p.accept(new ItemStack(Blocks.gold_ore));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_GOLD_ORE.get()));
            }
            p.accept(new ItemStack(Blocks.redstone_ore));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_REDSTONE_ORE.get()));
            }
            p.accept(new ItemStack(Blocks.emerald_ore));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_EMERALD_ORE.get()));
            }
            p.accept(new ItemStack(Blocks.lapis_ore));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_LAPIS_ORE.get()));
            }
            p.accept(new ItemStack(Blocks.diamond_ore));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DEEPSLATE_DIAMOND_ORE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_GOLD_ORE.get()));
            }
            p.accept(new ItemStack(Blocks.quartz_ore));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ANCIENT_DEBRIS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RAW_ORE_BLOCK.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RAW_ORE_BLOCK.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RAW_ORE_BLOCK.get(), 1, 2));
            }
            p.accept(new ItemStack(Blocks.glowstone));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AMETHYST_BLOCK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BUDDING_AMETHYST.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AMETHYST_CLUSTER_1.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AMETHYST_CLUSTER_1.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AMETHYST_CLUSTER_2.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AMETHYST_CLUSTER_2.get(), 1, 1));
            }
            p.accept(new ItemStack(Blocks.log, 1, 0));
            p.accept(new ItemStack(Blocks.log, 1, 1));
            p.accept(new ItemStack(Blocks.log, 1, 2));
            p.accept(new ItemStack(Blocks.log, 1, 3));
            p.accept(new ItemStack(Blocks.log2, 1, 0));
            p.accept(new ItemStack(Blocks.log2, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_LOG.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_ROOTS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MUDDY_MANGROVE_ROOTS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_LOG.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_STEM.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_STEM.get()));
            }
            p.accept(new ItemStack(Blocks.leaves, 1, 0));
            p.accept(new ItemStack(Blocks.leaves, 1, 1));
            p.accept(new ItemStack(Blocks.leaves, 1, 2));
            p.accept(new ItemStack(Blocks.leaves, 1, 3));
            p.accept(new ItemStack(Blocks.leaves2, 1, 0));
            p.accept(new ItemStack(Blocks.leaves2, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LEAVES.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LEAVES.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AZALEA_LEAVES.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AZALEA_LEAVES.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BROWN_MUSHROOM.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.RED_MUSHROOM.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SHROOMLIGHT.get()));
            }
            p.accept(new ItemStack(Blocks.sapling, 1, 0));
            p.accept(new ItemStack(Blocks.sapling, 1, 1));
            p.accept(new ItemStack(Blocks.sapling, 1, 2));
            p.accept(new ItemStack(Blocks.sapling, 1, 3));
            p.accept(new ItemStack(Blocks.sapling, 1, 4));
            p.accept(new ItemStack(Blocks.sapling, 1, 5));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SAPLING.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SAPLING.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AZALEA.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AZALEA.get(), 1, 1));
            }
            p.accept(new ItemStack(Blocks.brown_mushroom));
            p.accept(new ItemStack(Blocks.red_mushroom));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_FUNGUS.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_FUNGUS.get(), 1, 1));
            }
            p.accept(new ItemStack(Blocks.tallgrass, 1, 1));
            p.accept(new ItemStack(Blocks.tallgrass, 1, 2));
            p.accept(new ItemStack(Blocks.deadbush));
            p.accept(new ItemStack(Blocks.yellow_flower));
            p.accept(new ItemStack(Blocks.red_flower, 1, 0));
            p.accept(new ItemStack(Blocks.red_flower, 1, 1));
            p.accept(new ItemStack(Blocks.red_flower, 1, 2));
            p.accept(new ItemStack(Blocks.red_flower, 1, 3));
            p.accept(new ItemStack(Blocks.red_flower, 1, 4));
            p.accept(new ItemStack(Blocks.red_flower, 1, 5));
            p.accept(new ItemStack(Blocks.red_flower, 1, 6));
            p.accept(new ItemStack(Blocks.red_flower, 1, 7));
            p.accept(new ItemStack(Blocks.red_flower, 1, 8));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CORNFLOWER.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LILY_OF_THE_VALLEY.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WITHER_ROSE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.PINK_PETALS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.BAMBOO.get()));
            }
            p.accept(new ItemStack(Items.reeds));
            p.accept(new ItemStack(Blocks.cactus));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_ROOTS.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_ROOTS.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_SPROUTS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WEEPING_VINES.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TWISTING_VINES.get()));
            }
            p.accept(new ItemStack(Blocks.vine));
            p.accept(new ItemStack(Blocks.double_plant, 1, 2));
            p.accept(new ItemStack(Blocks.double_plant, 1, 3));
            p.accept(new ItemStack(Blocks.double_plant, 1, 0));
            p.accept(new ItemStack(Blocks.double_plant, 1, 1));
            p.accept(new ItemStack(Blocks.double_plant, 1, 4));
            p.accept(new ItemStack(Blocks.double_plant, 1, 5));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHORUS_PLANT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHORUS_FLOWER.get()));
            }
            p.accept(new ItemStack(Items.wheat_seeds));
            p.accept(new ItemStack(Items.dye, 1, 3));
            p.accept(new ItemStack(Items.pumpkin_seeds));
            p.accept(new ItemStack(Items.melon_seeds));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.BEETROOT_SEEDS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_WART.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SPONGE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SPONGE.get(), 1, 1));
            }
            p.accept(new ItemStack(Blocks.melon_block));
            p.accept(new ItemStack(Blocks.pumpkin));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BEE_NEST.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.HONEYCOMB_BLOCK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SLIME.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.HONEY_BLOCK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SCULK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SCULK_CATALYST.get()));
            }
            p.accept(new ItemStack(Blocks.web));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslate) {
                    p.accept(new ItemStack(ModBlocks.MODDED_DEEPSLATE_ORE.get()));
                }
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableRawOres) {
                    p.accept(new ItemStack(ModBlocks.MODDED_RAW_ORE_BLOCK.get()));
                }
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableNetherite) {
                    p.accept(new ItemStack(ModBlocks.RAW_ADAMANTIUM_BLOCK.get()));
                }
                if (ganymedes01.etfuturum.configuration.configs.ConfigTweaks.enableOldGravel) {
                    p.accept(new ItemStack(ModBlocks.OLD_GRAVEL.get()));
                }
                if (ganymedes01.etfuturum.configuration.configs.ConfigTweaks.enableRoses) {
                    p.accept(new ItemStack(ModBlocks.ROSE.get()));
                }
            }
}
    });

    public static final CreativeTabs FUNCTIONAL_BLOCKS = new ModernCreativeTab("functionalBlocks", () -> new ItemStack(Items.sign), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Blocks.torch));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SOUL_TORCH.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LANTERN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SOUL_LANTERN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHAIN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.END_ROD.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SEA_LANTERN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COPPER_BULB.get()));
            }
            p.accept(new ItemStack(Blocks.glowstone));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SHROOMLIGHT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRYING_OBSIDIAN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MAGMA.get()));
            }
            p.accept(new ItemStack(Blocks.crafting_table));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.STONECUTTER.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CARTOGRAPHY_TABLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.FLETCHING_TABLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMITHING_TABLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LOOM.get()));
            }
            p.accept(new ItemStack(Blocks.furnace));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SMOKER.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BLAST_FURNACE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ANVIL.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ANVIL.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ANVIL.get(), 1, 2));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COMPOSTER.get()));
            }
            p.accept(new ItemStack(Blocks.noteblock));
            p.accept(new ItemStack(Blocks.jukebox));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ENCHANTMENT_TABLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BREWING_STAND.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BEACON.get()));
            }
            p.accept(new ItemStack(Blocks.ladder));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BEE_NEST.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BEEHIVE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIGHTNING_ROD.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.WOODEN_ARMORSTAND.get()));
            }
            p.accept(new ItemStack(Blocks.bookshelf));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TINTED_GLASS.get()));
            }
            p.accept(new ItemStack(Items.sign));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.ITEM_SIGN_SPRUCE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.ITEM_SIGN_BIRCH.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.ITEM_SIGN_JUNGLE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.ITEM_SIGN_ACACIA.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.ITEM_SIGN_DARK_OAK.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.MANGROVE_SIGN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CHERRY_SIGN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BAMBOO_SIGN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.CRIMSON_SIGN.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.WARPED_SIGN.get()));
            }
            p.accept(new ItemStack(Blocks.chest));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARREL.get()));
            }
            p.accept(new ItemStack(Blocks.ender_chest));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SHULKER_BOX.get()));
            }
            p.accept(new ItemStack(Blocks.monster_egg, 1, 0));
            p.accept(new ItemStack(Blocks.monster_egg, 1, 1));
            p.accept(new ItemStack(Blocks.monster_egg, 1, 2));
            p.accept(new ItemStack(Blocks.monster_egg, 1, 3));
            p.accept(new ItemStack(Blocks.monster_egg, 1, 4));
            p.accept(new ItemStack(Blocks.monster_egg, 1, 5));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableBarrel) {
                    p.accept(new ItemStack(ModBlocks.COPPER_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.IRON_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.SILVER_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.GOLD_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.DIAMOND_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.OBSIDIAN_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.NETHERITE_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.STEEL_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.DARKSTEEL_BARREL.get()));
                    p.accept(new ItemStack(ModBlocks.CRYSTAL_BARREL.get()));
                    p.accept(new ItemStack(ModItems.BARREL_UPGRADE.get()));
                }
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableShulkerBoxes) {
                    p.accept(new ItemStack(ModItems.SHULKER_BOX_UPGRADE.get()));
                }
            }
}
    });

    public static final CreativeTabs REDSTONE_BLOCKS = new ModernCreativeTab("redstoneBlocks", () -> new ItemStack(Items.redstone), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Items.redstone));
            p.accept(new ItemStack(Blocks.redstone_torch));
            p.accept(new ItemStack(Blocks.redstone_block));
            p.accept(new ItemStack(Items.repeater));
            p.accept(new ItemStack(Items.comparator));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.TARGET.get()));
            }
            p.accept(new ItemStack(Blocks.lever));
            p.accept(new ItemStack(Blocks.wooden_button));
            p.accept(new ItemStack(Blocks.wooden_pressure_plate));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.AMETHYST_BLOCK.get()));
            }
            p.accept(new ItemStack(Blocks.wool, 1, 0));
            p.accept(new ItemStack(Blocks.tripwire_hook));
            p.accept(new ItemStack(Items.string));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.DAYLIGHT_DETECTOR.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIGHTNING_ROD.get()));
            }
            p.accept(new ItemStack(Blocks.piston));
            p.accept(new ItemStack(Blocks.sticky_piston));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.SLIME.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.HONEY_BLOCK.get()));
            }
            p.accept(new ItemStack(Blocks.dispenser));
            p.accept(new ItemStack(Blocks.dropper));
            p.accept(new ItemStack(Blocks.hopper));
            p.accept(new ItemStack(Blocks.chest));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARREL.get()));
            }
            p.accept(new ItemStack(Blocks.furnace));
            p.accept(new ItemStack(Blocks.trapped_chest));
            p.accept(new ItemStack(Blocks.jukebox));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.OBSERVER.get()));
            }
            p.accept(new ItemStack(Blocks.noteblock));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.COMPOSTER.get()));
            }
            p.accept(new ItemStack(Blocks.rail));
            p.accept(new ItemStack(Blocks.golden_rail));
            p.accept(new ItemStack(Blocks.detector_rail));
            p.accept(new ItemStack(Blocks.activator_rail));
            p.accept(new ItemStack(Items.iron_door));
            p.accept(new ItemStack(Blocks.fence_gate));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.IRON_TRAPDOOR.get()));
            }
            p.accept(new ItemStack(Blocks.tnt));
            p.accept(new ItemStack(Blocks.redstone_lamp));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.WOODEN_ARMORSTAND.get()));
            }
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
            p.accept(new ItemStack(Items.wooden_shovel));
            p.accept(new ItemStack(Items.wooden_pickaxe));
            p.accept(new ItemStack(Items.wooden_axe));
            p.accept(new ItemStack(Items.wooden_hoe));
            p.accept(new ItemStack(Items.stone_shovel));
            p.accept(new ItemStack(Items.stone_pickaxe));
            p.accept(new ItemStack(Items.stone_axe));
            p.accept(new ItemStack(Items.stone_hoe));
            p.accept(new ItemStack(Items.iron_shovel));
            p.accept(new ItemStack(Items.iron_pickaxe));
            p.accept(new ItemStack(Items.iron_axe));
            p.accept(new ItemStack(Items.iron_hoe));
            p.accept(new ItemStack(Items.golden_shovel));
            p.accept(new ItemStack(Items.golden_pickaxe));
            p.accept(new ItemStack(Items.golden_axe));
            p.accept(new ItemStack(Items.golden_hoe));
            p.accept(new ItemStack(Items.diamond_shovel));
            p.accept(new ItemStack(Items.diamond_pickaxe));
            p.accept(new ItemStack(Items.diamond_axe));
            p.accept(new ItemStack(Items.diamond_hoe));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_SPADE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_PICKAXE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_AXE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_HOE.get()));
            }
            p.accept(new ItemStack(Items.bucket));
            p.accept(new ItemStack(Items.water_bucket));
            p.accept(new ItemStack(Items.lava_bucket));
            p.accept(new ItemStack(Items.milk_bucket));
            p.accept(new ItemStack(Items.fishing_rod));
            p.accept(new ItemStack(Items.flint_and_steel));
            p.accept(new ItemStack(Items.fire_charge));
            p.accept(new ItemStack(Items.dye, 1, 15));
            p.accept(new ItemStack(Items.shears));
            p.accept(new ItemStack(Items.name_tag));
            p.accept(new ItemStack(Items.lead));
            p.accept(new ItemStack(Items.compass));
            p.accept(new ItemStack(Items.clock));
            p.accept(new ItemStack(Items.map));
            p.accept(new ItemStack(Items.writable_book));
            p.accept(new ItemStack(Items.ender_pearl));
            p.accept(new ItemStack(Items.ender_eye));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.ELYTRA.get()));
            }
            p.accept(new ItemStack(Items.saddle));
            p.accept(new ItemStack(Items.carrot_on_a_stick));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.OAK_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.OAK_CHEST_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.SPRUCE_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.SPRUCE_CHEST_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.BIRCH_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.BIRCH_CHEST_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.JUNGLE_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.JUNGLE_CHEST_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.ACACIA_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.ACACIA_CHEST_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.DARK_OAK_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.DARK_OAK_CHEST_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.MANGROVE_OAK_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.MANGROVE_CHEST_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.CHERRY_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.CHERRY_CHEST_BOAT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.BAMBOO_RAFT.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.BAMBOO_CHEST_RAFT.get()));
            }
            p.accept(new ItemStack(Blocks.rail));
            p.accept(new ItemStack(Blocks.golden_rail));
            p.accept(new ItemStack(Blocks.detector_rail));
            p.accept(new ItemStack(Blocks.activator_rail));
            p.accept(new ItemStack(Items.minecart));
            p.accept(new ItemStack(Items.hopper_minecart));
            p.accept(new ItemStack(Items.chest_minecart));
            p.accept(new ItemStack(Items.furnace_minecart));
            p.accept(new ItemStack(Items.tnt_minecart));
            p.accept(new ItemStack(Items.record_13));
            p.accept(new ItemStack(Items.record_cat));
            p.accept(new ItemStack(Items.record_blocks));
            p.accept(new ItemStack(Items.record_chirp));
            p.accept(new ItemStack(Items.record_far));
            p.accept(new ItemStack(Items.record_mall));
            p.accept(new ItemStack(Items.record_mellohi));
            p.accept(new ItemStack(Items.record_stal));
            p.accept(new ItemStack(Items.record_strad));
            p.accept(new ItemStack(Items.record_ward));
            p.accept(new ItemStack(Items.record_11));
            p.accept(new ItemStack(Items.record_wait));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.OTHERSIDE_RECORD.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.PIGSTEP_RECORD.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.configuration.configs.ConfigEntities.enableGoats) {
                    java.util.List<ItemStack> horns = new java.util.ArrayList<>();
                    ModItems.GOAT_HORN.get().getSubItems(ModItems.GOAT_HORN.get(), null, horns);
                    for (ItemStack stack : horns) {
                        p.accept(stack);
                    }
                }
            }
}
    });

    public static final CreativeTabs COMBAT = new ModernCreativeTab("combat", () -> ConfigBlocksItems.enableNetherite ? new ItemStack(ModItems.NETHERITE_SWORD.get()) : new ItemStack(Items.diamond_sword), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Items.wooden_sword));
            p.accept(new ItemStack(Items.stone_sword));
            p.accept(new ItemStack(Items.iron_sword));
            p.accept(new ItemStack(Items.golden_sword));
            p.accept(new ItemStack(Items.diamond_sword));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_SWORD.get()));
            }
            p.accept(new ItemStack(Items.wooden_axe));
            p.accept(new ItemStack(Items.stone_axe));
            p.accept(new ItemStack(Items.iron_axe));
            p.accept(new ItemStack(Items.golden_axe));
            p.accept(new ItemStack(Items.diamond_axe));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_AXE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.TRIDENT.get()));
            }
            p.accept(new ItemStack(Items.leather_helmet));
            p.accept(new ItemStack(Items.leather_chestplate));
            p.accept(new ItemStack(Items.leather_leggings));
            p.accept(new ItemStack(Items.leather_boots));
            p.accept(new ItemStack(Items.chainmail_helmet));
            p.accept(new ItemStack(Items.chainmail_chestplate));
            p.accept(new ItemStack(Items.chainmail_leggings));
            p.accept(new ItemStack(Items.chainmail_boots));
            p.accept(new ItemStack(Items.iron_helmet));
            p.accept(new ItemStack(Items.iron_chestplate));
            p.accept(new ItemStack(Items.iron_leggings));
            p.accept(new ItemStack(Items.iron_boots));
            p.accept(new ItemStack(Items.golden_helmet));
            p.accept(new ItemStack(Items.golden_chestplate));
            p.accept(new ItemStack(Items.golden_leggings));
            p.accept(new ItemStack(Items.golden_boots));
            p.accept(new ItemStack(Items.diamond_helmet));
            p.accept(new ItemStack(Items.diamond_chestplate));
            p.accept(new ItemStack(Items.diamond_leggings));
            p.accept(new ItemStack(Items.diamond_boots));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_HELMET.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_CHESTPLATE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_LEGGINGS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_BOOTS.get()));
            }
            p.accept(new ItemStack(Items.iron_horse_armor));
            p.accept(new ItemStack(Items.golden_horse_armor));
            p.accept(new ItemStack(Items.diamond_horse_armor));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.TOTEM_OF_UNDYING.get()));
            }
            p.accept(new ItemStack(Blocks.tnt));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.END_CRYSTAL.get()));
            }
            p.accept(new ItemStack(Items.snowball));
            p.accept(new ItemStack(Items.egg));
            p.accept(new ItemStack(Items.bow));
            p.accept(new ItemStack(Items.arrow));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.SPECTRAL_ARROW.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableTippedArrows) {
                    java.util.List<ItemStack> tippedArrows = new java.util.ArrayList<>();
                    ModItems.TIPPED_ARROW.get().getSubItems(ModItems.TIPPED_ARROW.get(), null, tippedArrows);
                    for (ItemStack stack : tippedArrows) {
                        p.accept(stack);
                    }
                }
            }
}
    });

    public static final CreativeTabs FOOD_AND_DRINKS = new ModernCreativeTab("food", () -> new ItemStack(Items.golden_apple), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Items.apple));
            p.accept(new ItemStack(Items.golden_apple, 1, 0));
            p.accept(new ItemStack(Items.golden_apple, 1, 1));
            p.accept(new ItemStack(Items.melon));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.SWEET_BERRIES.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.CHORUS_FRUIT.get()));
            }
            p.accept(new ItemStack(Items.carrot));
            p.accept(new ItemStack(Items.golden_carrot));
            p.accept(new ItemStack(Items.potato));
            p.accept(new ItemStack(Items.baked_potato));
            p.accept(new ItemStack(Items.poisonous_potato));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.BEETROOT.get()));
            }
            p.accept(new ItemStack(Items.beef));
            p.accept(new ItemStack(Items.cooked_beef));
            p.accept(new ItemStack(Items.porkchop));
            p.accept(new ItemStack(Items.cooked_porkchop));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.MUTTON_RAW.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.MUTTON_COOKED.get()));
            }
            p.accept(new ItemStack(Items.chicken));
            p.accept(new ItemStack(Items.cooked_chicken));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.RABBIT_RAW.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.RABBIT_COOKED.get()));
            }
            p.accept(new ItemStack(Items.fish, 1, 0));
            p.accept(new ItemStack(Items.cooked_fished, 1, 0));
            p.accept(new ItemStack(Items.fish, 1, 1));
            p.accept(new ItemStack(Items.cooked_fished, 1, 1));
            p.accept(new ItemStack(Items.fish, 1, 2));
            p.accept(new ItemStack(Items.fish, 1, 3));
            p.accept(new ItemStack(Items.bread));
            p.accept(new ItemStack(Items.cookie));
            p.accept(new ItemStack(Items.cake));
            p.accept(new ItemStack(Items.pumpkin_pie));
            p.accept(new ItemStack(Items.rotten_flesh));
            p.accept(new ItemStack(Items.spider_eye));
            p.accept(new ItemStack(Items.mushroom_stew));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.BEETROOT_SOUP.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.RABBIT_STEW.get()));
            }
            p.accept(new ItemStack(Items.milk_bucket));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.HONEY_BOTTLE.get()));
            }
            {
                java.util.List<ItemStack> vanillaPotions = new java.util.ArrayList<>();
                Items.potionitem.getSubItems(Items.potionitem, null, vanillaPotions);
                for (ItemStack stack : vanillaPotions) {
                    p.accept(stack);
                }
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableLingeringPotions) {
                    java.util.List<ItemStack> lingeringPotions = new java.util.ArrayList<>();
                    ModItems.LINGERING_POTION.get().getSubItems(ModItems.LINGERING_POTION.get(), null, lingeringPotions);
                    for (ItemStack stack : lingeringPotions) {
                        p.accept(stack);
                    }
                }
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableSuspiciousStew) {
                    p.accept(new ItemStack(ModItems.SUSPICIOUS_STEW.get()));
                }
            }
}
    });

    public static final CreativeTabs INGREDIENTS = new ModernCreativeTab("ingredients", () -> new ItemStack(Items.iron_ingot), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Items.coal, 1, 0));
            p.accept(new ItemStack(Items.coal, 1, 1));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.RAW_ORE.get(), 1, 1));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.RAW_ORE.get(), 1, 0));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.RAW_ORE.get(), 1, 2));
            }
            p.accept(new ItemStack(Items.emerald));
            p.accept(new ItemStack(Items.dye, 1, 4));
            p.accept(new ItemStack(Items.diamond));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.ANCIENT_DEBRIS.get()));
            }
            p.accept(new ItemStack(Items.quartz));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.AMETHYST_SHARD.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NUGGET_IRON.get()));
            }
            p.accept(new ItemStack(Items.gold_nugget));
            p.accept(new ItemStack(Items.iron_ingot));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.COPPER_INGOT.get()));
            }
            p.accept(new ItemStack(Items.gold_ingot));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_SCRAP.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NETHERITE_INGOT.get()));
            }
            p.accept(new ItemStack(Items.stick));
            p.accept(new ItemStack(Items.flint));
            p.accept(new ItemStack(Items.wheat));
            p.accept(new ItemStack(Items.bone));
            p.accept(new ItemStack(Items.dye, 1, 15));
            p.accept(new ItemStack(Items.string));
            p.accept(new ItemStack(Items.feather));
            p.accept(new ItemStack(Items.snowball));
            p.accept(new ItemStack(Items.egg));
            p.accept(new ItemStack(Items.leather));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.RABBIT_HIDE.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.HONEYCOMB.get()));
            }
            p.accept(new ItemStack(Items.dye, 1, 0));
            p.accept(new ItemStack(Items.slime_ball));
            p.accept(new ItemStack(Items.clay_ball));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.PRISMARINE_SHARD.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.PRISMARINE_CRYSTALS.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.NAUTILUS_SHELL.get()));
            }
            p.accept(new ItemStack(Items.blaze_rod));
            p.accept(new ItemStack(Items.nether_star));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.SHULKER_SHELL.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.CHORUS_FRUIT_POPPED.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.DYE.get(), 1, 0));
            }
            p.accept(new ItemStack(Items.dye, 1, 7));
            p.accept(new ItemStack(Items.dye, 1, 8));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.DYE.get(), 1, 3));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.DYE.get(), 1, 2));
            }
            p.accept(new ItemStack(Items.dye, 1, 1));
            p.accept(new ItemStack(Items.dye, 1, 14));
            p.accept(new ItemStack(Items.dye, 1, 11));
            p.accept(new ItemStack(Items.dye, 1, 10));
            p.accept(new ItemStack(Items.dye, 1, 2));
            p.accept(new ItemStack(Items.dye, 1, 6));
            p.accept(new ItemStack(Items.dye, 1, 12));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.DYE.get(), 1, 1));
            }
            p.accept(new ItemStack(Items.dye, 1, 5));
            p.accept(new ItemStack(Items.dye, 1, 13));
            p.accept(new ItemStack(Items.dye, 1, 9));
            p.accept(new ItemStack(Items.bowl));
            p.accept(new ItemStack(Items.brick));
            p.accept(new ItemStack(Items.netherbrick));
            p.accept(new ItemStack(Items.paper));
            p.accept(new ItemStack(Items.book));
            p.accept(new ItemStack(Items.firework_charge));
            p.accept(new ItemStack(Items.glass_bottle));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.NETHER_WART.get()));
            }
            p.accept(new ItemStack(Items.redstone));
            p.accept(new ItemStack(Items.glowstone_dust));
            p.accept(new ItemStack(Items.gunpowder));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.DRAGON_BREATH.get()));
            }
            p.accept(new ItemStack(Items.fermented_spider_eye));
            p.accept(new ItemStack(Items.blaze_powder));
            p.accept(new ItemStack(Items.sugar));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModItems.RABBIT_FOOT.get()));
            }
            p.accept(new ItemStack(Items.speckled_melon));
            p.accept(new ItemStack(Items.spider_eye));
            p.accept(new ItemStack(Items.fish, 1, 3));
            p.accept(new ItemStack(Items.magma_cream));
            p.accept(new ItemStack(Items.golden_carrot));
            p.accept(new ItemStack(Items.ghast_tear));
            p.accept(new ItemStack(Items.experience_bottle));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableRawOres) {
                    p.accept(new ItemStack(ModItems.MODDED_RAW_ORE.get()));
                }
                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableNetherite) {
                    p.accept(new ItemStack(ModItems.RAW_ADAMANTIUM.get()));
                }
            }
}
    });

    public static final CreativeTabs SPAWN_EGGS = new ModernCreativeTab("spawnEgg", () -> new ItemStack(Items.spawn_egg, 1, 90), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Blocks.mob_spawner));
            p.accept(new ItemStack(Items.spawn_egg, 1, 65));
            p.accept(new ItemStack(Items.spawn_egg, 1, 61));
            p.accept(new ItemStack(Items.spawn_egg, 1, 59));
            p.accept(new ItemStack(Items.spawn_egg, 1, 93));
            p.accept(new ItemStack(Items.spawn_egg, 1, 92));
            p.accept(new ItemStack(Items.spawn_egg, 1, 50));
            p.accept(new ItemStack(Items.spawn_egg, 1, 31));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                Integer eggId = ganymedes01.etfuturum.entities.ModEntityList.eggIds.get(ganymedes01.etfuturum.entities.EntityDrowned.class);
                if (eggId != null) {
                    p.accept(new ItemStack(Items.spawn_egg, 1, eggId));
                }
            }
            p.accept(new ItemStack(Items.spawn_egg, 1, 58));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                Integer eggId = ganymedes01.etfuturum.entities.ModEntityList.eggIds.get(ganymedes01.etfuturum.entities.EntityEndermite.class);
                if (eggId != null) {
                    p.accept(new ItemStack(Items.spawn_egg, 1, eggId));
                }
            }
            p.accept(new ItemStack(Items.spawn_egg, 1, 56));
            p.accept(new ItemStack(Items.spawn_egg, 1, 100));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                Integer eggId = ganymedes01.etfuturum.entities.ModEntityList.eggIds.get(ganymedes01.etfuturum.entities.EntityHusk.class);
                if (eggId != null) {
                    p.accept(new ItemStack(Items.spawn_egg, 1, eggId));
                }
            }
            p.accept(new ItemStack(Items.spawn_egg, 1, 62));
            p.accept(new ItemStack(Items.spawn_egg, 1, 96));
            p.accept(new ItemStack(Items.spawn_egg, 1, 32));
            p.accept(new ItemStack(Items.spawn_egg, 1, 98));
            p.accept(new ItemStack(Items.spawn_egg, 1, 90));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                Integer eggId = ganymedes01.etfuturum.entities.ModEntityList.eggIds.get(ganymedes01.etfuturum.entities.EntityPolarBear.class);
                if (eggId != null) {
                    p.accept(new ItemStack(Items.spawn_egg, 1, eggId));
                }
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                Integer eggId = ganymedes01.etfuturum.entities.ModEntityList.eggIds.get(ganymedes01.etfuturum.entities.EntityRabbit.class);
                if (eggId != null) {
                    p.accept(new ItemStack(Items.spawn_egg, 1, eggId));
                }
            }
            p.accept(new ItemStack(Items.spawn_egg, 1, 91));
            p.accept(new ItemStack(Items.spawn_egg, 1, 60));
            p.accept(new ItemStack(Items.spawn_egg, 1, 51));
            p.accept(new ItemStack(Items.spawn_egg, 1, 28));
            p.accept(new ItemStack(Items.spawn_egg, 1, 55));
            p.accept(new ItemStack(Items.spawn_egg, 1, 52));
            p.accept(new ItemStack(Items.spawn_egg, 1, 94));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                Integer eggId = ganymedes01.etfuturum.entities.ModEntityList.eggIds.get(ganymedes01.etfuturum.entities.EntityStray.class);
                if (eggId != null) {
                    p.accept(new ItemStack(Items.spawn_egg, 1, eggId));
                }
            }
            p.accept(new ItemStack(Items.spawn_egg, 1, 120));
            p.accept(new ItemStack(Items.spawn_egg, 1, 66));
            p.accept(new ItemStack(Items.spawn_egg, 1, 95));
            p.accept(new ItemStack(Items.spawn_egg, 1, 54));
            p.accept(new ItemStack(Items.spawn_egg, 1, 29));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                Integer eggId = ganymedes01.etfuturum.entities.ModEntityList.eggIds.get(ganymedes01.etfuturum.entities.EntityZombieVillager.class);
                if (eggId != null) {
                    p.accept(new ItemStack(Items.spawn_egg, 1, eggId));
                }
            }
            p.accept(new ItemStack(Items.spawn_egg, 1, 57));
}
    });

    public static final CreativeTabs OP = new ModernCreativeTab("op", () -> new ItemStack(Blocks.command_block), new CreativeTabPopulator() {
        @Override
        public void populate(CreativeTabDisplayBuilder p) {
            p.accept(new ItemStack(Blocks.command_block));
            p.accept(new ItemStack(Items.command_block_minecart));
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.BARRIER.get()));
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                if (ganymedes01.etfuturum.lib.Reference.DEV_ENVIRONMENT) {
                    p.accept(new ItemStack(ModItems.DEBUGGING_TOOL.get()));
                }
            }
            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                p.accept(new ItemStack(ModBlocks.LIGHT.get()));
            }
}
    });

    public static void init() {
        // Just initializing the classes to register the tabs
    }

    public static void postInit() {
        java.util.List<CreativeTabs> modTabs = new java.util.ArrayList<CreativeTabs>();
        CreativeTabs[] moderns = new CreativeTabs[]{BUILDING_BLOCKS, COLORED_BLOCKS, NATURAL_BLOCKS, FUNCTIONAL_BLOCKS, REDSTONE_BLOCKS, HOTBAR, CreativeTabs.tabAllSearch, TOOLS, COMBAT, FOOD_AND_DRINKS, INGREDIENTS, SPAWN_EGGS, OP, CreativeTabs.tabInventory};
        java.util.List<CreativeTabs> modernList = java.util.Arrays.asList(moderns);
        
        for (CreativeTabs tab : CreativeTabs.creativeTabArray) {
            if (tab != null && !modernList.contains(tab)) {
                boolean isVanilla = false;
                for (int i = 0; i < 12; i++) {
                    if (tab == CreativeTabs.creativeTabArray[i] && tab != CreativeTabs.tabAllSearch && tab != CreativeTabs.tabInventory) {
                        isVanilla = true;
                        break;
                    }
                }
                if (!isVanilla) {
                    // If we want EFR items sorted in vanilla tabs, we hide EFR's separate custom tabs
                    if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {
                        if (tab == ganymedes01.etfuturum.EtFuturum.creativeTabBlocks || tab == ganymedes01.etfuturum.EtFuturum.creativeTabItems) {
                            continue;
                        }
                    }
                    modTabs.add(tab);
                }
            }
        }

        CreativeTabs[] newArray = new CreativeTabs[moderns.length + modTabs.size()];
        
        try {
            String[] fieldNames = new String[]{"tabIndex", "field_78033_n"};
            java.lang.reflect.Field modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            
            java.lang.reflect.Field targetField = null;
            for (String name : fieldNames) {
                try {
                    targetField = CreativeTabs.class.getDeclaredField(name);
                    targetField.setAccessible(true);
                    modifiersField.setInt(targetField, targetField.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
                    break;
                } catch (Exception e) {}
            }
            
            for (int i = 0; i < moderns.length; i++) {
                newArray[i] = moderns[i];
                if (targetField != null) {
                    targetField.setInt(moderns[i], i);
                }
            }
            
            for (int i = 0; i < modTabs.size(); i++) {
                CreativeTabs modTab = modTabs.get(i);
                newArray[moderns.length + i] = modTab;
                if (targetField != null) {
                    targetField.setInt(modTab, moderns.length + i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CreativeTabs.creativeTabArray = newArray;
    }
}
