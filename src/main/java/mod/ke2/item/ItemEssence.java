package mod.ke2.item;

import net.minecraft.item.Item;

public class ItemEssence extends Item {
	public enum Color {
		RED("awkward"), ORANGE("prideful"), YELLOW("impulsive"), GREEN("jealous"),
		BLUE("obsessive"), VIOLET("dependent"), PINK("careless"), WHITE("anxious");
		private final String color;
		private Color(String color) {
			this.color = color;
		}
		public String getPrefix() {
			return this.color;
		}
	}
	private final Color color;
	public ItemEssence(Color color) {
		super();
		this.setUnlocalizedName(color.getPrefix() + "_essence");
		this.color = color;
	}
	public Color getColor() {
		return this.color;
	}
}