package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelSapphire;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntitySapphire;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSapphire<T extends EntitySapphire> extends RenderGem<T> {
	public RenderSapphire(RenderManager manager) {
		super(manager, new ModelSapphire(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntitySapphire.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntitySapphire.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntitySapphire.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntitySapphire.JACKETS));
		this.addLayer(new LayerGemstone(this, EntitySapphire.GEMSTONES));
	}
}
