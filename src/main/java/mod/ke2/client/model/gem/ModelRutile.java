package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRutile extends ModelGem {
	public ModelRutile() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedHead.offsetY = -0.37F;
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -5.0F, 8, 4, 9, 0.1F);
        this.bipedHead.addChild(this.bipedHeadwear);
        this.bipedLeftArm = new ModelRenderer(this, 0, 16);
        this.bipedLeftArm.addBox(-2.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 0, 30);
        this.bipedRightArm.addBox(0.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
        this.bipedBody = new ModelRenderer(this, 8, 16);
        this.bipedBody.addBox(-3.0F, -2.0F, -2.0F, 6, 12, 4, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 28, 16);
        this.bipedLeftLeg.addBox(-3.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 28, 30);
        this.bipedRightLeg.addBox(1.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
	}
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedBody.render(scale);
		this.bipedLeftLeg.render(scale);
		this.bipedRightLeg.render(scale);
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
	}
}
