package com.geneticalgorithm;

//Add Genealogy

import com.neuralnetwork.IActivationFunction;

public class XORGeneration extends Generation
{
  public XORGeneration ( int _generation_count, double _weight_range, IActivationFunction _activation_function, IFitnessFunction _fitness_function, IReproductionFunction _reproduction_function)
  {
	  super (_generation_count, _weight_range, _activation_function, _fitness_function, _reproduction_function );
  }
  
  public void activate ()
  {
	  double[][] inputs = {{0,0},{0,1},{1,0},{1,1}};
	  super.activate ( inputs );
  }
  
  public void printResults ()
  {
	  double[][] inputs = {{0,0},{0,1},{1,0},{1,1}};
	  super.printResults ( inputs );
  }
  
}