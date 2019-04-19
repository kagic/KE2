package mod.ke2.api.variants.types;

import mod.ke2.api.variants.IVariant;
import net.minecraft.util.text.translation.I18n;

public class VariantName extends AbstractVariant<String> implements IVariant<String>  {
	public String getName() {
		return I18n.translateToLocal(this.getValue());
	}
}
