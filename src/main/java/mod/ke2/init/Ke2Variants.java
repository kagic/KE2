package mod.ke2.init;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import mod.ke2.api.variants.IVariant;
import net.minecraft.util.ResourceLocation;

public class Ke2Variants {
	public static final HashMap<ResourceLocation, ArrayList<ResourceLocation>> TABLE = new HashMap<ResourceLocation, ArrayList<ResourceLocation>>();
	public static final HashMap<ResourceLocation, IVariant<?>> REGISTRY = new HashMap<ResourceLocation, IVariant<?>>();
	
	public static void register() {
		
	}
	public static void registerVariant(ResourceLocation loc, Class<? extends IVariant<?>> type) {
		InputStream in = Ke2Gems.class.getResourceAsStream("assets/" + loc.getResourcePath() + "/" + loc.getResourceDomain());
		IVariant<?> variant = KAGIC.JSON.fromJson(new BufferedReader(new InputStreamReader(in)), type);
		registerVariant(loc, variant);
	}
	public static void registerVariant(ResourceLocation loc, IVariant<?> variant) {
		if (!Ke2Variants.REGISTRY.containsKey(loc)) {
			Ke2Variants.REGISTRY.put(loc, variant);
		}
		else {
			KAGIC.LOGGER.warn("Variant '%s' already exists! Skipping!", loc);
			KAGIC.LOGGER.warn("Report this to addon or mod author!");
		}
	}
}
