package mod.ke2.items;

import mod.ke2.init.Ke2CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemStaff extends Item {
	public ItemGemStaff() {
		super();
		this.setUnlocalizedName("gem_staff");
		this.setCreativeTab(Ke2CreativeTabs.GEM_TECH);
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
	@SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
}