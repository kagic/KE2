package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityAquamarine;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderAquamarine<T extends EntityAquamarine> extends RenderGem<T> {
	public RenderAquamarine(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
