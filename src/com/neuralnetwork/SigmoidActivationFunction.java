package com.neuralnetwork;
import java.lang.Math;

public class SigmoidActivationFunction implements IActivationFunction { 

	static final double EULER_CONSTANT = 2.71828; 

	public SigmoidActivationFunction () { 
	} 
	
	public double Activate ( double _sum_of_weights_times_inputs) { 
		double E_to_sum_power = Math.pow (EULER_CONSTANT, -_sum_of_weights_times_inputs);
		double output = 1.0 / ( 1.0 + E_to_sum_power);
		//System.out.println ( "OUTPUT: " + output );
		return output;
	} 
}
