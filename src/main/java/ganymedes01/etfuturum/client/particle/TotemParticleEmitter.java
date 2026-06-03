package ganymedes01.etfuturum.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class TotemParticleEmitter extends EntityFX {
	private final Entity attachedEntity;
	private final int lifetime;
	private int age;

	public TotemParticleEmitter(World world, Entity entity, int lifetime) {
		super(world, entity.posX, entity.boundingBox.minY + (double) (entity.height / 2.0F), entity.posZ);
		this.attachedEntity = entity;
		this.lifetime = lifetime;
		this.onUpdate();
	}

	@Override
	public void onUpdate() {
		for (int i = 0; i < 16; ++i) {
			double d0 = (double) (this.rand.nextFloat() * 2.0F - 1.0F);
			double d1 = (double) (this.rand.nextFloat() * 2.0F - 1.0F);
			double d2 = (double) (this.rand.nextFloat() * 2.0F - 1.0F);

			if (d0 * d0 + d1 * d1 + d2 * d2 <= 1.0D) {
				double x = this.attachedEntity.posX + d0 * (double) this.attachedEntity.width / 4.0D;
				double y = this.attachedEntity.boundingBox.minY + (double) (this.attachedEntity.height / 2.0F) + d1 * (double) this.attachedEntity.height / 4.0D;
				double z = this.attachedEntity.posZ + d2 * (double) this.attachedEntity.width / 4.0D;
				CustomParticles.spawnTotemParticle(this.worldObj, x, y, z, d0, d1 + 0.2D, d2);
			}
		}

		++this.age;
		if (this.age >= this.lifetime) {
			this.setDead();
		}
	}

	@Override
	public void renderParticle(net.minecraft.client.renderer.Tessellator tessellator, float partialTicks, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY) {
	}

	@Override
	public int getFXLayer() {
		return 3;
	}
}
