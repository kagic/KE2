package mod.ke2.api;

import net.minecraft.entity.INpc;

public interface IGem extends INpc {
	public int generateSkinColor();
	public int generateHairColor();
	public int generateOutfitColor();
	public int generateVisorColor();
	public int generateGemstoneColor();
	public int generateGemstonePosition();
	public String generateGemstoneCut();
	public String generateOutfitVariant();
	public String generateHairVariant();
	public String generateSkinVariant();
}
