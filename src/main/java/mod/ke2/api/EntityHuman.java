package mod.ke2.api;

import com.google.common.base.Predicate;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.InvWrapper;

public class EntityHuman extends EntityCreature implements IInventoryChangedListener, INpc {
	public static final DataParameter<Boolean> BACKPACKED = EntityDataManager.<Boolean>createKey(EntityHuman.class, DataSerializers.BOOLEAN);
	public InventoryBasic backpack;
	public InvWrapper backpackHandler;

	public EntityHuman(World world) {
		super(world);

		// Register backpacks.
		this.dataManager.register(EntityHuman.BACKPACKED, true);
		this.initStorage();

		// See doors.
		((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
		((PathNavigateGround) this.getNavigator()).setEnterDoors(true);

		// Apply tasks.
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAvoidEntity<EntityCreeper>(this, EntityCreeper.class, new Predicate<EntityCreeper>() {
			@Override
			public boolean apply(EntityCreeper input) {
				return input.getCreeperState() == 1;
			}
		}, 6.0F, 1.0D, 1.2D));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(3, new EntityAIMoveTowardsTarget(this, 0.414D, 32.0F));
		this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.8D, true));
		this.tasks.addTask(5, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		// this.tasks.addTask(6, new
		// EntityAIPickUpLoot(this, 0.9D));
		this.tasks.addTask(7, new EntityAIWander(this, 0.6D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityMob.class, 16.0F));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		NBTTagList list = new NBTTagList();
		for (int slot = 0; slot < this.backpack.getSizeInventory(); ++slot) {
			ItemStack stack = this.backpack.getStackInSlot(slot);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setByte("slot", (byte) slot);
			stack.writeToNBT(tag);
			list.appendTag(tag);
		}
		compound.setTag("items", list);
		compound.setBoolean("backpacked", this.isBackpacked());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.initStorage();
		NBTTagList list = compound.getTagList("items", 10);
		for (int i = 0; i < list.tagCount(); ++i) {
			NBTTagCompound tag = list.getCompoundTagAt(i);
			int slot = tag.getByte("slot") & 255;
			if (slot >= 0 && slot < this.backpack.getSizeInventory()) {
				this.backpack.setInventorySlotContents(slot, new ItemStack(tag));
			}
		}
		this.setBackpack(compound.getBoolean("backpacked"));
	}

	@Override
	public void onInventoryChanged(IInventory inventory) {

	}

	public void initStorage() {
		InventoryBasic gemstorage = this.backpack;
		this.backpack = new InventoryBasic("backpack", false, 27);
		if (gemstorage != null) {
			gemstorage.removeInventoryChangeListener(this);
			for (int i = 0; i < this.backpack.getSizeInventory(); ++i) {
				ItemStack itemstack = gemstorage.getStackInSlot(i);
				this.backpack.setInventorySlotContents(i, itemstack.copy());
			}
		}
		this.backpack.addInventoryChangeListener(this);
		this.backpackHandler = new InvWrapper(this.backpack);
		this.setCanPickUpLoot(this.isBackpacked());
	}

	public boolean isBackpacked() {
		return this.dataManager.get(EntityHuman.BACKPACKED);
	}

	public void setBackpack(boolean backpacked) {
		this.dataManager.set(EntityHuman.BACKPACKED, backpacked);
		this.setCanPickUpLoot(backpacked);
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	public boolean shouldAttackEntity(EntityLivingBase attacker, EntityLivingBase target) {
		return true;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		EntityLivingBase living = entity instanceof EntityLivingBase ? (EntityLivingBase) entity : null;
		float amount = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
		int i = 0;
		if (entity instanceof EntityLivingBase) {
			amount += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), living.getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}
		this.swingArm(EnumHand.MAIN_HAND);
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), amount);
		if (flag) {
			if (i > 0 && entity instanceof EntityLivingBase) {
				living.knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F), -MathHelper.cos(this.rotationYaw * 0.017453292F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
			int j = EnchantmentHelper.getFireAspectModifier(this);
			if (j > 0) {
				entity.setFire(j * 4);
			}
			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				ItemStack stack = this.getHeldItemMainhand();
				ItemStack held = player.isHandActive() ? player.getActiveItemStack() : ItemStack.EMPTY;
				if (stack.getItem() instanceof ItemAxe && held.getItem() == Items.SHIELD) {
					float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
					if (this.rand.nextFloat() < f1) {
						player.getCooldownTracker().setCooldown(Items.SHIELD, 100);
						this.world.setEntityState(player, (byte) 30);
					}
				}
			}
			this.applyEnchantments(this, entity);
		}
		return flag;
	}

	@Override
	public void onLivingUpdate() {
		this.updateArmSwingProgress();
		super.onLivingUpdate();
		if (!this.world.isRemote) {
			if (this.isBackpacked() && this.getHealth() < 10.0F) {
				for (int i = 0; i < this.backpack.getSizeInventory(); ++i) {
					ItemStack stack = this.backpack.getStackInSlot(i);
					if (stack.getItem() instanceof ItemFood) {
						ItemFood food = (ItemFood) stack.getItem();
						int amount = food.getHealAmount(stack);
						if (this.getHealth() + amount <= 20.0F) {
							this.playSound(SoundEvents.ENTITY_GENERIC_EAT, this.getSoundVolume(), this.getSoundPitch());
							this.heal(amount);
						}
					}
				}
			}
		}
		if (!this.getDisplayName().getUnformattedText().equals(this.getRealName())) {
			this.setCustomNameTag(this.getRealName());
		}
	}

	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			for (int i = 0; i < this.backpack.getSizeInventory(); ++i) {
				this.entityDropItem(this.backpack.getStackInSlot(i), 0.0F);
			}
		}
		super.onDeath(cause);
	}

	@Override
	protected void updateEquipmentIfNeeded(EntityItem item) {
		ItemStack stack = item.getItem();
		ItemStack held = this.backpack.addItem(stack);
		if (held.isEmpty()) {
			item.setDead();
		} else {
			stack.setCount(held.getCount());
		}
	}

	public void openGUI(EntityPlayer player) {
		if (!this.world.isRemote && this.isBackpacked()) {
			String name = new TextComponentTranslation("command.ke2." + this.getRealName().toLowerCase() + ".name").getUnformattedComponentText();
			this.backpack.setCustomName(name);
			player.displayGUIChest(this.backpack);
		}
	}

	public String getRealName() {
		return "Human";
	}

	@Override
	protected float getSoundPitch() {
		return 1.0F;
	}

	@Override
	public int getTalkInterval() {
		return 200;
	}
}
