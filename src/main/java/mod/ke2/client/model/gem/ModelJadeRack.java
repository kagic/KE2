package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelJadeRack extends ModelGem {
	public ModelRenderer bipedRightPart;
	public ModelRenderer bipedLeftPart;
	public ModelRenderer bipedHair;
	public ModelRenderer bipedCog0;
	public ModelRenderer bipedCog1;
	public ModelJadeRack() {
		super(0.0F, 0.0F, 64, 80);
        this.bipedHead = new ModelRenderer(this, 24, 20);
        this.bipedHead.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedHead.offsetY = -0.125F;
        this.bipedHair = new ModelRenderer(this, 24, 8);
        this.bipedHair.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.bipedHair.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
        this.bipedHead.addChild(this.bipedHair);
        this.bipedBody = new ModelRenderer(this, 0, 0);
        this.bipedBody.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 10, 4, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 50, 14);
        this.bipedRightArm.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.bipedRightArm.addBox(0.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.bipedRightPart = new ModelRenderer(this, 32, 0);
        this.bipedRightPart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedRightPart.addBox(-3.0F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.bipedRightArm.addChild(this.bipedRightPart);
        this.bipedBody.addChild(this.bipedRightArm);
        this.bipedLeftArm = new ModelRenderer(this, 50, 0);
        this.bipedLeftArm.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bipedLeftArm.addBox(-2.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.bipedBody.addChild(this.bipedLeftArm);
        this.bipedLeftPart = new ModelRenderer(this, 20, 0);
        this.bipedLeftPart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedLeftPart.addBox(0.0F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.bipedLeftArm.addChild(this.bipedLeftPart);
        this.bipedSkirt = new ModelRenderer(this, 0, 14);
        this.bipedSkirt.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.bipedSkirt.addBox(-3.0F, 0.0F, -3.0F, 6, 16, 6, 0.0F);
        this.bipedBody.addChild(this.bipedSkirt);
		this.bipedCog0 = new ModelRenderer(this, 0, 36);
        this.bipedCog0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedCog0.addBox(-4.0F, 0.0F, -4.0F, 8, 16, 8, 0.0F);
        this.bipedSkirt.addChild(this.bipedCog0);
        this.bipedCog1 = new ModelRenderer(this, 32, 36);
        this.bipedCog1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedCog1.addBox(-4.0F, 0.0F, -4.0F, 8, 16, 8, 0.0F);
        this.bipedSkirt.addChild(this.bipedCog1);
    }
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netbipedHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netbipedHeadYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedBody.render(scale);
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netbipedHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netbipedHeadYaw, headPitch, scaleFactor, entity);
        this.bipedCog0.rotateAngleY = 0.7853981633974483F;
	}
}