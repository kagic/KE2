package mod.kagic.client.model;

import java.util.ArrayList;

import mod.kagic.entity.EntityGemFusion;
import mod.kagic.init.AmGems;
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
public class ModelGemFusion extends ModelBiped {
	public ArrayList<ModelRenderer> bipedGems = new ArrayList<ModelRenderer>();
	public ModelRenderer bipedCape;
	public final int[] gemSizes;
	public ModelGemFusion(float modelSize, float offset, int width, int height, int... gemSizes) {
		super(modelSize, offset, width, height);
		this.gemSizes = gemSizes;
		for (int i = 0; i < this.gemSizes.length; ++i) {
			ModelRenderer gem = new ModelRenderer(this, 0, 0);
			gem.setTextureSize(this.gemSizes[i] * 4, this.gemSizes[i] * 2);
			gem.setRotationPoint(this.gemSizes[i] / 2, this.gemSizes[i] / 2, this.gemSizes[i] / 2);
			gem.addBox(0.0F, 0.0F, 0.0F, this.gemSizes[i], this.gemSizes[i], this.gemSizes[i]);
			this.bipedGems.add(gem);
		}
    }
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		for (int i = 0; i < this.bipedGems.size(); ++i) {
			this.bipedGems.get(i).render(scale);
		}
    }
	@Override
	public void setLivingAnimations(EntityLivingBase entity, float limbSwingAmount, float ageInTicks, float partialTickTime) {
		this.rightArmPose = ModelBiped.ArmPose.EMPTY;
		this.leftArmPose = ModelBiped.ArmPose.EMPTY;
		if (entity instanceof EntityGemFusion) {
			ItemStack stack = entity.getHeldItem(EnumHand.MAIN_HAND);
			EntityGemFusion gem = (EntityGemFusion)(entity);
			if (stack != null && stack.getItem() == Items.BOW && gem.getSwingingArms()) {
				if (gem.getPrimaryHand() == EnumHandSide.RIGHT) {
					this.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
				}
				else {
					this.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
				}
			}
			for (int i = 0; i < this.bipedGems.size(); ++i) {
		        this.bipedGems.get(i).setRotationPoint(this.gemSizes[i] / 2, this.gemSizes[i] / 2, this.gemSizes[i] / 2);
				this.bipedGems.get(i).rotateAngleX = 0;
				this.bipedGems.get(i).rotateAngleY = 0;
				this.bipedGems.get(i).rotateAngleZ = 0;
				this.bipedGems.get(i).offsetX = 0;
				this.bipedGems.get(i).offsetY = 0;
				this.bipedGems.get(i).offsetZ = 0;
				switch (gem.getGemstonePosition(i)) {
				case AmGems.GEMSTONE_FOREHEAD:
					super.copyModelAngles(this.bipedHead, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_BACK_OF_HEAD:
					super.copyModelAngles(this.bipedHead, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_RIGHT_EYE:
					super.copyModelAngles(this.bipedHead, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_LEFT_EYE:
					super.copyModelAngles(this.bipedHead, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_NOSE:
					super.copyModelAngles(this.bipedHead, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_RIGHT_SHOULDER:
					super.copyModelAngles(this.bipedRightArm, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_LEFT_SHOULDER:
					super.copyModelAngles(this.bipedLeftArm, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_RIGHT_HAND:
					super.copyModelAngles(this.bipedRightArm, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_LEFT_HAND:
					super.copyModelAngles(this.bipedLeftArm, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_CHEST:
					super.copyModelAngles(this.bipedBody, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_BACK:
					super.copyModelAngles(this.bipedBody, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_NAVEL:
					super.copyModelAngles(this.bipedBody, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_RIGHT_THIGH:
					super.copyModelAngles(this.bipedRightLeg, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_LEFT_THIGH:
					super.copyModelAngles(this.bipedLeftLeg, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_RIGHT_KNEE:
					super.copyModelAngles(this.bipedRightLeg, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_LEFT_KNEE:
					super.copyModelAngles(this.bipedLeftLeg, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_RIGHT_FOOT:
					super.copyModelAngles(this.bipedRightLeg, this.bipedGems.get(i));
					break;
				case AmGems.GEMSTONE_LEFT_FOOT:
					super.copyModelAngles(this.bipedLeftLeg, this.bipedGems.get(i));
					break;
				}
				switch (gem.getGemstoneDirection(i)) {
				case NORTH:
					this.bipedGems.get(i).rotateAngleY += 0.0000F;
					break;
				case SOUTH:
					this.bipedGems.get(i).rotateAngleY += 3.1415F;
					break;
				case EAST:
					this.bipedGems.get(i).rotateAngleY += 4.7123F;
					break;
				case WEST:
					this.bipedGems.get(i).rotateAngleY += 1.5708F;
					break;
				case UP:
					this.bipedGems.get(i).rotateAngleX += 0.0000F;
					break;
				case DOWN:
					this.bipedGems.get(i).rotateAngleX += 3.1415F;
					break;
				}
			}
		}
		super.setLivingAnimations(entity, limbSwingAmount, ageInTicks, partialTickTime);
	}
}