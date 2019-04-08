package mod.ke2.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Ke2Recipes {
	public static void register() {
		
	}
	public static void registerSmeltingRecipe(ItemStack input, ItemStack output, int xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
}
