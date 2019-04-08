package mod.ke2.enchant;

import java.util.HashMap;

import mod.ke2.entity.EntityGemShard;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class EnchantShard extends Enchantment {
	public static final HashMap<String, EnchantShard> ENCHANTS = new HashMap<String, EnchantShard>();
	public final int color;
	public EnchantShard(int color) {
		super(Rarity.UNCOMMON, EnumEnchantmentType.ALL, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND });
		this.setRegistryName(new ResourceLocation("ke2:gem_shard_" + color));
		this.setName("gem_shard_" + color + ".name");
		this.color = color;
		ENCHANTS.put("gem_shard_" + color, this);
	}
	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		if (target instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase)(target);
			for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
				ItemStack stack = entity.getItemStackFromSlot(slot);
				NBTTagList enchantments = stack.getEnchantmentTagList();
				for (int i = 0; i < enchantments.tagCount(); i++) {
					if (Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")) instanceof EnchantShard) {
						EnchantShard en = (EnchantShard)(Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")));
						entity.addPotionEffect(this.getDeBuff(en.color));
					}
				}
			}
		}
    }
    @Override
	public void onUserHurt(EntityLivingBase user, Entity attacker, int level) {
    	for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
    		ItemStack stack = user.getItemStackFromSlot(slot);
			NBTTagList enchantments = stack.getEnchantmentTagList();
			for (int i = 0; i < enchantments.tagCount(); i++) {
				if (Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")) instanceof EnchantShard) {
					EnchantShard en = (EnchantShard)(Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")));
					EntityGemShard shard = new EntityGemShard(user.world);
					shard.setPositionAndRotation(user.posX, user.posY, user.posZ, user.rotationYaw, user.rotationPitch);
					shard.setColor(en.color);
					shard.setItem(stack);
					user.world.spawnEntity(shard);
					user.setItemStackToSlot(slot, ItemStack.EMPTY);
					if (attacker instanceof EntityLivingBase) {
						shard.setAttackTarget((EntityLivingBase) attacker);
					}
					break;
				}
			}
		}
    }
    @Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }
    @Override
	public boolean isTreasureEnchantment() {
        return true;
    }
    @Override
	public boolean isCurse() {
        return true;
    }
	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
        return 5;
    }
    @Override
	public int getMaxEnchantability(int enchantmentLevel) {
        return 55;
    }
	@Override
	public int getMaxLevel() {
        return 1;
    }
	public PotionEffect getDeBuff(int color) {
		switch (color) {
		case 0:	// White
			return new PotionEffect(MobEffects.SLOWNESS, 400);
		case 1:	// Orange
			return new PotionEffect(MobEffects.WITHER, 400);
		case 2:	// Magenta
			return new PotionEffect(MobEffects.INSTANT_DAMAGE, 400);
		case 3:	// Light Blue
			return new PotionEffect(MobEffects.BLINDNESS, 400);
		case 4:	// Yellow
			return new PotionEffect(MobEffects.MINING_FATIGUE, 400);
		case 5:	// Lime
			return new PotionEffect(MobEffects.LEVITATION, 400);
		case 6:	// Pink
			return new PotionEffect(MobEffects.POISON, 400);
		case 7:	// Gray
			return new PotionEffect(MobEffects.WITHER, 400);
		case 8:	// Light Gray
			return new PotionEffect(MobEffects.BLINDNESS, 400);
		case 9: // Cyan
			return new PotionEffect(MobEffects.BLINDNESS, 400);
		case 10:// Purple
			return new PotionEffect(MobEffects.INSTANT_DAMAGE, 400);
		case 11:// Blue
			return new PotionEffect(MobEffects.WITHER, 400);
		case 12:// Brown
			return new PotionEffect(MobEffects.HUNGER, 400);
		case 13:// Green
			return new PotionEffect(MobEffects.UNLUCK, 400);
		case 14:// Red
			return new PotionEffect(MobEffects.WEAKNESS, 400);
		case 15:// Black
			return new PotionEffect(MobEffects.WITHER, 400);
		default:
			return new PotionEffect(MobEffects.WITHER, 400);
		}
	}
	public PotionEffect getBuff(int color) {
		switch (color) {
		case 0:	// White
			return new PotionEffect(MobEffects.SPEED, 400);
		case 1:	// Orange
			return new PotionEffect(MobEffects.FIRE_RESISTANCE, 400);
		case 2:	// Magenta
			return new PotionEffect(MobEffects.ABSORPTION, 400);
		case 3:	// Light Blue
			return new PotionEffect(MobEffects.NIGHT_VISION, 400);
		case 4:	// Yellow
			return new PotionEffect(MobEffects.HASTE, 400);
		case 5:	// Lime
			return new PotionEffect(MobEffects.JUMP_BOOST, 400);
		case 6:	// Pink
			return new PotionEffect(MobEffects.REGENERATION, 400);
		case 7:	// Gray
			return new PotionEffect(MobEffects.RESISTANCE, 400);
		case 8:	// Light Gray
			return new PotionEffect(MobEffects.INVISIBILITY, 400);
		case 9: // Cyan
			return new PotionEffect(MobEffects.INVISIBILITY, 400);
		case 10:// Purple
			return new PotionEffect(MobEffects.HEALTH_BOOST, 400);
		case 11:// Blue
			return new PotionEffect(MobEffects.WATER_BREATHING, 400);
		case 12:// Brown
			return new PotionEffect(MobEffects.RESISTANCE, 400);
		case 13:// Green
			return new PotionEffect(MobEffects.LUCK, 400);
		case 14:// Red
			return new PotionEffect(MobEffects.STRENGTH, 400);
		case 15:// Black
			return new PotionEffect(MobEffects.RESISTANCE, 400);
		default:
			return new PotionEffect(MobEffects.FIRE_RESISTANCE, 400);
		}
	}
}
