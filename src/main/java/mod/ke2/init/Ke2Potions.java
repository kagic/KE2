package mod.ke2.init;

import mod.ke2.potion.PotionImpulsiveness;
import mod.ke2.potion.PotionAnxiety;
import mod.ke2.potion.PotionObsession;
import mod.ke2.potion.PotionCarelessness;
import mod.ke2.potion.PotionTemperment;
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
	public static final PotionTemperment TEMPERMENT = new PotionTemperment();
	public static final PotionAnxiety ANXIETY = new PotionAnxiety();
	public static final PotionImpulsiveness IMPULSIVENESS = new PotionImpulsiveness();
	public static final PotionObsession OBSESSION = new PotionObsession();
	public static final PotionCarelessness CARELESS = new PotionCarelessness();
	public static final PotionType POTION_OF_TEMPERMENT = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.TEMPERMENT, 7200) });
	public static final PotionType POTION_OF_ANXIETY = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.ANXIETY, 10800) });
	public static final PotionType POTION_OF_IMPULSIVENESS = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.IMPULSIVENESS, 10800) });
	public static final PotionType POTION_OF_OBSESSION = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.OBSESSION, 10800) });
	public static final PotionType POTION_OF_CARELESS = new PotionType(new PotionEffect[] { new PotionEffect(Ke2Potions.CARELESS, 10800) });
	public static void register() {
		registerPotion(TEMPERMENT, new ResourceLocation("ke2:temperment"));
		registerPotionType(POTION_OF_TEMPERMENT, new ResourceLocation("ke2:temperment"));
		registerPotionMix(PotionTypes.AWKWARD, Ke2Items.TEMPERPLASM, POTION_OF_TEMPERMENT);
		registerPotionType(POTION_OF_ANXIETY, new ResourceLocation("ke2:anxiety"));
		registerPotionMix(POTION_OF_TEMPERMENT, Items.SUGAR, POTION_OF_ANXIETY);
		registerPotionType(POTION_OF_IMPULSIVENESS, new ResourceLocation("ke2:impulsiveness"));
		registerPotionMix(POTION_OF_TEMPERMENT, Items.GLOWSTONE_DUST, POTION_OF_IMPULSIVENESS);
		registerPotionType(POTION_OF_OBSESSION, new ResourceLocation("ke2:obsession"));
		registerPotionMix(POTION_OF_TEMPERMENT, Items.GHAST_TEAR, POTION_OF_OBSESSION);
		registerPotionType(POTION_OF_CARELESS, new ResourceLocation("ke2:careless"));
		registerPotionMix(POTION_OF_TEMPERMENT, Items.REDSTONE, POTION_OF_CARELESS);
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
