package mod.ke2.entity.machine;

import java.util.List;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.item.ItemGem;
import mod.ke2.item.ItemGemDestabilizer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityBubble extends EntityLiving {
	private static final DataParameter<NBTTagCompound> ITEM = EntityDataManager.<NBTTagCompound>createKey(EntityBubble.class, DataSerializers.COMPOUND_TAG);
	private static final DataParameter<Integer> COLOR = EntityDataManager.<Integer>createKey(EntityBubble.class, DataSerializers.VARINT);
	public EntityBubble(World world) {
		super(world);
		this.setSize(0.8F, 0.8F);
		this.dataManager.register(ITEM, ItemStack.EMPTY.serializeNBT());
		this.dataManager.register(COLOR, 0xFFFFFF);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(0.5D);
	}
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setTag("item", this.getItem().serializeNBT());
        compound.setInteger("color", this.getColor());
        super.writeEntityToNBT(compound);
	}
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		NBTTagCompound itemStackTag = (NBTTagCompound) compound.getTag("item");
        this.setItem(new ItemStack(itemStackTag));
        this.setColor(compound.getInteger("color"));
        super.readEntityFromNBT(compound);
	}
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setHealth(0.5F);
		return livingdata;
	}
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote && hand == EnumHand.MAIN_HAND) {
			List<EntityGem> list = player.world.<EntityGem>getEntitiesWithinAABB(EntityGem.class, player.getEntityBoundingBox().grow(4, 4, 4));
			double distance = Double.MAX_VALUE;
			EntityGem gem = null;
			for (EntityGem testedGem : list) {
				if (testedGem.isOwnedBy(player)) {
					double newDistance = player.getDistanceSq(testedGem);
					if (newDistance <= distance) {
						distance = newDistance;
						gem = testedGem;
					}
				}
			}
			if (!player.isSneaking()) {
				if (gem != null || player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemGemDestabilizer) {
					BlockPos location = player.getBedLocation(player.dimension);
					if (location == null) {
						return false;
					}
					if (!this.dead) {
						boolean generating = true;
						int attempts = 0;
						while (generating && attempts < 30) {
							BlockPos pos = location.add((this.world.rand.nextFloat() - 0.5F) * 5, this.world.rand.nextFloat() * 3 + 1, (this.world.rand.nextFloat() - 0.5F) * 5);
							if (this.world.isAirBlock(pos) && this.world.isAirBlock(pos.east()) && this.world.isAirBlock(pos.west()) && this.world.isAirBlock(pos.north()) && this.world.isAirBlock(pos.south())) {
								this.playSendSound();
								this.setPosition(pos.getX(), pos.getY(), pos.getZ());
								this.playSendSound();
								return true;
							}
							++attempts;
						}
						return false;
					}
				}
			}
			else {
				if (player.inventory.addItemStackToInventory(this.getItem())) {
					this.setDead();
				}
				else {
					this.attackEntityFrom(DamageSource.GENERIC, 1.0F);
				}
				return true;
			}
		}
		return super.processInteract(player, hand);
	}
	@Override
	public void onLivingUpdate() {
		this.setNoGravity(true);
		super.onLivingUpdate();
		this.motionY *= 0.9;
	}
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			EntityPlayer player = null;
			if (cause.getTrueSource() instanceof EntityPlayer) {
				player = (EntityPlayer)(cause.getTrueSource());
			}
			if (this.getItem().getItem() instanceof ItemGem) {
				ItemGem gem = (ItemGem)(this.getItem().getItem());
				gem.spawnGem(this.world, player, this.getPosition(), this.getItem());
			}
			else {
				this.entityDropItem(this.getItem(), 0.0F);
			}
		}
		this.playPopSound();
		super.onDeath(cause);
	}
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getTrueSource() != null || source == DamageSource.CACTUS || source == DamageSource.CRAMMING || source == DamageSource.OUT_OF_WORLD || source == DamageSource.IN_WALL) {
			return super.attackEntityFrom(source, amount);
		}
		return false;
	}
	public ItemStack getItem() {
		return new ItemStack(this.dataManager.get(ITEM));
	}
	public void setItem(ItemStack item) {
		this.dataManager.set(ITEM, item.serializeNBT());
	}
	@Override
	protected boolean canTriggerWalking() {
        return false;
	}
	@Override
	public void fall(float distance, float damageMultiplier) {
		return;
	}
	@Override
	public boolean canDespawn() {
		return false;
	}
	@Override
	public SoundEvent getHurtSound(DamageSource source) {
		return null;
	}
	@Override
	public SoundEvent getDeathSound() { 
		return null;
	}
	public void setColor(int color) {
		this.dataManager.set(COLOR, color);
	}
	public int getColor() {
		return this.dataManager.get(COLOR);
	}
	public void playBubbleSound() {
		this.playSound(Ke2Sounds.BUBBLE_CREATE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
	}
	public void playPopSound() {
		this.playSound(Ke2Sounds.BUBBLE_POP, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
	}
	public void playSendSound() {
		this.playSound(Ke2Sounds.BUBBLE_SEND, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
	}
}
