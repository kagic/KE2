package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelMotherOfPearl;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityMotherOfPearl;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMotherOfPearl<T extends EntityMotherOfPearl> extends RenderGem<T> {
	public RenderMotherOfPearl(RenderManager manager) {
		super(manager, new ModelMotherOfPearl(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityMotherOfPearl.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityMotherOfPearl.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityMotherOfPearl.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityMotherOfPearl.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityMotherOfPearl.GEMSTONES));
	}
}
