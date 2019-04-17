package mod.ke2.api.variants;

import java.util.Random;

import mod.ke2.api.injection.GemSpawnData;

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
}
