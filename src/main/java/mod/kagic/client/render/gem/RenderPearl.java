package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelPearl;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityPearl;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPearl<T extends EntityPearl> extends RenderGem<T> {
	public RenderPearl(RenderManager manager) {
		super(manager, new ModelPearl(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityPearl.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityPearl.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityPearl.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityPearl.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityPearl.GEMSTONES));
	}
}
