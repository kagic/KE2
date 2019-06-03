package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAquamarine extends ModelGem {
	public ModelRenderer bipedLeftWing;
	public ModelRenderer bipedRightWing;
	public ModelAquamarine() {
		super(0.0F, 0.0F, 64, 64, 4);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-3.0F, 0.0F, -3.0F, 6, 6, 6);
	    this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-5F, 0F, -3F, 10, 6, 6, 1.1F);
		//this.bipedHead.addChild(this.bipedHeadwear);
	    this.bipedBody = new ModelRenderer(this, 8, 16);
	    this.bipedBody.addBox(-2.0F, 6.0F, -2.0F, 4, 4, 4);
	    this.bipedSkirt = new ModelRenderer(this, 24, 24);
	    this.bipedSkirt.addBox(-5F, 15F, -5F, 10, 8, 10);
	    this.bipedBody.addChild(this.bipedSkirt);
		this.bipedRightWing = new ModelRenderer(this, -1, 42);
        this.bipedRightWing.addBox(-4F, 6F, 1F, 10, 10, 1);
        this.bipedRightWing.setRotationPoint(-5F, 0.5F, 0F);
		this.bipedLeftWing = new ModelRenderer(this, -1, 53);
		this.bipedLeftWing.addBox(2F, 8F, -5F, 10, 10, 1);
		this.bipedLeftWing.setRotationPoint(-5F, 0.5F, 0F);
	    this.bipedRightArm = new ModelRenderer(this, 28, 16);
	    this.bipedRightArm.addBox(0F, 0F, -1F, 2, 6, 2);
	    this.bipedRightArm.setRotationPoint(0F, 8F, 0F);
	    this.bipedLeftArm = new ModelRenderer(this, 36, 16);
	    this.bipedLeftArm.addBox(-2F, 0F, -1F, 2, 6, 2);
	    this.bipedLeftArm.setRotationPoint(0F, 8F, 0F);
	    this.bipedRightLeg = new ModelRenderer(this, 0, 16);
	    this.bipedRightLeg.addBox(-3F, 10F, -1F, 2, 4, 2);
	    this.bipedRightLeg.setRotationPoint(0F, 0F, 0F);
	    this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
	    this.bipedLeftLeg.addBox(1F, 10F, -1F, 2, 4, 2);
	    this.bipedLeftLeg.setRotationPoint(0F, 0F, 0F);
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
		super.copyModelAngles(this.bipedBody, this.bipedSkirt);
		this.bipedRightWing.rotationPointZ = 2.0F;
        this.bipedLeftWing.rotationPointZ = 2.0F;
        this.bipedRightWing.rotationPointY = 1.0F;
        this.bipedLeftWing.rotationPointY = 1.0F;
        this.bipedRightWing.rotateAngleY = 0.47123894F + MathHelper.cos(ageInTicks * 0.8F) * (float)(Math.PI) * 0.05F;
        this.bipedLeftWing.rotateAngleY = -this.bipedRightWing.rotateAngleY;
        this.bipedLeftWing.rotateAngleZ = -0.47123894F;
        this.bipedLeftWing.rotateAngleX = 0.47123894F;
        this.bipedRightWing.rotateAngleX = 0.47123894F;
        this.bipedRightWing.rotateAngleZ = 0.47123894F;
	}
}