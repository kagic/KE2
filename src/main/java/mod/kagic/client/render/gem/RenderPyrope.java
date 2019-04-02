package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelGarnet;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityPyrope;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPyrope<T extends EntityPyrope> extends RenderGem<T> {
	public RenderPyrope(RenderManager manager) {
		super(manager, new ModelGarnet(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityPyrope.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityPyrope.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityPyrope.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityPyrope.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityPyrope.GEMSTONES));
	}
}
