package mod.ke2.api.variants;

import java.util.ArrayList;
import java.util.Random;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantName;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.init.Ke2Gems;
import mod.ke2.init.Ke2Variants;
import net.minecraft.util.ResourceLocation;

public class VariantHelper {
	public enum Functions {
		SPAWNED_BELOW("spawned_below"), SPAWNED_ABOVE("spawned_above"), SPAWNED_IN_BIOME("spawned_in"),
		IS_DEFECTIVE("is_defective"), IS_PERFECTIVE("is_perfective"), IS_NORMAL("is_normal"),
		INSIGNIA_COLOR("insignia_color"), ALWAYS_TRUE("always_true"), RANDOM("random"), WEIGHTED("weighted"); 
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
	public static boolean tryAlwaysTrue(EntityGem gem, String value) {
		return true && Boolean.parseBoolean(value);
	}
	public static boolean tryRandom(EntityGem gem, String value) {
		Random rand = gem.world.rand;
		int bound = 10;
		try {
			bound = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			bound = 10;
		}
		return rand.nextInt(bound) == 0;
	}
	public static boolean tryWeighted(EntityGem gem, String value) {
		Random rand = gem.world.rand;
		float bound = 0.5F;
		try {
			bound = Float.parseFloat(value);
		} catch (NumberFormatException e) {
			bound = 0.5F;
		}
		return rand.nextFloat() < bound;
	}
	public static boolean tryInsigniaColor(EntityGem gem, String value) {
		int color = -1;
		try {
			color = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			color = -1;
		}
		return gem.getInsigniaColor() == color;
	}
	public static boolean tryIsNormal(EntityGem gem, String value) {
		if (tryIsDefective(gem, value)) {
			return false;
		}
		if (tryIsPerfective(gem, value)) {
			return false;
		}
		return true;
	}
	public static boolean tryIsPerfective(EntityGem gem, String value) {
		return gem.isPerfective() == Boolean.parseBoolean(value);
	}
	public static boolean tryIsDefective(EntityGem gem, String value) {
		return gem.isDefective() == Boolean.parseBoolean(value);
	}
	public static boolean trySpawnedInBiome(EntityGem gem, String value) {
		String[] biomes = value.split(",");
		for (int i = 0; i < biomes.length; ++i) {
			if (gem.world.getBiome(gem.getPosition()).getRegistryName().getResourcePath().equals(biomes[i])) {
				return true;
			}
		}
		return false;
	}
	public static boolean trySpawnedAbove(EntityGem gem, String value) {
		int depth = 64;
		try {
			depth = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			depth = 64;
		}
		return gem.getPosition().getY() < depth;
	}
	public static boolean trySpawnedBelow(EntityGem gem, String value) {
		int depth = 64;
		try {
			depth = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			depth = 64;
		}
		return gem.getPosition().getY() > depth;
	}
	public static int loadVariantColor(EntityGem gem, String... tags) {
		ArrayList<ResourceLocation> variants = Ke2Variants.TABLE.get(Ke2Gems.REGISTRY_REVERSE.get(gem.getClass()));
		int color = 0xFFFFFF;
		for (int i = 0; i < variants.size(); ++i) {
			IVariant<?> v = Ke2Variants.REGISTRY.get(variants.get(i));
			if (v.matches(gem, VariantColor.class, tags)) {
				VariantColor c = (VariantColor)(v);
				color = c.getColor();
			}
		}
		return color;
	}
	public static String loadVariantName(EntityGem gem, String... tags) {
		ArrayList<ResourceLocation> variants = Ke2Variants.TABLE.get(Ke2Gems.REGISTRY_REVERSE.get(gem.getClass()));
		String name = "null";
		for (int i = 0; i < variants.size(); ++i) {
			IVariant<?> v = Ke2Variants.REGISTRY.get(variants.get(i));
			if (v.matches(gem, VariantName.class, tags)) {
				VariantName n = (VariantName)(v);
				name = n.getName();
			}
		}
		return name;
	}
	public static ResourceLocation loadVariantPath(EntityGem gem, String... tags) {
		ArrayList<ResourceLocation> variants = Ke2Variants.TABLE.get(Ke2Gems.REGISTRY_REVERSE.get(gem.getClass()));
		ResourceLocation path = VariantPath.getDefaultPath();
		for (int i = 0; i < variants.size(); ++i) {
			IVariant<?> v = Ke2Variants.REGISTRY.get(variants.get(i));
			if (v.matches(gem, VariantPath.class, tags)) {
				VariantPath p = (VariantPath)(v);
				path = p.getPath();
			}
		}
		return path;
	}
}
