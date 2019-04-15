package mod.ke2.api;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GemColorHandler implements IItemColor {
	@Override
	public int colorMultiplier(ItemStack stack, int tint) {
		if (stack.hasTagCompound()) {
			NBTTagCompound compound = stack.getTagCompound();
			return compound.getInteger("gemColor");
		}
		return 0xFFFFFF;
	}
}
