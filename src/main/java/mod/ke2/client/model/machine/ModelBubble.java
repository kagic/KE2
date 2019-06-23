package mod.ke2.client.model.machine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelBubble extends ModelBase {
	public ModelRenderer anteLat1;
	public ModelRenderer simmLat1;
	public ModelRenderer postLat1;
	public ModelRenderer anteLat2;
	public ModelRenderer simmLat2;
	public ModelRenderer postLat2;
	public ModelRenderer anteLat3;
	public ModelRenderer simmLat3;
	public ModelRenderer postLat3;
	public ModelRenderer anteLat4;
	public ModelRenderer simmLat4;
	public ModelRenderer postLat4;
	public ModelRenderer corner1;
	public ModelRenderer corner2;
	public ModelRenderer corner3;
	public ModelRenderer corner4;
	public ModelRenderer bottom;
	public ModelRenderer top;

	public ModelBubble() {
		this.textureHeight = 16;
		this.textureWidth = 24;
		this.anteLat1 = new ModelRenderer(this, 0, 0);
		this.anteLat1.addBox(-4, -5, 4, 8, 1, 1);
		this.anteLat1.setRotationPoint(0, 0, 0);
		this.simmLat1 = new ModelRenderer(this, 0, 0);
		this.simmLat1.addBox(-4, -4, 5, 8, 8, 1);
		this.simmLat1.setRotationPoint(0, 0, 0);
		this.postLat1 = new ModelRenderer(this, 0, 0);
		this.postLat1.addBox(-4, 4, 4, 8, 1, 1);
		this.postLat1.setRotationPoint(0, 0, 0);
		this.anteLat2 = new ModelRenderer(this, 0, 0);
		this.anteLat2.addBox(-4, -5, -5, 8, 1, 1);
		this.anteLat2.setRotationPoint(0, 0, 0);
		this.simmLat2 = new ModelRenderer(this, 0, 0);
		this.simmLat2.addBox(-4, -4, -6, 8, 8, 1);
		this.simmLat2.setRotationPoint(0, 0, 0);
		this.postLat2 = new ModelRenderer(this, 0, 0);
		this.postLat2.addBox(-4, 4, -5, 8, 1, 1);
		this.postLat2.setRotationPoint(0, 0, 0);
		this.anteLat3 = new ModelRenderer(this, 0, 0);
		this.anteLat3.addBox(-5, -5, -4, 1, 1, 8);
		this.anteLat3.setRotationPoint(0, 0, 0);
		this.simmLat3 = new ModelRenderer(this, 0, 0);
		this.simmLat3.addBox(-6, -4, -4, 1, 8, 8);
		this.simmLat3.setRotationPoint(0, 0, 0);
		this.postLat3 = new ModelRenderer(this, 0, 0);
		this.postLat3.addBox(-5, 4, -4, 1, 1, 8);
		this.postLat3.setRotationPoint(0, 0, 0);
		this.anteLat4 = new ModelRenderer(this, 0, 0);
		this.anteLat4.addBox(4, -5, -4, 1, 1, 8);
		this.anteLat4.setRotationPoint(0, 0, 0);
		this.simmLat4 = new ModelRenderer(this, 0, 0);
		this.simmLat4.addBox(5, -4, -4, 1, 8, 8);
		this.simmLat4.setRotationPoint(0, 0, 0);
		this.postLat4 = new ModelRenderer(this, 0, 0);
		this.postLat4.addBox(4, 4, -4, 1, 1, 8);
		this.postLat4.setRotationPoint(0, 0, 0);
		this.corner1 = new ModelRenderer(this, 0, 0);
		this.corner1.addBox(4, -4, -5, 1, 8, 1);
		this.corner1.setRotationPoint(0, 0, 0);
		this.corner2 = new ModelRenderer(this, 0, 0);
		this.corner2.addBox(-5, -4, -5, 1, 8, 1);
		this.corner2.setRotationPoint(0, 0, 0);
		this.corner3 = new ModelRenderer(this, 0, 0);
		this.corner3.addBox(4, -4, 4, 1, 8, 1);
		this.corner3.setRotationPoint(0, 0, 0);
		this.corner4 = new ModelRenderer(this, 0, 0);
		this.corner4.addBox(-5, -4, 4, 1, 8, 1);
		this.corner4.setRotationPoint(0, 0, 0);
		this.bottom = new ModelRenderer(this, 0, 0);
		this.bottom.addBox(-4, -6, -4, 8, 1, 8);
		this.bottom.setRotationPoint(0, 0, 0);
		this.top = new ModelRenderer(this, 0, 0);
		this.top.addBox(-4, 5, -4, 8, 1, 8);
		this.top.setRotationPoint(0, 0, 0);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		GlStateManager.pushMatrix();
		GlStateManager.translate(0, 1.28, 0);
		GlStateManager.scale(0.5, 0.5, 0.5);
		GlStateManager.rotate(ageInTicks, 1, 1, 1);
		this.anteLat1.render(scale);
		this.simmLat1.render(scale);
		this.postLat1.render(scale);
		this.anteLat2.render(scale);
		this.simmLat2.render(scale);
		this.postLat2.render(scale);
		this.anteLat3.render(scale);
		this.simmLat3.render(scale);
		this.postLat3.render(scale);
		this.anteLat4.render(scale);
		this.simmLat4.render(scale);
		this.postLat4.render(scale);
		this.corner1.render(scale);
		this.corner2.render(scale);
		this.corner3.render(scale);
		this.corner4.render(scale);
		this.bottom.render(scale);
		this.top.render(scale);
		GlStateManager.popMatrix();
	}
}