package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.entity.gem.EntityLapisLazuli;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;

public class ModelLapisLazuli extends ModelGem {
	public ModelRenderer bipedRightWing;
	public ModelRenderer bipedLeftWing;
	
	public ModelLapisLazuli() {
		super(0.0F, 0.0F, 64, 72);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.bipedHead.offsetY = -0.125F;
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.5F);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.addBox(-2.0F, 2.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 30);
		this.bipedRightArm.addBox(0.0F, 2.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedBody = new ModelRenderer(this, 14, 16);
		this.bipedBody.addBox(-3.0F, 2.0F, -2.0F, 6, 10, 4, 0.0F);
		this.bipedRightWing = new ModelRenderer(this, 32, 51);
		this.bipedRightWing.addBox(0F, -2F, 2F, 10, 20, 1);
		this.bipedRightWing.setRotationPoint(-5F, 0.5F, 0F);
		this.bipedLeftWing = new ModelRenderer(this, 10, 51);
		this.bipedLeftWing.addBox(-10F, -2F, 2F, 10, 20, 1);
		this.bipedLeftWing.setRotationPoint(-5F, 0.5F, 0F);
		this.bipedSkirt = new ModelRenderer(this, 8, 30);
		this.bipedSkirt.addBox(-4.0F, 12.0F, -4.0F, 8, 12, 8, 0.0F);
		this.bipedBody.addChild(this.bipedSkirt);
	}
	
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedBody.render(scale);
		if (entity instanceof EntityLapisLazuli) {
			EntityLapisLazuli gem = (EntityLapisLazuli) entity;
			if (gem.isWinged()) {
				this.bipedRightWing.render(scale);
				this.bipedLeftWing.render(scale);
			}
		}
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
	}
	
	@Override
	public void setLivingAnimations(EntityLivingBase entity, float limbSwingAmount, float ageInTicks, float partialTickTime) {
		super.setLivingAnimations(entity, limbSwingAmount, ageInTicks, partialTickTime);
		float x = 0.2617994F;
		float y = 1.0F;
		float z = -0.2617994F;
		if (entity.motionY < 0.0D) {
			Vec3d vec3d = new Vec3d(entity.motionX, entity.motionY, entity.motionZ).normalize();
			y = 1.0F - (float) Math.pow(-vec3d.y, 1.5D);
		} else if (entity.motionY > 0.0D) {
			Vec3d vec3d = new Vec3d(entity.motionX, entity.motionY, entity.motionZ).normalize();
			y = 1.0F + (float) Math.pow(vec3d.y, 1.5D);
		}
		x = y * 0.34906584F + (1.0F - y) * x;
		z = y * -(float) (Math.PI / 2.0F) + (1.0F - y) * z;
		this.bipedLeftWing.rotationPointX = 5.0F;
		this.bipedLeftWing.rotationPointY = 0;
		this.bipedLeftWing.rotateAngleX = x;
		this.bipedLeftWing.rotateAngleZ = z;
		this.bipedRightWing.rotationPointX = -this.bipedLeftWing.rotationPointX;
		this.bipedRightWing.rotationPointY = this.bipedLeftWing.rotationPointY;
		this.bipedRightWing.rotateAngleX = this.bipedLeftWing.rotateAngleX;
		this.bipedRightWing.rotateAngleZ = -this.bipedLeftWing.rotateAngleZ;
		if (entity.isBeingRidden()) {
			this.bipedRightArm.rotateAngleX = (float) (-Math.PI / 2.0F);
			this.bipedLeftArm.rotateAngleX = (float) (-Math.PI / 2.0F);
		}
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
