package mod.kagic.client.render.gem;

import mod.kagic.client.model.ModelGem;
import mod.kagic.client.render.RenderGem;
import mod.kagic.entity.gem.EntitySnowflakeObsidian;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSnowflakeObsidian<T extends EntitySnowflakeObsidian> extends RenderGem<T> {
	public RenderSnowflakeObsidian(RenderManager manager, ModelGem model, float shadowSize) {
		super(manager, model, shadowSize);
	}
}
