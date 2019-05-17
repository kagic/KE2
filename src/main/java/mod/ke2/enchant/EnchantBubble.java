package mod.ke2.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class EnchantBubble extends Enchantment {
	public EnchantBubble() {
		super(Rarity.RARE, EnumEnchantmentType.ALL, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND });
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
}