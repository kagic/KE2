package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelJade;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityJade;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderJade<T extends EntityJade> extends RenderGem<T> {
	public RenderJade(RenderManager manager) {
		super(manager, new ModelJade(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityJade.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityJade.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityJade.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityJade.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityJade.GEMSTONES));
	}
}
