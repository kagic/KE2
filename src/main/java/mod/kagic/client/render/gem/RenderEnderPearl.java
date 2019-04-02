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
import mod.kagic.entity.gem.EntityEnderPearl;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderEnderPearl<T extends EntityEnderPearl> extends RenderGem<T> {
	public RenderEnderPearl(RenderManager manager) {
		super(manager, new ModelPearl(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityEnderPearl.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityEnderPearl.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityEnderPearl.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityEnderPearl.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityEnderPearl.GEMSTONES));
	}
}
