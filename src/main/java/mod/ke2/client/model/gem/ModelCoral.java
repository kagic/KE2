package mod.ke2.client.model.gem;

import org.lwjgl.opengl.GL11;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelCoral extends ModelGem {
    public ModelRenderer bipedHair;
    public ModelRenderer bipedTorso;
    public ModelRenderer bipedNeck;
	public ModelCoral() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHeadwear = new ModelRenderer(this, 0, 0);
        this.bipedHeadwear.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedHeadwear.offsetY = -0.125F;
        this.bipedHair = new ModelRenderer(this, 32, 0);
        this.bipedHair.addBox(-3.0F, -5.0F, 2.0F, 6, 7, 6, 0.0F);
        this.bipedHeadwear.addChild(this.bipedHair);
        this.bipedLeftArm = new ModelRenderer(this, 0, 16);
        this.bipedLeftArm.addBox(-2.0F, 2.0F, -1.0F, 2, 12, 2, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 0, 30);
        this.bipedRightArm.addBox(0.0F, 2.0F, -1.0F, 2, 12, 2, 0.0F);
        this.bipedBody = new ModelRenderer(this, 8, 16);
        this.bipedBody.addBox(-3.0F, 2.0F, -2.0F, 6, 10, 4, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 28, 16);
        this.bipedLeftLeg.addBox(-3.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 28, 30);
        this.bipedRightLeg.addBox(1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.bipedHead = new ModelRenderer(this, 32, 0);
        this.bipedHead.setRotationPoint(0.0F, 3.3F, 0.0F);
        this.bipedHead.addBox(-3.0F, -5.0F, -3.0F, 6, 6, 6, 0.0F);
        this.bipedTorso = new ModelRenderer(this, 36, 16);
        this.bipedTorso.setRotationPoint(0.0F, 13.5F, 0.0F);
        this.bipedTorso.addBox(-2.0F, -10.5F, -1.0F, 4, 8, 2, 0.0F);
        this.bipedNeck = new ModelRenderer(this, 41, 13);
        this.bipedNeck.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.bipedNeck.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
	}
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.bipedHead.render(scale);
        this.bipedNeck.render(scale);
        this.bipedTorso.render(scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.25F);
		this.bipedHeadwear.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
        GlStateManager.disableBlend();
	}
	public void renderSpecially(ModelRenderer part, float scale) {
		GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
        part.render(scale);
        GlStateManager.disableBlend();
	}
}