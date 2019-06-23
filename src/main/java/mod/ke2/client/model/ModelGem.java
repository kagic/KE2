package mod.ke2.client.model;

import mod.ke2.api.EntityGem;
import mod.ke2.init.Ke2Gems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGem extends ModelBiped {
	public ModelRenderer bipedCape;
	public ModelRenderer bipedSkirt;
	public float heldItemHandOffset;
	public float heldItemOffsetX;
	public float heldItemOffsetY;
	public float heldItemOffsetZ;
	public float flowerOffsetX;
	public float flowerOffsetY;
	public float flowerOffsetZ;

	public ModelGem(float modelSize, float offset, int width, int height) {
		super(modelSize, offset, width, height);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		if (entity instanceof EntityLivingBase) {
			this.setLivingAnimations((EntityLivingBase) entity, limbSwingAmount, ageInTicks, ageInTicks % 1.0F);
		}
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float limbSwingAmount, float ageInTicks, float partialTickTime) {
		this.rightArmPose = ModelBiped.ArmPose.EMPTY;
		this.leftArmPose = ModelBiped.ArmPose.EMPTY;
		if (entity instanceof EntityGem) {
			ItemStack stack = entity.getHeldItem(EnumHand.MAIN_HAND);
			EntityGem gem = (EntityGem) entity;
			if (stack != null && stack.getItem() == Items.BOW && gem.isSwingingArms()) {
				if (gem.getPrimaryHand() == EnumHandSide.RIGHT) {
					this.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
				} else {
					this.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
				}
			}
			if (gem.getEmotion() > 660.0F) {
				this.bipedRightArm.rotateAngleZ += (0.5 - gem.world.rand.nextDouble() / 2.0) * 0.1;
				this.bipedRightArm.rotateAngleX += (0.5 - gem.world.rand.nextDouble() / 2.0) * 0.1;
				this.bipedLeftArm.rotateAngleZ += (0.5 - gem.world.rand.nextDouble() / 2.0) * 0.1;
				this.bipedLeftArm.rotateAngleX += (0.5 - gem.world.rand.nextDouble() / 2.0) * 0.1;
			} else if (gem.getEmotionalState() == Ke2Gems.EMOTION_ROMANCE) {
				this.bipedRightArm.rotateAngleZ *= Math.sin(ageInTicks);
				this.bipedLeftArm.rotateAngleZ *= Math.cos(ageInTicks);
			}
			if (gem.getPose() == EntityGem.Pose.HEAD_BANGING) {
				this.bipedHead.rotateAngleX = (float) Math.sin(ageInTicks) / 5.0F;
			}
		}
		super.setLivingAnimations(entity, limbSwingAmount, ageInTicks, partialTickTime);
	}

	public void renderGemOnBody(int pos, float scale) {

	}
}