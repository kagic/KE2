package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntityEnderPearl;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderEnderPearl<T extends EntityEnderPearl> extends RenderGem<T> {
	public RenderEnderPearl(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
