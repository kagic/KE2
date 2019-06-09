package mod.ke2.init;

import mod.ke2.effect.EffectTempermental;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Ke2Effects {
	public static final EffectTempermental EFFECT_TEMPERMENTAL = new EffectTempermental();
	public static void register() {
		registerEffect(EFFECT_TEMPERMENTAL, new ResourceLocation("ke2:tempermental"));
	}
	public static void registerEffect(Potion effect, ResourceLocation name) {
		ForgeRegistries.POTIONS.register(effect.setRegistryName(name));
	}
}
