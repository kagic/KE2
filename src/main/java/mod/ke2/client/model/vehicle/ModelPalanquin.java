package mod.ke2.client.model.vehicle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelPalanquin extends ModelBase {
	public ModelRenderer top;
	public ModelRenderer capTop;
	public ModelRenderer capBottom;
	public ModelRenderer body;
	public ModelRenderer base;
	public ModelRenderer legTopFrontLeft;
	public ModelRenderer legBottomFrontLeft;
	public ModelRenderer legTopFrontRight;
	public ModelRenderer legBottomFrontRight;
	public ModelRenderer legTopBackLeft;
	public ModelRenderer legBottomBackLeft;
	public ModelRenderer legTopBackRight;
	public ModelRenderer legBottomBackRight;
	public ModelRenderer seat;
	public ModelRenderer armLeft;
	public ModelRenderer armRight;
	public ModelRenderer backTop;
	public ModelRenderer backMiddle;
	public ModelRenderer backBottom;
	public ModelRenderer cage;
	public ModelRenderer tip;
	public ModelRenderer veil;

	public ModelPalanquin() {
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.top = new ModelRenderer(this, 140, 24);
		this.top.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.top.addBox(-5.0F, -3.0F, -5.0F, 10, 3, 10, 0.0F);
		this.tip.addChild(this.top);
		this.capTop = new ModelRenderer(this, 0, 0);
		this.capTop.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.capTop.addBox(-4.0F, -6.0F, 0.0F, 8, 6, 0, 0.0F);
		this.capTop.rotateAngleY = 0.7853981633974483F;
		this.top.addChild(this.capTop);
		this.capBottom = new ModelRenderer(this, 0, 0);
		this.capBottom.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.capBottom.addBox(-4.0F, -6.0F, 0.0F, 8, 6, 0, 0.0F);
		this.capBottom.rotateAngleY = -0.7853981633974483F;
		this.top.addChild(this.capBottom);
		this.body = new ModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.body.addBox(-12.0F, 0.0F, -12.0F, 24, 2, 24, 0.0F);
		this.body.rotateAngleY = 0.017453292519943295F;
		this.base = new ModelRenderer(this, 72, 0);
		this.base.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.base.addBox(-11.0F, 0.0F, -11.0F, 22, 2, 22, 0.0F);
		this.body.addChild(this.base);
		this.legTopFrontLeft = new ModelRenderer(this, 30, 26);
		this.legTopFrontLeft.setRotationPoint(12.0F, 0.0F, -12.0F);
		this.legTopFrontLeft.addBox(-1.5F, -20.0F, -1.5F, 3, 20, 3, 0.0F);
		this.legTopFrontLeft.rotateAngleX = 0.5235987755982988F;
		this.legTopFrontLeft.rotateAngleZ = 0.5235987755982988F;
		this.body.addChild(this.legTopFrontLeft);
		this.legBottomFrontLeft = new ModelRenderer(this, 22, 26);
		this.legBottomFrontLeft.setRotationPoint(0.0F, -21.0F, 0.0F);
		this.legBottomFrontLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 20, 2, 0.0F);
		this.legBottomFrontLeft.rotateAngleX = -0.5235987755982988F;
		this.legBottomFrontLeft.rotateAngleZ = -0.5235987755982988F;
		this.legTopFrontLeft.addChild(this.legBottomFrontLeft);
		this.legTopFrontRight = new ModelRenderer(this, 30, 26);
		this.legTopFrontRight.setRotationPoint(12.0F, 0.0F, 12.0F);
		this.legTopFrontRight.addBox(-1.5F, -20.0F, -1.5F, 3, 20, 3, 0.0F);
		this.legTopFrontRight.rotateAngleX = -0.5235987755982988F;
		this.legTopFrontRight.rotateAngleZ = 0.5235987755982988F;
		this.body.addChild(this.legTopFrontRight);
		this.legBottomFrontRight = new ModelRenderer(this, 22, 26);
		this.legBottomFrontRight.setRotationPoint(0.0F, -21.0F, 0.0F);
		this.legBottomFrontRight.addBox(-1.0F, 0.0F, -1.0F, 2, 20, 2, 0.0F);
		this.legBottomFrontRight.rotateAngleX = 0.5235987755982988F;
		this.legBottomFrontRight.rotateAngleZ = -0.5235987755982988F;
		this.legTopFrontRight.addChild(this.legBottomFrontRight);
		this.legTopBackLeft = new ModelRenderer(this, 30, 26);
		this.legTopBackLeft.setRotationPoint(-12.0F, 0.0F, 12.0F);
		this.legTopBackLeft.addBox(-1.5F, -20.0F, -1.5F, 3, 20, 3, 0.0F);
		this.legTopBackLeft.rotateAngleX = -0.5235987755982988F;
		this.legTopBackLeft.rotateAngleZ = -0.5235987755982988F;
		this.body.addChild(this.legTopBackLeft);
		this.legBottomBackLeft = new ModelRenderer(this, 22, 26);
		this.legBottomBackLeft.setRotationPoint(0.0F, -21.0F, 0.0F);
		this.legBottomBackLeft.addBox(-1.0F, 0.0F, -1.0F, 2, 20, 2, 0.0F);
		this.legBottomBackLeft.rotateAngleX = 0.5235987755982988F;
		this.legBottomBackLeft.rotateAngleZ = 0.5235987755982988F;
		this.legTopBackLeft.addChild(this.legBottomBackLeft);
		this.legTopBackRight = new ModelRenderer(this, 30, 26);
		this.legTopBackRight.setRotationPoint(-12.0F, 0.0F, -12.0F);
		this.legTopBackRight.addBox(-1.5F, -20.0F, -1.5F, 3, 20, 3, 0.0F);
		this.legTopBackRight.rotateAngleX = 0.5235987755982988F;
		this.legTopBackRight.rotateAngleZ = -0.5235987755982988F;
		this.body.addChild(this.legTopBackRight);
		this.legBottomBackRight = new ModelRenderer(this, 22, 26);
		this.legBottomBackRight.setRotationPoint(0.0F, -21.0F, 0.0F);
		this.legBottomBackRight.addBox(-1.0F, 0.0F, -1.0F, 2, 20, 2, 0.0F);
		this.legBottomBackRight.rotateAngleX = -0.5235987755982988F;
		this.legBottomBackRight.rotateAngleZ = 0.5235987755982988F;
		this.legTopBackRight.addChild(this.legBottomBackRight);
		this.seat = new ModelRenderer(this, 184, 0);
		this.seat.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.seat.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
		this.base.addChild(this.seat);
		this.armLeft = new ModelRenderer(this, 224, 0);
		this.armLeft.mirror = true;
		this.armLeft.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.armLeft.addBox(0.0F, -14.0F, -5.0F, 1, 14, 9, 0.0F);
		this.seat.addChild(this.armLeft);
		this.armRight = new ModelRenderer(this, 224, 0);
		this.armRight.setRotationPoint(-4.0F, 0.0F, 0.0F);
		this.armRight.addBox(-1.0F, -14.0F, -5.0F, 1, 14, 9, 0.0F);
		this.seat.addChild(this.armRight);
		this.backTop = new ModelRenderer(this, 0, 26);
		this.backTop.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.backTop.addBox(-5.0F, -24.0F, 1.0F, 10, 24, 1, 0.0F);
		this.seat.addChild(this.backTop);
		this.backMiddle = new ModelRenderer(this, 72, 0);
		this.backMiddle.setRotationPoint(0.0F, -19.1F, 0.8F);
		this.backMiddle.addBox(0.0F, -9.0F, 0.0F, 9, 9, 1, 0.0F);
		this.backMiddle.rotateAngleZ = -0.7853981633974483F;
		this.backTop.addChild(this.backMiddle);
		this.backBottom = new ModelRenderer(this, 138, 0);
		this.backBottom.setRotationPoint(4.0F, -4.0F, -0.2F);
		this.backBottom.addBox(0.0F, -6.0F, 0.0F, 6, 6, 1, 0.0F);
		this.backMiddle.addChild(this.backBottom);
		this.cage = new ModelRenderer(this, 164, 18);
		this.cage.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.cage.addBox(-10.0F, -36.0F, -10.0F, 20, 36, 20, 0.0F);
		this.base.addChild(this.cage);
		this.tip = new ModelRenderer(this, 0, 59);
		this.tip.setRotationPoint(0.0F, -38.0F, 0.0F);
		this.tip.addBox(-11.5F, 0.0F, -11.5F, 23, 2, 23, 0.0F);
		this.cage.addChild(this.tip);
		this.veil = new ModelRenderer(this, 74, 24);
		this.veil.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.veil.addBox(-11.0F, -36.0F, -11.0F, 22, 36, 22, 0.0F);
		this.base.addChild(this.veil);
	}

	public void resetRotationAngles() {
		this.legTopFrontLeft.rotateAngleX = 0.5235987755982988F;
		this.legTopFrontLeft.rotateAngleY = 0.0F;
		this.legTopFrontLeft.rotateAngleZ = 0.5235987755982988F;
		this.legTopFrontRight.rotateAngleX = -0.5235987755982988F;
		this.legTopFrontRight.rotateAngleY = 0.0F;
		this.legTopFrontRight.rotateAngleZ = 0.5235987755982988F;
		this.legTopBackLeft.rotateAngleX = -0.5235987755982988F;
		this.legTopBackLeft.rotateAngleY = 0.0F;
		this.legTopBackLeft.rotateAngleZ = -0.5235987755982988F;
		this.legTopBackRight.rotateAngleX = 0.5235987755982988F;
		this.legTopBackRight.rotateAngleY = 0.0F;
		this.legTopBackRight.rotateAngleZ = -0.5235987755982988F;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		this.resetRotationAngles();
		if (entity.onGround) {
			this.legTopFrontLeft.rotateAngleY += Math.abs(MathHelper.sin(limbSwing * 0.6662F + 3.14F) * 0.4F) * limbSwingAmount;
			this.legTopFrontRight.rotateAngleY += -Math.abs(MathHelper.sin(limbSwing * 0.6662F + 3.14F) * 0.4F) * limbSwingAmount;
			this.legTopBackLeft.rotateAngleY += -Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
			this.legTopBackRight.rotateAngleY += Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
			this.legTopFrontLeft.rotateAngleZ += MathHelper.cos(limbSwing * 0.6662F * 2.0F + 3.14F) * 0.4F * limbSwingAmount;
			this.legTopFrontRight.rotateAngleZ += -MathHelper.cos(limbSwing * 0.6662F * 2.0F + 3.14F) * 0.4F * limbSwingAmount;
			this.legTopBackLeft.rotateAngleZ += MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F * limbSwingAmount;
			this.legTopBackRight.rotateAngleZ += -MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F * limbSwingAmount;
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
