package mod.ke2.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Ke2Colors {
	public static void register() {
		Ke2Colors.registerColor(new IItemColor() {
			@Override
			public int colorMultiplier(ItemStack stack, int layer) {
				if (stack.hasTagCompound()) {
					return stack.getTagCompound().getInteger("GemstoneColor");
				}
				return 0xffffff;
			}
		}, Ke2Items.GEM_DUST, Ke2Items.GEM_SHARD, Ke2Items.COLORED_GEMSTONE);
		Ke2Colors.registerColor(new IItemColor() {
			@Override
			public int colorMultiplier(ItemStack stack, int layer) {
				if (layer == 0 && stack.hasTagCompound()) {
					return stack.getTagCompound().getInteger("UpperColor");
				}
				if (layer == 1 && stack.hasTagCompound()) {
					return stack.getTagCompound().getInteger("LowerColor");
				}
				return 0xffffff;
			}
		}, Ke2Items.GEM_DESTABILIZER, Ke2Items.WARP_WHISTLE);
	}
	
	public static void registerColor(IItemColor handler, Item... items) {
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(handler, items);
	}
}
