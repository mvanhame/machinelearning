package com.probabilisticlearner;

import java.util.HashMap;

public class SingleOutputRoteLearner implements ILearner {
    // inputs map to outputs
    // each output has a probability

    HashMap<String, int[]> TheBrain;
    int num_outputs;

    public SingleOutputRoteLearner(int _num_outputs) {

        TheBrain = new HashMap<String,int[]> ();
        num_outputs = _num_outputs;
    }

    public int[] getChances ( String _inputs )
    {
        if ( !TheBrain.containsKey ( _inputs )) {
            // haven't seen this before, so create it
            int [] chances = new int[num_outputs];

            for ( int output = 0; output < num_outputs; output++ )
                chances[output] = 1;

            TheBrain.put ( _inputs, chances );
            return chances;
        }
        return TheBrain.get ( _inputs );
    }

    public String evaluate ( String _input ) {

        int[] chances = getChances ( _input );

        int total_chances = 0;
        for ( int output_loop = 0; output_loop < num_outputs; output_loop++ ) {
            total_chances += chances[output_loop];
        }

        int random_chance = (int)(Math.random() * total_chances) + 1;

        StringBuilder output = new StringBuilder();
        for ( int output_loop = 0; output_loop < num_outputs; output_loop++ ) {
            if (random_chance <= chances[output_loop]) {
                output.append("1");
                random_chance = 1000; // ensure that none other are selected
            } else {
                random_chance -= chances[output_loop];
                output.append("0");
            }
        }

        return output.toString();
    }

    // trains one cycle
    public void reward ( String _input, String _desired_output) {
        int[] chances = getChances ( _input );

        // which output is desired?
        for ( int desired_output = 0; desired_output < num_outputs; desired_output++) {
            if ( _desired_output.charAt (desired_output ) != '1') {
                chances[desired_output] = 0;
            }
        }
        TheBrain.put(_input, chances );
    }
    public void punish ( String _input, String _desired_output) {
    }
}

