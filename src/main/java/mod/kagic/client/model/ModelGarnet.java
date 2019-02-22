package mod.kagic.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGarnet extends ModelGem {
    public ModelRenderer bipedLeftCalve;
    public ModelRenderer bipedRightCalve;
    public ModelRenderer bipedCape;
    public ModelRenderer bipedCapeBack;
    public ModelRenderer bipedHips;
    public ModelGarnet() {
		super(0F, 0F, 64, 64, 6);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.addBox(-6.0F, -12.0F, -4.0F, 12, 12, 8, 0.0F);
        this.bipedCape = new ModelRenderer(this, 0, 38);
        this.bipedCape.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.bipedCape.addBox(-8.0F, 0.0F, 0.0F, 16, 22, 0, 0.0F);
        this.bipedCapeBack = new ModelRenderer(this, 32, 38);
        this.bipedCapeBack.setRotationPoint(0.0F, 0.0F, 0.03F);
        this.bipedCapeBack.addBox(-8.0F, 0.0F, 0.0F, 16, 22, 0, 0.0F);
        this.bipedBody = new ModelRenderer(this, 12, 20);
        this.bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 8, 4, 0.0F);
        this.bipedHips = new ModelRenderer(this, 8, 32);
        this.bipedHips.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.bipedHips.addBox(-5.0F, 0.0F, -2.0F, 10, 2, 4, 0.0F);
        this.bipedRightCalve = new ModelRenderer(this, 40, 9);
        this.bipedRightCalve.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.bipedRightCalve.addBox(-4.0F, 0.0F, -1.5F, 3, 12, 3, 0.0F);
        this.bipedLeftCalve = new ModelRenderer(this, 40, 9);
        this.bipedLeftCalve.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.bipedLeftCalve.addBox(1.0F, 0.0F, -1.5F, 3, 12, 3, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 40, 0);
        this.bipedRightLeg.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.bipedRightLeg.addBox(-5.0F, 0.0F, -2.0F, 5, 5, 4, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 40, 0);
        this.bipedLeftLeg.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.bipedLeftLeg.addBox(0.0F, 0.0F, -2.0F, 5, 5, 4, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 0, 20);
        this.bipedRightArm.setRotationPoint(-4.0F, 2.0F, 0.0F);
        this.bipedRightArm.addBox(-3.0F, -2.0F, -1.5F, 3, 12, 3, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 0, 20);
        this.bipedLeftArm.setRotationPoint(4.0F, 2.0F, 0.0F);
        this.bipedLeftArm.addBox(0.0F, -2.0F, -1.5F, 3, 12, 3, 0.0F);
        this.bipedCape.addChild(this.bipedCapeBack);
        this.bipedHips.addChild(this.bipedRightLeg);
        this.bipedRightLeg.addChild(this.bipedRightCalve);
        this.bipedBody.addChild(this.bipedCape);
        this.bipedBody.addChild(this.bipedLeftArm);
        this.bipedLeftLeg.addChild(this.bipedLeftCalve);
        this.bipedHips.addChild(this.bipedLeftLeg);
        this.bipedBody.addChild(this.bipedRightArm);
        this.bipedBody.addChild(this.bipedHips);
        this.bipedBody.addChild(this.bipedHead);
    }
    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    	this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
    	super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); 
    	this.bipedRightArm.mirror = true;
    	this.bipedLeftArm.mirror = false;
    	this.bipedBody.render(scale);
    }
}