package mod.ke2.lib.neuron;

import mod.ke2.lib.Neuron;

public class InputNeuron extends Neuron {
	public void input(float output) {
        this.output = output;
    }
    public InputNeuron(int i) {
        super(i, true);
    }
    public InputNeuron() {
        super();
    }
}