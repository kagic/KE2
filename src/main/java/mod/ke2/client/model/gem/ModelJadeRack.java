package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelJadeRack extends ModelGem {
	public ModelRenderer bipedRightPart;
	public ModelRenderer bipedLeftPart;
	public ModelRenderer bipedHair;
	public ModelRenderer bipedCog0;
	public ModelRenderer bipedCog1;

	public ModelJadeRack() {
		super(0.0F, 0.0F, 64, 80);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.bipedHead.offsetY = -0.125F;
		this.bipedHair = new ModelRenderer(this, 32, 4);
		this.bipedHair.setRotationPoint(0.0F, -8.0F, 0.0F);
		this.bipedHair.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
		this.bipedHead.addChild(this.bipedHair);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 10, 4, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 30);
		this.bipedRightArm.setRotationPoint(-3.0F, 0.0F, 0.0F);
		this.bipedRightArm.addBox(0.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedRightPart = new ModelRenderer(this, 12, 52);
		this.bipedRightPart.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightPart.addBox(-3.0F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
		this.bipedRightArm.addChild(this.bipedRightPart);
		this.bipedBody.addChild(this.bipedRightArm);
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.setRotationPoint(3.0F, 0.0F, 0.0F);
		this.bipedLeftArm.addBox(-2.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
		this.bipedBody.addChild(this.bipedLeftArm);
		this.bipedLeftPart = new ModelRenderer(this, 0, 52);
		this.bipedLeftPart.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftPart.addBox(0.0F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
		this.bipedLeftArm.addChild(this.bipedLeftPart);
		this.bipedSkirt = new ModelRenderer(this, 0, 58);
		this.bipedSkirt.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.bipedSkirt.addBox(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F);
		this.bipedBody.addChild(this.bipedSkirt);
		this.bipedCog0 = new ModelRenderer(this, 24, 32);
		this.bipedCog0.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedCog0.addBox(-4.0F, 0.0F, -4.0F, 8, 16, 8, 0.0F);
		this.bipedSkirt.addChild(this.bipedCog0);
		this.bipedCog1 = new ModelRenderer(this, 24, 56);
		this.bipedCog1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedCog1.addBox(-4.0F, 0.0F, -4.0F, 8, 16, 8, 0.0F);
		this.bipedSkirt.addChild(this.bipedCog1);
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
		this.bipedCog0.rotateAngleY = 0.7853981633974483F;
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