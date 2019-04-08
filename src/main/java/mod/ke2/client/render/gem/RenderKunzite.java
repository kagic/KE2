package mod.ke2.client.render.gem;

import mod.ke2.client.model.gem.ModelSpodumene;
import mod.ke2.client.render.RenderGem;
import mod.ke2.client.render.gem.layers.LayerGemstone;
import mod.ke2.client.render.gem.layers.LayerHair;
import mod.ke2.client.render.gem.layers.LayerInsignia;
import mod.ke2.client.render.gem.layers.LayerJacket;
import mod.ke2.client.render.gem.layers.LayerNoDyeOverlay;
import mod.ke2.client.render.gem.layers.LayerSkin;
import mod.ke2.client.render.gem.layers.LayerUniform;
import mod.ke2.client.render.gem.layers.LayerVisor;
import mod.ke2.entity.gem.EntityKunzite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderKunzite<T extends EntityKunzite> extends RenderGem<T> {
	public RenderKunzite(RenderManager manager) {
		super(manager, new ModelSpodumene(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityKunzite.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityKunzite.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityKunzite.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityKunzite.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityKunzite.GEMSTONES));
	}
}
