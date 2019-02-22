package mod.kagic.client.render.layers;

import mod.kagic.entity.EntityGem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;

public class LayerVisor implements LayerRenderer<EntityGem> {
	private final RenderLivingBase<?> gemRenderer;
	private final ModelBase gemModel;
	
	public LayerVisor(RenderLivingBase<?> gemRenderer) {
		this.gemRenderer = gemRenderer;
		this.gemModel = gemRenderer.getMainModel();
	}
	@Override
	public void doRenderLayer(EntityGem entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (entity.hasVisor()) {
			GlStateManager.color(1.0F, 1.0F, 1.0F);
			GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			this.gemRenderer.bindTexture(this.getTexture(entity));
			this.gemModel.setModelAttributes(this.gemRenderer.getMainModel());
	        this.gemModel.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	        GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
		}
	}
	public ResourceLocation getTexture(EntityGem gem) {
		ResourceLocation loc = EntityList.getKey(gem);
		return new ResourceLocation(loc.getResourceDomain() + ":textures/entities/" + this.getName(gem) + "/visor.png");
	}
	public String getName(EntityGem gem) {
		ResourceLocation loc = EntityList.getKey(gem);
		if (loc.getResourceDomain().equals("kagic")) {
	        return loc.getResourcePath().replaceFirst("kagic.", "");
		}
		else {
	        return loc.getResourcePath();
		}
	}
	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
