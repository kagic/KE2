package mod.ke2.client.render.gem;

import mod.ke2.client.model.gem.ModelRutile;
import mod.ke2.client.render.RenderGem;
import mod.ke2.client.render.gem.layers.LayerGemstone;
import mod.ke2.client.render.gem.layers.LayerHair;
import mod.ke2.client.render.gem.layers.LayerInsignia;
import mod.ke2.client.render.gem.layers.LayerJacket;
import mod.ke2.client.render.gem.layers.LayerNoDyeOverlay;
import mod.ke2.client.render.gem.layers.LayerSkin;
import mod.ke2.client.render.gem.layers.LayerUniform;
import mod.ke2.client.render.gem.layers.LayerVisor;
import mod.ke2.entity.gem.EntityRutile;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRutile<T extends EntityRutile> extends RenderGem<T> {
	public RenderRutile(RenderManager manager) {
		super(manager, new ModelRutile(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityRutile.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityRutile.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityRutile.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityRutile.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityRutile.GEMSTONES));
	}
}
