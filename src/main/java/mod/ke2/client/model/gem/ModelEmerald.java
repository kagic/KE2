package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEmerald extends ModelGem {
	public ModelRenderer bipedLeftShoulder;
	public ModelRenderer bipedRightShoulder;
	public ModelRenderer bipedHair;
	public ModelRenderer bipedHips;

	public ModelEmerald() {
		super(0.0F, 0.0F, 96, 80);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -6.0F, -4.7F, 8, 8, 8, 0.0F);
		this.bipedHead.offsetY = -0.25F;
		this.bipedHeadwear = new ModelRenderer(this, 64, 20);
		this.bipedHeadwear.addBox(-5.0F, -6.0F, -6.0F, 10, 4, 2, 0.0F);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedHair = new ModelRenderer(this, 56, 0);
		this.bipedHair.addBox(-10.0F, -10.0F, -4.8F, 12, 12, 8, 0.0F);
		this.bipedHead.addChild(this.bipedHair);
		this.bipedBody = new ModelRenderer(this, 12, 16);
		this.bipedBody.addBox(-7.4F, -7.4F, -3.5F, 7, 7, 7, 0.0F);
		this.bipedRightShoulder = new ModelRenderer(this, 16, 58);
		this.bipedRightShoulder.setRotationPoint(3.0F, -4.5F, 0.0F);
		this.bipedRightShoulder.addBox(0.0F, -3.0F, -2.0F, 6, 4, 4, 0.0F);
		this.bipedLeftShoulder = new ModelRenderer(this, 16, 50);
		this.bipedLeftShoulder.setRotationPoint(-3.0F, -4.5F, 0.0F);
		this.bipedLeftShoulder.addBox(0.0F, -1.0F, -2.0F, 6, 4, 4, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 35);
		this.bipedRightArm.addBox(0.0F, -1.0F, -1.5F, 3, 16, 3, 0.0F);
		this.bipedRightShoulder.addChild(this.bipedRightArm);
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.addBox(-3.0F, -1.0F, -1.5F, 3, 16, 3, 0.0F);
		this.bipedLeftShoulder.addChild(this.bipedLeftArm);
		this.bipedHips = new ModelRenderer(this, 12, 30);
		this.bipedHips.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.bipedHips.addBox(-4.0F, -9.0F, -3.0F, 8, 14, 6, 0.0F);
		this.bipedRightLeg = new ModelRenderer(this, 40, 16);
		this.bipedRightLeg.setRotationPoint(1.0F, 4.0F, 0.0F);
		this.bipedRightLeg.addBox(-1.0F, 1.0F, -2.0F, 4, 16, 4, 0.0F);
		this.bipedHips.addChild(this.bipedRightLeg);
		this.bipedLeftLeg = new ModelRenderer(this, 40, 36);
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
		this.bipedHair.rotateAngleY = 0.2617993877991494F;
		this.bipedHair.rotateAngleZ = 0.7853981633974483F;
		this.bipedRightLeg.rotationPointY = 8.0F;
		this.bipedRightLeg.offsetY = -0.25F;
		this.bipedLeftLeg.rotationPointY = 8.0F;
		this.bipedLeftLeg.offsetY = -0.25F;
		this.bipedHead.rotationPointY = -6.0F;
	}
	
	@Override
	public void preGemRenderCallback(int pos, float scale) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				break;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				break;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				break;
			case Ke2Gems.GEMSTONE_NOSE :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				break;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				break;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				break;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				break;
			case Ke2Gems.GEMSTONE_CHEST :
				break;
			case Ke2Gems.GEMSTONE_BACK :
				break;
			case Ke2Gems.GEMSTONE_NAVEL :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				break;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				break;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				break;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				break;
		}
	}

	@Override
	public float getGemRenderScale(int pos) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				return 1.0F;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_NOSE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				return 1.0F;
			case Ke2Gems.GEMSTONE_CHEST :
				return 1.0F;
			case Ke2Gems.GEMSTONE_BACK :
				return 1.0F;
			case Ke2Gems.GEMSTONE_NAVEL :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				return 1.0F;
		}
		return 1.0F;
	}
}