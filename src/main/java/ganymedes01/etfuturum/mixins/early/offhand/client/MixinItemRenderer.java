package ganymedes01.etfuturum.mixins.early.offhand.client;

import ganymedes01.etfuturum.client.offhand.OffhandClientCache;
import ganymedes01.etfuturum.client.offhand.OffhandItemRendererAccess;
import ganymedes01.etfuturum.configuration.configs.ConfigFunctions;
import ganymedes01.etfuturum.offhand.Hand;
import ganymedes01.etfuturum.offhand.IOffhandEntity;
import ganymedes01.etfuturum.offhand.OffhandInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer implements OffhandItemRendererAccess {
	@Unique
	private static final ResourceLocation ETFU$MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");

	@Shadow
	private Minecraft mc;
	@Shadow
	private ItemStack itemToRender;
	@Shadow
	private float equippedProgress;
	@Shadow
	private float prevEquippedProgress;

	@Unique
	private ItemRenderer etfu$offhandFirstPersonRenderer;
	@Unique
	private static boolean etfu$renderingOffhand;
	@Unique
	private static boolean etfu$updatingOffhandRenderer;

	@Override
	public float etfu$getEquippedProgress() {
		return equippedProgress;
	}

	@Override
	public float etfu$getPrevEquippedProgress() {
		return prevEquippedProgress;
	}

	@Unique
	private ItemRenderer etfu$getOffhandFirstPersonRenderer() {
		if (etfu$offhandFirstPersonRenderer == null) {
			etfu$offhandFirstPersonRenderer = new ItemRenderer(mc);
		}
		return etfu$offhandFirstPersonRenderer;
	}

	@Unique
	private boolean etfu$isOffhandActive(EntityClientPlayerMP player) {
		return player instanceof IOffhandEntity && ((IOffhandEntity) player).etfu$getActiveHand() == Hand.OFF_HAND;
	}

	@Unique
	private boolean etfu$isActiveOffhandBow(EntityClientPlayerMP player) {
		ItemStack offhand = OffhandInventory.getOffhandStack(player);
		return etfu$isOffhandActive(player) && offhand != null && offhand.getItem() != null && offhand.getItemUseAction() == EnumAction.bow;
	}

	@Unique
	private boolean etfu$isFilledMap(ItemStack stack) {
		return stack != null && stack.getItem() instanceof ItemMap;
	}

	@Inject(method = "renderItemInFirstPerson", at = @At("HEAD"), cancellable = true)
	private void etfu$renderOccupiedMainHandMap(float partialTicks, CallbackInfo ci) {
		if (etfu$renderingOffhand || !ConfigFunctions.offhandFirstPersonRender || mc.thePlayer == null) return;

		ItemStack offhandStack = OffhandInventory.getOffhandStack(mc.thePlayer);
		if (etfu$isFilledMap(itemToRender) && offhandStack != null) {
			etfu$renderMainHandMapWithOffhand(partialTicks, itemToRender, offhandStack);
			ci.cancel();
		}
	}

	@Inject(method = "renderItemInFirstPerson", at = @At("RETURN"))
	private void etfu$renderOffhandItemInFirstPerson(float partialTicks, CallbackInfo ci) {
		if (etfu$renderingOffhand || !ConfigFunctions.offhandFirstPersonRender || mc.thePlayer == null) return;

		ItemStack offhandStack = OffhandInventory.getOffhandStack(mc.thePlayer);
		if (offhandStack == null) return;
		if (etfu$isFilledMap(offhandStack)) {
			etfu$renderOffhandMapSide(partialTicks, offhandStack);
			return;
		}

		etfu$renderOffhandVanilla(partialTicks);
	}

	@Unique
	private void etfu$renderOffhandVanilla(float partialTicks) {
		if (mc.thePlayer == null) return;

		EntityClientPlayerMP player = mc.thePlayer;
		int previousSlot = player.inventory.currentItem;
		boolean cullEnabled = GL11.glIsEnabled(GL11.GL_CULL_FACE);
		int previousCullFace = GL11.glGetInteger(GL11.GL_CULL_FACE_MODE);

		GL11.glPushMatrix();
		try {
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glCullFace(GL11.GL_FRONT);
			GL11.glScalef(-1.0F, 1.0F, 1.0F);

			float armPitch = player.prevRenderArmPitch + (player.renderArmPitch - player.prevRenderArmPitch) * partialTicks;
			float armYaw = player.prevRenderArmYaw + (player.renderArmYaw - player.prevRenderArmYaw) * partialTicks;
			GL11.glRotatef((player.rotationPitch - armPitch) * -0.1F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef((player.rotationYaw - armYaw) * -0.1F, 0.0F, 1.0F, 0.0F);

			etfu$renderingOffhand = true;
			player.inventory.currentItem = OffhandInventory.OFFHAND_INVENTORY_INDEX;
			etfu$getOffhandFirstPersonRenderer().renderItemInFirstPerson(partialTicks);
		} finally {
			player.inventory.currentItem = previousSlot;
			etfu$renderingOffhand = false;
			GL11.glCullFace(previousCullFace);
			if (!cullEnabled) {
				GL11.glDisable(GL11.GL_CULL_FACE);
			}
			GL11.glPopMatrix();
		}
	}

	@Unique
	private void etfu$renderMainHandMapWithOffhand(float partialTicks, ItemStack mainStack, ItemStack offhandStack) {
		EntityClientPlayerMP player = mc.thePlayer;
		etfu$setupFirstPersonRender(partialTicks, mainStack);
		etfu$renderRightMapFirstPersonSide(etfu$getMainEquipProgress(partialTicks), player.getSwingProgress(partialTicks), mainStack);
		etfu$finishFirstPersonRender();

		if (etfu$isFilledMap(offhandStack)) {
			etfu$renderOffhandMapSide(partialTicks, offhandStack);
		} else {
			etfu$renderOffhandVanilla(partialTicks);
		}
	}

	@Unique
	private void etfu$renderOffhandMapSide(float partialTicks, ItemStack stack) {
		EntityClientPlayerMP player = mc.thePlayer;
		int previousSlot = player.inventory.currentItem;
		boolean cullEnabled = GL11.glIsEnabled(GL11.GL_CULL_FACE);
		int previousCullFace = GL11.glGetInteger(GL11.GL_CULL_FACE_MODE);

		GL11.glPushMatrix();
		try {
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glCullFace(GL11.GL_FRONT);
			GL11.glScalef(-1.0F, 1.0F, 1.0F);

			float armPitch = player.prevRenderArmPitch + (player.renderArmPitch - player.prevRenderArmPitch) * partialTicks;
			float armYaw = player.prevRenderArmYaw + (player.renderArmYaw - player.prevRenderArmYaw) * partialTicks;
			GL11.glRotatef((player.rotationPitch - armPitch) * -0.1F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef((player.rotationYaw - armYaw) * -0.1F, 0.0F, 1.0F, 0.0F);

			etfu$renderingOffhand = true;
			player.inventory.currentItem = OffhandInventory.OFFHAND_INVENTORY_INDEX;
			etfu$setupFirstPersonRender(partialTicks, stack);
			etfu$renderRightMapFirstPersonSide(etfu$getOffhandEquipProgress(partialTicks), etfu$getOffhandSwingProgressValue(player, partialTicks), stack);
			etfu$finishFirstPersonRender();
		} finally {
			player.inventory.currentItem = previousSlot;
			etfu$renderingOffhand = false;
			GL11.glCullFace(previousCullFace);
			if (!cullEnabled) {
				GL11.glDisable(GL11.GL_CULL_FACE);
			}
			GL11.glPopMatrix();
		}
	}

	@Unique
	private float etfu$getMainEquipProgress(float partialTicks) {
		return 1.0F - (prevEquippedProgress + (equippedProgress - prevEquippedProgress) * partialTicks);
	}

	@Unique
	private float etfu$getOffhandEquipProgress(float partialTicks) {
		OffhandItemRendererAccess access = (OffhandItemRendererAccess) etfu$getOffhandFirstPersonRenderer();
		return 1.0F - (access.etfu$getPrevEquippedProgress() + (access.etfu$getEquippedProgress() - access.etfu$getPrevEquippedProgress()) * partialTicks);
	}

	@Unique
	private float etfu$getOffhandSwingProgressValue(EntityClientPlayerMP player, float partialTicks) {
		if (player instanceof IOffhandEntity) {
			return ((IOffhandEntity) player).etfu$getOffhandSwingProgress(partialTicks);
		}
		return 0.0F;
	}

	@Unique
	private void etfu$setupFirstPersonRender(float partialTicks, ItemStack stack) {
		EntityClientPlayerMP player = mc.thePlayer;
		float pitch = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * partialTicks;
		float yaw = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * partialTicks;
		GL11.glPushMatrix();
		GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();

		EntityPlayerSP playerSP = (EntityPlayerSP) player;
		float armPitch = playerSP.prevRenderArmPitch + (playerSP.renderArmPitch - playerSP.prevRenderArmPitch) * partialTicks;
		float armYaw = playerSP.prevRenderArmYaw + (playerSP.renderArmYaw - playerSP.prevRenderArmYaw) * partialTicks;
		GL11.glRotatef((player.rotationPitch - armPitch) * 0.1F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef((player.rotationYaw - armYaw) * 0.1F, 0.0F, 1.0F, 0.0F);

		int light = mc.theWorld.getLightBrightnessForSkyBlocks(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ), 0);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) (light % 65536), (float) (light / 65536));

		if (stack != null && stack.getItem() != null) {
			int color = stack.getItem().getColorFromItemStack(stack, 0);
			GL11.glColor4f((float) (color >> 16 & 255) / 255.0F, (float) (color >> 8 & 255) / 255.0F, (float) (color & 255) / 255.0F, 1.0F);
		} else {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	}

	@Unique
	private void etfu$finishFirstPersonRender() {
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.disableStandardItemLighting();
	}

	@Unique
	private void etfu$renderRightMapFirstPersonSide(float equipProgress, float swingProgress, ItemStack stack) {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.125F, -0.125F, 0.0F);

		if (!mc.thePlayer.isInvisible()) {
			GL11.glPushMatrix();
			GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
			etfu$renderRightArmFirstPerson(equipProgress, swingProgress);
			GL11.glPopMatrix();
		}

		GL11.glPushMatrix();
		GL11.glTranslatef(0.51F, -0.08F + equipProgress * -1.2F, -0.75F);
		float swingRoot = MathHelper.sqrt_float(swingProgress);
		float swingSin = MathHelper.sin(swingRoot * (float) Math.PI);
		float xOffset = -0.5F * swingSin;
		float yOffset = 0.4F * MathHelper.sin(swingRoot * ((float) Math.PI * 2.0F));
		float zOffset = -0.3F * MathHelper.sin(swingProgress * (float) Math.PI);
		GL11.glTranslatef(xOffset, yOffset - 0.3F * swingSin, zOffset);
		GL11.glRotatef(swingSin * -45.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(swingSin * -30.0F, 0.0F, 1.0F, 0.0F);
		etfu$renderMapFirstPerson(stack);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	@Unique
	private void etfu$renderRightArmFirstPerson(float equipProgress, float swingProgress) {
		float swingRoot = MathHelper.sqrt_float(swingProgress);
		float xOffset = -0.3F * MathHelper.sin(swingRoot * (float) Math.PI);
		float yOffset = 0.4F * MathHelper.sin(swingRoot * ((float) Math.PI * 2.0F));
		float zOffset = -0.4F * MathHelper.sin(swingProgress * (float) Math.PI);
		GL11.glTranslatef(xOffset + 0.64000005F, yOffset - 0.6F + equipProgress * -0.6F, zOffset - 0.71999997F);
		GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
		float swingSinSquared = MathHelper.sin(swingProgress * swingProgress * (float) Math.PI);
		float swingSin = MathHelper.sin(swingRoot * (float) Math.PI);
		GL11.glRotatef(swingSin * 70.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(swingSinSquared * -20.0F, 0.0F, 0.0F, 1.0F);
		mc.getTextureManager().bindTexture(mc.thePlayer.getLocationSkin());
		GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
		GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(5.6F, 0.0F, 0.0F);
		Render render = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
		RenderPlayer renderPlayer = (RenderPlayer) render;
		GL11.glDisable(GL11.GL_CULL_FACE);
		renderPlayer.renderFirstPersonArm(mc.thePlayer);
		GL11.glEnable(GL11.GL_CULL_FACE);
	}

	@Unique
	private void etfu$renderMapFirstPerson(ItemStack stack) {
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.38F, 0.38F, 0.38F);
		GL11.glDisable(GL11.GL_LIGHTING);
		mc.getTextureManager().bindTexture(ETFU$MAP_BACKGROUND);
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
		GL11.glScalef(0.0078125F, 0.0078125F, 0.0078125F);
		GL11.glNormal3f(0.0F, 0.0F, -1.0F);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0D, 135.0D, 0.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(135.0D, 135.0D, 0.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(135.0D, -7.0D, 0.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(-7.0D, -7.0D, 0.0D, 0.0D, 0.0D);
		tessellator.draw();

		IItemRenderer custom = MinecraftForgeClient.getItemRenderer(stack, IItemRenderer.ItemRenderType.FIRST_PERSON_MAP);
		MapData mapData = ((ItemMap) stack.getItem()).getMapData(stack, mc.theWorld);
		if (custom == null) {
			if (mapData != null) {
				mc.entityRenderer.getMapItemRenderer().func_148250_a(mapData, false);
			}
		} else {
			custom.renderItem(IItemRenderer.ItemRenderType.FIRST_PERSON_MAP, stack, mc.thePlayer, mc.getTextureManager(), mapData);
		}

		GL11.glEnable(GL11.GL_LIGHTING);
	}

	@Inject(method = "updateEquippedItem", at = @At("TAIL"))
	private void etfu$updateOffhandEquippedItem(CallbackInfo ci) {
		if (etfu$updatingOffhandRenderer || mc.thePlayer == null) return;

		EntityClientPlayerMP player = mc.thePlayer;
		int previousSlot = player.inventory.currentItem;
		try {
			etfu$updatingOffhandRenderer = true;
			player.inventory.currentItem = OffhandInventory.OFFHAND_INVENTORY_INDEX;
			if (OffhandClientCache.triggerOffhandEquipReset) {
				etfu$getOffhandFirstPersonRenderer().resetEquippedProgress();
				OffhandClientCache.triggerOffhandEquipReset = false;
			}
			etfu$getOffhandFirstPersonRenderer().updateEquippedItem();
		} finally {
			player.inventory.currentItem = previousSlot;
			etfu$updatingOffhandRenderer = false;
		}
	}

	@Redirect(method = "renderItemInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityClientPlayerMP;getSwingProgress(F)F"))
	private float etfu$getOffhandSwingProgress(EntityClientPlayerMP player, float partialTicks) {
		if (etfu$renderingOffhand && player instanceof IOffhandEntity) {
			return ((IOffhandEntity) player).etfu$getOffhandSwingProgress(partialTicks);
		}
		return player.getSwingProgress(partialTicks);
	}

	@Redirect(method = "renderItemInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityClientPlayerMP;getItemInUseCount()I"))
	private int etfu$getItemInUseCountForHand(EntityClientPlayerMP player) {
		if (etfu$renderingOffhand) {
			return etfu$isOffhandActive(player) ? player.getItemInUseCount() : 0;
		}
		return etfu$isOffhandActive(player) ? 0 : player.getItemInUseCount();
	}

	@Redirect(method = "updateEquippedItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/InventoryPlayer;getCurrentItem()Lnet/minecraft/item/ItemStack;"))
	private ItemStack etfu$getCurrentItemForEquippedUpdate(InventoryPlayer inventory) {
		if (!etfu$updatingOffhandRenderer && mc.thePlayer != null && etfu$isActiveOffhandBow(mc.thePlayer)) {
			return null;
		}
		return inventory.getCurrentItem();
	}
}
