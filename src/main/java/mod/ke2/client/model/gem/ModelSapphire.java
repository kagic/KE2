package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSapphire extends ModelGem {
    public ModelSapphire() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -6.0F, -4.0F, 8, 8, 8);
		this.bipedHead.offsetY = 0.25F;
	    this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4.0F, -2.0F, -4.0F, 8, 14, 8, 0.5F);
		this.bipedHeadwear.offsetY = -0.25F;
		this.bipedHead.addChild(this.bipedHeadwear);
	    this.bipedRightArm = new ModelRenderer(this, 0, 16);
	    this.bipedRightArm.addBox(0.0F, -2.0F, -1.0F, 2, 8, 2);
	    this.bipedRightArm.offsetY = 0.5F;
	    this.bipedLeftArm = new ModelRenderer(this, 0, 26);
	    this.bipedLeftArm.addBox(-2.0F, -2.0F, -1.0F, 2, 8, 2);
	    this.bipedLeftArm.offsetY = 0.5F;
	    this.bipedBody = new ModelRenderer(this, 12, 16);
	    this.bipedBody.addBox(-3.0F, 6.0F, -3.0F, 6, 8, 6);
	    this.bipedSkirt = new ModelRenderer(this, 0, 30);
	    this.bipedSkirt.addBox(-6.0F, 14.0F, -6.0F, 12, 10, 12);
	    this.bipedBody.addChild(this.bipedSkirt);
    }
    @Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
	}
    @Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
	    super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
	    this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
	}
	@Override
	public void renderGemOnBody(int pos, float scale) {
		switch (pos) {
			case Ke2Gems.GEMSTONE_FOREHEAD:
				break;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD:
				break;
			case Ke2Gems.GEMSTONE_RIGHT_EYE:
				break;
			case Ke2Gems.GEMSTONE_LEFT_EYE:
				break;
			case Ke2Gems.GEMSTONE_NOSE:
				break;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER:
				break;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER:
				break;
			case Ke2Gems.GEMSTONE_RIGHT_HAND:
				break;
			case Ke2Gems.GEMSTONE_LEFT_HAND:
				break;
			case Ke2Gems.GEMSTONE_CHEST:
				break;
			case Ke2Gems.GEMSTONE_BACK:
				break;
			case Ke2Gems.GEMSTONE_NAVEL:
				break;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH:
				break;
			case Ke2Gems.GEMSTONE_LEFT_THIGH:
				break;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE:
				break;
			case Ke2Gems.GEMSTONE_LEFT_KNEE:
				break;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT:
				break;
			case Ke2Gems.GEMSTONE_LEFT_FOOT:
				break;
		}
	}
}