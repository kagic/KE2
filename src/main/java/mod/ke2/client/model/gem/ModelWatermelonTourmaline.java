package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWatermelonTourmaline extends ModelGem {
	public ModelWatermelonTourmaline() {
		super(0.0F, 0.0F, 96, 80);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -12.0F, -4.0F, 8, 8, 8);
		this.bipedHead.offsetY = -1.0F;
		this.bipedBody = new ModelRenderer(this, 24, 20);
		this.bipedBody.addBox(-6.0F, -16.0F, -4.0F, 12, 20, 8);
		this.bipedRightArm = new ModelRenderer(this, 64, 20);
		this.bipedRightArm.addBox(-7.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedRightArm.offsetY = -1.0F;
		this.bipedLeftArm = new ModelRenderer(this, 64, 46);
		this.bipedLeftArm.addBox(1.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedLeftArm.offsetY = -1.0F;
		this.bipedRightLeg = new ModelRenderer(this, 0, 20);
		this.bipedRightLeg.addBox(-6.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedRightLeg.offsetY = -0.5F;
		this.bipedLeftLeg = new ModelRenderer(this, 0, 46);
		this.bipedLeftLeg.addBox(0.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedLeftLeg.offsetY = -0.5F;
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedHeadwear.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedLeftLeg.render(scale);
		this.bipedRightLeg.render(scale);
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