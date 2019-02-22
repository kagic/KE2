package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityBismuth;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderBismuth<T extends EntityBismuth> extends RenderGem<T> {
	public RenderBismuth(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
