package mod.ke2.entity.vehicle;

import java.util.List;

import mod.ke2.entity.EntityGemMachine;
import mod.ke2.init.Ke2Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityPalanquin extends EntityGemMachine implements IJumpingMount {
	private static final DataParameter<Integer> BODY_COLOR = EntityDataManager.<Integer>createKey(EntityPalanquin.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> HIGHLIGHT_COLOR = EntityDataManager.<Integer>createKey(EntityPalanquin.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> VEIL_COLOR = EntityDataManager.<Integer>createKey(EntityPalanquin.class, DataSerializers.VARINT);
	protected float jumpPower;
	public EntityPalanquin(World world) {
		super(world);
		this.setSize(3.0F, 7.0F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		//this.tasks.addTask(1, new EntityAIMachineFollowPlayer(this, 0.6D));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
		this.dataManager.register(BODY_COLOR, world.rand.nextInt(16));
		this.dataManager.register(HIGHLIGHT_COLOR, world.rand.nextInt(16));
		this.dataManager.register(VEIL_COLOR, world.rand.nextInt(16));
		this.isImmuneToFire = true;
	}
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("BodyColor", this.getBodyColor());
		compound.setInteger("HighlightColor", this.getHighlightColor());
		compound.setInteger("VeilColor", this.getVeilColor());
    }
    @Override
	public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setBodyColor(compound.getInteger("BodyColor"));
        this.setHighlightColor(compound.getInteger("HighlightColor"));
        this.setVeilColor(compound.getInteger("VeilColor"));
    }
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setHealth(this.getMaxHealth());
		this.setBodyColor(this.world.rand.nextInt(16));
		this.setHighlightColor(this.world.rand.nextInt(16));
		this.setVeilColor(this.world.rand.nextInt(16));
		return livingdata;
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
					}
					else {
						this.say(player, this.getName() + " will follow you.");
						this.setPlayerBeingFollowed(player);
					}
					return true;
				}
			}
			else if (!this.isRidingOrBeingRiddenBy(player)) {
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
					entity.attackEntityFrom(DamageSource.causeIndirectDamage(this, (EntityLivingBase)(this.getControllingPassenger())), damage);
					entity.motionY += this.motionX + this.motionZ;
					entity.motionX += this.motionX * 1.5D;
					entity.motionZ += this.motionZ * 1.5D;
				}
			}
		}
	}
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.STAINED_GLASS), 20, 15 - this.getVeilColor()), 0);
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.CONCRETE), 18, 15 - this.getBodyColor()), 0);
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 15 - this.getHighlightColor()), 0);
		}
		super.onDeath(cause);
	}
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if ((source.getTrueSource() != null && !this.isRidingOrBeingRiddenBy(source.getTrueSource()))) {
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
        passenger.setPosition(this.posX, this.posY + 1.2F, this.posZ);
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
        this.jumpMovementFactor = 0.1F;
        if (this.isBeingRidden() && this.canBeSteered()) {
            EntityLivingBase player = (EntityLivingBase)(this.getControllingPassenger());
            this.rotationPitch = player.rotationPitch;
            this.rotationYaw = player.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.renderYawOffset = this.rotationYaw;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            strafe = player.moveStrafing * 0.5F;
            forward = player.moveForward;
            if (this.jumpPower > 0.0F && this.onGround) {
                this.motionY = this.jumpPower;
                if (this.isPotionActive(MobEffects.JUMP_BOOST)) {
                    this.motionY += (this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1F;
                }
                this.isAirBorne = true;
                if (forward > 0.0F) {
                    float sin = MathHelper.sin(this.rotationYaw * 0.017453292F);
                    float cos = MathHelper.cos(this.rotationYaw * 0.017453292F);
                    this.motionX += -0.4F * sin * this.jumpPower * 1.5F;
                    this.motionZ += 0.4F * cos * this.jumpPower * 1.5F;
                    this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.4F, 1.0F);
                }
                this.jumpPower = 0.0F;
            }
            if (this.onGround) {
            	this.jumpPower = 0.0F;
            }
            if (this.canPassengerSteer()) {
                this.setAIMoveSpeed(0.1F);
                super.travel(strafe, vertical, forward);
            }
            else if (player instanceof EntityPlayer) {
                this.motionX = 0.0D;
                this.motionY = 0.0D;
                this.motionZ = 0.0D;
            }
            this.prevLimbSwingAmount = this.limbSwingAmount;
            double x = this.posX - this.prevPosX;
            double z = this.posZ - this.prevPosZ;
            float dist = MathHelper.sqrt(z * z + x * x) * 4.0F;
            if (dist > 0.25F) {
                dist = 0.25F;
            }
            this.limbSwingAmount += (dist - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else {
            super.travel(strafe, vertical, forward);
        }
    }
	@Override public void handleStartJump(int power) { }
	@Override public void handleStopJump() { }
	@Override
	@SideOnly(Side.CLIENT)
    public void setJumpPower(int jumpPower) {
        if (this.canJump()) {
            if (jumpPower > 90) {
                this.jumpPower = 1.0F;
            }
            else {
                this.jumpPower = 0.4F + 0.4F * jumpPower / 90.0F;
            }
            if (jumpPower < 0) {
                jumpPower = 0;
            }
        }
    }
	@Override
	public boolean canJump() {
		return true;
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
	public void setBodyColor(int color) {
		this.dataManager.set(BODY_COLOR, color);
	}
	public int getBodyColor() {
		return this.dataManager.get(BODY_COLOR);
	}
	public void setHighlightColor(int color) {
		this.dataManager.set(HIGHLIGHT_COLOR, color);
	}
	public int getHighlightColor() {
		return this.dataManager.get(HIGHLIGHT_COLOR);
	}
	public void setVeilColor(int color) {
		this.dataManager.set(VEIL_COLOR, color);
	}
	public int getVeilColor() {
		return this.dataManager.get(VEIL_COLOR);
	}
}