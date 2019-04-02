package mod.kagic.client.model.human;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelConnie extends ModelBiped {
	private ModelRenderer bipedSkirt;
	public ModelConnie() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4F, -2F, -4F, 8, 8, 8);
	    this.bipedHead.setRotationPoint(0F, 0F, 0F);
	    this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4F, -2F, -4F, 8, 8, 8, 1.1F);
	    this.bipedHeadwear.setRotationPoint(0F, 0F, 0F);
	    this.bipedBody = new ModelRenderer(this, 8, 16);
	    this.bipedBody.addBox(-3F, 6F, -2F, 6, 8, 4);
	    this.bipedBody.setRotationPoint(0F, 0F, 0F);
	    this.bipedSkirt = new ModelRenderer(this, 24, 28);
	    this.bipedSkirt.addBox(-5F, 13F, -5F, 10, 8, 10);
	    this.bipedSkirt.setRotationPoint(0F, 0F, 0F);
	    this.bipedRightArm = new ModelRenderer(this, 28, 16);
	    this.bipedRightArm.addBox(0F, -2F, -1F, 2, 10, 2);
	    this.bipedRightArm.setRotationPoint(0F, 8F, 0F);
	    this.bipedLeftArm = new ModelRenderer(this, 36, 16);
	    this.bipedLeftArm.addBox(-2F, -2F, -1F, 2, 10, 2);
	    this.bipedLeftArm.setRotationPoint(0F, 8F, 0F);
	    this.bipedRightLeg = new ModelRenderer(this, 0, 16);
	    this.bipedRightLeg.addBox(-3F, 2F, -1F, 2, 10, 2);
	    this.bipedRightLeg.setRotationPoint(0F, 0F, 0F);
	    this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
	    this.bipedLeftLeg.addBox(1F, 2F, -1F, 2, 10, 2);
	    this.bipedLeftLeg.setRotationPoint(0F, 0F, 0F);
    }
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.bipedHead.render(scale);
		this.bipedHeadwear.render(scale);
		this.bipedBody.render(scale);
		this.bipedSkirt.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		super.copyModelAngles(this.bipedBody, this.bipedSkirt);
	}
}