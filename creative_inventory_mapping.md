# Et Futurum Requiem: Source-to-Backport Mapping Table

This document maps all entries from Minecraft 1.21.4 creative tabs directly to their nearest 1.7.10 or EFR equivalents.

## Tab: Building Blocks (`itemGroup.buildingBlocks`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:oak_log` | `new ItemStack(Blocks.log, 1, 0)` | exact legacy equivalent |  |
| 1 | `minecraft:oak_wood` | `new ItemStack(ModBlocks.BARK.get(), 1, 0)` | EFR backport equivalent | Bark block |
| 2 | `minecraft:stripped_oak_log` | `new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 0)` | EFR backport equivalent |  |
| 3 | `minecraft:stripped_oak_wood` | `new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 0)` | EFR backport equivalent |  |
| 4 | `minecraft:oak_planks` | `new ItemStack(Blocks.planks, 1, 0)` | exact legacy equivalent |  |
| 5 | `minecraft:oak_stairs` | `new ItemStack(Blocks.oak_stairs)` | exact legacy equivalent |  |
| 6 | `minecraft:oak_slab` | `new ItemStack(Blocks.wooden_slab, 1, 0)` | exact legacy equivalent |  |
| 7 | `minecraft:oak_fence` | `new ItemStack(Blocks.fence)` | exact legacy equivalent |  |
| 8 | `minecraft:oak_fence_gate` | `new ItemStack(Blocks.fence_gate)` | exact legacy equivalent |  |
| 9 | `minecraft:oak_door` | `new ItemStack(Items.wooden_door)` | exact legacy equivalent |  |
| 10 | `minecraft:oak_trapdoor` | `new ItemStack(Blocks.trapdoor)` | exact legacy equivalent |  |
| 11 | `minecraft:oak_pressure_plate` | `new ItemStack(Blocks.wooden_pressure_plate)` | exact legacy equivalent |  |
| 12 | `minecraft:oak_button` | `new ItemStack(Blocks.wooden_button)` | exact legacy equivalent |  |
| 13 | `minecraft:spruce_log` | `new ItemStack(Blocks.log, 1, 1)` | exact legacy equivalent |  |
| 14 | `minecraft:spruce_wood` | `new ItemStack(ModBlocks.BARK.get(), 1, 1)` | EFR backport equivalent | Bark block |
| 15 | `minecraft:stripped_spruce_log` | `new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 1)` | EFR backport equivalent |  |
| 16 | `minecraft:stripped_spruce_wood` | `new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 1)` | EFR backport equivalent |  |
| 17 | `minecraft:spruce_planks` | `new ItemStack(Blocks.planks, 1, 1)` | exact legacy equivalent |  |
| 18 | `minecraft:spruce_stairs` | `new ItemStack(Blocks.spruce_stairs)` | exact legacy equivalent |  |
| 19 | `minecraft:spruce_slab` | `new ItemStack(Blocks.wooden_slab, 1, 1)` | exact legacy equivalent |  |
| 20 | `minecraft:spruce_fence` | `new ItemStack(ModBlocks.FENCE_SPRUCE.get())` | exact legacy equivalent |  |
| 21 | `minecraft:spruce_fence_gate` | `new ItemStack(ModBlocks.FENCE_GATE_SPRUCE.get())` | exact legacy equivalent |  |
| 22 | `minecraft:spruce_door` | `new ItemStack(ModBlocks.DOOR_SPRUCE.get())` | exact legacy equivalent |  |
| 23 | `minecraft:spruce_trapdoor` | `new ItemStack(ModBlocks.TRAPDOOR_SPRUCE.get())` | exact legacy equivalent |  |
| 24 | `minecraft:spruce_pressure_plate` | `new ItemStack(ModBlocks.PRESSURE_PLATE_SPRUCE.get())` | exact legacy equivalent |  |
| 25 | `minecraft:spruce_button` | `new ItemStack(ModBlocks.BUTTON_SPRUCE.get())` | exact legacy equivalent |  |
| 26 | `minecraft:birch_log` | `new ItemStack(Blocks.log, 1, 2)` | exact legacy equivalent |  |
| 27 | `minecraft:birch_wood` | `new ItemStack(ModBlocks.BARK.get(), 1, 2)` | EFR backport equivalent | Bark block |
| 28 | `minecraft:stripped_birch_log` | `new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 2)` | EFR backport equivalent |  |
| 29 | `minecraft:stripped_birch_wood` | `new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 2)` | EFR backport equivalent |  |
| 30 | `minecraft:birch_planks` | `new ItemStack(Blocks.planks, 1, 2)` | exact legacy equivalent |  |
| 31 | `minecraft:birch_stairs` | `new ItemStack(Blocks.birch_stairs)` | exact legacy equivalent |  |
| 32 | `minecraft:birch_slab` | `new ItemStack(Blocks.wooden_slab, 1, 2)` | exact legacy equivalent |  |
| 33 | `minecraft:birch_fence` | `new ItemStack(ModBlocks.FENCE_BIRCH.get())` | exact legacy equivalent |  |
| 34 | `minecraft:birch_fence_gate` | `new ItemStack(ModBlocks.FENCE_GATE_BIRCH.get())` | exact legacy equivalent |  |
| 35 | `minecraft:birch_door` | `new ItemStack(ModBlocks.DOOR_BIRCH.get())` | exact legacy equivalent |  |
| 36 | `minecraft:birch_trapdoor` | `new ItemStack(ModBlocks.TRAPDOOR_BIRCH.get())` | exact legacy equivalent |  |
| 37 | `minecraft:birch_pressure_plate` | `new ItemStack(ModBlocks.PRESSURE_PLATE_BIRCH.get())` | exact legacy equivalent |  |
| 38 | `minecraft:birch_button` | `new ItemStack(ModBlocks.BUTTON_BIRCH.get())` | exact legacy equivalent |  |
| 39 | `minecraft:jungle_log` | `new ItemStack(Blocks.log, 1, 3)` | exact legacy equivalent |  |
| 40 | `minecraft:jungle_wood` | `new ItemStack(ModBlocks.BARK.get(), 1, 3)` | EFR backport equivalent | Bark block |
| 41 | `minecraft:stripped_jungle_log` | `new ItemStack(ModBlocks.LOG_STRIPPED.get(), 1, 3)` | EFR backport equivalent |  |
| 42 | `minecraft:stripped_jungle_wood` | `new ItemStack(ModBlocks.WOOD_STRIPPED.get(), 1, 3)` | EFR backport equivalent |  |
| 43 | `minecraft:jungle_planks` | `new ItemStack(Blocks.planks, 1, 3)` | exact legacy equivalent |  |
| 44 | `minecraft:jungle_stairs` | `new ItemStack(Blocks.jungle_stairs)` | exact legacy equivalent |  |
| 45 | `minecraft:jungle_slab` | `new ItemStack(Blocks.wooden_slab, 1, 3)` | exact legacy equivalent |  |
| 46 | `minecraft:jungle_fence` | `new ItemStack(ModBlocks.FENCE_JUNGLE.get())` | exact legacy equivalent |  |
| 47 | `minecraft:jungle_fence_gate` | `new ItemStack(ModBlocks.FENCE_GATE_JUNGLE.get())` | exact legacy equivalent |  |
| 48 | `minecraft:jungle_door` | `new ItemStack(ModBlocks.DOOR_JUNGLE.get())` | exact legacy equivalent |  |
| 49 | `minecraft:jungle_trapdoor` | `new ItemStack(ModBlocks.TRAPDOOR_JUNGLE.get())` | exact legacy equivalent |  |
| 50 | `minecraft:jungle_pressure_plate` | `new ItemStack(ModBlocks.PRESSURE_PLATE_JUNGLE.get())` | exact legacy equivalent |  |
| 51 | `minecraft:jungle_button` | `new ItemStack(ModBlocks.BUTTON_JUNGLE.get())` | exact legacy equivalent |  |
| 52 | `minecraft:acacia_log` | `new ItemStack(Blocks.log2, 1, 0)` | exact legacy equivalent |  |
| 53 | `minecraft:acacia_wood` | `new ItemStack(ModBlocks.BARK2.get(), 1, 0)` | EFR backport equivalent | Bark block |
| 54 | `minecraft:stripped_acacia_log` | `new ItemStack(ModBlocks.LOG2_STRIPPED.get(), 1, 0)` | EFR backport equivalent |  |
| 55 | `minecraft:stripped_acacia_wood` | `new ItemStack(ModBlocks.WOOD2_STRIPPED.get(), 1, 0)` | EFR backport equivalent |  |
| 56 | `minecraft:acacia_planks` | `new ItemStack(Blocks.planks, 1, 4)` | exact legacy equivalent |  |
| 57 | `minecraft:acacia_stairs` | `new ItemStack(Blocks.acacia_stairs)` | exact legacy equivalent |  |
| 58 | `minecraft:acacia_slab` | `new ItemStack(Blocks.wooden_slab, 1, 4)` | exact legacy equivalent |  |
| 59 | `minecraft:acacia_fence` | `new ItemStack(ModBlocks.FENCE_ACACIA.get())` | exact legacy equivalent |  |
| 60 | `minecraft:acacia_fence_gate` | `new ItemStack(ModBlocks.FENCE_GATE_ACACIA.get())` | exact legacy equivalent |  |
| 61 | `minecraft:acacia_door` | `new ItemStack(ModBlocks.DOOR_ACACIA.get())` | exact legacy equivalent |  |
| 62 | `minecraft:acacia_trapdoor` | `new ItemStack(ModBlocks.TRAPDOOR_ACACIA.get())` | exact legacy equivalent |  |
| 63 | `minecraft:acacia_pressure_plate` | `new ItemStack(ModBlocks.PRESSURE_PLATE_ACACIA.get())` | exact legacy equivalent |  |
| 64 | `minecraft:acacia_button` | `new ItemStack(ModBlocks.BUTTON_ACACIA.get())` | exact legacy equivalent |  |
| 65 | `minecraft:dark_oak_log` | `new ItemStack(Blocks.log2, 1, 1)` | exact legacy equivalent |  |
| 66 | `minecraft:dark_oak_wood` | `new ItemStack(ModBlocks.BARK2.get(), 1, 1)` | EFR backport equivalent | Bark block |
| 67 | `minecraft:stripped_dark_oak_log` | `new ItemStack(ModBlocks.LOG2_STRIPPED.get(), 1, 1)` | EFR backport equivalent |  |
| 68 | `minecraft:stripped_dark_oak_wood` | `new ItemStack(ModBlocks.WOOD2_STRIPPED.get(), 1, 1)` | EFR backport equivalent |  |
| 69 | `minecraft:dark_oak_planks` | `new ItemStack(Blocks.planks, 1, 5)` | exact legacy equivalent |  |
| 70 | `minecraft:dark_oak_stairs` | `new ItemStack(Blocks.dark_oak_stairs)` | exact legacy equivalent |  |
| 71 | `minecraft:dark_oak_slab` | `new ItemStack(Blocks.wooden_slab, 1, 5)` | exact legacy equivalent |  |
| 72 | `minecraft:dark_oak_fence` | `new ItemStack(ModBlocks.FENCE_DARK_OAK.get())` | exact legacy equivalent |  |
| 73 | `minecraft:dark_oak_fence_gate` | `new ItemStack(ModBlocks.FENCE_GATE_DARK_OAK.get())` | exact legacy equivalent |  |
| 74 | `minecraft:dark_oak_door` | `new ItemStack(ModBlocks.DOOR_DARK_OAK.get())` | exact legacy equivalent |  |
| 75 | `minecraft:dark_oak_trapdoor` | `new ItemStack(ModBlocks.TRAPDOOR_DARK_OAK.get())` | exact legacy equivalent |  |
| 76 | `minecraft:dark_oak_pressure_plate` | `new ItemStack(ModBlocks.PRESSURE_PLATE_DARK_OAK.get())` | exact legacy equivalent |  |
| 77 | `minecraft:dark_oak_button` | `new ItemStack(ModBlocks.BUTTON_DARK_OAK.get())` | exact legacy equivalent |  |
| 78 | `minecraft:mangrove_log` | `new ItemStack(ModBlocks.MANGROVE_LOG.get())` | EFR backport equivalent |  |
| 79 | `minecraft:mangrove_wood` | `Omitted` | missing | Not backported |
| 80 | `minecraft:stripped_mangrove_log` | `Omitted` | missing | Not backported |
| 81 | `minecraft:stripped_mangrove_wood` | `Omitted` | missing | Not backported |
| 82 | `minecraft:mangrove_planks` | `new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 2)` | EFR backport equivalent |  |
| 83 | `minecraft:mangrove_stairs` | `new ItemStack(ModBlocks.MANGROVE_STAIRS.get())` | EFR backport equivalent |  |
| 84 | `minecraft:mangrove_slab` | `new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 2)` | EFR backport equivalent |  |
| 85 | `minecraft:mangrove_fence` | `new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 2)` | EFR backport equivalent |  |
| 86 | `minecraft:mangrove_fence_gate` | `new ItemStack(ModBlocks.MANGROVE_FENCE_GATE.get())` | EFR backport equivalent |  |
| 87 | `minecraft:mangrove_door` | `new ItemStack(ModBlocks.MANGROVE_DOOR.get())` | EFR backport equivalent |  |
| 88 | `minecraft:mangrove_trapdoor` | `new ItemStack(ModBlocks.MANGROVE_TRAPDOOR.get())` | EFR backport equivalent |  |
| 89 | `minecraft:mangrove_pressure_plate` | `new ItemStack(ModBlocks.MANGROVE_PRESSURE_PLATE.get())` | EFR backport equivalent |  |
| 90 | `minecraft:mangrove_button` | `new ItemStack(ModBlocks.MANGROVE_BUTTON.get())` | EFR backport equivalent |  |
| 91 | `minecraft:cherry_log` | `new ItemStack(ModBlocks.CHERRY_LOG.get())` | EFR backport equivalent |  |
| 92 | `minecraft:cherry_wood` | `Omitted` | missing | Not backported |
| 93 | `minecraft:stripped_cherry_log` | `Omitted` | missing | Not backported |
| 94 | `minecraft:stripped_cherry_wood` | `Omitted` | missing | Not backported |
| 95 | `minecraft:cherry_planks` | `new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 3)` | EFR backport equivalent |  |
| 96 | `minecraft:cherry_stairs` | `new ItemStack(ModBlocks.CHERRY_STAIRS.get())` | EFR backport equivalent |  |
| 97 | `minecraft:cherry_slab` | `new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 3)` | EFR backport equivalent |  |
| 98 | `minecraft:cherry_fence` | `new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 3)` | EFR backport equivalent |  |
| 99 | `minecraft:cherry_fence_gate` | `new ItemStack(ModBlocks.CHERRY_FENCE_GATE.get())` | EFR backport equivalent |  |
| 100 | `minecraft:cherry_door` | `new ItemStack(ModBlocks.CHERRY_DOOR.get())` | EFR backport equivalent |  |
| 101 | `minecraft:cherry_trapdoor` | `new ItemStack(ModBlocks.CHERRY_TRAPDOOR.get())` | EFR backport equivalent |  |
| 102 | `minecraft:cherry_pressure_plate` | `new ItemStack(ModBlocks.CHERRY_PRESSURE_PLATE.get())` | EFR backport equivalent |  |
| 103 | `minecraft:cherry_button` | `new ItemStack(ModBlocks.CHERRY_BUTTON.get())` | EFR backport equivalent |  |
| 104 | `minecraft:pale_oak_log` | `Omitted` | missing | Not backported |
| 105 | `minecraft:pale_oak_wood` | `Omitted` | missing | Not backported |
| 106 | `minecraft:stripped_pale_oak_log` | `Omitted` | missing | Not backported |
| 107 | `minecraft:stripped_pale_oak_wood` | `Omitted` | missing | Not backported |
| 108 | `minecraft:pale_oak_planks` | `Omitted` | missing | Not backported |
| 109 | `minecraft:pale_oak_stairs` | `Omitted` | missing | Not backported |
| 110 | `minecraft:pale_oak_slab` | `Omitted` | missing | Not backported |
| 111 | `minecraft:pale_oak_fence` | `Omitted` | missing | Not backported |
| 112 | `minecraft:pale_oak_fence_gate` | `Omitted` | missing | Not backported |
| 113 | `minecraft:pale_oak_door` | `Omitted` | missing | Not backported |
| 114 | `minecraft:pale_oak_trapdoor` | `Omitted` | missing | Not backported |
| 115 | `minecraft:pale_oak_pressure_plate` | `Omitted` | missing | Not backported |
| 116 | `minecraft:pale_oak_button` | `Omitted` | missing | Not backported |
| 117 | `minecraft:bamboo_block` | `new ItemStack(ModBlocks.BAMBOO_BLOCK.get())` | EFR backport equivalent | Automatically resolved |
| 118 | `minecraft:stripped_bamboo_block` | `Omitted` | missing | Not backported |
| 119 | `minecraft:bamboo_planks` | `new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 4)` | EFR backport equivalent |  |
| 120 | `minecraft:bamboo_mosaic` | `new ItemStack(ModBlocks.BAMBOO_MOSAIC.get())` | EFR backport equivalent | Automatically resolved |
| 121 | `minecraft:bamboo_stairs` | `new ItemStack(ModBlocks.BAMBOO_STAIRS.get())` | EFR backport equivalent |  |
| 122 | `minecraft:bamboo_mosaic_stairs` | `new ItemStack(ModBlocks.BAMBOO_MOSAIC_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 123 | `minecraft:bamboo_slab` | `new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 4)` | EFR backport equivalent |  |
| 124 | `minecraft:bamboo_mosaic_slab` | `new ItemStack(ModBlocks.BAMBOO_MOSAIC_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 125 | `minecraft:bamboo_fence` | `new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 4)` | EFR backport equivalent |  |
| 126 | `minecraft:bamboo_fence_gate` | `new ItemStack(ModBlocks.BAMBOO_FENCE_GATE.get())` | EFR backport equivalent |  |
| 127 | `minecraft:bamboo_door` | `new ItemStack(ModBlocks.BAMBOO_DOOR.get())` | EFR backport equivalent |  |
| 128 | `minecraft:bamboo_trapdoor` | `new ItemStack(ModBlocks.BAMBOO_TRAPDOOR.get())` | EFR backport equivalent |  |
| 129 | `minecraft:bamboo_pressure_plate` | `new ItemStack(ModBlocks.BAMBOO_PRESSURE_PLATE.get())` | EFR backport equivalent |  |
| 130 | `minecraft:bamboo_button` | `new ItemStack(ModBlocks.BAMBOO_BUTTON.get())` | EFR backport equivalent |  |
| 131 | `minecraft:crimson_stem` | `new ItemStack(ModBlocks.CRIMSON_STEM.get())` | EFR backport equivalent |  |
| 132 | `minecraft:crimson_hyphae` | `Omitted` | missing | Not backported |
| 133 | `minecraft:stripped_crimson_stem` | `Omitted` | missing | Not backported |
| 134 | `minecraft:stripped_crimson_hyphae` | `Omitted` | missing | Not backported |
| 135 | `minecraft:crimson_planks` | `new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 0)` | EFR backport equivalent |  |
| 136 | `minecraft:crimson_stairs` | `new ItemStack(ModBlocks.CRIMSON_STAIRS.get())` | EFR backport equivalent |  |
| 137 | `minecraft:crimson_slab` | `new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 0)` | EFR backport equivalent |  |
| 138 | `minecraft:crimson_fence` | `new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 0)` | EFR backport equivalent |  |
| 139 | `minecraft:crimson_fence_gate` | `new ItemStack(ModBlocks.CRIMSON_FENCE_GATE.get())` | EFR backport equivalent |  |
| 140 | `minecraft:crimson_door` | `new ItemStack(ModBlocks.CRIMSON_DOOR.get())` | EFR backport equivalent |  |
| 141 | `minecraft:crimson_trapdoor` | `new ItemStack(ModBlocks.CRIMSON_TRAPDOOR.get())` | EFR backport equivalent |  |
| 142 | `minecraft:crimson_pressure_plate` | `new ItemStack(ModBlocks.CRIMSON_PRESSURE_PLATE.get())` | EFR backport equivalent |  |
| 143 | `minecraft:crimson_button` | `new ItemStack(ModBlocks.CRIMSON_BUTTON.get())` | EFR backport equivalent |  |
| 144 | `minecraft:warped_stem` | `new ItemStack(ModBlocks.WARPED_STEM.get())` | EFR backport equivalent |  |
| 145 | `minecraft:warped_hyphae` | `Omitted` | missing | Not backported |
| 146 | `minecraft:stripped_warped_stem` | `Omitted` | missing | Not backported |
| 147 | `minecraft:stripped_warped_hyphae` | `Omitted` | missing | Not backported |
| 148 | `minecraft:warped_planks` | `new ItemStack(ModBlocks.WOOD_PLANKS.get(), 1, 1)` | EFR backport equivalent |  |
| 149 | `minecraft:warped_stairs` | `new ItemStack(ModBlocks.WARPED_STAIRS.get())` | EFR backport equivalent |  |
| 150 | `minecraft:warped_slab` | `new ItemStack(ModBlocks.WOOD_SLAB.get(), 1, 1)` | EFR backport equivalent |  |
| 151 | `minecraft:warped_fence` | `new ItemStack(ModBlocks.WOOD_FENCE.get(), 1, 1)` | EFR backport equivalent |  |
| 152 | `minecraft:warped_fence_gate` | `new ItemStack(ModBlocks.WARPED_FENCE_GATE.get())` | EFR backport equivalent |  |
| 153 | `minecraft:warped_door` | `new ItemStack(ModBlocks.WARPED_DOOR.get())` | EFR backport equivalent |  |
| 154 | `minecraft:warped_trapdoor` | `new ItemStack(ModBlocks.WARPED_TRAPDOOR.get())` | EFR backport equivalent |  |
| 155 | `minecraft:warped_pressure_plate` | `new ItemStack(ModBlocks.WARPED_PRESSURE_PLATE.get())` | EFR backport equivalent |  |
| 156 | `minecraft:warped_button` | `new ItemStack(ModBlocks.WARPED_BUTTON.get())` | EFR backport equivalent |  |
| 157 | `minecraft:stone` | `new ItemStack(Blocks.stone, 1, 0)` | exact legacy equivalent |  |
| 158 | `minecraft:stone_stairs` | `new ItemStack(ModBlocks.STONE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 159 | `minecraft:stone_slab` | `new ItemStack(ModBlocks.STONE_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 160 | `minecraft:stone_pressure_plate` | `Omitted` | missing | Not backported |
| 161 | `minecraft:stone_button` | `Omitted` | missing | Not backported |
| 162 | `minecraft:cobblestone` | `new ItemStack(Blocks.cobblestone)` | exact legacy equivalent |  |
| 163 | `minecraft:cobblestone_stairs` | `Omitted` | missing | Not backported |
| 164 | `minecraft:cobblestone_slab` | `Omitted` | missing | Not backported |
| 165 | `minecraft:cobblestone_wall` | `Omitted` | missing | Not backported |
| 166 | `minecraft:mossy_cobblestone` | `new ItemStack(Blocks.mossy_cobblestone)` | exact legacy equivalent |  |
| 167 | `minecraft:mossy_cobblestone_stairs` | `new ItemStack(ModBlocks.MOSSY_COBBLESTONE_STAIRS.get())` | EFR backport equivalent |  |
| 168 | `minecraft:mossy_cobblestone_slab` | `Omitted` | missing | Not backported |
| 169 | `minecraft:mossy_cobblestone_wall` | `Omitted` | missing | Not backported |
| 170 | `minecraft:smooth_stone` | `new ItemStack(ModBlocks.SMOOTH_STONE.get())` | EFR backport equivalent |  |
| 171 | `minecraft:smooth_stone_slab` | `new ItemStack(Blocks.stone_slab, 1, 8)` | exact legacy equivalent |  |
| 172 | `minecraft:stone_bricks` | `new ItemStack(Blocks.stonebrick, 1, 0)` | exact legacy equivalent |  |
| 173 | `minecraft:cracked_stone_bricks` | `new ItemStack(Blocks.stonebrick, 1, 2)` | exact legacy equivalent |  |
| 174 | `minecraft:stone_brick_stairs` | `Omitted` | missing | Not backported |
| 175 | `minecraft:stone_brick_slab` | `Omitted` | missing | Not backported |
| 176 | `minecraft:stone_brick_wall` | `new ItemStack(ModBlocks.STONE_WALL.get(), 1, 0)` | EFR backport equivalent | Automatically resolved |
| 177 | `minecraft:chiseled_stone_bricks` | `new ItemStack(Blocks.stonebrick, 1, 3)` | exact legacy equivalent |  |
| 178 | `minecraft:mossy_stone_bricks` | `new ItemStack(Blocks.stonebrick, 1, 1)` | exact legacy equivalent |  |
| 179 | `minecraft:mossy_stone_brick_stairs` | `new ItemStack(ModBlocks.MOSSY_STONE_BRICK_STAIRS.get())` | EFR backport equivalent |  |
| 180 | `minecraft:mossy_stone_brick_slab` | `Omitted` | missing | Not backported |
| 181 | `minecraft:mossy_stone_brick_wall` | `new ItemStack(ModBlocks.STONE_WALL.get(), 1, 1)` | EFR backport equivalent | Automatically resolved |
| 182 | `minecraft:granite` | `new ItemStack(ModBlocks.STONE.get(), 1, 1)` | EFR backport equivalent |  |
| 183 | `minecraft:granite_stairs` | `new ItemStack(ModBlocks.GRANITE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 184 | `minecraft:granite_slab` | `new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 0)` | EFR backport equivalent | Automatically resolved |
| 185 | `minecraft:granite_wall` | `new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 0)` | EFR backport equivalent | Automatically resolved |
| 186 | `minecraft:polished_granite` | `new ItemStack(ModBlocks.STONE.get(), 1, 2)` | EFR backport equivalent |  |
| 187 | `minecraft:polished_granite_stairs` | `new ItemStack(ModBlocks.POLISHED_GRANITE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 188 | `minecraft:polished_granite_slab` | `new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 1)` | EFR backport equivalent | Automatically resolved |
| 189 | `minecraft:diorite` | `new ItemStack(ModBlocks.STONE.get(), 1, 3)` | EFR backport equivalent |  |
| 190 | `minecraft:diorite_stairs` | `new ItemStack(ModBlocks.DIORITE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 191 | `minecraft:diorite_slab` | `new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 2)` | EFR backport equivalent | Automatically resolved |
| 192 | `minecraft:diorite_wall` | `new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 1)` | EFR backport equivalent | Automatically resolved |
| 193 | `minecraft:polished_diorite` | `new ItemStack(ModBlocks.STONE.get(), 1, 4)` | EFR backport equivalent |  |
| 194 | `minecraft:polished_diorite_stairs` | `new ItemStack(ModBlocks.POLISHED_DIORITE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 195 | `minecraft:polished_diorite_slab` | `new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 3)` | EFR backport equivalent | Automatically resolved |
| 196 | `minecraft:andesite` | `new ItemStack(ModBlocks.STONE.get(), 1, 5)` | EFR backport equivalent |  |
| 197 | `minecraft:andesite_stairs` | `new ItemStack(ModBlocks.ANDESITE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 198 | `minecraft:andesite_slab` | `new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 4)` | EFR backport equivalent | Automatically resolved |
| 199 | `minecraft:andesite_wall` | `new ItemStack(ModBlocks.STONE_WALL_2.get(), 1, 2)` | EFR backport equivalent | Automatically resolved |
| 200 | `minecraft:polished_andesite` | `new ItemStack(ModBlocks.STONE.get(), 1, 6)` | EFR backport equivalent |  |
| 201 | `minecraft:polished_andesite_stairs` | `new ItemStack(ModBlocks.POLISHED_ANDESITE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 202 | `minecraft:polished_andesite_slab` | `new ItemStack(ModBlocks.STONE_SLAB_2.get(), 1, 5)` | EFR backport equivalent | Automatically resolved |
| 203 | `minecraft:deepslate` | `new ItemStack(ModBlocks.DEEPSLATE.get())` | EFR backport equivalent |  |
| 204 | `minecraft:cobbled_deepslate` | `new ItemStack(ModBlocks.COBBLED_DEEPSLATE.get())` | EFR backport equivalent |  |
| 205 | `minecraft:cobbled_deepslate_stairs` | `new ItemStack(ModBlocks.COBBLED_DEEPSLATE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 206 | `minecraft:cobbled_deepslate_slab` | `new ItemStack(ModBlocks.DEEPSLATE_SLAB.get(), 1, 0)` | EFR backport equivalent | Automatically resolved |
| 207 | `minecraft:cobbled_deepslate_wall` | `new ItemStack(ModBlocks.DEEPSLATE_WALL.get(), 1, 0)` | EFR backport equivalent | Automatically resolved |
| 208 | `minecraft:chiseled_deepslate` | `Omitted` | missing | Not backported |
| 209 | `minecraft:polished_deepslate` | `new ItemStack(ModBlocks.POLISHED_DEEPSLATE.get())` | EFR backport equivalent |  |
| 210 | `minecraft:polished_deepslate_stairs` | `new ItemStack(ModBlocks.POLISHED_DEEPSLATE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 211 | `minecraft:polished_deepslate_slab` | `new ItemStack(ModBlocks.DEEPSLATE_SLAB.get(), 1, 1)` | EFR backport equivalent | Automatically resolved |
| 212 | `minecraft:polished_deepslate_wall` | `new ItemStack(ModBlocks.DEEPSLATE_WALL.get(), 1, 1)` | EFR backport equivalent | Automatically resolved |
| 213 | `minecraft:deepslate_bricks` | `new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 0)` | EFR backport equivalent |  |
| 214 | `minecraft:cracked_deepslate_bricks` | `new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 1)` | EFR backport equivalent |  |
| 215 | `minecraft:deepslate_brick_stairs` | `new ItemStack(ModBlocks.DEEPSLATE_BRICK_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 216 | `minecraft:deepslate_brick_slab` | `new ItemStack(ModBlocks.DEEPSLATE_BRICK_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 217 | `minecraft:deepslate_brick_wall` | `new ItemStack(ModBlocks.DEEPSLATE_BRICK_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 218 | `minecraft:deepslate_tiles` | `new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 2)` | EFR backport equivalent |  |
| 219 | `minecraft:cracked_deepslate_tiles` | `new ItemStack(ModBlocks.DEEPSLATE_BRICKS.get(), 1, 3)` | EFR backport equivalent |  |
| 220 | `minecraft:deepslate_tile_stairs` | `new ItemStack(ModBlocks.DEEPSLATE_TILE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 221 | `minecraft:deepslate_tile_slab` | `new ItemStack(ModBlocks.DEEPSLATE_BRICK_SLAB.get(), 1, 1)` | EFR backport equivalent | Automatically resolved |
| 222 | `minecraft:deepslate_tile_wall` | `Omitted` | missing | Not backported |
| 223 | `minecraft:reinforced_deepslate` | `Omitted` | missing | Not backported |
| 224 | `minecraft:tuff` | `new ItemStack(ModBlocks.TUFF.get())` | EFR backport equivalent |  |
| 225 | `minecraft:tuff_stairs` | `new ItemStack(ModBlocks.TUFF_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 226 | `minecraft:tuff_slab` | `new ItemStack(ModBlocks.TUFF_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 227 | `minecraft:tuff_wall` | `new ItemStack(ModBlocks.TUFF_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 228 | `minecraft:chiseled_tuff` | `Omitted` | missing | Not backported |
| 229 | `minecraft:polished_tuff` | `Omitted` | missing | Not backported |
| 230 | `minecraft:polished_tuff_stairs` | `new ItemStack(ModBlocks.POLISHED_TUFF_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 231 | `minecraft:polished_tuff_slab` | `Omitted` | missing | Not backported |
| 232 | `minecraft:polished_tuff_wall` | `Omitted` | missing | Not backported |
| 233 | `minecraft:tuff_bricks` | `Omitted` | missing | Not backported |
| 234 | `minecraft:tuff_brick_stairs` | `new ItemStack(ModBlocks.TUFF_BRICK_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 235 | `minecraft:tuff_brick_slab` | `Omitted` | missing | Not backported |
| 236 | `minecraft:tuff_brick_wall` | `Omitted` | missing | Not backported |
| 237 | `minecraft:chiseled_tuff_bricks` | `Omitted` | missing | Not backported |
| 238 | `minecraft:bricks` | `Omitted` | missing | Not backported |
| 239 | `minecraft:brick_stairs` | `Omitted` | missing | Not backported |
| 240 | `minecraft:brick_slab` | `Omitted` | missing | Not backported |
| 241 | `minecraft:brick_wall` | `new ItemStack(ModBlocks.STONE_WALL.get(), 1, 3)` | EFR backport equivalent | Automatically resolved |
| 242 | `minecraft:packed_mud` | `new ItemStack(ModBlocks.PACKED_MUD.get())` | EFR backport equivalent |  |
| 243 | `minecraft:mud_bricks` | `Omitted` | missing | Not backported |
| 244 | `minecraft:mud_brick_stairs` | `new ItemStack(ModBlocks.MUD_BRICK_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 245 | `minecraft:mud_brick_slab` | `new ItemStack(ModBlocks.MUD_BRICK_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 246 | `minecraft:mud_brick_wall` | `new ItemStack(ModBlocks.MUD_BRICK_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 247 | `minecraft:resin_bricks` | `Omitted` | missing | Not backported |
| 248 | `minecraft:resin_brick_stairs` | `Omitted` | missing | Not backported |
| 249 | `minecraft:resin_brick_slab` | `Omitted` | missing | Not backported |
| 250 | `minecraft:resin_brick_wall` | `Omitted` | missing | Not backported |
| 251 | `minecraft:chiseled_resin_bricks` | `Omitted` | missing | Not backported |
| 252 | `minecraft:sandstone` | `new ItemStack(Blocks.sandstone, 1, 0)` | exact legacy equivalent |  |
| 253 | `minecraft:sandstone_stairs` | `Omitted` | missing | Not backported |
| 254 | `minecraft:sandstone_slab` | `Omitted` | missing | Not backported |
| 255 | `minecraft:sandstone_wall` | `new ItemStack(ModBlocks.STONE_WALL.get(), 1, 2)` | EFR backport equivalent | Automatically resolved |
| 256 | `minecraft:chiseled_sandstone` | `new ItemStack(Blocks.sandstone, 1, 1)` | exact legacy equivalent |  |
| 257 | `minecraft:smooth_sandstone` | `new ItemStack(ModBlocks.SMOOTH_SANDSTONE.get())` | EFR backport equivalent |  |
| 258 | `minecraft:smooth_sandstone_stairs` | `new ItemStack(ModBlocks.SMOOTH_SANDSTONE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 259 | `minecraft:smooth_sandstone_slab` | `new ItemStack(ModBlocks.SMOOTH_SANDSTONE_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 260 | `minecraft:cut_sandstone` | `new ItemStack(Blocks.sandstone, 1, 2)` | exact legacy equivalent |  |
| 261 | `minecraft:cut_standstone_slab` | `Omitted` | missing | Not backported |
| 262 | `minecraft:red_sandstone` | `new ItemStack(ModBlocks.RED_SANDSTONE.get(), 1, 0)` | EFR backport equivalent |  |
| 263 | `minecraft:red_sandstone_stairs` | `new ItemStack(ModBlocks.RED_SANDSTONE_STAIRS.get())` | EFR backport equivalent |  |
| 264 | `minecraft:red_sandstone_slab` | `new ItemStack(ModBlocks.RED_SANDSTONE_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 265 | `minecraft:red_sandstone_wall` | `new ItemStack(ModBlocks.RED_SANDSTONE_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 266 | `minecraft:chiseled_red_sandstone` | `new ItemStack(ModBlocks.RED_SANDSTONE.get(), 1, 1)` | EFR backport equivalent |  |
| 267 | `minecraft:smooth_red_sandstone` | `new ItemStack(ModBlocks.SMOOTH_RED_SANDSTONE.get())` | EFR backport equivalent |  |
| 268 | `minecraft:smooth_red_sandstone_stairs` | `new ItemStack(ModBlocks.SMOOTH_RED_SANDSTONE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 269 | `minecraft:smooth_red_sandstone_slab` | `new ItemStack(ModBlocks.SMOOTH_RED_SANDSTONE_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 270 | `minecraft:cut_red_sandstone` | `new ItemStack(ModBlocks.RED_SANDSTONE.get(), 1, 2)` | EFR backport equivalent |  |
| 271 | `minecraft:cut_red_sandstone_slab` | `Omitted` | missing | Not backported |
| 272 | `minecraft:sea_lantern` | `new ItemStack(ModBlocks.SEA_LANTERN.get())` | EFR backport equivalent |  |
| 273 | `minecraft:prismarine` | `new ItemStack(ModBlocks.PRISMARINE_BLOCK.get(), 1, 0)` | EFR backport equivalent |  |
| 274 | `minecraft:prismarine_stairs` | `new ItemStack(ModBlocks.PRISMARINE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 275 | `minecraft:prismarine_slab` | `new ItemStack(ModBlocks.PRISMARINE_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 276 | `minecraft:prismarine_wall` | `new ItemStack(ModBlocks.PRISMARINE_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 277 | `minecraft:prismarine_bricks` | `new ItemStack(ModBlocks.PRISMARINE_BLOCK.get(), 1, 1)` | EFR backport equivalent |  |
| 278 | `minecraft:prismarine_brick_stairs` | `new ItemStack(ModBlocks.PRISMARINE_STAIRS_BRICK.get())` | EFR backport equivalent | Automatically resolved |
| 279 | `minecraft:prismarine_brick_slab` | `Omitted` | missing | Not backported |
| 280 | `minecraft:dark_prismarine` | `new ItemStack(ModBlocks.PRISMARINE_BLOCK.get(), 1, 2)` | EFR backport equivalent |  |
| 281 | `minecraft:dark_prismarine_stairs` | `new ItemStack(ModBlocks.PRISMARINE_STAIRS_DARK.get())` | EFR backport equivalent | Automatically resolved |
| 282 | `minecraft:dark_prismarine_slab` | `Omitted` | missing | Not backported |
| 283 | `minecraft:netherrack` | `new ItemStack(Blocks.netherrack)` | exact legacy equivalent |  |
| 284 | `minecraft:nether_bricks` | `Omitted` | missing | Not backported |
| 285 | `minecraft:cracked_nether_bricks` | `Omitted` | missing | Not backported |
| 286 | `minecraft:nether_brick_stairs` | `Omitted` | missing | Not backported |
| 287 | `minecraft:nether_brick_slab` | `Omitted` | missing | Not backported |
| 288 | `minecraft:nether_brick_wall` | `new ItemStack(ModBlocks.NETHER_BRICK_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 289 | `minecraft:nether_brick_fence` | `Omitted` | missing | Not backported |
| 290 | `minecraft:chiseled_nether_bricks` | `Omitted` | missing | Not backported |
| 291 | `minecraft:red_nether_bricks` | `new ItemStack(ModBlocks.RED_NETHERBRICK.get())` | EFR backport equivalent | Automatically resolved |
| 292 | `minecraft:red_nether_brick_stairs` | `new ItemStack(ModBlocks.RED_NETHERBRICK_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 293 | `minecraft:red_nether_brick_slab` | `new ItemStack(ModBlocks.RED_NETHERBRICK_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 294 | `minecraft:red_nether_brick_wall` | `new ItemStack(ModBlocks.RED_NETHER_BRICK_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 295 | `minecraft:basalt` | `new ItemStack(ModBlocks.BASALT.get())` | EFR backport equivalent |  |
| 296 | `minecraft:smooth_basalt` | `new ItemStack(ModBlocks.SMOOTH_BASALT.get())` | EFR backport equivalent |  |
| 297 | `minecraft:polished_basalt` | `Omitted` | missing | Not backported |
| 298 | `minecraft:blackstone` | `new ItemStack(ModBlocks.BLACKSTONE.get(), 1, 0)` | EFR backport equivalent |  |
| 299 | `minecraft:gilded_blackstone` | `new ItemStack(ModBlocks.GILDED_BLACKSTONE.get())` | EFR backport equivalent | Automatically resolved |
| 300 | `minecraft:blackstone_stairs` | `new ItemStack(ModBlocks.BLACKSTONE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 301 | `minecraft:blackstone_slab` | `new ItemStack(ModBlocks.BLACKSTONE_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 302 | `minecraft:blackstone_wall` | `new ItemStack(ModBlocks.BLACKSTONE_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 303 | `minecraft:chiseled_polished_blackstone` | `Omitted` | missing | Not backported |
| 304 | `minecraft:polished_blackstone` | `Omitted` | missing | Not backported |
| 305 | `minecraft:polished_blackstone_stairs` | `new ItemStack(ModBlocks.POLISHED_BLACKSTONE_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 306 | `minecraft:polished_blackstone_slab` | `Omitted` | missing | Not backported |
| 307 | `minecraft:polished_blackstone_wall` | `Omitted` | missing | Not backported |
| 308 | `minecraft:polished_blackstone_pressure_plate` | `new ItemStack(ModBlocks.POLISHED_BLACKSTONE_PRESSURE_PLATE.get())` | EFR backport equivalent | Automatically resolved |
| 309 | `minecraft:polished_blackstone_button` | `new ItemStack(ModBlocks.POLISHED_BLACKSTONE_BUTTON.get())` | EFR backport equivalent | Automatically resolved |
| 310 | `minecraft:polished_blackstone_bricks` | `Omitted` | missing | Not backported |
| 311 | `minecraft:cracked_polished_blackstone_bricks` | `Omitted` | missing | Not backported |
| 312 | `minecraft:polished_blackstone_brick_stairs` | `new ItemStack(ModBlocks.POLISHED_BLACKSTONE_BRICK_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 313 | `minecraft:polished_blackstone_brick_slab` | `Omitted` | missing | Not backported |
| 314 | `minecraft:polished_blackstone_brick_wall` | `Omitted` | missing | Not backported |
| 315 | `minecraft:end_stone` | `new ItemStack(Blocks.end_stone)` | exact legacy equivalent |  |
| 316 | `minecraft:end_stone_bricks` | `new ItemStack(ModBlocks.END_BRICKS.get())` | EFR backport equivalent | Automatically resolved |
| 317 | `minecraft:end_stone_brick_stairs` | `new ItemStack(ModBlocks.END_BRICK_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 318 | `minecraft:end_stone_brick_slab` | `new ItemStack(ModBlocks.END_BRICK_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 319 | `minecraft:end_stone_brick_wall` | `new ItemStack(ModBlocks.END_BRICK_WALL.get())` | EFR backport equivalent | Automatically resolved |
| 320 | `minecraft:purpur_block` | `new ItemStack(ModBlocks.PURPUR_BLOCK.get())` | EFR backport equivalent | Automatically resolved |
| 321 | `minecraft:purpur_pillar` | `new ItemStack(ModBlocks.PURPUR_PILLAR.get())` | EFR backport equivalent | Automatically resolved |
| 322 | `minecraft:purpur_stairs` | `new ItemStack(ModBlocks.PURPUR_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 323 | `minecraft:purpur_slab` | `new ItemStack(ModBlocks.PURPUR_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 324 | `minecraft:coal_block` | `new ItemStack(Blocks.coal_block)` | exact legacy equivalent |  |
| 325 | `minecraft:iron_block` | `new ItemStack(Blocks.iron_block)` | exact legacy equivalent |  |
| 326 | `minecraft:iron_bars` | `new ItemStack(Blocks.iron_bars)` | exact legacy equivalent |  |
| 327 | `minecraft:iron_door` | `new ItemStack(Items.iron_door)` | EFR backport equivalent | Automatically resolved |
| 328 | `minecraft:iron_trapdoor` | `new ItemStack(ModBlocks.IRON_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 329 | `minecraft:heavy_weighted_pressure_plate` | `Omitted` | missing | Not backported |
| 330 | `minecraft:chain` | `new ItemStack(ModBlocks.CHAIN.get())` | EFR backport equivalent |  |
| 331 | `minecraft:gold_block` | `new ItemStack(Blocks.gold_block)` | exact legacy equivalent |  |
| 332 | `minecraft:light_weighted_pressure_plate` | `Omitted` | missing | Not backported |
| 333 | `minecraft:redstone_block` | `new ItemStack(Blocks.redstone_block)` | exact legacy equivalent |  |
| 334 | `minecraft:emerald_block` | `new ItemStack(Blocks.emerald_block)` | exact legacy equivalent |  |
| 335 | `minecraft:lapis_block` | `new ItemStack(Blocks.lapis_block)` | exact legacy equivalent |  |
| 336 | `minecraft:diamond_block` | `new ItemStack(Blocks.diamond_block)` | exact legacy equivalent |  |
| 337 | `minecraft:netherite_block` | `new ItemStack(ModBlocks.NETHERITE_BLOCK.get())` | EFR backport equivalent |  |
| 338 | `minecraft:quartz_block` | `new ItemStack(Blocks.quartz_block, 1, 0)` | exact legacy equivalent |  |
| 339 | `minecraft:quartz_stairs` | `Omitted` | missing | Not backported |
| 340 | `minecraft:quartz_slab` | `Omitted` | missing | Not backported |
| 341 | `minecraft:chiseled_quartz_block` | `new ItemStack(Blocks.quartz_block, 1, 1)` | exact legacy equivalent |  |
| 342 | `minecraft:quartz_bricks` | `new ItemStack(ModBlocks.QUARTZ_BRICKS.get())` | EFR backport equivalent | Automatically resolved |
| 343 | `minecraft:quartz_pillar` | `new ItemStack(Blocks.quartz_block, 1, 2)` | exact legacy equivalent |  |
| 344 | `minecraft:smooth_quartz` | `new ItemStack(ModBlocks.SMOOTH_QUARTZ.get())` | EFR backport equivalent |  |
| 345 | `minecraft:smooth_quartz_stairs` | `new ItemStack(ModBlocks.SMOOTH_QUARTZ_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 346 | `minecraft:smooth_quartz_slab` | `new ItemStack(ModBlocks.SMOOTH_QUARTZ_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 347 | `minecraft:amethyst_block` | `new ItemStack(ModBlocks.AMETHYST_BLOCK.get())` | EFR backport equivalent |  |
| 348 | `minecraft:copper_block` | `new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 0)` | EFR backport equivalent |  |
| 349 | `minecraft:chiseled_copper` | `new ItemStack(ModBlocks.CHISELED_COPPER.get())` | EFR backport equivalent | Automatically resolved |
| 350 | `minecraft:copper_grate` | `new ItemStack(ModBlocks.COPPER_GRATE.get())` | EFR backport equivalent | Automatically resolved |
| 351 | `minecraft:cut_copper` | `Omitted` | missing | Not backported |
| 352 | `minecraft:cut_copper_stairs` | `new ItemStack(ModBlocks.CUT_COPPER_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 353 | `minecraft:cut_copper_slab` | `new ItemStack(ModBlocks.CUT_COPPER_SLAB.get())` | EFR backport equivalent | Automatically resolved |
| 354 | `minecraft:copper_door` | `new ItemStack(ModBlocks.COPPER_DOOR.get())` | EFR backport equivalent | Automatically resolved |
| 355 | `minecraft:copper_trapdoor` | `new ItemStack(ModBlocks.COPPER_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 356 | `minecraft:copper_bulb` | `new ItemStack(ModBlocks.COPPER_BULB.get())` | EFR backport equivalent | Automatically resolved |
| 357 | `minecraft:exposed_copper` | `new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 1)` | EFR backport equivalent |  |
| 358 | `minecraft:exposed_chiseled_copper` | `Omitted` | missing | Not backported |
| 359 | `minecraft:exposed_copper_grate` | `Omitted` | missing | Not backported |
| 360 | `minecraft:exposed_cut_copper` | `Omitted` | missing | Not backported |
| 361 | `minecraft:exposed_cut_copper_stairs` | `new ItemStack(ModBlocks.EXPOSED_CUT_COPPER_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 362 | `minecraft:exposed_cut_copper_slab` | `Omitted` | missing | Not backported |
| 363 | `minecraft:exposed_copper_door` | `new ItemStack(ModBlocks.EXPOSED_COPPER_DOOR.get())` | EFR backport equivalent | Automatically resolved |
| 364 | `minecraft:exposed_copper_trapdoor` | `new ItemStack(ModBlocks.EXPOSED_COPPER_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 365 | `minecraft:exposed_copper_bulb` | `Omitted` | missing | Not backported |
| 366 | `minecraft:weathered_copper` | `new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 2)` | EFR backport equivalent |  |
| 367 | `minecraft:weathered_chiseled_copper` | `Omitted` | missing | Not backported |
| 368 | `minecraft:weathered_copper_grate` | `Omitted` | missing | Not backported |
| 369 | `minecraft:weathered_cut_copper` | `Omitted` | missing | Not backported |
| 370 | `minecraft:weathered_cut_copper_stairs` | `new ItemStack(ModBlocks.WEATHERED_CUT_COPPER_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 371 | `minecraft:weathered_cut_copper_slab` | `Omitted` | missing | Not backported |
| 372 | `minecraft:weathered_copper_door` | `new ItemStack(ModBlocks.WEATHERED_COPPER_DOOR.get())` | EFR backport equivalent | Automatically resolved |
| 373 | `minecraft:weathered_copper_trapdoor` | `new ItemStack(ModBlocks.WEATHERED_COPPER_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 374 | `minecraft:weathered_copper_bulb` | `Omitted` | missing | Not backported |
| 375 | `minecraft:oxidized_copper` | `new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 3)` | EFR backport equivalent |  |
| 376 | `minecraft:oxidized_chiseled_copper` | `Omitted` | missing | Not backported |
| 377 | `minecraft:oxidized_copper_grate` | `Omitted` | missing | Not backported |
| 378 | `minecraft:oxidized_cut_copper` | `Omitted` | missing | Not backported |
| 379 | `minecraft:oxidized_cut_copper_stairs` | `new ItemStack(ModBlocks.OXIDIZED_CUT_COPPER_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 380 | `minecraft:oxidized_cut_copper_slab` | `Omitted` | missing | Not backported |
| 381 | `minecraft:oxidized_copper_door` | `new ItemStack(ModBlocks.OXIDIZED_COPPER_DOOR.get())` | EFR backport equivalent | Automatically resolved |
| 382 | `minecraft:oxidized_copper_trapdoor` | `new ItemStack(ModBlocks.OXIDIZED_COPPER_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 383 | `minecraft:oxidized_copper_bulb` | `Omitted` | missing | Not backported |
| 384 | `minecraft:waxed_copper_block` | `new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 8)` | EFR backport equivalent |  |
| 385 | `minecraft:waxed_chiseled_copper` | `Omitted` | missing | Not backported |
| 386 | `minecraft:waxed_copper_grate` | `Omitted` | missing | Not backported |
| 387 | `minecraft:waxed_cut_copper` | `Omitted` | missing | Not backported |
| 388 | `minecraft:waxed_cut_copper_stairs` | `new ItemStack(ModBlocks.WAXED_CUT_COPPER_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 389 | `minecraft:waxed_cut_copper_slab` | `Omitted` | missing | Not backported |
| 390 | `minecraft:waxed_copper_door` | `new ItemStack(ModBlocks.WAXED_COPPER_DOOR.get())` | EFR backport equivalent | Automatically resolved |
| 391 | `minecraft:waxed_copper_trapdoor` | `new ItemStack(ModBlocks.WAXED_COPPER_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 392 | `minecraft:waxed_copper_bulb` | `Omitted` | missing | Not backported |
| 393 | `minecraft:waxed_exposed_copper` | `new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 9)` | EFR backport equivalent |  |
| 394 | `minecraft:waxed_exposed_chiseled_copper` | `Omitted` | missing | Not backported |
| 395 | `minecraft:waxed_exposed_copper_grate` | `Omitted` | missing | Not backported |
| 396 | `minecraft:waxed_exposed_cut_copper` | `Omitted` | missing | Not backported |
| 397 | `minecraft:waxed_exposed_cut_copper_stairs` | `new ItemStack(ModBlocks.WAXED_EXPOSED_CUT_COPPER_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 398 | `minecraft:waxed_exposed_cut_copper_slab` | `Omitted` | missing | Not backported |
| 399 | `minecraft:waxed_exposed_copper_door` | `new ItemStack(ModBlocks.WAXED_EXPOSED_COPPER_DOOR.get())` | EFR backport equivalent | Automatically resolved |
| 400 | `minecraft:waxed_exposed_copper_trapdoor` | `new ItemStack(ModBlocks.WAXED_EXPOSED_COPPER_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 401 | `minecraft:waxed_exposed_copper_bulb` | `Omitted` | missing | Not backported |
| 402 | `minecraft:waxed_weathered_copper` | `new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 10)` | EFR backport equivalent |  |
| 403 | `minecraft:waxed_weathered_chiseled_copper` | `Omitted` | missing | Not backported |
| 404 | `minecraft:waxed_weathered_copper_grate` | `Omitted` | missing | Not backported |
| 405 | `minecraft:waxed_weathered_cut_copper` | `Omitted` | missing | Not backported |
| 406 | `minecraft:waxed_weathered_cut_copper_stairs` | `new ItemStack(ModBlocks.WAXED_WEATHERED_CUT_COPPER_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 407 | `minecraft:waxed_weathered_cut_copper_slab` | `Omitted` | missing | Not backported |
| 408 | `minecraft:waxed_weathered_copper_door` | `new ItemStack(ModBlocks.WAXED_WEATHERED_COPPER_DOOR.get())` | EFR backport equivalent | Automatically resolved |
| 409 | `minecraft:waxed_weathered_copper_trapdoor` | `new ItemStack(ModBlocks.WAXED_WEATHERED_COPPER_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 410 | `minecraft:waxed_weathered_copper_bulb` | `Omitted` | missing | Not backported |
| 411 | `minecraft:waxed_oxidized_copper` | `new ItemStack(ModBlocks.COPPER_BLOCK.get(), 1, 11)` | EFR backport equivalent |  |
| 412 | `minecraft:waxed_oxidized_chiseled_copper` | `Omitted` | missing | Not backported |
| 413 | `minecraft:waxed_oxidized_copper_grate` | `Omitted` | missing | Not backported |
| 414 | `minecraft:waxed_oxidized_cut_copper` | `Omitted` | missing | Not backported |
| 415 | `minecraft:waxed_oxidized_cut_copper_stairs` | `new ItemStack(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS.get())` | EFR backport equivalent | Automatically resolved |
| 416 | `minecraft:waxed_oxidized_cut_copper_slab` | `Omitted` | missing | Not backported |
| 417 | `minecraft:waxed_oxidized_copper_door` | `new ItemStack(ModBlocks.WAXED_OXIDIZED_COPPER_DOOR.get())` | EFR backport equivalent | Automatically resolved |
| 418 | `minecraft:waxed_oxidized_copper_trapdoor` | `new ItemStack(ModBlocks.WAXED_OXIDIZED_COPPER_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 419 | `minecraft:waxed_oxidized_copper_bulb` | `Omitted` | missing | Not backported |

## Tab: Colored Blocks (`itemGroup.coloredBlocks`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:white_wool` | `new ItemStack(Blocks.wool, 1, 0)` | exact legacy equivalent |  |
| 1 | `minecraft:light_gray_wool` | `new ItemStack(Blocks.wool, 1, 8)` | exact legacy equivalent |  |
| 2 | `minecraft:gray_wool` | `new ItemStack(Blocks.wool, 1, 7)` | exact legacy equivalent |  |
| 3 | `minecraft:black_wool` | `new ItemStack(Blocks.wool, 1, 15)` | exact legacy equivalent |  |
| 4 | `minecraft:brown_wool` | `new ItemStack(Blocks.wool, 1, 12)` | exact legacy equivalent |  |
| 5 | `minecraft:red_wool` | `new ItemStack(Blocks.wool, 1, 14)` | exact legacy equivalent |  |
| 6 | `minecraft:orange_wool` | `new ItemStack(Blocks.wool, 1, 1)` | exact legacy equivalent |  |
| 7 | `minecraft:yellow_wool` | `new ItemStack(Blocks.wool, 1, 4)` | exact legacy equivalent |  |
| 8 | `minecraft:lime_wool` | `new ItemStack(Blocks.wool, 1, 5)` | exact legacy equivalent |  |
| 9 | `minecraft:green_wool` | `new ItemStack(Blocks.wool, 1, 13)` | exact legacy equivalent |  |
| 10 | `minecraft:cyan_wool` | `new ItemStack(Blocks.wool, 1, 9)` | exact legacy equivalent |  |
| 11 | `minecraft:light_blue_wool` | `new ItemStack(Blocks.wool, 1, 3)` | exact legacy equivalent |  |
| 12 | `minecraft:blue_wool` | `new ItemStack(Blocks.wool, 1, 11)` | exact legacy equivalent |  |
| 13 | `minecraft:purple_wool` | `new ItemStack(Blocks.wool, 1, 10)` | exact legacy equivalent |  |
| 14 | `minecraft:magenta_wool` | `new ItemStack(Blocks.wool, 1, 2)` | exact legacy equivalent |  |
| 15 | `minecraft:pink_wool` | `new ItemStack(Blocks.wool, 1, 6)` | exact legacy equivalent |  |
| 16 | `minecraft:white_carpet` | `new ItemStack(Blocks.carpet, 1, 0)` | exact legacy equivalent |  |
| 17 | `minecraft:light_gray_carpet` | `new ItemStack(Blocks.carpet, 1, 8)` | exact legacy equivalent |  |
| 18 | `minecraft:gray_carpet` | `new ItemStack(Blocks.carpet, 1, 7)` | exact legacy equivalent |  |
| 19 | `minecraft:black_carpet` | `new ItemStack(Blocks.carpet, 1, 15)` | exact legacy equivalent |  |
| 20 | `minecraft:brown_carpet` | `new ItemStack(Blocks.carpet, 1, 12)` | exact legacy equivalent |  |
| 21 | `minecraft:red_carpet` | `new ItemStack(Blocks.carpet, 1, 14)` | exact legacy equivalent |  |
| 22 | `minecraft:orange_carpet` | `new ItemStack(Blocks.carpet, 1, 1)` | exact legacy equivalent |  |
| 23 | `minecraft:yellow_carpet` | `new ItemStack(Blocks.carpet, 1, 4)` | exact legacy equivalent |  |
| 24 | `minecraft:lime_carpet` | `new ItemStack(Blocks.carpet, 1, 5)` | exact legacy equivalent |  |
| 25 | `minecraft:green_carpet` | `new ItemStack(Blocks.carpet, 1, 13)` | exact legacy equivalent |  |
| 26 | `minecraft:cyan_carpet` | `new ItemStack(Blocks.carpet, 1, 9)` | exact legacy equivalent |  |
| 27 | `minecraft:light_blue_carpet` | `new ItemStack(Blocks.carpet, 1, 3)` | exact legacy equivalent |  |
| 28 | `minecraft:blue_carpet` | `new ItemStack(Blocks.carpet, 1, 11)` | exact legacy equivalent |  |
| 29 | `minecraft:purple_carpet` | `new ItemStack(Blocks.carpet, 1, 10)` | exact legacy equivalent |  |
| 30 | `minecraft:magenta_carpet` | `new ItemStack(Blocks.carpet, 1, 2)` | exact legacy equivalent |  |
| 31 | `minecraft:pink_carpet` | `new ItemStack(Blocks.carpet, 1, 6)` | exact legacy equivalent |  |
| 32 | `minecraft:terracotta` | `Omitted` | missing | Not backported |
| 33 | `minecraft:white_terracotta` | `Omitted` | missing | Not backported |
| 34 | `minecraft:light_gray_terracotta` | `Omitted` | missing | Not backported |
| 35 | `minecraft:gray_terracotta` | `Omitted` | missing | Not backported |
| 36 | `minecraft:black_terracotta` | `Omitted` | missing | Not backported |
| 37 | `minecraft:brown_terracotta` | `Omitted` | missing | Not backported |
| 38 | `minecraft:red_terracotta` | `Omitted` | missing | Not backported |
| 39 | `minecraft:orange_terracotta` | `Omitted` | missing | Not backported |
| 40 | `minecraft:yellow_terracotta` | `Omitted` | missing | Not backported |
| 41 | `minecraft:lime_terracotta` | `Omitted` | missing | Not backported |
| 42 | `minecraft:green_terracotta` | `Omitted` | missing | Not backported |
| 43 | `minecraft:cyan_terracotta` | `Omitted` | missing | Not backported |
| 44 | `minecraft:light_blue_terracotta` | `Omitted` | missing | Not backported |
| 45 | `minecraft:blue_terracotta` | `Omitted` | missing | Not backported |
| 46 | `minecraft:purple_terracotta` | `Omitted` | missing | Not backported |
| 47 | `minecraft:magenta_terracotta` | `Omitted` | missing | Not backported |
| 48 | `minecraft:pink_terracotta` | `Omitted` | missing | Not backported |
| 49 | `minecraft:white_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 0)` | EFR backport equivalent |  |
| 50 | `minecraft:light_gray_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 8)` | EFR backport equivalent |  |
| 51 | `minecraft:gray_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 7)` | EFR backport equivalent |  |
| 52 | `minecraft:black_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 15)` | EFR backport equivalent |  |
| 53 | `minecraft:brown_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 12)` | EFR backport equivalent |  |
| 54 | `minecraft:red_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 14)` | EFR backport equivalent |  |
| 55 | `minecraft:orange_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 1)` | EFR backport equivalent |  |
| 56 | `minecraft:yellow_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 4)` | EFR backport equivalent |  |
| 57 | `minecraft:lime_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 5)` | EFR backport equivalent |  |
| 58 | `minecraft:green_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 13)` | EFR backport equivalent |  |
| 59 | `minecraft:cyan_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 9)` | EFR backport equivalent |  |
| 60 | `minecraft:light_blue_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 3)` | EFR backport equivalent |  |
| 61 | `minecraft:blue_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 11)` | EFR backport equivalent |  |
| 62 | `minecraft:purple_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 10)` | EFR backport equivalent |  |
| 63 | `minecraft:magenta_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 2)` | EFR backport equivalent |  |
| 64 | `minecraft:pink_concrete` | `new ItemStack(ModBlocks.CONCRETE.get(), 1, 6)` | EFR backport equivalent |  |
| 65 | `minecraft:white_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 0)` | EFR backport equivalent |  |
| 66 | `minecraft:light_gray_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 8)` | EFR backport equivalent |  |
| 67 | `minecraft:gray_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 7)` | EFR backport equivalent |  |
| 68 | `minecraft:black_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 15)` | EFR backport equivalent |  |
| 69 | `minecraft:brown_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 12)` | EFR backport equivalent |  |
| 70 | `minecraft:red_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 14)` | EFR backport equivalent |  |
| 71 | `minecraft:orange_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 1)` | EFR backport equivalent |  |
| 72 | `minecraft:yellow_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 4)` | EFR backport equivalent |  |
| 73 | `minecraft:lime_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 5)` | EFR backport equivalent |  |
| 74 | `minecraft:green_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 13)` | EFR backport equivalent |  |
| 75 | `minecraft:cyan_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 9)` | EFR backport equivalent |  |
| 76 | `minecraft:light_blue_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 3)` | EFR backport equivalent |  |
| 77 | `minecraft:blue_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 11)` | EFR backport equivalent |  |
| 78 | `minecraft:purple_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 10)` | EFR backport equivalent |  |
| 79 | `minecraft:magenta_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 2)` | EFR backport equivalent |  |
| 80 | `minecraft:pink_concrete_powder` | `new ItemStack(ModBlocks.CONCRETE_POWDER.get(), 1, 6)` | EFR backport equivalent |  |
| 81 | `minecraft:white_glazed_terracotta` | `new ItemStack(ModBlocks.WHITE_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 82 | `minecraft:light_gray_glazed_terracotta` | `new ItemStack(ModBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 83 | `minecraft:gray_glazed_terracotta` | `new ItemStack(ModBlocks.GRAY_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 84 | `minecraft:black_glazed_terracotta` | `new ItemStack(ModBlocks.BLACK_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 85 | `minecraft:brown_glazed_terracotta` | `new ItemStack(ModBlocks.BROWN_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 86 | `minecraft:red_glazed_terracotta` | `new ItemStack(ModBlocks.RED_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 87 | `minecraft:orange_glazed_terracotta` | `new ItemStack(ModBlocks.ORANGE_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 88 | `minecraft:yellow_glazed_terracotta` | `new ItemStack(ModBlocks.YELLOW_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 89 | `minecraft:lime_glazed_terracotta` | `new ItemStack(ModBlocks.LIME_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 90 | `minecraft:green_glazed_terracotta` | `new ItemStack(ModBlocks.GREEN_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 91 | `minecraft:cyan_glazed_terracotta` | `new ItemStack(ModBlocks.CYAN_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 92 | `minecraft:light_blue_glazed_terracotta` | `new ItemStack(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 93 | `minecraft:blue_glazed_terracotta` | `new ItemStack(ModBlocks.BLUE_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 94 | `minecraft:purple_glazed_terracotta` | `new ItemStack(ModBlocks.PURPLE_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 95 | `minecraft:magenta_glazed_terracotta` | `new ItemStack(ModBlocks.MAGENTA_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 96 | `minecraft:pink_glazed_terracotta` | `new ItemStack(ModBlocks.PINK_GLAZED_TERRACOTTA.get())` | EFR backport equivalent |  |
| 97 | `minecraft:glass` | `new ItemStack(Blocks.glass)` | exact legacy equivalent |  |
| 98 | `minecraft:tinted_glass` | `new ItemStack(ModBlocks.TINTED_GLASS.get())` | EFR backport equivalent |  |
| 99 | `minecraft:white_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 0)` | exact legacy equivalent |  |
| 100 | `minecraft:light_gray_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 8)` | exact legacy equivalent |  |
| 101 | `minecraft:gray_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 7)` | exact legacy equivalent |  |
| 102 | `minecraft:black_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 15)` | exact legacy equivalent |  |
| 103 | `minecraft:brown_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 12)` | exact legacy equivalent |  |
| 104 | `minecraft:red_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 14)` | exact legacy equivalent |  |
| 105 | `minecraft:orange_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 1)` | exact legacy equivalent |  |
| 106 | `minecraft:yellow_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 4)` | exact legacy equivalent |  |
| 107 | `minecraft:lime_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 5)` | exact legacy equivalent |  |
| 108 | `minecraft:green_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 13)` | exact legacy equivalent |  |
| 109 | `minecraft:cyan_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 9)` | exact legacy equivalent |  |
| 110 | `minecraft:light_blue_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 3)` | exact legacy equivalent |  |
| 111 | `minecraft:blue_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 11)` | exact legacy equivalent |  |
| 112 | `minecraft:purple_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 10)` | exact legacy equivalent |  |
| 113 | `minecraft:magenta_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 2)` | exact legacy equivalent |  |
| 114 | `minecraft:pink_stained_glass` | `new ItemStack(Blocks.stained_glass, 1, 6)` | exact legacy equivalent |  |
| 115 | `minecraft:glass_pane` | `new ItemStack(Blocks.glass_pane)` | exact legacy equivalent |  |
| 116 | `minecraft:white_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 0)` | exact legacy equivalent |  |
| 117 | `minecraft:light_gray_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 8)` | exact legacy equivalent |  |
| 118 | `minecraft:gray_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 7)` | exact legacy equivalent |  |
| 119 | `minecraft:black_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 15)` | exact legacy equivalent |  |
| 120 | `minecraft:brown_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 12)` | exact legacy equivalent |  |
| 121 | `minecraft:red_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 14)` | exact legacy equivalent |  |
| 122 | `minecraft:orange_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 1)` | exact legacy equivalent |  |
| 123 | `minecraft:yellow_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 4)` | exact legacy equivalent |  |
| 124 | `minecraft:lime_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 5)` | exact legacy equivalent |  |
| 125 | `minecraft:green_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 13)` | exact legacy equivalent |  |
| 126 | `minecraft:cyan_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 9)` | exact legacy equivalent |  |
| 127 | `minecraft:light_blue_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 3)` | exact legacy equivalent |  |
| 128 | `minecraft:blue_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 11)` | exact legacy equivalent |  |
| 129 | `minecraft:purple_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 10)` | exact legacy equivalent |  |
| 130 | `minecraft:magenta_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 2)` | exact legacy equivalent |  |
| 131 | `minecraft:pink_stained_glass_pane` | `new ItemStack(Blocks.stained_glass_pane, 1, 6)` | exact legacy equivalent |  |
| 132 | `minecraft:shulker_box` | `new ItemStack(ModBlocks.SHULKER_BOX.get())` | EFR backport equivalent | Automatically resolved |
| 133 | `minecraft:white_shulker_box` | `Omitted` | missing | Not backported |
| 134 | `minecraft:light_gray_shulker_box` | `Omitted` | missing | Not backported |
| 135 | `minecraft:gray_shulker_box` | `Omitted` | missing | Not backported |
| 136 | `minecraft:black_shulker_box` | `Omitted` | missing | Not backported |
| 137 | `minecraft:brown_shulker_box` | `Omitted` | missing | Not backported |
| 138 | `minecraft:red_shulker_box` | `Omitted` | missing | Not backported |
| 139 | `minecraft:orange_shulker_box` | `Omitted` | missing | Not backported |
| 140 | `minecraft:yellow_shulker_box` | `Omitted` | missing | Not backported |
| 141 | `minecraft:lime_shulker_box` | `Omitted` | missing | Not backported |
| 142 | `minecraft:green_shulker_box` | `Omitted` | missing | Not backported |
| 143 | `minecraft:cyan_shulker_box` | `Omitted` | missing | Not backported |
| 144 | `minecraft:light_blue_shulker_box` | `Omitted` | missing | Not backported |
| 145 | `minecraft:blue_shulker_box` | `Omitted` | missing | Not backported |
| 146 | `minecraft:purple_shulker_box` | `Omitted` | missing | Not backported |
| 147 | `minecraft:magenta_shulker_box` | `Omitted` | missing | Not backported |
| 148 | `minecraft:pink_shulker_box` | `Omitted` | missing | Not backported |
| 149 | `minecraft:white_bed` | `new ItemStack(ModBlocks.WHITE_BED.get())` | EFR backport equivalent |  |
| 150 | `minecraft:light_gray_bed` | `new ItemStack(ModBlocks.LIGHT_GRAY_BED.get())` | EFR backport equivalent |  |
| 151 | `minecraft:gray_bed` | `new ItemStack(ModBlocks.GRAY_BED.get())` | EFR backport equivalent |  |
| 152 | `minecraft:black_bed` | `new ItemStack(ModBlocks.BLACK_BED.get())` | EFR backport equivalent |  |
| 153 | `minecraft:brown_bed` | `new ItemStack(ModBlocks.BROWN_BED.get())` | EFR backport equivalent |  |
| 154 | `minecraft:red_bed` | `new ItemStack(ModBlocks.RED_BED.get())` | EFR backport equivalent |  |
| 155 | `minecraft:orange_bed` | `new ItemStack(ModBlocks.ORANGE_BED.get())` | EFR backport equivalent |  |
| 156 | `minecraft:yellow_bed` | `new ItemStack(ModBlocks.YELLOW_BED.get())` | EFR backport equivalent |  |
| 157 | `minecraft:lime_bed` | `new ItemStack(ModBlocks.LIME_BED.get())` | EFR backport equivalent |  |
| 158 | `minecraft:green_bed` | `new ItemStack(ModBlocks.GREEN_BED.get())` | EFR backport equivalent |  |
| 159 | `minecraft:cyan_bed` | `new ItemStack(ModBlocks.CYAN_BED.get())` | EFR backport equivalent |  |
| 160 | `minecraft:light_blue_bed` | `new ItemStack(ModBlocks.LIGHT_BLUE_BED.get())` | EFR backport equivalent |  |
| 161 | `minecraft:blue_bed` | `new ItemStack(ModBlocks.BLUE_BED.get())` | EFR backport equivalent |  |
| 162 | `minecraft:purple_bed` | `new ItemStack(ModBlocks.PURPLE_BED.get())` | EFR backport equivalent |  |
| 163 | `minecraft:magenta_bed` | `new ItemStack(ModBlocks.MAGENTA_BED.get())` | EFR backport equivalent |  |
| 164 | `minecraft:pink_bed` | `new ItemStack(ModBlocks.PINK_BED.get())` | EFR backport equivalent |  |
| 165 | `minecraft:candle` | `Omitted` | missing | Not backported |
| 166 | `minecraft:white_candle` | `Omitted` | missing | Not backported |
| 167 | `minecraft:light_gray_candle` | `Omitted` | missing | Not backported |
| 168 | `minecraft:gray_candle` | `Omitted` | missing | Not backported |
| 169 | `minecraft:black_candle` | `Omitted` | missing | Not backported |
| 170 | `minecraft:brown_candle` | `Omitted` | missing | Not backported |
| 171 | `minecraft:red_candle` | `Omitted` | missing | Not backported |
| 172 | `minecraft:orange_candle` | `Omitted` | missing | Not backported |
| 173 | `minecraft:yellow_candle` | `Omitted` | missing | Not backported |
| 174 | `minecraft:lime_candle` | `Omitted` | missing | Not backported |
| 175 | `minecraft:green_candle` | `Omitted` | missing | Not backported |
| 176 | `minecraft:cyan_candle` | `Omitted` | missing | Not backported |
| 177 | `minecraft:light_blue_candle` | `Omitted` | missing | Not backported |
| 178 | `minecraft:blue_candle` | `Omitted` | missing | Not backported |
| 179 | `minecraft:purple_candle` | `Omitted` | missing | Not backported |
| 180 | `minecraft:magenta_candle` | `Omitted` | missing | Not backported |
| 181 | `minecraft:pink_candle` | `Omitted` | missing | Not backported |
| 182 | `minecraft:white_banner` | `Omitted` | missing | Not backported |
| 183 | `minecraft:light_gray_banner` | `Omitted` | missing | Not backported |
| 184 | `minecraft:gray_banner` | `Omitted` | missing | Not backported |
| 185 | `minecraft:black_banner` | `Omitted` | missing | Not backported |
| 186 | `minecraft:brown_banner` | `Omitted` | missing | Not backported |
| 187 | `minecraft:red_banner` | `Omitted` | missing | Not backported |
| 188 | `minecraft:orange_banner` | `Omitted` | missing | Not backported |
| 189 | `minecraft:yellow_banner` | `Omitted` | missing | Not backported |
| 190 | `minecraft:lime_banner` | `Omitted` | missing | Not backported |
| 191 | `minecraft:green_banner` | `Omitted` | missing | Not backported |
| 192 | `minecraft:cyan_banner` | `Omitted` | missing | Not backported |
| 193 | `minecraft:light_blue_banner` | `Omitted` | missing | Not backported |
| 194 | `minecraft:blue_banner` | `Omitted` | missing | Not backported |
| 195 | `minecraft:purple_banner` | `Omitted` | missing | Not backported |
| 196 | `minecraft:magenta_banner` | `Omitted` | missing | Not backported |
| 197 | `minecraft:pink_banner` | `Omitted` | missing | Not backported |

## Tab: Natural Blocks (`itemGroup.natural`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:grass_block` | `new ItemStack(Blocks.grass)` | exact legacy equivalent |  |
| 1 | `minecraft:podzol` | `new ItemStack(Blocks.dirt, 1, 2)` | exact legacy equivalent |  |
| 2 | `minecraft:mycelium` | `new ItemStack(Blocks.mycelium)` | exact legacy equivalent |  |
| 3 | `minecraft:dirt_path` | `new ItemStack(ModBlocks.GRASS_PATH.get())` | EFR backport equivalent |  |
| 4 | `minecraft:dirt` | `new ItemStack(Blocks.dirt, 1, 0)` | exact legacy equivalent |  |
| 5 | `minecraft:coarse_dirt` | `new ItemStack(ModBlocks.COARSE_DIRT.get())` | EFR backport equivalent |  |
| 6 | `minecraft:rooted_dirt` | `Omitted` | missing | Not backported |
| 7 | `minecraft:farmland` | `new ItemStack(Blocks.farmland)` | exact legacy equivalent |  |
| 8 | `minecraft:mud` | `new ItemStack(ModBlocks.MUD.get())` | EFR backport equivalent |  |
| 9 | `minecraft:clay` | `new ItemStack(Blocks.clay)` | exact legacy equivalent |  |
| 10 | `minecraft:gravel` | `new ItemStack(Blocks.gravel)` | exact legacy equivalent |  |
| 11 | `minecraft:sand` | `new ItemStack(Blocks.sand, 1, 0)` | exact legacy equivalent |  |
| 12 | `minecraft:sandstone` | `new ItemStack(Blocks.sandstone, 1, 0)` | exact legacy equivalent |  |
| 13 | `minecraft:red_sand` | `new ItemStack(Blocks.sand, 1, 1)` | exact legacy equivalent |  |
| 14 | `minecraft:red_sandstone` | `new ItemStack(ModBlocks.RED_SANDSTONE.get(), 1, 0)` | EFR backport equivalent |  |
| 15 | `minecraft:ice` | `new ItemStack(Blocks.ice)` | exact legacy equivalent |  |
| 16 | `minecraft:packed_ice` | `new ItemStack(Blocks.packed_ice)` | exact legacy equivalent |  |
| 17 | `minecraft:blue_ice` | `new ItemStack(ModBlocks.BLUE_ICE.get())` | EFR backport equivalent |  |
| 18 | `minecraft:snow_block` | `new ItemStack(Blocks.snow)` | exact legacy equivalent |  |
| 19 | `minecraft:snow` | `new ItemStack(Blocks.snow_layer)` | exact legacy equivalent |  |
| 20 | `minecraft:moss_block` | `new ItemStack(ModBlocks.MOSS_BLOCK.get())` | EFR backport equivalent |  |
| 21 | `minecraft:moss_carpet` | `new ItemStack(ModBlocks.MOSS_CARPET.get())` | EFR backport equivalent |  |
| 22 | `minecraft:pale_moss_block` | `Omitted` | missing | Not backported |
| 23 | `minecraft:pale_moss_carpet` | `Omitted` | missing | Not backported |
| 24 | `minecraft:pale_hanging_moss` | `Omitted` | missing | Not backported |
| 25 | `minecraft:stone` | `new ItemStack(Blocks.stone, 1, 0)` | exact legacy equivalent |  |
| 26 | `minecraft:deepslate` | `new ItemStack(ModBlocks.DEEPSLATE.get())` | EFR backport equivalent |  |
| 27 | `minecraft:granite` | `new ItemStack(ModBlocks.STONE.get(), 1, 1)` | EFR backport equivalent |  |
| 28 | `minecraft:diorite` | `new ItemStack(ModBlocks.STONE.get(), 1, 3)` | EFR backport equivalent |  |
| 29 | `minecraft:andesite` | `new ItemStack(ModBlocks.STONE.get(), 1, 5)` | EFR backport equivalent |  |
| 30 | `minecraft:calcite` | `new ItemStack(ModBlocks.CALCITE.get())` | EFR backport equivalent |  |
| 31 | `minecraft:tuff` | `new ItemStack(ModBlocks.TUFF.get())` | EFR backport equivalent |  |
| 32 | `minecraft:dripstone_block` | `new ItemStack(ModBlocks.DRIPSTONE_BLOCK.get())` | EFR backport equivalent |  |
| 33 | `minecraft:pointed_dripstone` | `new ItemStack(ModBlocks.POINTED_DRIPSTONE.get())` | EFR backport equivalent |  |
| 34 | `minecraft:prismarine` | `new ItemStack(ModBlocks.PRISMARINE_BLOCK.get(), 1, 0)` | EFR backport equivalent |  |
| 35 | `minecraft:magma_block` | `new ItemStack(ModBlocks.MAGMA.get())` | EFR backport equivalent |  |
| 36 | `minecraft:obsidian` | `new ItemStack(Blocks.obsidian)` | exact legacy equivalent |  |
| 37 | `minecraft:crying_obsidian` | `new ItemStack(ModBlocks.CRYING_OBSIDIAN.get())` | EFR backport equivalent |  |
| 38 | `minecraft:netherrack` | `new ItemStack(Blocks.netherrack)` | exact legacy equivalent |  |
| 39 | `minecraft:crimson_nylium` | `new ItemStack(ModBlocks.NYLIUM.get(), 1, 0)` | EFR backport equivalent |  |
| 40 | `minecraft:warped_nylium` | `new ItemStack(ModBlocks.NYLIUM.get(), 1, 1)` | EFR backport equivalent |  |
| 41 | `minecraft:soul_sand` | `new ItemStack(Blocks.soul_sand)` | exact legacy equivalent |  |
| 42 | `minecraft:soul_soil` | `new ItemStack(ModBlocks.SOUL_SOIL.get())` | EFR backport equivalent |  |
| 43 | `minecraft:bone_block` | `new ItemStack(ModBlocks.BONE.get())` | EFR backport equivalent |  |
| 44 | `minecraft:blackstone` | `new ItemStack(ModBlocks.BLACKSTONE.get(), 1, 0)` | EFR backport equivalent |  |
| 45 | `minecraft:basalt` | `new ItemStack(ModBlocks.BASALT.get())` | EFR backport equivalent |  |
| 46 | `minecraft:smooth_basalt` | `new ItemStack(ModBlocks.SMOOTH_BASALT.get())` | EFR backport equivalent |  |
| 47 | `minecraft:end_stone` | `new ItemStack(Blocks.end_stone)` | exact legacy equivalent |  |
| 48 | `minecraft:coal_ore` | `new ItemStack(Blocks.coal_ore)` | exact legacy equivalent |  |
| 49 | `minecraft:deepslate_coal_ore` | `new ItemStack(ModBlocks.DEEPSLATE_COAL_ORE.get())` | EFR backport equivalent |  |
| 50 | `minecraft:iron_ore` | `new ItemStack(Blocks.iron_ore)` | exact legacy equivalent |  |
| 51 | `minecraft:deepslate_iron_ore` | `new ItemStack(ModBlocks.DEEPSLATE_IRON_ORE.get())` | EFR backport equivalent |  |
| 52 | `minecraft:copper_ore` | `new ItemStack(ModBlocks.COPPER_ORE.get())` | EFR backport equivalent |  |
| 53 | `minecraft:deepslate_copper_ore` | `new ItemStack(ModBlocks.DEEPSLATE_COPPER_ORE.get())` | EFR backport equivalent |  |
| 54 | `minecraft:gold_ore` | `new ItemStack(Blocks.gold_ore)` | exact legacy equivalent |  |
| 55 | `minecraft:deepslate_gold_ore` | `new ItemStack(ModBlocks.DEEPSLATE_GOLD_ORE.get())` | EFR backport equivalent |  |
| 56 | `minecraft:redstone_ore` | `new ItemStack(Blocks.redstone_ore)` | exact legacy equivalent |  |
| 57 | `minecraft:deepslate_redstone_ore` | `new ItemStack(ModBlocks.DEEPSLATE_REDSTONE_ORE.get())` | EFR backport equivalent |  |
| 58 | `minecraft:emerald_ore` | `new ItemStack(Blocks.emerald_ore)` | exact legacy equivalent |  |
| 59 | `minecraft:deepslate_emerald_ore` | `new ItemStack(ModBlocks.DEEPSLATE_EMERALD_ORE.get())` | EFR backport equivalent |  |
| 60 | `minecraft:lapis_ore` | `new ItemStack(Blocks.lapis_ore)` | exact legacy equivalent |  |
| 61 | `minecraft:deepslate_lapis_ore` | `new ItemStack(ModBlocks.DEEPSLATE_LAPIS_ORE.get())` | EFR backport equivalent |  |
| 62 | `minecraft:diamond_ore` | `new ItemStack(Blocks.diamond_ore)` | exact legacy equivalent |  |
| 63 | `minecraft:deepslate_diamond_ore` | `new ItemStack(ModBlocks.DEEPSLATE_DIAMOND_ORE.get())` | EFR backport equivalent |  |
| 64 | `minecraft:nether_gold_ore` | `new ItemStack(ModBlocks.NETHER_GOLD_ORE.get())` | EFR backport equivalent |  |
| 65 | `minecraft:nether_quartz_ore` | `new ItemStack(Blocks.quartz_ore)` | exact legacy equivalent |  |
| 66 | `minecraft:ancient_debris` | `new ItemStack(ModBlocks.ANCIENT_DEBRIS.get())` | EFR backport equivalent |  |
| 67 | `minecraft:raw_iron_block` | `new ItemStack(ModBlocks.RAW_ORE_BLOCK.get(), 1, 1)` | EFR backport equivalent |  |
| 68 | `minecraft:raw_copper_block` | `new ItemStack(ModBlocks.RAW_ORE_BLOCK.get(), 1, 0)` | EFR backport equivalent |  |
| 69 | `minecraft:raw_gold_block` | `new ItemStack(ModBlocks.RAW_ORE_BLOCK.get(), 1, 2)` | EFR backport equivalent |  |
| 70 | `minecraft:glowstone` | `new ItemStack(Blocks.glowstone)` | exact legacy equivalent |  |
| 71 | `minecraft:amethyst_block` | `new ItemStack(ModBlocks.AMETHYST_BLOCK.get())` | EFR backport equivalent |  |
| 72 | `minecraft:budding_amethyst` | `new ItemStack(ModBlocks.BUDDING_AMETHYST.get())` | EFR backport equivalent |  |
| 73 | `minecraft:small_amethyst_bud` | `new ItemStack(ModBlocks.AMETHYST_CLUSTER_1.get(), 1, 0)` | EFR backport equivalent |  |
| 74 | `minecraft:medium_amethyst_bud` | `new ItemStack(ModBlocks.AMETHYST_CLUSTER_1.get(), 1, 1)` | EFR backport equivalent |  |
| 75 | `minecraft:large_amethyst_bud` | `new ItemStack(ModBlocks.AMETHYST_CLUSTER_2.get(), 1, 0)` | EFR backport equivalent |  |
| 76 | `minecraft:amethyst_cluster` | `new ItemStack(ModBlocks.AMETHYST_CLUSTER_2.get(), 1, 1)` | EFR backport equivalent |  |
| 77 | `minecraft:oak_log` | `new ItemStack(Blocks.log, 1, 0)` | exact legacy equivalent |  |
| 78 | `minecraft:spruce_log` | `new ItemStack(Blocks.log, 1, 1)` | exact legacy equivalent |  |
| 79 | `minecraft:birch_log` | `new ItemStack(Blocks.log, 1, 2)` | exact legacy equivalent |  |
| 80 | `minecraft:jungle_log` | `new ItemStack(Blocks.log, 1, 3)` | exact legacy equivalent |  |
| 81 | `minecraft:acacia_log` | `new ItemStack(Blocks.log2, 1, 0)` | exact legacy equivalent |  |
| 82 | `minecraft:dark_oak_log` | `new ItemStack(Blocks.log2, 1, 1)` | exact legacy equivalent |  |
| 83 | `minecraft:mangrove_log` | `new ItemStack(ModBlocks.MANGROVE_LOG.get())` | EFR backport equivalent |  |
| 84 | `minecraft:mangrove_roots` | `new ItemStack(ModBlocks.MANGROVE_ROOTS.get())` | EFR backport equivalent |  |
| 85 | `minecraft:muddy_mangrove_roots` | `new ItemStack(ModBlocks.MUDDY_MANGROVE_ROOTS.get())` | EFR backport equivalent |  |
| 86 | `minecraft:cherry_log` | `new ItemStack(ModBlocks.CHERRY_LOG.get())` | EFR backport equivalent |  |
| 87 | `minecraft:pale_oak_log` | `Omitted` | missing | Not backported |
| 88 | `minecraft:mushroom_stem` | `Omitted` | missing | Not backported |
| 89 | `minecraft:crimson_stem` | `new ItemStack(ModBlocks.CRIMSON_STEM.get())` | EFR backport equivalent |  |
| 90 | `minecraft:warped_stem` | `new ItemStack(ModBlocks.WARPED_STEM.get())` | EFR backport equivalent |  |
| 91 | `minecraft:oak_leaves` | `new ItemStack(Blocks.leaves, 1, 0)` | exact legacy equivalent |  |
| 92 | `minecraft:spruce_leaves` | `new ItemStack(Blocks.leaves, 1, 1)` | exact legacy equivalent |  |
| 93 | `minecraft:birch_leaves` | `new ItemStack(Blocks.leaves, 1, 2)` | exact legacy equivalent |  |
| 94 | `minecraft:jungle_leaves` | `new ItemStack(Blocks.leaves, 1, 3)` | exact legacy equivalent |  |
| 95 | `minecraft:acacia_leaves` | `new ItemStack(Blocks.leaves2, 1, 0)` | exact legacy equivalent |  |
| 96 | `minecraft:dark_oak_leaves` | `new ItemStack(Blocks.leaves2, 1, 1)` | exact legacy equivalent |  |
| 97 | `minecraft:mangrove_leaves` | `new ItemStack(ModBlocks.LEAVES.get(), 1, 2)` | EFR backport equivalent |  |
| 98 | `minecraft:cherry_leaves` | `new ItemStack(ModBlocks.LEAVES.get(), 1, 3)` | EFR backport equivalent |  |
| 99 | `minecraft:pale_oak_leaves` | `Omitted` | missing | Not backported |
| 100 | `minecraft:azalea_leaves` | `new ItemStack(ModBlocks.AZALEA_LEAVES.get(), 1, 0)` | EFR backport equivalent |  |
| 101 | `minecraft:flowering_azalea_leaves` | `new ItemStack(ModBlocks.AZALEA_LEAVES.get(), 1, 1)` | EFR backport equivalent |  |
| 102 | `minecraft:brown_mushroom_block` | `new ItemStack(ModBlocks.BROWN_MUSHROOM.get())` | EFR backport equivalent | Silked block |
| 103 | `minecraft:red_mushroom_block` | `new ItemStack(ModBlocks.RED_MUSHROOM.get())` | EFR backport equivalent | Silked block |
| 104 | `minecraft:nether_wart_block` | `Omitted` | missing | Not backported |
| 105 | `minecraft:warped_wart_block` | `Omitted` | missing | Not backported |
| 106 | `minecraft:shroomlight` | `new ItemStack(ModBlocks.SHROOMLIGHT.get())` | EFR backport equivalent |  |
| 107 | `minecraft:oak_sapling` | `new ItemStack(Blocks.sapling, 1, 0)` | exact legacy equivalent |  |
| 108 | `minecraft:spruce_sapling` | `new ItemStack(Blocks.sapling, 1, 1)` | exact legacy equivalent |  |
| 109 | `minecraft:birch_sapling` | `new ItemStack(Blocks.sapling, 1, 2)` | exact legacy equivalent |  |
| 110 | `minecraft:jungle_sapling` | `new ItemStack(Blocks.sapling, 1, 3)` | exact legacy equivalent |  |
| 111 | `minecraft:acacia_sapling` | `new ItemStack(Blocks.sapling, 1, 4)` | exact legacy equivalent |  |
| 112 | `minecraft:dark_oak_sapling` | `new ItemStack(Blocks.sapling, 1, 5)` | exact legacy equivalent |  |
| 113 | `minecraft:mangrove_propagule` | `new ItemStack(ModBlocks.SAPLING.get(), 1, 2)` | EFR backport equivalent |  |
| 114 | `minecraft:cherry_sapling` | `new ItemStack(ModBlocks.SAPLING.get(), 1, 3)` | EFR backport equivalent |  |
| 115 | `minecraft:pale_oak_sapling` | `Omitted` | missing | Not backported |
| 116 | `minecraft:azalea` | `new ItemStack(ModBlocks.AZALEA.get(), 1, 0)` | EFR backport equivalent |  |
| 117 | `minecraft:flowering_azalea` | `new ItemStack(ModBlocks.AZALEA.get(), 1, 1)` | EFR backport equivalent |  |
| 118 | `minecraft:brown_mushroom` | `new ItemStack(Blocks.brown_mushroom)` | exact legacy equivalent |  |
| 119 | `minecraft:red_mushroom` | `new ItemStack(Blocks.red_mushroom)` | exact legacy equivalent |  |
| 120 | `minecraft:crimson_fungus` | `new ItemStack(ModBlocks.NETHER_FUNGUS.get(), 1, 0)` | EFR backport equivalent |  |
| 121 | `minecraft:warped_fungus` | `new ItemStack(ModBlocks.NETHER_FUNGUS.get(), 1, 1)` | EFR backport equivalent |  |
| 122 | `minecraft:short_grass` | `new ItemStack(Blocks.tallgrass, 1, 1)` | exact legacy equivalent |  |
| 123 | `minecraft:fern` | `new ItemStack(Blocks.tallgrass, 1, 2)` | exact legacy equivalent |  |
| 124 | `minecraft:dead_bush` | `new ItemStack(Blocks.deadbush)` | exact legacy equivalent |  |
| 125 | `minecraft:dandelion` | `new ItemStack(Blocks.yellow_flower)` | exact legacy equivalent |  |
| 126 | `minecraft:poppy` | `new ItemStack(Blocks.red_flower, 1, 0)` | exact legacy equivalent |  |
| 127 | `minecraft:blue_orchid` | `new ItemStack(Blocks.red_flower, 1, 1)` | exact legacy equivalent |  |
| 128 | `minecraft:allium` | `new ItemStack(Blocks.red_flower, 1, 2)` | exact legacy equivalent |  |
| 129 | `minecraft:azure_bluet` | `new ItemStack(Blocks.red_flower, 1, 3)` | exact legacy equivalent |  |
| 130 | `minecraft:red_tulip` | `new ItemStack(Blocks.red_flower, 1, 4)` | exact legacy equivalent |  |
| 131 | `minecraft:orange_tulip` | `new ItemStack(Blocks.red_flower, 1, 5)` | exact legacy equivalent |  |
| 132 | `minecraft:white_tulip` | `new ItemStack(Blocks.red_flower, 1, 6)` | exact legacy equivalent |  |
| 133 | `minecraft:pink_tulip` | `new ItemStack(Blocks.red_flower, 1, 7)` | exact legacy equivalent |  |
| 134 | `minecraft:oxeye_daisy` | `new ItemStack(Blocks.red_flower, 1, 8)` | exact legacy equivalent |  |
| 135 | `minecraft:cornflower` | `new ItemStack(ModBlocks.CORNFLOWER.get())` | EFR backport equivalent |  |
| 136 | `minecraft:lily_of_the_valley` | `new ItemStack(ModBlocks.LILY_OF_THE_VALLEY.get())` | EFR backport equivalent |  |
| 137 | `minecraft:torchflower` | `Omitted` | missing | Not backported |
| 138 | `minecraft:closed_eyeblossom` | `Omitted` | missing | Not backported |
| 139 | `minecraft:open_eyeblossom` | `Omitted` | missing | Not backported |
| 140 | `minecraft:wither_rose` | `new ItemStack(ModBlocks.WITHER_ROSE.get())` | EFR backport equivalent |  |
| 141 | `minecraft:pink_petals` | `new ItemStack(ModBlocks.PINK_PETALS.get())` | EFR backport equivalent |  |
| 142 | `minecraft:spore_blossom` | `Omitted` | missing | Not backported |
| 143 | `minecraft:bamboo` | `new ItemStack(ModItems.BAMBOO.get())` | EFR backport equivalent |  |
| 144 | `minecraft:sugar_cane` | `new ItemStack(Items.reeds)` | exact legacy equivalent |  |
| 145 | `minecraft:cactus` | `new ItemStack(Blocks.cactus)` | exact legacy equivalent |  |
| 146 | `minecraft:crimson_roots` | `new ItemStack(ModBlocks.NETHER_ROOTS.get(), 1, 0)` | EFR backport equivalent |  |
| 147 | `minecraft:warped_roots` | `new ItemStack(ModBlocks.NETHER_ROOTS.get(), 1, 1)` | EFR backport equivalent |  |
| 148 | `minecraft:nether_sprouts` | `new ItemStack(ModBlocks.NETHER_SPROUTS.get())` | EFR backport equivalent |  |
| 149 | `minecraft:weeping_vines` | `new ItemStack(ModBlocks.WEEPING_VINES.get())` | EFR backport equivalent |  |
| 150 | `minecraft:twisting_vines` | `new ItemStack(ModBlocks.TWISTING_VINES.get())` | EFR backport equivalent |  |
| 151 | `minecraft:vine` | `new ItemStack(Blocks.vine)` | exact legacy equivalent |  |
| 152 | `minecraft:tall_grass` | `new ItemStack(Blocks.double_plant, 1, 2)` | exact legacy equivalent |  |
| 153 | `minecraft:large_fern` | `new ItemStack(Blocks.double_plant, 1, 3)` | exact legacy equivalent |  |
| 154 | `minecraft:sunflower` | `new ItemStack(Blocks.double_plant, 1, 0)` | exact legacy equivalent |  |
| 155 | `minecraft:lilac` | `new ItemStack(Blocks.double_plant, 1, 1)` | exact legacy equivalent |  |
| 156 | `minecraft:rose_bush` | `new ItemStack(Blocks.double_plant, 1, 4)` | exact legacy equivalent |  |
| 157 | `minecraft:peony` | `new ItemStack(Blocks.double_plant, 1, 5)` | exact legacy equivalent |  |
| 158 | `minecraft:pitcher_plant` | `Omitted` | missing | Not backported |
| 159 | `minecraft:big_dripleaf` | `Omitted` | missing | Not backported |
| 160 | `minecraft:small_dripleaf` | `Omitted` | missing | Not backported |
| 161 | `minecraft:chorus_plant` | `new ItemStack(ModBlocks.CHORUS_PLANT.get())` | EFR backport equivalent | Automatically resolved |
| 162 | `minecraft:chorus_flower` | `new ItemStack(ModBlocks.CHORUS_FLOWER.get())` | EFR backport equivalent | Automatically resolved |
| 163 | `minecraft:glow_lichen` | `Omitted` | missing | Not backported |
| 164 | `minecraft:hanging_roots` | `Omitted` | missing | Not backported |
| 165 | `minecraft:frogspawn` | `Omitted` | missing | Not backported |
| 166 | `minecraft:turtle_egg` | `Omitted` | missing | Not backported |
| 167 | `minecraft:sniffer_egg` | `Omitted` | missing | Not backported |
| 168 | `minecraft:wheat_seeds` | `new ItemStack(Items.wheat_seeds)` | exact legacy equivalent |  |
| 169 | `minecraft:cocoa_beans` | `new ItemStack(Items.dye, 1, 3)` | exact legacy equivalent |  |
| 170 | `minecraft:pumpkin_seeds` | `new ItemStack(Items.pumpkin_seeds)` | exact legacy equivalent |  |
| 171 | `minecraft:melon_seeds` | `new ItemStack(Items.melon_seeds)` | exact legacy equivalent |  |
| 172 | `minecraft:beetroot_seeds` | `new ItemStack(ModItems.BEETROOT_SEEDS.get())` | EFR backport equivalent |  |
| 173 | `minecraft:torchflower_seeds` | `Omitted` | missing | Not backported |
| 174 | `minecraft:pitcher_pod` | `Omitted` | missing | Not backported |
| 175 | `minecraft:glow_berries` | `Omitted` | missing | Not backported |
| 176 | `minecraft:sweet_berries` | `new ItemStack(ModItems.SWEET_BERRIES.get())` | EFR backport equivalent |  |
| 177 | `minecraft:nether_wart` | `new ItemStack(ModBlocks.NETHER_WART.get())` | EFR backport equivalent | Automatically resolved |
| 178 | `minecraft:lily_pad` | `Omitted` | missing | Not backported |
| 179 | `minecraft:seagrass` | `Omitted` | missing | Not backported |
| 180 | `minecraft:sea_pickle` | `Omitted` | missing | Not backported |
| 181 | `minecraft:kelp` | `Omitted` | missing | Not backported |
| 182 | `minecraft:dried_kelp_block` | `Omitted` | missing | Not backported |
| 183 | `minecraft:tube_coral_block` | `Omitted` | missing | Not backported |
| 184 | `minecraft:brain_coral_block` | `Omitted` | missing | Not backported |
| 185 | `minecraft:bubble_coral_block` | `Omitted` | missing | Not backported |
| 186 | `minecraft:fire_coral_block` | `Omitted` | missing | Not backported |
| 187 | `minecraft:horn_coral_block` | `Omitted` | missing | Not backported |
| 188 | `minecraft:dead_tube_coral_block` | `Omitted` | missing | Not backported |
| 189 | `minecraft:dead_brain_coral_block` | `Omitted` | missing | Not backported |
| 190 | `minecraft:dead_bubble_coral_block` | `Omitted` | missing | Not backported |
| 191 | `minecraft:dead_fire_coral_block` | `Omitted` | missing | Not backported |
| 192 | `minecraft:dead_horn_coral_block` | `Omitted` | missing | Not backported |
| 193 | `minecraft:tube_coral` | `Omitted` | missing | Not backported |
| 194 | `minecraft:brain_coral` | `Omitted` | missing | Not backported |
| 195 | `minecraft:bubble_coral` | `Omitted` | missing | Not backported |
| 196 | `minecraft:fire_coral` | `Omitted` | missing | Not backported |
| 197 | `minecraft:horn_coral` | `Omitted` | missing | Not backported |
| 198 | `minecraft:dead_tube_coral` | `Omitted` | missing | Not backported |
| 199 | `minecraft:dead_brain_coral` | `Omitted` | missing | Not backported |
| 200 | `minecraft:dead_bubble_coral` | `Omitted` | missing | Not backported |
| 201 | `minecraft:dead_fire_coral` | `Omitted` | missing | Not backported |
| 202 | `minecraft:dead_horn_coral` | `Omitted` | missing | Not backported |
| 203 | `minecraft:tube_coral_fan` | `Omitted` | missing | Not backported |
| 204 | `minecraft:brain_coral_fan` | `Omitted` | missing | Not backported |
| 205 | `minecraft:bubble_coral_fan` | `Omitted` | missing | Not backported |
| 206 | `minecraft:fire_coral_fan` | `Omitted` | missing | Not backported |
| 207 | `minecraft:horn_coral_fan` | `Omitted` | missing | Not backported |
| 208 | `minecraft:dead_tube_coral_fan` | `Omitted` | missing | Not backported |
| 209 | `minecraft:dead_brain_coral_fan` | `Omitted` | missing | Not backported |
| 210 | `minecraft:dead_bubble_coral_fan` | `Omitted` | missing | Not backported |
| 211 | `minecraft:dead_fire_coral_fan` | `Omitted` | missing | Not backported |
| 212 | `minecraft:dead_horn_coral_fan` | `Omitted` | missing | Not backported |
| 213 | `minecraft:sponge` | `new ItemStack(ModBlocks.SPONGE.get())` | EFR backport equivalent | Automatically resolved |
| 214 | `minecraft:wet_sponge` | `Omitted` | missing | Not backported |
| 215 | `minecraft:melon` | `new ItemStack(Blocks.melon_block)` | exact legacy equivalent |  |
| 216 | `minecraft:pumpkin` | `new ItemStack(Blocks.pumpkin)` | exact legacy equivalent |  |
| 217 | `minecraft:carved_pumpkin` | `Omitted` | missing | Not backported |
| 218 | `minecraft:jack_o_lantern` | `Omitted` | missing | Not backported |
| 219 | `minecraft:hay_block` | `Omitted` | missing | Not backported |
| 220 | `minecraft:bee_nest` | `new ItemStack(ModBlocks.BEE_NEST.get())` | EFR backport equivalent |  |
| 221 | `minecraft:honeycomb_block` | `new ItemStack(ModBlocks.HONEYCOMB_BLOCK.get())` | EFR backport equivalent |  |
| 222 | `minecraft:slime_block` | `Omitted` | missing | Not backported |
| 223 | `minecraft:honey_block` | `new ItemStack(ModBlocks.HONEY_BLOCK.get())` | EFR backport equivalent |  |
| 224 | `minecraft:resin_block` | `Omitted` | missing | Not backported |
| 225 | `minecraft:ochre_froglight` | `Omitted` | missing | Not backported |
| 226 | `minecraft:verdant_froglight` | `Omitted` | missing | Not backported |
| 227 | `minecraft:pearlescent_froglight` | `Omitted` | missing | Not backported |
| 228 | `minecraft:sculk` | `new ItemStack(ModBlocks.SCULK.get())` | EFR backport equivalent | Automatically resolved |
| 229 | `minecraft:sculk_vein` | `Omitted` | missing | Not backported |
| 230 | `minecraft:sculk_catalyst` | `new ItemStack(ModBlocks.SCULK_CATALYST.get())` | EFR backport equivalent | Automatically resolved |
| 231 | `minecraft:sculk_shrieker` | `Omitted` | missing | Not backported |
| 232 | `minecraft:sculk_sensor` | `Omitted` | missing | Not backported |
| 233 | `minecraft:cobweb` | `new ItemStack(Blocks.web)` | exact legacy equivalent |  |
| 234 | `minecraft:bedrock` | `Omitted` | missing | Not backported |

## Tab: Functional Blocks (`itemGroup.functional`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:torch` | `new ItemStack(Blocks.torch)` | exact legacy equivalent |  |
| 1 | `minecraft:soul_torch` | `new ItemStack(ModBlocks.SOUL_TORCH.get())` | EFR backport equivalent |  |
| 2 | `minecraft:redstone_torch` | `new ItemStack(Blocks.redstone_torch)` | exact legacy equivalent |  |
| 3 | `minecraft:lantern` | `new ItemStack(ModBlocks.LANTERN.get())` | EFR backport equivalent |  |
| 4 | `minecraft:soul_lantern` | `new ItemStack(ModBlocks.SOUL_LANTERN.get())` | EFR backport equivalent |  |
| 5 | `minecraft:chain` | `new ItemStack(ModBlocks.CHAIN.get())` | EFR backport equivalent |  |
| 6 | `minecraft:end_rod` | `new ItemStack(ModBlocks.END_ROD.get())` | EFR backport equivalent | Automatically resolved |
| 7 | `minecraft:sea_lantern` | `new ItemStack(ModBlocks.SEA_LANTERN.get())` | EFR backport equivalent |  |
| 8 | `minecraft:redstone_lamp` | `new ItemStack(Blocks.redstone_lamp)` | exact legacy equivalent |  |
| 9 | `minecraft:copper_bulb` | `new ItemStack(ModBlocks.COPPER_BULB.get())` | EFR backport equivalent | Automatically resolved |
| 10 | `minecraft:exposed_copper_bulb` | `Omitted` | missing | Not backported |
| 11 | `minecraft:weathered_copper_bulb` | `Omitted` | missing | Not backported |
| 12 | `minecraft:oxidized_copper_bulb` | `Omitted` | missing | Not backported |
| 13 | `minecraft:waxed_copper_bulb` | `Omitted` | missing | Not backported |
| 14 | `minecraft:waxed_exposed_copper_bulb` | `Omitted` | missing | Not backported |
| 15 | `minecraft:waxed_weathered_copper_bulb` | `Omitted` | missing | Not backported |
| 16 | `minecraft:waxed_oxidized_copper_bulb` | `Omitted` | missing | Not backported |
| 17 | `minecraft:glowstone` | `new ItemStack(Blocks.glowstone)` | exact legacy equivalent |  |
| 18 | `minecraft:shroomlight` | `new ItemStack(ModBlocks.SHROOMLIGHT.get())` | EFR backport equivalent |  |
| 19 | `minecraft:ochre_froglight` | `Omitted` | missing | Not backported |
| 20 | `minecraft:verdant_froglight` | `Omitted` | missing | Not backported |
| 21 | `minecraft:pearlescent_froglight` | `Omitted` | missing | Not backported |
| 22 | `minecraft:crying_obsidian` | `new ItemStack(ModBlocks.CRYING_OBSIDIAN.get())` | EFR backport equivalent |  |
| 23 | `minecraft:glow_lichen` | `Omitted` | missing | Not backported |
| 24 | `minecraft:magma_block` | `new ItemStack(ModBlocks.MAGMA.get())` | EFR backport equivalent |  |
| 25 | `minecraft:crafting_table` | `new ItemStack(Blocks.crafting_table)` | exact legacy equivalent |  |
| 26 | `minecraft:stonecutter` | `new ItemStack(ModBlocks.STONECUTTER.get())` | EFR backport equivalent |  |
| 27 | `minecraft:cartography_table` | `new ItemStack(ModBlocks.CARTOGRAPHY_TABLE.get())` | EFR backport equivalent |  |
| 28 | `minecraft:fletching_table` | `new ItemStack(ModBlocks.FLETCHING_TABLE.get())` | EFR backport equivalent |  |
| 29 | `minecraft:smithing_table` | `new ItemStack(ModBlocks.SMITHING_TABLE.get())` | EFR backport equivalent |  |
| 30 | `minecraft:grindstone` | `Omitted` | missing | Not backported |
| 31 | `minecraft:loom` | `new ItemStack(ModBlocks.LOOM.get())` | EFR backport equivalent |  |
| 32 | `minecraft:furnace` | `new ItemStack(Blocks.furnace)` | exact legacy equivalent |  |
| 33 | `minecraft:smoker` | `new ItemStack(ModBlocks.SMOKER.get())` | EFR backport equivalent |  |
| 34 | `minecraft:blast_furnace` | `new ItemStack(ModBlocks.BLAST_FURNACE.get())` | EFR backport equivalent |  |
| 35 | `minecraft:campfire` | `Omitted` | missing | Not backported |
| 36 | `minecraft:soul_campfire` | `Omitted` | missing | Not backported |
| 37 | `minecraft:anvil` | `new ItemStack(ModBlocks.ANVIL.get(), 1, 0)` | EFR backport equivalent | Anvil backport matches modern naming |
| 38 | `minecraft:chipped_anvil` | `new ItemStack(ModBlocks.ANVIL.get(), 1, 1)` | EFR backport equivalent |  |
| 39 | `minecraft:damaged_anvil` | `new ItemStack(ModBlocks.ANVIL.get(), 1, 2)` | EFR backport equivalent |  |
| 40 | `minecraft:composter` | `new ItemStack(ModBlocks.COMPOSTER.get())` | EFR backport equivalent |  |
| 41 | `minecraft:note_block` | `new ItemStack(Blocks.noteblock)` | exact legacy equivalent |  |
| 42 | `minecraft:jukebox` | `new ItemStack(Blocks.jukebox)` | exact legacy equivalent |  |
| 43 | `minecraft:enchanting_table` | `new ItemStack(ModBlocks.ENCHANTMENT_TABLE.get())` | EFR backport equivalent |  |
| 44 | `minecraft:end_crystal` | `new ItemStack(ModItems.END_CRYSTAL.get())` | EFR backport equivalent | Automatically resolved |
| 45 | `minecraft:brewing_stand` | `new ItemStack(ModBlocks.BREWING_STAND.get())` | EFR backport equivalent |  |
| 46 | `minecraft:cauldron` | `Omitted` | missing | Not backported |
| 47 | `minecraft:bell` | `Omitted` | missing | Not backported |
| 48 | `minecraft:beacon` | `new ItemStack(ModBlocks.BEACON.get())` | EFR backport equivalent |  |
| 49 | `minecraft:conduit` | `Omitted` | missing | Not backported |
| 50 | `minecraft:lodestone` | `Omitted` | missing | Not backported |
| 51 | `minecraft:ladder` | `new ItemStack(Blocks.ladder)` | exact legacy equivalent |  |
| 52 | `minecraft:scaffolding` | `Omitted` | missing | Not backported |
| 53 | `minecraft:bee_nest` | `new ItemStack(ModBlocks.BEE_NEST.get())` | EFR backport equivalent |  |
| 54 | `minecraft:beehive` | `new ItemStack(ModBlocks.BEEHIVE.get())` | EFR backport equivalent |  |
| 55 | `minecraft:suspicious_sand` | `Omitted` | missing | Not backported |
| 56 | `minecraft:suspicious_gravel` | `Omitted` | missing | Not backported |
| 57 | `minecraft:lightning_rod` | `new ItemStack(ModBlocks.LIGHTNING_ROD.get())` | EFR backport equivalent | Automatically resolved |
| 58 | `minecraft:flower_pot` | `Omitted` | missing | Not backported |
| 59 | `minecraft:decorated_pot` | `Omitted` | missing | Not backported |
| 60 | `minecraft:armor_stand` | `new ItemStack(ModItems.WOODEN_ARMORSTAND.get())` | EFR backport equivalent | Automatically resolved |
| 61 | `minecraft:item_frame` | `Omitted` | missing | Not backported |
| 62 | `minecraft:glow_item_frame` | `Omitted` | missing | Not backported |
| 63 | `minecraft:painting` | `Omitted` | missing | Not backported |
| 64 | `minecraft:bookshelf` | `new ItemStack(Blocks.bookshelf)` | exact legacy equivalent |  |
| 65 | `minecraft:chiseled_bookshelf` | `Omitted` | missing | Not backported |
| 66 | `minecraft:lectern` | `Omitted` | missing | Not backported |
| 67 | `minecraft:tinted_glass` | `new ItemStack(ModBlocks.TINTED_GLASS.get())` | EFR backport equivalent |  |
| 68 | `minecraft:oak_sign` | `new ItemStack(Items.sign)` | EFR backport equivalent | Automatically resolved |
| 69 | `minecraft:oak_hanging_sign` | `Omitted` | missing | Not backported |
| 70 | `minecraft:spruce_sign` | `new ItemStack(ModItems.ITEM_SIGN_SPRUCE.get())` | EFR backport equivalent | Automatically resolved |
| 71 | `minecraft:spruce_hanging_sign` | `Omitted` | missing | Not backported |
| 72 | `minecraft:birch_sign` | `new ItemStack(ModItems.ITEM_SIGN_BIRCH.get())` | EFR backport equivalent | Automatically resolved |
| 73 | `minecraft:birch_hanging_sign` | `Omitted` | missing | Not backported |
| 74 | `minecraft:jungle_sign` | `new ItemStack(ModItems.ITEM_SIGN_JUNGLE.get())` | EFR backport equivalent | Automatically resolved |
| 75 | `minecraft:jungle_hanging_sign` | `Omitted` | missing | Not backported |
| 76 | `minecraft:acacia_sign` | `new ItemStack(ModItems.ITEM_SIGN_ACACIA.get())` | EFR backport equivalent | Automatically resolved |
| 77 | `minecraft:acacia_hanging_sign` | `Omitted` | missing | Not backported |
| 78 | `minecraft:dark_oak_sign` | `new ItemStack(ModItems.ITEM_SIGN_DARK_OAK.get())` | EFR backport equivalent | Automatically resolved |
| 79 | `minecraft:dark_oak_hanging_sign` | `Omitted` | missing | Not backported |
| 80 | `minecraft:mangrove_sign` | `new ItemStack(ModBlocks.MANGROVE_SIGN.get())` | EFR backport equivalent | Automatically resolved |
| 81 | `minecraft:mangrove_hanging_sign` | `Omitted` | missing | Not backported |
| 82 | `minecraft:cherry_sign` | `new ItemStack(ModBlocks.CHERRY_SIGN.get())` | EFR backport equivalent | Automatically resolved |
| 83 | `minecraft:cherry_hanging_sign` | `Omitted` | missing | Not backported |
| 84 | `minecraft:pale_oak_sign` | `Omitted` | missing | Not backported |
| 85 | `minecraft:pale_oak_hanging_sign` | `Omitted` | missing | Not backported |
| 86 | `minecraft:bamboo_sign` | `new ItemStack(ModBlocks.BAMBOO_SIGN.get())` | EFR backport equivalent | Automatically resolved |
| 87 | `minecraft:bamboo_hanging_sign` | `Omitted` | missing | Not backported |
| 88 | `minecraft:crimson_sign` | `new ItemStack(ModBlocks.CRIMSON_SIGN.get())` | EFR backport equivalent | Automatically resolved |
| 89 | `minecraft:crimson_hanging_sign` | `Omitted` | missing | Not backported |
| 90 | `minecraft:warped_sign` | `new ItemStack(ModBlocks.WARPED_SIGN.get())` | EFR backport equivalent | Automatically resolved |
| 91 | `minecraft:warped_hanging_sign` | `Omitted` | missing | Not backported |
| 92 | `minecraft:chest` | `new ItemStack(Blocks.chest)` | exact legacy equivalent |  |
| 93 | `minecraft:barrel` | `new ItemStack(ModBlocks.BARREL.get())` | EFR backport equivalent |  |
| 94 | `minecraft:ender_chest` | `new ItemStack(Blocks.ender_chest)` | exact legacy equivalent |  |
| 95 | `minecraft:shulker_box` | `new ItemStack(ModBlocks.SHULKER_BOX.get())` | EFR backport equivalent | Automatically resolved |
| 96 | `minecraft:white_shulker_box` | `Omitted` | missing | Not backported |
| 97 | `minecraft:light_gray_shulker_box` | `Omitted` | missing | Not backported |
| 98 | `minecraft:gray_shulker_box` | `Omitted` | missing | Not backported |
| 99 | `minecraft:black_shulker_box` | `Omitted` | missing | Not backported |
| 100 | `minecraft:brown_shulker_box` | `Omitted` | missing | Not backported |
| 101 | `minecraft:red_shulker_box` | `Omitted` | missing | Not backported |
| 102 | `minecraft:orange_shulker_box` | `Omitted` | missing | Not backported |
| 103 | `minecraft:yellow_shulker_box` | `Omitted` | missing | Not backported |
| 104 | `minecraft:lime_shulker_box` | `Omitted` | missing | Not backported |
| 105 | `minecraft:green_shulker_box` | `Omitted` | missing | Not backported |
| 106 | `minecraft:cyan_shulker_box` | `Omitted` | missing | Not backported |
| 107 | `minecraft:light_blue_shulker_box` | `Omitted` | missing | Not backported |
| 108 | `minecraft:blue_shulker_box` | `Omitted` | missing | Not backported |
| 109 | `minecraft:purple_shulker_box` | `Omitted` | missing | Not backported |
| 110 | `minecraft:magenta_shulker_box` | `Omitted` | missing | Not backported |
| 111 | `minecraft:pink_shulker_box` | `Omitted` | missing | Not backported |
| 112 | `minecraft:respawn_anchor` | `Omitted` | missing | Not backported |
| 113 | `minecraft:white_bed` | `new ItemStack(ModBlocks.WHITE_BED.get())` | EFR backport equivalent |  |
| 114 | `minecraft:light_gray_bed` | `new ItemStack(ModBlocks.LIGHT_GRAY_BED.get())` | EFR backport equivalent |  |
| 115 | `minecraft:gray_bed` | `new ItemStack(ModBlocks.GRAY_BED.get())` | EFR backport equivalent |  |
| 116 | `minecraft:black_bed` | `new ItemStack(ModBlocks.BLACK_BED.get())` | EFR backport equivalent |  |
| 117 | `minecraft:brown_bed` | `new ItemStack(ModBlocks.BROWN_BED.get())` | EFR backport equivalent |  |
| 118 | `minecraft:red_bed` | `new ItemStack(ModBlocks.RED_BED.get())` | EFR backport equivalent |  |
| 119 | `minecraft:orange_bed` | `new ItemStack(ModBlocks.ORANGE_BED.get())` | EFR backport equivalent |  |
| 120 | `minecraft:yellow_bed` | `new ItemStack(ModBlocks.YELLOW_BED.get())` | EFR backport equivalent |  |
| 121 | `minecraft:lime_bed` | `new ItemStack(ModBlocks.LIME_BED.get())` | EFR backport equivalent |  |
| 122 | `minecraft:green_bed` | `new ItemStack(ModBlocks.GREEN_BED.get())` | EFR backport equivalent |  |
| 123 | `minecraft:cyan_bed` | `new ItemStack(ModBlocks.CYAN_BED.get())` | EFR backport equivalent |  |
| 124 | `minecraft:light_blue_bed` | `new ItemStack(ModBlocks.LIGHT_BLUE_BED.get())` | EFR backport equivalent |  |
| 125 | `minecraft:blue_bed` | `new ItemStack(ModBlocks.BLUE_BED.get())` | EFR backport equivalent |  |
| 126 | `minecraft:purple_bed` | `new ItemStack(ModBlocks.PURPLE_BED.get())` | EFR backport equivalent |  |
| 127 | `minecraft:magenta_bed` | `new ItemStack(ModBlocks.MAGENTA_BED.get())` | EFR backport equivalent |  |
| 128 | `minecraft:pink_bed` | `new ItemStack(ModBlocks.PINK_BED.get())` | EFR backport equivalent |  |
| 129 | `minecraft:candle` | `Omitted` | missing | Not backported |
| 130 | `minecraft:white_candle` | `Omitted` | missing | Not backported |
| 131 | `minecraft:light_gray_candle` | `Omitted` | missing | Not backported |
| 132 | `minecraft:gray_candle` | `Omitted` | missing | Not backported |
| 133 | `minecraft:black_candle` | `Omitted` | missing | Not backported |
| 134 | `minecraft:brown_candle` | `Omitted` | missing | Not backported |
| 135 | `minecraft:red_candle` | `Omitted` | missing | Not backported |
| 136 | `minecraft:orange_candle` | `Omitted` | missing | Not backported |
| 137 | `minecraft:yellow_candle` | `Omitted` | missing | Not backported |
| 138 | `minecraft:lime_candle` | `Omitted` | missing | Not backported |
| 139 | `minecraft:green_candle` | `Omitted` | missing | Not backported |
| 140 | `minecraft:cyan_candle` | `Omitted` | missing | Not backported |
| 141 | `minecraft:light_blue_candle` | `Omitted` | missing | Not backported |
| 142 | `minecraft:blue_candle` | `Omitted` | missing | Not backported |
| 143 | `minecraft:purple_candle` | `Omitted` | missing | Not backported |
| 144 | `minecraft:magenta_candle` | `Omitted` | missing | Not backported |
| 145 | `minecraft:pink_candle` | `Omitted` | missing | Not backported |
| 146 | `minecraft:white_banner` | `Omitted` | missing | Not backported |
| 147 | `minecraft:light_gray_banner` | `Omitted` | missing | Not backported |
| 148 | `minecraft:gray_banner` | `Omitted` | missing | Not backported |
| 149 | `minecraft:black_banner` | `Omitted` | missing | Not backported |
| 150 | `minecraft:brown_banner` | `Omitted` | missing | Not backported |
| 151 | `minecraft:red_banner` | `Omitted` | missing | Not backported |
| 152 | `minecraft:orange_banner` | `Omitted` | missing | Not backported |
| 153 | `minecraft:yellow_banner` | `Omitted` | missing | Not backported |
| 154 | `minecraft:lime_banner` | `Omitted` | missing | Not backported |
| 155 | `minecraft:green_banner` | `Omitted` | missing | Not backported |
| 156 | `minecraft:cyan_banner` | `Omitted` | missing | Not backported |
| 157 | `minecraft:light_blue_banner` | `Omitted` | missing | Not backported |
| 158 | `minecraft:blue_banner` | `Omitted` | missing | Not backported |
| 159 | `minecraft:purple_banner` | `Omitted` | missing | Not backported |
| 160 | `minecraft:magenta_banner` | `Omitted` | missing | Not backported |
| 161 | `minecraft:pink_banner` | `Omitted` | missing | Not backported |
| 162 | `minecraft:skeleton_skull` | `Omitted` | missing | Not backported |
| 163 | `minecraft:wither_skeleton_skull` | `Omitted` | missing | Not backported |
| 164 | `minecraft:player_head` | `Omitted` | missing | Not backported |
| 165 | `minecraft:zombie_head` | `Omitted` | missing | Not backported |
| 166 | `minecraft:creeper_head` | `Omitted` | missing | Not backported |
| 167 | `minecraft:piglin_head` | `Omitted` | missing | Not backported |
| 168 | `minecraft:dragon_head` | `Omitted` | missing | Not backported |
| 169 | `minecraft:dragon_egg` | `Omitted` | missing | Not backported |
| 170 | `minecraft:end_portal_frame` | `Omitted` | missing | Not backported |
| 171 | `minecraft:ender_eye` | `new ItemStack(Items.ender_eye)` | exact legacy equivalent |  |
| 172 | `minecraft:vault` | `Omitted` | missing | Not backported |
| 173 | `minecraft:infested_stone` | `Omitted` | missing | Not backported |
| 174 | `minecraft:infested_cobblestone` | `Omitted` | missing | Not backported |
| 175 | `minecraft:infested_stone_bricks` | `Omitted` | missing | Not backported |
| 176 | `minecraft:infested_mossy_stone_bricks` | `Omitted` | missing | Not backported |
| 177 | `minecraft:infested_cracked_stone_bricks` | `Omitted` | missing | Not backported |
| 178 | `minecraft:infested_chiseled_stone_bricks` | `Omitted` | missing | Not backported |
| 179 | `minecraft:infested_deepslate` | `Omitted` | missing | Not backported |

## Tab: Redstone Blocks (`itemGroup.redstone`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:redstone` | `new ItemStack(Items.redstone)` | exact legacy equivalent |  |
| 1 | `minecraft:redstone_torch` | `new ItemStack(Blocks.redstone_torch)` | exact legacy equivalent |  |
| 2 | `minecraft:redstone_block` | `new ItemStack(Blocks.redstone_block)` | exact legacy equivalent |  |
| 3 | `minecraft:repeater` | `new ItemStack(Items.repeater)` | exact legacy equivalent |  |
| 4 | `minecraft:comparator` | `new ItemStack(Items.comparator)` | exact legacy equivalent |  |
| 5 | `minecraft:target` | `new ItemStack(ModBlocks.TARGET.get())` | EFR backport equivalent |  |
| 6 | `minecraft:waxed_copper_bulb` | `Omitted` | missing | Not backported |
| 7 | `minecraft:waxed_exposed_copper_bulb` | `Omitted` | missing | Not backported |
| 8 | `minecraft:waxed_weathered_copper_bulb` | `Omitted` | missing | Not backported |
| 9 | `minecraft:waxed_oxidized_copper_bulb` | `Omitted` | missing | Not backported |
| 10 | `minecraft:lever` | `new ItemStack(Blocks.lever)` | exact legacy equivalent |  |
| 11 | `minecraft:oak_button` | `new ItemStack(Blocks.wooden_button)` | exact legacy equivalent |  |
| 12 | `minecraft:stone_button` | `Omitted` | missing | Not backported |
| 13 | `minecraft:oak_pressure_plate` | `new ItemStack(Blocks.wooden_pressure_plate)` | exact legacy equivalent |  |
| 14 | `minecraft:stone_pressure_plate` | `Omitted` | missing | Not backported |
| 15 | `minecraft:light_weighted_pressure_plate` | `Omitted` | missing | Not backported |
| 16 | `minecraft:heavy_weighted_pressure_plate` | `Omitted` | missing | Not backported |
| 17 | `minecraft:sculk_sensor` | `Omitted` | missing | Not backported |
| 18 | `minecraft:calibrated_sculk_sensor` | `Omitted` | missing | Not backported |
| 19 | `minecraft:sculk_shrieker` | `Omitted` | missing | Not backported |
| 20 | `minecraft:amethyst_block` | `new ItemStack(ModBlocks.AMETHYST_BLOCK.get())` | EFR backport equivalent |  |
| 21 | `minecraft:white_wool` | `new ItemStack(Blocks.wool, 1, 0)` | exact legacy equivalent |  |
| 22 | `minecraft:tripwire_hook` | `new ItemStack(Blocks.tripwire_hook)` | exact legacy equivalent |  |
| 23 | `minecraft:string` | `new ItemStack(Items.string)` | exact legacy equivalent | Not backported |
| 24 | `minecraft:lectern` | `Omitted` | missing | Not backported |
| 25 | `minecraft:daylight_detector` | `new ItemStack(Blocks.daylight_detector)` | exact legacy equivalent |  |
| 26 | `minecraft:lightning_rod` | `new ItemStack(ModBlocks.LIGHTNING_ROD.get())` | EFR backport equivalent | Automatically resolved |
| 27 | `minecraft:piston` | `new ItemStack(Blocks.piston)` | exact legacy equivalent |  |
| 28 | `minecraft:sticky_piston` | `new ItemStack(Blocks.sticky_piston)` | exact legacy equivalent |  |
| 29 | `minecraft:slime_block` | `Omitted` | missing | Not backported |
| 30 | `minecraft:honey_block` | `new ItemStack(ModBlocks.HONEY_BLOCK.get())` | EFR backport equivalent |  |
| 31 | `minecraft:dispenser` | `new ItemStack(Blocks.dispenser)` | exact legacy equivalent |  |
| 32 | `minecraft:dropper` | `new ItemStack(Blocks.dropper)` | exact legacy equivalent |  |
| 33 | `minecraft:crafter` | `Omitted` | missing | Not backported |
| 34 | `minecraft:hopper` | `new ItemStack(Blocks.hopper)` | exact legacy equivalent |  |
| 35 | `minecraft:chest` | `new ItemStack(Blocks.chest)` | exact legacy equivalent |  |
| 36 | `minecraft:barrel` | `new ItemStack(ModBlocks.BARREL.get())` | EFR backport equivalent |  |
| 37 | `minecraft:chiseled_bookshelf` | `Omitted` | missing | Not backported |
| 38 | `minecraft:furnace` | `new ItemStack(Blocks.furnace)` | exact legacy equivalent |  |
| 39 | `minecraft:trapped_chest` | `new ItemStack(Blocks.trapped_chest)` | exact legacy equivalent |  |
| 40 | `minecraft:jukebox` | `new ItemStack(Blocks.jukebox)` | exact legacy equivalent |  |
| 41 | `minecraft:decorated_pot` | `Omitted` | missing | Not backported |
| 42 | `minecraft:observer` | `new ItemStack(ModBlocks.OBSERVER.get())` | EFR backport equivalent |  |
| 43 | `minecraft:note_block` | `new ItemStack(Blocks.noteblock)` | exact legacy equivalent |  |
| 44 | `minecraft:composter` | `new ItemStack(ModBlocks.COMPOSTER.get())` | EFR backport equivalent |  |
| 45 | `minecraft:cauldron` | `Omitted` | missing | Not backported |
| 46 | `minecraft:rail` | `new ItemStack(Blocks.rail)` | EFR backport equivalent | Automatically resolved |
| 47 | `minecraft:powered_rail` | `new ItemStack(Blocks.golden_rail)` | EFR backport equivalent | Automatically resolved |
| 48 | `minecraft:detector_rail` | `new ItemStack(Blocks.detector_rail)` | EFR backport equivalent | Automatically resolved |
| 49 | `minecraft:activator_rail` | `new ItemStack(Blocks.activator_rail)` | EFR backport equivalent | Automatically resolved |
| 50 | `minecraft:minecart` | `new ItemStack(Items.minecart)` | EFR backport equivalent | Automatically resolved |
| 51 | `minecraft:hopper_minecart` | `new ItemStack(Items.hopper_minecart)` | EFR backport equivalent | Automatically resolved |
| 52 | `minecraft:chest_minecart` | `new ItemStack(Items.chest_minecart)` | EFR backport equivalent | Automatically resolved |
| 53 | `minecraft:furnace_minecart` | `new ItemStack(Items.furnace_minecart)` | EFR backport equivalent | Automatically resolved |
| 54 | `minecraft:tnt_minecart` | `new ItemStack(Items.tnt_minecart)` | EFR backport equivalent | Automatically resolved |
| 55 | `minecraft:oak_chest_boat` | `new ItemStack(ModItems.OAK_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 56 | `minecraft:bamboo_chest_raft` | `new ItemStack(ModItems.BAMBOO_CHEST_RAFT.get())` | EFR backport equivalent | Automatically resolved |
| 57 | `minecraft:oak_door` | `new ItemStack(Items.wooden_door)` | exact legacy equivalent |  |
| 58 | `minecraft:iron_door` | `new ItemStack(Items.iron_door)` | EFR backport equivalent | Automatically resolved |
| 59 | `minecraft:oak_fence_gate` | `new ItemStack(Blocks.fence_gate)` | exact legacy equivalent |  |
| 60 | `minecraft:oak_trapdoor` | `new ItemStack(Blocks.trapdoor)` | exact legacy equivalent |  |
| 61 | `minecraft:iron_trapdoor` | `new ItemStack(ModBlocks.IRON_TRAPDOOR.get())` | EFR backport equivalent | Automatically resolved |
| 62 | `minecraft:tnt` | `new ItemStack(Blocks.tnt)` | exact legacy equivalent |  |
| 63 | `minecraft:redstone_lamp` | `new ItemStack(Blocks.redstone_lamp)` | exact legacy equivalent |  |
| 64 | `minecraft:bell` | `Omitted` | missing | Not backported |
| 65 | `minecraft:big_dripleaf` | `Omitted` | missing | Not backported |
| 66 | `minecraft:armor_stand` | `new ItemStack(ModItems.WOODEN_ARMORSTAND.get())` | EFR backport equivalent | Automatically resolved |
| 67 | `minecraft:redstone_ore` | `new ItemStack(Blocks.redstone_ore)` | exact legacy equivalent |  |

## Tab: Tools & Utilities (`itemGroup.tools`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:wooden_shovel` | `new ItemStack(Items.wooden_shovel)` | exact legacy equivalent |  |
| 1 | `minecraft:wooden_pickaxe` | `new ItemStack(Items.wooden_pickaxe)` | exact legacy equivalent |  |
| 2 | `minecraft:wooden_axe` | `new ItemStack(Items.wooden_axe)` | exact legacy equivalent |  |
| 3 | `minecraft:wooden_hoe` | `new ItemStack(Items.wooden_hoe)` | exact legacy equivalent |  |
| 4 | `minecraft:stone_shovel` | `new ItemStack(Items.stone_shovel)` | exact legacy equivalent |  |
| 5 | `minecraft:stone_pickaxe` | `new ItemStack(Items.stone_pickaxe)` | exact legacy equivalent |  |
| 6 | `minecraft:stone_axe` | `new ItemStack(Items.stone_axe)` | exact legacy equivalent |  |
| 7 | `minecraft:stone_hoe` | `new ItemStack(Items.stone_hoe)` | exact legacy equivalent |  |
| 8 | `minecraft:iron_shovel` | `new ItemStack(Items.iron_shovel)` | exact legacy equivalent |  |
| 9 | `minecraft:iron_pickaxe` | `new ItemStack(Items.iron_pickaxe)` | exact legacy equivalent |  |
| 10 | `minecraft:iron_axe` | `new ItemStack(Items.iron_axe)` | exact legacy equivalent |  |
| 11 | `minecraft:iron_hoe` | `new ItemStack(Items.iron_hoe)` | exact legacy equivalent |  |
| 12 | `minecraft:golden_shovel` | `new ItemStack(Items.golden_shovel)` | exact legacy equivalent |  |
| 13 | `minecraft:golden_pickaxe` | `new ItemStack(Items.golden_pickaxe)` | exact legacy equivalent |  |
| 14 | `minecraft:golden_axe` | `new ItemStack(Items.golden_axe)` | exact legacy equivalent |  |
| 15 | `minecraft:golden_hoe` | `new ItemStack(Items.golden_hoe)` | exact legacy equivalent |  |
| 16 | `minecraft:diamond_shovel` | `new ItemStack(Items.diamond_shovel)` | exact legacy equivalent |  |
| 17 | `minecraft:diamond_pickaxe` | `new ItemStack(Items.diamond_pickaxe)` | exact legacy equivalent |  |
| 18 | `minecraft:diamond_axe` | `new ItemStack(Items.diamond_axe)` | exact legacy equivalent |  |
| 19 | `minecraft:diamond_hoe` | `new ItemStack(Items.diamond_hoe)` | exact legacy equivalent |  |
| 20 | `minecraft:netherite_shovel` | `new ItemStack(ModItems.NETHERITE_SPADE.get())` | EFR backport equivalent |  |
| 21 | `minecraft:netherite_pickaxe` | `new ItemStack(ModItems.NETHERITE_PICKAXE.get())` | EFR backport equivalent |  |
| 22 | `minecraft:netherite_axe` | `new ItemStack(ModItems.NETHERITE_AXE.get())` | EFR backport equivalent |  |
| 23 | `minecraft:netherite_hoe` | `new ItemStack(ModItems.NETHERITE_HOE.get())` | EFR backport equivalent |  |
| 24 | `minecraft:bucket` | `new ItemStack(Items.bucket)` | exact legacy equivalent |  |
| 25 | `minecraft:water_bucket` | `new ItemStack(Items.water_bucket)` | exact legacy equivalent |  |
| 26 | `minecraft:cod_bucket` | `Omitted` | missing | Not backported |
| 27 | `minecraft:salmon_bucket` | `Omitted` | missing | Not backported |
| 28 | `minecraft:tropical_fish_bucket` | `Omitted` | missing | Not backported |
| 29 | `minecraft:pufferfish_bucket` | `Omitted` | missing | Not backported |
| 30 | `minecraft:axolotl_bucket` | `Omitted` | missing | Not backported |
| 31 | `minecraft:tadpole_bucket` | `Omitted` | missing | Not backported |
| 32 | `minecraft:lava_bucket` | `new ItemStack(Items.lava_bucket)` | exact legacy equivalent |  |
| 33 | `minecraft:powder_snow_bucket` | `Omitted` | missing | Not backported |
| 34 | `minecraft:milk_bucket` | `new ItemStack(Items.milk_bucket)` | exact legacy equivalent |  |
| 35 | `minecraft:fishing_rod` | `new ItemStack(Items.fishing_rod)` | exact legacy equivalent |  |
| 36 | `minecraft:flint_and_steel` | `new ItemStack(Items.flint_and_steel)` | exact legacy equivalent |  |
| 37 | `minecraft:fire_charge` | `new ItemStack(Items.fire_charge)` | EFR backport equivalent | Automatically resolved |
| 38 | `minecraft:bone_meal` | `new ItemStack(Items.dye, 1, 15)` | exact legacy equivalent |  |
| 39 | `minecraft:shears` | `new ItemStack(Items.shears)` | exact legacy equivalent |  |
| 40 | `minecraft:brush` | `Omitted` | missing | Not backported |
| 41 | `minecraft:name_tag` | `new ItemStack(Items.name_tag)` | exact legacy equivalent |  |
| 42 | `minecraft:lead` | `new ItemStack(Items.lead)` | exact legacy equivalent |  |
| 43 | `minecraft:bundle` | `Omitted` | missing | Not backported |
| 44 | `minecraft:white_bundle` | `Omitted` | missing | Not backported |
| 45 | `minecraft:light_gray_bundle` | `Omitted` | missing | Not backported |
| 46 | `minecraft:gray_bundle` | `Omitted` | missing | Not backported |
| 47 | `minecraft:black_bundle` | `Omitted` | missing | Not backported |
| 48 | `minecraft:brown_bundle` | `Omitted` | missing | Not backported |
| 49 | `minecraft:red_bundle` | `Omitted` | missing | Not backported |
| 50 | `minecraft:orange_bundle` | `Omitted` | missing | Not backported |
| 51 | `minecraft:yellow_bundle` | `Omitted` | missing | Not backported |
| 52 | `minecraft:lime_bundle` | `Omitted` | missing | Not backported |
| 53 | `minecraft:green_bundle` | `Omitted` | missing | Not backported |
| 54 | `minecraft:cyan_bundle` | `Omitted` | missing | Not backported |
| 55 | `minecraft:light_blue_bundle` | `Omitted` | missing | Not backported |
| 56 | `minecraft:blue_bundle` | `Omitted` | missing | Not backported |
| 57 | `minecraft:purple_bundle` | `Omitted` | missing | Not backported |
| 58 | `minecraft:magenta_bundle` | `Omitted` | missing | Not backported |
| 59 | `minecraft:pink_bundle` | `Omitted` | missing | Not backported |
| 60 | `minecraft:compass` | `new ItemStack(Items.compass)` | exact legacy equivalent |  |
| 61 | `minecraft:recovery_compass` | `Omitted` | missing | Not backported |
| 62 | `minecraft:clock` | `new ItemStack(Items.clock)` | exact legacy equivalent |  |
| 63 | `minecraft:spyglass` | `Omitted` | missing | Not backported |
| 64 | `minecraft:map` | `new ItemStack(Items.map)` | EFR backport equivalent | Automatically resolved |
| 65 | `minecraft:writable_book` | `new ItemStack(Items.writable_book)` | EFR backport equivalent | Automatically resolved |
| 66 | `minecraft:wind_charge` | `Omitted` | missing | Not backported |
| 67 | `minecraft:ender_pearl` | `new ItemStack(Items.ender_pearl)` | exact legacy equivalent |  |
| 68 | `minecraft:ender_eye` | `new ItemStack(Items.ender_eye)` | exact legacy equivalent |  |
| 69 | `minecraft:elytra` | `new ItemStack(ModItems.ELYTRA.get())` | EFR backport equivalent |  |
| 70 | `minecraft:saddle` | `new ItemStack(Items.saddle)` | exact legacy equivalent |  |
| 71 | `minecraft:carrot_on_a_stick` | `new ItemStack(Items.carrot_on_a_stick)` | EFR backport equivalent | Automatically resolved |
| 72 | `minecraft:warped_fungus_on_a_stick` | `Omitted` | missing | Not backported |
| 73 | `minecraft:oak_boat` | `new ItemStack(Items.boat)` | EFR backport equivalent | Automatically resolved |
| 74 | `minecraft:oak_chest_boat` | `new ItemStack(ModItems.OAK_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 75 | `minecraft:spruce_boat` | `new ItemStack(ModItems.SPRUCE_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 76 | `minecraft:spruce_chest_boat` | `new ItemStack(ModItems.SPRUCE_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 77 | `minecraft:birch_boat` | `new ItemStack(ModItems.BIRCH_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 78 | `minecraft:birch_chest_boat` | `new ItemStack(ModItems.BIRCH_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 79 | `minecraft:jungle_boat` | `new ItemStack(ModItems.JUNGLE_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 80 | `minecraft:jungle_chest_boat` | `new ItemStack(ModItems.JUNGLE_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 81 | `minecraft:acacia_boat` | `new ItemStack(ModItems.ACACIA_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 82 | `minecraft:acacia_chest_boat` | `new ItemStack(ModItems.ACACIA_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 83 | `minecraft:dark_oak_boat` | `new ItemStack(ModItems.DARK_OAK_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 84 | `minecraft:dark_oak_chest_boat` | `new ItemStack(ModItems.DARK_OAK_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 85 | `minecraft:mangrove_boat` | `new ItemStack(ModItems.MANGROVE_OAK_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 86 | `minecraft:mangrove_chest_boat` | `new ItemStack(ModItems.MANGROVE_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 87 | `minecraft:cherry_boat` | `new ItemStack(ModItems.CHERRY_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 88 | `minecraft:cherry_chest_boat` | `new ItemStack(ModItems.CHERRY_CHEST_BOAT.get())` | EFR backport equivalent | Automatically resolved |
| 89 | `minecraft:pale_oak_boat` | `Omitted` | missing | Not backported |
| 90 | `minecraft:pale_oak_chest_boat` | `Omitted` | missing | Not backported |
| 91 | `minecraft:bamboo_raft` | `new ItemStack(ModItems.BAMBOO_RAFT.get())` | EFR backport equivalent | Automatically resolved |
| 92 | `minecraft:bamboo_chest_raft` | `new ItemStack(ModItems.BAMBOO_CHEST_RAFT.get())` | EFR backport equivalent | Automatically resolved |
| 93 | `minecraft:rail` | `new ItemStack(Blocks.rail)` | EFR backport equivalent | Automatically resolved |
| 94 | `minecraft:powered_rail` | `new ItemStack(Blocks.golden_rail)` | EFR backport equivalent | Automatically resolved |
| 95 | `minecraft:detector_rail` | `new ItemStack(Blocks.detector_rail)` | EFR backport equivalent | Automatically resolved |
| 96 | `minecraft:activator_rail` | `new ItemStack(Blocks.activator_rail)` | EFR backport equivalent | Automatically resolved |
| 97 | `minecraft:minecart` | `new ItemStack(Items.minecart)` | EFR backport equivalent | Automatically resolved |
| 98 | `minecraft:hopper_minecart` | `new ItemStack(Items.hopper_minecart)` | EFR backport equivalent | Automatically resolved |
| 99 | `minecraft:chest_minecart` | `new ItemStack(Items.chest_minecart)` | EFR backport equivalent | Automatically resolved |
| 100 | `minecraft:furnace_minecart` | `new ItemStack(Items.furnace_minecart)` | EFR backport equivalent | Automatically resolved |
| 101 | `minecraft:tnt_minecart` | `new ItemStack(Items.tnt_minecart)` | EFR backport equivalent | Automatically resolved |
| 102 | `minecraft:music_disc_13` | `new ItemStack(Items.record_13)` | EFR backport equivalent | Automatically resolved |
| 103 | `minecraft:music_disc_cat` | `new ItemStack(Items.record_cat)` | EFR backport equivalent | Automatically resolved |
| 104 | `minecraft:music_disc_blocks` | `new ItemStack(Items.record_blocks)` | EFR backport equivalent | Automatically resolved |
| 105 | `minecraft:music_disc_chirp` | `new ItemStack(Items.record_chirp)` | EFR backport equivalent | Automatically resolved |
| 106 | `minecraft:music_disc_far` | `new ItemStack(Items.record_far)` | EFR backport equivalent | Automatically resolved |
| 107 | `minecraft:music_disc_mall` | `new ItemStack(Items.record_mall)` | EFR backport equivalent | Automatically resolved |
| 108 | `minecraft:music_disc_mellohi` | `new ItemStack(Items.record_mellohi)` | EFR backport equivalent | Automatically resolved |
| 109 | `minecraft:music_disc_stal` | `new ItemStack(Items.record_stal)` | EFR backport equivalent | Automatically resolved |
| 110 | `minecraft:music_disc_strad` | `new ItemStack(Items.record_strad)` | EFR backport equivalent | Automatically resolved |
| 111 | `minecraft:music_disc_ward` | `new ItemStack(Items.record_ward)` | EFR backport equivalent | Automatically resolved |
| 112 | `minecraft:music_disc_11` | `new ItemStack(Items.record_11)` | EFR backport equivalent | Automatically resolved |
| 113 | `minecraft:music_disc_creator_music_box` | `Omitted` | missing | Not backported |
| 114 | `minecraft:music_disc_wait` | `new ItemStack(Items.record_wait)` | EFR backport equivalent | Automatically resolved |
| 115 | `minecraft:music_disc_creator` | `Omitted` | missing | Not backported |
| 116 | `minecraft:music_disc_precipice` | `Omitted` | missing | Not backported |
| 117 | `minecraft:music_disc_otherside` | `new ItemStack(ModItems.OTHERSIDE_RECORD.get())` | EFR backport equivalent | Automatically resolved |
| 118 | `minecraft:music_disc_relic` | `Omitted` | missing | Not backported |
| 119 | `minecraft:music_disc_5` | `Omitted` | missing | Not backported |
| 120 | `minecraft:music_disc_pigstep` | `new ItemStack(ModItems.PIGSTEP_RECORD.get())` | EFR backport equivalent | Automatically resolved |

## Tab: Combat (`itemGroup.combat`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:wooden_sword` | `new ItemStack(Items.wooden_sword)` | exact legacy equivalent |  |
| 1 | `minecraft:stone_sword` | `new ItemStack(Items.stone_sword)` | exact legacy equivalent |  |
| 2 | `minecraft:iron_sword` | `new ItemStack(Items.iron_sword)` | exact legacy equivalent |  |
| 3 | `minecraft:golden_sword` | `new ItemStack(Items.golden_sword)` | exact legacy equivalent |  |
| 4 | `minecraft:diamond_sword` | `new ItemStack(Items.diamond_sword)` | exact legacy equivalent |  |
| 5 | `minecraft:netherite_sword` | `new ItemStack(ModItems.NETHERITE_SWORD.get())` | EFR backport equivalent |  |
| 6 | `minecraft:wooden_axe` | `new ItemStack(Items.wooden_axe)` | exact legacy equivalent |  |
| 7 | `minecraft:stone_axe` | `new ItemStack(Items.stone_axe)` | exact legacy equivalent |  |
| 8 | `minecraft:iron_axe` | `new ItemStack(Items.iron_axe)` | exact legacy equivalent |  |
| 9 | `minecraft:golden_axe` | `new ItemStack(Items.golden_axe)` | exact legacy equivalent |  |
| 10 | `minecraft:diamond_axe` | `new ItemStack(Items.diamond_axe)` | exact legacy equivalent |  |
| 11 | `minecraft:netherite_axe` | `new ItemStack(ModItems.NETHERITE_AXE.get())` | EFR backport equivalent |  |
| 12 | `minecraft:trident` | `new ItemStack(ModItems.TRIDENT.get())` | EFR backport equivalent |  |
| 13 | `minecraft:mace` | `Omitted` | missing | Not backported |
| 14 | `minecraft:shield` | `Omitted` | missing | Not backported |
| 15 | `minecraft:leather_helmet` | `new ItemStack(Items.leather_helmet)` | exact legacy equivalent |  |
| 16 | `minecraft:leather_chestplate` | `new ItemStack(Items.leather_chestplate)` | exact legacy equivalent |  |
| 17 | `minecraft:leather_leggings` | `new ItemStack(Items.leather_leggings)` | exact legacy equivalent |  |
| 18 | `minecraft:leather_boots` | `new ItemStack(Items.leather_boots)` | exact legacy equivalent |  |
| 19 | `minecraft:chainmail_helmet` | `new ItemStack(Items.chainmail_helmet)` | exact legacy equivalent |  |
| 20 | `minecraft:chainmail_chestplate` | `new ItemStack(Items.chainmail_chestplate)` | exact legacy equivalent |  |
| 21 | `minecraft:chainmail_leggings` | `new ItemStack(Items.chainmail_leggings)` | exact legacy equivalent |  |
| 22 | `minecraft:chainmail_boots` | `new ItemStack(Items.chainmail_boots)` | exact legacy equivalent |  |
| 23 | `minecraft:iron_helmet` | `new ItemStack(Items.iron_helmet)` | exact legacy equivalent |  |
| 24 | `minecraft:iron_chestplate` | `new ItemStack(Items.iron_chestplate)` | exact legacy equivalent |  |
| 25 | `minecraft:iron_leggings` | `new ItemStack(Items.iron_leggings)` | exact legacy equivalent |  |
| 26 | `minecraft:iron_boots` | `new ItemStack(Items.iron_boots)` | exact legacy equivalent |  |
| 27 | `minecraft:golden_helmet` | `new ItemStack(Items.golden_helmet)` | exact legacy equivalent |  |
| 28 | `minecraft:golden_chestplate` | `new ItemStack(Items.golden_chestplate)` | exact legacy equivalent |  |
| 29 | `minecraft:golden_leggings` | `new ItemStack(Items.golden_leggings)` | exact legacy equivalent |  |
| 30 | `minecraft:golden_boots` | `new ItemStack(Items.golden_boots)` | exact legacy equivalent |  |
| 31 | `minecraft:diamond_helmet` | `new ItemStack(Items.diamond_helmet)` | exact legacy equivalent |  |
| 32 | `minecraft:diamond_chestplate` | `new ItemStack(Items.diamond_chestplate)` | exact legacy equivalent |  |
| 33 | `minecraft:diamond_leggings` | `new ItemStack(Items.diamond_leggings)` | exact legacy equivalent |  |
| 34 | `minecraft:diamond_boots` | `new ItemStack(Items.diamond_boots)` | exact legacy equivalent |  |
| 35 | `minecraft:netherite_helmet` | `new ItemStack(ModItems.NETHERITE_HELMET.get())` | EFR backport equivalent |  |
| 36 | `minecraft:netherite_chestplate` | `new ItemStack(ModItems.NETHERITE_CHESTPLATE.get())` | EFR backport equivalent |  |
| 37 | `minecraft:netherite_leggings` | `new ItemStack(ModItems.NETHERITE_LEGGINGS.get())` | EFR backport equivalent |  |
| 38 | `minecraft:netherite_boots` | `new ItemStack(ModItems.NETHERITE_BOOTS.get())` | EFR backport equivalent |  |
| 39 | `minecraft:turtle_helmet` | `Omitted` | missing | Not backported |
| 40 | `minecraft:leather_horse_armor` | `Omitted` | missing | Not backported |
| 41 | `minecraft:iron_horse_armor` | `new ItemStack(Items.iron_horse_armor)` | EFR backport equivalent | Automatically resolved |
| 42 | `minecraft:golden_horse_armor` | `new ItemStack(Items.golden_horse_armor)` | EFR backport equivalent | Automatically resolved |
| 43 | `minecraft:diamond_horse_armor` | `new ItemStack(Items.diamond_horse_armor)` | EFR backport equivalent | Automatically resolved |
| 44 | `minecraft:wolf_armor` | `Omitted` | missing | Not backported |
| 45 | `minecraft:totem_of_undying` | `new ItemStack(ModItems.TOTEM_OF_UNDYING.get())` | EFR backport equivalent |  |
| 46 | `minecraft:tnt` | `new ItemStack(Blocks.tnt)` | exact legacy equivalent |  |
| 47 | `minecraft:end_crystal` | `new ItemStack(ModItems.END_CRYSTAL.get())` | EFR backport equivalent | Automatically resolved |
| 48 | `minecraft:snowball` | `new ItemStack(Items.snowball)` | exact legacy equivalent | Not backported |
| 49 | `minecraft:egg` | `new ItemStack(Items.egg)` | exact legacy equivalent |  |
| 50 | `minecraft:wind_charge` | `Omitted` | missing | Not backported |
| 51 | `minecraft:bow` | `new ItemStack(Items.bow)` | exact legacy equivalent |  |
| 52 | `minecraft:crossbow` | `Omitted` | missing | Not backported |
| 53 | `minecraft:arrow` | `new ItemStack(Items.arrow)` | exact legacy equivalent |  |
| 54 | `minecraft:spectral_arrow` | `new ItemStack(ModItems.SPECTRAL_ARROW.get())` | EFR backport equivalent |  |

## Tab: Food & Drinks (`itemGroup.foodAndDrink`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:apple` | `new ItemStack(Items.apple)` | exact legacy equivalent |  |
| 1 | `minecraft:golden_apple` | `new ItemStack(Items.golden_apple, 1, 0)` | exact legacy equivalent |  |
| 2 | `minecraft:enchanted_golden_apple` | `new ItemStack(Items.golden_apple, 1, 1)` | exact legacy equivalent |  |
| 3 | `minecraft:melon_slice` | `new ItemStack(Items.melon)` | exact legacy equivalent |  |
| 4 | `minecraft:sweet_berries` | `new ItemStack(ModItems.SWEET_BERRIES.get())` | EFR backport equivalent |  |
| 5 | `minecraft:glow_berries` | `Omitted` | missing | Not backported |
| 6 | `minecraft:chorus_fruit` | `new ItemStack(ModItems.CHORUS_FRUIT.get())` | EFR backport equivalent | Automatically resolved |
| 7 | `minecraft:carrot` | `new ItemStack(Items.carrot)` | EFR backport equivalent | Automatically resolved |
| 8 | `minecraft:golden_carrot` | `new ItemStack(Items.golden_carrot)` | exact legacy equivalent | Not backported |
| 9 | `minecraft:potato` | `new ItemStack(Items.potato)` | EFR backport equivalent | Automatically resolved |
| 10 | `minecraft:baked_potato` | `new ItemStack(Items.baked_potato)` | EFR backport equivalent | Automatically resolved |
| 11 | `minecraft:poisonous_potato` | `new ItemStack(Items.poisonous_potato)` | exact legacy equivalent |  |
| 12 | `minecraft:beetroot` | `new ItemStack(ModItems.BEETROOT.get())` | EFR backport equivalent |  |
| 13 | `minecraft:dried_kelp` | `Omitted` | missing | Not backported |
| 14 | `minecraft:beef` | `new ItemStack(Items.beef)` | exact legacy equivalent |  |
| 15 | `minecraft:cooked_beef` | `new ItemStack(Items.cooked_beef)` | exact legacy equivalent |  |
| 16 | `minecraft:porkchop` | `new ItemStack(Items.porkchop)` | exact legacy equivalent |  |
| 17 | `minecraft:cooked_porkchop` | `new ItemStack(Items.cooked_porkchop)` | exact legacy equivalent |  |
| 18 | `minecraft:mutton` | `new ItemStack(ModItems.MUTTON_RAW.get())` | EFR backport equivalent |  |
| 19 | `minecraft:cooked_mutton` | `new ItemStack(ModItems.MUTTON_COOKED.get())` | EFR backport equivalent |  |
| 20 | `minecraft:chicken` | `new ItemStack(Items.chicken)` | exact legacy equivalent |  |
| 21 | `minecraft:cooked_chicken` | `new ItemStack(Items.cooked_chicken)` | exact legacy equivalent |  |
| 22 | `minecraft:rabbit` | `new ItemStack(ModItems.RABBIT_RAW.get())` | EFR backport equivalent |  |
| 23 | `minecraft:cooked_rabbit` | `new ItemStack(ModItems.RABBIT_COOKED.get())` | EFR backport equivalent |  |
| 24 | `minecraft:cod` | `new ItemStack(Items.fish, 1, 0)` | EFR backport equivalent | Automatically resolved |
| 25 | `minecraft:cooked_cod` | `new ItemStack(Items.cooked_fished, 1, 0)` | EFR backport equivalent | Automatically resolved |
| 26 | `minecraft:salmon` | `new ItemStack(Items.fish, 1, 1)` | EFR backport equivalent | Automatically resolved |
| 27 | `minecraft:cooked_salmon` | `new ItemStack(Items.cooked_fished, 1, 1)` | EFR backport equivalent | Automatically resolved |
| 28 | `minecraft:tropical_fish` | `new ItemStack(Items.fish, 1, 2)` | EFR backport equivalent | Automatically resolved |
| 29 | `minecraft:pufferfish` | `new ItemStack(Items.fish, 1, 3)` | EFR backport equivalent | Automatically resolved |
| 30 | `minecraft:bread` | `new ItemStack(Items.bread)` | exact legacy equivalent |  |
| 31 | `minecraft:cookie` | `new ItemStack(Items.cookie)` | exact legacy equivalent |  |
| 32 | `minecraft:cake` | `new ItemStack(Items.cake)` | EFR backport equivalent | Automatically resolved |
| 33 | `minecraft:pumpkin_pie` | `new ItemStack(Items.pumpkin_pie)` | exact legacy equivalent |  |
| 34 | `minecraft:rotten_flesh` | `new ItemStack(Items.rotten_flesh)` | exact legacy equivalent |  |
| 35 | `minecraft:spider_eye` | `new ItemStack(Items.spider_eye)` | exact legacy equivalent |  |
| 36 | `minecraft:mushroom_stew` | `new ItemStack(Items.mushroom_stew)` | exact legacy equivalent |  |
| 37 | `minecraft:beetroot_soup` | `new ItemStack(ModItems.BEETROOT_SOUP.get())` | EFR backport equivalent |  |
| 38 | `minecraft:rabbit_stew` | `new ItemStack(ModItems.RABBIT_STEW.get())` | EFR backport equivalent |  |
| 39 | `minecraft:milk_bucket` | `new ItemStack(Items.milk_bucket)` | exact legacy equivalent |  |
| 40 | `minecraft:honey_bottle` | `new ItemStack(ModItems.HONEY_BOTTLE.get())` | EFR backport equivalent |  |

## Tab: Ingredients (`itemGroup.ingredients`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:coal` | `new ItemStack(Items.coal, 1, 0)` | exact legacy equivalent |  |
| 1 | `minecraft:charcoal` | `new ItemStack(Items.coal, 1, 1)` | exact legacy equivalent |  |
| 2 | `minecraft:raw_iron` | `new ItemStack(ModItems.RAW_ORE.get(), 1, 1)` | EFR backport equivalent |  |
| 3 | `minecraft:raw_copper` | `new ItemStack(ModItems.RAW_ORE.get(), 1, 0)` | EFR backport equivalent |  |
| 4 | `minecraft:raw_gold` | `new ItemStack(ModItems.RAW_ORE.get(), 1, 2)` | EFR backport equivalent |  |
| 5 | `minecraft:emerald` | `new ItemStack(Items.emerald)` | exact legacy equivalent |  |
| 6 | `minecraft:lapis_lazuli` | `new ItemStack(Items.dye, 1, 4)` | exact legacy equivalent |  |
| 7 | `minecraft:diamond` | `new ItemStack(Items.diamond)` | exact legacy equivalent |  |
| 8 | `minecraft:ancient_debris` | `new ItemStack(ModBlocks.ANCIENT_DEBRIS.get())` | EFR backport equivalent |  |
| 9 | `minecraft:quartz` | `new ItemStack(Items.quartz)` | exact legacy equivalent |  |
| 10 | `minecraft:amethyst_shard` | `new ItemStack(ModItems.AMETHYST_SHARD.get())` | EFR backport equivalent |  |
| 11 | `minecraft:iron_nugget` | `new ItemStack(ModItems.NUGGET_IRON.get())` | EFR backport equivalent | Not backported |
| 12 | `minecraft:gold_nugget` | `new ItemStack(Items.gold_nugget)` | exact legacy equivalent | Not backported |
| 13 | `minecraft:iron_ingot` | `new ItemStack(Items.iron_ingot)` | exact legacy equivalent |  |
| 14 | `minecraft:copper_ingot` | `new ItemStack(ModItems.COPPER_INGOT.get())` | EFR backport equivalent |  |
| 15 | `minecraft:gold_ingot` | `new ItemStack(Items.gold_ingot)` | exact legacy equivalent |  |
| 16 | `minecraft:netherite_scrap` | `new ItemStack(ModItems.NETHERITE_SCRAP.get())` | EFR backport equivalent |  |
| 17 | `minecraft:netherite_ingot` | `new ItemStack(ModItems.NETHERITE_INGOT.get())` | EFR backport equivalent |  |
| 18 | `minecraft:stick` | `new ItemStack(Items.stick)` | exact legacy equivalent |  |
| 19 | `minecraft:flint` | `new ItemStack(Items.flint)` | exact legacy equivalent |  |
| 20 | `minecraft:wheat` | `new ItemStack(Items.wheat)` | exact legacy equivalent |  |
| 21 | `minecraft:bone` | `new ItemStack(Items.bone)` | exact legacy equivalent | Not backported |
| 22 | `minecraft:bone_meal` | `new ItemStack(Items.dye, 1, 15)` | exact legacy equivalent |  |
| 23 | `minecraft:string` | `new ItemStack(Items.string)` | exact legacy equivalent | Not backported |
| 24 | `minecraft:feather` | `new ItemStack(Items.feather)` | exact legacy equivalent | Not backported |
| 25 | `minecraft:snowball` | `new ItemStack(Items.snowball)` | exact legacy equivalent | Not backported |
| 26 | `minecraft:egg` | `new ItemStack(Items.egg)` | exact legacy equivalent |  |
| 27 | `minecraft:leather` | `new ItemStack(Items.leather)` | exact legacy equivalent | Not backported |
| 28 | `minecraft:rabbit_hide` | `new ItemStack(ModItems.RABBIT_HIDE.get())` | EFR backport equivalent | Not backported |
| 29 | `minecraft:honeycomb` | `new ItemStack(ModItems.HONEYCOMB.get())` | EFR backport equivalent |  |
| 30 | `minecraft:resin_clump` | `Omitted` | missing | Not backported |
| 31 | `minecraft:ink_sac` | `new ItemStack(Items.dye, 1, 0)` | exact legacy equivalent |  |
| 32 | `minecraft:glow_ink_sac` | `Omitted` | missing | Not backported |
| 33 | `minecraft:turtle_scute` | `Omitted` | missing | Not backported |
| 34 | `minecraft:armadillo_scute` | `Omitted` | missing | Not backported |
| 35 | `minecraft:slime_ball` | `new ItemStack(Items.slime_ball)` | exact legacy equivalent |  |
| 36 | `minecraft:clay_ball` | `new ItemStack(Items.clay_ball)` | exact legacy equivalent |  |
| 37 | `minecraft:prismarine_shard` | `new ItemStack(ModItems.PRISMARINE_SHARD.get())` | EFR backport equivalent | Not backported |
| 38 | `minecraft:prismarine_crystals` | `new ItemStack(ModItems.PRISMARINE_CRYSTALS.get())` | EFR backport equivalent | Not backported |
| 39 | `minecraft:nautilus_shell` | `new ItemStack(ModItems.NAUTILUS_SHELL.get())` | EFR backport equivalent |  |
| 40 | `minecraft:heart_of_the_sea` | `Omitted` | missing | Not backported |
| 41 | `minecraft:fire_charge` | `new ItemStack(Items.fire_charge)` | EFR backport equivalent | Automatically resolved |
| 42 | `minecraft:blaze_rod` | `new ItemStack(Items.blaze_rod)` | exact legacy equivalent | Not backported |
| 43 | `minecraft:breeze_rod` | `Omitted` | missing | Not backported |
| 44 | `minecraft:heavy_core` | `Omitted` | missing | Not backported |
| 45 | `minecraft:nether_star` | `new ItemStack(Items.nether_star)` | exact legacy equivalent | Not backported |
| 46 | `minecraft:ender_pearl` | `new ItemStack(Items.ender_pearl)` | exact legacy equivalent |  |
| 47 | `minecraft:ender_eye` | `new ItemStack(Items.ender_eye)` | exact legacy equivalent |  |
| 48 | `minecraft:shulker_shell` | `new ItemStack(ModItems.SHULKER_SHELL.get())` | EFR backport equivalent |  |
| 49 | `minecraft:popped_chorus_fruit` | `Omitted` | missing | Not backported |
| 50 | `minecraft:echo_shard` | `Omitted` | missing | Not backported |
| 51 | `minecraft:disc_fragment_5` | `Omitted` | missing | Not backported |
| 52 | `minecraft:white_dye` | `new ItemStack(ModItems.DYE.get(), 1, 0)` | EFR backport equivalent |  |
| 53 | `minecraft:light_gray_dye` | `new ItemStack(Items.dye, 1, 7)` | exact legacy equivalent |  |
| 54 | `minecraft:gray_dye` | `new ItemStack(Items.dye, 1, 8)` | exact legacy equivalent |  |
| 55 | `minecraft:black_dye` | `new ItemStack(ModItems.DYE.get(), 1, 3)` | EFR backport equivalent |  |
| 56 | `minecraft:brown_dye` | `new ItemStack(ModItems.DYE.get(), 1, 2)` | EFR backport equivalent |  |
| 57 | `minecraft:red_dye` | `new ItemStack(Items.dye, 1, 1)` | exact legacy equivalent |  |
| 58 | `minecraft:orange_dye` | `new ItemStack(Items.dye, 1, 14)` | exact legacy equivalent |  |
| 59 | `minecraft:yellow_dye` | `new ItemStack(Items.dye, 1, 11)` | exact legacy equivalent |  |
| 60 | `minecraft:lime_dye` | `new ItemStack(Items.dye, 1, 10)` | exact legacy equivalent |  |
| 61 | `minecraft:green_dye` | `new ItemStack(Items.dye, 1, 2)` | exact legacy equivalent |  |
| 62 | `minecraft:cyan_dye` | `new ItemStack(Items.dye, 1, 6)` | exact legacy equivalent |  |
| 63 | `minecraft:light_blue_dye` | `new ItemStack(Items.dye, 1, 12)` | exact legacy equivalent |  |
| 64 | `minecraft:blue_dye` | `new ItemStack(ModItems.DYE.get(), 1, 1)` | EFR backport equivalent |  |
| 65 | `minecraft:purple_dye` | `new ItemStack(Items.dye, 1, 5)` | exact legacy equivalent |  |
| 66 | `minecraft:magenta_dye` | `new ItemStack(Items.dye, 1, 13)` | exact legacy equivalent |  |
| 67 | `minecraft:pink_dye` | `new ItemStack(Items.dye, 1, 9)` | exact legacy equivalent |  |
| 68 | `minecraft:bowl` | `new ItemStack(Items.bowl)` | EFR backport equivalent | Automatically resolved |
| 69 | `minecraft:brick` | `new ItemStack(Items.brick)` | exact legacy equivalent |  |
| 70 | `minecraft:nether_brick` | `new ItemStack(Items.netherbrick)` | exact legacy equivalent |  |
| 71 | `minecraft:resin_brick` | `Omitted` | missing | Not backported |
| 72 | `minecraft:paper` | `new ItemStack(Items.paper)` | exact legacy equivalent |  |
| 73 | `minecraft:book` | `new ItemStack(Items.book)` | exact legacy equivalent |  |
| 74 | `minecraft:firework_star` | `new ItemStack(Items.fireworkCharge)` | exact legacy equivalent | Not backported |
| 75 | `minecraft:glass_bottle` | `new ItemStack(Items.glass_bottle)` | EFR backport equivalent | Automatically resolved |
| 76 | `minecraft:nether_wart` | `new ItemStack(ModBlocks.NETHER_WART.get())` | EFR backport equivalent | Automatically resolved |
| 77 | `minecraft:redstone` | `new ItemStack(Items.redstone)` | exact legacy equivalent |  |
| 78 | `minecraft:glowstone_dust` | `new ItemStack(Items.glowstone_dust)` | exact legacy equivalent |  |
| 79 | `minecraft:gunpowder` | `new ItemStack(Items.gunpowder)` | exact legacy equivalent | Not backported |
| 80 | `minecraft:dragon_breath` | `new ItemStack(ModItems.DRAGON_BREATH.get())` | EFR backport equivalent | Not backported |
| 81 | `minecraft:fermented_spider_eye` | `new ItemStack(Items.fermented_spider_eye)` | exact legacy equivalent |  |
| 82 | `minecraft:blaze_powder` | `new ItemStack(Items.blaze_powder)` | exact legacy equivalent | Not backported |
| 83 | `minecraft:sugar` | `new ItemStack(Items.sugar)` | exact legacy equivalent | Not backported |
| 84 | `minecraft:rabbit_foot` | `new ItemStack(ModItems.RABBIT_FOOT.get())` | EFR backport equivalent | Not backported |
| 85 | `minecraft:glistering_melon_slice` | `new ItemStack(Items.speckled_melon)` | exact legacy equivalent | Not backported |
| 86 | `minecraft:spider_eye` | `new ItemStack(Items.spider_eye)` | exact legacy equivalent |  |
| 87 | `minecraft:pufferfish` | `new ItemStack(Items.fish, 1, 3)` | EFR backport equivalent | Automatically resolved |
| 88 | `minecraft:magma_cream` | `new ItemStack(Items.magma_cream)` | exact legacy equivalent | Not backported |
| 89 | `minecraft:golden_carrot` | `new ItemStack(Items.golden_carrot)` | exact legacy equivalent | Not backported |
| 90 | `minecraft:ghast_tear` | `new ItemStack(Items.ghast_tear)` | exact legacy equivalent | Not backported |
| 91 | `minecraft:turtle_helmet` | `Omitted` | missing | Not backported |
| 92 | `minecraft:phantom_membrane` | `Omitted` | missing | Not backported |
| 93 | `minecraft:field_masoned_banner_pattern` | `Omitted` | missing | Not backported |
| 94 | `minecraft:bordure_indented_banner_pattern` | `Omitted` | missing | Not backported |
| 95 | `minecraft:flower_banner_pattern` | `Omitted` | missing | Not backported |
| 96 | `minecraft:creeper_banner_pattern` | `Omitted` | missing | Not backported |
| 97 | `minecraft:skull_banner_pattern` | `Omitted` | missing | Not backported |
| 98 | `minecraft:mojang_banner_pattern` | `Omitted` | missing | Not backported |
| 99 | `minecraft:globe_banner_pattern` | `Omitted` | missing | Not backported |
| 100 | `minecraft:piglin_banner_pattern` | `Omitted` | missing | Not backported |
| 101 | `minecraft:flow_banner_pattern` | `Omitted` | missing | Not backported |
| 102 | `minecraft:guster_banner_pattern` | `Omitted` | missing | Not backported |
| 103 | `minecraft:angler_pottery_sherd` | `Omitted` | missing | Not backported |
| 104 | `minecraft:archer_pottery_sherd` | `Omitted` | missing | Not backported |
| 105 | `minecraft:arms_up_pottery_sherd` | `Omitted` | missing | Not backported |
| 106 | `minecraft:blade_pottery_sherd` | `Omitted` | missing | Not backported |
| 107 | `minecraft:brewer_pottery_sherd` | `Omitted` | missing | Not backported |
| 108 | `minecraft:burn_pottery_sherd` | `Omitted` | missing | Not backported |
| 109 | `minecraft:danger_pottery_sherd` | `Omitted` | missing | Not backported |
| 110 | `minecraft:flow_pottery_sherd` | `Omitted` | missing | Not backported |
| 111 | `minecraft:explorer_pottery_sherd` | `Omitted` | missing | Not backported |
| 112 | `minecraft:friend_pottery_sherd` | `Omitted` | missing | Not backported |
| 113 | `minecraft:guster_pottery_sherd` | `Omitted` | missing | Not backported |
| 114 | `minecraft:heart_pottery_sherd` | `Omitted` | missing | Not backported |
| 115 | `minecraft:heartbreak_pottery_sherd` | `Omitted` | missing | Not backported |
| 116 | `minecraft:howl_pottery_sherd` | `Omitted` | missing | Not backported |
| 117 | `minecraft:miner_pottery_sherd` | `Omitted` | missing | Not backported |
| 118 | `minecraft:mourner_pottery_sherd` | `Omitted` | missing | Not backported |
| 119 | `minecraft:plenty_pottery_sherd` | `Omitted` | missing | Not backported |
| 120 | `minecraft:prize_pottery_sherd` | `Omitted` | missing | Not backported |
| 121 | `minecraft:scrape_pottery_sherd` | `Omitted` | missing | Not backported |
| 122 | `minecraft:sheaf_pottery_sherd` | `Omitted` | missing | Not backported |
| 123 | `minecraft:shelter_pottery_sherd` | `Omitted` | missing | Not backported |
| 124 | `minecraft:skull_pottery_sherd` | `Omitted` | missing | Not backported |
| 125 | `minecraft:snort_pottery_sherd` | `Omitted` | missing | Not backported |
| 126 | `minecraft:netherite_upgrade_smithing_template` | `Omitted` | missing | Not backported |
| 127 | `minecraft:sentry_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 128 | `minecraft:vex_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 129 | `minecraft:wild_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 130 | `minecraft:coast_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 131 | `minecraft:dune_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 132 | `minecraft:wayfinder_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 133 | `minecraft:raiser_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 134 | `minecraft:shaper_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 135 | `minecraft:host_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 136 | `minecraft:ward_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 137 | `minecraft:silence_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 138 | `minecraft:tide_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 139 | `minecraft:snout_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 140 | `minecraft:rib_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 141 | `minecraft:eye_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 142 | `minecraft:spire_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 143 | `minecraft:flow_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 144 | `minecraft:bolt_armor_trim_smithing_template` | `Omitted` | missing | Not backported |
| 145 | `minecraft:experience_bottle` | `new ItemStack(Items.experience_bottle)` | EFR backport equivalent | Automatically resolved |
| 146 | `minecraft:trial_key` | `Omitted` | missing | Not backported |
| 147 | `minecraft:ominous_trial_key` | `Omitted` | missing | Not backported |

## Tab: Spawn Eggs (`itemGroup.spawnEggs`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:spawner` | `new ItemStack(Blocks.mob_spawner)` | EFR backport equivalent | Automatically resolved |
| 1 | `minecraft:trial_spawner` | `Omitted` | missing | Not backported |
| 2 | `minecraft:creaking_heart` | `Omitted` | missing | Not backported |
| 3 | `minecraft:allay_spawn_egg` | `Omitted` | missing | Not backported |
| 4 | `minecraft:armadillo_spawn_egg` | `Omitted` | missing | Not backported |
| 5 | `minecraft:axolotl_spawn_egg` | `Omitted` | missing | Not backported |
| 6 | `minecraft:bat_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 65)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 7 | `minecraft:bee_spawn_egg` | `Omitted` | missing | Not backported |
| 8 | `minecraft:blaze_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 61)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 9 | `minecraft:bogged_spawn_egg` | `Omitted` | missing | Not backported |
| 10 | `minecraft:breeze_spawn_egg` | `Omitted` | missing | Not backported |
| 11 | `minecraft:camel_spawn_egg` | `Omitted` | missing | Not backported |
| 12 | `minecraft:cat_spawn_egg` | `Omitted` | missing | Not backported |
| 13 | `minecraft:cave_spider_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 59)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 14 | `minecraft:chicken_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 93)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 15 | `minecraft:cod_spawn_egg` | `Omitted` | missing | Not backported |
| 16 | `minecraft:cow_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 92)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 17 | `minecraft:creaking_spawn_egg` | `Omitted` | missing | Not backported |
| 18 | `minecraft:creeper_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 50)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 19 | `minecraft:dolphin_spawn_egg` | `Omitted` | missing | Not backported |
| 20 | `minecraft:donkey_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 31)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 21 | `minecraft:drowned_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, ModEntityList.eggIds.get(EntityDrowned.class))` | EFR backport equivalent | Registered with custom FML/Forge egg ID |
| 22 | `minecraft:elder_guardian_spawn_egg` | `Omitted` | missing | Not backported |
| 23 | `minecraft:enderman_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 58)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 24 | `minecraft:endermite_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, ModEntityList.eggIds.get(EntityEndermite.class))` | EFR backport equivalent | Registered with custom FML/Forge egg ID |
| 25 | `minecraft:evoker_spawn_egg` | `Omitted` | missing | Not backported |
| 26 | `minecraft:fox_spawn_egg` | `Omitted` | missing | Not backported |
| 27 | `minecraft:frog_spawn_egg` | `Omitted` | missing | Not backported |
| 28 | `minecraft:ghast_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 56)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 29 | `minecraft:glow_squid_spawn_egg` | `Omitted` | missing | Not backported |
| 30 | `minecraft:goat_spawn_egg` | `Omitted` | missing | Not backported |
| 31 | `minecraft:guardian_spawn_egg` | `Omitted` | missing | Not backported |
| 32 | `minecraft:hoglin_spawn_egg` | `Omitted` | missing | Not backported |
| 33 | `minecraft:horse_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 100)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 34 | `minecraft:husk_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, ModEntityList.eggIds.get(EntityHusk.class))` | EFR backport equivalent | Registered with custom FML/Forge egg ID |
| 35 | `minecraft:iron_golem_spawn_egg` | `Omitted` | missing | Not backported |
| 36 | `minecraft:llama_spawn_egg` | `Omitted` | missing | Not backported |
| 37 | `minecraft:magma_cube_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 62)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 38 | `minecraft:mooshroom_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 96)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 39 | `minecraft:mule_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 32)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 40 | `minecraft:ocelot_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 98)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 41 | `minecraft:panda_spawn_egg` | `Omitted` | missing | Not backported |
| 42 | `minecraft:parrot_spawn_egg` | `Omitted` | missing | Not backported |
| 43 | `minecraft:phantom_spawn_egg` | `Omitted` | missing | Not backported |
| 44 | `minecraft:pig_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 90)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 45 | `minecraft:piglin_spawn_egg` | `Omitted` | missing | Not backported |
| 46 | `minecraft:piglin_brute_spawn_egg` | `Omitted` | missing | Not backported |
| 47 | `minecraft:pillager_spawn_egg` | `Omitted` | missing | Not backported |
| 48 | `minecraft:polar_bear_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, ModEntityList.eggIds.get(EntityPolarBear.class))` | EFR backport equivalent | Registered with custom FML/Forge egg ID |
| 49 | `minecraft:pufferfish_spawn_egg` | `Omitted` | missing | Not backported |
| 50 | `minecraft:rabbit_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, ModEntityList.eggIds.get(EntityRabbit.class))` | EFR backport equivalent | Registered with custom FML/Forge egg ID |
| 51 | `minecraft:ravager_spawn_egg` | `Omitted` | missing | Not backported |
| 52 | `minecraft:salmon_spawn_egg` | `Omitted` | missing | Not backported |
| 53 | `minecraft:sheep_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 91)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 54 | `minecraft:shulker_spawn_egg` | `Omitted` | missing | Not backported |
| 55 | `minecraft:silverfish_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 60)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 56 | `minecraft:skeleton_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 51)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 57 | `minecraft:skeleton_horse_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 28)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 58 | `minecraft:slime_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 55)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 59 | `minecraft:sniffer_spawn_egg` | `Omitted` | missing | Not backported |
| 60 | `minecraft:snow_golem_spawn_egg` | `Omitted` | missing | Not backported |
| 61 | `minecraft:spider_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 52)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 62 | `minecraft:squid_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 94)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 63 | `minecraft:stray_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, ModEntityList.eggIds.get(EntityStray.class))` | EFR backport equivalent | Registered with custom FML/Forge egg ID |
| 64 | `minecraft:strider_spawn_egg` | `Omitted` | missing | Not backported |
| 65 | `minecraft:tadpole_spawn_egg` | `Omitted` | missing | Not backported |
| 66 | `minecraft:trader_llama_spawn_egg` | `Omitted` | missing | Not backported |
| 67 | `minecraft:tropical_fish_spawn_egg` | `Omitted` | missing | Not backported |
| 68 | `minecraft:turtle_spawn_egg` | `Omitted` | missing | Not backported |
| 69 | `minecraft:vex_spawn_egg` | `Omitted` | missing | Not backported |
| 70 | `minecraft:villager_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 120)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 71 | `minecraft:vindicator_spawn_egg` | `Omitted` | missing | Not backported |
| 72 | `minecraft:wandering_trader_spawn_egg` | `Omitted` | missing | Not backported |
| 73 | `minecraft:warden_spawn_egg` | `Omitted` | missing | Not backported |
| 74 | `minecraft:witch_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 66)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 75 | `minecraft:wither_skeleton_spawn_egg` | `Omitted` | missing | Not backported |
| 76 | `minecraft:wolf_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 95)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 77 | `minecraft:zoglin_spawn_egg` | `Omitted` | missing | Not backported |
| 78 | `minecraft:zombie_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 54)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 79 | `minecraft:zombie_horse_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 29)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |
| 80 | `minecraft:zombie_villager_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, ModEntityList.eggIds.get(EntityZombieVillager.class))` | EFR backport equivalent | Registered with custom FML/Forge egg ID |
| 81 | `minecraft:zombified_piglin_spawn_egg` | `new ItemStack(Items.spawn_egg, 1, 57)` | exact legacy equivalent | Registered with custom FML/Forge egg ID |

## Tab: Operator Utilities (`itemGroup.op`)
| Index | 1.21.4 Registry ID | 1.7.10 / EFR Constructor | Status | Notes |
| --- | --- | --- | --- | --- |
| 0 | `minecraft:command_block` | `new ItemStack(Blocks.command_block)` | exact legacy equivalent |  |
| 1 | `minecraft:chain_command_block` | `Omitted` | missing | Not backported |
| 2 | `minecraft:repeating_command_block` | `Omitted` | missing | Not backported |
| 3 | `minecraft:command_block_minecart` | `new ItemStack(Items.command_block_minecart)` | exact legacy equivalent |  |
| 4 | `minecraft:jigsaw` | `Omitted` | missing | Not backported |
| 5 | `minecraft:structure_block` | `Omitted` | missing | Not backported |
| 6 | `minecraft:structure_void` | `Omitted` | missing | Not backported |
| 7 | `minecraft:barrier` | `new ItemStack(ModBlocks.BARRIER.get())` | EFR backport equivalent |  |
| 8 | `minecraft:debug_stick` | `Omitted` | missing | Not backported |

## Exact Color Ordering
Extracted strictly from 1.21.4 `Colored Blocks` tab:
1. White
2. Orange
3. Magenta
4. Light_blue
5. Yellow
6. Lime
7. Pink
8. Gray
9. Light_gray
10. Cyan
11. Purple
12. Blue
13. Brown
14. Green
15. Red
16. Black

## Saved Hotbars Behavior
- Stored in client directory as `hotbar.nbt`.
- 9 groups of 9 slots.
- Client keybindings: Dynamic combination of 'Save Hotbar Activator' and hotbar slots (1-9).
- Empty slot info renders using paper with custom description but cannot be transferred to inventory (preventing pickup).
- Server validation blocks Operator-only items if the client loads from custom modified `hotbar.nbt` without permissions.

## Search Behavior
- Full search aggregates items from all active display builders.
- Excludes Operator tab items unless OP setting is true.
- Prefixing with `#` will search by OreDictionary names (approximate modern tag search).
- Hidden tabs and Saved Hotbar placeholders are omitted from search results.

## Inventory Tab Behavior
- Matches 1.21.4 styling but fits within 1.7.10 GUI container guidelines.
- Includes the 'destroy item' trash can slot, which works client-side and coordinates slot removals.