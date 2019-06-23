package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.entity.gem.EntityDesertGlass;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDesertGlass extends ModelGem {
	public ModelRenderer bipedJarBase;
	public ModelRenderer bipedJarNeck;
	public ModelRenderer bipedJarEdge;

	public ModelDesertGlass() {
		super(0.0F, 0.0F, 64, 128);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.bipedHead.offsetY = 0.5F;
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.addBox(-4.0F, 8.0F, -3.0F, 8, 8, 6, 0.0F);
		this.bipedJarBase = new ModelRenderer(this, 0, 78);
		this.bipedJarBase.addBox(-8.0F, -12.0F, 3.0F, 16, 32, 16, 0.0F);
		this.bipedJarNeck = new ModelRenderer(this, 8, 58);
		this.bipedJarNeck.addBox(-6.0F, -20.0F, 5.0F, 12, 8, 12, 0.0F);
		this.bipedJarBase.addChild(this.bipedJarNeck);
		this.bipedJarEdge = new ModelRenderer(this, 8, 36);
		this.bipedJarEdge.addBox(-8.0F, -26.0F, 3.0F, 16, 6, 16, 0.0F);
		this.bipedJarBase.addChild(this.bipedJarEdge);
		this.bipedRightArm = new ModelRenderer(this, 0, 26);
		this.bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.bipedRightArm.offsetY = 0.5F;
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.bipedLeftArm.offsetY = 0.5F;
		this.bipedRightLeg = new ModelRenderer(this, 36, 26);
		this.bipedRightLeg.addBox(1.0F, 4.0F, -1.0F, 2, 8, 2, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 36, 16);
		this.bipedLeftLeg.addBox(-3.0F, 4.0F, -1.0F, 2, 8, 2, 0.0F);
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
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
		if (entity instanceof EntityDesertGlass) {
			EntityDesertGlass gem = (EntityDesertGlass) entity;
			if (gem.hasJar()) {
				this.bipedJarBase.render(scaleFactor);
				this.bipedHead.offsetZ = -0.125F;
			}
		}
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