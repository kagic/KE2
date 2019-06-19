package mod.ke2.api.variants;

import mod.ke2.api.EntityGem;

public interface IVariant<T> {
	boolean matches(EntityGem gem, Class<?> type, String... tags);
	
	String[] getTags();
	
	T getValue();
}
