package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelLapisLazuli;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityLapisLazuli;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderLapisLazuli<T extends EntityLapisLazuli> extends RenderGem<T> {
	public RenderLapisLazuli(RenderManager manager) {
		super(manager, new ModelLapisLazuli(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityLapisLazuli.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityLapisLazuli.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityLapisLazuli.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityLapisLazuli.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityLapisLazuli.GEMSTONES));
	}
}
