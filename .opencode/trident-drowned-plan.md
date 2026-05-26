# Trident + Drowned Backport Plan

## Target

Primary behavior target: vanilla Minecraft 1.13.2, backported to Forge 1.7.10.

Undertow is a 1.7.10 compatibility/reference aid only. When Undertow differs from vanilla 1.13.2, vanilla 1.13.2 wins.

## Approved Decisions

| Area | Target behavior |
| --- | --- |
| Trident repair | No copper repair, no custom repair recipe. Vanilla 1.13.2 `ItemTrident` does not override item repair and has no recipe. |
| Drowned ingot drop | Gold ingot, not copper. Loot is player-kill gated, `5% + 1% per Looting level`. |
| Drowned equipment | `10%` equipment branch; inside it `10/16` trident and `6/16` fishing rod. Effective trident chance is `6.25%`. |
| Nautilus shell | `3%` offhand chance, offhand drop chance `2.0F`. |
| Trident item | Durability `250`, enchantability `1`, charge time `>= 10` ticks, throw speed `2.5F`, inaccuracy `1.0F`. |
| Thrown trident damage | Base `8.0F` plus Impaling modifier. |
| Channeling | Entity hit only, thundering, sky-visible target; no lightning-rod or block-hit behavior. |
| Zombie conversion | Eyes in water `600` ticks, conversion `300` ticks. |
| Drowned behavior | Does not drown, does not break doors, attacks dry players only at night where practical. |

## Vanilla Source References

| Feature | Vanilla source |
| --- | --- |
| Trident item behavior | `H:/CodeProjects/Minecraft-Sources/1.13.2/MCP-Reborn-1.13.2-20190314/src/main/java/net/minecraft/item/ItemTrident.java` |
| Thrown trident behavior | `H:/CodeProjects/Minecraft-Sources/1.13.2/MCP-Reborn-1.13.2-20190314/src/main/java/net/minecraft/entity/projectile/EntityTrident.java` |
| Drowned behavior | `H:/CodeProjects/Minecraft-Sources/1.13.2/MCP-Reborn-1.13.2-20190314/src/main/java/net/minecraft/entity/monster/EntityDrowned.java` |
| Zombie conversion | `H:/CodeProjects/Minecraft-Sources/1.13.2/MCP-Reborn-1.13.2-20190314/src/main/java/net/minecraft/entity/monster/EntityZombie.java` |
| Trident enchantments | `EnchantmentLoyalty`, `EnchantmentImpaling`, `EnchantmentRiptide`, `EnchantmentChanneling`, `EnchantmentHelper`, `EnumEnchantmentType` in the same 1.13.2 source tree |
| Drowned loot | 1.13.2 `data/minecraft/loot_tables/entities/drowned.json` fetched from MC assets |

## Undertow Reference Boundaries

| Undertow file | Allowed use | Must change or reject |
| --- | --- | --- |
| `undertow-master/src/main/java/invalid/myask/undertow/item/ItemTrident.java` | 1.7.10 method names, item use hooks, attribute shape. | Do not use 1.6F throw force, Infinity/config behavior, or non-vanilla Riptide behavior. |
| `undertow-master/src/main/java/invalid/myask/undertow/entities/ProjectileTrident.java` | 1.7.10 projectile collision and NBT scaffolding. | Do not use Undertow Channeling block/config behavior, configurable multihits, or Undertow Loyalty/Riptide approximations when they differ. |
| `undertow-master/src/main/java/invalid/myask/undertow/entities/EntityDrowned.java` | 1.7.10 drowned scaffolding and equipment-slot constraints. | Do not use copper drops, Bedrock/configurable equipment constants, or non-vanilla AI. |

Any adapted Undertow code must be called out in implementation notes with the source file and the vanilla changes made.

## Implementation Phases

| Phase | Scope |
| --- | --- |
| L | Write and approve the revised source-verified plan. |
| A | Add config skeleton, IDs, item/entity registration stubs, and server-safe wiring. |
| B | Implement trident item and thrown trident projectile with basic vanilla throw/hit/pickup behavior. |
| I | Add basic client renderer/model and client-only registration. |
| C | Add trident enchantments and full Loyalty/Impaling/Riptide/Channeling behavior. |
| F | Add sounds through existing AssetDirector conventions. |
| E | Add Drowned entity shell, loot, equipment, sounds, and renderer. |
| D | Add focused zombie-to-drowned conversion. |
| G | Add Drowned AI, ranged attack, swimming/pathing approximations, and spawn rules. |
| H | Add final assets/lang/subtitles as needed. |
| J | Integration testing and client-visible verification. |
| K | Cleanup, documentation, and final report. |

## Milestone 1 Scope

Do this first and stop before Drowned AI/conversion:

- Config skeleton.
- Safe item/entity registration stubs.
- `ItemTrident` with vanilla durability, charge gating, throw speed, stack removal, creative pickup, melee/block durability basics, and no repair override.
- `EntityTrident` with preserved item stack, NBT persistence, shooter handling, in-ground/pickup behavior, base `8.0F` damage, basic collision, despawn behavior, and renderer orientation support.
- Basic trident renderer/model and client-only registration.
- Build with `./gradlew.bat build --rerun-tasks`.
- Client verification with `./gradlew.bat runClient`.

Deferred after Milestone 1:

- Drowned entity, AI, spawning, loot, and zombie conversion.
- Full trident enchantment registration and behavior.
- Final trident sounds/subtitles if AssetDirector wiring needs a separate pass.
- Dispenser behavior.

## Milestone 1 Guardrails

- Extending `EntityArrow` is acceptable only if arrow-only behavior is overridden or neutralized where it would make tridents incorrect.
- Verify pickup behavior, creative pickup behavior, in-ground behavior, NBT persistence, owner/shooter handling, item stack preservation, damage calculation, collision behavior, despawn behavior, and renderer orientation.
- Loyalty state can be represented in projectile data during Milestone 1, but full return behavior is deferred until enchantments are implemented.
- Keep client-only classes out of common code and register renderers only in `ClientProxy`.
- Do not start Drowned AI or zombie conversion until the trident item/projectile path is stable.
- Do not dump vanilla assets blindly; follow existing EFR resource-pack/AssetDirector practices and report expected paths.

## Milestone 1 Report Checklist

- Files added.
- Files modified.
- Config/registration added.
- Trident item status.
- Thrown trident status.
- Renderer/model status.
- Vanilla source files used.
- Undertow files reused/adapted, if any.
- Build result.
- `runClient` result.
- Known missing behavior deferred to later phases.
