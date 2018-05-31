package com.geneticalgorithm;

//Add Genealogy

import com.neuralnetwork.SigmoidActivationFunction;

public class XORSigmoidGeneration extends XORGeneration
{
  public XORSigmoidGeneration ( int _generation_count)
  {
	  super ( _generation_count, 0.1, new SigmoidActivationFunction(), new XORSigmoidFitnessFunction(), new PercentReproductionFunction( 0.1, 0.2, 0.1) );
  }
}