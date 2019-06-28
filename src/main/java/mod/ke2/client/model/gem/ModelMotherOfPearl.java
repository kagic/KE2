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
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
		this.bipedShelmet = new ModelRenderer(this, 0, 32);
		this.bipedShelmet.addBox(-6.0F, -12.0F, -4.0F, 12, 12, 12);
		this.bipedNose = new ModelRenderer(this, 36, 16);
		this.bipedNose.addBox(-0.5F, -3.0F, -6.0F, 1, 1, 2);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 12, 4);
		this.bipedSkirt = new ModelRenderer(this, 64, 0);
		this.bipedSkirt.addBox(-4.0F, 12.0F, -4.0F, 8, 18, 8);
		this.bipedRightArm = new ModelRenderer(this, 28, 16);
		this.bipedRightArm.addBox(0.0F, 0.0F, -1.0F, 2, 12, 2);
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.addBox(-2.0F, 0.0F, -1.0F, 2, 12, 2);
		this.bipedLeftArm.setRotationPoint(0F, 0F, 0F);
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
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		super.copyModelAngles(this.bipedHead, this.bipedShelmet);
		super.copyModelAngles(this.bipedBody, this.bipedSkirt);
		super.copyModelAngles(this.bipedHead, this.bipedNose);
		this.bipedShelmet.rotateAngleX += -0.1F;
		this.bipedShelmet.offsetY = -0.355F;
		this.bipedShelmet.offsetZ = 0.02F;
		this.bipedSkirt.offsetY = -0.375F;
		this.bipedBody.offsetY = -0.375F;
		this.bipedRightArm.offsetY = -0.375F;
		this.bipedLeftArm.offsetY = -0.375F;
		this.bipedHead.offsetY = -0.375F;
		this.bipedHeadwear.offsetY = -0.375F;
		this.bipedNose.offsetY = -0.375F;
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
