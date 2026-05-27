package ganymedes01.etfuturum.mixins.early.items;

import com.mojang.authlib.GameProfile;
import ganymedes01.etfuturum.client.renderer.item.ItemTridentRenderer;
import ganymedes01.etfuturum.client.renderer.tileentity.TileEntityFancySkullRenderer;
import ganymedes01.etfuturum.items.equipment.ItemTrident;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderPlayer.class)
public class MixinRenderPlayer {

    @Redirect(method = "renderEquippedItems(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V", 
              at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/tileentity/TileEntitySkullRenderer;func_152674_a(FFFIFILcom/mojang/authlib/GameProfile;)V"))
    private void etfuturum$redirectSkullRender(TileEntitySkullRenderer instance, float x, float y, float z, int direction, float rotation, int meta, GameProfile profile) {
        if (meta == 5) {
            TileEntityFancySkullRenderer.instance.renderWornDragonHead(x, y, z, direction, rotation, profile);
        } else {
            instance.func_152674_a(x, y, z, direction, rotation, meta, profile);
        }
    }

    @Inject(method = "renderEquippedItems(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/ModelRenderer;postRender(F)V", ordinal = 1))
    private void etfuturum$renderTridentInRightHand(AbstractClientPlayer player, float partialTicks, CallbackInfo ci) {
        ItemStack stack = player.inventory.getCurrentItem();
        if (stack != null && stack.getItem() instanceof ItemTrident) {
            ItemTridentRenderer.renderHeldTrident(((RenderPlayer) (Object) this).modelBipedMain, player, stack);
        }
    }
}
