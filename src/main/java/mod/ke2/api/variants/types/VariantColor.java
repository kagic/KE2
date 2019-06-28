package mod.ke2.api.variants.types;

import mod.ke2.api.GemColorHandler;
import mod.ke2.api.variants.IVariant;

public class VariantColor extends AbstractVariant<String[]> implements IVariant<String[]> {
	public int[] getColors() {
		int[] colors = new int[this.getValue().length];
		for (int i = 0; i < colors.length; ++i) {
			String value = this.getValue()[i].toLowerCase();
			colors[i] = Integer.parseInt(value, 16);
		}
		return colors;
	}

	public int getColor() {
		return GemColorHandler.mix(this.getColors());
	}
}
