package com.geneticalgorithm;

public class XORBinaryFitnessFunction implements IFitnessFunction
{
  public double calculate ( double[] _inputs, double[] _outputs )
  {	
	  // input 0,0 expected output 0
	  if ( _inputs[0] == 0 && _inputs[1] == 0 && _outputs[0] == 0)
	  {
		  return 25;
	  }
	  // input 1,0 expected output 1
	  else if ( _inputs[0] == 1 && _inputs[1] == 0 && _outputs[0] == 1)
	  {
		  return 25;
	  }
	  // input 0,1 expected output 1
	  else if ( _inputs[0] == 0 && _inputs[1] == 1 && _outputs[0] == 1)
	  {
		  return 25;
	  }
	  // input 1,1 expected output 0
	  else if ( _inputs[0] == 1 && _inputs[1] == 1 && _outputs[0] == 0)
	  {
		  return 25;
	  }
	  return 0;
  }
  
  public boolean isFit ( double[] _fitness ) {
	  if ( _fitness[0] == 100 && _fitness[1] == 100 ) return true;
	  	return false;
  }
  
}