package com.placester.main;
/*
 * Implement a 6 sided die with weights on the sides, so that we don't have an even probability distribution, but it is 
 * weighted by a list of weights passed in at construction time
 * 
 * After 10k iterations of throwing this die, the results should closely match the desired distribution, and this should
 * be reproducible in the unit test in
 * 
 * src/test/com/placester/test/WeightedDiceTest
 */
public class SixSidedWeightedDie extends WeightedDie{
	float[] weights;
	int[] range;
    //NOTE: since these are weights on a probability distribution, these should sum to one, and the incoming array
    // should be of length 6. You should throw if either of these preconditions is false
    public SixSidedWeightedDie(float[] weights)
    {
        super(weights);
        this.weights = weights;
        this.range = new int[7];
        for(int i = 1; i <= 6 ; i++){
        	range[i] = Math.round(( 100 * (1 + weights[i-1])  - 100) + range[i-1]);
        }    
    }

    //Throw the die: this should produce a value in [1,6]
    @Override
    public int throwDie()
    {
        double result;
        int die  = 0;
        result=Math.random()*100;
        for(int i = 1; i<=6 ;i++){
        	if( result > range[i-1] && result <= range[i]) {
        		die = i;
        		break;
        	}
        }
        return die;
    }
}
