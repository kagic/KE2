package mod.ke2.client.render.gem;

import mod.ke2.client.model.gem.ModelJade;
import mod.ke2.client.render.RenderGem;
import mod.ke2.client.render.gem.layers.LayerGemstone;
import mod.ke2.client.render.gem.layers.LayerHair;
import mod.ke2.client.render.gem.layers.LayerInsignia;
import mod.ke2.client.render.gem.layers.LayerJacket;
import mod.ke2.client.render.gem.layers.LayerNoDyeOverlay;
import mod.ke2.client.render.gem.layers.LayerSkin;
import mod.ke2.client.render.gem.layers.LayerUniform;
import mod.ke2.client.render.gem.layers.LayerVisor;
import mod.ke2.entity.gem.EntityJade;
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
