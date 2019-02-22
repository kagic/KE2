package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityJasper;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderJasper<T extends EntityJasper> extends RenderGem<T> {
	public RenderJasper(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
