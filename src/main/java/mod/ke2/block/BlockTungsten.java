package mod.ke2.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTungsten extends Block {
	public BlockTungsten(String ore) {
		super(Material.ROCK);
		this.setUnlocalizedName(ore + "_ore");
		this.setResistance(3);
		this.setHardness(2);
	}
}
