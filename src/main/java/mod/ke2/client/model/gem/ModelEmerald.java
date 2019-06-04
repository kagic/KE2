package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEmerald extends ModelGem {
	public ModelRenderer bipedLeftShoulder;
	public ModelRenderer bipedRightShoulder;
	public ModelRenderer bipedHair;
	public ModelRenderer bipedHips;
    public ModelEmerald() {
		super(0.0F, 0.0F, 64, 64);
        this.bipedHead = new ModelRenderer(this, 28, 14);
        this.bipedHead.addBox(-4.0F, -6.0F, -4.7F, 8, 8, 8, 0.0F);
        this.bipedHead.offsetY = -0.25F;
        this.bipedHeadwear = new ModelRenderer(this, 0, 50);
        this.bipedHeadwear.addBox(-5.0F, -6.0F, -6.0F, 10, 4, 2, 0.0F);
        this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedHair = new ModelRenderer(this, 24, 44);
        this.bipedHair.addBox(-10.0F, -10.0F, -4.8F, 12, 12, 8, 0.0F);
        this.bipedHead.addChild(this.bipedHair);
        this.bipedBody = new ModelRenderer(this, 24, 0);
        this.bipedBody.addBox(-7.4F, -7.4F, -3.5F, 7, 7, 7, 0.0F);
        this.bipedRightShoulder = new ModelRenderer(this, 0, 22);
        this.bipedRightShoulder.setRotationPoint(3.0F, -4.5F, 0.0F);
        this.bipedRightShoulder.addBox(0.0F, -3.0F, -2.0F, 6, 4, 4, 0.0F);
        this.bipedLeftShoulder = new ModelRenderer(this, 0, 22);
        this.bipedLeftShoulder.setRotationPoint(-3.0F, -4.5F, 0.0F);
        this.bipedLeftShoulder.addBox(0.0F, -1.0F, -2.0F, 6, 4, 4, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 0, 30);
        this.bipedRightArm.addBox(0.0F, -1.0F, -1.5F, 3, 16, 3, 0.0F);
        this.bipedRightShoulder.addChild(this.bipedRightArm);
        this.bipedLeftArm = new ModelRenderer(this, 0, 30);
        this.bipedLeftArm.addBox(-3.0F, -1.0F, -1.5F, 3, 16, 3, 0.0F);
        this.bipedLeftShoulder.addChild(this.bipedLeftArm);
        this.bipedHips = new ModelRenderer(this, 0, 12);
        this.bipedHips.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.bipedHips.addBox(-4.0F, -9.0F, -3.0F, 8, 14, 6, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 12, 30);
        this.bipedRightLeg.setRotationPoint(1.0F, 4.0F, 0.0F);
        this.bipedRightLeg.addBox(-1.0F, 1.0F, -2.0F, 4, 16, 4, 0.0F);
        this.bipedHips.addChild(this.bipedRightLeg);
        this.bipedLeftLeg = new ModelRenderer(this, 12, 30);
        this.bipedLeftLeg.setRotationPoint(-1.0F, 4.0F, 0.0F);
        this.bipedLeftLeg.addBox(-3.0F, 1.0F, -2.0F, 4, 16, 4, 0.0F);
        this.bipedHips.addChild(this.bipedLeftLeg);
    }
    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.bipedHead.render(scale);
        this.bipedRightShoulder.render(scale);
        this.bipedLeftShoulder.render(scale);
        this.bipedBody.render(scale);
        this.bipedHips.render(scale);
    }
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
		this.bipedHair.rotateAngleX = 0.0F;
		this.bipedHair.rotateAngleY = 0.0F;
    	this.bipedBody.rotateAngleZ = 0.7853981633974483F;
    	this.bipedRightShoulder.rotateAngleZ = -0.5235987755982988F;
    	this.bipedRightArm.rotateAngleZ = 0.5235987755982988F;
    	this.bipedRightArm.rotationPointX = 1F;
    	this.bipedLeftShoulder.rotateAngleZ = -2.6179938779914944F;
    	this.bipedLeftArm.rotateAngleZ = 2.6179938779914944F;
    	this.bipedLeftArm.rotationPointX = 1F;
        this.bipedHair.rotateAngleX = -0.2617993877991494F;
    	this.bipedHair.rotateAngleY =  0.2617993877991494F;
    	this.bipedHair.rotateAngleZ =  0.7853981633974483F;
    	this.bipedRightLeg.rotationPointY = 8.0F;
    	this.bipedRightLeg.offsetY = -0.25F;
    	this.bipedLeftLeg.rotationPointY = 8.0F;
    	this.bipedLeftLeg.offsetY = -0.25F;
    	this.bipedHead.rotationPointY = -6.0F;
    }
}