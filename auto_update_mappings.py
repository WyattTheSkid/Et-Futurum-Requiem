#!/usr/bin/env python3
import os
import re

MAPPING_PATH = "creative_inventory_mapping.md"
BLOCKS_PATH = "src/main/java/ganymedes01/etfuturum/ModBlocks.java"
ITEMS_PATH = "src/main/java/ganymedes01/etfuturum/ModItems.java"

ALIASES = {
    "end_stone_bricks": "new ItemStack(ModBlocks.END_BRICKS.get())",
    "end_stone_brick_slab": "new ItemStack(ModBlocks.END_BRICK_SLAB.get())",
    "end_stone_brick_stairs": "new ItemStack(ModBlocks.END_BRICK_STAIRS.get())",
    "end_stone_brick_wall": "new ItemStack(ModBlocks.END_BRICK_WALL.get())",
    "daylight_detector": "new ItemStack(ModBlocks.DAYLIGHT_DETECTOR.get())",
    "daylight_detector_inverted": "new ItemStack(ModBlocks.DAYLIGHT_DETECTOR_INVERTED.get())",
    "bamboo": "new ItemStack(ModItems.BAMBOO.get())",
    "end_crystal": "new ItemStack(ModItems.END_CRYSTAL.get())",
    "chorus_fruit": "new ItemStack(ModItems.CHORUS_FRUIT.get())",
    "chorus_flower": "new ItemStack(ModBlocks.CHORUS_FLOWER.get())",
    "chorus_plant": "new ItemStack(ModBlocks.CHORUS_PLANT.get())",
    "beetroots": "new ItemStack(ModItems.BEETROOT.get())",
    "sweet_berries": "new ItemStack(ModItems.SWEET_BERRIES.get())",
    "suspicious_stew": "new ItemStack(ModItems.SUSPICIOUS_STEW.get())",
    "tipped_arrow": "new ItemStack(ModItems.TIPPED_ARROW.get())",
    "armor_stand": "new ItemStack(ModItems.WOODEN_ARMORSTAND.get())",
    "red_nether_bricks": "new ItemStack(ModBlocks.RED_NETHERBRICK.get())",
    "red_nether_brick_slab": "new ItemStack(ModBlocks.RED_NETHERBRICK_SLAB.get())",
    "red_nether_brick_stairs": "new ItemStack(ModBlocks.RED_NETHERBRICK_STAIRS.get())",
    "lingering_potion": "new ItemStack(ModItems.LINGERING_POTION.get())",
    "otherside_record": "new ItemStack(ModItems.OTHERSIDE_RECORD.get())",
    "pigstep_record": "new ItemStack(ModItems.PIGSTEP_RECORD.get())",
    "goat_horn": "new ItemStack(ModItems.GOAT_HORN.get())",
    "sculk": "new ItemStack(ModBlocks.SCULK.get())",
    "sculk_catalyst": "new ItemStack(ModBlocks.SCULK_CATALYST.get())",
    "shulker_box": "new ItemStack(ModBlocks.SHULKER_BOX.get())",
    "rose": "new ItemStack(ModBlocks.ROSE.get())",
    "red_bed": "new ItemStack(Items.bed)",
    "spawner": "new ItemStack(Blocks.mob_spawner)",
    
    # Vanilla Items and Blocks
    "carrot": "new ItemStack(Items.carrot)",
    "potato": "new ItemStack(Items.potato)",
    "baked_potato": "new ItemStack(Items.baked_potato)",
    "cod": "new ItemStack(Items.fish, 1, 0)",
    "cooked_cod": "new ItemStack(Items.cooked_fished, 1, 0)",
    "salmon": "new ItemStack(Items.fish, 1, 1)",
    "cooked_salmon": "new ItemStack(Items.cooked_fished, 1, 1)",
    "tropical_fish": "new ItemStack(Items.fish, 1, 2)",
    "pufferfish": "new ItemStack(Items.fish, 1, 3)",
    "cake": "new ItemStack(Items.cake)",
    "fire_charge": "new ItemStack(Items.fire_charge)",
    "map": "new ItemStack(Items.map)",
    "writable_book": "new ItemStack(Items.writable_book)",
    "carrot_on_a_stick": "new ItemStack(Items.carrot_on_a_stick)",
    "rail": "new ItemStack(Blocks.rail)",
    "powered_rail": "new ItemStack(Blocks.golden_rail)",
    "detector_rail": "new ItemStack(Blocks.detector_rail)",
    "activator_rail": "new ItemStack(Blocks.activator_rail)",
    "minecart": "new ItemStack(Items.minecart)",
    "hopper_minecart": "new ItemStack(Items.hopper_minecart)",
    "chest_minecart": "new ItemStack(Items.chest_minecart)",
    "furnace_minecart": "new ItemStack(Items.furnace_minecart)",
    "tnt_minecart": "new ItemStack(Items.tnt_minecart)",
    
    # Music Discs
    "music_disc_13": "new ItemStack(Items.record_13)",
    "music_disc_cat": "new ItemStack(Items.record_cat)",
    "music_disc_blocks": "new ItemStack(Items.record_blocks)",
    "music_disc_chirp": "new ItemStack(Items.record_chirp)",
    "music_disc_far": "new ItemStack(Items.record_far)",
    "music_disc_mall": "new ItemStack(Items.record_mall)",
    "music_disc_mellohi": "new ItemStack(Items.record_mellohi)",
    "music_disc_stal": "new ItemStack(Items.record_stal)",
    "music_disc_strad": "new ItemStack(Items.record_strad)",
    "music_disc_ward": "new ItemStack(Items.record_ward)",
    "music_disc_11": "new ItemStack(Items.record_11)",
    "music_disc_wait": "new ItemStack(Items.record_wait)",
    
    # Horse Armor
    "iron_horse_armor": "new ItemStack(Items.iron_horse_armor)",
    "golden_horse_armor": "new ItemStack(Items.golden_horse_armor)",
    "diamond_horse_armor": "new ItemStack(Items.diamond_horse_armor)",
    
    # Potion / Ingredients
    "experience_bottle": "new ItemStack(Items.experience_bottle)",
    "bowl": "new ItemStack(Items.bowl)",
    "glass_bottle": "new ItemStack(Items.glass_bottle)",
    "firework_star": "new ItemStack(Items.firework_charge)",
    
    # Custom items / blocks aliases
    "music_disc_otherside": "new ItemStack(ModItems.OTHERSIDE_RECORD.get())",
    "music_disc_pigstep": "new ItemStack(ModItems.PIGSTEP_RECORD.get())",
    
    # Prismarine stairs
    "prismarine_brick_stairs": "new ItemStack(ModBlocks.PRISMARINE_STAIRS_BRICK.get())",
    "dark_prismarine_stairs": "new ItemStack(ModBlocks.PRISMARINE_STAIRS_DARK.get())",
    
    # Deepslate Tile Slab
    "deepslate_tile_slab": "new ItemStack(ModBlocks.DEEPSLATE_BRICK_SLAB.get(), 1, 1)",
    
    # Stone Slab 2
    "granite_slab": "new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 0)",
    "polished_granite_slab": "new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 1)",
    "diorite_slab": "new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 2)",
    "polished_diorite_slab": "new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 3)",
    "andesite_slab": "new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 4)",
    "polished_andesite_slab": "new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 5)",
    
    # Stone Wall 2
    "granite_wall": "new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 0)",
    "diorite_wall": "new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 1)",
    "andesite_wall": "new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 2)",
    
    # Stone Wall (extra vanilla walls)
    "stone_brick_wall": "new ItemStack(ModBlocks.STONE_WALL.get(), 1, 0)",
    "mossy_stone_brick_wall": "new ItemStack(ModBlocks.STONE_WALL.get(), 1, 1)",
    "sandstone_wall": "new ItemStack(ModBlocks.STONE_WALL.get(), 1, 2)",
    "brick_wall": "new ItemStack(ModBlocks.STONE_WALL.get(), 1, 3)",
    
    # Deepslate Slab
    "cobbled_deepslate_slab": "new ItemStack(ModBlocks.DEEPSLATE_SLAB.get(), 1, 0)",
    "polished_deepslate_slab": "new ItemStack(ModBlocks.DEEPSLATE_SLAB.get(), 1, 1)",
    
    # Deepslate Wall
    "cobbled_deepslate_wall": "new ItemStack(ModBlocks.DEEPSLATE_WALL.get(), 1, 0)",
    "polished_deepslate_wall": "new ItemStack(ModBlocks.DEEPSLATE_WALL.get(), 1, 1)",
    
    # Signs
    "oak_sign": "new ItemStack(Items.sign)",
    "spruce_sign": "new ItemStack(ModItems.ITEM_SIGN_SPRUCE.get())",
    "birch_sign": "new ItemStack(ModItems.ITEM_SIGN_BIRCH.get())",
    "jungle_sign": "new ItemStack(ModItems.ITEM_SIGN_JUNGLE.get())",
    "acacia_sign": "new ItemStack(ModItems.ITEM_SIGN_ACACIA.get())",
    "dark_oak_sign": "new ItemStack(ModItems.ITEM_SIGN_DARK_OAK.get())",
    "mangrove_sign": "new ItemStack(ModBlocks.MANGROVE_SIGN.get())",
    "cherry_sign": "new ItemStack(ModBlocks.CHERRY_SIGN.get())",
    "bamboo_sign": "new ItemStack(ModBlocks.BAMBOO_SIGN.get())",
    "crimson_sign": "new ItemStack(ModBlocks.CRIMSON_SIGN.get())",
    "warped_sign": "new ItemStack(ModBlocks.WARPED_SIGN.get())",
    
    # Doors
    "oak_door": "new ItemStack(Items.wooden_door)",
    "iron_door": "new ItemStack(Items.iron_door)",
    "spruce_door": "new ItemStack(ModBlocks.DOOR_SPRUCE.get())",
    "birch_door": "new ItemStack(ModBlocks.DOOR_BIRCH.get())",
    "jungle_door": "new ItemStack(ModBlocks.DOOR_JUNGLE.get())",
    "acacia_door": "new ItemStack(ModBlocks.DOOR_ACACIA.get())",
    "dark_oak_door": "new ItemStack(ModBlocks.DOOR_DARK_OAK.get())",
    "mangrove_door": "new ItemStack(ModBlocks.MANGROVE_DOOR.get())",
    "cherry_door": "new ItemStack(ModBlocks.CHERRY_DOOR.get())",
    "bamboo_door": "new ItemStack(ModBlocks.BAMBOO_DOOR.get())",
    "crimson_door": "new ItemStack(ModBlocks.CRIMSON_DOOR.get())",
    "warped_door": "new ItemStack(ModBlocks.WARPED_DOOR.get())",
    
    # Boats
    "oak_boat": "new ItemStack(ModItems.OAK_BOAT.get())",
    "spruce_boat": "new ItemStack(ModItems.SPRUCE_BOAT.get())",
    "spruce_chest_boat": "new ItemStack(ModItems.SPRUCE_CHEST_BOAT.get())",
    "birch_boat": "new ItemStack(ModItems.BIRCH_BOAT.get())",
    "birch_chest_boat": "new ItemStack(ModItems.BIRCH_CHEST_BOAT.get())",
    "jungle_boat": "new ItemStack(ModItems.JUNGLE_BOAT.get())",
    "jungle_chest_boat": "new ItemStack(ModItems.JUNGLE_CHEST_BOAT.get())",
    "acacia_boat": "new ItemStack(ModItems.ACACIA_BOAT.get())",
    "acacia_chest_boat": "new ItemStack(ModItems.ACACIA_CHEST_BOAT.get())",
    "dark_oak_boat": "new ItemStack(ModItems.DARK_OAK_BOAT.get())",
    "dark_oak_chest_boat": "new ItemStack(ModItems.DARK_OAK_CHEST_BOAT.get())",
    "mangrove_boat": "new ItemStack(ModItems.MANGROVE_OAK_BOAT.get())",
    "mangrove_chest_boat": "new ItemStack(ModItems.MANGROVE_CHEST_BOAT.get())",
    "cherry_boat": "new ItemStack(ModItems.CHERRY_BOAT.get())",
    "cherry_chest_boat": "new ItemStack(ModItems.CHERRY_CHEST_BOAT.get())",
    "bamboo_raft": "new ItemStack(ModItems.BAMBOO_RAFT.get())",
    "bamboo_chest_raft": "new ItemStack(ModItems.BAMBOO_CHEST_RAFT.get())",
}

# Helper to parse registered enums in java files
def parse_registered_enums(file_path):
    enums = set()
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()
    m = re.search(r'public enum \w+ \{', content)
    if not m:
        return enums
    start_char = m.end()
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
        match = re.match(r'^\s*([A-Z0-9_]+)\(', line)
        if match:
            enums.add(match.group(1))
    return enums

def main():
    if not os.path.exists(MAPPING_PATH):
        print(f"Error: {MAPPING_PATH} not found.")
        return
        
    registered_blocks = parse_registered_enums(BLOCKS_PATH)
    registered_items = parse_registered_enums(ITEMS_PATH)
    
    # Create lookup map
    efr_blocks_lower = {b.lower(): b for b in registered_blocks}
    efr_items_lower = {i.lower(): i for i in registered_items}
    
    updated_lines = []
    changes_count = 0
    
    with open(MAPPING_PATH, "r", encoding="utf-8") as f:
        for line_no, line in enumerate(f, 1):
            stripped = line.strip()
            if not stripped.startswith("|"):
                updated_lines.append(line)
                continue
                
            parts = [p.strip() for p in line.split("|")]
            # parts will be ['', 'Item #', 'Registry Name', 'Constructor', 'Status', 'Notes', '']
            if len(parts) < 6:
                updated_lines.append(line)
                continue
                
            reg_name = parts[2].replace("`", "")
            constructor = parts[3].replace("`", "")
            
            if constructor == "Omitted" and ":" in reg_name:
                suffix = reg_name.split(":")[1]
                
                # Check ALIASES
                resolved_constructor = None
                if suffix in ALIASES:
                    resolved_constructor = ALIASES[suffix]
                elif suffix in efr_blocks_lower:
                    resolved_constructor = f"new ItemStack(ModBlocks.{efr_blocks_lower[suffix]}.get())"
                elif suffix in efr_items_lower:
                    resolved_constructor = f"new ItemStack(ModItems.{efr_items_lower[suffix]}.get())"
                
                if resolved_constructor:
                    parts[3] = f"`{resolved_constructor}`"
                    parts[4] = "EFR backport equivalent"
                    parts[5] = "Automatically resolved"
                    changes_count += 1
                    print(f"Line {line_no}: Resolved {reg_name} -> {resolved_constructor}")
                    
            # Reconstruct the line
            new_line = " | ".join(parts[1:-1])
            new_line = f"| {new_line} |\n"
            updated_lines.append(new_line)
            
    if changes_count > 0:
        with open(MAPPING_PATH, "w", encoding="utf-8") as f:
            f.writelines(updated_lines)
        print(f"Updated {changes_count} entries in {MAPPING_PATH}.")
    else:
        print("No entries needed updates.")

if __name__ == "__main__":
    main()
