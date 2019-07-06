package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelJadeSpur extends ModelGem {
	public ModelRenderer bipedCog0;
	public ModelRenderer bipedCog1;
	public ModelRenderer bipedCog2;
	public ModelRenderer bipedCog3;
	
	public ModelJadeSpur() {
		super(0.0F, 0.0F, 64, 80);
		this.bipedHead = new ModelRenderer(this, 0, 2);
		this.bipedHead.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.bipedHead.addBox(-6.0F, -8.0F, -3.0F, 12, 8, 6, 0.0F);
		this.bipedHead.offsetY = -0.125F;
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 10, 4, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 30);
		this.bipedRightArm.setRotationPoint(-3.0F, 0.0F, 0.0F);
		this.bipedRightArm.addBox(0.0F, 0.0F, 0.0F, 2, 12, 2, 0.0F);
		this.bipedBody.addChild(this.bipedRightArm);
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.setRotationPoint(3.0F, 0.0F, 0.0F);
		this.bipedLeftArm.addBox(-2.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedBody.addChild(this.bipedLeftArm);
		this.bipedSkirt = new ModelRenderer(this, 0, 58);
		this.bipedSkirt.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.bipedSkirt.addBox(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F);
		this.bipedBody.addChild(this.bipedSkirt);
		this.bipedCog0 = new ModelRenderer(this, 48, 62);
		this.bipedCog0.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedCog0.addBox(-1.0F, 0.0F, -5.0F, 2, 16, 10, 0.0F);
		this.bipedSkirt.addChild(this.bipedCog0);
		this.bipedCog1 = new ModelRenderer(this, 24, 62);
		this.bipedCog1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedCog1.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 2, 0.0F);
		this.bipedSkirt.addChild(this.bipedCog1);
		this.bipedCog2 = new ModelRenderer(this, 48, 62);
		this.bipedCog2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedCog2.addBox(-1.0F, 0.0F, -5.0F, 2, 16, 10, 0.0F);
		this.bipedSkirt.addChild(this.bipedCog2);
		this.bipedCog3 = new ModelRenderer(this, 24, 62);
		this.bipedCog3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedCog3.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 2, 0.0F);
		this.bipedSkirt.addChild(this.bipedCog3);
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
		this.bipedCog2.rotateAngleY = 0.7853981633974483F;
		this.bipedCog3.rotateAngleY = 0.7853981633974483F;
	}

	@Override
	public void preGemRenderCallback(int pos, float scale) {
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
	}
	
	@Override
	public void postGemRenderCallback(int pos, float scale) {
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
	}
}