package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelPyrite extends ModelGem {
	public ModelPyrite() {
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
	public void renderGemOnBody(int pos, float scale) {
		super.renderGemOnBody(pos, scale);
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				break;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				break;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				break;
			case Ke2Gems.GEMSTONE_NOSE :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				break;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				break;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				break;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				break;
			case Ke2Gems.GEMSTONE_CHEST :
				break;
			case Ke2Gems.GEMSTONE_BACK :
				break;
			case Ke2Gems.GEMSTONE_NAVEL :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				break;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				break;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				break;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				break;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				break;
		}
		this.bipedGem.postRender(scale);
	}
}