package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelQuartz extends ModelGem {
	public ModelRenderer bipedHairFloof;
	public ModelRenderer bipedTopBun;
	public ModelRenderer bipedSideBuns;
	public ModelRenderer bipedBackBun;

	public ModelQuartz() {
		super(0.0F, 0.0F, 144, 80);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-5.0F, -12.0F, -5.0F, 10, 12, 10);
		this.bipedHead.offsetY = -1.0F;
		this.bipedHeadwear = new ModelRenderer(this, 90, 0);
		this.bipedHeadwear.addBox(-5.0F, -12.0F, -5.0F, 10, 28, 10, 0.5F);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedHairFloof = new ModelRenderer(this, 63, 9);
		this.bipedHairFloof.addBox(-6.0F, -12.0F, -6.0F, 12, 12, 1, 0.5F);
		this.bipedHead.addChild(this.bipedHairFloof);
		this.bipedSideBuns = new ModelRenderer(this, 88, 40);
		this.bipedSideBuns.addBox(-9.0F, -6.0F, -2.0F, 18, 4, 4);
		this.bipedHead.addChild(this.bipedSideBuns);
		this.bipedTopBun = new ModelRenderer(this, 88, 48);
		this.bipedTopBun.addBox(-2.0F, -12.0F, -2.0F, 4, 4, 4);
		this.bipedHead.addChild(this.bipedTopBun);
		this.bipedBackBun = new ModelRenderer(this, 104, 48);
		this.bipedBackBun.addBox(-2.0F, -6.0F, 4.0F, 4, 4, 4);
		this.bipedHead.addChild(this.bipedBackBun);
		this.bipedBody = new ModelRenderer(this, 24, 22);
		this.bipedBody.addBox(-6.0F, -16.0F, -4.0F, 12, 20, 8);
		this.bipedRightArm = new ModelRenderer(this, 0, 22);
		this.bipedRightArm.addBox(-7.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedRightArm.offsetY = -1.0F;
		this.bipedLeftArm = new ModelRenderer(this, 0, 48);
		this.bipedLeftArm.addBox(1.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedLeftArm.offsetY = -1.0F;
		this.bipedRightLeg = new ModelRenderer(this, 64, 22);
		this.bipedRightLeg.addBox(-6.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedRightLeg.offsetY = -0.5F;
		this.bipedLeftLeg = new ModelRenderer(this, 64, 48);
		this.bipedLeftLeg.addBox(0.0F, 0.0F, -3.0F, 6, 20, 6);
		this.bipedLeftLeg.offsetY = -0.5F;
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
	}
	
	@Override
	public void preGemRenderCallback(int pos, float scale) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				GlStateManager.translate(0.0, -0.55, -0.325);
				break;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				GlStateManager.translate(0.0, -0.35, 0.35);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				GlStateManager.translate(0.17, -0.35, -0.325);
				break;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				GlStateManager.translate(-0.17, -0.35, -0.325);
				break;
			case Ke2Gems.GEMSTONE_NOSE :
				GlStateManager.translate(0.0, -0.2, -0.325);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				GlStateManager.translate(0.2, -0.15, -0.325);
				break;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				GlStateManager.translate(-0.2, -0.15, -0.325);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.2, -0.45);
				break;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.2, 0.45);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 1.05, -0.45);
				break;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 1.05, 0.45);
				break;
			case Ke2Gems.GEMSTONE_CHEST :
				GlStateManager.translate(0.0, -0.72, -0.25);
				break;
			case Ke2Gems.GEMSTONE_BACK :
				GlStateManager.translate(0.0, -0.5, 0.25);
				break;
			case Ke2Gems.GEMSTONE_NAVEL :
				GlStateManager.translate(0.0, -0.2, -0.25);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.25, -0.38);
				break;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.25, 0.38);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				GlStateManager.translate(-0.2, 0.5, -0.2);
				break;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				GlStateManager.translate(0.2, 0.5, -0.2);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				GlStateManager.translate(-0.2, 1.1, -0.2);
				break;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				GlStateManager.translate(0.2, 1.1, -0.2);
				break;
		}
	}

	@Override
	public float getGemRenderScale(int pos) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				return 0.3F;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				return 0.3F;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				return 0.3F;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				return 0.3F;
			case Ke2Gems.GEMSTONE_NOSE :
				return 0.2F;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				return 0.2F;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				return 0.2F;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				return 0.3F;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				return 0.3F;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				return 0.3F;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				return 0.3F;
			case Ke2Gems.GEMSTONE_CHEST :
				return 0.3F;
			case Ke2Gems.GEMSTONE_BACK :
				return 0.3F;
			case Ke2Gems.GEMSTONE_NAVEL :
				return 0.3F;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				return 0.3F;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				return 0.3F;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				return 0.3F;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				return 0.3F;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				return 0.3F;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				return 0.3F;
		}
		return 1.0F;
	}
}
