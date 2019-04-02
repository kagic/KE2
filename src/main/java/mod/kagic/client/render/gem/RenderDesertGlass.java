package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelDesertGlass;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityDesertGlass;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDesertGlass<T extends EntityDesertGlass> extends RenderGem<T> {
	public RenderDesertGlass(RenderManager manager) {
		super(manager, new ModelDesertGlass(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityDesertGlass.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityDesertGlass.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityDesertGlass.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityDesertGlass.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityDesertGlass.GEMSTONES));
	}
}
