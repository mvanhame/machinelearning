package com.geneticalgorithm;

//Add Genealogy

import com.neuralnetwork.IActivationFunction;

public class Generation
{
	GeneticAlgorithm[] networks;
	double[] fitness;
	IFitnessFunction fitness_function;
	IActivationFunction activation_function;
	IReproductionFunction reproduction_function;
	int generation_count;
	int current_generation;
  
  public Generation ( int _generation_count, double _weight_range, IActivationFunction _activation_function, IFitnessFunction _fitness_function, IReproductionFunction _reproduction_function ) {
	  generation_count = _generation_count;
	  activation_function = _activation_function;
	  fitness_function = _fitness_function;
	  reproduction_function = _reproduction_function;
		  	  
      networks = new GeneticAlgorithm[generation_count];
	  
	  for ( int network = 0; network < generation_count; network++ )
	  {
		  // this whole section needs to be dynamic
//  		  double[][][] weights = {{{0.5,0.5},{0.5,0.5}},{{0.5,0.5}}};
  		  double[][][] weights = {{{0,0},{0,0}},{{0,0}}};
  		  IActivationFunction[][] activationFunctions = new IActivationFunction[2][3];
  		  activationFunctions[0][0] = activation_function;
  		  activationFunctions[0][1] = activation_function;
  		  activationFunctions[1][0] = activation_function;
		  
		  networks[network] = new GeneticAlgorithm ( network, current_generation, weights, null, activationFunctions );
		  networks[network].mutate(1.0, _weight_range);
	  }
	  
	  fitness = new double[generation_count];
  }
  
  public void activate ( double[][] _inputs )
  {
	  fitness = new double[networks.length];
  	  for ( int input = 0; input < _inputs.length; input++ )
	  {
		  for ( int network = 0; network < networks.length; network++ )
	      {
		      double[] outputs = networks[network].Activate ( _inputs[input] );
		      fitness[network] += fitness_function.calculate( _inputs[input], outputs );
	      }
	  }
  }
  
  public void activate () {}
  
  public void printFitness ()
  {
  	  for ( int network = 0; network < fitness.length; network++ )
	  {
		  System.out.println("Network[" + networks[network].getName() + "].fitness = " + fitness[network]);
//		  System.out.println("Network[" + network + "].fitness = " + fitness[network]);
      }	
  }
  
  public void printResults ( double[][] _inputs )
  {
	  for ( int network = 0; network < 2 /*networks.length*/; network++ )
	  {
  		  System.out.println("Network[" + networks[network].getName() + "].fitness = " + fitness[network]);
		  networks[network].printWeights();
	  	  for ( int input = 0; input < _inputs.length; input++ )
	      {
		      double[] outputs = networks[network].Activate ( _inputs[input] );
   			  System.out.println("[" + _inputs[input][0] + ", " + _inputs[input][1] + "] = " + outputs[0]);
		  }
		  System.out.println();
	  }
  }
  
  public void printResults () {}
  
  public boolean reproduce ()
  {
  	  // sort by fitness, yes I know its bubble sort, but it was easy at the time
	  int n = fitness.length;
	      
	  do
	  {
          int newn = 0;
          for ( int i = 1; i <= n-1; i++ )
		  {
              if ( fitness[i-1] < fitness[i] )
			  {
				  // swap fitness and networks
				  double temp_fitness = fitness[i-1];
				  fitness[i-1] = fitness[i];
				  fitness[i] = temp_fitness;
				  
				  GeneticAlgorithm temp_ga = networks[i-1];
				  networks[i-1] = networks[i];
				  networks[i] = temp_ga;
					  
	              newn = i;
			  }
         }
	     n = newn;
	  }
	  while ( n != 0 );
	  printFitness();
	  
	  if (fitness_function.isFit ( fitness ))
		  return true;

	  networks = reproduction_function.doIt ( current_generation, networks );
	  
	  return false;
  }
  
  public boolean evolve ( int _max_generations )
  {
	boolean is_fit = false;
	do 
	{
      System.out.println("\n\nGeneration: " + current_generation );
	  activate();
	  current_generation++;
	  is_fit = reproduce();
	}
	while ( is_fit == false && current_generation < _max_generations );
	
	printResults ();
	return is_fit;
  	
  }
  
}
