package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPearl extends ModelGem {
	public ModelRenderer bipedNose;
	
	public ModelPearl() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.bipedHead.offsetY = -0.125F;
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.5F);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedNose = new ModelRenderer(this, 24, 0);
		this.bipedNose.addBox(-0.5F, 1.0F, -6.0F, 1, 1, 2, 0.0F);
		this.bipedHead.addChild(this.bipedNose);
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.addBox(-2.0F, 2.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 30);
		this.bipedRightArm.addBox(0.0F, 2.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.addBox(-3.0F, 2.0F, -2.0F, 6, 10, 4, 0.0F);
		this.bipedSkirt = new ModelRenderer(this, 2, 37);
		this.bipedSkirt.addBox(-4.0F, 12.0F, -4.0F, 8, 12, 8, 0.0F);
		this.bipedBody.addChild(this.bipedSkirt);
		this.bipedLeftLeg = new ModelRenderer(this, 28, 16);
		this.bipedLeftLeg.addBox(-3.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedRightLeg = new ModelRenderer(this, 28, 30);
		this.bipedRightLeg.addBox(1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
	}
	
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
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
