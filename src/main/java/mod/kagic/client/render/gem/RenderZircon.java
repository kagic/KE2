package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelZircon;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityZircon;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderZircon<T extends EntityZircon> extends RenderGem<T> {
	public RenderZircon(RenderManager manager) {
		super(manager, new ModelZircon(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityZircon.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityZircon.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityZircon.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityZircon.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityZircon.GEMSTONES));
	}
}
