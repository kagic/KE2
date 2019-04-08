package mod.ke2.client.render.gem;

import mod.ke2.client.model.gem.ModelWatermelonTourmaline;
import mod.ke2.client.render.RenderGem;
import mod.ke2.client.render.gem.layers.LayerGemstone;
import mod.ke2.client.render.gem.layers.LayerHair;
import mod.ke2.client.render.gem.layers.LayerInsignia;
import mod.ke2.client.render.gem.layers.LayerJacket;
import mod.ke2.client.render.gem.layers.LayerNoDyeOverlay;
import mod.ke2.client.render.gem.layers.LayerSkin;
import mod.ke2.client.render.gem.layers.LayerUniform;
import mod.ke2.client.render.gem.layers.LayerVisor;
import mod.ke2.entity.gem.EntityWatermelonTourmaline;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderWatermelonTourmaline<T extends EntityWatermelonTourmaline> extends RenderGem<T> {
	public RenderWatermelonTourmaline(RenderManager manager) {
		super(manager, new ModelWatermelonTourmaline(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityWatermelonTourmaline.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityWatermelonTourmaline.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityWatermelonTourmaline.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityWatermelonTourmaline.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityWatermelonTourmaline.GEMSTONES));
	}
}
