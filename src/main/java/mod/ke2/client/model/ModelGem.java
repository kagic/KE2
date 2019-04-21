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
	public ModelRenderer bipedGem;
	public final int gemSize;
	public float heldItemHandOffset;
	public float heldItemOffsetX;
	public float heldItemOffsetY;
	public float heldItemOffsetZ;
	public ModelGem(float modelSize, float offset, int width, int height, int gemSize) {
		super(modelSize, offset, width, height);
		this.gemSize = gemSize;
        this.bipedGem = new ModelRenderer(this, 0, 0);
        this.bipedGem.setRotationPoint(this.gemSize / 2, this.gemSize / 2, this.gemSize / 2);
        this.bipedGem.addBox(0.0F, 0.0F, 0.0F, this.gemSize, this.gemSize, this.gemSize);
    }
	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }
	@Override
	public void setLivingAnimations(EntityLivingBase entity, float limbSwingAmount, float ageInTicks, float partialTickTime) {
		this.rightArmPose = ModelBiped.ArmPose.EMPTY;
		this.leftArmPose = ModelBiped.ArmPose.EMPTY;
		if (entity instanceof EntityGem) {
			ItemStack stack = entity.getHeldItem(EnumHand.MAIN_HAND);
			EntityGem gem = (EntityGem)(entity);
			if (stack != null && stack.getItem() == Items.BOW && gem.isSwingingArms()) {
				if (gem.getPrimaryHand() == EnumHandSide.RIGHT) {
					this.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
				}
				else {
					this.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
				}
			}
			this.bipedGem.setRotationPoint(this.gemSize / 2, this.gemSize / 2, this.gemSize / 2);
			this.bipedGem.rotateAngleX = 0;
			this.bipedGem.rotateAngleY = 0;
			this.bipedGem.rotateAngleZ = 0;
			this.bipedGem.offsetX = 0;
			this.bipedGem.offsetY = 0;
			this.bipedGem.offsetZ = 0;
			switch (gem.getGemstonePlacement()) {
			case Ke2Gems.GEMSTONE_FOREHEAD:
				super.copyModelAngles(this.bipedHead, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_BACK_OF_HEAD:
				super.copyModelAngles(this.bipedHead, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_EYE:
				super.copyModelAngles(this.bipedHead, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_LEFT_EYE:
				super.copyModelAngles(this.bipedHead, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_NOSE:
				super.copyModelAngles(this.bipedHead, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_SHOULDER:
				super.copyModelAngles(this.bipedRightArm, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_LEFT_SHOULDER:
				super.copyModelAngles(this.bipedLeftArm, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_HAND:
				super.copyModelAngles(this.bipedRightArm, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_LEFT_HAND:
				super.copyModelAngles(this.bipedLeftArm, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_CHEST:
				super.copyModelAngles(this.bipedBody, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_BACK:
				super.copyModelAngles(this.bipedBody, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_NAVEL:
				super.copyModelAngles(this.bipedBody, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_THIGH:
				super.copyModelAngles(this.bipedRightLeg, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_LEFT_THIGH:
				super.copyModelAngles(this.bipedLeftLeg, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_KNEE:
				super.copyModelAngles(this.bipedRightLeg, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_LEFT_KNEE:
				super.copyModelAngles(this.bipedLeftLeg, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_RIGHT_FOOT:
				super.copyModelAngles(this.bipedRightLeg, this.bipedGem);
				break;
			case Ke2Gems.GEMSTONE_LEFT_FOOT:
				super.copyModelAngles(this.bipedLeftLeg, this.bipedGem);
				break;
			}
			switch (gem.getGemstoneDirection()) {
			case NORTH:
				this.bipedGem.rotateAngleY += 0.0000F;
				break;
			case SOUTH:
				this.bipedGem.rotateAngleY += 3.1415F;
				break;
			case EAST:
				this.bipedGem.rotateAngleY += 4.7123F;
				break;
			case WEST:
				this.bipedGem.rotateAngleY += 1.5708F;
				break;
			case UP:
				this.bipedGem.rotateAngleX += 0.0000F;
				break;
			case DOWN:
				this.bipedGem.rotateAngleX += 3.1415F;
				break;
			}
		}
		super.setLivingAnimations(entity, limbSwingAmount, ageInTicks, partialTickTime);
	}
}