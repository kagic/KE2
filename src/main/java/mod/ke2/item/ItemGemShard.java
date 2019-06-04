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
	public static final int[] DEFAULT_GEM_SHARD_COLORS = new int[] {
		0xffffff,
		0xfdc84d,
		0xeb3dfe,
		0xceedf4,
		0xf4e900,
		0xb6feab,
		0xf8c2eb,
		0x9aa4af,
		0xdddddd,
		0xa8dcdf,
		0xb185cf,
		0xa0b7eb,
		0xe9d5c9,
		0x2ed6a8,
		0xfd4813,
		0x2e2941
	};
	public ItemGemShard() {
		this.setUnlocalizedName("gem_shard");
		this.setMaxStackSize(64);
        this.addPropertyOverride(new ResourceLocation("variant"), new IItemPropertyGetter() {
            @Override
			@SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, World world, EntityLivingBase entity) {
                if (stack.hasTagCompound()) {
                	return (stack.getTagCompound().getInteger("Variant")) / 16.0F;
                }
                return world.rand.nextFloat();
            }
        });
	}
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
        	for (int i = 0; i < 16; ++i) {
        		for (int color : ItemGemShard.DEFAULT_GEM_SHARD_COLORS) {
        			NBTTagCompound compound = new NBTTagCompound();
		        	compound.setInteger("GemstoneColor", color);
		        	compound.setInteger("Variant", i);
		        	ItemStack stack = new ItemStack(this);
		        	stack.setTagCompound(compound);
		            items.add(stack);
        		}
        	}
        }
    }
}
