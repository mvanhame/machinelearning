package com.neuralnetwork;

public class BiasActivationFunction implements IActivationFunction
{
  double Bias;
  public BiasActivationFunction ()
  {
	  Bias = 1.0;
  }
  public BiasActivationFunction ( double _bias)
  {
	  Bias = _bias;
  }
  
  public double Activate ( double _sum_of_weights_times_inputs)
  {
	  return Bias; 		
  }  
}