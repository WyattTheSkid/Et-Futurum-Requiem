package ganymedes01.etfuturum.mixins.early.offhand.client;

import net.minecraft.client.renderer.InventoryEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(InventoryEffectRenderer.class)
public interface InventoryEffectRendererAccessor {
	@Accessor("field_147045_u")
	boolean getHasActivePotionEffects();

	@Accessor("field_147045_u")
	void setHasActivePotionEffects(boolean value);
}
