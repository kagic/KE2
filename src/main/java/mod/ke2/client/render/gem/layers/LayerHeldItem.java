package mod.ke2.client.render.gem.layers;

import mod.ke2.api.EntityGem;
import mod.ke2.client.render.RenderGem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerHeldItem implements LayerRenderer<EntityGem> {
	protected final RenderGem<?> renderer;
	
	public LayerHeldItem(RenderGem<?> renderer) {
		this.renderer = renderer;
	}
	
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		boolean righty = gem.getPrimaryHand() == EnumHandSide.RIGHT;
		ItemStack main = righty ? gem.getHeldItemOffhand() : gem.getHeldItemMainhand();
		ItemStack off = righty ? gem.getHeldItemMainhand() : gem.getHeldItemOffhand();
		if (!main.isEmpty() || !off.isEmpty()) {
			GlStateManager.pushMatrix();
			this.renderHeldItem(gem, off, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
			this.renderHeldItem(gem, main, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
			GlStateManager.popMatrix();
		}
	}
	
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
	
	private void renderHeldItem(EntityGem gem, ItemStack stack, ItemCameraTransforms.TransformType camera, EnumHandSide side) {
		if (!stack.isEmpty()) {
			GlStateManager.pushMatrix();
			if (gem.isSneaking()) {
				GlStateManager.translate(0.0F, 0.2F, 0.0F);
			}
			this.setSide(side);
			GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			boolean lefty = side == EnumHandSide.LEFT;
			GlStateManager.translate((lefty ? -1 : 1) / this.renderer.getModel().heldItemOffsetX, this.renderer.getModel().heldItemOffsetY, this.renderer.getModel().heldItemOffsetZ);
			Minecraft.getMinecraft().getItemRenderer().renderItemSide(gem, stack, camera, lefty);
			GlStateManager.popMatrix();
		}
	}
	
	protected void setSide(EnumHandSide side) {
		((ModelBiped) this.renderer.getMainModel()).postRenderArm(this.renderer.getModel().heldItemHandOffset, side);
	}
}
