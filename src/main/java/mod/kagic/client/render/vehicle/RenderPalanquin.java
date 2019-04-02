package mod.kagic.client.render.vehicle;

import mod.kagic.client.model.vehicle.ModelPalanquin;
import mod.kagic.entity.vehicle.EntityPalanquin;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class RenderPalanquin extends RenderLiving<EntityPalanquin> {
	public RenderPalanquin(RenderManager manager) {
		super(manager, new ModelPalanquin(), 0.5F);
		this.layerRenderers.add(new LayerPalanquinColor(this));
		this.layerRenderers.add(new LayerPalanquinHighlights(this));
		this.layerRenderers.add(new LayerPalanquinVeil(this));
	}
	@Override
	protected ResourceLocation getEntityTexture(EntityPalanquin entity) {
		return new ResourceLocation("kagic:textures/entities/white.png");
	}
	public static class LayerPalanquinColor implements LayerRenderer<EntityPalanquin> {
	    private final RenderPalanquin renderer;
	    public LayerPalanquinColor(RenderPalanquin renderer) {
	        this.renderer = renderer;
	    }
	    @Override
		public void doRenderLayer(EntityPalanquin entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
	        float[] rgb = EnumDyeColor.byDyeDamage(entity.getBodyColor()).getColorComponentValues();
	        if (!entity.isInvisible()) {
	        	this.renderer.bindTexture(new ResourceLocation("kagic:textures/entities/palanquin/palanquin.png"));
	            GlStateManager.color(rgb[0], rgb[1], rgb[2], 1.0F);
	            this.renderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	    		GlStateManager.disableBlend();
	        }
	    }
	    @Override
		public boolean shouldCombineTextures() {
	        return false;
	    }
	}
	public class LayerPalanquinHighlights implements LayerRenderer<EntityPalanquin> {
	    private final RenderPalanquin renderer;
	    public LayerPalanquinHighlights(RenderPalanquin renderer) {
	        this.renderer = renderer;
	    }
	    @Override
		public void doRenderLayer(EntityPalanquin entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
	        float[] rgb = EnumDyeColor.byDyeDamage(entity.getHighlightColor()).getColorComponentValues();
	        if (!entity.isInvisible()) {
	        	this.renderer.bindTexture(new ResourceLocation("kagic:textures/entities/palanquin/highlights.png"));
	            GlStateManager.color(rgb[0], rgb[1], rgb[2], 1.0F);
	            this.renderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	            GlStateManager.disableBlend();
	        }
	    }
	    @Override
		public boolean shouldCombineTextures() {
	        return false;
	    }
	}
	public class LayerPalanquinVeil implements LayerRenderer<EntityPalanquin> {
	    private final RenderPalanquin renderer;
	    public LayerPalanquinVeil(RenderPalanquin renderer) {
	        this.renderer = renderer;
	    }
	    @Override
		public void doRenderLayer(EntityPalanquin entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
	        float[] rgb = EnumDyeColor.byDyeDamage(entity.getVeilColor()).getColorComponentValues();
	        if (!entity.isInvisible()) {
	        	this.renderer.bindTexture(new ResourceLocation("kagic:textures/entities/palanquin/veil.png"));
	        	GlStateManager.color(rgb[0], rgb[1], rgb[2], 0.5F);
	    		GlStateManager.enableBlend();
	    		GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
	            this.renderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	        }
	    }
	    @Override
		public boolean shouldCombineTextures() {
	        return false;
	    }
	}
}
