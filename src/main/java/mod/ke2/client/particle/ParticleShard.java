package mod.ke2.client.particle;

import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleShard extends Particle {
	private final double shardicleScale;
	private final int particleColor;

	public ParticleShard(World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) {
		this(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed, 0xFFFFFF);
	}

	public ParticleShard(World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int color) {
		super(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
		this.motionX = xSpeed;
		this.motionY = ySpeed;
		this.motionZ = zSpeed;
		this.posX = xCoord;
		this.posY = yCoord;
		this.posZ = zCoord;
		this.particleScale = this.rand.nextFloat() * 0.2F + 0.5F;
		this.shardicleScale = this.particleScale;
		this.particleColor = color;
		this.particleRed = ((this.particleColor & 16711680) >> 16) / 255f;
		this.particleGreen = ((this.particleColor & 65280) >> 8) / 255f;
		this.particleBlue = ((this.particleColor & 255) >> 0) / 255f;
		this.particleMaxAge = (int) (Math.random() * 10.0D) + 40;
		this.setParticleTextureIndex((int) (Math.random() * 8.0D));
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entity, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		float f = (this.particleAge + partialTicks) / this.particleMaxAge * 32.0F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		this.particleScale = (float) (this.shardicleScale * f);
		super.renderParticle(buffer, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.particleAge++ >= this.particleMaxAge) {
			this.setExpired();
		}
		this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
		this.move(this.motionX, this.motionY, this.motionZ);
		if (this.posY == this.prevPosY) {
			this.motionX *= 1.1D;
			this.motionZ *= 1.1D;
		}
		this.motionX *= 0.9599999785423279D;
		this.motionY *= 0.9599999785423279D;
		this.motionZ *= 0.9599999785423279D;
		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}
	}

	@SideOnly(Side.CLIENT)
	public static class Factory implements IParticleFactory {
		@Override
		public Particle createParticle(int particleID, World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int... params) {
			return new ParticleShard(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed, params[0]);
		}
	}
}