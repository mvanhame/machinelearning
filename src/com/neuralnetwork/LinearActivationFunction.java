package com.neuralnetwork;

public class LinearActivationFunction implements IActivationFunction
{
  public LinearActivationFunction ()
  {
  }
  
  public double Activate ( double _sum_of_weights_times_inputs)
  {
	  return _sum_of_weights_times_inputs;		
  }  
}