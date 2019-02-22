package mod.kagic.client.render;

import java.util.Iterator;

import mod.kagic.entity.EntityGem;
import mod.kagic.init.Ke2Configs;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

public class RenderGem<T extends EntityGem> extends RenderBiped<T> {
	public RenderGem(RenderManager manager, ModelBiped model, float shadowSize) {
		super(manager, model, shadowSize);
		for (Iterator<LayerRenderer<T>> it = this.layerRenderers.iterator(); it.hasNext();) {
			LayerRenderer<? extends EntityLivingBase> layer = it.next();
			if (layer instanceof LayerHeldItem) {
				it.remove();
			}
		}
	}
	@Override
	protected void preRenderCallback(T gem, float partialTickTime) {
		GlStateManager.scale(0.925F, 0.925F, 0.925F);
		if (gem.isDefective()) {
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
		}
		if (gem.isPerfect()) {
			GlStateManager.scale(1.5F, 1.5F, 1.5F);
		}
	}
	@Override
	protected void renderEntityName(T entity, double x, double y, double z, String name, double distanceSq) {
		if (Ke2Configs.showDescriptors) {
			this.renderLivingLabel(entity, "(" + entity.getDescriptor() + ")", x, y, z, 64);
			this.renderLivingLabel(entity, name, x, y + 0.25, z, 64);
		}
		else {
			this.renderLivingLabel(entity, name, x, y, z, 64);
		}
    }
}
