package mod.ke2.client.render;

import org.lwjgl.opengl.GL11;

import mod.ke2.tileentity.TileEntityWarpPadCore;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class WarpRenderer extends TileEntitySpecialRenderer<TileEntityWarpPadCore> {
	private static final ResourceLocation WARP_STREAM_TEXTURE = new ResourceLocation("ke2:textures/blocks/warp.png");
	private static final double STREAM_HEIGHT = 6.0;
	
	private void renderVertex(BufferBuilder renderer, double x, double y, double z, double u, double v) {
		renderer.pos(x, y, z).tex(u, v).color(1.0f, 1.0f, 1.0f, 0.75f).lightmap(0, 255).endVertex();
	}

	@Override
	public void render(TileEntityWarpPadCore pad, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		if (pad.isWarping() && pad.isValidPad()) {
			Tessellator tessellator = Tessellator.getInstance();
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y + 1.0, z);
			GlStateManager.enableBlend();
			GlStateManager.enableAlpha();
			GL11.glDisable(GL11.GL_LIGHTING);
			GlStateManager.disableCull();
			GlStateManager.depthMask(false);
			GlStateManager.enableDepth();
			GlStateManager.enableTexture2D();
			this.bindTexture(WARP_STREAM_TEXTURE);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

			BufferBuilder renderer = tessellator.getBuffer();

			double offset = -1.0;
			double progress = pad.renderCooldown > 0 ? 0 : ((double) pad.renderTicks / (double) pad.warpTicks) - partialTicks / (double) pad.warpTicks;
			double height = WarpRenderer.STREAM_HEIGHT - progress * WarpRenderer.STREAM_HEIGHT;
			
			renderer.begin(GL11.GL_QUADS, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
			renderVertex(renderer,		offset,	   height - 1,		offset,	1, 0.5);
			renderVertex(renderer,	1 - offset,	   height - 1,		offset,	0, 0.5);
			renderVertex(renderer,	1 - offset,				0,		offset,	0, 1.0);
			renderVertex(renderer, 		offset, 			0,		offset,	1, 1.0);
			renderVertex(renderer,	1 - offset,    height - 1,	1 - offset, 1, 0.5);
			renderVertex(renderer,		offset,    height - 1,	1 - offset, 0, 0.5);
			renderVertex(renderer,		offset, 			0,	1 - offset, 0, 1.0);
			renderVertex(renderer,	1 - offset, 			0,	1 - offset, 1, 1.0);
			renderVertex(renderer,		offset,    height - 1, 	1 - offset, 1, 0.5);
			renderVertex(renderer,		offset,    height - 1, 		offset, 0, 0.5);
			renderVertex(renderer,		offset,				0, 		offset, 0, 1.0);
			renderVertex(renderer,		offset,				0,	1 - offset, 1, 1.0);
			renderVertex(renderer,	1 - offset,	   height - 1,		offset, 1, 0.5);
			renderVertex(renderer,	1 - offset,    height - 1,	1 - offset, 0, 0.5);
			renderVertex(renderer,	1 - offset, 			0,	1 - offset, 0, 1.0);
			renderVertex(renderer,	1 - offset,				0,		offset, 1, 1.0);
			renderVertex(renderer,		offset,		   height,		offset, 1, 0.0);
			renderVertex(renderer,	1 - offset,		   height, 		offset, 0, 0.0);
			renderVertex(renderer,	1 - offset,	   height - 1, 		offset, 0, 0.5);
			renderVertex(renderer,		offset,	   height - 1, 		offset, 1, 0.5);
			renderVertex(renderer,	1 - offset, 	   height,	1 - offset, 1, 0.0);
			renderVertex(renderer,		offset, 	   height,	1 - offset, 0, 0.0);
			renderVertex(renderer,		offset,	   height - 1,	1 - offset, 0, 0.5);
			renderVertex(renderer,	1 - offset,    height - 1,	1 - offset, 1, 0.5);
			renderVertex(renderer, 		offset,		   height,	1 - offset, 1, 0.0);
			renderVertex(renderer, 		offset,		   height,		offset, 0, 0.0);
			renderVertex(renderer,		offset,    height - 1,		offset, 0, 0.5);
			renderVertex(renderer,		offset,    height - 1,	1 - offset, 1, 0.5);
			renderVertex(renderer,	1 - offset,		   height,		offset, 1, 0.0);
			renderVertex(renderer,	1 - offset,		   height,	1 - offset, 0, 0.0);
			renderVertex(renderer,	1 - offset,    height - 1,	1 - offset, 0, 0.5);
			renderVertex(renderer,	1 - offset,    height - 1,		offset, 1, 0.5);
			tessellator.draw();
			
			if (pad.renderTicks > 0) {
				--pad.renderTicks;
			}
			if (pad.renderCooldown > 0) {
				--pad.renderCooldown;
			}
			if (pad.renderTicks == 0 && pad.renderCooldown == 0) {
				pad.renderCooldown = pad.warpCooldownTicks;
			}
			
			GlStateManager.depthMask(true);
			GlStateManager.enableLighting();
			GlStateManager.popMatrix();
		}
	}
}
