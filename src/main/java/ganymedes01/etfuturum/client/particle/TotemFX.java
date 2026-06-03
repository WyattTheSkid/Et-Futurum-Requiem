package ganymedes01.etfuturum.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class TotemFX extends EntityFX {
	private static final int TEXTURE_INDEX = 176;
	private static final int TEXTURE_FRAMES = 8;
	private static final float Y_ACCEL = -0.05F;
	private static final float DRAG = 0.6F;

	public TotemFX(World world, double x, double y, double z, double mx, double my, double mz) {
		super(world, x, y, z);
		this.motionX = mx;
		this.motionY = my;
		this.motionZ = mz;
		this.particleScale *= 0.75F;
		this.particleMaxAge = 60 + this.rand.nextInt(12);

		if (this.rand.nextInt(4) == 0) {
			this.setRBGColorF(0.6F + this.rand.nextFloat() * 0.2F, 0.6F + this.rand.nextFloat() * 0.3F, this.rand.nextFloat() * 0.2F);
		} else {
			this.setRBGColorF(0.1F + this.rand.nextFloat() * 0.2F, 0.4F + this.rand.nextFloat() * 0.3F, this.rand.nextFloat() * 0.2F);
		}
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setDead();
			return;
		}

		if (this.particleAge > this.particleMaxAge / 2) {
			this.setAlphaF(1.0F - ((float) this.particleAge - (float) (this.particleMaxAge / 2)) / (float) this.particleMaxAge);
		}

		this.setParticleTextureIndex(TEXTURE_INDEX + (TEXTURE_FRAMES - 1 - this.particleAge * TEXTURE_FRAMES / this.particleMaxAge));
		this.motionY += Y_ACCEL;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= DRAG;
		this.motionY *= DRAG;
		this.motionZ *= DRAG;

		if (this.isCollided) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}
	}

	@Override
	public int getBrightnessForRender(float partialTicks) {
		return 15728880;
	}
}
