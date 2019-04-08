package mod.ke2.client.render.gem.layers;

import mod.ke2.entity.EntityGem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;

public class LayerNoDyeOverlay implements LayerRenderer<EntityGem> {
	private final RenderLivingBase<?> gemRenderer;
	private final ModelBase gemModel;
	private final String name;
	
	public LayerNoDyeOverlay(RenderLivingBase<?> gemRenderer) {
		this(gemRenderer, null);
	}
	
	public LayerNoDyeOverlay(RenderLivingBase<?> gemRenderer, String name) {
		this.gemRenderer = gemRenderer;
		this.gemModel = gemRenderer.getMainModel();
		this.name = name;
	}
	
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (gem.hasNoDyeOverlay()) {
			GlStateManager.color(1.0F, 1.0F, 1.0F);
			this.gemRenderer.bindTexture(this.getTexture(gem));
			this.gemModel.setModelAttributes(this.gemRenderer.getMainModel());
	        this.gemModel.render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.disableBlend();
		}
	}
	
	public ResourceLocation getTexture(EntityGem gem) {
		ResourceLocation loc = EntityList.getKey(gem);
		return new ResourceLocation(loc.getResourceDomain() + ":textures/entities/" + this.getName(gem) + "/overlay.png");
	}
	
	public String getName(EntityGem gem) {
		if (this.name == null) {
			ResourceLocation loc = EntityList.getKey(gem);
			if (loc.getResourceDomain().equals("ke2")) {
		        return loc.getResourcePath().replaceFirst("ke2.", "");
			}
			else {
		        return loc.getResourcePath();
			}
		} else {
			return this.name;
		}
	}
	
	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
