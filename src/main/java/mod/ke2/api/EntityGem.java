package mod.ke2.api;

import java.util.List;
import java.util.UUID;

import com.google.common.base.Optional;

import io.netty.buffer.ByteBuf;
import mod.ke2.api.injection.GemSpawnData;
import mod.ke2.init.Ke2;
import mod.ke2.init.Ke2Gems;
import mod.ke2.world.data.WorldDataAuthorities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.items.wrapper.InvWrapper;

public abstract class EntityGem extends EntityMob implements IGem, IInventoryChangedListener, IRangedAttackMob, IEntityAdditionalSpawnData {
	public enum Pose {
		DEFAULT,
		NOCKING_BOW,
		FLAILING,
		USING_POWERS,
		SALUTING,
		WAVING,
		DABBING,
		POSSESSED
	}
	protected static final DataParameter<Optional<UUID>> GEM_GLOBAL_ID 		= EntityDataManager.<Optional<UUID>>createKey(EntityGem.class, DataSerializers.OPTIONAL_UNIQUE_ID);	
	protected static final DataParameter<Optional<UUID>> GEM_OWNER_ID 		= EntityDataManager.<Optional<UUID>>createKey(EntityGem.class, DataSerializers.OPTIONAL_UNIQUE_ID);	
	protected static final DataParameter<Optional<UUID>> GEM_LEADER_ID		= EntityDataManager.<Optional<UUID>>createKey(EntityGem.class, DataSerializers.OPTIONAL_UNIQUE_ID);	
	protected static final DataParameter<Integer>		 GEM_ALIGNMENT 		= EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Float>			 GEM_EMOTION 		= EntityDataManager.<Float>createKey(EntityGem.class, DataSerializers.FLOAT);
	protected static final DataParameter<Integer> 		 POSE	 			= EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> 		 IS_HIGHLIGHTED 	= EntityDataManager.<Boolean>createKey(EntityGem.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<BlockPos> 		 ORIGINAL_POS 		= EntityDataManager.<BlockPos>createKey(EntityGem.class, DataSerializers.BLOCK_POS);
	protected static final DataParameter<Integer> 		 ORIGINAL_DIM 		= EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer>		 COLOR_DYE_INSIGNIA = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer>		 COLOR_RGB_OUTFIT 	= EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer>		 COLOR_RGB_VISOR 	= EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer>		 COLOR_RGB_SKIN 	= EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer>		 COLOR_RGB_HAIR 	= EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer>	 	 COLOR_RGB_GEMSTONE = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<String>		 VARIANT_OUTFIT		= EntityDataManager.<String>createKey(EntityGem.class, DataSerializers.STRING);
	protected static final DataParameter<String>		 VARIANT_HAIR		= EntityDataManager.<String>createKey(EntityGem.class, DataSerializers.STRING);
	protected static final DataParameter<String>		 VARIANT_SKIN		= EntityDataManager.<String>createKey(EntityGem.class, DataSerializers.STRING);
	protected static final DataParameter<Integer>		 GEMSTONE_POS 		= EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<EnumFacing>	 GEMSTONE_DIR 		= EntityDataManager.<EnumFacing>createKey(EntityGem.class, DataSerializers.FACING);
	protected static final DataParameter<String>		 GEMSTONE_CUT 		= EntityDataManager.<String>createKey(EntityGem.class, DataSerializers.STRING);
	protected static final DataParameter<Boolean>		 IS_DEFECTIVE		= EntityDataManager.<Boolean>createKey(EntityGem.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean>		 IS_PERFECT			= EntityDataManager.<Boolean>createKey(EntityGem.class, DataSerializers.BOOLEAN);
	
	/** If true, then the gem is 50% size when defective and 150% size when perfect. */
	protected boolean changesScaleBasedOnCondition = true;
	/** Default outfit color is analog to KAGIC's native color. */
	protected int defaultOutfitColor = 0;
	
	/** Handles inventory events for AI purposes. */
	public InvWrapper storageHandler;
	/** Gem storage, all gems have this but, not all use it though. */
	public InventoryBasic inventory;
	
	public double prevChasingPosX;
    public double prevChasingPosY;
    public double prevChasingPosZ;
    public double chasingPosX;
    public double chasingPosY;
    public double chasingPosZ;
	
	public EntityGem(World world) {
		super(world);
		this.dataManager.register(GEM_GLOBAL_ID, Optional.absent());
		this.dataManager.register(GEM_OWNER_ID, Optional.absent());
		this.dataManager.register(GEM_LEADER_ID, Optional.absent());
		this.dataManager.register(GEM_ALIGNMENT, 0);
		this.dataManager.register(GEM_EMOTION, Ke2Gems.EMOTION_HAPPY);
		this.dataManager.register(POSE, 0);
		this.dataManager.register(IS_HIGHLIGHTED, false);
		this.dataManager.register(ORIGINAL_POS, BlockPos.ORIGIN);
		this.dataManager.register(ORIGINAL_DIM, 0);
		this.dataManager.register(COLOR_DYE_INSIGNIA, -1);
		this.dataManager.register(COLOR_RGB_OUTFIT, 0);
		this.dataManager.register(COLOR_RGB_VISOR, 0);
		this.dataManager.register(COLOR_RGB_SKIN, 0);
		this.dataManager.register(COLOR_RGB_HAIR, 0);
		this.dataManager.register(COLOR_RGB_GEMSTONE, 0);
		this.dataManager.register(VARIANT_OUTFIT, "");
		this.dataManager.register(VARIANT_HAIR, "");
		this.dataManager.register(VARIANT_SKIN, "");
		this.dataManager.register(GEMSTONE_POS, 0);
		this.dataManager.register(GEMSTONE_DIR, EnumFacing.NORTH);
		this.dataManager.register(GEMSTONE_CUT, "");
		this.dataManager.register(IS_DEFECTIVE, false);
		this.dataManager.register(IS_PERFECT, false);
	}
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		this.setGemGlobalID(UUID.randomUUID());
		if (data instanceof GemSpawnData) {
			GemSpawnData gemSpawnData = (GemSpawnData)(data);
			this.setGemOwnerID(gemSpawnData.getOwner());
			this.setGemAlignment(Ke2Gems.ALIGNED_WITH_PLAYERS);
			this.setInsigniaColor(gemSpawnData.getColor());
			this.setDefective(gemSpawnData.isDefective());
			this.setPerfect(gemSpawnData.isPerfect());
		}
		this.setOriginalPosition(this.getPosition());
		this.setOriginalDimension(this.dimension);
		this.setOutfitVariant(this.generateOutfitVariant());
		this.setHairVariant(this.generateHairVariant());
		this.setSkinVariant(this.generateSkinVariant());
		this.setOutfitColor(this.generateOutfitColor());
		this.setVisorColor(this.generateVisorColor());
		this.setSkinColor(this.generateSkinColor());
		this.setHairColor(this.generateHairColor());
		this.setGemstoneColor(this.generateGemstoneColor());
		this.setGemstonePosition(this.generateGemstonePosition());
		this.setGemstoneCut(this.generateGemstoneCut());
		this.setEmotion(this.generateEmotion());
		this.setHealth(this.getMaxHealth());
		this.stepHeight = Math.min(0.5F, this.height / 2);
		return data;
	}
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey("GemGlobalID")) {
			this.setGemGlobalID(UUID.fromString(compound.getString("GemGlobalID")));
		}
		if (compound.hasKey("GemOwnerID")) {
			this.setGemOwnerID(UUID.fromString(compound.getString("GemOwnerID")));
		}
		if (compound.hasKey("GemLeaderID")) {
			this.setGemLeaderID(UUID.fromString(compound.getString("GemLeaderID")));
		}
		this.setGemAlignment(compound.getInteger("GemAlignment"));
		this.setEmotion(compound.getFloat("Emotion"));
		this.setSwingingArms(compound.getBoolean("SwingingArms"));
		this.setHighlighted(compound.getBoolean("Highlighted"));
		this.setOriginalPosition(BlockPos.fromLong(compound.getLong("OriginalPosition")));
		this.setOriginalDimension(compound.getInteger("OriginalDimension"));
		this.setInsigniaColor(compound.getInteger("InsigniaColor"));
		this.setOutfitColor(compound.getInteger("OutfitColor"));
		this.setVisorColor(compound.getInteger("VisorColor"));
		this.setSkinColor(compound.getInteger("SkinColor"));
		this.setHairColor(compound.getInteger("HairColor"));
		this.setGemstoneColor(compound.getInteger("GemstoneColor"));
		this.setOutfitVariant(compound.getString("OutfitVariant"));
		this.setHairVariant(compound.getString("HairVariant"));
		this.setSkinVariant(compound.getString("SkinVariant"));
		this.setGemstonePosition(compound.getInteger("GemstonePosition"));
		this.setGemstoneDirection(EnumFacing.byName(compound.getString("GemstoneDirection")));
		this.setGemstoneCut(compound.getString("GemstoneCut"));
		this.setDefective(compound.getBoolean("Defective"));
		this.setPerfect(compound.getBoolean("Perfect"));
		this.createInventory();
		NBTTagList inventory = compound.getTagList("Inventory", 10);
		for (int i = 0; i < inventory.tagCount(); ++i) {
			NBTTagCompound tag = inventory.getCompoundTagAt(i);
			int s = tag.getByte("Slot") & 255;
			if (s >= 0 && s < this.inventory.getSizeInventory()) {
				this.inventory.setInventorySlotContents(s, new ItemStack(tag));
			}
		}
	}
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("Species", Ke2Gems.GEM_TABLE.get(this.getClass()).toString());
		if (this.getGemGlobalID() != null) {
			compound.setString("GemGlobalID", this.getGemGlobalID().toString());
		}
		if (this.getGemOwnerID() != null) {
			compound.setString("GemOwner", this.getGemOwnerID().toString());
		}
		if (this.getGemLeaderID() != null) {
			compound.setString("GemLeaderID", this.getGemLeaderID().toString());
		}
		compound.setInteger("GemAlignment", this.getGemAlignment());
		compound.setFloat("Emotion", this.getEmotion());
		compound.setInteger("Pose", this.getPose().ordinal());
		compound.setBoolean("Highlighted", this.isHighlighted());
		compound.setLong("OriginalPosition", this.getOriginalPosition().toLong());
		compound.setInteger("OriginalDimension", this.getOriginalDimension());
		compound.setInteger("InsigniaColor", this.getInsigniaColor());
		compound.setInteger("OutfitColor", this.getOutfitColor());
		compound.setInteger("VisorColor", this.getVisorColor());
		compound.setInteger("SkinColor", this.getSkinColor());
		compound.setInteger("HairColor", this.getHairColor());
		compound.setInteger("GemstoneColor", this.getGemstoneColor());
		compound.setString("OutfitVariant", this.getOutfitVariant());
		compound.setString("HairVariant", this.getHairVariant());
		compound.setString("SkinVariant", this.getSkinVariant());
		compound.setInteger("GemstonePosition", this.getGemstonePosition());
		compound.setString("GemstoneDirection", this.getGemstoneDirection().toString());
		compound.setString("GemstoneCut", this.getGemstoneCut());
		compound.setBoolean("Defective", this.isDefective());
		compound.setBoolean("Perfect", this.isPerfect());
		this.createInventory();
		NBTTagList inventory = new NBTTagList();
		for (int i = 0; i < this.inventory.getSizeInventory(); ++i) {
			ItemStack stack = this.inventory.getStackInSlot(i);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setByte("Slot", (byte)(i));
			stack.writeToNBT(tag);
			inventory.appendTag(tag);
		}
		compound.setTag("Inventory", inventory);
	}
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}
	@Override
	public void onUpdate() {
        super.onUpdate();
        this.motionY *= this.getFallSpeed();
        if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.dead = this.getHealth() > 0;
        }
        this.updateCape();
    }
	@Override
	protected boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote) {
			if (hand == EnumHand.MAIN_HAND) {
				// TODO: weapon and gem staff code
			}
		}
		return super.processInteract(player, hand);
	}
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			if (this instanceof EntityGemFusion) {
				EntityGemFusion fusion = (EntityGemFusion)(this);
				fusion.unfuse();
				fusion.setDead();
			}
			else {
				if (this.world.getGameRules().getBoolean("showDeathMessages")) {
					if (!this.hasCustomName()) {
						this.setCustomNameTag(String.format("%s-%s", this.getName(), this.getDescriptor(3)));
						this.sendMessage(cause.getDeathMessage(this).getUnformattedText());
						this.setCustomNameTag("");
					}
					else {
						this.sendMessage(cause.getDeathMessage(this).getUnformattedText());
					}
				}
			}
		}
		super.onDeath(cause);
	}
	@Override
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
		return;
	}
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (!this.world.isRemote) {
			// TODO: Ensure we have all the (universal) damage types listed.
			if (source.damageType.matches("(?i:magic|drown|vacuum|oxygen_suffocation|electricity|radiation)")) {
				return false;
			}
			float health = this.getHealth() - amount;
			if (health < -50) {
				source = Ke2.DAMAGE_SHATTERED;
			}
			else if (health < -10) {
				source = Ke2.DAMAGE_CRACKED;
			}
			else {
				source = Ke2.DAMAGE_POOFED;
			}
		}
		return super.attackEntityFrom(source, amount);
	}
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntityTippedArrow arrow = new EntityTippedArrow(this.world, this);
		double distanceFromTargetX = target.posX - this.posX;
		double distanceFromTargetY = target.getEntityBoundingBox().minY + (target.height) - arrow.posY;
		double distanceFromTargetZ = target.posZ - this.posZ;
		double distanceFromTargetS = MathHelper.sqrt(distanceFromTargetX * distanceFromTargetX + distanceFromTargetY * distanceFromTargetY);
		arrow.shoot(distanceFromTargetX, distanceFromTargetY + distanceFromTargetS * 0.20000000298023224D, distanceFromTargetZ, 1.6F, 0.0F);
		arrow.setDamage(distanceFactor * 2.0D + this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE).getBaseValue() + this.rand.nextGaussian() * 0.25D);
		boolean flame = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FLAME, this) > 0;
		int power = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.POWER, this);
		int punch = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.PUNCH, this);
		if (power > 0) {
			arrow.setDamage(arrow.getDamage() + power * 0.5D + 0.5D);
		}
		if (punch > 0) {
			arrow.setKnockbackStrength(punch);
		}
		if (flame) {
			arrow.setFire(100);
		}
		ItemStack stack = this.getHeldItem(EnumHand.OFF_HAND);
		if (stack.getItem() == Items.TIPPED_ARROW) {
			arrow.setPotionEffect(stack);
		}
		this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.spawnEntity(arrow);
	}
	public boolean isHoldingRangedWeapon() {
		ItemStack stack = this.getHeldItem(EnumHand.MAIN_HAND);
		if (stack.getItem().getItemUseAction(stack) == EnumAction.BOW) {
			return true;
		}
		else {
			return false;
		}
	}
	public double getFallSpeed() {
		return 1.0D;
	}
	public boolean hasNoDyeOverlay() {
		return false;
	}
	public void sendMessageTo(EntityPlayer player, String line, Object... formatting) {
		player.sendMessage(new TextComponentString("<" + this.getName() + "> " + String.format(line, formatting)));
	}
	public void sendMessage(String line, Object... formatting) {
		List<EntityPlayer> list = this.world.playerEntities;
		for (EntityPlayer player : list) {
			if (this.isOwnedBy(player)) {
				this.sendMessageTo(player, line, formatting);
			}
		}
	}
	public boolean isOwnedBy(EntityPlayer player) {
		return this.isOwnedBy(player.getUniqueID());
	}
	public boolean isOwnedBy(EntityGem gem) {
		return this.isOwnedBy(gem.getGemGlobalID());
	}
	public boolean isOwnedBy(UUID id) {
		WorldDataAuthorities auth = WorldDataAuthorities.get(this.world);
		if (auth.isAuthorized(id, this.getGemOwnerID()) || this.getGemLeaderID() == id) {
			return true;
		}
		return false;
	}
	public void setGemGlobalID(UUID id) {
		this.dataManager.set(GEM_GLOBAL_ID, Optional.<UUID>fromNullable(id));
	}
	public UUID getGemGlobalID() {
		return this.dataManager.get(GEM_GLOBAL_ID).orNull();
	}
	public void setGemOwnerID(UUID id) {
		this.dataManager.set(GEM_OWNER_ID, Optional.<UUID>fromNullable(id));
	}
	public UUID getGemOwnerID() {
		return this.dataManager.get(GEM_OWNER_ID).orNull();
	}
	public void setGemLeaderID(UUID id) {
		this.dataManager.set(GEM_LEADER_ID, Optional.<UUID>fromNullable(id));
	}
	public UUID getGemLeaderID() {
		return this.dataManager.get(GEM_LEADER_ID).orNull();
	}
	public void setGemAlignment(int alignment) {
		this.dataManager.set(GEM_ALIGNMENT, alignment);
	}
	public int getGemAlignment() {
		return this.dataManager.get(GEM_ALIGNMENT);
	}
	public void setEmotion(float emotion) {
		this.dataManager.set(GEM_EMOTION, emotion);
	}
	public float getEmotion() {
		return this.dataManager.get(GEM_EMOTION);
	}
	@Override
	public void setSwingingArms(boolean swinging) {
		if (swinging) {
			this.setPose(Pose.NOCKING_BOW);
		}
		else if (this.isSwingingArms()) {
			this.setPose(Pose.DEFAULT);
		}
	}
	public boolean isSwingingArms() {
		return this.getPose() == Pose.NOCKING_BOW;
	}
	public void setPose(Pose pose) {
		this.dataManager.set(POSE, pose.ordinal());
	}
	public Pose getPose() {
		return Pose.values()[this.dataManager.get(POSE)];
	}
	public void setHighlighted(boolean highlighted) {
		this.dataManager.set(IS_HIGHLIGHTED, highlighted);
	}
	public boolean isHighlighted() {
		return this.dataManager.get(IS_HIGHLIGHTED);
	}
	public void setOriginalPosition(BlockPos pos) {
		if (pos != null) {
			this.dataManager.set(ORIGINAL_POS, pos);
		}
	}
	public BlockPos getOriginalPosition() {
		BlockPos pos = this.dataManager.get(ORIGINAL_POS);
		if (pos == null) {
			return BlockPos.ORIGIN;
		}
		else {
			return pos;
		}
	}
	public void setOriginalDimension(int dimension) {
		this.dataManager.set(ORIGINAL_DIM, dimension);
	}
	public int getOriginalDimension() {
		return this.dataManager.get(ORIGINAL_DIM);
	}
	public String getNameFromCut(String cut) {
		return "Cut";
	}
	public String getDescriptor(int piece) {
		BlockPos pos = this.getOriginalPosition();
		String prefix = "";
		switch (piece) {
		case 0:
			prefix = "Facet";
		case 1:
			String facet = Integer.toString(Math.abs(((pos.getX() / 16) + (pos.getZ() / 16)) / 3), 36).toUpperCase();
			return String.format("%s %s", prefix, facet);
		case 2:
			prefix = this.getNameFromCut(this.getGemstoneCut());
		case 3:
            String cutX = Integer.toString(Math.abs((pos.getX() % 10))).toUpperCase();
            String cutY = Integer.toString(Math.abs((pos.getY() / 4) % 36), 36).toUpperCase();
            String cutZ = Integer.toString(Math.abs((pos.getZ() % 26) + 10), 36).toUpperCase();
            return String.format("%s %s%s%s", prefix, cutX, cutZ, cutY);
		default:
			return String.format("%s %s", this.getDescriptor(0), this.getDescriptor(2));
		}
	}
	public String getDescriptor() {
		return this.getDescriptor(-1);
	}
	public void setInsigniaColor(int color) {
		this.dataManager.set(COLOR_DYE_INSIGNIA, color);
	}
	public int getInsigniaColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return Ke2Gems.BASIC_WHITE;
		}
		else {
			return this.dataManager.get(COLOR_DYE_INSIGNIA);
		}
	}
	public void setOutfitColor(int color) {
		this.dataManager.set(COLOR_RGB_OUTFIT, color);
	}
	public int getOutfitColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		}
		else {
			return this.dataManager.get(COLOR_RGB_OUTFIT);
		}
	}
	public void setVisorColor(int color) {
		this.dataManager.set(COLOR_RGB_VISOR, color);
	}
	public int getVisorColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		}
		else {
			return this.dataManager.get(COLOR_RGB_VISOR);
		}
	}
	public void setSkinColor(int color) {
		this.dataManager.set(COLOR_RGB_SKIN, color);
	}
	public int getSkinColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		}
		else {
			return this.dataManager.get(COLOR_RGB_SKIN);
		}
	}
	public void setHairColor(int color) {
		this.dataManager.set(COLOR_RGB_HAIR, color);
	}
	public int getHairColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		}
		else {
			return this.dataManager.get(COLOR_RGB_HAIR);
		}
	}
	public void setGemstoneColor(int color) {
		this.dataManager.set(COLOR_RGB_GEMSTONE, color);
	}
	public int getGemstoneColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		}
		else {
			return this.dataManager.get(COLOR_RGB_GEMSTONE);
		}
	}
	public void setHairVariant(String variant) {
		this.dataManager.set(VARIANT_HAIR, variant);
	}
	public String getHairVariant() {
		return this.dataManager.get(VARIANT_HAIR);
	}
	public void setOutfitVariant(String variant) {
		this.dataManager.set(VARIANT_OUTFIT, variant);
	}
	public String getOutfitVariant() {
		return this.dataManager.get(VARIANT_OUTFIT);
	}
	public void setSkinVariant(String variant) {
		this.dataManager.set(VARIANT_SKIN, variant);
	}
	public String getSkinVariant() {
		return this.dataManager.get(VARIANT_SKIN);
	}
	public void setGemstonePosition(int pos) {
		this.dataManager.set(GEMSTONE_POS, pos);
	}
	public int getGemstonePosition() {
		return this.dataManager.get(GEMSTONE_POS);
	}
	public boolean canGemstoneGlow() {
		return this.world.getLight(this.getPosition().down()) < 5;
	}
	public void setGemstoneDirection(EnumFacing direction) {
		this.dataManager.set(GEMSTONE_DIR, direction);
	}
	public EnumFacing getGemstoneDirection() {
		EnumFacing direction = this.dataManager.get(GEMSTONE_DIR);
		if (direction == null) {
			return EnumFacing.NORTH;
		}
		else {
			return direction;
		}
	}
	public void setGemstoneCut(String cut) {
		this.dataManager.set(GEMSTONE_CUT, cut);
	}
	public String getGemstoneCut() {
		return this.dataManager.get(GEMSTONE_CUT);
	}
	public void setDefective(boolean defective) {
		this.dataManager.set(IS_DEFECTIVE, defective);
		if (this.isDefective() && this.changesScaleBasedOnCondition) {
			this.setSize(this.width * 0.5F, this.height * 0.5F);
		}
	}
	public boolean isDefective() {
		return this.dataManager.get(IS_DEFECTIVE);
	}
	public void setPerfect(boolean perfect) {
		this.dataManager.set(IS_PERFECT, perfect);
		if (this.isPerfect() && this.changesScaleBasedOnCondition) {
			this.setSize(this.width * 1.5F, this.height * 1.5F);
		}
	}
	public boolean isPerfect() {
		return this.dataManager.get(IS_PERFECT);
	}
	@Override
	protected void updateEquipmentIfNeeded(EntityItem item) {
        ItemStack stack = item.getItem();
        ItemStack inventory = this.inventory.addItem(stack);
        if (inventory.isEmpty()) {
        	item.setDead();
        }
        else {
        	stack.setCount(inventory.getCount());
        }
	}
	public boolean canPickUpItem(Item item) {
		return false;
	}
	public boolean canUnloadInventory() {
		if (this.inventory.getSizeInventory() > 0) {
			float max = this.inventory.getSizeInventory() + 1;
			int count = 0;
			for (int i = 0; i < this.inventory.getSizeInventory(); ++i) {
				ItemStack stack = this.inventory.getStackInSlot(i);
				if (!stack.isEmpty()) {
					++count;
				}
			}
			float ratio = count / max;
			return ratio > 0.5F;
		}
		return false;
	}
	private void createInventory() {
        InventoryBasic inventory = this.inventory;
        this.inventory = new InventoryBasic("inventory", false, this.getMaxInventorySlots());
        if (inventory != null) {
        	inventory.removeInventoryChangeListener(this);
            for (int i = 0; i < this.inventory.getSizeInventory(); ++i) {
                ItemStack stack = inventory.getStackInSlot(i);
                this.inventory.setInventorySlotContents(i, stack.copy());
            }
        }
        this.inventory.addInventoryChangeListener(this);
        this.storageHandler = new InvWrapper(this.inventory);
    }
	public void openGUI(EntityPlayer player) {
        if (!this.world.isRemote) {
            this.inventory.setCustomName(this.getName() + (this.getName().matches("(z|s)$") ? "'" : "'s") + " Gem");
            player.displayGUIChest(this.inventory);
        }
    }
	public int getMaxInventorySlots() {
		return 0;
	}
	protected int extrapolate(int... colors) {
		if (colors.length == 0) {
			return 0x000000;
		}
		if (colors.length == 1) {
			return colors[0];
		}
		int bound = this.rand.nextInt(colors.length - 1);
		float rand = this.rand.nextFloat();
        int bR = (colors[bound] & 16711680) >> 16;
        int bG = (colors[bound] & 65280) >> 8;
        int bB = (colors[bound] & 255) >> 0;
        int eR = (colors[bound + 1] & 16711680) >> 16;
        int eG = (colors[bound + 1] & 65280) >> 8;
        int eB = (colors[bound + 1] & 255) >> 0;
        int r = (int)(rand * bR + (1 - rand) * eR); 
		int g = (int)(rand * bG + (1 - rand) * eG); 
		int b = (int)(rand * bB + (1 - rand) * eB); 
		return (r << 16) + (g << 8) + b;
	}
	private void updateCape() {
        this.prevChasingPosX = this.chasingPosX;
        this.prevChasingPosY = this.chasingPosY;
        this.prevChasingPosZ = this.chasingPosZ;
        double x = this.posX - this.chasingPosX;
        double y = this.posY - this.chasingPosY;
        double z = this.posZ - this.chasingPosZ;
        if (x > 10.0D || x < -10.0D) {
            this.prevChasingPosX = this.chasingPosX;
            this.chasingPosX = this.posX;
        }
        if (y > 10.0D || y < -10.0D) {
            this.prevChasingPosY = this.chasingPosY;
            this.chasingPosY = this.posY;
        }
        if (z > 10.0D || z < -10.0D) {
            this.prevChasingPosZ = this.chasingPosZ;
            this.chasingPosZ = this.posZ;
        }
        this.chasingPosX += x * 0.25D;
        this.chasingPosY += y * 0.25D;
        this.chasingPosZ += z * 0.25D;
    }
	public float getClosestEmotion() {
    	int emotion = Ke2Gems.EMOTIONAL_WAVELENGTHS[(int)(this.getEmotion() % 1 * 8)];
    	switch (emotion) {
    	case 0:
    		return Ke2Gems.EMOTION_DREAD;
    	case 1:
    		return Ke2Gems.EMOTION_GRIEF;
    	case 2:
    		return Ke2Gems.EMOTION_DOUBT;
    	case 3:
    		return Ke2Gems.EMOTION_SHAME;
    	case 4:
    		return Ke2Gems.EMOTION_HYPED;
    	case 5:
    		return Ke2Gems.EMOTION_HAPPY;
    	case 6:
    		return Ke2Gems.EMOTION_PRIDE;
    	case 7:
    		return Ke2Gems.EMOTION_ANGER;
    	default:
        	return Ke2Gems.EMOTION_DREAD;
    	}
	}
	public boolean setEmotion(float emotion, float step) {
		if (this.getEmotion() != emotion) {
			if (this.getEmotion() < emotion) {
				this.setEmotion((this.getEmotion() + Math.min(emotion - this.getEmotion(), step)) % 1);
			}
			else {
				this.setEmotion((this.getEmotion() - Math.min(emotion - this.getEmotion(), step)) % 1);
			}
			return true;
		}
		return false;
	}
	public boolean canFeel(float range) {
		double maxDist = Double.MAX_VALUE;
	    float r = (this.getSkinColor() & 16711680) >> 16;
        float g = (this.getSkinColor() & 65280) >> 8;
		float b = (this.getSkinColor() & 255) >> 0;
    	int color = Ke2Gems.EMOTIONAL_WAVELENGTHS[(int)(range * 8)];
    	int closestColor = -1;
    	for (int i = 0; i < Ke2Gems.EMOTIONAL_WAVELENGTHS.length; ++i) {
			float eR = (color & 16711680) >> 16;
	        float eG = (color & 65280) >> 8;
	        float eB = (color & 255) >> 0;
			double dist = Math.sqrt(Math.pow(eR - r, 2) + Math.pow(eG - g, 2) + Math.pow(eB - b, 2));
			if (dist < maxDist) {
				maxDist = dist;
				closestColor = i;
			}
    	}
		return closestColor == color;
	}
	public boolean isFeeling(float emotion) {
		return false;
	}
	protected float generateEmotion() {
		return Ke2Gems.EMOTION_HAPPY;
	}
	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeFloat(this.width);
		buffer.writeFloat(this.height);
	}
	@Override
	public void readSpawnData(ByteBuf buffer) {
		this.setSize(buffer.readFloat(), buffer.readFloat());
	}
}
