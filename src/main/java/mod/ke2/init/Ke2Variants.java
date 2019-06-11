package mod.ke2.init;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import mod.ke2.KAGIC;
import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.IVariant;
import mod.ke2.api.variants.VariantIndex;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantName;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.entity.gem.AbstractGarnet;
import mod.ke2.entity.gem.AbstractQuartz;
import net.minecraft.util.ResourceLocation;

public class Ke2Variants {
	public static final HashMap<ResourceLocation, ArrayList<ResourceLocation>> TABLE = new HashMap<ResourceLocation, ArrayList<ResourceLocation>>();
	public static final HashMap<ResourceLocation, IVariant<?>> REGISTRY = new HashMap<ResourceLocation, IVariant<?>>();
	
	public static void register() {
		registerGarnetVariants();
		registerQuartzVariants();
	}
	public static void registerGarnetVariants() {
		AbstractGarnet.GLOBAL_VARIANT_PATHS.add(registerVariant(new ResourceLocation("ke2:variants/garnet/outfit_default"), VariantPath.class));
		AbstractGarnet.GLOBAL_VARIANT_PATHS.add(registerVariant(new ResourceLocation("ke2:variants/garnet/skin_default"), VariantPath.class));
		AbstractGarnet.GLOBAL_VARIANT_PATHS.add(registerVariant(new ResourceLocation("ke2:variants/garnet/cut_faceted"), VariantPath.class));
		for (Class<? extends AbstractGarnet> garnet : AbstractGarnet.GLOBAL_VARIANT_CLASSES) {
			for (ResourceLocation variant : AbstractGarnet.GLOBAL_VARIANT_PATHS) {
				addVariantToGem(variant, garnet);
			}
		}
	}
	public static void registerQuartzVariants() {
		AbstractQuartz.GLOBAL_VARIANT_PATHS.add(registerVariant(new ResourceLocation("ke2:variants/quartz/hair_long_and_straight"), VariantPath.class));
		AbstractQuartz.GLOBAL_VARIANT_PATHS.add(registerVariant(new ResourceLocation("ke2:variants/quartz/outfit_default"), VariantPath.class));
		AbstractQuartz.GLOBAL_VARIANT_PATHS.add(registerVariant(new ResourceLocation("ke2:variants/quartz/skin_default"), VariantPath.class));
		AbstractQuartz.GLOBAL_VARIANT_PATHS.add(registerVariant(new ResourceLocation("ke2:variants/quartz/cut_faceted"), VariantPath.class));
		AbstractQuartz.GLOBAL_VARIANT_PATHS.add(registerVariant(new ResourceLocation("ke2:variants/quartz/eyes_default"), VariantPath.class));
		for (Class<? extends AbstractQuartz> quartz : AbstractQuartz.GLOBAL_VARIANT_CLASSES) {
			for (ResourceLocation variant : AbstractQuartz.GLOBAL_VARIANT_PATHS) {
				addVariantToGem(variant, quartz);
			}
		}
	}
	public static ResourceLocation registerVariant(ResourceLocation loc, Class<? extends IVariant<?>> type) {
		try {
			InputStream in = Ke2Gems.class.getResourceAsStream("/assets/" + loc.getResourceDomain() + "/" + loc.getResourcePath() + ".json");
			IVariant<?> variant = KAGIC.JSON.fromJson(new BufferedReader(new InputStreamReader(in)), type);
			return registerVariant(loc, variant);
		} catch (NullPointerException e) {
			KAGIC.LOGGER.warn("Variant '{}' doesn't exist in source! Skipping!", loc.toString());
			KAGIC.LOGGER.warn("Report this to addon or mod author!");
		}
		return null;
	}
	public static ResourceLocation registerVariant(ResourceLocation loc, IVariant<?> variant) {
		if (!Ke2Variants.REGISTRY.containsKey(loc)) {
			Ke2Variants.REGISTRY.put(loc, variant);
		}
		else {
			KAGIC.LOGGER.warn("Variant '{}' already exists! Skipping!", loc.toString());
			KAGIC.LOGGER.warn("Report this to addon or mod author!");
		}
		return loc;
	}
	public static void addVariantToGem(ResourceLocation loc, ResourceLocation... gem) {
		for (int i = 0; i < gem.length; ++i) {
			Ke2Variants.TABLE.get(gem[i]).add(loc);
		}
	}
	public static void addVariantToGem(ResourceLocation loc, Class<? extends EntityGem>... gem) {
		for (int i = 0; i < gem.length; ++i) { 
			addVariantToGem(loc, Ke2Gems.REGISTRY_REVERSE.get(gem[i]));
		}
	}
	public static void addVariantIndexFile(ResourceLocation loc, ResourceLocation... gem) {
		try {
			InputStream in = Ke2Gems.class.getResourceAsStream("/assets/" + loc.getResourceDomain() + "/" + loc.getResourcePath() + ".json");
			VariantIndex index = KAGIC.JSON.fromJson(new BufferedReader(new InputStreamReader(in)), VariantIndex.class);
			for (int i = 0; i < gem.length; ++i) {
				if (index.matches(gem[i])) {
					for (int t = 0; t < index.colors.length; ++t) {
						addVariantToGem(registerVariant(new ResourceLocation(index.colors[t]), VariantColor.class), gem[i]);
					}
					for (int t = 0; t < index.textures.length; ++t) {
						addVariantToGem(registerVariant(new ResourceLocation(index.textures[t]), VariantPath.class), gem[i]);
					}
					for (int t = 0; t < index.names.length; ++t) {
						addVariantToGem(registerVariant(new ResourceLocation(index.names[t]), VariantName.class), gem[i]);
					}
				}
				else {
					KAGIC.LOGGER.warn("Gem '{}' doesn't match its registered index! Skipping!", gem[i].toString());
					KAGIC.LOGGER.warn("Report this to addon or mod author!");
				}
			}
		} catch (NullPointerException e) {
			KAGIC.LOGGER.warn("Index '{}' doesn't exist in source! Skipping!", loc.toString());
			KAGIC.LOGGER.warn("Report this to addon or mod author!");
		}
	}
	public static void addVariantIndexFile(ResourceLocation loc, Class<? extends EntityGem>... gem) {
		for (int i = 0; i < gem.length; ++i) {
			addVariantIndexFile(loc, Ke2Gems.REGISTRY_REVERSE.get(gem[i]));
		}
	}
}
