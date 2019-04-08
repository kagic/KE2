package mod.ke2.handles;

import java.util.Random;

import mod.ke2.enchant.EnchantShard;
import mod.ke2.entity.EntityGemShard;
import mod.ke2.items.ItemGem;
import mod.ke2.items.ItemGemShard;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleShattering {
	@SubscribeEvent
	public boolean onLivingUpdate(LivingUpdateEvent e) {
		if (e.getEntityLiving().ticksExisted % 80 == 0) {
			for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
				ItemStack stack = e.getEntityLiving().getItemStackFromSlot(slot);
				NBTTagList enchantments = stack.getEnchantmentTagList();
				for (int i = 0; i < enchantments.tagCount(); i++) {
					if (Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")) instanceof EnchantShard) {
						EnchantShard en = (EnchantShard)(Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")));
						e.getEntityLiving().addPotionEffect(en.getBuff(en.color));
					}
				}
			}
		}
		return false;
	}
	@SubscribeEvent
	public void onItemExpire(ItemExpireEvent e) {
		ItemStack stack = e.getEntityItem().getItem();
		if (stack.isItemEnchanted()) {
			NBTTagList enchantments = stack.getEnchantmentTagList();
			for (int i = 0; i < enchantments.tagCount(); i++) {
				if (Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")) instanceof EnchantShard) {
					if (!e.getEntityItem().world.isRemote) {
						EnchantShard en = (EnchantShard)(Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")));
						EntityGemShard shard = new EntityGemShard(e.getEntityItem().world);
						shard.setPositionAndRotation(e.getEntityItem().posX, e.getEntityItem().posY, e.getEntityItem().posZ, e.getEntityItem().rotationYaw, e.getEntityItem().rotationPitch);
						shard.setColor(en.color);
						shard.setItem(stack);
						e.getEntityItem().world.spawnEntity(shard);
						e.getEntityItem().setDead();
					}
				}
			}
		}
	}
	@SubscribeEvent
	public void onAnvilRepair(AnvilRepairEvent e) {
		if (e.getIngredientInput().getItem() instanceof ItemGemShard) {
			ItemStack stack = e.getIngredientInput().copy();
			stack.shrink(1);
			boolean added = e.getEntityPlayer().addItemStackToInventory(stack);
			if (!added) {
				e.getEntityPlayer().dropItem(stack, true);
			}
		}
		if (e.getItemInput().getItem() instanceof ItemGem) {
			ItemGem gem = (ItemGem)(e.getItemInput().getItem());
			if (gem.isCracked()) {
				if (e.getIngredientInput().getItem().getToolClasses(e.getIngredientInput()).contains("pickaxe")) {
					ItemStack stack = e.getIngredientInput().copy();
					stack.damageItem(1, e.getEntityPlayer());
					boolean added = e.getEntityPlayer().addItemStackToInventory(stack);
					if (!added) {
						e.getEntityPlayer().dropItem(stack, true);
					}
				}
			}
		}
	}
	@SubscribeEvent
	public void onAnvilUpdate(AnvilUpdateEvent e) {
		Random rand = new Random(e.getRight().hashCode());
		if (e.getRight().getItem() instanceof ItemGemShard) {
			ItemGemShard gem = (ItemGemShard)(e.getRight().getItem());
			boolean enchantItem = true;
			NBTTagList enchantments = e.getLeft().getEnchantmentTagList();
			for (int i = 0; i < enchantments.tagCount(); i++) {
				if (Enchantment.getEnchantmentByID(enchantments.getCompoundTagAt(i).getInteger("id")) instanceof EnchantShard) {
					enchantItem = true;
				}
			}
			if (enchantItem) {
				ItemStack stack = e.getLeft().copy();
				stack.addEnchantment(EnchantShard.ENCHANTS.get(gem.getUnlocalizedName().replaceAll("item\\.", "")), 1);
				e.setOutput(stack);
			}
			if (!e.getOutput().isEmpty()) {
				e.setResult(Result.ALLOW);
				e.setCost(1);
			}
		}
		if (e.getLeft().getItem() instanceof ItemGem) {
			boolean canBreak = false;
			if (e.getRight().getItem() instanceof ItemPickaxe) {
				ItemPickaxe tool = (ItemPickaxe)(e.getRight().getItem());
				ToolMaterial mat = ToolMaterial.valueOf(tool.getToolMaterialName());
				canBreak = mat.getHarvestLevel() > 1;
			}
			if (canBreak) {
				ItemGem gem = (ItemGem)(e.getLeft().getItem());
				if (gem.isCracked()) {
				    int gemColor = rand.nextInt(16777215);
				    if (e.getLeft().hasTagCompound()) {
				    	NBTTagCompound nbt = e.getLeft().getTagCompound();
				    	if (nbt.hasKey("GemstoneColor")) {
				    		gemColor = nbt.getInteger("GemstoneColor");
				    	}
				    }
				    double maxDist = Double.MAX_VALUE;
				    int dyeColor = 0;
				    float r = (gemColor & 16711680) >> 16;
			        float g = (gemColor & 65280) >> 8;
			        float b = (gemColor & 255) >> 0;
				    for (int i = 0; i < EntityGemShard.PARTICLE_COLORS.length; ++i) {
				    	int color = EntityGemShard.PARTICLE_COLORS[i];
						float shardR = (color & 16711680) >> 16;
				        float shardG = (color & 65280) >> 8;
				        float shardB = (color & 255) >> 0;
						double dist = Math.sqrt(Math.pow(shardR - r, 2) + Math.pow(shardG - g, 2) + Math.pow(shardB - b, 2));
						if (dist < maxDist) {
							maxDist = dist;
							dyeColor = i;
						}
				    }
				    e.setOutput(new ItemStack(ItemGemShard.SHARD_COLORS.get(dyeColor), 9));
				    if (!e.getOutput().isEmpty()) {
						e.setResult(Result.ALLOW);
						e.setCost(1);
					}
				}
			}
		}
	}
}
