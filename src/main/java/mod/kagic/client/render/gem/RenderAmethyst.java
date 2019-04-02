package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelQuartz;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityAmethyst;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderAmethyst<T extends EntityAmethyst> extends RenderGem<T> {
	public RenderAmethyst(RenderManager manager) {
		super(manager, new ModelQuartz(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityAmethyst.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityAmethyst.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityAmethyst.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityAmethyst.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityAmethyst.GEMSTONES));
	}
}
