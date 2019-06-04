package mod.ke2.client.model.human;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSteven extends ModelGem {
	public ModelSteven() {
		super(0.0F, 0.0F, 64, 64);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8);
 		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
 		this.bipedHeadwear.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8, 0.5F);
	    this.bipedBody = new ModelRenderer(this, 16, 16);
	    this.bipedBody.addBox(-4.0F, 8.0F, -2.0F, 8, 8, 4);
	    this.bipedRightArm = new ModelRenderer(this, 40, 16);
	    this.bipedRightArm.addBox(-3.0F, 0.0F, -2.0F, 4, 8, 4);
	    this.bipedLeftArm = new ModelRenderer(this, 40, 28);
	    this.bipedLeftArm.addBox(-1.0F, 0.0F, -2.0F, 4, 8, 4);
	    this.bipedRightLeg = new ModelRenderer(this, 0, 16);
	    this.bipedRightLeg.addBox(0.0F, 4.0F, -2.0F, 4, 8, 4);
	    this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
	    this.bipedLeftLeg.addBox(-4.0F, 4.0F, -2.0F, 4, 8, 4);
    }
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		this.bipedHead.render(scale);
		this.bipedHeadwear.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
	}
}