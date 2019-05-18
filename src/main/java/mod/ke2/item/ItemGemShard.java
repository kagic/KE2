package mod.ke2.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemShard extends Item {
	public ItemGemShard() {
		this.setUnlocalizedName("gem_shard");
		this.setMaxStackSize(64);
        this.addPropertyOverride(new ResourceLocation("variant"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, World world, EntityLivingBase entity) {
                if (stack.hasTagCompound()) {
                	return (float)(stack.getTagCompound().getInteger("Variant")) / 16.0F;
                }
                return world.rand.nextFloat();
            }
        });
	}
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
        	for (int i = 0; i < 16; ++i) {
	        	NBTTagCompound compound = new NBTTagCompound();
	        	compound.setInteger("Variant", i);
	        	ItemStack stack = new ItemStack(this);
	        	stack.setTagCompound(compound);
	            items.add(stack);
        	}
        }
    }
}
