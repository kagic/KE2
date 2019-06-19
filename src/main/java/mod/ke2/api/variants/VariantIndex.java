package mod.ke2.api.variants;

import net.minecraft.util.ResourceLocation;

public class VariantIndex {
	public String applicant;
	public String[] colors;
	public String[] textures;
	public String[] names;

	public boolean matches(ResourceLocation applicant) {
		return applicant.equals(new ResourceLocation(this.applicant));
	}
}
