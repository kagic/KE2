package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPearl extends ModelGem {
    public ModelRenderer bipedSkirt;
    public ModelRenderer bipedNose;
    public ModelRenderer bipedLeftSleeve;
    public ModelRenderer bipedRightSleeve;
    public ModelPearl() {
		super(0.0F, 0.0F, 64, 64, 4);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 1.1F);
        this.bipedNose = new ModelRenderer(this, 24, 0);
        this.bipedNose.setRotationPoint(0.0F, -2.5F, -4.0F);
        this.bipedNose.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.setRotationPoint(4.0F, -6.0F, 0.0F);
        this.bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 16, 2, 0.0F);
        this.bipedLeftSleeve = new ModelRenderer(this, 0, 42);
        this.bipedLeftSleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedLeftSleeve.addBox(-1.0F, -2.0F, -2.0F, 4, 20, 4, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.setRotationPoint(-4.0F, -6.0F, 0.0F);
        this.bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 16, 2, 0.0F);
        this.bipedRightSleeve = new ModelRenderer(this, 0, 42);
        this.bipedRightSleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedRightSleeve.addBox(-3.0F, -2.0F, -2.0F, 4, 20, 4, 0.0F);
        this.bipedBody = new ModelRenderer(this, 0, 16);
        this.bipedBody.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.bipedBody.addBox(-3.0F, -6.0F, -2.0F, 6, 8, 4, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 40, 34);
        this.bipedLeftLeg.setRotationPoint(1.8F, 2.0F, 0.0F);
        this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 16, 2, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 40, 34);
        this.bipedRightLeg.setRotationPoint(-1.8F, 2.0F, 0.0F);
        this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 16, 2, 0.0F);
        this.bipedSkirt = new ModelRenderer(this, 32, 42);
        this.bipedSkirt.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.bipedSkirt.addBox(-4.0F, 0.0F, -4.0F, 8, 16, 8, 0.0F);
        this.bipedBody.addChild(this.bipedLeftArm);
        this.bipedBody.addChild(this.bipedHead);
        this.bipedLeftArm.addChild(this.bipedLeftSleeve);
        this.bipedBody.addChild(this.bipedRightArm);
        this.bipedHead.addChild(this.bipedNose);
        this.bipedBody.addChild(this.bipedSkirt);
        this.bipedRightArm.addChild(this.bipedRightSleeve);
        this.bipedBody.addChild(this.bipedLeftLeg);
        this.bipedBody.addChild(this.bipedRightLeg);
        this.bipedHead.addChild(this.bipedHeadwear);
    }
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.bipedBody.render(scale);
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
	}
}
