package mod.ke2.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemShard extends Item {
	public ItemGemShard() {
		this.setUnlocalizedName("gem_shard");
		this.setMaxStackSize(64);
		this.addPropertyOverride(new ResourceLocation("variant"), new IItemPropertyGetter() {
			@Override
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, World world, EntityLivingBase entity) {
				if (stack.hasTagCompound()) {
					return stack.getTagCompound().getInteger("Variant") / 16.0F;
				}
				return 0.0F;
			}
		});
	}
}
