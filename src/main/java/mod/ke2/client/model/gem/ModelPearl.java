package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelPearl extends ModelGem {
	public ModelRenderer bipedNose;

	public ModelPearl() {
		super(0.0F, 0.0F, 72, 64);
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
	public void preGemRenderCallback(int pos, float scale) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				GlStateManager.translate(0.0, -0.42, -0.25);
				break;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				GlStateManager.translate(0.0, -0.35, 0.375);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				GlStateManager.translate(0.125, -0.225, -0.25);
				break;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				GlStateManager.translate(-0.125, -0.225, -0.25);
				break;
			case Ke2Gems.GEMSTONE_NOSE :
				GlStateManager.translate(0.0, -0.15, -0.25);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				GlStateManager.translate(0.15, -0.1, -0.25);
				break;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				GlStateManager.translate(-0.15, -0.1, -0.25);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.05, -0.00125);
				break;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.05, 0.00125);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.55, -0.00125);
				break;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.55, 0.00125);
				break;
			case Ke2Gems.GEMSTONE_CHEST :
				GlStateManager.translate(0.0, 0.45, -0.125);
				break;
			case Ke2Gems.GEMSTONE_BACK :
				GlStateManager.translate(0.0, 0.35, 0.125);
				break;
			case Ke2Gems.GEMSTONE_NAVEL :
				GlStateManager.translate(0.0, 0.72, -0.125);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.15, -0.19);
				break;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.25, 0.19);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				GlStateManager.translate(-0.125, 0.375, -0.0625);
				break;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				GlStateManager.translate(0.125, 0.375, -0.0625);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				GlStateManager.translate(-0.125, 0.68, -0.0625);
				break;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				GlStateManager.translate(0.125, 0.68, -0.0625);
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
				return 0.25F;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				return 0.25F;
			case Ke2Gems.GEMSTONE_NOSE :
				return 0.2F;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				return 0.2F;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				return 0.2F;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				return 0.1F;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				return 0.1F;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				return 0.1F;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				return 0.1F;
			case Ke2Gems.GEMSTONE_CHEST :
				return 0.3F;
			case Ke2Gems.GEMSTONE_BACK :
				return 0.3F;
			case Ke2Gems.GEMSTONE_NAVEL :
				return 0.3F;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				return 0.1F;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				return 0.1F;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				return 0.1F;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				return 0.1F;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				return 0.1F;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				return 0.1F;
		}
		return 1.0F;
	}
}
