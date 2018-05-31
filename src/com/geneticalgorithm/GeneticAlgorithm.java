package com.geneticalgorithm;

import com.neuralnetwork.IActivationFunction;
import com.neuralnetwork.NeuralNetwork;

public class GeneticAlgorithm extends NeuralNetwork
{
	private String name; 
	public GeneticAlgorithm ( int _name, int _generation, double[][][] _weights, double [][] _biases, IActivationFunction[][] _activationFunctions)
	{
		super (_weights, _biases, _activationFunctions);
		name = String.valueOf(_name) + ": " + String.valueOf(_generation);
	}
	
	public GeneticAlgorithm ( int _generation, GeneticAlgorithm _source )
	{
		super (_source);
		name = _source.getName () + "-" + String.valueOf(_generation);
		
	}
	
	public String getName () { return name; }
	
	// for each weight, the _chance will be checked and if successful, will mutate the weights or bias by += _value
	public void mutate ( double _chance, double _value )
	{
		for ( int layer = 0; layer < Neurons.length; layer++)
		{
			for ( int neuron = 0; neuron < Neurons[layer].length; neuron++)
			{
				double[] Weights = Neurons[layer][neuron].GetWeights();
				
				for ( int weight = 0; weight < Weights.length; weight++)
				{
					if ( Math.random() <= _chance )
						Weights[weight] = Weights[weight] - _value + Math.random() * (2 * _value);
				}
				
				Neurons[layer][neuron].SetWeights(Weights);

				if ( Math.random() <= _chance ) {
					double bias = Neurons[layer][neuron].GetBias();
					bias = bias - _value + Math.random() * (2 * _value);
					Neurons[layer][neuron].SetBias(bias);
				}
			}
		}
		
		// activation function can change
		
		// number of neurons in hidden layers can change
		
		// add new hidden layers?
	} 
}