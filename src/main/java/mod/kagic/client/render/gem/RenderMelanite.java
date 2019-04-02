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
import mod.kagic.entity.gem.EntityMelanite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMelanite<T extends EntityMelanite> extends RenderGem<T> {
	public RenderMelanite(RenderManager manager) {
		super(manager, new ModelGarnet(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityMelanite.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityMelanite.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityMelanite.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityMelanite.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityMelanite.GEMSTONES));
	}
}
