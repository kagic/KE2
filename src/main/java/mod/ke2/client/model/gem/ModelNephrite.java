package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNephrite extends ModelGem {
	public ModelNephrite() {
		super(0.0F, 0.0F, 64, 64, 4);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8);
		this.bipedHead.setRotationPoint(0F, 0F, 0F);
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4F, -8F, 0F, 8, 8, 8, 1.1F);
		this.bipedHeadwear.setRotationPoint(0F, 0F, 0F);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.addBox(-3F, 0F, -2F, 6, 12, 4);
		this.bipedBody.setRotationPoint(0F, 0F, 0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 16);
		this.bipedRightArm.addBox(0F, 0F, -1F, 2, 12, 2);
		this.bipedRightArm.setRotationPoint(0F, 0F, 0F);
		this.bipedLeftArm = new ModelRenderer(this, 0, 16);
		this.bipedLeftArm.addBox(-2F, 0F, -1F, 2, 12, 2);
		this.bipedLeftArm.setRotationPoint(0F, 0F, 0F);
		this.bipedLeftArm.mirror = true;
		this.bipedRightLeg = new ModelRenderer(this, 28, 16);
		this.bipedRightLeg.addBox(1F, 0F, -1F, 2, 12, 2);
		this.bipedRightLeg.setRotationPoint(0F, 12F, 0F);
		this.bipedLeftLeg = new ModelRenderer(this, 28, 16);
		this.bipedLeftLeg.addBox(-3F, 0F, -1F, 2, 12, 2);
		this.bipedLeftLeg.setRotationPoint(0F, 12F, 0F);
	}
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.bipedHead.render(scale);
		this.bipedHeadwear.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
	}
}