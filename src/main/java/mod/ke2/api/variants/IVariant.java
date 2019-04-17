package mod.ke2.api.variants;

import mod.ke2.api.EntityGem;
import mod.ke2.api.injection.GemSpawnData;
import net.minecraft.util.ResourceLocation;

public interface IVariant {
	public boolean matches(EntityGem gem, ResourceLocation category, GemSpawnData data);
	public ResourceLocation getName();
	public ResourceLocation getCategory();
}
