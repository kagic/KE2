package mod.ke2.api.variants;

import java.util.ArrayList;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.util.ResourceLocation;

public class ResourceVariant implements IVariant {
	protected String name;
	protected String category;
	protected String[] gems;
	protected String function;
	protected String param;
	protected String value;
	
	@Override
	public boolean matches(EntityGem gem, ResourceLocation category) {
		if (category.equals(this.getCategory())) {
			ArrayList<ResourceLocation> gems = this.getGems();
			if (gems.contains(Ke2Gems.GEM_REGISTRY_REVERSE.get(gem.getClass()))) {
				switch (Variants.Functions.fromCode(this.function)) {
				case INSIGNIA_COLOR:
					break;
				case IS_DEFECTIVE:
					break;
				case IS_PERFECTIVE:
					break;
				case RANDOM:
					break;
				case SPAWNED_ABOVE:
					break;
				case SPAWNED_BELOW:
					break;
				case SPAWNED_IN_BIOME:
					break;
				default:
					break;
				}
			}
		}
		return false;
	}
	@Override
	public ResourceLocation getName() {
		return new ResourceLocation(this.name);
	}
	@Override
	public ResourceLocation getCategory() {
		return new ResourceLocation(this.category);
	}
	@Override
	public String getValue() {
		return this.value;
	}
	public ArrayList<ResourceLocation> getGems() {
		ArrayList<ResourceLocation> gems = new ArrayList<ResourceLocation>();
		for (int i = 0; i < this.gems.length; ++i) {
			gems.add(new ResourceLocation(this.gems[i]));
		}
		return gems;
	}
}
