package mod.ke2.client.render.gem;

import mod.ke2.client.model.gem.ModelPearl;
import mod.ke2.client.render.RenderGem;
import mod.ke2.client.render.gem.layers.LayerGemstone;
import mod.ke2.client.render.gem.layers.LayerHair;
import mod.ke2.client.render.gem.layers.LayerInsignia;
import mod.ke2.client.render.gem.layers.LayerJacket;
import mod.ke2.client.render.gem.layers.LayerNoDyeOverlay;
import mod.ke2.client.render.gem.layers.LayerSkin;
import mod.ke2.client.render.gem.layers.LayerUniform;
import mod.ke2.client.render.gem.layers.LayerVisor;
import mod.ke2.entity.gem.EntityEnderPearl;
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
