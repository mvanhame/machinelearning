package com.probabilisticlearner;

public interface ILearner {
    int[] getChances ( String _inputs );
    String evaluate(String _input);
    void reward(String _input, String _output ); // learner should be rewarded for the correct output
    void punish(String _input, String _output ); // learner should be punished for incorrect output
}
