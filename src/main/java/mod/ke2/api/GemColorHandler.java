package mod.ke2.api;

import java.util.Iterator;
import java.util.Random;

import mod.ke2.api.variants.IVariant;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GemColorHandler implements IItemColor {
	public static int mix(Random rand, int... colors) {
		if (colors.length == 0) {
			return 0x000000;
		}
		if (colors.length == 1) {
			return colors[0];
		}
		int bound = rand.nextInt(colors.length - 1);
		float set = rand.nextFloat();
        int bR = (colors[bound] & 16711680) >> 16;
        int bG = (colors[bound] & 65280) >> 8;
        int bB = (colors[bound] & 255) >> 0;
        int eR = (colors[bound + 1] & 16711680) >> 16;
        int eG = (colors[bound + 1] & 65280) >> 8;
        int eB = (colors[bound + 1] & 255) >> 0;
        int r = (int)(set * bR + (1 - set) * eR); 
		int g = (int)(set * bG + (1 - set) * eG); 
		int b = (int)(set * bB + (1 - set) * eB); 
		return (r << 16) + (g << 8) + b;
	}
	@Override
	public int colorMultiplier(ItemStack stack, int tint) {
		if (stack.hasTagCompound()) {
			NBTTagCompound compound = stack.getTagCompound();
			return compound.getInteger("gemColor");
		}
		return 0xFFFFFF;
	}
}
