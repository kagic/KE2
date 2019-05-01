package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSapphire extends ModelGem {
    public ModelSapphire() {
		super(0.0F, 0.0F, 96, 64, 4);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -6.0F, -4.0F, 8, 8, 8);
		this.bipedHead.offsetY = 0.25F;
	    this.bipedHeadwear = new ModelRenderer(this, 36, 0);
		this.bipedHeadwear.addBox(-5.0F, -6.0F, -4.0F, 8, 14, 8, 1.1F);
		this.bipedHeadwear.offsetY = 0.25F;
	    this.bipedRightArm = new ModelRenderer(this, 28, 16);
	    this.bipedRightArm.addBox(-1F, -2F, -1F, 2, 8, 2);
	    this.bipedRightArm.offsetY = 0.5F;
	    this.bipedLeftArm = new ModelRenderer(this, 28, 26);
	    this.bipedLeftArm.addBox(-1F, -2F, -1F, 2, 8, 2);
	    this.bipedLeftArm.offsetY = 0.5F;
	    this.bipedBody = new ModelRenderer(this, 0, 16);
	    this.bipedBody.addBox(-4.0F, 6.0F, -3.0F, 8, 8, 6);
	    this.bipedSkirt = new ModelRenderer(this, 0, 30);
	    this.bipedSkirt.addBox(-6.0F, 14.0F, -6.0F, 12, 10, 12);
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
	}
    @Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
	    super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
	    super.copyModelAngles(this.bipedHead, this.bipedHeadwear);
	    super.copyModelAngles(this.bipedBody, this.bipedSkirt);
	}
}