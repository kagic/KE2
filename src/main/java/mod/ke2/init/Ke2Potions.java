package mod.ke2.init;

import mod.ke2.potion.PotionTempermental;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Ke2Potions {
	public static final PotionTempermental POTION_TEMPERMENTAL = new PotionTempermental();
	public static void register() {
		registerPotion(POTION_TEMPERMENTAL, new ResourceLocation("ke2:tempermental"));
	}
	public static void registerPotion(Potion effect, ResourceLocation name) {
		ForgeRegistries.POTIONS.register(effect.setRegistryName(name));
	}
}
