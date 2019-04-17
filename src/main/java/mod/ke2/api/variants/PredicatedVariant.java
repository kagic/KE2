package mod.ke2.api.variants;

import com.google.common.base.Predicate;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.util.ResourceLocation;

public class PredicatedVariant implements IVariant {
	private final ResourceLocation name;
	private final Class<? extends EntityGem> gem;
	private final ResourceLocation category;
	private final Predicate<EntityGem> predicate;
	private final String value;
	public PredicatedVariant(ResourceLocation name, Class<? extends EntityGem> gem, ResourceLocation category, Predicate<EntityGem> predicate, String value) {
		this.name = name;
		this.gem = gem;
		this.category = category;
		this.predicate = predicate;
		this.value = value;
	}
	@Override
	public boolean matches(EntityGem gem, ResourceLocation category) {
		if (category.equals(this.getCategory())) {
			if (Ke2Gems.GEM_REGISTRY_REVERSE.get(this.gem).equals(Ke2Gems.GEM_REGISTRY_REVERSE.get(gem.getClass()))) {
				return this.predicate.apply(gem);
			}
		}
		return false;
	}
	@Override
	public ResourceLocation getName() {
		return this.name;
	}
	@Override
	public ResourceLocation getCategory() {
		return this.category;
	}
	@Override
	public String getValue() {
		return this.value;
	}
}
