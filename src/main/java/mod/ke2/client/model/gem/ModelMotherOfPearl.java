package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMotherOfPearl extends ModelGem {
	public ModelRenderer bipedShelmet;
	public ModelRenderer bipedSkirt;
	public ModelRenderer bipedNose;

	public ModelMotherOfPearl() {
		super(0.0F, 0.0F, 96, 96);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8);
		this.bipedHead.setRotationPoint(0F, 0F, 0F);
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4F, -8F, -4F, 8, 8, 8, 0.5F);
		this.bipedHeadwear.setRotationPoint(0F, 0F, 0F);
		this.bipedShelmet = new ModelRenderer(this, 0, 32);
		this.bipedShelmet.addBox(-6F, -12F, -4F, 12, 12, 12);
		this.bipedShelmet.setRotationPoint(0F, 0F, 0F);
		this.bipedNose = new ModelRenderer(this, 36, 16);
		this.bipedNose.addBox(-0.5F, -3F, -6F, 1, 1, 2);
		this.bipedNose.setRotationPoint(0F, 0F, 0F);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.addBox(-3F, 0F, -2F, 6, 12, 4);
		this.bipedBody.setRotationPoint(0F, 0F, 0F);
		this.bipedSkirt = new ModelRenderer(this, 64, 0);
		this.bipedSkirt.addBox(-4F, 12F, -4F, 8, 18, 8);
		this.bipedSkirt.setRotationPoint(0F, 0F, 0F);
		this.bipedRightArm = new ModelRenderer(this, 28, 16);
		this.bipedRightArm.addBox(0F, 0F, -1F, 2, 12, 2);
		this.bipedRightArm.setRotationPoint(0F, 0F, 0F);
		this.bipedRightArm.mirror = true;
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.addBox(-2F, 0F, -1F, 2, 12, 2);
		this.bipedLeftArm.setRotationPoint(0F, 0F, 0F);
		this.bipedRightLeg = new ModelRenderer(this, 28, 16);
		this.bipedRightLeg.addBox(1F, 0F, -1F, 2, 12, 2);
		this.bipedRightLeg.setRotationPoint(0F, 12F, 0F);
		this.bipedLeftLeg = new ModelRenderer(this, 28, 16);
		this.bipedLeftLeg.addBox(-3F, 0F, -1F, 2, 12, 2);
		this.bipedLeftLeg.setRotationPoint(0F, 12F, 0F);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedHeadwear.render(scale);
		this.bipedShelmet.render(scale);
		this.bipedNose.render(scale);
		this.bipedBody.render(scale);
		this.bipedSkirt.render(scale);
		this.bipedRightArm.mirror = true;
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.mirror = false;
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		super.copyModelAngles(this.bipedHead, this.bipedShelmet);
		super.copyModelAngles(this.bipedBody, this.bipedSkirt);
		super.copyModelAngles(this.bipedHead, this.bipedNose);
		this.bipedRightLeg.rotateAngleX = 0;
		this.bipedRightLeg.rotateAngleY = 0;
		this.bipedRightLeg.rotateAngleZ = 0;
		this.bipedLeftLeg.rotateAngleX = 0;
		this.bipedLeftLeg.rotateAngleY = 0;
		this.bipedLeftLeg.rotateAngleZ = 0;
		this.bipedShelmet.rotateAngleX += -0.1F;
		this.bipedShelmet.offsetY = 0.02F;
		this.bipedShelmet.offsetZ = 0.02F;
	}

	@Override
	public void renderGemOnBody(int pos, float scale) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				this.bipedHead.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				this.bipedHead.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				this.bipedHead.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				this.bipedHead.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_NOSE :
				this.bipedHead.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				this.bipedRightLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				this.bipedLeftLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				this.bipedRightLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				this.bipedLeftLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_CHEST :
				this.bipedBody.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_BACK :
				this.bipedBody.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_NAVEL :
				this.bipedBody.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				this.bipedRightLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				this.bipedLeftLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				this.bipedRightLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				this.bipedLeftLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				this.bipedRightLeg.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				this.bipedLeftLeg.postRender(scale);
				break;
		}
	}
}
