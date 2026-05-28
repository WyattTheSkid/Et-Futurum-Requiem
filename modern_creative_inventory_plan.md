# Et Futurum Requiem: Strict 1.21.4 Creative Inventory Parity Plan

## 1. Goal & Philosophy
The objective is to achieve a strict 1:1 parity with the Minecraft 1.21.4 creative inventory behavior, layout, and UX within Forge 1.7.10. 
This project values exact vanilla parity over quick approximation. Where exact parity is impossible, the deviation will be explicitly documented and guarded.

---

## 2. ItemStack-First Display Builder
To handle 1.7.10 metadata properly, the builder API will be strictly `ItemStack`-first:
`accept(ItemStack stack)`

This is required because 1.7.10 groups distinct modern items (like Granite, Polished Granite, Diorite) under a single `Item` (e.g., `Blocks.stone`) with different metadata. Using `accept(Item)` as the core model would break parity for logs, leaves, stained glass, wool, spawn eggs, and potions.

*Deviation Note*: We will not rely on `item.getSubItems()` for any vanilla or EFR parity entries, as it is unstable across tabs. We will hardcode explicit `ItemStack` arrays mirroring the 1.21.4 extraction. `getSubItems()` will be reserved solely for fallback third-party mod items.

---

## 3. Vanilla Tab Hiding Strategy
When `modernCreativeInventory` is enabled, old vanilla 1.7.10 tabs must be hidden.
- **Duplicate Prevention**: We will not delete the tabs from `CreativeTabs.creativeTabArray`, as doing so breaks indices for Forge and third-party mods.
- Instead, we will Mixin into `GuiContainerCreative` to skip rendering and clicking for any tab that is an original vanilla tab (indices 0-11) except for Search and Inventory.
- Any third-party mod item assigned to a hidden vanilla tab (e.g., BuildCraft pipes in `tabBlock`) will be scooped during `postInit` and appended to the corresponding modern tab's display list.

---

## 4. Saved Hotbars Parity
**Exact Behavior:**
- **Client/Server Division**: Saving (`C + [1-9]`) is strictly client-side. The client reads the hotbar and saves to `hotbar.nbt`.
- **Placeholder Items**: Empty slots display `Items.paper`. To prevent players from picking up this paper, we will implement a custom `Slot` class or a click-interceptor in the GUI that rejects pickup if the item has the `inventory.hotbarInfo` NBT tag.
- **Keybindings**: We will add `KeyBinding` objects for "Save Hotbar Activator" and "Load Hotbar Activator". The slot number will be derived from the player's actual Hotbar Slot 1-9 keybindings, not hardcoded numeric keys.
- **Loading / Server Verification**: Loading a hotbar (`X + [1-9]`) sends the standard 1.7.10 `C10PacketCreativeInventoryAction` packets for the 9 hotbar slots (inventory slots 36-44).
- **Operator Security**: To prevent non-OP players from injecting Command Blocks via edited `hotbar.nbt` files, we will Mixin to `NetHandlerPlayServer.processCreativeInventoryAction` to reject the packet if the `ItemStack` is an operator item and the player lacks OP permission.

---

## 5. Operator Utilities Parity
- **Visibility**: The Operator tab must only be visible if the player has OP status.
- **Server Sync**: Because 1.7.10 clients do not always know their exact OP level reliably in multiplayer, we will send a custom lightweight packet from server to client on join/OP-status-change indicating `canUseGameMasterBlocks`.
- **Empty Tab Hiding**: If the player lacks permission or disables the client-side `displayOperatorCreativeTab` config, the tab will be completely omitted from the GUI rendering list (via `GuiContainerCreative` Mixin), rather than displaying an empty tab.

---

## 6. Search Parity
- **1.21.4 Behavior**: Uses a complex `SearchTree` cache supporting `#tag` searches, exact names, and omitting Operator items for non-OPs.
- **1.7.10 Behavior**: Brute-force loop checking `.toLowerCase().contains()` on tooltips.
- **Approximation**: We will Mixin `updateCreativeSearch()` to add `#` prefix support, resolving it to OreDictionary tags. Operator items will be excluded from search if the player lacks permission. Saved Hotbar placeholders will be explicitly excluded from search results.
- **Final Deviation**: The underlying algorithmic optimization of `SearchTree` will not be backported, as it would conflict massively with NEI. Search result order will match the natural iteration order of the tabs, not the exact 1.21.4 SearchTree tokenized order.

---

## 7. Implementation Phases

*   **Phase 1**: Extract exact 1.21.4 creative tab definitions, tab order, item order, special tab behavior, saved hotbar behavior, operator visibility, spawn egg order, and color order from source. *(Completed via `creative_inventory_extraction.md`)*
*   **Phase 2**: Create a source-to-backport mapping table from each 1.21.4 entry to an exact 1.7.10/EFR ItemStack, omitted entry, or documented approximation.
*   **Phase 3**: Create `ItemStack`-first display builder infrastructure.
*   **Phase 4**: Create modern creative tab classes with vanilla names/icons/localization.
*   **Phase 5**: Populate tabs using explicit mapped ItemStacks, including duplicate-tab appearances.
*   **Phase 6**: Implement fallback handling for third-party items assigned to old vanilla tabs, with duplicate prevention and registry-name sorting (`domain:path`).
*   **Phase 7**: Hide old vanilla tabs from the modern creative flow without deleting them from `CreativeTabs.creativeTabArray`.
*   **Phase 8**: Implement Saved Hotbars storage, strict keybinds (Activator + Hotbar Key), and server-side OP-item validation Mixins.
*   **Phase 9**: Implement Saved Hotbars tab rendering with non-pickable placeholders/info entries.
*   **Phase 10**: Implement Operator Utilities contents and a server-to-client permission/visibility sync packet.
*   **Phase 11**: Implement Spawn Eggs ordering using source-confirmed 1.21.4 order.
*   **Phase 12**: Evaluate and improve Search behavior (OreDict `#` support, placeholder exclusion), explicitly documenting deviations.
*   **Phase 13**: Patch `GuiContainerCreative` layout toward the 1.21.4 7-top/7-bottom parity, guarded by `strictCreativeGui` config.
*   **Phase 14**: Compatibility testing with vanilla-only, EFR-only, NEI, InventoryTweaks, MouseTweaks, and large modpacks.
