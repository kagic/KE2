package mod.ke2.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantBubble extends Enchantment {
	public EnchantBubble() {
		super(Rarity.RARE, EnumEnchantmentType.ALL, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setRegistryName(new ResourceLocation("ke2:bubble"));
		this.setName("bubble");
		
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
	}
	
	@Override
	public boolean isTreasureEnchantment() {
		return true;
	}
	
	@Override
	public boolean isCurse() {
		return false;
	}
	
	@Override
	public boolean isAllowedOnBooks() {
		return true;
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
	
}