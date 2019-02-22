package mod.kagic.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTourmaline extends ModelGem {
    public ModelTourmaline() {
    	super(0.0F, 0.0F, 128, 64, 4);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.bipedHead.addBox(-4.0F, -1.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.bipedHeadwear.addBox(-4.5F, -1.1F, -4.5F, 9, 9, 9, 0.0F);
        this.bipedBody = new ModelRenderer(this, 0, 16);
        this.bipedBody.setRotationPoint(-3.0F, 7.0F, 0.0F);
        this.bipedBody.addBox(0.0F, 0.0F, -2.0F, 6, 9, 4, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 20, 29);
        this.bipedLeftArm.setRotationPoint(-2.0F, 7.0F, 0.0F);
        this.bipedLeftArm.addBox(-2.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 28, 29);
        this.bipedRightArm.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.bipedRightArm.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 8, 29);
        this.bipedLeftLeg.setRotationPoint(1.5F, 16.0F, 0.0F);
        this.bipedLeftLeg.addBox(-1.0F, 4.0F, -1.0F, 2, 8, 2, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 0, 29);
        this.bipedRightLeg.setRotationPoint(-1.5F, 16.0F, 0.0F);
        this.bipedRightLeg.addBox(-1.0F, 4.0F, -1.0F, 2, 8, 2, 0.0F); 
    }
    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.bipedHead.render(scale);
		this.bipedHeadwear.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedLeftLeg.render(scale);
		this.bipedRightLeg.render(scale);
	}
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
	}
}