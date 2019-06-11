package mod.ke2.api;

import net.minecraft.entity.INpc;
import net.minecraft.item.ItemStack;

public interface IGem extends INpc {
	public int generateSkinColor();
	public int generateHairColor();
	public int generateOutfitColor();
	public int generateVisorColor();
	public int generateGemstoneColor();
	public int generateGemstoneCut();
	public ItemStack generateGemstoneItem();
	public String generateOutfitVariant();
	public String generateHairVariant();
	public String generateSkinVariant();
	public String generateNameVariant();
}
