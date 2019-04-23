package mod.ke2.client.render;

import mod.ke2.client.model.ModelNothing;
import mod.ke2.entity.EntityGemBurst;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGemBurst extends RenderLiving<EntityGemBurst> {
    public RenderGemBurst(RenderManager manager) {
        super(manager, new ModelNothing(), 0.25F);
    }
    @Override
	protected ResourceLocation getEntityTexture(EntityGemBurst entity) {
        return new ResourceLocation("ke2:textures/entities/none/null.png");
    }
}