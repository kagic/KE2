package mod.kagic.lib;

import java.util.ArrayList;

public class Neuron {
	public static float factor(float x) {
        return 1.0f / (1.0f + (float)(Math.exp(-x)));
    }
    protected ArrayList<Connection> connections;
    protected boolean bias = false;
    protected float output;
    public Neuron(int output, boolean bias) {
        connections = new ArrayList<Connection>();
        this.output = output;
        this.bias = bias;
    }
    public Neuron() {
        this(0, false);
    }
    public void calcOutput() {
        if (!this.bias) {
            float bias = 0;
            float sum = 0;
            for (int i = 0; i < this.connections.size(); i++) {
                Connection connection = this.connections.get(i);
                Neuron from = connection.getFrom();
                Neuron to = connection.getTo();
                if (this.equals(to)) {
                    if (from.bias) {
                        bias = from.getOutput() * connection.getWeight();
                    } else {
                        sum += from.getOutput() * connection.getWeight();
                    }
                }
            }
            this.output = factor(bias + sum);
        }
    }
    public void addConnection(Connection connection) {
        this.connections.add(connection);
    }
    public float getOutput() {
        return this.output;
    }
    public ArrayList<Connection> getConnections() {
        return this.connections;
    }
}