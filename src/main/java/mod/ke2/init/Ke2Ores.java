package mod.ke2.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class Ke2Ores {
	public static void register() {
		Ke2Ores.registerOre(Ke2Blocks.TUNGSTEN_ORE, "oreTungsten");
		Ke2Ores.registerOre(Ke2Blocks.TUNGSTEN_BLOCK, "blockTungsten");
		Ke2Ores.registerOre(Ke2Items.TUNGSTEN_INGOT, "ingotTungsten");
	}
	public static void registerOre(Block block, String... ores) {
		for (int i = 0; i < ores.length; ++i) {
			OreDictionary.registerOre(ores[i], block);
		}
	}
	public static void registerOre(Item item, String... ores) {
		for (int i = 0; i < ores.length; ++i) {
			OreDictionary.registerOre(ores[i], item);
		}
	}
}
