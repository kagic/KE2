package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityMotherOfPearl;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMotherOfPearl<T extends EntityMotherOfPearl> extends RenderGem<T> {
	public RenderMotherOfPearl(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
