package mod.ke2.api.variants.types;

import mod.ke2.api.variants.IVariant;
import net.minecraft.util.ResourceLocation;

public class VariantPath extends AbstractVariant<ResourceLocation> implements IVariant<ResourceLocation>  {
	public ResourceLocation getPath() {
		return this.getValue();
	}
	public static ResourceLocation getDefaultPath() {
		return new ResourceLocation("kagic:textures/entities/none/null");
	}
}
