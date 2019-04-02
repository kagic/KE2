package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityCarnelian;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCarnelian<T extends EntityCarnelian> extends RenderGem<T> {
	public RenderCarnelian(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityCarnelian.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityCarnelian.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityCarnelian.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityCarnelian.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityCarnelian.GEMSTONES));
	}
}
