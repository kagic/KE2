package mod.kagic.items;

import java.util.List;

import mod.kagic.entity.EntityGem;
import mod.kagic.entity.EntityGemShard;
import mod.kagic.entity.machine.EntityBubble;
import mod.kagic.init.KAGIC;
import mod.kagic.util.DamagePoofed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemDestabilizer extends ItemSword {
	public int color;
	public ItemGemDestabilizer(int index) {
		super(ToolMaterial.GOLD);
		String name = EnumDyeColor.byMetadata(index).toString().toLowerCase();
		this.setUnlocalizedName(name + "_gem_destabilizer");
		this.setMaxStackSize(1);
		this.setMaxDamage(24);
		this.setCreativeTab(KAGIC.CREATIVE_TAB);
		this.color = index;
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		player.swingArm(hand);
		if (!world.isRemote) {
			List<EntityItem> items = world.<EntityItem>getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos).grow(1, 1, 1));
			for (EntityItem item : items) {
				EntityBubble bubble = new EntityBubble(world);
				bubble.setColor(EntityGemShard.PARTICLE_COLORS[this.color]);
				bubble.setItem(item.getItem());
				bubble.setPosition(item.posX, item.posY, item.posZ);
				bubble.setHealth(0.5F);
				bubble.motionY = world.rand.nextDouble() / 2;
				bubble.playBubbleSound();
				item.setDead();
				world.spawnEntity(bubble);
			}
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
	}
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        if (target instanceof EntityGem) {
        	target.attackEntityFrom(new DamagePoofed(), target.getHealth());
        }
        return true;
    }
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entity) {
        if (state.getBlockHardness(world, pos) != 0.0F) {
            stack.damageItem(2, entity);
        }
        return true;
    }
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if (repair.getItem() instanceof ItemGemShard) {
			ItemGemShard shard = (ItemGemShard)(repair.getItem());
			return this.color == shard.color;
		}
		return false;
    }
    @Override
	@SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
}
