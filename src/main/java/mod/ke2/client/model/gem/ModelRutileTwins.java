package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRutileTwins extends ModelGem {
	public ModelRenderer bipedOtherHead;
	public ModelRenderer bipedOtherHeadwear;
	public ModelRenderer bipedLeftTorso;
	public ModelRenderer bipedRightTorso;
	public ModelRutileTwins() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-8.0F, -6.0F, -4.0F, 8, 8, 8);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-8.0F, -10.0F, -5.0F, 8, 4, 9, 0.1F);
        this.bipedHead.addChild(this.bipedHeadwear);
        this.bipedOtherHead = new ModelRenderer(this, 0, 0);
		this.bipedOtherHead.addBox(0.0F, -6.0F, -4.0F, 8, 8, 8);
        this.bipedOtherHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedOtherHeadwear.addBox(0.0F, -10.0F, -5.0F, 8, 4, 9, 0.1F);
        this.bipedOtherHead.addChild(this.bipedOtherHeadwear);
		this.bipedRightArm = new ModelRenderer(this, 0, 18);
		this.bipedRightArm.addBox(-3.0F, -2.0F, -1.0F, 2, 14, 2);
		this.bipedLeftArm = new ModelRenderer(this, 0, 18);
		this.bipedLeftArm.addBox(1.0F, -2.0F, -1.0F, 2, 14, 2);
		this.bipedRightLeg = new ModelRenderer(this, 28, 18);
		this.bipedRightLeg.addBox(1.0F, -2.0F, -1.0F, 2, 14, 2);
		this.bipedLeftLeg = new ModelRenderer(this, 28, 18);
		this.bipedLeftLeg.addBox(-3.0F, -2.0F, -1.0F, 2, 14, 2);
        this.bipedLeftTorso = new ModelRenderer(this, 9, 18);
        this.bipedLeftTorso.mirror = true;
        this.bipedLeftTorso.addBox(-5.0F, 2.0F, -2.0F, 5, 12, 4, 0.0F);
        this.bipedLeftTorso.setRotationPoint(-1.3F, -4.2F, 0.0F);
        this.bipedLeftTorso.addChild(this.bipedHead);
        this.bipedRightTorso = new ModelRenderer(this, 9, 18);
        this.bipedRightTorso.addBox(0.0F, 2.0F, -2.0F, 5, 12, 4, 0.0F);
        this.bipedRightTorso.setRotationPoint(1.3F, -4.2F, 0.0F);
        this.bipedRightTorso.addChild(this.bipedOtherHead);
        this.bipedBody = new ModelRenderer(this, 8, 28);
        this.bipedBody.addBox(-3.0F, 8.0F, -2.0F, 6, 2, 4);
	}
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedLeftTorso.render(scale);
		this.bipedRightTorso.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.bipedOtherHead.rotateAngleX = headPitch * 0.017453292F;
		this.bipedOtherHead.rotateAngleY = netHeadYaw * 0.017453292F;
		this.bipedOtherHeadwear.rotateAngleX = 0.0F;
		this.bipedOtherHeadwear.rotateAngleY = 0.0F;
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
		this.bipedLeftTorso.rotateAngleZ = -0.1F;
		this.bipedRightTorso.rotateAngleZ = 0.1F;
	}
}
