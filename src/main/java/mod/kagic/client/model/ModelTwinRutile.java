package mod.kagic.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTwinRutile extends ModelGem {
	public ModelRenderer bipedOtherHead;
	public ModelRenderer bipedOtherHeadwear;
	public ModelRenderer bipedLeftTorso;
	public ModelRenderer bipedRightTorso;
	public ModelTwinRutile() {
		super(0.0F, 0.0F, 64, 64, 4);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-8F, -4F, -4F, 8, 10, 8);
		this.bipedHead.setRotationPoint(0F, 0F, 0F);
        this.bipedOtherHead = new ModelRenderer(this, 0, 0);
		this.bipedOtherHead.addBox(0F, -4F, -4F, 8, 10, 8);
		this.bipedOtherHead.setRotationPoint(0F, 0F, 0F);
		this.bipedRightArm = new ModelRenderer(this, 0, 18);
		this.bipedRightArm.addBox(-2F, 2F, -1F, 2, 12, 2);
		this.bipedRightArm.setRotationPoint(0F, 0F, 0F);
		this.bipedLeftArm = new ModelRenderer(this, 0, 18);
		this.bipedLeftArm.addBox(0F, 2F, -1F, 2, 12, 2);
		this.bipedLeftArm.setRotationPoint(0F, 0F, 0F);
		this.bipedRightLeg = new ModelRenderer(this, 28, 18);
		this.bipedRightLeg.addBox(1F, 0F, -1F, 2, 12, 2);
		this.bipedRightLeg.setRotationPoint(0F, 12F, 0F);
		this.bipedLeftLeg = new ModelRenderer(this, 28, 18);
		this.bipedLeftLeg.addBox(-3F, 0F, -1F, 2, 12, 2);
		this.bipedLeftLeg.setRotationPoint(0F, 12F, 0F);
        this.bipedLeftTorso = new ModelRenderer(this, 9, 18);
        this.bipedLeftTorso.mirror = true;
        this.bipedLeftTorso.addBox(-5.0F, 6.0F, -2.0F, 5, 10, 4, 0.0F);
        this.bipedLeftTorso.setRotationPoint(-1.3F, -4.2F, 0.0F);
        this.bipedLeftTorso.addChild(this.bipedHead);
        this.bipedRightTorso = new ModelRenderer(this, 9, 18);
        this.bipedRightTorso.addBox(0.0F, 6.0F, -2.0F, 5, 10, 4, 0.0F);
        this.bipedRightTorso.setRotationPoint(1.3F, -4.2F, 0.0F);
        this.bipedRightTorso.addChild(this.bipedOtherHead);
        this.bipedBody = new ModelRenderer(this, 8, 28);
        this.bipedBody.addBox(-3.0F, 4.0F, -2.0F, 6, 2, 4);
        this.bipedBody.setRotationPoint(0.0F, 6.0F, 0.0F);
	}
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.bipedOtherHead.rotateAngleX = headPitch * 0.017453292F;
		this.bipedOtherHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.bipedLeftTorso.rotateAngleZ = -0.1F;
		this.bipedRightTorso.rotateAngleZ = 0.1F;
		this.bipedHeadwear.render(scale);
		this.bipedLeftTorso.render(scale);
		this.bipedRightTorso.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
	}
}
