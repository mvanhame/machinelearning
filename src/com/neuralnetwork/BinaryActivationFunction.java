package com.neuralnetwork;

public class BinaryActivationFunction implements IActivationFunction
{
  public BinaryActivationFunction ()
  {
  }
  
  public double Activate ( double _sum_of_weights_times_inputs)
  {
	  if (_sum_of_weights_times_inputs > 0.0)
		  return 1;
	  return 0;		
  }  
}