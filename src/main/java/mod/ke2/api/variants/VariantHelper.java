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
	public enum Colors {
		WHITE, ORANGE, MAGENTA, LIGHTBLUE, YELLOW, LIME, PINK, GRAY, SILVER, CYAN, PURPLE, BLUE, BROWN, GREEN, RED, BLACK;
	}
	
	public enum Positions {
		FOREHEAD, BACK_OF_HEAD, RIGHT_EYE, LEFT_EYE, NOSE, RIGHT_SHOULDER, LEFT_SHOULDER, RIGHT_HAND, LEFT_HAND, CHEST, BACK, NAVEL, RIGHT_THIGH, LEFT_THIGH, RIGHT_KNEE, LEFT_KNEE, RIGHT_FOOT, LEFT_FOOT
	}
	
	public enum Functions {
		SPAWNED_BELOW, SPAWNED_ABOVE, SPAWNED_IN_BIOME, IS_DEFECTIVE, IS_PERFECTIVE, IS_NORMAL, GEM_POSITION, INSIGNIA_COLOR, ALWAYS_TRUE, RANDOM, WEIGHTED;
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
	
	public static boolean tryGemPosition(EntityGem gem, String value) {
		return gem.getGemstonePosition() == Positions.valueOf(value.toUpperCase()).ordinal();
	}
	
	public static boolean tryInsigniaColor(EntityGem gem, String value) {
		return gem.getInsigniaColor() == Colors.valueOf(value.toUpperCase()).ordinal();
	}
	
	public static boolean tryIsNormal(EntityGem gem, String value) {
		if (VariantHelper.tryIsDefective(gem, value)) {
			return false;
		}
		if (VariantHelper.tryIsPerfective(gem, value)) {
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
		int rolls = 30;
		for (int r = 0; r < rolls; ++r) {
			for (int i = 0; i < variants.size(); ++i) {
				IVariant<?> v = Ke2Variants.REGISTRY.get(variants.get(i));
				if (v instanceof VariantColor && v.matches(gem, VariantColor.class, tags)) {
					VariantColor c = (VariantColor) v;
					color = c.getColor();
					rolls = r;
				}
			}
		}
		return color;
	}
	
	public static String loadVariantName(EntityGem gem, String... tags) {
		ArrayList<ResourceLocation> variants = Ke2Variants.TABLE.get(Ke2Gems.REGISTRY_REVERSE.get(gem.getClass()));
		String name = "";
		int rolls = 30;
		for (int r = 0; r < rolls; ++r) {
			for (int i = 0; i < variants.size(); ++i) {
				IVariant<?> v = Ke2Variants.REGISTRY.get(variants.get(i));
				if (v instanceof VariantName && v.matches(gem, VariantName.class, tags)) {
					VariantName n = (VariantName) v;
					name = n.getName();
					rolls = r;
				}
			}
		}
		return name;
	}
	
	public static String loadVariantPath(EntityGem gem, String... tags) {
		ArrayList<ResourceLocation> variants = Ke2Variants.TABLE.get(Ke2Gems.REGISTRY_REVERSE.get(gem.getClass()));
		ResourceLocation path = VariantPath.getDefaultPath();
		int rolls = 30;
		for (int r = 0; r < rolls; ++r) {
			for (int i = 0; i < variants.size(); ++i) {
				IVariant<?> v = Ke2Variants.REGISTRY.get(variants.get(i));
				if (v instanceof VariantPath && v.matches(gem, VariantPath.class, tags)) {
					VariantPath p = (VariantPath) v;
					path = p.getPath();
					rolls = r;
				}
			}
		}
		return path.toString();
	}
}
