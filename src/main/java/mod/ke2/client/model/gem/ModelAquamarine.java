package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import mod.ke2.entity.gem.EntityAquamarine;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAquamarine extends ModelGem {
	public ModelRenderer bipedLeftWing;
	public ModelRenderer bipedRightWing;
	public ModelAquamarine() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
		this.bipedHead.offsetY = 0.75F;
	    this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-5.0F, 6.0F, -3.0F, 10, 6, 6, 1.1F);
		this.bipedHeadwear.offsetY = -0.75F;
		this.bipedHead.addChild(this.bipedHeadwear);
	    this.bipedRightArm = new ModelRenderer(this, 28, 16);
	    this.bipedRightArm.addBox(3.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
	    this.bipedRightArm.offsetY = 0.64F;
	    this.bipedLeftArm = new ModelRenderer(this, 36, 16);
	    this.bipedLeftArm.addBox(-5.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
	    this.bipedLeftArm.offsetY = 0.64F;
	    this.bipedBody = new ModelRenderer(this, 8, 16);
	    this.bipedBody.addBox(-2.0F, 12.0F, -2.0F, 4, 4, 4, 0.0F);
		this.bipedRightWing = new ModelRenderer(this, -1, 42);
        this.bipedRightWing.addBox(-11.0F, 10.0F, 2.0F, 10, 10, 1, 0.0F);
		this.bipedLeftWing = new ModelRenderer(this, -1, 53);
		this.bipedLeftWing.addBox(1.0F, 10.0F, 2.0F, 10, 10, 1, 0.0F);
	    this.bipedSkirt = new ModelRenderer(this, 24, 24);
	    this.bipedSkirt.addBox(-4.0F, 16.0F, -4.0F, 8, 6, 8, 0.0F);
	    this.bipedBody.addChild(this.bipedSkirt);
	    this.bipedRightLeg = new ModelRenderer(this, 0, 16);
	    this.bipedRightLeg.addBox(-3.0F, 10.0F, -1.0F, 2, 4, 2, 0.0F);
	    this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
	    this.bipedLeftLeg.addBox(1.0F, 10.0F, -1.0F, 2, 4, 2, 0.0F);
    }
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
		if (entity instanceof EntityAquamarine) {
			EntityAquamarine gem = (EntityAquamarine)(entity);
			if (gem.isWinged()) {
				this.bipedRightWing.render(scale);
				this.bipedLeftWing.render(scale);
			}
		}
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
		this.bipedRightArm.rotateAngleZ = 0.75F;
		this.bipedLeftArm.rotateAngleZ = -0.75F;
		this.bipedHeadwear.rotateAngleX = 0.0F;
		this.bipedHeadwear.rotateAngleY = 0.0F;
	}
	@Override
	public void setLivingAnimations(EntityLivingBase entity, float limbSwingAmount, float ageInTicks, float partialTickTime) {
		super.setLivingAnimations(entity, limbSwingAmount, ageInTicks, partialTickTime);
        this.bipedRightWing.rotateAngleY = MathHelper.cos(ageInTicks * 0.8F) * (float)(Math.PI) * 0.05F;
        this.bipedLeftWing.rotateAngleY = -this.bipedRightWing.rotateAngleY;
	}
}