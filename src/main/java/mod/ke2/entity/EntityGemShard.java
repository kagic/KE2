package mod.ke2.entity;

import mod.ke2.init.KAGIC;
import mod.ke2.init.Ke2Items;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityGemShard extends EntityMob {
	private static final DataParameter<NBTTagCompound> ITEM = EntityDataManager.<NBTTagCompound>createKey(EntityGemShard.class, DataSerializers.COMPOUND_TAG);
	private static final DataParameter<Integer> COLOR = EntityDataManager.<Integer>createKey(EntityGemShard.class, DataSerializers.VARINT);
	public static final ItemStack[] ITEMS = new ItemStack[] {
		new ItemStack(Ke2Items.WHITE_GEM_SHARD),
		new ItemStack(Ke2Items.ORANGE_GEM_SHARD),
		new ItemStack(Ke2Items.MAGENTA_GEM_SHARD),
		new ItemStack(Ke2Items.LIGHTBLUE_GEM_SHARD),
		new ItemStack(Ke2Items.YELLOW_GEM_SHARD),
		new ItemStack(Ke2Items.LIME_GEM_SHARD),
		new ItemStack(Ke2Items.PINK_GEM_SHARD),
		new ItemStack(Ke2Items.GRAY_GEM_SHARD),
		new ItemStack(Ke2Items.SILVER_GEM_SHARD),
		new ItemStack(Ke2Items.CYAN_GEM_SHARD),
		new ItemStack(Ke2Items.PURPLE_GEM_SHARD),
		new ItemStack(Ke2Items.BLUE_GEM_SHARD),
		new ItemStack(Ke2Items.BROWN_GEM_SHARD),
		new ItemStack(Ke2Items.GREEN_GEM_SHARD),
		new ItemStack(Ke2Items.RED_GEM_SHARD),
		new ItemStack(Ke2Items.BLACK_GEM_SHARD)
	};
	public static final int[] PARTICLE_COLORS = new int[] {
		0xFFFFFF,
		0xFDC84D,
		0xEB3DFE,
		0xCEEDF4,
		0xF4E900,
		0xB6FEAB,
		0xF8C2EB,
		0x9AA4AF,
		0xDDDDDD,
		0xA8DCDF,
		0xB185CF,
		0xA0B7EB,
		0xE9D5C9,
		0x2ED6A8,
		0xFD4813,
		0x2E2941
	};
	public EntityGemShard(World world) {
		super(world);
		this.setSize(0.8F, 1.6F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.8F, false));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 0.1D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityLivingBase.class, 16.0F));
        this.tasks.addTask(5, new EntityAIWander(this, 0.2D));
        this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, true, false));
		((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
		((PathNavigateGround) this.getNavigator()).setEnterDoors(true);
		this.dataManager.register(COLOR, this.rand.nextInt(16));
		this.dataManager.register(ITEM, EntityGemShard.ITEMS[this.dataManager.get(COLOR)].serializeNBT());
		this.setStatsBasedOnItem();
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
		this.setHealth(this.getMaxHealth());
		return super.onInitialSpawn(difficulty, livingdata);
	}
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote && !this.dead) {
			ItemStack stack = this.getItem().copy();
			boolean added = player.addItemStackToInventory(stack);
			if (!added) {
				player.dropItem(stack, true);
			}
			this.dead = true;
			this.setDead();
			return true;
		}
		return super.processInteract(player, hand);
	}
	@Override
	public void onLivingUpdate() {
        if (this.world.isRemote) {
            for (int i = 0; i < 1; ++i) {
            	KAGIC.proxy.addShardParticle(this.world, this.posX + (this.rand.nextFloat() * this.width * 2.0F) - this.width, this.posY + 0.5D + (this.rand.nextFloat() * this.height), this.posZ + (this.rand.nextFloat() * this.width * 2.0F) - this.width, this.rand.nextGaussian() * 0.02D, this.rand.nextGaussian() * 0.02D, this.rand.nextGaussian() * 0.02D, EntityGemShard.PARTICLE_COLORS[this.getColor()]);
            }
        }
        super.onLivingUpdate();
    }
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			this.entityDropItem(this.getItem(), 0.0F);
		}
		super.onDeath(cause);
	}
	@Override
	public boolean canDespawn() {
		return false;
	}
	public ItemStack getItem() {
		return new ItemStack(this.dataManager.get(ITEM));
	}
	public void setItem(ItemStack item) {
		this.dataManager.set(ITEM, item.serializeNBT());
		this.setStatsBasedOnItem();
	}
	@Override
	public SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.BLOCK_WOOD_BREAK;
	}
	@Override
	public SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_ITEM_BREAK;
	}
	@Override
	protected boolean canTriggerWalking() {
        return false;
	}
	@Override
	public void fall(float distance, float damageMultiplier) {
		return;
	}
	public void setColor(int color) {
		this.dataManager.set(COLOR, color);
	}
	public int getColor() {
		return this.dataManager.get(COLOR);
	}
	public void setStatsBasedOnItem() {
		ToolMaterial material = null;
		Item item = this.getItem().getItem();
		if (item instanceof ItemArmor) {
			material = ToolMaterial.valueOf(((ItemArmor) item).getArmorMaterial().getName().toUpperCase());
		}
		else if (item instanceof ItemSword) {
			material = ToolMaterial.valueOf(((ItemSword) item).getToolMaterialName());
		}
		else if (item instanceof ItemHoe) {
			material = ToolMaterial.valueOf(((ItemHoe) item).getMaterialName());
		}
		else if (item instanceof ItemAxe) {
			material = ToolMaterial.valueOf(((ItemTool) item).getToolMaterialName());
		}
		else if (item instanceof ItemPickaxe) {
			material = ToolMaterial.valueOf(((ItemTool) item).getToolMaterialName());
		}
		if (material == null) {
			material = ToolMaterial.STONE;
		}
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(material.getAttackDamage() + 3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(material.getHarvestLevel() * 6 + 2);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.experienceValue = material.getEnchantability();
	}
}