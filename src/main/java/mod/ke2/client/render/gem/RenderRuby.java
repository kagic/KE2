package mod.ke2.client.render.gem;

import mod.ke2.client.model.gem.ModelRuby;
import mod.ke2.client.render.RenderGem;
import mod.ke2.client.render.gem.layers.LayerGemstone;
import mod.ke2.client.render.gem.layers.LayerHair;
import mod.ke2.client.render.gem.layers.LayerInsignia;
import mod.ke2.client.render.gem.layers.LayerJacket;
import mod.ke2.client.render.gem.layers.LayerNoDyeOverlay;
import mod.ke2.client.render.gem.layers.LayerSkin;
import mod.ke2.client.render.gem.layers.LayerUniform;
import mod.ke2.client.render.gem.layers.LayerVisor;
import mod.ke2.entity.gem.EntityRuby;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRuby<T extends EntityRuby> extends RenderGem<T> {
	public RenderRuby(RenderManager manager) {
		super(manager, new ModelRuby(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityRuby.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityRuby.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityRuby.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityRuby.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityRuby.GEMSTONES));
	}
}
