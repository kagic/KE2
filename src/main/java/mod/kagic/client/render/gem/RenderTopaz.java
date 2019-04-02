package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelTopaz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityTopaz;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderTopaz<T extends EntityTopaz> extends RenderGem<T> {
	public RenderTopaz(RenderManager manager) {
		super(manager, new ModelTopaz(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityTopaz.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityTopaz.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityTopaz.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityTopaz.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityTopaz.GEMSTONES));
	}
}
