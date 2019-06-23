package mod.ke2.api.variants.types;

import mod.ke2.api.variants.IVariant;
import net.minecraft.util.ResourceLocation;

public class VariantPath extends AbstractVariant<String> implements IVariant<String> {
	public ResourceLocation getPath() {
		return new ResourceLocation(this.getValue());
	}

	public static ResourceLocation getDefaultPath() {
		return new ResourceLocation("ke2:textures/entities/none/null");
	}
}
