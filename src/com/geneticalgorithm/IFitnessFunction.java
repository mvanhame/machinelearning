package com.geneticalgorithm;

public interface IFitnessFunction
{
  public double calculate ( double[] _inputs, double[] _outputs );
  public boolean isFit ( double[] _fitness );
}
  