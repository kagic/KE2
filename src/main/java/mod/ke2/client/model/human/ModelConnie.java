package mod.ke2.client.model.human;

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
		this.bipedHead.addBox(-4.0F, -2.0F, -4.0F, 8, 8, 8);
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4.0F, -2.0F, -4.0F, 8, 8, 8, 0.5F);
		this.bipedBody = new ModelRenderer(this, 8, 16);
		this.bipedBody.addBox(-3.0F, 6.0F, -2.0F, 6, 8, 4);
		this.bipedSkirt = new ModelRenderer(this, 24, 28);
		this.bipedSkirt.addBox(-5.0F, 13.0F, -5.0F, 10, 8, 10);
		this.bipedRightArm = new ModelRenderer(this, 28, 16);
		this.bipedRightArm.addBox(0.0F, -2.0F, -1.0F, 2, 10, 2);
		this.bipedLeftArm = new ModelRenderer(this, 36, 16);
		this.bipedLeftArm.addBox(-2.0F, -2.0F, -1.0F, 2, 10, 2);
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.addBox(-3.0F, 2.0F, -1.0F, 2, 10, 2);
		this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg.addBox(1.0F, 2.0F, -1.0F, 2, 10, 2);
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