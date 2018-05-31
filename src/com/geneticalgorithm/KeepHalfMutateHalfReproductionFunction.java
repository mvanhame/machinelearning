package com.geneticalgorithm;

// copies each of the top half networks and then adds a small mutation to the copy
public class KeepHalfMutateHalfReproductionFunction implements IReproductionFunction
{
	public GeneticAlgorithm[] doIt ( int _generation, GeneticAlgorithm[] _networks )
	{
		GeneticAlgorithm[] new_networks = new GeneticAlgorithm[_networks.length];

		for ( int network = 0; network < _networks.length/2; network++) {
			new_networks[network] = new GeneticAlgorithm ( _generation, _networks[network] );
		}

		for ( int network = _networks.length/2; network < _networks.length; network++) {
			new_networks[network] = new GeneticAlgorithm ( _generation, _networks[network] );
			new_networks[network].mutate(1.0, 0.1);
		}

		return new_networks;
		
	}
}