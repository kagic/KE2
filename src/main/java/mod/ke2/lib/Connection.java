package mod.ke2.lib;

public class Connection {
	private float weight;
	private Neuron from;
	private Neuron to;

	public Connection(Neuron from, Neuron to, float weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public Connection(Neuron from, Neuron to) {
		this(from, to, (float) (Math.random() * 2 - 1));
	}

	public Neuron getFrom() {
		return this.from;
	}

	public Neuron getTo() {
		return this.to;
	}

	public float getWeight() {
		return this.weight;
	}

	public void adjustWeight(float delta) {
		this.weight += delta;
	}
}