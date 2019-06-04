package mod.ke2.client.render.gem;

import mod.ke2.client.model.gem.ModelJadeBell;
import mod.ke2.client.model.gem.ModelJadeRack;
import mod.ke2.client.model.gem.ModelJadeSpur;
import mod.ke2.client.model.gem.ModelJadeWorm;
import mod.ke2.client.render.RenderGem;
import mod.ke2.client.render.gem.layers.LayerFlower;
import mod.ke2.client.render.gem.layers.LayerGemstone;
import mod.ke2.client.render.gem.layers.LayerHair;
import mod.ke2.client.render.gem.layers.LayerHeldItem;
import mod.ke2.client.render.gem.layers.LayerInsignia;
import mod.ke2.client.render.gem.layers.LayerJacket;
import mod.ke2.client.render.gem.layers.LayerNoDyeOverlay;
import mod.ke2.client.render.gem.layers.LayerSkin;
import mod.ke2.client.render.gem.layers.LayerUniform;
import mod.ke2.client.render.gem.layers.LayerVisor;
import mod.ke2.entity.gem.EntityJade;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderJade<T extends EntityJade> extends RenderGem<T> {
	private static final ModelJadeBell BELL_MODEL = new ModelJadeBell();
	private static final ModelJadeSpur SPUR_MODEL = new ModelJadeSpur();
	private static final ModelJadeRack RACK_MODEL = new ModelJadeRack();
	private static final ModelJadeWorm WORM_MODEL = new ModelJadeWorm();
	public RenderJade(RenderManager manager) {
		super(manager, RenderJade.BELL_MODEL, 0.5F);
		this.addLayer(new LayerSkin(this));
		this.addLayer(new LayerUniform(this));
		this.addLayer(new LayerInsignia(this));
		this.addLayer(new LayerHair(this));
		this.addLayer(new LayerVisor(this));
		this.addLayer(new LayerNoDyeOverlay(this));
		this.addLayer(new LayerJacket(this));
		this.addLayer(new LayerGemstone(this));
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerFlower(this));
	}
	@Override
	public void preRenderCallback(T gem, float partialTickTime) {
		super.preRenderCallback(gem, partialTickTime);
		switch (gem.getJadeShape()) {
		case "ke2:jade.shape.bell":
			this.mainModel = RenderJade.BELL_MODEL;
			break;
		case "ke2:jade.shape.spur":
			this.mainModel = RenderJade.SPUR_MODEL;
			break;
		case "ke2:jade.shape.rack":
			this.mainModel = RenderJade.RACK_MODEL;
			break;
		case "ke2:jade.shape.worm":
			this.mainModel = RenderJade.WORM_MODEL;
			break;
		}
	}
}
