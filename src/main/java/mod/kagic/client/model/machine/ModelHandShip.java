package mod.kagic.client.model.machine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelHandShip extends ModelBase {
    public ModelRenderer wrist;
    public ModelRenderer hand;
    public ModelRenderer fingerThumb;
    public ModelRenderer fingerIndex;
    public ModelRenderer fingerMiddle;
    public ModelRenderer fingerRing;
    public ModelRenderer fingerPinky;
    public ModelRenderer tipThumb;
    public ModelRenderer tipIndex;
    public ModelRenderer tipMiddle;
    public ModelRenderer tipRing;
    public ModelRenderer tipPinky;

    public ModelHandShip() {
        this.textureWidth = 32; this.textureHeight = 8;
        this.fingerIndex = new ModelRenderer(this, 0, 6);
        this.fingerIndex.setRotationPoint(-4.0F, -0.5F, 1.5F);
        this.fingerIndex.addBox(-2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.tipThumb = new ModelRenderer(this, 6, 6);
        this.tipThumb.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.tipThumb.addBox(-2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.fingerRing = new ModelRenderer(this, 0, 6);
        this.fingerRing.setRotationPoint(-4.0F, -0.5F, -1.0F);
        this.fingerRing.addBox(-2.0F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
        this.fingerThumb = new ModelRenderer(this, 0, 6);
        this.fingerThumb.setRotationPoint(-1.0F, -0.5F, 2.5F);
        this.fingerThumb.addBox(-2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.hand = new ModelRenderer(this, 0, 0);
        this.hand.setRotationPoint(-2.0F, 0.5F, 0.4F);
        this.hand.addBox(-4.0F, -1.5F, -2.0F, 4, 2, 4, 0.0F);
        this.fingerPinky = new ModelRenderer(this, 0, 6);
        this.fingerPinky.setRotationPoint(-4.0F, -0.5F, -2.0F);
        this.fingerPinky.addBox(-2.0F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
        this.tipPinky = new ModelRenderer(this, 6, 6);
        this.tipPinky.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.tipPinky.addBox(-2.0F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
        this.tipMiddle = new ModelRenderer(this, 6, 6);
        this.tipMiddle.setRotationPoint(-3.0F, 0.0F, -0.5F);
        this.tipMiddle.addBox(-2.0F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
        this.tipIndex = new ModelRenderer(this, 6, 6);
        this.tipIndex.setRotationPoint(-2.0F, 0.0F, -0.5F);
        this.tipIndex.addBox(-2.0F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
        this.wrist = new ModelRenderer(this, 16, 1);
        this.wrist.setRotationPoint(5.3F, 23.0F, 0.0F);
        this.wrist.addBox(-2.0F, -1.0F, -1.0F, 2, 2, 3, 0.0F);
        this.fingerMiddle = new ModelRenderer(this, 0, 6);
        this.fingerMiddle.setRotationPoint(-3.0F, -0.5F, 0.5F);
        this.fingerMiddle.addBox(-3.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.tipRing = new ModelRenderer(this, 6, 6);
        this.tipRing.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.tipRing.addBox(-2.0F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
        this.hand.addChild(this.fingerIndex);
        this.fingerThumb.addChild(this.tipThumb);
        this.hand.addChild(this.fingerRing);
        this.hand.addChild(this.fingerThumb);
        this.wrist.addChild(this.hand);
        this.hand.addChild(this.fingerPinky);
        this.fingerPinky.addChild(this.tipPinky);
        this.fingerMiddle.addChild(this.tipMiddle);
        this.fingerIndex.addChild(this.tipIndex);
        this.hand.addChild(this.fingerMiddle);
        this.fingerRing.addChild(this.tipRing);
    }
    @Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
    	this.hand.rotateAngleZ = (float)(Math.toRadians(-15));
    	this.fingerThumb.rotateAngleY = (float)(Math.toRadians(30));
    	this.fingerThumb.rotateAngleZ = (float)(Math.toRadians(-25));
    	this.tipThumb.rotateAngleY = (float)(Math.toRadians(-40));
    	this.fingerIndex.rotateAngleY = (float)(Math.toRadians(15));
    	this.fingerIndex.rotateAngleZ = (float)(Math.toRadians(20));
    	this.tipIndex.rotateAngleZ = (float)(Math.toRadians(-60));
    	this.fingerMiddle.rotateAngleY = (float)(Math.toRadians(5));
    	this.fingerMiddle.rotateAngleZ = (float)(Math.toRadians(20));
    	this.tipMiddle.rotateAngleZ = (float)(Math.toRadians(-60));
    	this.fingerRing.rotateAngleY = (float)(Math.toRadians(-5));
    	this.fingerRing.rotateAngleZ = (float)(Math.toRadians(20));
    	this.tipRing.rotateAngleZ = (float)(Math.toRadians(-60));
    	this.fingerPinky.rotateAngleY = (float)(Math.toRadians(-15));
    	this.fingerPinky.rotateAngleZ = (float)(Math.toRadians(20));
    	this.tipPinky.rotateAngleZ = (float)(Math.toRadians(-60));
    }
    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headYaw, float scale) {
        this.wrist.render(scale);
    }
}