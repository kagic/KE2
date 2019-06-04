package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSnowflakeObsidian extends ModelGem {
    public ModelRenderer bipedChest;
	public ModelSnowflakeObsidian() {
		super(0.0F, 0.0F, 128, 64);
        this.bipedHead = new ModelRenderer(this, 38, 0);
        this.bipedHead.addBox(-8.0F, -14.0F, -5.0F, 16, 16, 10, 0.0F);
        this.bipedHead.offsetY = -1.375F;
        this.bipedBody = new ModelRenderer(this, 0, 0);
        this.bipedBody.addBox(-6.0F, -4.0F, -4.0F, 12, 8, 8, 0.0F);
        this.bipedChest = new ModelRenderer(this, 0, 0);
        this.bipedChest.addBox(-8.0F, -20.0F, -6.0F, 16, 16, 12, 0.0F);
        this.bipedBody.addChild(this.bipedChest);
        this.bipedRightArm = new ModelRenderer(this, 0, 23);
        this.bipedRightArm.addBox(-8.0F, 0.0F, -2.5F, 5, 24, 5, 0.0F);
        this.bipedRightArm.offsetY = -1.25F;
        this.bipedChest.addChild(this.bipedRightArm);
		this.bipedLeftArm = new ModelRenderer(this, 83, 20);
        this.bipedLeftArm.addBox(3.0F, 0.0F, -2.5F, 5, 24, 5, 0.0F);
        this.bipedLeftArm.offsetY = -1.25F;
        this.bipedChest.addChild(this.bipedLeftArm);
        this.bipedLeftLeg = new ModelRenderer(this, 88, 0);
        this.bipedLeftLeg.addBox(-6.0F, 0.0F, -2.5F, 5, 20, 5, 0.0F);
        this.bipedLeftLeg.offsetY = -0.5F;
        this.bipedBody.addChild(this.bipedLeftLeg);
        this.bipedRightLeg = new ModelRenderer(this, 103, 14);
        this.bipedRightLeg.addBox(1.0F, 0.0F, -2.5F, 5, 20, 5, 0.0F);
        this.bipedRightLeg.offsetY = -0.5F;
        this.bipedBody.addChild(this.bipedRightLeg);
	}
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netbipedHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netbipedHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedBody.render(scale);
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netbipedHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netbipedHeadYaw, headPitch, scaleFactor, entity);
	}
}
