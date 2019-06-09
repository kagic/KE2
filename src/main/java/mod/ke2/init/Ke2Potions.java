package mod.ke2.init;

import mod.ke2.potion.PotionTempermental;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Ke2Potions {
	public static final PotionTempermental TEMPERMENTAL = new PotionTempermental();
	public static final PotionType POTION_OF_TEMPERMENT = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.TEMPERMENTAL, 7200) });
	public static void register() {
		registerPotion(TEMPERMENTAL, new ResourceLocation("ke2:tempermental"));
		registerPotionType(POTION_OF_TEMPERMENT, new ResourceLocation("ke2:tempermental"));
		registerPotionMix(PotionTypes.AWKWARD, Ke2Items.TEMPERPLASM, POTION_OF_TEMPERMENT);
	}
	public static void registerPotion(Potion potion, ResourceLocation name) {
		ForgeRegistries.POTIONS.register(potion.setRegistryName(name));
	}
	public static void registerPotionType(PotionType type, ResourceLocation name) {
		ForgeRegistries.POTION_TYPES.register(type.setRegistryName(name));
	}
	public static void registerPotionMix(PotionType start, Item modifier, PotionType output) {
		PotionHelper.addMix(start, modifier, output);
	}
}
