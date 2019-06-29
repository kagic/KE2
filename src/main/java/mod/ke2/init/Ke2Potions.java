package mod.ke2.init;

import mod.ke2.potion.PotionAnxiety;
import mod.ke2.potion.PotionCholeric;
import mod.ke2.potion.PotionDepression;
import mod.ke2.potion.PotionLove;
import mod.ke2.potion.PotionMelancholic;
import mod.ke2.potion.PotionPhlegmatic;
import mod.ke2.potion.PotionSanguine;
import mod.ke2.potion.PotionSubmission;
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
	public static final PotionMelancholic MELANCHOLIC = new PotionMelancholic();
	public static final PotionAnxiety ANXIETY = new PotionAnxiety();
	public static final PotionCholeric CHOLERIC = new PotionCholeric();
	public static final PotionSubmission SUBMISSION = new PotionSubmission();
	public static final PotionPhlegmatic PHLEGMATIC = new PotionPhlegmatic();
	public static final PotionDepression DEPRESSION = new PotionDepression();
	public static final PotionSanguine SANGUINE = new PotionSanguine();
	public static final PotionLove LOVE = new PotionLove();
	public static final PotionType POTION_OF_TEMPERMENT = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.TEMPERMENT, 7200)});
	public static final PotionType POTION_OF_THE_MELANCHOLIC = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.MELANCHOLIC, 3600)});
	public static final PotionType POTION_OF_ANXIETY = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.ANXIETY, 3600)});
	public static final PotionType POTION_OF_THE_CHOLERIC = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.CHOLERIC, 3600)});
	public static final PotionType POTION_OF_SUBMISSION = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.SUBMISSION, 3600)});
	public static final PotionType POTION_OF_THE_PHLEGMATIC = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.PHLEGMATIC, 3600)});
	public static final PotionType POTION_OF_DEPRESSION = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.DEPRESSION, 3600)});
	public static final PotionType POTION_OF_THE_SANGUINE = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.SANGUINE, 3600)});
	public static final PotionType POTION_OF_LOVE = new PotionType(new PotionEffect[]{new PotionEffect(Ke2Potions.LOVE, 3600)});
	
	public static void register() {
		Ke2Potions.registerPotion(Ke2Potions.TEMPERMENT, new ResourceLocation("ke2:temperment"));
		Ke2Potions.registerPotion(Ke2Potions.MELANCHOLIC, new ResourceLocation("ke2:melancholic"));
		Ke2Potions.registerPotion(Ke2Potions.ANXIETY, new ResourceLocation("ke2:anxiety"));
		Ke2Potions.registerPotion(Ke2Potions.CHOLERIC, new ResourceLocation("ke2:choleric"));
		Ke2Potions.registerPotion(Ke2Potions.SUBMISSION, new ResourceLocation("ke2:submission"));
		Ke2Potions.registerPotion(Ke2Potions.PHLEGMATIC, new ResourceLocation("ke2:phlegmatic"));
		Ke2Potions.registerPotion(Ke2Potions.DEPRESSION, new ResourceLocation("ke2:depression"));
		Ke2Potions.registerPotion(Ke2Potions.SANGUINE, new ResourceLocation("ke2:sanguine"));
		Ke2Potions.registerPotion(Ke2Potions.LOVE, new ResourceLocation("ke2:love"));
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_TEMPERMENT, new ResourceLocation("ke2:temperment"));
		Ke2Potions.registerPotionMix(PotionTypes.AWKWARD, Ke2Items.TEMPERPLASM, Ke2Potions.POTION_OF_TEMPERMENT);
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_THE_MELANCHOLIC, new ResourceLocation("ke2:melancholic"));
		Ke2Potions.registerPotionMix(Ke2Potions.POTION_OF_TEMPERMENT, Items.SUGAR, Ke2Potions.POTION_OF_THE_MELANCHOLIC);
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_ANXIETY, new ResourceLocation("ke2:anxiety"));
		Ke2Potions.registerPotionMix(Ke2Potions.POTION_OF_THE_MELANCHOLIC, Items.FERMENTED_SPIDER_EYE, Ke2Potions.POTION_OF_ANXIETY);
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_THE_CHOLERIC, new ResourceLocation("ke2:choleric"));
		Ke2Potions.registerPotionMix(Ke2Potions.POTION_OF_TEMPERMENT, Items.GLOWSTONE_DUST, Ke2Potions.POTION_OF_THE_CHOLERIC);
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_SUBMISSION, new ResourceLocation("ke2:submission"));
		Ke2Potions.registerPotionMix(Ke2Potions.POTION_OF_THE_CHOLERIC, Items.GLOWSTONE_DUST, Ke2Potions.POTION_OF_SUBMISSION);
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_THE_PHLEGMATIC, new ResourceLocation("ke2:phlegmatic"));
		Ke2Potions.registerPotionMix(Ke2Potions.POTION_OF_TEMPERMENT, Items.GHAST_TEAR, Ke2Potions.POTION_OF_THE_PHLEGMATIC);
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_DEPRESSION, new ResourceLocation("ke2:depression"));
		Ke2Potions.registerPotionMix(Ke2Potions.POTION_OF_THE_PHLEGMATIC, Items.FERMENTED_SPIDER_EYE, Ke2Potions.POTION_OF_DEPRESSION);
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_THE_SANGUINE, new ResourceLocation("ke2:sanguine"));
		Ke2Potions.registerPotionMix(Ke2Potions.POTION_OF_TEMPERMENT, Items.REDSTONE, Ke2Potions.POTION_OF_THE_SANGUINE);
		Ke2Potions.registerPotionType(Ke2Potions.POTION_OF_LOVE, new ResourceLocation("ke2:love"));
		Ke2Potions.registerPotionMix(Ke2Potions.POTION_OF_THE_SANGUINE, Items.FERMENTED_SPIDER_EYE, Ke2Potions.POTION_OF_LOVE);
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
