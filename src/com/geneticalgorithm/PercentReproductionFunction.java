package com.geneticalgorithm;

// copies each of the top half networks and then adds a small mutation to the copy
public class PercentReproductionFunction implements IReproductionFunction
{
	double percent_to_reproduce;
	double mutationProbability;
	double mutationRange;

	public PercentReproductionFunction ( double _percent_to_reproduce, double _mutationProbability, double _mutationRange )
	{
		percent_to_reproduce = _percent_to_reproduce;
		mutationProbability = _mutationProbability;
		mutationRange = _mutationRange;
	}
	public GeneticAlgorithm[] doIt ( int _generation, GeneticAlgorithm[] _networks )
	{
		GeneticAlgorithm [] new_networks = new GeneticAlgorithm[_networks.length];
		int percent_of_networks = (int)(_networks.length*percent_to_reproduce);

		for ( int network = 0; network < _networks.length; network+=percent_of_networks) {
			for ( int source = 0; source < percent_of_networks; source++) {
				if ( network+source < _networks.length) { // allow for percentages which don't break evenly
					new_networks[network + source] = new GeneticAlgorithm(_generation, _networks[source]);
					if (network > percent_of_networks)
						new_networks[network + source].mutate(mutationProbability, mutationRange);
				}
			}
		}
		return new_networks;
	}
}
