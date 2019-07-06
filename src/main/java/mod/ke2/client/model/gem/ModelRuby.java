package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelRuby extends ModelGem {
	public ModelRuby() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-7.0F, -12.0F, -4.0F, 14, 12, 8);
		this.bipedHead.offsetY = 0.5F;
		this.bipedRightArm = new ModelRenderer(this, 0, 20);
		this.bipedRightArm.addBox(-3.0F, 0.0F, -2.0F, 4, 8, 4);
		this.bipedRightArm.offsetY = 0.5F;
		this.bipedLeftArm = new ModelRenderer(this, 0, 32);
		this.bipedLeftArm.addBox(-1.0F, 0.0F, -2.0F, 4, 8, 4);
		this.bipedLeftArm.offsetY = 0.5F;
		this.bipedBody = new ModelRenderer(this, 16, 20);
		this.bipedBody.addBox(-4.0F, 8.0F, -2.0F, 8, 8, 4);
		this.bipedRightLeg = new ModelRenderer(this, 40, 32);
		this.bipedRightLeg.addBox(-4.0F, 0.0F, -2.0F, 4, 8, 4);
		this.bipedRightLeg.offsetY = 0.25F;
		this.bipedLeftLeg = new ModelRenderer(this, 40, 20);
		this.bipedLeftLeg.addBox(0.0F, 0.0F, -2.0F, 4, 8, 4);
		this.bipedLeftLeg.offsetY = 0.25F;
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
	public void preGemRenderCallback(int pos, float scale) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				GlStateManager.translate(0.0, -0.42, -0.25);
				break;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				GlStateManager.translate(0.0, -0.25, 0.25);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				GlStateManager.translate(0.125, -0.27, -0.25);
				break;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				GlStateManager.translate(-0.125, -0.27, -0.25);
				break;
			case Ke2Gems.GEMSTONE_NOSE :
				GlStateManager.translate(0.0, -0.18, -0.25);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				GlStateManager.translate(0.15, -0.1, -0.25);
				break;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				GlStateManager.translate(-0.15, -0.1, -0.25);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.15, -0.2);
				break;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.15, 0.2);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.35, -0.2);
				break;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.35, 0.2);
				break;
			case Ke2Gems.GEMSTONE_CHEST :
				GlStateManager.translate(0.0, 0.7, -0.125);
				break;
			case Ke2Gems.GEMSTONE_BACK :
				GlStateManager.translate(0.0, 0.78, 0.125);
				break;
			case Ke2Gems.GEMSTONE_NAVEL :
				GlStateManager.translate(0.0, 0.85, -0.125);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.15, -0.25);
				break;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				GlStateManager.rotate(90.0F, 0, 1, 0);
				GlStateManager.translate(0.0, 0.15, 0.25);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				GlStateManager.translate(-0.125, 0.225, -0.125);
				break;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				GlStateManager.translate(0.125, 0.225, -0.125);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				GlStateManager.translate(-0.125, 0.35, -0.125);
				break;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				GlStateManager.translate(0.125, 0.35, -0.125);
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
				return 0.2F;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				return 0.2F;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				return 0.2F;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				return 0.2F;
			case Ke2Gems.GEMSTONE_CHEST :
				return 0.3F;
			case Ke2Gems.GEMSTONE_BACK :
				return 0.3F;
			case Ke2Gems.GEMSTONE_NAVEL :
				return 0.3F;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				return 0.25F;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				return 0.25F;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				return 0.25F;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				return 0.25F;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				return 0.25F;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				return 0.25F;
		}
		return 1.0F;
	}
}