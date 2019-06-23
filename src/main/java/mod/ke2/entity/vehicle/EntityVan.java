package mod.ke2.entity.vehicle;

import java.util.List;

import mod.ke2.entity.machine.EntityGemMachine;
import mod.ke2.init.Ke2Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityVan extends EntityGemMachine {
	public EntityVan(World world) {
		super(world);
		this.setSize(3.0F, 7.0F);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(12.0D);
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote) {
			ItemStack stack = player.getHeldItem(hand);
			if (player.isSneaking()) {
				if (stack.getItem() == Ke2Items.GEM_STAFF) {
					if (this.getPlayerBeingFollowed() != null && this.getPlayerBeingFollowed().isEntityEqual(player)) {
						this.say(player, this.getName() + " will not follow you.");
						this.setPlayerBeingFollowed(null);
					} else {
						this.say(player, this.getName() + " will follow you.");
						this.setPlayerBeingFollowed(player);
					}
					return true;
				}
			} else if (!this.isRidingOrBeingRiddenBy(player)) {
				player.rotationYaw = this.rotationYaw;
				player.rotationPitch = this.rotationPitch;
				player.startRiding(this);
				return true;
			}
		}
		return super.processInteract(player, hand);
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.isBeingRidden()) {
			List<EntityLivingBase> entities = this.world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox());
			for (EntityLivingBase entity : entities) {
				if (!this.isRidingOrBeingRiddenBy(entity) && !this.isEntityEqual(entity)) {
					float damage = 2.0F;
					if (this.posY > entity.posY) {
						damage = 40.0F;
					}
					entity.attackEntityFrom(DamageSource.causeIndirectDamage(this, (EntityLivingBase) this.getControllingPassenger()), damage);
					entity.motionY += this.motionX + this.motionZ;
					entity.motionX += this.motionX * 1.5D;
					entity.motionZ += this.motionZ * 1.5D;
				}
			}
		}
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
	public void updatePassenger(Entity passenger) {
		super.updatePassenger(passenger);
		passenger.setPosition(this.posX, this.posY + 0.375F, this.posZ);
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

	@Override
	public void travel(float strafe, float vertical, float forward) {
		if (this.isBeingRidden() && this.canBeSteered()) {
			EntityLivingBase player = (EntityLivingBase) this.getControllingPassenger();
			this.setRotation(this.rotationYaw - player.moveStrafing, this.rotationPitch);
			if (this.canPassengerSteer()) {
				this.setAIMoveSpeed(0.2F);
				super.travel(0.0F, vertical, player.moveForward);
			}
		} else {
			super.travel(strafe, vertical, forward);
		}
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public EnumPushReaction getPushReaction() {
		return EnumPushReaction.DESTROY;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource cause) {
		return SoundEvents.BLOCK_ANVIL_PLACE;
	}
}