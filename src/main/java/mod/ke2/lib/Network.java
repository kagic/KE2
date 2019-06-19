package mod.ke2.lib;

import java.util.ArrayList;

import mod.ke2.lib.neuron.HiddenNeuron;
import mod.ke2.lib.neuron.InputNeuron;
import mod.ke2.lib.neuron.OutputNeuron;

public class Network {
	public static final float LEARNING_CONSTANT = 0.5f;
	private InputNeuron[] input;
	private HiddenNeuron[] hidden;
	private OutputNeuron output;
	
	public Network(int inputs, int hiddentotal) {
		this.input = new InputNeuron[inputs];
		for (int i = 0; i < this.input.length - 1; ++i) {
			this.input[i] = new InputNeuron();
		}
		this.hidden = new HiddenNeuron[hiddentotal + 1];
		for (int i = 0; i < this.hidden.length - 1; ++i) {
			this.hidden[i] = new HiddenNeuron();
		}
		this.input[this.input.length - 1] = new InputNeuron(1);
		this.hidden[this.hidden.length - 1] = new HiddenNeuron(1);
		this.output = new OutputNeuron();
		for (int i = 0; i < this.input.length; ++i) {
			for (int j = 0; j < this.hidden.length - 1; ++j) {
				Connection connection = new Connection(this.input[i], this.hidden[j]);
				this.input[i].addConnection(connection);
				this.hidden[j].addConnection(connection);
			}
		}
		for (int i = 0; i < this.hidden.length; ++i) {
			Connection connection = new Connection(this.hidden[i], this.output);
			this.hidden[i].addConnection(connection);
			this.output.addConnection(connection);
		}
		
	}
	
	public float feedForward(float[] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			this.input[i].input(inputs[i]);
		}
		for (int i = 0; i < this.hidden.length - 1; i++) {
			this.hidden[i].calcOutput();
		}
		this.output.calcOutput();
		return this.output.getOutput();
	}
	
	public float train(float[] inputs, float answer) {
		float result = this.feedForward(inputs);
		float delta = result * (1 - result) * (answer - result);
		ArrayList<Connection> connections = this.output.getConnections();
		for (int i = 0; i < connections.size(); ++i) {
			Connection connection = connections.get(i);
			Neuron neuron = connection.getFrom();
			float output = neuron.getOutput();
			float weight = output * delta;
			connection.adjustWeight(Network.LEARNING_CONSTANT * weight);
		}
		for (int i = 0; i < this.hidden.length; ++i) {
			connections = this.hidden[i].getConnections();
			float sum = 0;
			for (int j = 0; j < connections.size(); ++j) {
				Connection connection = connections.get(j);
				if (connection.getFrom() == this.hidden[i]) {
					sum += connection.getWeight() * delta;
				}
			}
			for (int j = 0; j < connections.size(); ++j) {
				Connection connection = connections.get(j);
				if (this.hidden[i].equals(connection.getTo())) {
					float output = this.hidden[i].getOutput();
					float hidden = output * (1 - output) * sum;
					Neuron neuron = connection.getFrom();
					float weight = neuron.getOutput() * hidden;
					connection.adjustWeight(Network.LEARNING_CONSTANT * weight);
				}
			}
		}
		return result;
	}
}