package ganymedes01.etfuturum.client.particle;

import net.minecraft.world.World;

public class TotemFX extends EtFuturumFXParticle {

	public TotemFX(World world, double x, double y, double z, double mx, double my, double mz) {
		super(world, x, y, z, mx, my, mz, 60 + CustomParticles.rand.nextInt(12), 0.75F,
				particleRand.nextInt(4) == 0 ? 0xFF64db5a : 0xFFf2e111, "textures/particle/glitter.png", 8);
		this.motionX = mx;
		this.motionY = my;
		this.motionZ = mz;
		this.particleGravity = -0.01F; // floats up slowly
		this.currentTexture = particleRand.nextInt(4);
		this.fadeAway = true;
		if ((this.color & 0xFFFFFF) == 0x64db5a) {
			this.setColorFade(0x64db5a);
		} else {
			this.setColorFade(0xf2e111);
		}
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.particleAge % 2 == 0) {
			this.currentTexture = (this.currentTexture + 1) % 8;
		}
	}
}
