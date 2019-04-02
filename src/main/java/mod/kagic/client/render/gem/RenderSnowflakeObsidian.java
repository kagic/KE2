package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelSnowflakeObsidian;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntitySnowflakeObsidian;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSnowflakeObsidian<T extends EntitySnowflakeObsidian> extends RenderGem<T> {
	public RenderSnowflakeObsidian(RenderManager manager) {
		super(manager, new ModelSnowflakeObsidian(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntitySnowflakeObsidian.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntitySnowflakeObsidian.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntitySnowflakeObsidian.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntitySnowflakeObsidian.JACKETS));
		this.addLayer(new LayerGemstone(this, EntitySnowflakeObsidian.GEMSTONES));
	}
}
