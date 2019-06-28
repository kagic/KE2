package mod.ke2.recipe;

import mod.ke2.init.Ke2Items;
import mod.ke2.item.ItemEssence;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RecipeEssences implements IRecipe {
	private ResourceLocation name;

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory) {
		int i = 0;
		ItemEssence[] items = new ItemEssence[2];
		for (int slot = 0; slot < inventory.getInventoryStackLimit(); ++slot) {
			if (inventory.getStackInSlot(slot).getItem() instanceof ItemEssence) {
				items[i] = (ItemEssence) inventory.getStackInSlot(slot).getItem();
				++i;
			}
		}
		if (items[0] == Ke2Items.ANXIOUS_ESSENCE) {
			if (items[1] == Ke2Items.AWKWARD_ESSENCE) {
				return new ItemStack(Ke2Items.AWKWARD_ESSENCE, 2);
			}
			if (items[1] == Ke2Items.PRIDEFUL_ESSENCE) {
				return new ItemStack(Ke2Items.PRIDEFUL_ESSENCE, 2);
			}
			if (items[1] == Ke2Items.IMPULSIVE_ESSENCE) {
				return new ItemStack(Ke2Items.IMPULSIVE_ESSENCE, 2);
			}
			if (items[1] == Ke2Items.JEALOUS_ESSENCE) {
				return new ItemStack(Ke2Items.JEALOUS_ESSENCE, 2);
			}
			if (items[1] == Ke2Items.OBSESSIVE_ESSENCE) {
				return new ItemStack(Ke2Items.OBSESSIVE_ESSENCE, 2);
			}
			if (items[1] == Ke2Items.DEPENDENT_ESSENCE) {
				return new ItemStack(Ke2Items.DEPENDENT_ESSENCE, 2);
			}
			if (items[1] == Ke2Items.CARELESS_ESSENCE) {
				return new ItemStack(Ke2Items.CARELESS_ESSENCE, 2);
			}
		}
		if (items[1] == Ke2Items.ANXIOUS_ESSENCE) {
			if (items[0] == Ke2Items.AWKWARD_ESSENCE) {
				return new ItemStack(Ke2Items.AWKWARD_ESSENCE, 2);
			}
			if (items[0] == Ke2Items.PRIDEFUL_ESSENCE) {
				return new ItemStack(Ke2Items.PRIDEFUL_ESSENCE, 2);
			}
			if (items[0] == Ke2Items.IMPULSIVE_ESSENCE) {
				return new ItemStack(Ke2Items.IMPULSIVE_ESSENCE, 2);
			}
			if (items[0] == Ke2Items.JEALOUS_ESSENCE) {
				return new ItemStack(Ke2Items.JEALOUS_ESSENCE, 2);
			}
			if (items[0] == Ke2Items.OBSESSIVE_ESSENCE) {
				return new ItemStack(Ke2Items.OBSESSIVE_ESSENCE, 2);
			}
			if (items[0] == Ke2Items.DEPENDENT_ESSENCE) {
				return new ItemStack(Ke2Items.DEPENDENT_ESSENCE, 2);
			}
			if (items[0] == Ke2Items.CARELESS_ESSENCE) {
				return new ItemStack(Ke2Items.CARELESS_ESSENCE, 2);
			}
		}
		if (items[0] == Ke2Items.IMPULSIVE_ESSENCE) {
			if (items[1] == Ke2Items.OBSESSIVE_ESSENCE) {
				return new ItemStack(Ke2Items.JEALOUS_ESSENCE, 2);
			}
			if (items[1] == Ke2Items.CARELESS_ESSENCE) {
				return new ItemStack(Ke2Items.PRIDEFUL_ESSENCE, 2);
			}
		}
		if (items[1] == Ke2Items.IMPULSIVE_ESSENCE) {
			if (items[0] == Ke2Items.OBSESSIVE_ESSENCE) {
				return new ItemStack(Ke2Items.JEALOUS_ESSENCE, 2);
			}
			if (items[0] == Ke2Items.CARELESS_ESSENCE) {
				return new ItemStack(Ke2Items.PRIDEFUL_ESSENCE, 2);
			}
		}
		if (items[0] == Ke2Items.OBSESSIVE_ESSENCE) {
			if (items[1] == Ke2Items.CARELESS_ESSENCE) {
				return new ItemStack(Ke2Items.DEPENDENT_ESSENCE, 2);
			}
		}
		if (items[1] == Ke2Items.OBSESSIVE_ESSENCE) {
			if (items[0] == Ke2Items.CARELESS_ESSENCE) {
				return new ItemStack(Ke2Items.DEPENDENT_ESSENCE, 2);
			}
		}
		if (items[0] == Ke2Items.JEALOUS_ESSENCE) {
			if (items[1] == Ke2Items.PRIDEFUL_ESSENCE) {
				return new ItemStack(Ke2Items.AWKWARD_ESSENCE, 2);
			}
		}
		if (items[1] == Ke2Items.JEALOUS_ESSENCE) {
			if (items[0] == Ke2Items.PRIDEFUL_ESSENCE) {
				return new ItemStack(Ke2Items.AWKWARD_ESSENCE, 2);
			}
		}
		return ItemStack.EMPTY;
	}

	@Override
	public boolean matches(InventoryCrafting inventory, World world) {
		int essences = 0;
		for (int y = 0; y < inventory.getHeight(); ++y) {
			for (int x = 0; x < inventory.getWidth(); ++x) {
				ItemStack stack = inventory.getStackInRowAndColumn(x, y);
				if (stack.getItem() instanceof ItemEssence) {
					++essences;
				} else if (!stack.isEmpty()) {
					return false;
				}
			}
		}
		return essences == 2;
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
		return width + height >= 2;
	}

	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		this.name = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName() {
		return this.name;
	}
}