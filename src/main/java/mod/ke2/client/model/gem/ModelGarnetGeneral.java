package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGarnetGeneral extends ModelGem {
	public ModelRenderer bipedShoulderPads;

	public ModelGarnetGeneral() {
		super(0.0F, 0.0F, 80, 80);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-6.0F, -12.0F, -4.0F, 12, 12, 8, 0.0F);
		this.bipedHead.offsetY = -0.625F;
		this.bipedRightArm = new ModelRenderer(this, 0, 49);
		this.bipedRightArm.addBox(-2.0F, 2.0F, -1.5F, 3, 16, 3, 0.0F);
		this.bipedRightArm.offsetY = -0.5F;
		this.bipedLeftArm = new ModelRenderer(this, 0, 30);
		this.bipedLeftArm.addBox(-1.0F, 2.0F, -1.5F, 3, 16, 3, 0.0F);
		this.bipedLeftArm.offsetY = -0.5F;
		this.bipedBody = new ModelRenderer(this, 12, 30);
		this.bipedBody.addBox(-4.0F, -6.0F, -3.0F, 8, 14, 6, 0.0F);
		this.bipedShoulderPads = new ModelRenderer(this, 5, 20);
		this.bipedShoulderPads.addBox(-8.0F, -10.0F, -3.0F, 16, 4, 6);
		this.bipedBody.addChild(this.bipedShoulderPads);
		this.bipedCape = new ModelRenderer(this, 46, 0);
		this.bipedCape.addBox(-8.0F, -6.0F, 2.0F, 16, 22, 1, 0.0F);
		this.bipedBody.addChild(this.bipedCape);
		this.bipedRightLeg = new ModelRenderer(this, 40, 50);
		this.bipedRightLeg.addBox(-4.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
		this.bipedRightLeg.offsetY = -0.25F;
		this.bipedLeftLeg = new ModelRenderer(this, 40, 30);
		this.bipedLeftLeg.addBox(0.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
		this.bipedLeftLeg.offsetY = -0.25F;
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
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