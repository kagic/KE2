package mod.ke2.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class ItemTablet extends Item{
	
	public ItemTablet() {
		super();
		this.setUnlocalizedName("tablet");
		this.setMaxStackSize(1);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		//playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("kagic.tablet_use")));
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
