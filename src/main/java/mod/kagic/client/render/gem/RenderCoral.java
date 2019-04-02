package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelCoral;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityCoral;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCoral<T extends EntityCoral> extends RenderGem<T> {
	public RenderCoral(RenderManager manager) {
		super(manager, new ModelCoral(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityCoral.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityCoral.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityCoral.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityCoral.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityCoral.GEMSTONES));
	}
}
