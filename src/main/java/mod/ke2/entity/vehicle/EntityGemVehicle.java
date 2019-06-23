package mod.ke2.entity.vehicle;

import mod.ke2.entity.machine.EntityGemMachine;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityGemVehicle extends EntityGemMachine {
	public EntityGemVehicle(World world) {
		super(world);
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote) {
			if (!this.isRidingOrBeingRiddenBy(player)) {
				player.rotationYaw = this.rotationYaw;
				player.rotationPitch = this.rotationPitch;
				player.startRiding(this);
				return true;
			}
		}
		return super.processInteract(player, hand);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getTrueSource() != null && !this.isRidingOrBeingRiddenBy(source.getTrueSource())) {
			return super.attackEntityFrom(source, amount);
		}
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		return;
	}

	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return false;
	}

	@Override
	protected float getWaterSlowDown() {
		return 1.0F;
	}

	@Override
	public Entity getControllingPassenger() {
		for (Entity entity : this.getPassengers()) {
			if (entity instanceof EntityPlayer) {
				return entity;
			}
		}
		return null;
	}

	@Override
	protected boolean canFitPassenger(Entity passenger) {
		return this.getPassengers().isEmpty();
	}

	@Override
	public boolean canBeSteered() {
		return true;
	}
}
