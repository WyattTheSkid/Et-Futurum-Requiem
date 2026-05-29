package ganymedes01.etfuturum.mixins.early.client;

import ganymedes01.etfuturum.core.handlers.creativetabs.ModernCreativeTabs;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GuiContainerCreative.class)
public abstract class MixinGuiContainerCreative extends InventoryEffectRenderer {

    @Shadow
    private static int selectedTabIndex;

    @Shadow(remap = false)
    private int maxPages;

    public MixinGuiContainerCreative(net.minecraft.inventory.Container container) {
        super(container);
    }

    private static CreativeTabs[] getModernTabs() {
        return new CreativeTabs[] {
            ModernCreativeTabs.BUILDING_BLOCKS,
            ModernCreativeTabs.COLORED_BLOCKS,
            ModernCreativeTabs.NATURAL_BLOCKS,
            ModernCreativeTabs.FUNCTIONAL_BLOCKS,
            ModernCreativeTabs.REDSTONE_BLOCKS,
            ModernCreativeTabs.HOTBAR,
            CreativeTabs.tabAllSearch,
            ModernCreativeTabs.TOOLS,
            ModernCreativeTabs.COMBAT,
            ModernCreativeTabs.FOOD_AND_DRINKS,
            ModernCreativeTabs.INGREDIENTS,
            ModernCreativeTabs.SPAWN_EGGS,
            ModernCreativeTabs.OP,
            CreativeTabs.tabInventory
        };
    }

    private int getModernTabIndex(CreativeTabs tab) {
        CreativeTabs[] modernTabs = getModernTabs();
        for (int i = 0; i < modernTabs.length; i++) {
            if (modernTabs[i] == tab) {
                return i;
            }
        }
        return -1;
    }

    private int getTabX(int index) {
        int col = index < 7 ? index : index - 7;
        int x = 27 * col;
        boolean isAlignedRight = (col == 5 || col == 6);
        if (isAlignedRight) {
            x = 195 - 27 * (7 - col) + 1;
        }
        return x;
    }

    private int getTabY(int index) {
        boolean isTop = index < 7;
        int y = 0;
        if (isTop) {
            y -= 32;
        } else {
            y += 136;
        }
        return y;
    }

    private CreativeTabs sanitizeTab(CreativeTabs tab) {
        if (tab == null) {
            return ModernCreativeTabs.BUILDING_BLOCKS;
        }
        CreativeTabs[] modernTabs = getModernTabs();
        for (CreativeTabs modern : modernTabs) {
            if (modern == tab) {
                return tab;
            }
        }
        // Map vanilla tabs
        if (tab == CreativeTabs.tabBlock) return ModernCreativeTabs.BUILDING_BLOCKS;
        if (tab == CreativeTabs.tabDecorations) return ModernCreativeTabs.BUILDING_BLOCKS;
        if (tab == CreativeTabs.tabRedstone) return ModernCreativeTabs.REDSTONE_BLOCKS;
        if (tab == CreativeTabs.tabTransport) return ModernCreativeTabs.FUNCTIONAL_BLOCKS;
        if (tab == CreativeTabs.tabMisc) return ModernCreativeTabs.FUNCTIONAL_BLOCKS;
        if (tab == CreativeTabs.tabFood) return ModernCreativeTabs.FOOD_AND_DRINKS;
        if (tab == CreativeTabs.tabTools) return ModernCreativeTabs.TOOLS;
        if (tab == CreativeTabs.tabCombat) return ModernCreativeTabs.COMBAT;
        if (tab == CreativeTabs.tabBrewing) return ModernCreativeTabs.FOOD_AND_DRINKS;
        if (tab == CreativeTabs.tabMaterials) return ModernCreativeTabs.INGREDIENTS;

        return ModernCreativeTabs.BUILDING_BLOCKS;
    }

    @Inject(method = "func_147050_b", at = @At("HEAD"), cancellable = true)
    private void onSelectTab(CreativeTabs tab, CallbackInfo ci) {
        CreativeTabs sanitized = sanitizeTab(tab);
        if (sanitized != tab) {
            ci.cancel();
            this.func_147050_b(sanitized);
        }
    }

    @Inject(method = "func_147049_a", at = @At("HEAD"), cancellable = true)
    private void onCheckTabClicked(CreativeTabs tab, int relativeX, int relativeY, CallbackInfoReturnable<Boolean> cir) {
        int index = getModernTabIndex(tab);
        if (index == -1) {
            cir.setReturnValue(false);
            return;
        }
        int x = getTabX(index);
        int y = getTabY(index);
        cir.setReturnValue(relativeX >= x && relativeX <= x + 26 && relativeY >= y && relativeY <= y + 32);
    }

    @Inject(method = "func_147052_b", at = @At("HEAD"), cancellable = true)
    private void cancelVanillaTabHover(CreativeTabs tab, int mouseX, int mouseY, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "func_147051_a", at = @At("HEAD"), cancellable = true)
    private void cancelVanillaDrawTab(CreativeTabs tab, CallbackInfo ci) {
        ci.cancel();
    }

    private void drawModernTab(CreativeTabs tab) {
        int index = getModernTabIndex(tab);
        if (index == -1) return;

        boolean isSelected = tab.getTabIndex() == selectedTabIndex;
        boolean isTop = index < 7;
        int col = index < 7 ? index : index - 7;

        int u;
        if (col == 0) u = 0;
        else if (col == 6) u = 140;
        else u = 28;

        int v = 0;
        if (isSelected) {
            v += 32;
        }
        if (!isTop) {
            v += 64;
        }

        int tabX = getTabX(index);
        int tabY = getTabY(index);

        int drawX = this.guiLeft + tabX;
        int drawY = this.guiTop + tabY;

        org.lwjgl.opengl.GL11.glDisable(org.lwjgl.opengl.GL11.GL_LIGHTING);
        org.lwjgl.opengl.GL11.glEnable(org.lwjgl.opengl.GL11.GL_BLEND);
        org.lwjgl.opengl.GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new net.minecraft.util.ResourceLocation("textures/gui/container/creative_inventory/tabs.png"));
        this.drawTexturedModalRect(drawX, drawY, u, v, 28, 32);

        this.zLevel = 100.0F;
        itemRender.zLevel = 100.0F;
        int iconX = drawX + 6;
        int iconY = drawY + 8 + (isTop ? 1 : -1);
        org.lwjgl.opengl.GL11.glEnable(org.lwjgl.opengl.GL11.GL_LIGHTING);
        org.lwjgl.opengl.GL11.glEnable(org.lwjgl.opengl.GL12.GL_RESCALE_NORMAL);
        ItemStack iconStack = tab.getIconItemStack();
        if (iconStack != null) {
            itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), iconStack, iconX, iconY);
            itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), iconStack, iconX, iconY);
        }
        org.lwjgl.opengl.GL11.glDisable(org.lwjgl.opengl.GL11.GL_LIGHTING);
        itemRender.zLevel = 0.0F;
        this.zLevel = 0.0F;
    }

    @Inject(method = "drawGuiContainerBackgroundLayer", at = @At("TAIL"))
    private void drawModernTabs(float partialTicks, int mouseX, int mouseY, CallbackInfo ci) {
        for (CreativeTabs tab : getModernTabs()) {
            if (tab != null && tab.getTabIndex() != selectedTabIndex) {
                drawModernTab(tab);
            }
        }
        for (CreativeTabs tab : getModernTabs()) {
            if (tab != null && tab.getTabIndex() == selectedTabIndex) {
                drawModernTab(tab);
            }
        }
    }

    @Inject(method = "drawScreen", at = @At("TAIL"))
    private void drawModernTabHoverText(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        for (CreativeTabs tab : getModernTabs()) {
            if (tab != null) {
                int index = getModernTabIndex(tab);
                int tabX = getTabX(index) + this.guiLeft;
                int tabY = getTabY(index) + this.guiTop;
                if (mouseX >= tabX + 3 && mouseX <= tabX + 23 && mouseY >= tabY + 3 && mouseY <= tabY + 27) {
                    this.drawCreativeTabHoveringText(net.minecraft.client.resources.I18n.format(tab.getTranslatedTabLabel()), mouseX, mouseY);
                    break;
                }
            }
        }
    }

    @Inject(method = "initGui", at = @At("TAIL"))
    private void onInitGuiTail(CallbackInfo ci) {
        maxPages = 0;
        java.util.Iterator iterator = this.buttonList.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj instanceof GuiButton) {
                GuiButton button = (GuiButton) obj;
                if (button.id == 101 || button.id == 102) {
                    iterator.remove();
                }
            }
        }
    }

    @Shadow(remap = false)
    private void func_147050_b(CreativeTabs tab) {}
}
