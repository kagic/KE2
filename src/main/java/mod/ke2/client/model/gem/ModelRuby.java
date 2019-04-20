package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelRuby extends ModelGem {
	public ModelRuby() {
		super(0.0F, 0.0F, 64, 64, 4);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-7F, -4F, -4F, 14, 12, 8);
	    this.bipedHead.setRotationPoint(0F, 4F, 0F);
	    this.bipedBody = new ModelRenderer(this, 16, 20);
	    this.bipedBody.addBox(-4F, 8F, -2F, 8, 8, 4);
	    this.bipedBody.setRotationPoint(0F, 0F, 0F);
	    this.bipedRightArm = new ModelRenderer(this, 40, 32);
	    this.bipedRightArm.addBox(-3F, 0F, -2F, 4, 8, 4);
	    this.bipedRightArm.setRotationPoint(0F, 8F, 0F);
	    this.bipedLeftArm = new ModelRenderer(this, 40, 20);
	    this.bipedLeftArm.addBox(-1F, 0F, -2F, 4, 8, 4);
	    this.bipedLeftArm.setRotationPoint(0F, 8F, 0.0F);
	    this.bipedRightLeg = new ModelRenderer(this, 0, 20);
	    this.bipedRightLeg.addBox(-4F, 4F, -2F, 4, 8, 4);
	    this.bipedRightLeg.setRotationPoint(0F, 0F, 0F);
	    this.bipedLeftLeg = new ModelRenderer(this, 0, 32);
	    this.bipedLeftLeg.addBox(0F, 4F, -2F, 4, 8, 4);
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
}