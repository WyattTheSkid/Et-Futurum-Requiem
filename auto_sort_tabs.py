#!/usr/bin/env python3
import os
import re

# Paths relative to project root
MAPPING_PATH = "creative_inventory_mapping.md"
TABS_FILE_PATH = "src/main/java/ganymedes01/etfuturum/core/handlers/creativetabs/ModernCreativeTabs.java"
BLOCKS_PATH = "src/main/java/ganymedes01/etfuturum/ModBlocks.java"
ITEMS_PATH = "src/main/java/ganymedes01/etfuturum/ModItems.java"

TABS = {
    "Building Blocks": "BUILDING_BLOCKS",
    "Colored Blocks": "COLORED_BLOCKS",
    "Natural Blocks": "NATURAL_BLOCKS",
    "Functional Blocks": "FUNCTIONAL_BLOCKS",
    "Redstone Blocks": "REDSTONE_BLOCKS",
    "Tools & Utilities": "TOOLS",
    "Combat": "COMBAT",
    "Food & Drinks": "FOOD_AND_DRINKS",
    "Ingredients": "INGREDIENTS",
    "Spawn Eggs": "SPAWN_EGGS",
    "Operator Utilities": "OP"
}

# Manual overrides for omitted or custom metadata/blocks
MANUAL_MAPPINGS = {
    # Natural Blocks
    "minecraft:red_sand": "new ItemStack(Blocks.sand, 1, 1)",
    "minecraft:podzol": "new ItemStack(Blocks.dirt, 1, 2)",
    "minecraft:dirt_path": "new ItemStack(ModBlocks.GRASS_PATH.get())",
    "minecraft:wet_sponge": "new ItemStack(ModBlocks.SPONGE.get(), 1, 1)",
    "minecraft:slime_block": "new ItemStack(ModBlocks.SLIME.get())",
    "minecraft:magma_block": "new ItemStack(ModBlocks.MAGMA.get())",

    # Stripped logs and wood
    "minecraft:stripped_oak_log": "new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 0)",
    "minecraft:stripped_oak_wood": "new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 0)",
    "minecraft:stripped_spruce_log": "new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 1)",
    "minecraft:stripped_spruce_wood": "new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 1)",
    "minecraft:stripped_birch_log": "new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 2)",
    "minecraft:stripped_birch_wood": "new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 2)",
    "minecraft:stripped_jungle_log": "new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 3)",
    "minecraft:stripped_jungle_wood": "new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 3)",
    "minecraft:stripped_acacia_log": "new ItemStack(ModBlocks.LOG2_STRIPPED.get(), 1, 0)",
    "minecraft:stripped_acacia_wood": "new ItemStack(ModBlocks.WOOD2_STRIPPED.get(), 1, 0)",
    "minecraft:stripped_dark_oak_log": "new ItemStack(ModBlocks.LOG2_STRIPPED.get(), 1, 1)",
    "minecraft:stripped_dark_oak_wood": "new ItemStack(ModBlocks.WOOD2_STRIPPED.get(), 1, 1)",
    "minecraft:stripped_mangrove_log": "new ItemStack(ModBlocks.MANGROVE_LOG.get(), 1, 2)",
    "minecraft:stripped_mangrove_wood": "new ItemStack(ModBlocks.MANGROVE_LOG.get(), 1, 3)",
    "minecraft:stripped_cherry_log": "new ItemStack(ModBlocks.CHERRY_LOG.get(), 1, 2)",
    "minecraft:stripped_cherry_wood": "new ItemStack(ModBlocks.CHERRY_LOG.get(), 1, 3)",
    "minecraft:stripped_bamboo_block": "new ItemStack(ModBlocks.BAMBOO_BLOCK.get(), 1, 2)",

    # Infested Blocks
    "minecraft:infested_stone": "new ItemStack(Blocks.monster_egg, 1, 0)",
    "minecraft:infested_cobblestone": "new ItemStack(Blocks.monster_egg, 1, 1)",
    "minecraft:infested_stone_bricks": "new ItemStack(Blocks.monster_egg, 1, 2)",
    "minecraft:infested_mossy_stone_bricks": "new ItemStack(Blocks.monster_egg, 1, 3)",
    "minecraft:infested_cracked_stone_bricks": "new ItemStack(Blocks.monster_egg, 1, 4)",
    "minecraft:infested_chiseled_stone_bricks": "new ItemStack(Blocks.monster_egg, 1, 5)",

    # Ingredients
    "minecraft:popped_chorus_fruit": "new ItemStack(ModItems.CHORUS_FRUIT_POPPED.get())",

    # Tools / Chest boats & Rafts
    "minecraft:bamboo_raft": "new ItemStack(ModItems.BAMBOO_RAFT.get())",
    "minecraft:bamboo_chest_raft": "new ItemStack(ModItems.BAMBOO_CHEST_RAFT.get())",
    "minecraft:mangrove_boat": "new ItemStack(ModItems.MANGROVE_OAK_BOAT.get())",
    "minecraft:mangrove_chest_boat": "new ItemStack(ModItems.MANGROVE_CHEST_BOAT.get())",
    "minecraft:cherry_boat": "new ItemStack(ModItems.CHERRY_BOAT.get())",
    "minecraft:cherry_chest_boat": "new ItemStack(ModItems.CHERRY_CHEST_BOAT.get())",

    # Copper slabs
    "minecraft:exposed_cut_copper_slab": "new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 1)",
    "minecraft:weathered_cut_copper_slab": "new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 2)",
    "minecraft:oxidized_cut_copper_slab": "new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 3)",
    "minecraft:waxed_cut_copper_slab": "new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 4)",
    "minecraft:waxed_exposed_cut_copper_slab": "new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 5)",
    "minecraft:waxed_weathered_cut_copper_slab": "new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 6)",
    "minecraft:waxed_oxidized_cut_copper_slab": "new ItemStack(ModBlocks.CUT_COPPER_SLAB.get(), 1, 7)",

    # Copper blocks
    "minecraft:exposed_cut_copper": "new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 5)",
    "minecraft:weathered_cut_copper": "new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 6)",
    "minecraft:oxidized_cut_copper": "new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 7)",
    "minecraft:waxed_exposed_cut_copper": "new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 13)",
    "minecraft:waxed_weathered_cut_copper": "new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 14)",
    "minecraft:waxed_oxidized_cut_copper": "new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 15)",

    # Chiseled copper
    "minecraft:exposed_chiseled_copper": "new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 1)",
    "minecraft:weathered_chiseled_copper": "new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 2)",
    "minecraft:oxidized_chiseled_copper": "new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 3)",
    "minecraft:waxed_chiseled_copper": "new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 4)",
    "minecraft:waxed_exposed_chiseled_copper": "new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 5)",
    "minecraft:waxed_weathered_chiseled_copper": "new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 6)",
    "minecraft:waxed_oxidized_chiseled_copper": "new ItemStack(ModBlocks.CHISELED_COPPER.get(), 1, 7)",

    # Copper grate
    "minecraft:exposed_copper_grate": "new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 1)",
    "minecraft:weathered_copper_grate": "new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 2)",
    "minecraft:oxidized_copper_grate": "new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 3)",
    "minecraft:waxed_copper_grate": "new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 4)",
    "minecraft:waxed_exposed_copper_grate": "new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 5)",
    "minecraft:waxed_weathered_copper_grate": "new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 6)",
    "minecraft:waxed_oxidized_copper_grate": "new ItemStack(ModBlocks.COPPER_GRATE.get(), 1, 7)",

    # Cut Red Sandstone Slab fix
    "minecraft:cut_red_sandstone_slab": "new ItemStack(ModBlocks.RED_SANDSTONE_SLAB.get(), 1, 1)",

    # Daylight detector EFR overrides
    "minecraft:daylight_detector": "new ItemStack(ModBlocks.DAYLIGHT_DETECTOR.get())",
    "minecraft:daylight_detector_inverted": "new ItemStack(ModBlocks.DAYLIGHT_DETECTOR_INVERTED.get())",
    "minecraft:oak_boat": "new ItemStack(ModItems.OAK_BOAT.get())",

    # Red bed - vanilla bed is already red, EFR doesn't have RED_BED
    "minecraft:red_bed": "new ItemStack(Items.bed)",

    # Firework star
    "minecraft:firework_star": "new ItemStack(Items.firework_charge)",
}

TABS_APPENDS = {
    "BUILDING_BLOCKS": [
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableNetherite) {\n'
        '                    p.accept(new ItemStack(ModBlocks.NETHERITE_STAIRS.get()));\n'
        '                }\n'
        '            }'
    ],
    "NATURAL_BLOCKS": [
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableDeepslate) {\n'
        '                    p.accept(new ItemStack(ModBlocks.MODDED_DEEPSLATE_ORE.get()));\n'
        '                }\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableRawOres) {\n'
        '                    p.accept(new ItemStack(ModBlocks.MODDED_RAW_ORE_BLOCK.get()));\n'
        '                }\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableNetherite) {\n'
        '                    p.accept(new ItemStack(ModBlocks.RAW_ADAMANTIUM_BLOCK.get()));\n'
        '                }\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigTweaks.enableOldGravel) {\n'
        '                    p.accept(new ItemStack(ModBlocks.OLD_GRAVEL.get()));\n'
        '                }\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigTweaks.enableRoses) {\n'
        '                    p.accept(new ItemStack(ModBlocks.ROSE.get()));\n'
        '                }\n'
        '            }'
    ],
    "FUNCTIONAL_BLOCKS": [
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableBarrel) {\n'
        '                    p.accept(new ItemStack(ModBlocks.COPPER_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.IRON_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.SILVER_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.GOLD_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.DIAMOND_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.OBSIDIAN_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.NETHERITE_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.STEEL_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.DARKSTEEL_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModBlocks.CRYSTAL_BARREL.get()));\n'
        '                    p.accept(new ItemStack(ModItems.BARREL_UPGRADE.get()));\n'
        '                }\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableShulkerBoxes) {\n'
        '                    p.accept(new ItemStack(ModItems.SHULKER_BOX_UPGRADE.get()));\n'
        '                }\n'
        '            }'
    ],
    "COMBAT": [
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableTippedArrows) {\n'
        '                    java.util.List<ItemStack> tippedArrows = new java.util.ArrayList<>();\n'
        '                    ModItems.TIPPED_ARROW.get().getSubItems(ModItems.TIPPED_ARROW.get(), null, tippedArrows);\n'
        '                    for (ItemStack stack : tippedArrows) {\n'
        '                        p.accept(stack);\n'
        '                    }\n'
        '                }\n'
        '            }'
    ],
    "FOOD_AND_DRINKS": [
        '            {\n'
        '                java.util.List<ItemStack> vanillaPotions = new java.util.ArrayList<>();\n'
        '                Items.potionitem.getSubItems(Items.potionitem, null, vanillaPotions);\n'
        '                for (ItemStack stack : vanillaPotions) {\n'
        '                    p.accept(stack);\n'
        '                }\n'
        '            }',
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableLingeringPotions) {\n'
        '                    java.util.List<ItemStack> lingeringPotions = new java.util.ArrayList<>();\n'
        '                    ModItems.LINGERING_POTION.get().getSubItems(ModItems.LINGERING_POTION.get(), null, lingeringPotions);\n'
        '                    for (ItemStack stack : lingeringPotions) {\n'
        '                        p.accept(stack);\n'
        '                    }\n'
        '                }\n'
        '            }',
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableSuspiciousStew) {\n'
        '                    p.accept(new ItemStack(ModItems.SUSPICIOUS_STEW.get()));\n'
        '                }\n'
        '            }'
    ],
    "TOOLS": [
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigEntities.enableGoats) {\n'
        '                    java.util.List<ItemStack> horns = new java.util.ArrayList<>();\n'
        '                    ModItems.GOAT_HORN.get().getSubItems(ModItems.GOAT_HORN.get(), null, horns);\n'
        '                    for (ItemStack stack : horns) {\n'
        '                        p.accept(stack);\n'
        '                    }\n'
        '                }\n'
        '            }'
    ],
    "INGREDIENTS": [
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableRawOres) {\n'
        '                    p.accept(new ItemStack(ModItems.MODDED_RAW_ORE.get()));\n'
        '                }\n'
        '                if (ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems.enableNetherite) {\n'
        '                    p.accept(new ItemStack(ModItems.RAW_ADAMANTIUM.get()));\n'
        '                }\n'
        '            }'
    ],
    "OP": [
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                if (ganymedes01.etfuturum.lib.Reference.DEV_ENVIRONMENT) {\n'
        '                    p.accept(new ItemStack(ModItems.DEBUGGING_TOOL.get()));\n'
        '                }\n'
        '            }',
        '            if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {\n'
        '                p.accept(new ItemStack(ModBlocks.LIGHT.get()));\n'
        '            }'
    ]
}

# Helper to parse registered enums in java files
def parse_registered_enums(file_path):
    enums = set()
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()
    # Find enum block start
    m = re.search(r'public enum \w+ \{', content)
    if not m:
        return enums
    
    start_char = m.end()
    # Read until first semicolon (end of enum constants)
    enum_part = ""
    brace_count = 1
    for char in content[start_char:]:
        if char == '{':
            brace_count += 1
        elif char == '}':
            brace_count -= 1
        elif char == ';':
            if brace_count == 1:
                break
        enum_part += char
        
    for line in enum_part.split('\n'):
        # Match enum constant identifier
        match = re.match(r'^\s*([A-Z0-9_]+)\(', line)
        if match:
            enums.add(match.group(1))
    return enums

# Fix naming abbreviations/inconsistencies between mapping names and Java declarations
def fix_constructor(c):
    c = c.replace("ModBlocks.SPRUCE_DOOR", "ModBlocks.DOOR_SPRUCE")
    c = c.replace("ModBlocks.BIRCH_DOOR", "ModBlocks.DOOR_BIRCH")
    c = c.replace("ModBlocks.JUNGLE_DOOR", "ModBlocks.DOOR_JUNGLE")
    c = c.replace("ModBlocks.ACACIA_DOOR", "ModBlocks.DOOR_ACACIA")
    c = c.replace("ModBlocks.DARK_OAK_DOOR", "ModBlocks.DOOR_DARK_OAK")
    
    c = c.replace("ModBlocks.SPRUCE_FENCE_GATE", "ModBlocks.FENCE_GATE_SPRUCE")
    c = c.replace("ModBlocks.BIRCH_FENCE_GATE", "ModBlocks.FENCE_GATE_BIRCH")
    c = c.replace("ModBlocks.JUNGLE_FENCE_GATE", "ModBlocks.FENCE_GATE_JUNGLE")
    c = c.replace("ModBlocks.ACACIA_FENCE_GATE", "ModBlocks.FENCE_GATE_ACACIA")
    c = c.replace("ModBlocks.DARK_OAK_FENCE_GATE", "ModBlocks.FENCE_GATE_DARK_OAK")
    
    c = c.replace("ModBlocks.COPPER_COPPER_DOOR", "ModBlocks.COPPER_DOOR")
    c = c.replace("ModBlocks.EXPOSED_COPPER_COPPER_DOOR", "ModBlocks.EXPOSED_COPPER_DOOR")
    c = c.replace("ModBlocks.WEATHERED_COPPER_COPPER_DOOR", "ModBlocks.WEATHERED_COPPER_DOOR")
    c = c.replace("ModBlocks.OXIDIZED_COPPER_COPPER_DOOR", "ModBlocks.OXIDIZED_COPPER_DOOR")
    c = c.replace("ModBlocks.WAXED_COPPER_COPPER_DOOR", "ModBlocks.WAXED_COPPER_DOOR")
    c = c.replace("ModBlocks.WAXED_EXPOSED_COPPER_COPPER_DOOR", "ModBlocks.WAXED_EXPOSED_COPPER_DOOR")
    c = c.replace("ModBlocks.WAXED_WEATHERED_COPPER_COPPER_DOOR", "ModBlocks.WAXED_WEATHERED_COPPER_DOOR")
    c = c.replace("ModBlocks.WAXED_OXIDIZED_COPPER_COPPER_DOOR", "ModBlocks.WAXED_OXIDIZED_COPPER_DOOR")
    
    c = c.replace("ModBlocks.COPPER_COPPER_TRAPDOOR", "ModBlocks.COPPER_TRAPDOOR")
    c = c.replace("ModBlocks.EXPOSED_COPPER_COPPER_TRAPDOOR", "ModBlocks.EXPOSED_COPPER_TRAPDOOR")
    c = c.replace("ModBlocks.WEATHERED_COPPER_COPPER_TRAPDOOR", "ModBlocks.WEATHERED_COPPER_TRAPDOOR")
    c = c.replace("ModBlocks.OXIDIZED_COPPER_COPPER_TRAPDOOR", "ModBlocks.OXIDIZED_COPPER_TRAPDOOR")
    c = c.replace("ModBlocks.WAXED_COPPER_COPPER_TRAPDOOR", "ModBlocks.WAXED_COPPER_TRAPDOOR")
    c = c.replace("ModBlocks.WAXED_EXPOSED_COPPER_COPPER_TRAPDOOR", "ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR")
    c = c.replace("ModBlocks.WAXED_WEATHERED_COPPER_COPPER_TRAPDOOR", "ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR")
    c = c.replace("ModBlocks.WAXED_OXIDIZED_COPPER_COPPER_TRAPDOOR", "ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR")
    
    c = c.replace("new ItemStack(ModBlocks.POLISHED_BASALT.get())", "new ItemStack(ModBlocks.BASALT.get(), 1, 1)")
    c = c.replace("new ItemStack(ModBlocks.CHISELED_DEEPSLATE.get())", "new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 4)")
    c = c.replace("new ItemStack(ModBlocks.COBBLED_DEEPSLATE_SLAB.get(), 1, 0)", "new ItemStack(ModBlocks.DEEPSLATE_SLAB.get(), 1, 0)")
    c = c.replace("new ItemStack(ModBlocks.POLISHED_DEEPSLATE_SLAB.get(), 1, 0)", "new ItemStack(ModBlocks.DEEPSLATE_SLAB.get(), 1, 1)")
    c = c.replace("new ItemStack(ModBlocks.DEEPSLATE_TILE_SLAB.get(), 1, 0)", "new ItemStack(ModBlocks.DEEPSLATE_BRICK_SLAB.get(), 1, 1)")
    c = c.replace("new ItemStack(ModBlocks.MUD_BRICKS.get())", "new ItemStack(ModBlocks.PACKED_MUD.get(), 1, 1)")
    
    c = c.replace("ModBlocks.COPPER_CUT_COPPER_STAIRS", "ModBlocks.CUT_COPPER_STAIRS")
    c = c.replace("ModBlocks.WAXED_COPPER_CUT_COPPER_STAIRS", "ModBlocks.WAXED_CUT_COPPER_STAIRS")
    
    return c

def main():
    if not os.path.exists(MAPPING_PATH):
        print(f"Error: {MAPPING_PATH} not found in the project root.")
        return
        
    print("Auditing registered EFR elements...")
    registered_blocks = parse_registered_enums(BLOCKS_PATH)
    registered_items = parse_registered_enums(ITEMS_PATH)
    
    print(f"Loaded {len(registered_blocks)} registered blocks.")
    print(f"Loaded {len(registered_items)} registered items.")
    
    tab_items = {k: [] for k in TABS.keys()}
    mapped_efr_blocks = set()
    mapped_efr_items = set()
    
    print("Parsing creative mapping file...")
    current_tab = None
    with open(MAPPING_PATH, "r", encoding="utf-8") as f:
        for line_no, line in enumerate(f, 1):
            line = line.strip()
            # Match Tab Heading
            header_match = re.match(r'## Tab:\s*([A-Za-z0-9_ &]+)', line)
            if header_match:
                current_tab = header_match.group(1).strip()
                continue
                
            if not line.startswith("|") or not current_tab:
                continue
                
            parts = [p.strip() for p in line.split("|")][1:-1]
            if len(parts) < 4:
                continue
                
            # Skip header lines
            if parts[0] == "Item #" or parts[0] == "---" or "Registry Name" in parts[1]:
                continue
                
            tab_name = current_tab
            if tab_name not in TABS:
                continue
                
            reg_name = parts[1].replace("`", "")
            if ":" not in reg_name:
                continue
                
            # Duplicate filtering logic from 1.21.4:
            # 1. Redstone Ore: only in Natural Blocks, NOT in Redstone Blocks
            if tab_name == "Redstone Blocks" and reg_name in ["minecraft:redstone_ore", "minecraft:deepslate_redstone_ore"]:
                continue
            
            # 2. Redstone Torch / Lamp: only in Redstone Blocks, NOT in Functional Blocks
            if tab_name == "Functional Blocks" and reg_name in ["minecraft:redstone_torch", "minecraft:redstone_lamp"]:
                continue
            
            # 3. Wooden doors and trapdoors: only in Building Blocks, NOT in Redstone Blocks
            if tab_name == "Redstone Blocks" and (reg_name.endswith("_door") or reg_name.endswith("_trapdoor")):
                if "iron" not in reg_name and "copper" not in reg_name:
                    continue
            
            # 4. Beds: only in Colored Blocks, NOT in Functional Blocks
            if tab_name == "Functional Blocks" and reg_name.endswith("_bed"):
                continue
                
            # 5. Minecarts: only in Tools & Utilities, NOT in Redstone Blocks
            if tab_name == "Redstone Blocks" and "minecart" in reg_name:
                continue
                
            # 6. Ender Pearl, Eye of Ender, Fire Charge: only in Tools & Utilities, NOT in Ingredients or Functional Blocks
            if tab_name in ["Ingredients", "Functional Blocks"] and reg_name in ["minecraft:ender_pearl", "minecraft:ender_eye", "minecraft:fire_charge"]:
                continue
                
            # 7. Banners: only in Colored Blocks, NOT in Functional Blocks
            if tab_name == "Functional Blocks" and (reg_name.endswith("_banner") or reg_name == "minecraft:banner"):
                continue
                
            # 8. Shulker Boxes: only in Functional Blocks, NOT in Colored Blocks
            if tab_name == "Colored Blocks" and "shulker_box" in reg_name:
                continue
                
            # 9. Smooth Basalt: only in Building Blocks, NOT in Natural Blocks
            if tab_name == "Natural Blocks" and reg_name == "minecraft:smooth_basalt":
                continue
                
            # 10. Tinted Glass: only in Functional Blocks, NOT in Colored Blocks
            if tab_name == "Colored Blocks" and reg_name == "minecraft:tinted_glass":
                continue
                
            # 11. End Crystal: only in Combat, NOT in Functional Blocks
            if tab_name == "Functional Blocks" and reg_name == "minecraft:end_crystal":
                continue
                
            # 12. Chest Boats / Rafts: only in Tools & Utilities, NOT in Redstone Blocks
            if tab_name == "Redstone Blocks" and reg_name in [
                "minecraft:oak_chest_boat", "minecraft:spruce_chest_boat", "minecraft:birch_chest_boat", 
                "minecraft:jungle_chest_boat", "minecraft:acacia_chest_boat", "minecraft:dark_oak_chest_boat", 
                "minecraft:mangrove_chest_boat", "minecraft:cherry_chest_boat", "minecraft:bamboo_chest_raft"
            ]:
                continue

            # 13. Sweet Berries: only in Food & Drinks, NOT in Natural Blocks
            if tab_name == "Natural Blocks" and reg_name == "minecraft:sweet_berries":
                continue
            
            constructor = parts[2].replace("`", "")
            if reg_name in MANUAL_MAPPINGS:
                constructor = MANUAL_MAPPINGS[reg_name]
            
            if constructor == "Omitted" or not constructor:
                continue
                
            constructor = fix_constructor(constructor)
            
            # Extract NBT if present (typically in notes or metadata column, let's check parts)
            nbt = None
            if len(parts) >= 5:
                notes = parts[4]
                if "{Color:" in notes:
                    nbt = notes.replace("`", "")
                
            # Track EFR usages
            for block_field in re.findall(r'ModBlocks\.([A-Z0-9_]+)', constructor):
                mapped_efr_blocks.add(block_field)
            for item_field in re.findall(r'ModItems\.([A-Z0-9_]+)', constructor):
                mapped_efr_items.add(item_field)
                
            tab_items[tab_name].append((constructor, nbt))

    # Audit reporting
    unmapped_blocks = registered_blocks - mapped_efr_blocks
    unmapped_items = registered_items - mapped_efr_items
    
    # Exclude technical/dummy blocks/items that shouldn't appear in tabs
    ignored_blocks = {
        "SWEET_BERRY_BUSH", "POWERED_COPPER_BULB", "NETHER_PORTAL", 
        "POTTED_ALLIUM", "POTTED_AZALEA_BUSH", "POTTED_CORNFLOWER", 
        "POTTED_DANDELION", "POTTED_FLOWERING_AZALEA_BUSH", 
        "POTTED_LILY_OF_THE_VALLEY", "POTTED_MUSHROOM_BROWN", 
        "POTTED_MUSHROOM_RED", "POTTED_SAPLING_ACACIA", 
        "POTTED_SAPLING_BIRCH", "POTTED_SAPLING_DARK_OAK", 
        "POTTED_SAPLING_JUNGLE", "POTTED_SAPLING_OAK", 
        "POTTED_SAPLING_SPRUCE", "POTTED_WITHER_ROSE",
        "WALL_SIGN_ACACIA", "WALL_SIGN_BIRCH", "WALL_SIGN_DARK_OAK",
        "WALL_SIGN_JUNGLE", "WALL_SIGN_SPRUCE", "WARPED_WALL_SIGN",
        "CHERRY_WALL_SIGN", "CRIMSON_WALL_SIGN", "MANGROVE_WALL_SIGN", "BAMBOO_WALL_SIGN",
        "BAMBOO", "BAMBOO_SAPLING", "BEETROOTS", "BUBBLE_COLUMN_DOWN", "BUBBLE_COLUMN_UP",
        "LIT_BLAST_FURNACE", "LIT_SMOKER", "LAVA_CAULDRON", "POTION_CAULDRON",
        "FROSTED_ICE", "END_GATEWAY", "BANNER", "SIGN_ACACIA", "SIGN_BIRCH", 
        "SIGN_DARK_OAK", "SIGN_JUNGLE", "SIGN_SPRUCE", "DAYLIGHT_DETECTOR_INVERTED",
        
        # Double slabs (technical)
        "DOUBLE_BAMBOO_MOSAIC_SLAB", "DOUBLE_BLACKSTONE_SLAB", "DOUBLE_CUT_COPPER_SLAB", 
        "DOUBLE_DEEPSLATE_BRICK_SLAB", "DOUBLE_DEEPSLATE_SLAB", "DOUBLE_END_BRICK_SLAB", 
        "DOUBLE_MUD_BRICK_SLAB", "DOUBLE_PRISMARINE_SLAB", "DOUBLE_PURPUR_SLAB", 
        "DOUBLE_RED_NETHERBRICK_SLAB", "DOUBLE_RED_SANDSTONE_SLAB", "DOUBLE_SMOOTH_QUARTZ_SLAB", 
        "DOUBLE_SMOOTH_RED_SANDSTONE_SLAB", "DOUBLE_SMOOTH_SANDSTONE_SLAB", "DOUBLE_STONE_SLAB", 
        "DOUBLE_STONE_SLAB_2", "DOUBLE_TUFF_SLAB", "DOUBLE_WOOD_SLAB",
        
        # Compat ores (only for other mods)
        "DEEPSLATE_ADAMANTIUM_ORE", "DEEPSLATE_AM2_ORE", "DEEPSLATE_BLUEPOWER_ORE", 
        "DEEPSLATE_BOP_ORE", "DEEPSLATE_CERTUS_QUARTZ_ORE", "DEEPSLATE_DBC_ORE", 
        "DEEPSLATE_DQ_ORE", "DEEPSLATE_DRACONIUM_ORE", "DEEPSLATE_LIT_REDSTONE_ORE", 
        "DEEPSLATE_PROJRED_ORE", "DEEPSLATE_THAUMCRAFT_ORE", "MODDED_DEEPSLATE_ORE", 
        "MODDED_RAW_ORE_BLOCK", "RAW_ADAMANTIUM_BLOCK",
        
        # Custom elements generated via TABS_APPENDS
        "COPPER_BARREL", "CRYSTAL_BARREL", "DARKSTEEL_BARREL", "DIAMOND_BARREL", 
        "GOLD_BARREL", "IRON_BARREL", "NETHERITE_BARREL", "OBSIDIAN_BARREL", 
        "SILVER_BARREL", "STEEL_BARREL", "NETHERITE_STAIRS", "ROSE", "OLD_GRAVEL", "LIGHT"
    }
    ignored_items = {
        "RAW_ORE", # handled by subblocks/variants
        
        # Custom elements generated via TABS_APPENDS
        "BARREL_UPGRADE", "SHULKER_BOX_UPGRADE", "MODDED_RAW_ORE", "RAW_ADAMANTIUM", 
        "GOAT_HORN", "LINGERING_POTION", "SUSPICIOUS_STEW", "TIPPED_ARROW", "DEBUGGING_TOOL"
    }
    
    unmapped_blocks = {b for b in unmapped_blocks if b not in ignored_blocks}
    unmapped_items = {i for i in unmapped_items if i not in ignored_items}
    
    if unmapped_blocks:
        print("\n[WARNING] The following registered EFR blocks are NOT mapped in any creative tab:")
        for b in sorted(unmapped_blocks):
            print(f"  - ModBlocks.{b}")
            
    if unmapped_items:
        print("\n[WARNING] The following registered EFR items are NOT mapped in any creative tab:")
        for i in sorted(unmapped_items):
            print(f"  - ModItems.{i}")
            
    if not unmapped_blocks and not unmapped_items:
        print("\nAudit Complete: All registered EFR blocks and items are correctly mapped!")

    # Load ModernCreativeTabs.java
    with open(TABS_FILE_PATH, "r", encoding="utf-8") as f:
        tabs_code = f.read()

    print("\nGenerating code and updating ModernCreativeTabs.java...")
    for tab_name, items in tab_items.items():
        tab_var = TABS[tab_name]
        
        # Build java statements block
        statements = []
        for constructor, nbt in items:
            constructor = fix_constructor(constructor)
            egg_match = re.search(r'ModEntityList\.eggIds\.get\((Entity\w+)\.class\)', constructor)
            is_efr = "ModBlocks" in constructor or "ModItems" in constructor or egg_match is not None
            indent = "            "
            
            if egg_match:
                ent_class = egg_match.group(1)
                fq_class = f"ganymedes01.etfuturum.entities.{ent_class}"
                stmt = (
                    f"{indent}if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {{\n"
                    f"{indent}    Integer eggId = ganymedes01.etfuturum.entities.ModEntityList.eggIds.get({fq_class}.class);\n"
                    f"{indent}    if (eggId != null) {{\n"
                    f"{indent}        p.accept(new ItemStack(Items.spawn_egg, 1, eggId));\n"
                    f"{indent}    }}\n"
                    f"{indent}}}"
                )
            elif is_efr:
                if nbt:
                    stmt = (
                        f"{indent}if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {{\n"
                        f"{indent}    ItemStack stack = {constructor};\n"
                    )
                    if "{Color:" in nbt:
                        color_match = re.search(r'Color:\s*(\d+)b', nbt)
                        if color_match:
                            color_val = color_match.group(1)
                            stmt += (
                                f"{indent}    stack.setTagCompound(new net.minecraft.nbt.NBTTagCompound());\n"
                                f"{indent}    stack.getTagCompound().setByte(\"Color\", (byte){color_val});\n"
                            )
                    stmt += (
                        f"{indent}    p.accept(stack);\n"
                        f"{indent}}}"
                    )
                else:
                    stmt = (
                        f"{indent}if (!ganymedes01.etfuturum.configuration.configs.ConfigFunctions.useSeparateCreativeTabs) {{\n"
                        f"{indent}    p.accept({constructor});\n"
                        f"{indent}}}"
                    )
            else:
                if nbt:
                    stmt = (
                        f"{indent}ItemStack stack = {constructor};\n"
                        f"{indent}p.accept(stack);"
                    )
                else:
                    stmt = f"{indent}p.accept({constructor});"
            statements.append(stmt)
            
        # Append manual/dynamic tab items
        if tab_var in TABS_APPENDS:
            for append_stmt in TABS_APPENDS[tab_var]:
                statements.append(append_stmt)
            
        body = "\n".join(statements) + "\n"
        
        # Replace populate body
        pattern = r'(public\s+static\s+final\s+CreativeTabs\s+' + re.escape(tab_var) + r'\s*=\s*new\s+ModernCreativeTab\(".*?",\s*\(\)\s*->\s*.*?,.*?new\s+CreativeTabPopulator\(\)\s*\{\s*\n\s*@Override\s*\n\s*public\s+void\s+populate\(CreativeTabDisplayBuilder\s+p\)\s*\{)([\s\S]*?)(\}\s*\n\s*\}\);)'
        
        match = re.search(pattern, tabs_code)
        if not match:
            # Try simple pattern
            pattern_simple = r'(CreativeTabs\s+' + re.escape(tab_var) + r'\b[\s\S]*?populate\(CreativeTabDisplayBuilder\s+p\)\s*\{)([\s\S]*?)(\}\s*\n\s*\}\);)'
            match = re.search(pattern_simple, tabs_code)
            if match:
                tabs_code = re.sub(pattern_simple, r'\1\n' + body.replace('\\', '\\\\').replace('$', '\\$') + r'\3', tabs_code, count=1)
                print(f"  Merged {tab_name} ({tab_var})")
            else:
                print(f"  [ERROR] Failed to find tab declaration block for {tab_var}!")
        else:
            tabs_code = re.sub(pattern, r'\1\n' + body.replace('\\', '\\\\').replace('$', '\\$') + r'\3', tabs_code, count=1)
            print(f"  Merged {tab_name} ({tab_var})")

    with open(TABS_FILE_PATH, "w", encoding="utf-8") as f:
        f.write(tabs_code)
        
    print("Done! ModernCreativeTabs.java updated successfully.")

if __name__ == "__main__":
    main()
