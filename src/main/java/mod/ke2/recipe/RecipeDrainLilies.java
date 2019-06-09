package mod.ke2.recipe;

import java.util.ArrayList;
import java.util.Arrays;

import mod.ke2.init.Ke2Blocks;
import mod.ke2.init.Ke2Items;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RecipeDrainLilies implements IRecipe {
	private ResourceLocation name;
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory) {
		for (int slot = 0; slot < inventory.getInventoryStackLimit(); ++slot) {
			if (!inventory.getStackInSlot(slot).isEmpty()) {
				Block block = Block.getBlockFromItem(inventory.getStackInSlot(slot).getItem());
				ItemStack stack = new ItemStack(Ke2Items.GEM_SHARD, 1);
				if (block == Ke2Blocks.MOSS_ROSE) {
					stack.setTagCompound(generateShard(0xe4679d, 13));
				}
				else if (block == Ke2Blocks.VALLEY_DRAIN_LILY) {
					stack.setTagCompound(generateShard(0xc6ba35, 13));
				}
				else if (block == Ke2Blocks.DESERT_DRAIN_LILY) {
					stack.setTagCompound(generateShard(0x8ba6d3, 13));
				}
				else if (block == Ke2Blocks.ALPINE_DRAIN_LILY) {
					stack.setTagCompound(generateShard(0x68c7cc, 13));
				}
				else if (block == Ke2Blocks.NETHER_DRAIN_LILY) {
					stack.setTagCompound(generateShard(0xe59f37, 13));
				}
				return stack;
			}
		}
        return ItemStack.EMPTY;
    }
	@Override
	public boolean matches(InventoryCrafting inventory, World world) {
		int lilies = 0;
        for (int y = 0; y < inventory.getHeight(); ++y) {
            for (int x = 0; x < inventory.getWidth(); ++x) {
            	ItemStack stack = inventory.getStackInRowAndColumn(x, y);
                Block block = Block.getBlockFromItem(stack.getItem());
            	if (block == Ke2Blocks.MOSS_ROSE) {
            		++lilies;
 				}
            	else if (block == Ke2Blocks.VALLEY_DRAIN_LILY) {
            		++lilies;
 				}
            	else if (block == Ke2Blocks.DESERT_DRAIN_LILY) {
            		++lilies;
 				}
            	else if (block == Ke2Blocks.ALPINE_DRAIN_LILY) {
            		++lilies;
 				}
            	else if (block == Ke2Blocks.NETHER_DRAIN_LILY) {
            		++lilies;
 				}
                else if (!stack.isEmpty()) {
                	return false;
                }
            }
        }
        return lilies == 1;
	}
	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}
	@Override
	public Class<IRecipe> getRegistryType() {
		return IRecipe.class;
	}
	@Override
	public boolean canFit(int width, int height) {
		return width + height >= 1;
	}
	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		this.name = name;
		return this;
	}
	@Override
	public ResourceLocation getRegistryName() {
		return name;
	}
	private static NBTTagCompound generateShard(int color, int variant) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("GemstoneColor", color);
		compound.setInteger("Variant", variant);
		return compound;
	}
}