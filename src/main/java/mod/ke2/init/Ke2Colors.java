package mod.ke2.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Ke2Colors {
	public static void register() {
		registerColor(new IItemColor() {
			@Override
			public int colorMultiplier(ItemStack stack, int layer) {
				if (layer == 1) {
					if (stack.hasTagCompound()) {
						return stack.getTagCompound().getInteger("Color");
					}
					else {
						return 0xb2ffff;
					}
				}
				return 0xffffff;
			}
		}, Ke2Items.WARP_WHISTLE);
	}
	public static void registerColor(IItemColor handler, Item... items) {
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(handler, items);
	}
}
