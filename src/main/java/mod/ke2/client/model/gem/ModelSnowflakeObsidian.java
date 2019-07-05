package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSnowflakeObsidian extends ModelGem {
	public ModelRenderer bipedChest;
	
	public ModelSnowflakeObsidian() {
		super(0.0F, 0.0F, 96, 96);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-8.0F, -14.0F, -5.0F, 16, 16, 10, 0.0F);
		this.bipedHead.offsetY = -1.375F;
		this.bipedBody = new ModelRenderer(this, 28, 52);
		this.bipedBody.addBox(-6.0F, -4.0F, -4.0F, 12, 8, 8, 0.0F);
		this.bipedChest = new ModelRenderer(this, 20, 26);
		this.bipedChest.addBox(-8.0F, -20.0F, -6.0F, 16, 16, 12, 0.0F);
		this.bipedBody.addChild(this.bipedChest);
		this.bipedRightArm = new ModelRenderer(this, 0, 56);
		this.bipedRightArm.addBox(-8.0F, 0.0F, -2.5F, 5, 24, 5, 0.0F);
		this.bipedRightArm.offsetY = -1.25F;
		this.bipedChest.addChild(this.bipedRightArm);
		this.bipedLeftArm = new ModelRenderer(this, 0, 26);
		this.bipedLeftArm.addBox(3.0F, 0.0F, -2.5F, 5, 24, 5, 0.0F);
		this.bipedLeftArm.offsetY = -1.25F;
		this.bipedChest.addChild(this.bipedLeftArm);
		this.bipedLeftLeg = new ModelRenderer(this, 76, 26);
		this.bipedLeftLeg.addBox(-6.0F, 0.0F, -2.5F, 5, 20, 5, 0.0F);
		this.bipedLeftLeg.offsetY = -0.5F;
		this.bipedBody.addChild(this.bipedLeftLeg);
		this.bipedRightLeg = new ModelRenderer(this, 76, 52);
		this.bipedRightLeg.addBox(1.0F, 0.0F, -2.5F, 5, 20, 5, 0.0F);
		this.bipedRightLeg.offsetY = -0.5F;
		this.bipedBody.addChild(this.bipedRightLeg);
	}
	
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netbipedHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netbipedHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedBody.render(scale);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netbipedHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netbipedHeadYaw, headPitch, scaleFactor, entity);
	}
	
	@Override
	public void renderGemOnBody(int pos, float scale) {
		super.renderGemOnBody(pos, scale);
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
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				this.bipedHead.postRender(scale);
				break;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
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
