package mod.ke2.client.model.gem;

import org.lwjgl.opengl.GL11;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelSpodumene extends ModelGem {
	public ModelSpodumene() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.bipedHeadwear = new ModelRenderer(this, 40, 8);
		this.bipedHeadwear.addBox(-3.0F, -3.0F, -3.0F, 6, 4, 6, 0.0F);
		this.bipedBody = new ModelRenderer(this, 16, 16);
		this.bipedBody.addBox(-5.0F, 4.0F, -3.0F, 10, 14, 6, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 32);
		this.bipedRightArm.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.bipedRightArm.offsetY = 0.3F;
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.bipedLeftArm.offsetY = 0.3F;
		this.bipedRightLeg = new ModelRenderer(this, 48, 26);
		this.bipedRightLeg.addBox(-4.0F, 6.0F, -2.0F, 4, 6, 4, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 48, 16);
		this.bipedLeftLeg.addBox(0.0F, 6.0F, -2.0F, 4, 6, 4, 0.0F);
	}
	
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHeadwear.render(scale);
		GlStateManager.enableBlend();
		ModelBase.copyModelAngles(this.bipedHead, this.bipedHeadwear);
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.25F);
		this.bipedHead.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedLeftLeg.render(scale);
		this.bipedRightLeg.render(scale);
		GlStateManager.disableBlend();
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