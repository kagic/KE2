package mod.ke2.items;

import java.util.List;

import javax.annotation.Nullable;

import mod.ke2.client.gui.GuiManual;
import mod.ke2.init.Ke2Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemManual extends Item{
	
	
	public static final String[] manualArray = new String[] {"1"};
	
	
	
	public ItemManual() {
		super();
		this.setUnlocalizedName("manual");
		this.setMaxStackSize(1);
        this.addPropertyOverride(new ResourceLocation("using"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
	}
	
	int metadata;
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote){
			//Used to have some text, but was used for debugging.
		}else{
			Minecraft.getMinecraft().displayGuiScreen(new GuiManual());
			
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Welcome to Kindergartening 101!");
		tooltip.add("Activate me to begin your journey.");
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
