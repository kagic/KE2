package mod.ke2.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWarpWhistle extends Item {
	private static final int[] DEFAULT_WARP_WHISTLE_COLORS = new int[] { 
		0xeaeaea,
		0xe6c0a7,
		0xe694e6,
		0x9ccde7,
		0xe5dd70,
		0xc0e99d,
		0xdeb8ba,
		0xc0c0c0,
		0xd2d2d2,
		0x7adfe3,
		0xb98be5,
		0x0269b1,
		0xc2aba4,
		0xa0e589,
		0xe67b7f,
		0x828282
	};
	public ItemWarpWhistle() {
		super();
		this.setUnlocalizedName("warp_whistle");
		this.setMaxStackSize(1);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (!world.isRemote) {
			// TODO: example function
	        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		}
		player.swingArm(hand);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
	}
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
        	for (int i = 0; i < 16; ++i) {
	        	NBTTagCompound compound = new NBTTagCompound(); compound.setInteger("Color", DEFAULT_WARP_WHISTLE_COLORS[i]);
	        	ItemStack stack = new ItemStack(this);
	        	stack.setTagCompound(compound);
	            items.add(stack);
        	}
        }
    }
	@Override
	@SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
}