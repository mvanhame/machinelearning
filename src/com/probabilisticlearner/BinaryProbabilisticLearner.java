package com.probabilisticlearner;
import java.util.*;

public class BinaryProbabilisticLearner {

    // inputs map to outputs
    // each output has a probability

    HashMap<String, int[]> TheBrain;
    int num_outputs;

    public BinaryProbabilisticLearner ( int _num_outputs) {
        TheBrain = new HashMap<String,int[]> ();
        num_outputs = _num_outputs;
    }

    private int[] getChances ( int[] _inputs )
    {
        String InputsAsString = Arrays.toString (_inputs );
        if ( !TheBrain.containsKey ( InputsAsString )) {
            // haven't seen this before, so create it
            int [] chances = new int[num_outputs];

            for ( int output = 0; output < num_outputs; output++ )
                chances[output] = 1;

            TheBrain.put ( InputsAsString, chances );
            return chances;
        }
        return TheBrain.get ( InputsAsString );
    }

    // make the probability a sigmoid?
    public int[] test ( int[] _input ) {

        int[] chances = getChances ( _input );
        int[] output = new int[num_outputs];

        int total_chances = 0;
        for ( int output_loop = 0; output_loop < num_outputs; output_loop++ ) {
            total_chances += chances[output_loop];
        }

        int random_chance = (int)(Math.random() * total_chances) + 1;

        for ( int output_loop = 0; output_loop < num_outputs; output_loop++ ) {
            if ( random_chance <= chances[output_loop]) {
                output[output_loop] = 1;
                break;
            }
            else
                random_chance -= chances[output_loop];
        }

        return output;
    }

    // trains one cycle
    public void teach ( int[] _input, int _desired_output ) {
        int[] chances = getChances ( _input );
        chances[_desired_output]++;
        TheBrain.put(Arrays.toString(_input), chances );
    }
}
