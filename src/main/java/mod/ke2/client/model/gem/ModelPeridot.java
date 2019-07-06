package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.entity.gem.EntityPeridot;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelPeridot extends ModelGem {
	public ModelPeridot() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		this.bipedHead.offsetY = 0.25F;
		this.bipedHeadwear = new ModelRenderer(this, 0, 40);
		this.bipedHeadwear.addBox(-11.0F, -12.0F, -4.0F, 14, 14, 10);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.addBox(-3.0F, 4.0F, -2.0F, 6, 10, 4);
		this.bipedRightArm = new ModelRenderer(this, 0, 16);
		this.bipedRightArm.addBox(0.0F, 0.0F, -1.0F, 2, 10, 2);
		this.bipedRightArm.offsetY = 0.25F;
		this.bipedLeftArm = new ModelRenderer(this, 0, 28);
		this.bipedLeftArm.addBox(-2.0F, 0.0F, -1.0F, 2, 10, 2);
		this.bipedLeftArm.offsetY = 0.25F;
		this.bipedRightLeg = new ModelRenderer(this, 28, 16);
		this.bipedRightLeg.addBox(-3.0F, 2.0F, -1.0F, 2, 10, 2);
		this.bipedLeftLeg = new ModelRenderer(this, 28, 28);
		this.bipedLeftLeg.addBox(1.0F, 2.0F, -1.0F, 2, 10, 2);
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
		if (entity instanceof EntityPeridot) {
			EntityPeridot gem = (EntityPeridot) entity;
			if (gem.hasSquareHair()) {
				this.bipedHeadwear.rotateAngleY = 0.0F;
				this.bipedHeadwear.rotateAngleX = 0.0F;
				this.bipedHeadwear.rotateAngleZ += 0.0000000F;
				this.bipedHeadwear.offsetX = 0.25F;
				this.bipedHeadwear.offsetY = -0.12F;
			} else {
				this.bipedHeadwear.rotateAngleY = 0.0F;
				this.bipedHeadwear.rotateAngleX = 0.0F;
				this.bipedHeadwear.rotateAngleZ += 0.7853982F;
				this.bipedHeadwear.offsetX = -0.039F;
				this.bipedHeadwear.offsetY = -0.06F;
			}
		}
		this.bipedHeadwear.offsetZ = 0.001F;
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
				GlStateManager.translate(0.0, 0.4, 0.125);
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