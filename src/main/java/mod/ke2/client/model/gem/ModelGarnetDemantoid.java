package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGarnetDemantoid extends ModelGem {
	public ModelRenderer bipedNeck;
    public ModelGarnetDemantoid() {
		super(0.0F, 0.0F, 64, 64);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedHead.offsetY = -0.5625F;
        this.bipedHeadwear = new ModelRenderer(this, 90, 0);
		this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 16, 8, 0.5F);
		this.bipedHead.addChild(this.bipedHeadwear);
        this.bipedRightArm = new ModelRenderer(this, 0, 20);
        this.bipedRightArm.addBox(-2.0F, 2.0F, -1.5F, 3, 16, 3, 0.0F);
        this.bipedRightArm.offsetY = -0.5F;
        this.bipedLeftArm = new ModelRenderer(this, 0, 20);
        this.bipedLeftArm.addBox(-1.0F, 2.0F, -1.5F, 3, 16, 3, 0.0F);
        this.bipedLeftArm.offsetY = -0.5F;
        this.bipedBody = new ModelRenderer(this, 12, 20);
        this.bipedBody.addBox(-4.0F, -6.0F, -3.0F, 8, 10, 6, 0.0F);
        this.bipedNeck = new ModelRenderer(this, 0, 38);
        this.bipedNeck.addBox(-1.5F, -9.0F, -1.5F, 3, 3, 3);
        this.bipedBody.addChild(this.bipedNeck);
        this.bipedSkirt = new ModelRenderer(this, 0, 38);
        this.bipedSkirt.addBox(-5.0F, 4.0F, -5.0F, 10, 20, 10, 0.0F);
        this.bipedBody.addChild(this.bipedSkirt);
    }
    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    	this.bipedHead.render(scale);
    	this.bipedRightArm.render(scale);
    	this.bipedLeftArm.render(scale);
		this.bipedBody.render(scale);
    }
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
	}
}