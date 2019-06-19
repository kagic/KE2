package mod.ke2.client.model.vehicle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelPalanquin extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer base;
	public ModelRenderer cage;
	public ModelRenderer veil;
	public ModelRenderer seat;
	public ModelRenderer armLeft;
	public ModelRenderer armRight;
	public ModelRenderer tip;
	public ModelRenderer top;
	public ModelRenderer capTop;
	public ModelRenderer capBottom;
	public ModelRenderer backTop;
	public ModelRenderer backMiddle;
	public ModelRenderer backBottom;
	public ModelRenderer topFrontLeftLeg;
	public ModelRenderer topFrontRightLeg;
	public ModelRenderer topBackLeftLeg;
	public ModelRenderer topBackRightLeg;
	public ModelRenderer bottomFrontLeftLeg;
	public ModelRenderer bottomFrontRightLeg;
	public ModelRenderer bottomBackLeftLeg;
	public ModelRenderer bottomBackRightLeg;
	
	public ModelPalanquin() {
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.veil = new ModelRenderer(this, 74, 24);
		this.veil.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.veil.addBox(-11.0F, -36.0F, -11.0F, 22, 36, 22, 0.0F);
		this.cage = new ModelRenderer(this, 164, 18);
		this.cage.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.cage.addBox(-10.0F, -36.0F, -10.0F, 20, 36, 20, 0.0F);
		this.seat = new ModelRenderer(this, 184, 0);
		this.seat.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.seat.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
		this.armLeft = new ModelRenderer(this, 224, 0);
		this.armLeft.mirror = true;
		this.armLeft.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.armLeft.addBox(0.0F, -14.0F, -5.0F, 1, 14, 9, 0.0F);
		this.armRight = new ModelRenderer(this, 224, 0);
		this.armRight.setRotationPoint(-4.0F, 0.0F, 0.0F);
		this.armRight.addBox(-1.0F, -14.0F, -5.0F, 1, 14, 9, 0.0F);
		this.tip = new ModelRenderer(this, 0, 59);
		this.tip.setRotationPoint(0.0F, -38.0F, 0.0F);
		this.tip.addBox(-11.5F, 0.0F, -11.5F, 23, 2, 23, 0.0F);
		this.top = new ModelRenderer(this, 140, 24);
		this.top.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.top.addBox(-5.0F, -3.0F, -5.0F, 10, 3, 10, 0.0F);
		this.topFrontLeftLeg = new ModelRenderer(this, 30, 26);
		this.topFrontLeftLeg.setRotationPoint(12.0F, 0.0F, -12.0F);
		this.topFrontLeftLeg.addBox(-1.5F, -20.0F, -1.5F, 3, 20, 3, 0.0F);
		this.topFrontLeftLeg.rotateAngleX = 0.5235987755982988F;
		this.topFrontLeftLeg.rotateAngleZ = 0.5235987755982988F;
		this.topFrontRightLeg = new ModelRenderer(this, 30, 26);
		this.topFrontRightLeg.setRotationPoint(12.0F, 0.0F, 12.0F);
		this.topFrontRightLeg.addBox(-1.5F, -20.0F, -1.5F, 3, 20, 3, 0.0F);
		this.topFrontRightLeg.rotateAngleX = -0.5235987755982988F;
		this.topFrontRightLeg.rotateAngleZ = 0.5235987755982988F;
		this.topBackLeftLeg = new ModelRenderer(this, 30, 26);
		this.topBackLeftLeg.setRotationPoint(-12.0F, 0.0F, 12.0F);
		this.topBackLeftLeg.addBox(-1.5F, -20.0F, -1.5F, 3, 20, 3, 0.0F);
		this.topBackLeftLeg.rotateAngleX = -0.5235987755982988F;
		this.topBackLeftLeg.rotateAngleZ = -0.5235987755982988F;
		this.topBackRightLeg = new ModelRenderer(this, 30, 26);
		this.topBackRightLeg.setRotationPoint(-12.0F, 0.0F, -12.0F);
		this.topBackRightLeg.addBox(-1.5F, -20.0F, -1.5F, 3, 20, 3, 0.0F);
		this.topBackRightLeg.rotateAngleX = 0.5235987755982988F;
		this.topBackRightLeg.rotateAngleZ = -0.5235987755982988F;
		this.bottomFrontLeftLeg = new ModelRenderer(this, 22, 26);
		this.bottomFrontLeftLeg.setRotationPoint(0.0F, -21.0F, 0.0F);
		this.bottomFrontLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 20, 2, 0.0F);
		this.bottomFrontLeftLeg.rotateAngleX = -0.5235987755982988F;
		this.bottomFrontLeftLeg.rotateAngleZ = -0.5235987755982988F;
		this.bottomFrontRightLeg = new ModelRenderer(this, 22, 26);
		this.bottomFrontRightLeg.setRotationPoint(0.0F, -21.0F, 0.0F);
		this.bottomFrontRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 20, 2, 0.0F);
		this.bottomFrontRightLeg.rotateAngleX = 0.5235987755982988F;
		this.bottomFrontRightLeg.rotateAngleZ = -0.5235987755982988F;
		this.bottomBackLeftLeg = new ModelRenderer(this, 22, 26);
		this.bottomBackLeftLeg.setRotationPoint(0.0F, -21.0F, 0.0F);
		this.bottomBackLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 20, 2, 0.0F);
		this.bottomBackLeftLeg.rotateAngleX = 0.5235987755982988F;
		this.bottomBackLeftLeg.rotateAngleZ = 0.5235987755982988F;
		this.bottomBackRightLeg = new ModelRenderer(this, 22, 26);
		this.bottomBackRightLeg.setRotationPoint(0.0F, -21.0F, 0.0F);
		this.bottomBackRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 20, 2, 0.0F);
		this.bottomBackRightLeg.rotateAngleX = -0.5235987755982988F;
		this.bottomBackRightLeg.rotateAngleZ = 0.5235987755982988F;
		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.body.addBox(-12.0F, 0.0F, -12.0F, 24, 2, 24, 0.0F);
		this.body.rotateAngleY = 0.017453292519943295F;
		this.capTop = new ModelRenderer(this, 0, 0);
		this.capTop.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.capTop.addBox(-4.0F, -6.0F, 0.0F, 8, 6, 0, 0.0F);
		this.capTop.rotateAngleY = 0.7853981633974483F;
		this.capBottom = new ModelRenderer(this, 0, 0);
		this.capBottom.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.capBottom.addBox(-4.0F, -6.0F, 0.0F, 8, 6, 0, 0.0F);
		this.capBottom.rotateAngleY = -0.7853981633974483F;
		this.backTop = new ModelRenderer(this, 0, 26);
		this.backTop.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.backTop.addBox(-5.0F, -24.0F, 1.0F, 10, 24, 1, 0.0F);
		this.backMiddle = new ModelRenderer(this, 72, 0);
		this.backMiddle.setRotationPoint(0.0F, -19.1F, 0.8F);
		this.backMiddle.addBox(0.0F, -9.0F, 0.0F, 9, 9, 1, 0.0F);
		this.backMiddle.rotateAngleZ = -0.7853981633974483F;
		this.backBottom = new ModelRenderer(this, 138, 0);
		this.backBottom.setRotationPoint(4.0F, -4.0F, -0.2F);
		this.backBottom.addBox(0.0F, -6.0F, 0.0F, 6, 6, 1, 0.0F);
		this.base = new ModelRenderer(this, 72, 0);
		this.base.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.base.addBox(-11.0F, 0.0F, -11.0F, 22, 2, 22, 0.0F);
		this.base.addChild(this.veil);
		this.tip.addChild(this.top);
		this.seat.addChild(this.armRight);
		this.topBackRightLeg.addChild(this.bottomBackRightLeg);
		this.base.addChild(this.cage);
		this.seat.addChild(this.armLeft);
		this.topBackLeftLeg.addChild(this.bottomBackLeftLeg);
		this.backMiddle.addChild(this.backBottom);
		this.top.addChild(this.capTop);
		this.seat.addChild(this.backTop);
		this.body.addChild(this.topFrontRightLeg);
		this.body.addChild(this.base);
		this.topFrontRightLeg.addChild(this.bottomFrontRightLeg);
		this.body.addChild(this.topBackLeftLeg);
		this.base.addChild(this.seat);
		this.backTop.addChild(this.backMiddle);
		this.top.addChild(this.capBottom);
		this.body.addChild(this.topFrontLeftLeg);
		this.topFrontLeftLeg.addChild(this.bottomFrontLeftLeg);
		this.body.addChild(this.topBackRightLeg);
		this.cage.addChild(this.tip);
	}
	
	public void resetRotationAngles() {
		this.topFrontLeftLeg.rotateAngleX = 0.5235987755982988F;
		this.topFrontLeftLeg.rotateAngleY = 0.0F;
		this.topFrontLeftLeg.rotateAngleZ = 0.5235987755982988F;
		this.topFrontRightLeg.rotateAngleX = -0.5235987755982988F;
		this.topFrontRightLeg.rotateAngleY = 0.0F;
		this.topFrontRightLeg.rotateAngleZ = 0.5235987755982988F;
		this.topBackLeftLeg.rotateAngleX = -0.5235987755982988F;
		this.topBackLeftLeg.rotateAngleY = 0.0F;
		this.topBackLeftLeg.rotateAngleZ = -0.5235987755982988F;
		this.topBackRightLeg.rotateAngleX = 0.5235987755982988F;
		this.topBackRightLeg.rotateAngleY = 0.0F;
		this.topBackRightLeg.rotateAngleZ = -0.5235987755982988F;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		this.resetRotationAngles();
		if (entity.onGround) {
			this.topFrontLeftLeg.rotateAngleY += Math.abs(MathHelper.sin(limbSwing * 0.6662F + 3.14F) * 0.4F) * limbSwingAmount;
			this.topFrontRightLeg.rotateAngleY += -Math.abs(MathHelper.sin(limbSwing * 0.6662F + 3.14F) * 0.4F) * limbSwingAmount;
			this.topBackLeftLeg.rotateAngleY += -Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
			this.topBackRightLeg.rotateAngleY += Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
			this.topFrontLeftLeg.rotateAngleZ += MathHelper.cos(limbSwing * 0.6662F * 2.0F + 3.14F) * 0.4F * limbSwingAmount;
			this.topFrontRightLeg.rotateAngleZ += -MathHelper.cos(limbSwing * 0.6662F * 2.0F + 3.14F) * 0.4F * limbSwingAmount;
			this.topBackLeftLeg.rotateAngleZ += MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F * limbSwingAmount;
			this.topBackRightLeg.rotateAngleZ += -MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F * limbSwingAmount;
		}
	}
	
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headYaw, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
		GlStateManager.translate(this.body.rotationPointX * scale, this.body.rotationPointY * scale, this.body.rotationPointZ * scale);
		GlStateManager.scale(2.0D, 2.0D, 2.0D);
		GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
		GlStateManager.translate(-this.body.rotationPointX * scale, -this.body.rotationPointY * scale, -this.body.rotationPointZ * scale);
		this.body.render(scale);
		GlStateManager.popMatrix();
	}
}
