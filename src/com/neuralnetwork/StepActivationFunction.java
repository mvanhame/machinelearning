package com.neuralnetwork;

public class StepActivationFunction implements IActivationFunction
{
  private double Threshold;
  
  public StepActivationFunction ( double _threshold )
  {
    Threshold = _threshold;
  }
  
  public double Activate ( double _sum_of_weights_times_inputs)
  {
	  if (_sum_of_weights_times_inputs > Threshold)
		  return 1;
	  return 0;		
  }  
}