package mod.ke2.api.variants.types;

import java.util.ArrayList;
import java.util.Collections;

public class TagType implements Comparable<TagType> {
	private final int weight;
	private final String tag;
	public TagType(int weight, String tag) {
		this.weight = weight;
		this.tag = tag;
	}
	public int getWeight() {
		return this.weight;
	}
	public String getTag() {
		return this.tag;
	}
	public static TagType weigh(ArrayList<TagType> tags) {
		Collections.sort(tags);
		int volume = 0;
		for (int i = 0; i < tags.size(); ++i) {
			volume += tags.get(i).getWeight();
		}
		double random = Math.random() * volume;
		for (TagType tag : tags) {
			random -= tag.getWeight();
			if (random <= 0.0) {
				return tag;
			}
		}
		return null;
	}
	@Override
    public int compareTo(TagType tag) {
        return Integer.compare(this.getWeight(), tag.getWeight());
    }
}
