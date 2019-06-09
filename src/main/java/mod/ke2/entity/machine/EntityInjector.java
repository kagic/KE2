package mod.ke2.entity.machine;

import java.util.ArrayList;
import java.util.UUID;

import mod.ke2.init.Ke2Items;
import mod.ke2.item.ItemEssence;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityInjector extends EntityGemMachine {
	private static final DataParameter<Integer> COLOR = EntityDataManager.<Integer>createKey(EntityInjector.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> SEEDS = EntityDataManager.<Integer>createKey(EntityInjector.class, DataSerializers.VARINT);
	/** List of owner IDs in the order that they placed gem seeds into the injector. */
	public ArrayList<UUID> latestOwnerIDs = new ArrayList<UUID>();
	
	public EntityInjector(World world) {
		super(world);
		this.setSize(0.9F, 4.6F);
		this.setCanPickUpLoot(true);
		this.dataManager.register(COLOR, world.rand.nextInt(16));
		this.dataManager.register(SEEDS, 0);
		this.isImmuneToFire = true;
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
	}
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("Color", this.getColor());
        compound.setInteger("Count", this.getSeedCount());
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.latestOwnerIDs.size(); ++i) {
        	NBTTagCompound tag = new NBTTagCompound();
        	tag.setUniqueId("OwnerID", this.latestOwnerIDs.get(i));
        	list.appendTag(tag);
        }
        compound.setTag("LatestOwnerIDs", list);
	}
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setColor(compound.getInteger("Color"));
        this.setSeedCount(compound.getInteger("Count"));
        this.latestOwnerIDs.clear();
        NBTTagList list = compound.getTagList("LatestOwnerIDs", 10);
        for (int i = 0; i < list.tagCount(); ++i) {
        	this.latestOwnerIDs.add(list.getCompoundTagAt(i).getUniqueId("OwnerID"));
        }
	}
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setHealth(this.getMaxHealth());
		this.setColor(this.world.rand.nextInt(16));
		return livingdata;
	}
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote) {
			ItemStack stack = player.getHeldItem(hand);
			if (stack.getItem() == Ke2Items.GEM_STAFF) {
				if (player.isSneaking()) {
					this.say(player, this.getName() + " can produce " + this.getSeedCount() + " gems.");
				}
				else {
					if (this.getPlayerBeingFollowed() != null && this.getPlayerBeingFollowed().isEntityEqual(player)) {
						this.say(player, this.getName() + " will not follow you.");
						this.setPlayerBeingFollowed(null);
					}
					else {
						this.say(player, this.getName() + " will follow you.");
						this.setPlayerBeingFollowed(player);
					}
				}
			}
			else if (this.isEssence(stack)) {
				this.setSeedCount(this.getSeedCount() + 1);
				this.say(player, this.getName() + " can produce " + this.getSeedCount() + " gems.");
				this.latestOwnerIDs.add(player.getUniqueID());
				stack.shrink(1);
			}
		}
		return super.processInteract(player, hand);
	}
	@Override
	protected void updateEquipmentIfNeeded(EntityItem entity) {
		ItemStack stack = entity.getItem();
		if (this.isEssence(stack)) {
			int total = this.getSeedCount() + stack.getCount();
			if (total > 64) {
				stack.setCount(64 - total);
				this.setSeedCount(64);
			}
			else {
				this.setSeedCount(total);
				entity.setDead();
			}
		}
	}
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.STAINED_GLASS), 2, 15 - this.getColor()), 0);
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.IRON_BARS), 8), 0);
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.ANVIL)), 0);
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.DISPENSER)), 0);
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.HOPPER)), 0);
			//this.entityDropItem(new ItemStack(Item.getItemFromBlock(Ke2Blocks.GEM_SEED), this.getSeedCount()), 0);
		}
		super.onDeath(cause);
	}
	public boolean canInject() {
		return this.getPlayerBeingFollowed() == null && this.getSeedCount() > 0;
	}
	public boolean isEssence(ItemStack stack) {
		return stack.getItem() instanceof ItemEssence;
	}
	public UUID getLatestOwnerID(boolean remove) {
		if (this.latestOwnerIDs.isEmpty()) {
			return new UUID(0, 0);
		}
		else {
			UUID uuid = this.latestOwnerIDs.get(0);
			if (remove) {
				return this.latestOwnerIDs.remove(0);
			}
			return uuid;
		}
	}
	public UUID getLatestOwnerID() {
		return this.getLatestOwnerID(false);
	}
	public void setColor(int color) {
		this.dataManager.set(COLOR, color);
	}
	public int getColor() {
		return this.dataManager.get(COLOR);
	}
	public void setSeedCount(int count) {
		this.dataManager.set(SEEDS, count);
	}
	public int getSeedCount() {
		return this.dataManager.get(SEEDS);
	}
}
