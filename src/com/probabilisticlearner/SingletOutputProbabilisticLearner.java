package com.probabilisticlearner;

import java.util.HashMap;

// this learner takes an arbitrary string input and returns a single output based on the probability
// of each possible output.  Teaching will increase the chances of certain outputs, but no output will have 0
// probability, this is by design

// Inputs can be any string, output is a string with 0s and a single 1 for the selected output
public class SingletOutputProbabilisticLearner implements ILearner {
    // inputs map to outputs
    // each output has a probability

    HashMap<String, int[]> TheBrain;
    int num_outputs;

    public SingletOutputProbabilisticLearner(int _num_outputs) {

        TheBrain = new HashMap<String,int[]> ();
        num_outputs = _num_outputs;
    }

    public int[] getChances ( String _inputs )
    {
        if ( !TheBrain.containsKey ( _inputs )) {
            // haven't seen this before, so create it
            int [] chances = new int[num_outputs];

            // add a chance for each possible output
            for ( int output = 0; output < num_outputs; output++ ) {
                if ( _inputs.charAt(output)=='.') // only allow an output where there is not an input
                    chances[output] = 1;
            }

            TheBrain.put ( _inputs, chances );
            return chances;
        }
        return TheBrain.get ( _inputs );
    }

    // make the probability a sigmoid?
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
                break;
            } else {
                random_chance -= chances[output_loop];
                output.append("0");
            }
        }

        while ( output.length() < 9)
            output.append ( "0");

        return output.toString();
    }

    // increase the chance of making the same choice again
    public void reward ( String _input, String _desired_output) {
        int[] chances = getChances ( _input );

        // which output is desired?
        for ( int desired_output = 0; desired_output < num_outputs; desired_output++) {
            if ( _desired_output.charAt (desired_output ) == '1') {
                chances[desired_output] += 3;
                break;
            }
        }
        TheBrain.put(_input, chances );
    }

    // decrease the chance of making the same choice again
    public void punish ( String _input, String _desired_output) {
        int[] chances = getChances ( _input );

        // which output is desired?
        for ( int desired_output = 0; desired_output < num_outputs; desired_output++) {
            if ( _desired_output.charAt (desired_output ) == '1') {
                if ( chances[desired_output] > 1 ) chances[desired_output] -= 1;
                break;
            }
        }

        // if all chances are 0, the brain will break, so reset this one memory so as to always have choices
        boolean noChances = true;
        for ( int chance = 0; chance < 9; chance++) {
            if (chances[chance] > 0) {
                noChances = false;
                break;
            }
        }

        if ( noChances)
            TheBrain.remove(_input);
        else
            TheBrain.put(_input, chances );
    }
}
