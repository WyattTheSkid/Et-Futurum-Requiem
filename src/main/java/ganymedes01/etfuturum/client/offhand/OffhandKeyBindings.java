package ganymedes01.etfuturum.client.offhand;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public final class OffhandKeyBindings {
	public static final KeyBinding SWAP_HANDS = new KeyBinding("key.etfuturum.offhand.swap", Keyboard.KEY_F, "key.categories.inventory");

	private OffhandKeyBindings() {
	}

	public static void register() {
		ClientRegistry.registerKeyBinding(SWAP_HANDS);
	}
}
