package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHessonite extends ModelGem {
	public ModelRenderer bipedShoulderPads;
    public ModelHessonite() {
		super(0.0F, 0.0F, 64, 64);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-6.0F, -12.0F, -4.0F, 12, 12, 8, 0.0F);
        this.bipedHead.offsetY = -0.625F;
        this.bipedRightArm = new ModelRenderer(this, 0, 20);
        this.bipedRightArm.addBox(-2.0F, 2.0F, -1.5F, 3, 16, 3, 0.0F);
        this.bipedRightArm.offsetY = -0.5F;
        this.bipedLeftArm = new ModelRenderer(this, 0, 20);
        this.bipedLeftArm.addBox(-1.0F, 2.0F, -1.5F, 3, 16, 3, 0.0F);
        this.bipedLeftArm.offsetY = -0.5F;
        this.bipedBody = new ModelRenderer(this, 12, 20);
        this.bipedBody.addBox(-4.0F, -6.0F, -3.0F, 8, 14, 6, 0.0F);
        this.bipedShoulderPads = new ModelRenderer(this, 0, 38);
        this.bipedShoulderPads.addBox(-8.0F, -10.0F, -3.0F, 16, 4, 6);
        this.bipedBody.addChild(this.bipedShoulderPads);
        this.bipedCape = new ModelRenderer(this, 0, 38);
        this.bipedCape.addBox(-8.0F, -6.0F, 2.0F, 16, 22, 1, 0.0F);
        this.bipedBody.addChild(this.bipedCape);
        this.bipedRightLeg = new ModelRenderer(this, 40, 0);
        this.bipedRightLeg.addBox(-4.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
        this.bipedRightLeg.offsetY = -0.25F;
        this.bipedLeftLeg = new ModelRenderer(this, 40, 0);
        this.bipedLeftLeg.addBox(0.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
        this.bipedLeftLeg.offsetY = -0.25F;
    }
    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    	this.bipedHead.render(scale);
    	this.bipedRightArm.render(scale);
    	this.bipedLeftArm.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
    }
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
	}
}