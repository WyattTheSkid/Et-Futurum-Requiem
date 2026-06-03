package ganymedes01.etfuturum.client.hotbar;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public final class SavedHotbarKeyBindings {
	public static final KeyBinding SAVE_HOTBAR = new KeyBinding("key.saveToolbarActivator", Keyboard.KEY_C, "key.categories.creative");
	public static final KeyBinding LOAD_HOTBAR = new KeyBinding("key.loadToolbarActivator", Keyboard.KEY_X, "key.categories.creative");

	private SavedHotbarKeyBindings() {
	}

	public static void register() {
		ClientRegistry.registerKeyBinding(SAVE_HOTBAR);
		ClientRegistry.registerKeyBinding(LOAD_HOTBAR);
	}
}
