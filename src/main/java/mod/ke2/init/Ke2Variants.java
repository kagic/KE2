package mod.ke2.init;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.IVariant;
import mod.ke2.api.variants.types.VariantColor;
import mod.ke2.api.variants.types.VariantPath;
import mod.ke2.entity.gem.EntityRuby;
import net.minecraft.util.ResourceLocation;

public class Ke2Variants {
	public static final HashMap<ResourceLocation, ArrayList<ResourceLocation>> TABLE = new HashMap<ResourceLocation, ArrayList<ResourceLocation>>();
	public static final HashMap<ResourceLocation, IVariant<?>> REGISTRY = new HashMap<ResourceLocation, IVariant<?>>();
	
	public static void register() {
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/default_hair"), VariantPath.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/default_outfit"), VariantPath.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/default_skin"), VariantPath.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/doc_outfit"), VariantPath.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/gemstone_cut"), VariantPath.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/gemstone_color"), VariantColor.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/hair_color"), VariantColor.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/outfit_color"), VariantColor.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/skin_color"), VariantColor.class),
				EntityRuby.class);
		addVariantToGem(registerVariant(new ResourceLocation("ke2:variants/ruby/visor_color"), VariantColor.class),
				EntityRuby.class);
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
}
