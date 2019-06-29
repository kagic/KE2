package mod.ke2.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.common.base.Optional;

import io.netty.buffer.ByteBuf;
import mod.ke2.api.injection.GemSpawnData;
import mod.ke2.api.variants.VariantHelper;
import mod.ke2.entity.gem.ai.EntityAIFollowTheLeader;
import mod.ke2.init.Ke2Damage;
import mod.ke2.init.Ke2Gems;
import mod.ke2.init.Ke2Items;
import mod.ke2.init.Ke2Sounds;
import mod.ke2.world.data.WorldDataFactions;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
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
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.items.wrapper.InvWrapper;

public abstract class EntityGem extends EntityGemBase implements IGem, IInventoryChangedListener, IRangedAttackMob, IEntityAdditionalSpawnData {
	public static final String[] BLACKLISTED_NBT_TAGS = new String[]{"Pos", "Motion", "Rotation", "FallDistance", "Fire", "Air", "OnGround", "Dimension", "Invulnerable", "PortalCooldown", "UUID", "NoGravity", "Glowing", "Passengers", "NoAI", "Health", "HurtTime", "HurtByTimestamp", "DeathTime", "AbsorptionAmount", "ActiveEffects", "GemstoneItem"};
	
	public enum Pose {
		DEFAULT, NOCKING_BOW, FLAILING, USING_POWERS, SALUTING, WAVING, DABBING, POSSESSED, YELLING, HEAD_BANGING
	}
	
	protected static final DataParameter<Optional<UUID>> GEM_UNIQUE_ID = EntityDataManager.<Optional<UUID>>createKey(EntityGem.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	protected static final DataParameter<Optional<UUID>> GEM_FACTION_ID = EntityDataManager.<Optional<UUID>>createKey(EntityGem.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	protected static final DataParameter<Optional<UUID>> GEM_LEADER_ID = EntityDataManager.<Optional<UUID>>createKey(EntityGem.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	protected static final DataParameter<Integer> GEM_ALIGNMENT = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Float> GEM_EMOTION = EntityDataManager.<Float>createKey(EntityGem.class, DataSerializers.FLOAT);
	protected static final DataParameter<Integer> POSE = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> IS_HIGHLIGHTED = EntityDataManager.<Boolean>createKey(EntityGem.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<BlockPos> ORIGINAL_POS = EntityDataManager.<BlockPos>createKey(EntityGem.class, DataSerializers.BLOCK_POS);
	protected static final DataParameter<Integer> ORIGINAL_DIM = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> COLOR_DYE_INSIGNIA = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> COLOR_RGB_OUTFIT = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> COLOR_RGB_VISOR = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> COLOR_RGB_SKIN = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> COLOR_RGB_HAIR = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> COLOR_RGB_GEMSTONE = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<String> VARIANT_OUTFIT = EntityDataManager.<String>createKey(EntityGem.class, DataSerializers.STRING);
	protected static final DataParameter<String> VARIANT_HAIR = EntityDataManager.<String>createKey(EntityGem.class, DataSerializers.STRING);
	protected static final DataParameter<String> VARIANT_SKIN = EntityDataManager.<String>createKey(EntityGem.class, DataSerializers.STRING);
	protected static final DataParameter<String> VARIANT_NAME = EntityDataManager.<String>createKey(EntityGem.class, DataSerializers.STRING);
	protected static final DataParameter<Integer> GEMSTONE_POS = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> GEMSTONE_CUT = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	protected static final DataParameter<ItemStack> GEMSTONE_ITEM = EntityDataManager.<ItemStack>createKey(EntityGem.class, DataSerializers.ITEM_STACK);
	protected static final DataParameter<Boolean> IS_DEFECTIVE = EntityDataManager.<Boolean>createKey(EntityGem.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> IS_PERFECT = EntityDataManager.<Boolean>createKey(EntityGem.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> FLOWER_IN_HAIR = EntityDataManager.<Integer>createKey(EntityGem.class, DataSerializers.VARINT);
	/**
	 * Resource location of entity is stored as the key and
	 * the emotional resource is the value. Determines part
	 * of the environmental emotional score.
	 */
	public HashMap<ResourceLocation, Float> biasTowardsMobs = new HashMap<ResourceLocation, Float>();
	/**
	 * If true, then the gem is 50% size when defective and
	 * 150% size when perfective.
	 */
	protected boolean changesScaleBasedOnCondition = true;
	/**
	 * Default outfit color is analog to KAGIC's native
	 * color.
	 */
	protected int defaultOutfitColor = 0;
	/**
	 * Eye height placeholder value used for scaling with
	 * height.
	 */
	protected float eyeHeight = 0.85F;
	
	/** Handles inventory events for AI purposes. */
	public InvWrapper storageHandler;
	/**
	 * Gem storage, all gems have this, not all use it
	 * though.
	 */
	public InventoryBasic inventory;
	/**
	 * Multiplier determining vocal pitch.
	 */
	public int vocalOctave;
	
	public double prevChasingPosX;
	public double prevChasingPosY;
	public double prevChasingPosZ;
	public double chasingPosX;
	public double chasingPosY;
	public double chasingPosZ;
	
	public EntityGem(World world) {
		super(world);
		this.tasks.addTask(3, new EntityAIFollowTheLeader(this, 0.5D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, Entity.class, 8.0F));
		this.tasks.addTask(7, new EntityAIWander(this, 0.3D));
		this.dataManager.register(EntityGem.GEM_UNIQUE_ID, Optional.absent());
		this.dataManager.register(EntityGem.GEM_FACTION_ID, Optional.absent());
		this.dataManager.register(EntityGem.GEM_LEADER_ID, Optional.absent());
		this.dataManager.register(EntityGem.GEM_ALIGNMENT, 0);
		this.dataManager.register(EntityGem.GEM_EMOTION, 565.0F);
		this.dataManager.register(EntityGem.POSE, 0);
		this.dataManager.register(EntityGem.IS_HIGHLIGHTED, false);
		this.dataManager.register(EntityGem.ORIGINAL_POS, BlockPos.ORIGIN);
		this.dataManager.register(EntityGem.ORIGINAL_DIM, 0);
		this.dataManager.register(EntityGem.COLOR_DYE_INSIGNIA, -1);
		this.dataManager.register(EntityGem.COLOR_RGB_OUTFIT, 0);
		this.dataManager.register(EntityGem.COLOR_RGB_VISOR, 0);
		this.dataManager.register(EntityGem.COLOR_RGB_SKIN, 0);
		this.dataManager.register(EntityGem.COLOR_RGB_HAIR, 0);
		this.dataManager.register(EntityGem.COLOR_RGB_GEMSTONE, 0);
		this.dataManager.register(EntityGem.VARIANT_OUTFIT, "");
		this.dataManager.register(EntityGem.VARIANT_HAIR, "");
		this.dataManager.register(EntityGem.VARIANT_SKIN, "");
		this.dataManager.register(EntityGem.VARIANT_NAME, "");
		this.dataManager.register(EntityGem.GEMSTONE_POS, -1);
		this.dataManager.register(EntityGem.GEMSTONE_CUT, -1);
		this.dataManager.register(EntityGem.GEMSTONE_ITEM, ItemStack.EMPTY);
		this.dataManager.register(EntityGem.IS_DEFECTIVE, false);
		this.dataManager.register(EntityGem.IS_PERFECT, false);
		this.dataManager.register(EntityGem.FLOWER_IN_HAIR, 0);
		this.setAlwaysRenderNameTag(true);
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
		this.setGemUniqueID(UUID.randomUUID());
		if (data instanceof GemSpawnData) {
			GemSpawnData gemSpawnData = (GemSpawnData) data;
			this.setFactionID(gemSpawnData.getOwner());
			this.setGemAlignment(Ke2Gems.ALIGNED_WITH_PLAYERS);
			this.setInsigniaColor(gemSpawnData.getColor());
			this.setDefective(gemSpawnData.isDefective());
			this.setPerfective(gemSpawnData.isPerfective());
		}
		this.setOriginalPosition(this.getPosition());
		this.setOriginalDimension(this.dimension);
		this.setGemstonePosition(this.rand.nextInt(18));
		this.setOutfitVariant(this.generateOutfitVariant());
		this.setHairVariant(this.generateHairVariant());
		this.setSkinVariant(this.generateSkinVariant());
		this.setNameVariant(this.generateNameVariant());
		this.setOutfitColor(this.generateOutfitColor());
		this.setVisorColor(this.generateVisorColor());
		this.setSkinColor(this.generateSkinColor());
		this.setHairColor(this.generateHairColor());
		this.setGemstoneColor(this.generateGemstoneColor());
		this.setGemstoneCut(this.generateGemstoneCut());
		this.setGemstoneItem(this.generateGemstoneItem());
		this.setVocalOctave(this.generateVocalOctave());
		this.setHealth(this.getMaxHealth());
		this.stepHeight = Math.min(0.5F, this.height / 2);
		return data;
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey("GemUniqueID")) {
			this.setGemUniqueID(UUID.fromString(compound.getString("GemUniqueID")));
		}
		if (compound.hasKey("FactionID")) {
			this.setFactionID(UUID.fromString(compound.getString("FactionID")));
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
		this.setOutfitVariant(compound.getString("OutfitVariant"));
		this.setHairVariant(compound.getString("HairVariant"));
		this.setSkinVariant(compound.getString("SkinVariant"));
		this.setNameVariant(compound.getString("NameVariant"));
		this.setDefective(compound.getBoolean("Defective"));
		this.setPerfective(compound.getBoolean("Perfective"));
		this.setFlowerInHair(compound.getInteger("FlowerInHair"));
		this.setVocalOctave(compound.getInteger("VocalOctave"));
		NBTTagList biases = compound.getTagList("BiasTowardsMobs", 10);
		for (int i = 0; i < biases.tagCount(); ++i) {
			NBTTagCompound tag = biases.getCompoundTagAt(i);
			this.biasTowardsMobs.put(new ResourceLocation(tag.getString("Mob")), tag.getFloat("Bias"));
		}
		this.createInventory();
		NBTTagList inventory = compound.getTagList("Inventory", 10);
		for (int i = 0; i < inventory.tagCount(); ++i) {
			NBTTagCompound tag = inventory.getCompoundTagAt(i);
			int s = tag.getByte("Slot") & 255;
			if (s >= 0 && s < this.inventory.getSizeInventory()) {
				this.inventory.setInventorySlotContents(s, new ItemStack(tag));
			}
		}
		this.setGemstonePosition(compound.getInteger("GemstonePosition"));
		this.setGemstoneColor(compound.getInteger("GemstoneColor"));
		this.setGemstoneCut(compound.getInteger("GemstoneCut"));
		this.setGemstoneItem(new ItemStack(compound.getCompoundTag("GemstoneItem")));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString("Species", Ke2Gems.REGISTRY_REVERSE.get(this.getClass()).toString());
		if (this.getGemUniqueID() != null) {
			compound.setString("GemUniqueID", this.getGemUniqueID().toString());
		}
		if (this.getFactionID() != null) {
			compound.setString("FactionID", this.getFactionID().toString());
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
		compound.setString("OutfitVariant", this.getOutfitVariant());
		compound.setString("HairVariant", this.getHairVariant());
		compound.setString("SkinVariant", this.getSkinVariant());
		compound.setString("NameVariant", this.getNameVariant());
		compound.setBoolean("Defective", this.isDefective());
		compound.setBoolean("Perfective", this.isPerfective());
		compound.setInteger("FlowerInHair", this.getFlowerInHair());
		compound.setInteger("VocalOctave", this.getVocalOctave());
		NBTTagList biases = new NBTTagList();
		Iterator<ResourceLocation> it = this.biasTowardsMobs.keySet().iterator();
		while (it.hasNext()) {
			ResourceLocation key = it.next();
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("Mob", key.toString());
			tag.setFloat("Bias", this.biasTowardsMobs.get(key));
			biases.appendTag(tag);
		}
		compound.setTag("BiasTowardsMobs", biases);
		this.createInventory();
		NBTTagList inventory = new NBTTagList();
		for (int i = 0; i < this.inventory.getSizeInventory(); ++i) {
			ItemStack stack = this.inventory.getStackInSlot(i);
			if (stack.getTagCompound() == null || !stack.getTagCompound().getBoolean("IsGem")) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				inventory.appendTag(tag);
			}
		}
		compound.setTag("Inventory", inventory);
		compound.setInteger("GemstonePosition", this.getGemstonePosition());
		compound.setInteger("GemstoneColor", this.getGemstoneColor());
		compound.setInteger("GemstoneCut", this.getGemstoneCut());
		compound.setTag("GemstoneItem", this.getGemstoneItem().serializeNBT());
	}
	
	@Override
	public String getName() {
		if (this.hasCustomName()) {
			return this.getCustomNameTag();
		} else {
			String name = this.getNameVariant();
			if (name == null || name.isEmpty()) {
				name = EntityList.getEntityString(this);
				if (name == null) {
					name = "gem";
				}
			}
			return I18n.translateToLocal("entity." + name + ".name");
		}
	}
	
	@Override
	public boolean canDespawn() {
		return false;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.world.isRemote) {
			double x, y, z, vx, vy, vz;
			switch (this.getEmotionalState()) {
				case Ke2Gems.EMOTION_ROMANCE :
					if (this.ticksExisted % 5 == 0) {
						x = this.posX + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.8 : 0.8);
						y = this.posY + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5) + this.height / 2.0;
						z = this.posZ + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.8 : 0.8);
						vx = 0.0;
						vy = this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						vz = 0.0;
						this.world.spawnParticle(EnumParticleTypes.HEART, x, y, z, vx, vy, vz);
					}
					break;
				case Ke2Gems.EMOTION_PLEASED :
					if (this.ticksExisted % 10 == 0) {
						x = this.posX + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.8 : 0.8);
						y = this.posY + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5) + this.height / 2.0;
						z = this.posZ + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.8 : 0.8);
						vx = this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						vy = this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						vz = this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x, y, z, vx, vy, vz);
					}
					break;
				case Ke2Gems.EMOTION_SADNESS :
					if (this.ticksExisted % 1 == 0) {
						x = this.posX - Math.sin(Math.PI / 180.0 * this.rotationYawHead) * (this.rand.nextBoolean() ? 0.3 : -0.3);
						y = this.posY + this.eyeHeight + this.rand.nextDouble() * 0.5;
						z = this.posZ + Math.cos(Math.PI / 180.0 * this.rotationYawHead) * (this.rand.nextBoolean() ? 0.3 : -0.3);
						vx = this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						vy = this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.8 : 0.8);
						vz = this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						this.world.spawnParticle(EnumParticleTypes.WATER_DROP, x, y, z, vx, vy, vz);
					}
					break;
				case Ke2Gems.EMOTION_FEARFUL :
					if (this.ticksExisted % 10 == 0) {
						x = this.posX + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						y = this.posY + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5) + this.height;
						z = this.posZ + this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						vx = 0.0;
						vy = this.rand.nextDouble() * (this.rand.nextBoolean() ? -0.5 : 0.5);
						vz = 0.0;
						this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, x, y, z, vx, vy, vz);
					}
					break;
			}
		}
	}
	
	@Override
	public void onUpdate() {
		if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
			this.dead = this.getHealth() > 0;
		}
		super.onUpdate();
		this.motionY *= this.getFallSpeed();
		this.updateCape();
	}
	
	@Override
	protected boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!this.world.isRemote) {
			System.out.println(WorldDataFactions.get(world).getFaction(player.getUniqueID()));
			ItemStack stack = player.getHeldItem(hand);
			Item item = stack.getItem();
			if (this.isOwnedBy(player)) {
				if (item == Ke2Items.GEM_STAFF) {
					if (this.isLeader(player)) {
						this.tell(player, "I'll stop following you now.");
						this.setLeader(this);
					} else {
						this.tell(player, "I'll follow you now.");
						this.setLeader(player);
					}
				}
			} else if (this.hasFaction()) {
				this.tell(player, "YOU DON'T KNOW ME!");
			} else {
				if (item == Ke2Items.GEM_STAFF) {
					this.tell(player, "I'm forever at your service!");
					this.setFactionID(player.getUniqueID());
				}
			}
		}
		return super.processInteract(player, hand);
	}
	
	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			boolean reverse = false;
			if (this instanceof EntityGemFusion) {
				EntityGemFusion fusion = (EntityGemFusion) this;
				fusion.unfuse();
				fusion.setDead();
			} else {
				this.setGemstoneItem();
				if (this.world.getGameRules().getBoolean("showDeathMessages")) {
					if (!this.hasCustomName()) {
						this.setCustomNameTag(String.format("%s-%s", this.getName(), this.getDescriptor(3)));
						reverse = true;
					}
					for (EntityPlayer player : this.world.playerEntities) {
						player.sendMessage(cause.getDeathMessage(this));
					}
					if (reverse) {
						this.setCustomNameTag("");
					}
				}
				this.entityDropItem(this.getGemstoneItem(), 0.0F);
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
			// TODO: Ensure we have all the (universal)
			// damage types listed.
			if (source.damageType.matches("(?i:magic|drown|vacuum|oxygen_suffocation|electricity|radiation)")) {
				return false;
			}
			float health = this.getHealth() - amount;
			if (health < -70) {
				source = Ke2Damage.SHATTER;
			} else if (health < -30) {
				source = Ke2Damage.CRACK;
			} else {
				source = Ke2Damage.POOF;
			}
		}
		return super.attackEntityFrom(source, amount);
	}
	
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntityTippedArrow arrow = new EntityTippedArrow(this.world, this);
		double distanceFromTargetX = target.posX - this.posX;
		double distanceFromTargetY = target.getEntityBoundingBox().minY + target.height - arrow.posY;
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
		this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (this.rand.nextFloat() * 0.4F + 0.8F));
		this.world.spawnEntity(arrow);
	}
	
	public boolean isHoldingRangedWeapon() {
		ItemStack stack = this.getHeldItem(EnumHand.MAIN_HAND);
		if (stack.getItem().getItemUseAction(stack) == EnumAction.BOW) {
			return true;
		} else {
			return false;
		}
	}
	
	public double getFallSpeed() {
		return 1.0D;
	}
	
	public void tell(EntityPlayer player, String line, Object... formatting) {
		player.sendMessage(new TextComponentString("<" + this.getName() + "> " + String.format(line, formatting)));
	}
	
	public void say(String line, Object... formatting) {
		List<EntityPlayer> list = this.world.playerEntities;
		for (EntityPlayer player : list) {
			if (this.isOwnedBy(player) || player.getDistance(this) < 16.0F) {
				this.tell(player, line, formatting);
			}
		}
	}
	
	public boolean isLeader(EntityPlayer player) {
		return this.isLeader(player.getUniqueID());
	}
	
	public boolean isLeader(EntityGem gem) {
		return this.isLeader(gem.getGemUniqueID());
	}
	
	public boolean isLeader(UUID id) {
		return this.getGemLeaderID() != null && this.getGemLeaderID().equals(id);
	}
	
	public EntityLivingBase getLeader() {
		EntityPlayer player = this.world.getPlayerEntityByUUID(this.getGemLeaderID());
		if (player == null) {
			List<EntityGem> gems = this.world.getEntitiesWithinAABB(EntityGem.class, this.getEntityBoundingBox().grow(8.0D, 4.0D, 8.0D));
			for (EntityGem gem : gems) {
				if (gem.getGemUniqueID().equals(this.getGemLeaderID())) {
					return gem;
				}
			}
		}
		return player;
	}
	
	public void setLeader(EntityPlayer player) {
		this.setGemLeaderID(player.getUniqueID());
	}
	
	public void setLeader(EntityGem gem) {
		this.setGemLeaderID(gem.getGemUniqueID());
	}
	
	public boolean isOwnedBy(EntityPlayer player) {
		return this.isOwnedBy(player.getUniqueID());
	}
	
	public boolean isOwnedBy(EntityGem gem) {
		return this.isOwnedBy(gem.getGemUniqueID());
	}
	
	public boolean isOwnedBy(UUID id) {
		if (this.hasFaction()) {
			WorldDataFactions faction = WorldDataFactions.get(this.world);
			if (faction.isAuthorized(id, this.getFactionID())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasFaction() {
		return this.getFactionID() != null;
	}
	
	public void setFactionID(UUID id) {
		this.dataManager.set(EntityGem.GEM_FACTION_ID, Optional.<UUID>fromNullable(id));
	}
	
	public UUID getFactionID() {
		return this.dataManager.get(EntityGem.GEM_FACTION_ID).orNull();
	}
	
	public void setGemUniqueID(UUID id) {
		this.dataManager.set(EntityGem.GEM_UNIQUE_ID, Optional.<UUID>fromNullable(id));
	}
	
	public UUID getGemUniqueID() {
		return this.dataManager.get(EntityGem.GEM_UNIQUE_ID).orNull();
	}
	
	public void setGemLeaderID(UUID id) {
		this.dataManager.set(EntityGem.GEM_LEADER_ID, Optional.<UUID>fromNullable(id));
	}
	
	public UUID getGemLeaderID() {
		return this.dataManager.get(EntityGem.GEM_LEADER_ID).or(this.getUniqueID());
	}
	
	public void setGemAlignment(int alignment) {
		this.dataManager.set(EntityGem.GEM_ALIGNMENT, alignment);
	}
	
	public int getGemAlignment() {
		return this.dataManager.get(EntityGem.GEM_ALIGNMENT);
	}
	
	public void setEmotion(float emotion) {
		this.dataManager.set(EntityGem.GEM_EMOTION, emotion);
	}
	
	public float getEmotion() {
		return this.dataManager.get(EntityGem.GEM_EMOTION);
	}

	public int getEmotionalState() {
		if (this.getEmotion() < 470.0F) {
			return Ke2Gems.EMOTION_ROMANCE;
		} else if (this.getEmotion() < 530.0F) {
			return Ke2Gems.EMOTION_PLEASED;
		} else if (this.getEmotion() < 600.0F) {
			return Ke2Gems.EMOTION_RELAXED;
		} else if (this.getEmotion() < 660.0F) {
			return Ke2Gems.EMOTION_NERVOUS;
		} else if (this.getEmotion() < 725.0F) {
			return Ke2Gems.EMOTION_SADNESS;
		} else {
			return Ke2Gems.EMOTION_FEARFUL;
		}
	}

	public boolean setEmotionalState(float emotion, float step) {
		if (this.getEmotion() != emotion) {
			if (this.getEmotion() < emotion) {
				this.setEmotion((this.getEmotion() + Math.min(emotion - this.getEmotion(), step)) % 1);
			} else {
				this.setEmotion((this.getEmotion() - Math.min(emotion - this.getEmotion(), step)) % 1);
			}
			return true;
		}
		return false;
	}
	
	public boolean isFeeling(float emotion) {
		return false;
	}
	
	@Override
	public void setSwingingArms(boolean swinging) {
		if (swinging) {
			this.setPose(Pose.NOCKING_BOW);
		} else if (this.isSwingingArms()) {
			this.setPose(Pose.DEFAULT);
		}
	}
	
	public boolean isSwingingArms() {
		return this.getPose() == Pose.NOCKING_BOW;
	}
	
	public void setPose(Pose pose) {
		this.dataManager.set(EntityGem.POSE, pose.ordinal());
	}
	
	public Pose getPose() {
		return Pose.values()[this.dataManager.get(EntityGem.POSE)];
	}
	
	public void setHighlighted(boolean highlighted) {
		this.dataManager.set(EntityGem.IS_HIGHLIGHTED, highlighted);
	}
	
	public boolean isHighlighted() {
		return this.dataManager.get(EntityGem.IS_HIGHLIGHTED);
	}
	
	public void setOriginalPosition(BlockPos pos) {
		if (pos != null) {
			this.dataManager.set(EntityGem.ORIGINAL_POS, pos);
		}
	}
	
	public BlockPos getOriginalPosition() {
		BlockPos pos = this.dataManager.get(EntityGem.ORIGINAL_POS);
		if (pos == null) {
			return BlockPos.ORIGIN;
		} else {
			return pos;
		}
	}
	
	public void setOriginalDimension(int dimension) {
		this.dataManager.set(EntityGem.ORIGINAL_DIM, dimension);
	}
	
	public int getOriginalDimension() {
		return this.dataManager.get(EntityGem.ORIGINAL_DIM);
	}
	
	public String getNameFromCut(int cut) {
		return "Cut";
	}
	
	public String getDescriptor(int piece) {
		BlockPos pos = this.getOriginalPosition();
		String prefix = "";
		switch (piece) {
			case 0 :
				prefix = "Facet";
			case 1 :
				String facet = Integer.toString(Math.abs((pos.getX() / 16 + pos.getZ() / 16) / 3), 36).toUpperCase();
				return String.format("%s %s", prefix, facet);
			case 2 :
				prefix = this.getNameFromCut(this.getGemstoneCut());
			case 3 :
				String cutX = Integer.toString(Math.abs(pos.getX() % 10)).toUpperCase();
				String cutY = Integer.toString(Math.abs(pos.getY() / 4 % 36), 36).toUpperCase();
				String cutZ = Integer.toString(Math.abs(pos.getZ() % 26 + 10), 36).toUpperCase();
				return String.format("%s %s%s%s", prefix, cutX, cutZ, cutY);
			default :
				return String.format("%s %s", this.getDescriptor(0), this.getDescriptor(2));
		}
	}
	
	public String getDescriptor() {
		return this.getDescriptor(-1);
	}
	
	public void setInsigniaColor(int color) {
		this.dataManager.set(EntityGem.COLOR_DYE_INSIGNIA, color);
	}
	
	public int getInsigniaColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return Ke2Gems.BASIC_WHITE;
		} else {
			return this.dataManager.get(EntityGem.COLOR_DYE_INSIGNIA);
		}
	}
	
	public void setOutfitColor(int color) {
		this.dataManager.set(EntityGem.COLOR_RGB_OUTFIT, color);
	}
	
	public int getOutfitColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		} else {
			return this.dataManager.get(EntityGem.COLOR_RGB_OUTFIT);
		}
	}
	
	public void setVisorColor(int color) {
		this.dataManager.set(EntityGem.COLOR_RGB_VISOR, color);
	}
	
	public int getVisorColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		} else {
			return this.dataManager.get(EntityGem.COLOR_RGB_VISOR);
		}
	}
	
	public void setSkinColor(int color) {
		this.dataManager.set(EntityGem.COLOR_RGB_SKIN, color);
	}
	
	public int getSkinColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		} else {
			return this.dataManager.get(EntityGem.COLOR_RGB_SKIN);
		}
	}
	
	public void setHairColor(int color) {
		this.dataManager.set(EntityGem.COLOR_RGB_HAIR, color);
	}
	
	public int getHairColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		} else {
			return this.dataManager.get(EntityGem.COLOR_RGB_HAIR);
		}
	}
	
	public void setGemstoneColor(int color) {
		this.dataManager.set(EntityGem.COLOR_RGB_GEMSTONE, color);
	}
	
	public int getGemstoneColor() {
		if (this.getGemAlignment() >= Ke2Gems.CONTROLLED_BY_WHITE) {
			return 0xFFFFFF;
		} else {
			return this.dataManager.get(EntityGem.COLOR_RGB_GEMSTONE);
		}
	}
	
	public void setGemstoneCut(int cut) {
		this.dataManager.set(EntityGem.GEMSTONE_CUT, cut);
	}
	
	public int getGemstoneCut() {
		return this.dataManager.get(EntityGem.GEMSTONE_CUT);
	}
	
	public void setGemstoneItem(Item item, int quantity, int meta) {
		ItemStack stack = new ItemStack(item, quantity, meta);
		stack.setTagCompound(this.getGemstoneTags());
		this.dataManager.set(EntityGem.GEMSTONE_ITEM, stack);
	}
	
	public void setGemstoneItem(ItemStack stack) {
		this.setGemstoneItem(stack.getItem(), stack.getCount(), stack.getMetadata());
	}
	
	public void setGemstoneItem(Item item) {
		this.setGemstoneItem(new ItemStack(item));
	}
	
	public void setGemstoneItem() {
		if (this.getGemstoneItem().isEmpty()) {
			this.setGemstoneItem(this.generateGemstoneItem());
		} else {
			this.setGemstoneItem(this.getGemstoneItem());
		}
	}
	
	public ItemStack getGemstoneItem() {
		return this.dataManager.get(EntityGem.GEMSTONE_ITEM);
	}
	
	public NBTTagCompound getGemstoneTags() {
		NBTTagCompound compound = this.writeToNBT(new NBTTagCompound());
		for (String tag : EntityGem.BLACKLISTED_NBT_TAGS) {
			compound.removeTag(tag);
		}
		return compound;
	}
	
	public void setHairVariant(String variant) {
		this.dataManager.set(EntityGem.VARIANT_HAIR, variant);
	}
	
	public String getHairVariant() {
		return this.dataManager.get(EntityGem.VARIANT_HAIR);
	}
	
	public void setOutfitVariant(String variant) {
		this.dataManager.set(EntityGem.VARIANT_OUTFIT, variant);
	}
	
	public String getOutfitVariant() {
		return this.dataManager.get(EntityGem.VARIANT_OUTFIT);
	}
	
	public void setSkinVariant(String variant) {
		this.dataManager.set(EntityGem.VARIANT_SKIN, variant);
	}
	
	public String getSkinVariant() {
		return this.dataManager.get(EntityGem.VARIANT_SKIN);
	}
	
	public void setNameVariant(String variant) {
		this.dataManager.set(EntityGem.VARIANT_NAME, variant);
	}
	
	public String getNameVariant() {
		return this.dataManager.get(EntityGem.VARIANT_NAME);
	}
	
	public void setGemstonePosition(int pos) {
		this.dataManager.set(EntityGem.GEMSTONE_POS, pos);
	}
	
	public int getGemstonePosition() {
		return this.dataManager.get(EntityGem.GEMSTONE_POS);
	}
	
	public void setDefective(boolean defective) {
		this.dataManager.set(EntityGem.IS_DEFECTIVE, defective);
		if (this.isDefective() && this.changesScaleBasedOnCondition) {
			this.setSize(this.width * 0.5F, this.height * 0.5F, this.eyeHeight * 0.5F);
		}
	}
	
	public boolean isDefective() {
		return this.dataManager.get(EntityGem.IS_DEFECTIVE);
	}
	
	public void setPerfective(boolean perfective) {
		this.dataManager.set(EntityGem.IS_PERFECT, perfective);
		if (this.isPerfective() && this.changesScaleBasedOnCondition) {
			this.setSize(this.width * 1.5F, this.height * 1.5F, this.eyeHeight * 1.5F);
		}
	}
	
	public boolean isPerfective() {
		return this.dataManager.get(EntityGem.IS_PERFECT);
	}
	
	public void setFlowerInHair(int flower) {
		this.dataManager.set(EntityGem.FLOWER_IN_HAIR, flower);
	}
	
	public int getFlowerInHair() {
		return this.dataManager.get(EntityGem.FLOWER_IN_HAIR);
	}
	
	@Override
	protected void updateEquipmentIfNeeded(EntityItem item) {
		ItemStack stack = item.getItem();
		ItemStack inventory = this.inventory.addItem(stack);
		if (inventory.isEmpty()) {
			item.setDead();
		} else {
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
	
	public void setVocalOctave(int vocalOctave) {
		this.vocalOctave = vocalOctave;
	}
	
	public int getVocalOctave() {
		return this.vocalOctave;
	}
	
	/**
	 * Generates a vocal octave. Vocal octaves
	 * are simple pitch adjustments done to
	 * the gem's original voice.
	 * Ranging from 0-3, there is a rare
	 * chance for gems to have higher
	 * or lower pitched voices.
	 * @return the selected octave.
	 */
	public int generateVocalOctave() {
		if (this.rand.nextFloat() > 0.02) {
			return this.rand.nextInt(6);
		}
		else if (this.rand.nextBoolean()) {
			return this.rand.nextInt(3) * -1;
		}
		else { 
			return this.rand.nextInt(3) +  6;
		}
	}

	protected void setSize(float width, float height, float eyeHeight) {
		super.setSize(width, height);
		this.eyeHeight = eyeHeight;
	}
	
	@Override
	public float getEyeHeight() {
		return this.eyeHeight;
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
	
	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeFloat(this.width);
		buffer.writeFloat(this.height);
	}
	
	@Override
	public void readSpawnData(ByteBuf buffer) {
		this.setSize(buffer.readFloat(), buffer.readFloat());
	}
	
	@Override
	protected float getSoundPitch() {
		return ((float)(this.getVocalOctave()) / 6.0F) + ((this.getEmotion() - 405.0F) / 320.0F) + 0.5F + (this.rand.nextFloat() / 10.0F - 0.05F);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
        return this.getGemSound();
    }

	@Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return this.getGemSound();
    }

	@Override
    protected SoundEvent getDeathSound() {
        return this.getGemSound();
    }

	@Override
	public int generateSkinColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.skin");
	}
	
	@Override
	public int generateHairColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.hair");
	}
	
	@Override
	public int generateOutfitColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.outfit");
	}
	
	@Override
	public int generateVisorColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.visor");
	}
	
	@Override
	public int generateGemstoneColor() {
		return VariantHelper.loadVariantColor(this, "ke2:color.gemstone");
	}
	
	@Override
	public ItemStack generateGemstoneItem() {
		return new ItemStack(Ke2Items.COLORED_GEMSTONE);
	}
	
	@Override
	public String generateOutfitVariant() {
		return VariantHelper.loadVariantPath(this, "ke2:texture.outfit");
	}
	
	@Override
	public String generateHairVariant() {
		return VariantHelper.loadVariantPath(this, "ke2:texture.hair");
	}
	
	@Override
	public String generateSkinVariant() {
		return VariantHelper.loadVariantPath(this, "ke2:texture.skin");
	}
	
	@Override
	public String generateNameVariant() {
		return VariantHelper.loadVariantName(this, "ke2:name");
	}
	
	@Override
	public SoundEvent getGemSound() {
		return Ke2Sounds.GEM_GENERIC;
	}
}
