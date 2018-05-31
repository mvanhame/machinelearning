package com.geneticalgorithm;

//Add Genealogy

import com.neuralnetwork.BinaryActivationFunction;

public class XORBinaryGeneration extends XORGeneration
{
  public XORBinaryGeneration (int _generation_count)
  {
	  super ( _generation_count, 4.0, new BinaryActivationFunction(), new XORBinaryFitnessFunction(), new PercentReproductionFunction ( 0.1,0.1, 0.5));//KeepHalfMutateHalfReproductionFunction
  }
}