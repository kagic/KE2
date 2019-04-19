package mod.ke2.api.variants;

import mod.ke2.api.EntityGem;

public interface IVariant<T> {
	public boolean matches(EntityGem gem, Class<?> type, String... tags);
	public String[] getTags();
	public T getValue();
}
