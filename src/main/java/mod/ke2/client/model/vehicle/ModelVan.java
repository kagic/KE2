package mod.ke2.client.model.vehicle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVan extends ModelBase {
	public ModelRenderer cabin;
	public ModelRenderer hood;
	public ModelRenderer windshield;
	public ModelRenderer wheelFrontRight;
	public ModelRenderer wheelFrontLeft;
	public ModelRenderer wheelBackLeft;
	public ModelRenderer wheelBackRight;
	public ModelRenderer seats;
	
	public ModelVan() {
		this.textureWidth = 96;
		this.textureHeight = 112;
		this.cabin = new ModelRenderer(this, 0, 0);
		this.cabin.setRotationPoint(-5.0F, 1.0F, -6.0F);
		this.cabin.addBox(-10.0F, -10.0F, 0.0F, 20, 20, 26, 0.0F);
		this.hood = new ModelRenderer(this, 0, 64);
		this.hood.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hood.addBox(-10.0F, 0.0F, -6.0F, 20, 10, 6, -0.01F);
		this.cabin.addChild(this.hood);
		this.windshield = new ModelRenderer(this, 0, 46);
		this.windshield.setRotationPoint(0.0F, -10.0F, 0.0F);
		this.windshield.addBox(-10.0F, 0.0F, 0.0F, 20, 12, 6, -0.02F);
		this.cabin.addChild(this.windshield);
		this.wheelFrontRight = new ModelRenderer(this, 0, 0);
		this.wheelFrontRight.setRotationPoint(7.01F, 10.0F, 2.0F);
		this.wheelFrontRight.addBox(0.5F, -3.0F, -3.0F, 3, 6, 6, 0.0F);
		this.cabin.addChild(this.wheelFrontRight);
		this.wheelFrontLeft = new ModelRenderer(this, 0, 0);
		this.wheelFrontLeft.setRotationPoint(-7.01F, 10.0F, 2.0F);
		this.wheelFrontLeft.addBox(-3.5F, -3.0F, -3.0F, 3, 6, 6, 0.0F);
		this.cabin.addChild(this.wheelFrontLeft);
		this.wheelBackRight = new ModelRenderer(this, 0, 0);
		this.wheelBackRight.setRotationPoint(7.01F, 10.0F, 20.0F);
		this.wheelBackRight.addBox(0.5F, -3.0F, -3.0F, 3, 6, 6, 0.0F);
		this.cabin.addChild(this.wheelBackRight);
		this.wheelBackLeft = new ModelRenderer(this, 0, 0);
		this.wheelBackLeft.setRotationPoint(-7.01F, 10.0F, 20.0F);
		this.wheelBackLeft.addBox(-3.5F, -3.0F, -3.0F, 3, 6, 6, 0.0F);
		this.cabin.addChild(this.wheelBackLeft);
		this.seats = new ModelRenderer(this, 0, 80);
		this.seats.addBox(-10.0F, -10.0F, 1.0F, 20, 16, 10, -0.01F);
		this.cabin.addChild(this.seats);
	}
	
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headYaw, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headYaw, scale, entity);
		this.cabin.render(scale);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		this.windshield.rotateAngleX = -0.2617993877991494F;
		this.hood.rotateAngleX = 0.17453292519943295F;
		this.wheelFrontRight.rotateAngleX += entity.motionX + entity.motionZ;
		this.wheelFrontLeft.rotateAngleX += entity.motionX + entity.motionZ;
		this.wheelBackRight.rotateAngleX += entity.motionX + entity.motionZ;
		this.wheelBackLeft.rotateAngleX += entity.motionX + entity.motionZ;
	}
}
