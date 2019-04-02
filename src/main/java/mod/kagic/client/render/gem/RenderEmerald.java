package mod.kagic.client.render.gem;

import mod.kagic.client.model.gem.ModelEmerald;
import mod.kagic.client.render.RenderGem;
import mod.kagic.client.render.gem.layers.LayerGemstone;
import mod.kagic.client.render.gem.layers.LayerHair;
import mod.kagic.client.render.gem.layers.LayerInsignia;
import mod.kagic.client.render.gem.layers.LayerJacket;
import mod.kagic.client.render.gem.layers.LayerNoDyeOverlay;
import mod.kagic.client.render.gem.layers.LayerSkin;
import mod.kagic.client.render.gem.layers.LayerUniform;
import mod.kagic.client.render.gem.layers.LayerVisor;
import mod.kagic.entity.gem.EntityEmerald;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderEmerald<T extends EntityEmerald> extends RenderGem<T> {
	public RenderEmerald(RenderManager manager) {
		super(manager, new ModelEmerald(), 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this, EntityEmerald.UNIFORMS));
		this.addLayer(new LayerInsignia(this, EntityEmerald.INSIGNIAS));
		this.addLayer(new LayerHair(this, EntityEmerald.HAIRSTYLES));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this, EntityEmerald.JACKETS));
		this.addLayer(new LayerGemstone(this, EntityEmerald.GEMSTONES));
	}
}
