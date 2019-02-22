package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityHessonite;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderHessonite<T extends EntityHessonite> extends RenderGem<T> {
	public RenderHessonite(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
