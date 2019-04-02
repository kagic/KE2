package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelLarimar;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityLarimar;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderLarimar<T extends EntityLarimar> extends RenderGem<T> {
	public RenderLarimar(RenderManager manager) {
		super(manager, new ModelLarimar(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityLarimar.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityLarimar.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityLarimar.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityLarimar.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityLarimar.GEMSTONES));
	}
}
