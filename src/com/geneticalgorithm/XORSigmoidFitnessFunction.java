package com.geneticalgorithm;

public class XORSigmoidFitnessFunction implements IFitnessFunction
{
  public double calculate ( double[] _inputs, double[] _outputs )
  {	
	  // input 0,0 expected output 0
	  if ( _inputs[0] == 0 && _inputs[1] == 0)
	  {
		  return 1 - _outputs[0];
	  }
	  // input 1,0 expected output 1
	  else if ( _inputs[0] == 1 && _inputs[1] == 0)
	  {
		  return _outputs[0];
	  }
	  // input 0,1 expected output 1
	  else if ( _inputs[0] == 0 && _inputs[1] == 1)
	  {
		  return _outputs[0];
	  }
	  // input 1,1 expected output 0
	  else if ( _inputs[0] == 1 && _inputs[1] == 1)
	  {
		  return 1-_outputs[0];
	  }
	  return 0;
  }
  
  public boolean isFit ( double[] _fitness ) {
	  if ( _fitness[0] > 3.75  ) return true;
	  return false;
  }
  
}