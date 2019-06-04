package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelQuartz extends ModelGem {
	public ModelRenderer bipedHairFloof;
	public ModelRenderer bipedTopBun;
	public ModelRenderer bipedSideBuns;
	public ModelRenderer bipedBackBun;
	public ModelQuartz() {
		super(0.0F, 0.0F, 144, 80);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-5.0F, -12.0F, -5.0F, 10, 12, 10);
		this.bipedHead.offsetY = -1.0F;
		this.bipedHeadwear = new ModelRenderer(this, 90, 0);
		this.bipedHeadwear.addBox(-5.0F, -12.0F, -5.0F, 10, 28, 10, 1.1F);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedHairFloof = new ModelRenderer(this, 63, 9);
		this.bipedHairFloof.addBox(-6.0F, -12.0F, -6.0F, 12, 12, 1, 1.1F);
		this.bipedHead.addChild(this.bipedHairFloof);
		this.bipedSideBuns = new ModelRenderer(this, 88, 40);
		this.bipedSideBuns.addBox(-9.0F, -6.0F, -2.0F, 18, 4, 4);
		this.bipedHead.addChild(this.bipedSideBuns);
		this.bipedTopBun = new ModelRenderer(this, 88, 48);
		this.bipedTopBun.addBox(-2.0F, -12.0F, -2.0F, 4, 4, 4);
		this.bipedHead.addChild(this.bipedTopBun);
		this.bipedBackBun = new ModelRenderer(this, 104, 48);
		this.bipedBackBun.addBox(-2.0F, -6.0F, 4.0F, 4, 4, 4);
		this.bipedHead.addChild(this.bipedBackBun);
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
		this.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
	}
}
