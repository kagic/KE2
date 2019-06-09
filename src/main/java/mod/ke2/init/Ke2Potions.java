package mod.ke2.init;

import mod.ke2.potion.PotionCholeric;
import mod.ke2.potion.PotionMelancholic;
import mod.ke2.potion.PotionPhlegmatic;
import mod.ke2.potion.PotionSanguine;
import mod.ke2.potion.PotionTempermental;
import net.minecraft.init.Items;
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
	public static final PotionMelancholic MELANCHOLIC = new PotionMelancholic();
	public static final PotionCholeric CHOLERIC = new PotionCholeric();
	public static final PotionPhlegmatic PHLEGMATIC = new PotionPhlegmatic();
	public static final PotionSanguine SANGUINE = new PotionSanguine();
	public static final PotionType POTION_OF_TEMPERMENT = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.TEMPERMENTAL, 7200) });
	public static final PotionType MELANCHOLIC_POTION = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.MELANCHOLIC, 9600) });
	public static final PotionType CHOLERIC_POTION = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.CHOLERIC, 9600) });
	public static final PotionType PHLEGMATIC_POTION = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.PHLEGMATIC, 9600) });
	public static final PotionType SANGUINE_POTION = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.SANGUINE, 9600) });
	public static void register() {
		registerPotion(TEMPERMENTAL, new ResourceLocation("ke2:tempermental"));
		registerPotionType(POTION_OF_TEMPERMENT, new ResourceLocation("ke2:tempermental"));
		registerPotionMix(PotionTypes.AWKWARD, Ke2Items.TEMPERPLASM, POTION_OF_TEMPERMENT);
		registerPotionType(MELANCHOLIC_POTION, new ResourceLocation("ke2:melancholic"));
		registerPotionMix(POTION_OF_TEMPERMENT, Items.SUGAR, MELANCHOLIC_POTION);
		registerPotionType(CHOLERIC_POTION, new ResourceLocation("ke2:choleric"));
		registerPotionMix(POTION_OF_TEMPERMENT, Items.GLOWSTONE_DUST, CHOLERIC_POTION);
		registerPotionType(PHLEGMATIC_POTION, new ResourceLocation("ke2:phlegmatic"));
		registerPotionMix(POTION_OF_TEMPERMENT, Items.GHAST_TEAR, PHLEGMATIC_POTION);
		registerPotionType(SANGUINE_POTION, new ResourceLocation("ke2:sanguine"));
		registerPotionMix(POTION_OF_TEMPERMENT, Items.REDSTONE, SANGUINE_POTION);
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
