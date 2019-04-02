package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelNephrite;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityNephrite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderNephrite<T extends EntityNephrite> extends RenderGem<T> {
	public RenderNephrite(RenderManager manager) {
		super(manager, new ModelNephrite(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityNephrite.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityNephrite.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityNephrite.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityNephrite.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityNephrite.GEMSTONES));
	}
}
