package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelPeridot;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityPeridot;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPeridot<T extends EntityPeridot> extends RenderGem<T> {
	public RenderPeridot(RenderManager manager) {
		super(manager, new ModelPeridot(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityPeridot.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityPeridot.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityPeridot.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityPeridot.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityPeridot.GEMSTONES));
	}
}
