package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelBismuth;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityBismuth;
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
