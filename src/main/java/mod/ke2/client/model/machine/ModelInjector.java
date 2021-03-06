package mod.ke2.client.model.machine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelInjector extends ModelBase {
	public ModelRenderer incubator;
	public ModelRenderer incubatorCap;
	public ModelRenderer neck;
	public ModelRenderer bottomSlab;
	public ModelRenderer topSlab;
	public ModelRenderer girdle;
	public ModelRenderer body;
	public ModelRenderer drillBitTop;
	public ModelRenderer drillBitMiddle;
	public ModelRenderer drillBitBottom;
	public ModelRenderer miniDrills;
	public ModelRenderer frontLeftFoot;
	public ModelRenderer frontRightFoot;
	public ModelRenderer backLeftFoot;
	public ModelRenderer backRightFoot;
	public ModelRenderer frontLeftLeg;
	public ModelRenderer frontRightLeg;
	public ModelRenderer backLeftLeg;
	public ModelRenderer backRightLeg;

	public ModelInjector() {
		this.textureWidth = 96;
		this.textureHeight = 96;
		this.frontLeftFoot = new ModelRenderer(this, 0, 68);
		this.frontLeftFoot.setRotationPoint(0.0F, -13.0F, 2.0F);
		this.frontLeftFoot.addBox(-1.5F, 0.0F, 0.0F, 3, 20, 2, 0.0F);
		this.frontLeftFoot.rotateAngleX = -0.8726646259971648F;
		this.frontRightFoot = new ModelRenderer(this, 0, 68);
		this.frontRightFoot.setRotationPoint(0.0F, -13.0F, 2.0F);
		this.frontRightFoot.addBox(-1.5F, 0.0F, 0.0F, 3, 20, 2, 0.0F);
		this.frontRightFoot.rotateAngleX = -0.8726646259971648F;
		this.backLeftFoot = new ModelRenderer(this, 0, 68);
		this.backLeftFoot.setRotationPoint(0.0F, -13.0F, 2.0F);
		this.backLeftFoot.addBox(-1.5F, 0.0F, 0.0F, 3, 20, 2, 0.0F);
		this.backLeftFoot.rotateAngleX = -0.8726646259971648F;
		this.backRightFoot = new ModelRenderer(this, 0, 68);
		this.backRightFoot.setRotationPoint(0.0F, -13.0F, 2.0F);
		this.backRightFoot.addBox(-1.5F, 0.0F, 0.0F, 3, 20, 2, 0.0F);
		this.backRightFoot.rotateAngleX = -0.8726646259971648F;
		this.frontLeftLeg = new ModelRenderer(this, 0, 42);
		this.frontLeftLeg.setRotationPoint(0.0F, 0.0F, -9.0F);
		this.frontLeftLeg.addBox(-1.0F, -10.0F, -1.0F, 2, 10, 2, 0.0F);
		this.frontLeftLeg.rotateAngleX = 0.7853981633974483F;
		this.frontRightLeg = new ModelRenderer(this, 0, 42);
		this.frontRightLeg.setRotationPoint(0.0F, 0.0F, 9.0F);
		this.frontRightLeg.addBox(-1.0F, -10.0F, -1.0F, 2, 10, 2, 0.0F);
		this.frontRightLeg.rotateAngleX = 0.7853981633974483F;
		this.frontRightLeg.rotateAngleY = 3.141592653589793F;
		this.backLeftLeg = new ModelRenderer(this, 0, 42);
		this.backLeftLeg.setRotationPoint(-9.0F, 0.0F, 0.0F);
		this.backLeftLeg.addBox(-1.0F, -10.0F, -1.0F, 2, 10, 2, 0.0F);
		this.backLeftLeg.rotateAngleX = 0.7853981633974483F;
		this.backLeftLeg.rotateAngleY = 1.5707963267948966F;
		this.backRightLeg = new ModelRenderer(this, 0, 42);
		this.backRightLeg.setRotationPoint(9.0F, 0.0F, 0.0F);
		this.backRightLeg.addBox(-1.0F, -10.0F, -1.0F, 2, 10, 2, 0.0F);
		this.backRightLeg.rotateAngleX = 0.7853981633974483F;
		this.backRightLeg.rotateAngleY = -1.5707963267948966F;
		this.neck = new ModelRenderer(this, 0, 32);
		this.neck.setRotationPoint(0.0F, -35.0F, 0.0F);
		this.neck.addBox(-3.5F, -3.0F, -3.5F, 7, 3, 7, 0.0F);
		this.neck.rotateAngleY = 0.7853981633974483F;
		this.incubator = new ModelRenderer(this, 0, 42);
		this.incubator.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.incubator.addBox(-6.0F, -14.0F, -6.0F, 12, 14, 12, 0.0F);
		this.incubatorCap = new ModelRenderer(this, 38, 58);
		this.incubatorCap.setRotationPoint(0.0F, -14.0F, 0.0F);
		this.incubatorCap.addBox(-5.0F, -5.0F, -5.0F, 10, 5, 10, 0.0F);
		this.bottomSlab = new ModelRenderer(this, 0, 0);
		this.bottomSlab.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.bottomSlab.addBox(-8.0F, 0.0F, -8.0F, 16, 3, 16, 0.0F);
		this.topSlab = new ModelRenderer(this, 48, 0);
		this.topSlab.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.topSlab.addBox(-5.0F, 0.0F, -5.0F, 10, 3, 10, 0.0F);
		this.drillBitTop = new ModelRenderer(this, 0, 19);
		this.drillBitTop.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.drillBitTop.addBox(-3.0F, 0.0F, -3.0F, 6, 3, 6, 0.0F);
		this.drillBitTop.rotateAngleY = 0.7853981633974483F;
		this.drillBitMiddle = new ModelRenderer(this, 78, 0);
		this.drillBitMiddle.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.drillBitMiddle.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
		this.drillBitBottom = new ModelRenderer(this, 48, 0);
		this.drillBitBottom.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.drillBitBottom.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
		this.miniDrills = new ModelRenderer(this, 15, 19);
		this.miniDrills.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.miniDrills.addBox(-4.5F, 0.0F, -4.5F, 9, 4, 9, 0.0F);
		this.body = new ModelRenderer(this, 54, 13);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-5.0F, -35.0F, -5.0F, 10, 35, 10, 0.0F);
		this.girdle = new ModelRenderer(this, 0, 0);
		this.girdle.setRotationPoint(0.0F, 10.6F, 0.0F);
		this.girdle.addBox(-2.0F, 0.0F, -2.0F, 4, 0, 4, 0.0F);
		this.girdle.rotateAngleY = 0.7853981633974483F;
		this.frontLeftLeg.addChild(this.frontLeftFoot);
		this.frontRightLeg.addChild(this.frontRightFoot);
		this.backLeftLeg.addChild(this.backRightFoot);
		this.backRightLeg.addChild(this.backRightFoot);
		this.girdle.addChild(this.frontLeftLeg);
		this.girdle.addChild(this.frontRightLeg);
		this.girdle.addChild(this.backLeftLeg);
		this.girdle.addChild(this.backRightLeg);
		this.topSlab.addChild(this.drillBitTop);
		this.topSlab.addChild(this.miniDrills);
		this.drillBitTop.addChild(this.drillBitMiddle);
		this.drillBitMiddle.addChild(this.drillBitBottom);
		this.incubator.addChild(this.incubatorCap);
		this.neck.addChild(this.incubator);
		this.bottomSlab.addChild(this.topSlab);
		this.bottomSlab.addChild(this.body);
		this.body.addChild(this.neck);
	}

	public void resetRotationAngles() {
		this.frontLeftLeg.rotateAngleX = 0.7853981633974483F;
		this.frontLeftLeg.rotateAngleY = 0;
		this.frontLeftLeg.rotateAngleZ = 0;
		this.frontRightLeg.rotateAngleX = 0.7853981633974483F;
		this.frontRightLeg.rotateAngleY = 3.141592653589793F;
		this.frontRightLeg.rotateAngleZ = 0;
		this.backLeftLeg.rotateAngleX = 0.7853981633974483F;
		this.backLeftLeg.rotateAngleY = 1.5707963267948966F;
		this.backLeftLeg.rotateAngleZ = 0;
		this.backRightLeg.rotateAngleX = 0.7853981633974483F;
		this.backRightLeg.rotateAngleY = -1.5707963267948966F;
		this.backRightLeg.rotateAngleZ = 0;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		this.resetRotationAngles();
		this.frontLeftLeg.rotateAngleY += Math.abs(MathHelper.sin(limbSwing * 0.6662F + 3.14F) * 0.8F) * limbSwingAmount;
		this.frontRightLeg.rotateAngleY += -Math.abs(MathHelper.sin(limbSwing * 0.6662F + 3.14F) * 0.8F) * limbSwingAmount;
		this.backLeftLeg.rotateAngleY += -Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.8F) * limbSwingAmount;
		this.backRightLeg.rotateAngleY += Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.8F) * limbSwingAmount;
		this.frontLeftLeg.rotateAngleZ += MathHelper.cos(limbSwing * 0.6662F * 2.0F + 3.14F) * 0.8F * limbSwingAmount;
		this.frontRightLeg.rotateAngleZ += -MathHelper.cos(limbSwing * 0.6662F * 2.0F + 3.14F) * 0.8F * limbSwingAmount;
		this.backLeftLeg.rotateAngleZ += MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.8F * limbSwingAmount;
		this.backRightLeg.rotateAngleZ += -MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.8F * limbSwingAmount;
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headYaw, float scale) {
		this.bottomSlab.render(scale);
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.girdle.offsetX, this.girdle.offsetY, this.girdle.offsetZ);
		GlStateManager.translate(this.girdle.rotationPointX * scale, this.girdle.rotationPointY * scale, this.girdle.rotationPointZ * scale);
		GlStateManager.scale(1.0D, 1.5D, 1.0D);
		GlStateManager.translate(-this.girdle.offsetX, -this.girdle.offsetY, -this.girdle.offsetZ);
		GlStateManager.translate(-this.girdle.rotationPointX * scale, -this.girdle.rotationPointY * scale, -this.girdle.rotationPointZ * scale);
		this.girdle.render(scale);
		GlStateManager.popMatrix();
	}
}