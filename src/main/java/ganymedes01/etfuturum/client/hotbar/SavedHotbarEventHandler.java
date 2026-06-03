package ganymedes01.etfuturum.client.hotbar;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public final class SavedHotbarEventHandler {
	public static final SavedHotbarEventHandler INSTANCE = new SavedHotbarEventHandler();

	private SavedHotbarEventHandler() {
	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (!Keyboard.getEventKeyState()) return;

		Minecraft mc = Minecraft.getMinecraft();
		if (mc.thePlayer == null || mc.currentScreen != null || !mc.playerController.isInCreativeMode()) return;

		boolean saveDown = Keyboard.isKeyDown(SavedHotbarKeyBindings.SAVE_HOTBAR.getKeyCode());
		boolean loadDown = Keyboard.isKeyDown(SavedHotbarKeyBindings.LOAD_HOTBAR.getKeyCode());
		if (!saveDown && !loadDown) return;

		int eventKey = Keyboard.getEventKey();
		for (int i = 0; i < HotbarSnapshot.HOTBAR_SIZE; ++i) {
			if (eventKey == mc.gameSettings.keyBindsHotbar[i].getKeyCode()) {
				if (loadDown) {
					SavedHotbarsClient.loadHotbar(mc, i);
				} else {
					SavedHotbarsClient.saveCurrentHotbar(mc, i);
				}
				return;
			}
		}
	}
}
