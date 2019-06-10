package mod.ke2.client.model.gem;

import mod.ke2.client.model.ModelGem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelJadeBell extends ModelGem {
	public ModelRenderer bipedRightPart;
	public ModelRenderer bipedLeftPart;
	public ModelRenderer bipedRightEar;
	public ModelRenderer bipedLeftEar;
	public ModelRenderer bipedRightBun;
	public ModelRenderer bipedLeftBun;
	public ModelRenderer bipedBottomBun;
	public ModelJadeBell() {
		super(0.0F, 0.0F, 64, 80);
        this.bipedHead = new ModelRenderer(this, 8, 22);
        this.bipedHead.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedHead.offsetY = -0.125F;
        this.bipedRightEar = new ModelRenderer(this, 30, 48);
        this.bipedRightEar.setRotationPoint(-3.0F, -9.0F, -2.0F);
        this.bipedRightEar.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 4, 0.0F);
        this.bipedHead.addChild(this.bipedRightEar);
        this.bipedLeftEar = new ModelRenderer(this, 30, 48);
        this.bipedLeftEar.setRotationPoint(3.0F, -9.0F, -2.0F);
        this.bipedLeftEar.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 4, 0.0F);
        this.bipedHead.addChild(this.bipedLeftEar);
        this.bipedRightBun = new ModelRenderer(this, 44, 26);
        this.bipedRightBun.setRotationPoint(-4.0F, -4.0F, 0.0F);
        this.bipedRightBun.addBox(-4.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
        this.bipedHead.addChild(this.bipedRightBun);
        this.bipedLeftBun = new ModelRenderer(this, 32, 22);
        this.bipedLeftBun.setRotationPoint(4.0F, -4.0F, 0.0F);
        this.bipedLeftBun.addBox(0.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
        this.bipedHead.addChild(this.bipedLeftBun);
        this.bipedBottomBun = new ModelRenderer(this, 36, 34);
        this.bipedBottomBun.setRotationPoint(0.0F, -8.0F, 2.5F);
        this.bipedBottomBun.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 4, 0.0F);
        this.bipedHead.addChild(this.bipedBottomBun);
        this.bipedRightPart = new ModelRenderer(this, 0, 46);
        this.bipedRightPart.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedRightPart.addBox(-5.0F, -9.0F, -5.0F, 10, 16, 10, 0.0F);
        this.bipedHead.addChild(this.bipedRightPart);
        this.bipedLeftPart = new ModelRenderer(this, 0, 38);
        this.bipedLeftPart.setRotationPoint(0.0F, -8.0F, -4.0F);
        this.bipedLeftPart.addBox(-4.0F, 0.0F, -1.0F, 8, 4, 1, 0.0F);
        this.bipedHead.addChild(this.bipedLeftPart);
		this.bipedBody = new ModelRenderer(this, 0, 0);
        this.bipedBody.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 10, 4, 0.0F);
        this.bipedSkirt = new ModelRenderer(this, 24, 0);
        this.bipedSkirt.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.bipedSkirt.addBox(-5.0F, 0.0F, -3.0F, 10, 16, 6, 0.0F);
        this.bipedBody.addChild(this.bipedSkirt);
        this.bipedLeftArm = new ModelRenderer(this, 0, 14);
        this.bipedLeftArm.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.bipedBody.addChild(this.bipedLeftArm);
        this.bipedRightArm = new ModelRenderer(this, 8, 14);
        this.bipedRightArm.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.bipedRightArm.addBox(-1.0F, 0.0F, 0.0F, 2, 12, 2, 0.0F);
        this.bipedBody.addChild(this.bipedRightArm);
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
		this.bipedRightEar.mirror = true;
	}
}