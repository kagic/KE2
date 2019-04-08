package mod.ke2.util;

import net.minecraft.entity.INpc;

public interface IGem extends INpc {
	public int generateSkinColor();
	public int generateHairColor();
	public int generateGemstoneColor();
	public int generateGemstonePosition();
	public int generateGemstoneCut();
	public int generateClothingVariant();
	public int generateHairVariant();
	public int generateSkinVariant();
	public boolean generateVisor();
}
