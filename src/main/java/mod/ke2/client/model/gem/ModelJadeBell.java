package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelJadeBell extends ModelGem {
	public ModelRenderer bipedRightPart;
	public ModelRenderer bipedLeftPart;
	public ModelRenderer bipedRightEar;
	public ModelRenderer bipedLeftEar;
	public ModelRenderer bipedRightBun;
	public ModelRenderer bipedLeftBun;
	public ModelRenderer bipedBottomBun;

	public ModelJadeBell() {
		super(0.0F, 0.0F, 64, 80);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.bipedHead.offsetY = -0.125F;
		this.bipedRightEar = new ModelRenderer(this, 32, 33);
		this.bipedRightEar.setRotationPoint(-3.0F, -9.0F, -2.0F);
		this.bipedRightEar.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 4, 0.0F);
		this.bipedHead.addChild(this.bipedRightEar);
		this.bipedLeftEar = new ModelRenderer(this, 32, 33);
		this.bipedLeftEar.setRotationPoint(3.0F, -9.0F, -2.0F);
		this.bipedLeftEar.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 4, 0.0F);
		this.bipedHead.addChild(this.bipedLeftEar);
		this.bipedRightBun = new ModelRenderer(this, 48, 25);
		this.bipedRightBun.setRotationPoint(-4.0F, -4.0F, 0.0F);
		this.bipedRightBun.addBox(-4.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
		this.bipedHead.addChild(this.bipedRightBun);
		this.bipedLeftBun = new ModelRenderer(this, 32, 25);
		this.bipedLeftBun.setRotationPoint(4.0F, -4.0F, 0.0F);
		this.bipedLeftBun.addBox(0.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
		this.bipedHead.addChild(this.bipedLeftBun);
		this.bipedBottomBun = new ModelRenderer(this, 64, 33);
		this.bipedBottomBun.setRotationPoint(0.0F, -8.0F, 2.5F);
		this.bipedBottomBun.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 4, 0.0F);
		this.bipedHead.addChild(this.bipedBottomBun);
		this.bipedRightPart = new ModelRenderer(this, 32, 0);
		this.bipedRightPart.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightPart.addBox(-5.0F, -9.0F, -5.0F, 10, 16, 10, 0.0F);
		this.bipedHead.addChild(this.bipedRightPart);
		this.bipedLeftPart = new ModelRenderer(this, 45, 36);
		this.bipedLeftPart.setRotationPoint(0.0F, -8.0F, -4.0F);
		this.bipedLeftPart.addBox(-4.0F, 0.0F, -1.0F, 8, 4, 1, 0.0F);
		this.bipedHead.addChild(this.bipedLeftPart);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 10, 4, 0.0F);
		this.bipedSkirt = new ModelRenderer(this, 0, 58);
		this.bipedSkirt.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.bipedSkirt.addBox(-5.0F, 0.0F, -3.0F, 10, 16, 6, 0.0F);
		this.bipedBody.addChild(this.bipedSkirt);
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedBody.addChild(this.bipedLeftArm);
		this.bipedRightArm = new ModelRenderer(this, 0, 30);
		this.bipedRightArm.setRotationPoint(-4.0F, 0.0F, 0.0F);
		this.bipedRightArm.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 2, 0.0F);
		this.bipedBody.addChild(this.bipedRightArm);
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
		this.bipedRightEar.mirror = true;
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
	public float getGemRenderScale(int pos) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD :
				return 1.0F;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_EYE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_EYE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_NOSE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_CHEEK :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_CHEEK :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_HAND :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_HAND :
				return 1.0F;
			case Ke2Gems.GEMSTONE_CHEST :
				return 1.0F;
			case Ke2Gems.GEMSTONE_BACK :
				return 1.0F;
			case Ke2Gems.GEMSTONE_NAVEL :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_THIGH :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_KNEE :
				return 1.0F;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT :
				return 1.0F;
			case Ke2Gems.GEMSTONE_LEFT_FOOT :
				return 1.0F;
		}
		return 1.0F;
	}
}