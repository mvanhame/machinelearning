package com.neuralnetwork;

public class NeuralNetwork {
	protected double[][] Outputs; // [layer][neuron]
	protected Neuron[][] Neurons; // [layer][neuron]
	
	public NeuralNetwork ( NeuralNetwork _source)
	{
		this.Outputs = new double[_source.Outputs.length][];
		this.Neurons = new Neuron[_source.Neurons.length][];

		for ( int layer = 0; layer < Neurons.length; layer++)
		{
			this.Outputs[layer] = new double[_source.Outputs[layer].length];
			this.Neurons[layer] = new Neuron[_source.Neurons[layer].length];
			
			for ( int neuron = 0; neuron < this.Neurons[layer].length; neuron++ )
			{
				this.Neurons[layer][neuron] = new Neuron (_source.Neurons[layer][neuron]);
			}
			
		}		
	}
	
	// _weights [layer][neuron][weight]
	// _biases [layer][neuron]
	// _activationFunctions [layer][neuron]
	public NeuralNetwork ( double[][][] _weights, double [][] _biases, IActivationFunction[][] _activationFunctions)
	{
		Outputs = new double[_weights.length][];
		Neurons = new Neuron[_weights.length][];
		
		for ( int layer = 0; layer < Neurons.length; layer++)
		{
			Outputs[layer] = new double[_weights[layer].length];
			Neurons[layer] = new Neuron[_weights[layer].length];
			for ( int neuron = 0; neuron < Neurons[layer].length; neuron++ )
			{
				double bias = 0;
				if ( _biases != null )
					bias = _biases[layer][neuron];
				Neurons[layer][neuron] = new Neuron (_weights[layer][neuron], bias, _activationFunctions[layer][neuron] );
			}
		}
	}
	
	public double[] Activate ( double[] _inputs )
	{
		for ( int neuron = 0; neuron < Outputs[0].length; neuron++)
			Outputs[0][neuron] = Neurons[0][neuron].Activate(_inputs);
		
		for ( int layer = 1; layer < Outputs.length; layer++)
		{
			for ( int neuron = 0; neuron < Outputs[layer].length; neuron++)
				Outputs[layer][neuron] = Neurons[layer][neuron].Activate(Outputs[layer-1]);
		}

		return Outputs[Outputs.length-1];
	}
	
	public void printWeights()
	{
		for ( int layer = 0; layer < Neurons.length; layer++)
		{
			System.out.println("Layer: " + layer );
			for ( int neuron = 0; neuron < Neurons[layer].length; neuron++)
			{
				System.out.println("Neuron: " + neuron );
				Neurons[layer][neuron].printWeights();
			}
		}
	}	
	
}