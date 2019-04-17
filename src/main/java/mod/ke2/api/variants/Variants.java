package mod.ke2.api.variants;

import java.util.Iterator;
import java.util.Random;

import mod.ke2.api.EntityGem;
import mod.ke2.api.GemColorHandler;
import mod.ke2.api.injection.GemSpawnData;
import mod.ke2.init.Ke2Gems;
import net.minecraft.util.ResourceLocation;

public class Variants {
	public enum Functions {
		SPAWNED_BELOW("spawned_below"), SPAWNED_ABOVE("spawned_above"), SPAWNED_IN_BIOME("spawned_in"),
		IS_DEFECTIVE("is_defective"), IS_PERFECTIVE("is_perfective"), INSIGNIA_COLOR("insignia_color"),
		ALWAYS_TRUE("always_true"), RANDOM("random"); 
		private final String code;
		private Functions(String code) {
			this.code = code;
		}
		@Override
		public String toString() {
			return this.code;
		}
		public static Functions fromCode(String code) {
			for (int i = 0; i < Functions.values().length; ++i) {
				if (code.equals(Functions.values()[i].toString())) {
					return Functions.values()[i];
				}
			}
			return Functions.ALWAYS_TRUE;
		}
	}
	public static boolean tryAlwaysTrue(GemSpawnData data, String value) {
		return true;
	}
	public static boolean tryRandom(GemSpawnData data, String value) {
		Random rand = data.getWorld().rand;
		int bound = 10;
		try {
			bound = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			bound = 10;
		}
		return rand.nextInt(bound) == 0;
	}
	public static boolean tryInsigniaColor(GemSpawnData data, String value) {
		int color = -1;
		try {
			color = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			color = -1;
		}
		return data.getColor() == color;
	}
	public static boolean tryIsPerfective(GemSpawnData data, String value) {
		return data.isPerfective() == Boolean.getBoolean(value);
	}
	public static boolean tryIsDefective(GemSpawnData data, String value) {
		return data.isDefective() == Boolean.getBoolean(value);
	}
	public static boolean trySpawnedInBiome(GemSpawnData data, String value) {
		String[] biomes = value.split(",");
		for (int i = 0; i < biomes.length; ++i) {
			if (data.getWorld().getBiome(data.getPosition()).getRegistryName().getResourcePath().equals(biomes[i])) {
				return true;
			}
		}
		return false;
	}
	public static boolean trySpawnedAbove(GemSpawnData data, String value) {
		int depth = 64;
		try {
			depth = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			depth = 64;
		}
		return data.getPosition().getY() < depth;
	}
	public static boolean trySpawnedBelow(GemSpawnData data, String value) {
		int depth = 64;
		try {
			depth = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			depth = 64;
		}
		return data.getPosition().getY() > depth;
	}
	public static int loadColor(EntityGem gem, ResourceLocation category) {
		Iterator<ResourceLocation> it = Ke2Gems.VARIANT_REGISTRY.keySet().iterator();
		while (it.hasNext()) {
			IVariant variant = Ke2Gems.VARIANT_REGISTRY.get(it.next());
			if (variant.matches(gem, category)) {
				String value = variant.getValue();
				String[] hex = value.split(",");
				int[] colors = new int[hex.length];
				for (int i = 0; i < colors.length; ++i) {
					colors[i] = Integer.parseInt(hex[i], 16);
				}
				return GemColorHandler.mix(gem.world.rand, colors);
			}
		}
		return 0;
	}
	public static String loadResource(EntityGem gem, ResourceLocation category) {
		Iterator<ResourceLocation> it = Ke2Gems.VARIANT_REGISTRY.keySet().iterator();
		while (it.hasNext()) {
			IVariant variant = Ke2Gems.VARIANT_REGISTRY.get(it.next());
			if (variant.matches(gem, category)) {
				return variant.getValue();
			}
		}
		return "kagic:textures/entities/none/null";
	}
}
