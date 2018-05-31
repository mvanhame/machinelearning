package com.neuralnetwork;

public class Neuron {


	private double[] Weights;
	private double Bias;
	private int NumInputs;
	private IActivationFunction ActivationFunction;

	public Neuron( Neuron _source )
	{
		this.Weights = new double[_source.Weights.length];
		for ( int weight = 0; weight < this.Weights.length; weight++)
			this.Weights[weight] = _source.Weights[weight];
		
		this.Bias = _source.Bias;
		this.NumInputs = _source.NumInputs;
		this.ActivationFunction = _source.ActivationFunction;
	}

	
	// if bias input is necessary, it must be treated like any other input
	public Neuron( int _num_inputs, double _bias, IActivationFunction _activationFunction )
	{		
		NumInputs = _num_inputs;
		Bias = _bias;
		ActivationFunction = _activationFunction;
		Weights = new double[NumInputs]; 
		
		// assign random weights
		// this will probably depend on activation function
		// logistic functions use the range += 1/sqrt(#inputs)
		double max_weight_value = 1.0/Math.sqrt(NumInputs);
		for (int weight = 0; weight < NumInputs; weight++) 
			Weights[weight] = -max_weight_value + Math.random() * (2 * max_weight_value);
	}
	
	public Neuron ( double[] _weights, double _bias, IActivationFunction _activationFunction )
	{
		NumInputs = _weights.length;
		Bias = _bias;
		ActivationFunction = _activationFunction;
		Weights = _weights; 
	}
	
	public double Activate ( double[] _inputs )
	{
		// first sum inputs * weights
		double sum = 0;
		for (int weight = 0; weight < NumInputs; weight++) 
		{
			sum += Weights[weight] * _inputs[weight];
		}
		return ActivationFunction.Activate ( sum + Bias );
	}
	
	public void printWeights()
	{
		for (int weight = 0; weight < NumInputs; weight++) 
			System.out.println(Weights[weight]);
		System.out.println(Bias);
	}	
	
	public double[] GetWeights()
	{
		return Weights;
	}	
	
	public void SetWeights ( double[] _weights)
	{
		Weights = _weights;
	}
	
	public double GetBias()
		{
			return Bias;
		}		
	public void SetBias ( double _bias )
	{
		Bias = _bias;
	}
}
