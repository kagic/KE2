package mod.ke2.client.render.gem;

import mod.ke2.client.model.gem.ModelBismuth;
import mod.ke2.client.render.RenderGem;
import mod.ke2.client.render.gem.layers.LayerGemstone;
import mod.ke2.client.render.gem.layers.LayerHair;
import mod.ke2.client.render.gem.layers.LayerInsignia;
import mod.ke2.client.render.gem.layers.LayerJacket;
import mod.ke2.client.render.gem.layers.LayerNoDyeOverlay;
import mod.ke2.client.render.gem.layers.LayerSkin;
import mod.ke2.client.render.gem.layers.LayerUniform;
import mod.ke2.client.render.gem.layers.LayerVisor;
import mod.ke2.entity.gem.EntityBismuth;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderBismuth<T extends EntityBismuth> extends RenderGem<T> {
	public RenderBismuth(RenderManager manager) {
		super(manager, new ModelBismuth(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityBismuth.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityBismuth.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityBismuth.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityBismuth.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityBismuth.GEMSTONES));
	}
}
