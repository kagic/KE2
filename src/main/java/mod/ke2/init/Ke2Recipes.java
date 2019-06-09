package mod.ke2.init;

import mod.ke2.recipe.RecipeEssences;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Ke2Recipes {
	public static void register(RegistryEvent.Register<IRecipe> event) {
		if (event != null) {
			registerRecipe(new RecipeEssences(), new ResourceLocation("ke2:essences"));
		}
		else {
			
		}
	}
	public static void registerSmeltingRecipe(ItemStack input, ItemStack output, int xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
	public static void registerRecipe(IRecipe recipe, ResourceLocation name) {
		ForgeRegistries.RECIPES.register(recipe.setRegistryName(name));
	}
}
