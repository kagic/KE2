package mod.ke2.api.variants.types;

import mod.ke2.api.EntityGem;
import mod.ke2.api.variants.IVariant;
import mod.ke2.api.variants.VariantHelper;

public class AbstractVariant<T> implements IVariant<T> {
	protected String function;
	protected String parameter;
	protected String[] tags;
	protected T value;
	
	@Override
	public boolean matches(EntityGem gem, Class<?> type, String... tags) {
		for (int x = 0; x < this.tags.length; ++x) {
			for (int y = 0; y < tags.length; ++y) {
				if (this.tags[x].equals(tags[y])) {
					switch (VariantHelper.Functions.valueOf(this.getFunction().toUpperCase())) {
					case INSIGNIA_COLOR:
						return VariantHelper.tryInsigniaColor(gem, this.getParameter());
					case GEM_PLACEMENT:
						return VariantHelper.tryGemPlacement(gem, this.getParameter());
					case IS_DEFECTIVE:
						return VariantHelper.tryIsDefective(gem, this.getParameter());
					case IS_PERFECTIVE:
						return VariantHelper.tryIsPerfective(gem, this.getParameter());
					case IS_NORMAL:
						return VariantHelper.tryIsNormal(gem, this.getParameter());
					case RANDOM:
						return VariantHelper.tryRandom(gem, this.getParameter());
					case WEIGHTED:
						return VariantHelper.tryWeighted(gem, this.getParameter());
					case SPAWNED_ABOVE:
						return VariantHelper.trySpawnedAbove(gem, this.getParameter());
					case SPAWNED_BELOW:
						return VariantHelper.trySpawnedBelow(gem, this.getParameter());
					case SPAWNED_IN_BIOME:
						return VariantHelper.trySpawnedInBiome(gem, this.getParameter());
					default:
						return VariantHelper.tryAlwaysTrue(gem, this.getParameter());
					}
				}
			}
		}
		return false;
	}
	@Override
	public String[] getTags() {
		return this.tags;
	}
	@Override
	public T getValue() {
		return this.value;
	}
	public String getFunction() {
		return this.function;
	}
	public String getParameter() {
		return this.parameter;
	}
}