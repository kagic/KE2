package mod.ke2.items;

import mod.ke2.client.gui.GUIManual;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemManual extends Item{
	
	public ItemManual() {
		super();
		this.setUnlocalizedName("manual");
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote){
			playerIn.sendMessage(new TextComponentString("Used"));
		}else{
			Minecraft.getMinecraft().displayGuiScreen(new GUIManual());
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
}
