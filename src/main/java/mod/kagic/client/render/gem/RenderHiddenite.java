package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelSpodumene;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityHiddenite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderHiddenite<T extends EntityHiddenite> extends RenderGem<T> {
	public RenderHiddenite(RenderManager manager) {
		super(manager, new ModelSpodumene(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityHiddenite.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityHiddenite.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityHiddenite.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityHiddenite.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityHiddenite.GEMSTONES));
	}
}
