package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelPeridot extends ModelGem {
	private ModelRenderer bipedHeadsquare;
	public ModelPeridot() {
		super(0.0F, 0.0F, 64, 64, 4);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4F, -4F, -4F, 2, 2, 2);
	    this.bipedHead.setRotationPoint(0F, 0F, 0F);
		this.bipedHeadwear = new ModelRenderer(this, 2, 2);
		this.bipedHeadwear.addBox(-5.5F, -5.5F, -3.5F, 11, 11, 7);
	    this.bipedHeadwear.setRotationPoint(0F, 0F, 0F);
		this.bipedHeadsquare = new ModelRenderer(this, 0, 45);
		this.bipedHeadsquare.addBox(-7F, -8F, -3.49F, 14, 12, 7);
	    this.bipedHeadsquare.setRotationPoint(0F, 0F, 0F);
	    this.bipedBody = new ModelRenderer(this, 8, 20);
	    this.bipedBody.addBox(-3F, 4F, -2F, 6, 10, 4);
	    this.bipedBody.setRotationPoint(0F, 0F, 0F);
	    this.bipedRightArm = new ModelRenderer(this, 28, 20);
	    this.bipedRightArm.addBox(0F, -4F, -1F, 2, 10, 2);
	    this.bipedRightArm.setRotationPoint(0F, 8F, 0F);
	    this.bipedLeftArm = new ModelRenderer(this, 36, 20);
	    this.bipedLeftArm.addBox(-2F, -4F, -1F, 2, 10, 2);
	    this.bipedLeftArm.setRotationPoint(0F, 8F, 0F);
	    this.bipedRightLeg = new ModelRenderer(this, 0, 20);
	    this.bipedRightLeg.addBox(-3F, 2F, -1F, 2, 10, 2);
	    this.bipedRightLeg.setRotationPoint(0F, 8F, 0F);
	    this.bipedLeftLeg = new ModelRenderer(this, 0, 20);
	    this.bipedLeftLeg.addBox(1F, 2F, -1F, 2, 10, 2);
	    this.bipedLeftLeg.setRotationPoint(0F, 8F, 0F);
	    this.bipedHead.addChild(this.bipedHeadwear);
	    this.bipedHead.addChild(this.bipedHeadsquare);
	}
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
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
		this.bipedHeadwear.rotateAngleX = 0;
		this.bipedHeadwear.rotateAngleY = 0;
		this.bipedHeadwear.rotateAngleZ = 0.7853982f;
		this.bipedHead.offsetY = -0.2F;
	}
}