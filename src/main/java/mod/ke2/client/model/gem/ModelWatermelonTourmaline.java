package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWatermelonTourmaline extends ModelGem {
    public ModelWatermelonTourmaline() {
    	super(0.0F, 0.0F, 96, 80);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -12.0F, -4.0F, 8, 8, 8);
		this.bipedHead.offsetY = -1.0F;
		this.bipedBody = new ModelRenderer(this, 24, 22);
		this.bipedBody.addBox(-6.0F, -16.0F, -4.0F, 12, 20, 8);
		this.bipedRightArm = new ModelRenderer(this, 64, 22);
		this.bipedRightArm.addBox(-7.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedRightArm.offsetY = -1.0F;
		this.bipedLeftArm = new ModelRenderer(this, 64, 48);
		this.bipedLeftArm.addBox(1.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedLeftArm.offsetY = -1.0F;
		this.bipedRightLeg = new ModelRenderer(this, 0, 22);
		this.bipedRightLeg.addBox(-6.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedRightLeg.offsetY = -0.5F;
		this.bipedLeftLeg = new ModelRenderer(this, 0, 48);
		this.bipedLeftLeg.addBox(0.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedLeftLeg.offsetY = -0.5F;
    }
    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
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