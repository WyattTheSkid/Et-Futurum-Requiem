package ganymedes01.etfuturum.client.renderer.item;

import ganymedes01.etfuturum.client.model.ModelTrident;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import ganymedes01.etfuturum.entities.EntityDrowned;
import ganymedes01.etfuturum.client.renderer.entity.DrownedRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class ItemTridentRenderer implements IItemRenderer {

	private static final float ARM_RENDER_SCALE = 0.0625F;

	// Third-person throwing/charging. This is close to correct; keep it independent from idle tuning.
	private static final float TP_THROW_HAND_X = -0.08F;
	private static final float TP_THROW_HAND_Y = 0.42F;
	private static final float TP_THROW_HAND_Z = 0.06F;

	private static final float TP_THROW_GRIP_X = 0.0F;
	private static final float TP_THROW_GRIP_Y = -0.65F;
	private static final float TP_THROW_GRIP_Z = 0.0F;

	private static final float TP_THROW_ROT_X = -95.0F;
	private static final float TP_THROW_ROT_Y = 90.0F;
	private static final float TP_THROW_ROT_Z = 0.0F;

	private static final float TP_THROW_SCALE = 0.75F;

	// Third-person idle. Tune independently from the throw transform.
	private static final float TP_IDLE_HAND_X = -0.08F;
	private static final float TP_IDLE_HAND_Y = 0.42F;
	private static final float TP_IDLE_HAND_Z = 0.06F;

	private static final float TP_IDLE_GRIP_X = 0.0F;
	private static final float TP_IDLE_GRIP_Y = -0.65F;
	private static final float TP_IDLE_GRIP_Z = 0.0F;

	private static final float TP_IDLE_ROT_X = -20.0F;
	private static final float TP_IDLE_ROT_Y = 0.0F;
	private static final float TP_IDLE_ROT_Z = -35.0F;

	private static final float TP_IDLE_SCALE = 0.75F;

	// Drowned third-person held trident constants (can be independently modified)
	public static float DROWNED_IDLE_HAND_X = 0.0625F;
	public static float DROWNED_IDLE_HAND_Y = 0.125F;
	public static float DROWNED_IDLE_HAND_Z = -0.625F;
	
	public static float DROWNED_IDLE_JSON_X = 11.0F / 16.0F;
	public static float DROWNED_IDLE_JSON_Y = 17.0F / 16.0F;
	public static float DROWNED_IDLE_JSON_Z = -2.0F / 16.0F;
	
	public static float DROWNED_IDLE_ROT_X = 0.0F;
	public static float DROWNED_IDLE_ROT_Y = 60.0F;
	public static float DROWNED_IDLE_ROT_Z = 0.0F;
	
	public static float DROWNED_IDLE_GRIP_X = 0.0F;
	public static float DROWNED_IDLE_GRIP_Y = -0.625F;
	public static float DROWNED_IDLE_GRIP_Z = 0.0F;
	
	public static float DROWNED_IDLE_SCALE = 1.0F;

	public static float DROWNED_THROW_HAND_X = -0.08F;
	public static float DROWNED_THROW_HAND_Y = 0.42F;
	public static float DROWNED_THROW_HAND_Z = 0.06F;
	
	public static float DROWNED_THROW_ROT_X = -95.0F;
	public static float DROWNED_THROW_ROT_Y = 90.0F;
	public static float DROWNED_THROW_ROT_Z = 0.0F;
	
	public static float DROWNED_THROW_GRIP_X = 0.0F;
	public static float DROWNED_THROW_GRIP_Y = -0.65F;
	public static float DROWNED_THROW_GRIP_Z = 0.0F;
	
	public static float DROWNED_THROW_SCALE = 0.75F;

	// First-person idle. Camera/held-item space, not ModelBiped arm space.
	private static final float FP_IDLE_X = 0.0F;
	private static final float FP_IDLE_Y = -0.3F;
	private static final float FP_IDLE_Z = 0.85F;

	private static final float FP_IDLE_ROT_X = -5.0F;
	private static final float FP_IDLE_ROT_Y = 75.0F;
	private static final float FP_IDLE_ROT_Z = -10.0F;

	private static final float FP_IDLE_GRIP_X = 0.0F;
	private static final float FP_IDLE_GRIP_Y = 0.0F;
	private static final float FP_IDLE_GRIP_Z = 0.0F;

	private static final float FP_IDLE_SCALE = 2.0F;

	// First-person throwing/charging. Camera/held-item space, not ModelBiped arm space.
	private static final float FP_THROW_X = -1.5F;
	private static final float FP_THROW_Y = 2.2F;
	private static final float FP_THROW_Z = 1.15F;

	private static final float FP_THROW_ROT_X = -90.0F;
	private static final float FP_THROW_ROT_Y = -60.0F;
	private static final float FP_THROW_ROT_Z = -90.0F;

	private static final float FP_THROW_GRIP_X = 0.0F;
	private static final float FP_THROW_GRIP_Y = 0.0F;
	private static final float FP_THROW_GRIP_Z = 0.0F;

	private static final float FP_THROW_SCALE = 2.0F;

	public static final boolean DEBUG_TRIDENT_RENDERING = true;
	private static long lastDebugPrintTime = 0;

	private static void logRender(String context, ItemRenderType type, EntityLivingBase entity, ItemStack stack, boolean throwing, String pathApplied) {
		if (!DEBUG_TRIDENT_RENDERING) return;
		long now = System.currentTimeMillis();
		if (now - lastDebugPrintTime >= 2000) {
			lastDebugPrintTime = now;
			String entityInfo = "null";
			int useCount = 0;
			boolean isUsing = false;
			if (entity != null) {
				entityInfo = entity.getClass().getName();
				if (entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) entity;
					isUsing = player.getItemInUse() == stack;
					useCount = player.getItemInUseCount();
				}
			}
			System.out.println(String.format(
				"[TridentRender] context=%s, type=%s, entity=%s, stack=%s, isUsing=%b, useCount=%d, throwing=%b, path=%s",
				context,
				type != null ? type.name() : "null",
				entityInfo,
				stack != null ? stack.toString() : "null",
				isUsing,
				useCount,
				throwing,
				pathApplied
			));
		}
	}

	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/trident.png");
	private static final ModelTrident MODEL = new ModelTrident();

	@Override
	public boolean handleRenderType(ItemStack stack, ItemRenderType type) {
		return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack stack, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
		EntityLivingBase entity = null;

		if (data != null) {
			for (Object obj : data) {
				if (obj instanceof EntityLivingBase) {
					entity = (EntityLivingBase) obj;
					break;
				}
			}
		}

		boolean throwing = isUsingTrident(entity, stack);
		String pathApplied = "NONE";
		switch (type) {
			case EQUIPPED_FIRST_PERSON:
				pathApplied = throwing ? "FIRST_PERSON_THROW" : "FIRST_PERSON_IDLE";
				break;
			case EQUIPPED:
				pathApplied = throwing ? "THIRD_PERSON_THROW" : "THIRD_PERSON_IDLE";
				break;
			case ENTITY:
				pathApplied = "ENTITY_DROPPED";
				break;
			case INVENTORY:
				pathApplied = "INVENTORY";
				break;
			default:
				pathApplied = "GENERIC";
				break;
		}
		logRender("ItemRenderer", type, entity, stack, throwing, pathApplied);

		GL11.glPushMatrix();

		switch (type) {
			case INVENTORY:
				renderInventoryTrident(stack);
				break;
			case ENTITY:
				renderDroppedTrident(stack);
				break;
			case EQUIPPED_FIRST_PERSON:
				renderFirstPersonTrident(stack, entity, throwing);
				break;
			case EQUIPPED:
				renderThirdPersonTrident(stack, entity, throwing);
				break;
			default:
				renderGenericTrident(stack);
				break;
		}

		GL11.glPopMatrix();
	}

	public static void renderHeldTrident(ModelBiped modelBiped, EntityPlayer player, ItemStack stack) {
		boolean throwing = isUsingTrident(player, stack);
		logRender("MixinRenderPlayer", ItemRenderType.EQUIPPED, player, stack, throwing, throwing ? "THIRD_PERSON_THROW" : "THIRD_PERSON_IDLE");
		renderThirdPersonTrident(stack, player, throwing, modelBiped);
	}

	private static void renderThirdPersonTrident(ItemStack stack, EntityLivingBase entity, boolean throwing) {
		if (!(entity instanceof EntityPlayer)) {
			applyGenericEquippedTransform();
			renderTridentModel(stack);
			return;
		}

		// Player-held tridents are rendered from MixinRenderPlayer, where the active ModelBiped is available before vanilla item transforms.
	}

	private static void renderThirdPersonTrident(ItemStack stack, EntityPlayer player, boolean throwing, ModelBiped modelBiped) {
		if (modelBiped == null) {
			return;
		}

		GL11.glPushMatrix();

		modelBiped.bipedRightArm.postRender(ARM_RENDER_SCALE);
		if (throwing) {
			applyThirdPersonThrowingTransform();
		} else {
			applyThirdPersonIdleTransform();
		}

		renderTridentModel(stack);

		GL11.glPopMatrix();
	}

	private static void renderFirstPersonTrident(ItemStack stack, EntityLivingBase entity, boolean throwing) {
		GL11.glPushMatrix();

		if (throwing) {
			applyFirstPersonThrowTransform(entity, stack);
		} else {
			applyFirstPersonIdleTransform();
		}

		renderTridentModel(stack);

		GL11.glPopMatrix();
	}

	private static void renderDroppedTrident(ItemStack stack) {
		GL11.glScalef(0.8F, -0.8F, -0.8F);
		renderTridentModel(stack);
	}

	private static void renderInventoryTrident(ItemStack stack) {
		GL11.glTranslatef(8.0F, 8.0F, 0.0F);
		GL11.glRotatef(-45.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(15.0F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(8.0F, -8.0F, 8.0F);
		renderTridentModel(stack);
	}

	private static void renderGenericTrident(ItemStack stack) {
		renderTridentModel(stack);
	}

	private static void renderTridentModel(ItemStack stack) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		MODEL.renderer();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	}

	private static boolean isUsingTrident(EntityLivingBase entity, ItemStack stack) {
		if (entity instanceof EntityPlayer) {
			return stack != null && ((EntityPlayer) entity).getItemInUse() == stack;
		}
		if (entity instanceof EntityDrowned) {
			return stack != null && ((EntityDrowned) entity).getAttackTarget() != null;
		}
		return false;
	}

	private static void applyThirdPersonIdleTransform() {
		// 1. Standard item pre-transforms from HeldItemLayer:
		GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.0625F, 0.125F, -0.625F);

		// 2. Apply JSON display transform (thirdperson_righthand):
		// Translation from JSON: [ 11, 17, -2 ]
		GL11.glTranslatef(11.0F / 16.0F, 17.0F / 16.0F, -2.0F / 16.0F);
		// Rotation from JSON: [ 0, 60, 0 ]
		GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);

		// 3. Translate by [-0.5, -0.5, -0.5]
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

		// 4. Scale by [1.0, -1.0, -1.0]
		GL11.glScalef(1.0F, -1.0F, -1.0F);
	}

	private static void applyThirdPersonThrowingTransform() {
		GL11.glTranslatef(TP_THROW_HAND_X, TP_THROW_HAND_Y, TP_THROW_HAND_Z);
		GL11.glRotatef(TP_THROW_ROT_X, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(TP_THROW_ROT_Y, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(TP_THROW_ROT_Z, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(TP_THROW_GRIP_X, TP_THROW_GRIP_Y, TP_THROW_GRIP_Z);
		GL11.glScalef(TP_THROW_SCALE, TP_THROW_SCALE, TP_THROW_SCALE);
	}

	private static void applyFirstPersonIdleTransform() {
		// Undo vanilla ItemRenderer.renderItem transforms to restore the clean hand coordinate space:
		GL11.glTranslatef(0.9375F, 0.0625F, 0.0F);
		GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.0F / 1.5F, 1.0F / 1.5F, 1.0F / 1.5F);
		GL11.glTranslatef(0.0F, 0.3F, 0.0F);

		// Scale the coordinate system to match modern Minecraft (canceling the 0.4F first-person hand scale):
		GL11.glScalef(2.5F, 2.5F, 2.5F);

		// Now apply modern vanilla first person transforms:
		// 1. Apply JSON display transform (firstperson_righthand):
		// Translation from JSON: [ -3, 17, 1 ]
		GL11.glTranslatef(-3.0F / 16.0F, 17.0F / 16.0F, 1.0F / 16.0F);
		// Rotation from JSON: [ 0, -90, 25 ]
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);

		// 2. Translate by [-0.5, -0.5, -0.5]
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

		// 3. Scale by [1.0, -1.0, -1.0]
		GL11.glScalef(1.0F, -1.0F, -1.0F);
	}

	private static void applyFirstPersonThrowTransform(EntityLivingBase entity, ItemStack stack) {
		// Undo vanilla ItemRenderer.renderItem transforms to restore the clean hand coordinate space:
		GL11.glTranslatef(0.9375F, 0.0625F, 0.0F);
		GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.0F / 1.5F, 1.0F / 1.5F, 1.0F / 1.5F);
		GL11.glTranslatef(0.0F, 0.3F, 0.0F);

		// Scale the coordinate system to match modern Minecraft (canceling the 0.4F first-person hand scale):
		GL11.glScalef(2.5F, 2.5F, 2.5F);

		// 1. First Person SPEAR action pre-transform (from FirstPersonRenderer.java):
		GL11.glTranslatef(-0.5F, 0.7F, 0.1F);
		GL11.glRotatef(-55.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(35.3F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-9.785F, 0.0F, 0.0F, 1.0F);

		// Calculate charge progress dynamically:
		float f11 = 0.0F;
		float f7 = 0.0F;
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			float partialTicks = Minecraft.getMinecraft().timer.renderPartialTicks;
			f7 = (float)stack.getMaxItemUseDuration() - ((float)player.getItemInUseCount() - partialTicks + 1.0F);
			f11 = f7 / 10.0F;
			if (f11 > 1.0F) {
				f11 = 1.0F;
			}
			if (f11 < 0.0F) {
				f11 = 0.0F;
			}
		}

		float f19 = 0.0F;
		if (f11 > 0.1F) {
			float f14 = MathHelper.sin((f7 - 0.1F) * 1.3F);
			float f17 = f11 - 0.1F;
			f19 = f14 * f17;
		}

		GL11.glTranslatef(0.0F, f19 * 0.004F, 0.0F);
		GL11.glTranslatef(0.0F, 0.0F, f11 * 0.2F);
		GL11.glScalef(1.0F, 1.0F, 1.0F + f11 * 0.2F);
		GL11.glRotatef(f11 * 45.0F, 0.0F, -1.0F, 0.0F); // Rotate Y by -f11 * 45.0F

		// 2. Apply JSON display transform (firstperson_righthand):
		// Translation from JSON: [ -3, 17, 1 ]
		GL11.glTranslatef(-3.0F / 16.0F, 17.0F / 16.0F, 1.0F / 16.0F);
		// Rotation from JSON: [ 0, -90, 25 ]
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);

		// 3. Translate by [-0.5, -0.5, -0.5]
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

		// 4. Scale by [1.0, -1.0, -1.0]
		GL11.glScalef(1.0F, -1.0F, -1.0F);
	}

	private static void applyGenericEquippedTransform() {
		GL11.glTranslatef(-0.2F, 1.0F, 0.875F);
		GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(18.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-10.0F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.75F, 0.75F, 0.75F);
	}

	public static void renderDrownedTrident(ModelBiped modelBiped, EntityLivingBase drowned, ItemStack stack) {
		boolean throwing = isUsingTrident(drowned, stack);
		
		if (DrownedRenderer.DEBUG_DROWNED_TRIDENT) {
			System.out.println("[DrownedDebug] ItemTridentRenderer received renderDrownedTrident, throwing=" + throwing);
		}

		GL11.glPushMatrix();

		if (throwing) {
			applyDrownedThirdPersonThrowTransform();
		} else {
			applyDrownedThirdPersonIdleTransform();
		}

		renderTridentModel(stack);

		GL11.glPopMatrix();
	}

	private static void applyDrownedThirdPersonIdleTransform() {
		// 1. Standard item pre-transforms from HeldItemLayer:
		GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(DROWNED_IDLE_HAND_X, DROWNED_IDLE_HAND_Y, DROWNED_IDLE_HAND_Z);

		// 2. Apply JSON display transform (thirdperson_righthand):
		GL11.glTranslatef(DROWNED_IDLE_JSON_X, DROWNED_IDLE_JSON_Y, DROWNED_IDLE_JSON_Z);
		GL11.glRotatef(DROWNED_IDLE_ROT_X, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(DROWNED_IDLE_ROT_Y, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(DROWNED_IDLE_ROT_Z, 0.0F, 0.0F, 1.0F);
		
		// 3. Translation to grip point & scale:
		GL11.glTranslatef(DROWNED_IDLE_GRIP_X, DROWNED_IDLE_GRIP_Y, DROWNED_IDLE_GRIP_Z);
		GL11.glScalef(DROWNED_IDLE_SCALE, -DROWNED_IDLE_SCALE, -DROWNED_IDLE_SCALE);
	}

	private static void applyDrownedThirdPersonThrowTransform() {
		GL11.glTranslatef(DROWNED_THROW_HAND_X, DROWNED_THROW_HAND_Y, DROWNED_THROW_HAND_Z);
		GL11.glRotatef(DROWNED_THROW_ROT_X, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(DROWNED_THROW_ROT_Y, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(DROWNED_THROW_ROT_Z, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(DROWNED_THROW_GRIP_X, DROWNED_THROW_GRIP_Y, DROWNED_THROW_GRIP_Z);
		GL11.glScalef(DROWNED_THROW_SCALE, DROWNED_THROW_SCALE, DROWNED_THROW_SCALE);
	}
}
