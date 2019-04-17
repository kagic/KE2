package mod.ke2.api.variants;

import mod.ke2.api.EntityGem;
import net.minecraft.util.ResourceLocation;

public interface IVariant {
	public boolean matches(EntityGem gem, ResourceLocation category);
	public ResourceLocation getName();
	public ResourceLocation getCategory();
	public String getValue();
}
