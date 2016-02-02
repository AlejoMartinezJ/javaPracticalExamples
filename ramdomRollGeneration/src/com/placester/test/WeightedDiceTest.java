package com.placester.test;
import org.junit.Assert;
import org.junit.Test;

import com.placester.main.SixSidedWeightedDie;

public class WeightedDiceTest {
	   @Test
	    public void test()
	    {
	        float errVal = .01f;
	        float [] weights = new float[]{.05f,.10f,.15f,.2f, .2f, .3f};
	        SixSidedWeightedDie theDie = new SixSidedWeightedDie(weights);
	        int [] counts = new int []{0,0,0,0,0,0};
	        int numThrows = 100000;
	        for(int i = 0; i < numThrows; i++)
	        {
	            int val = theDie.throwDie();
	            counts[val-1]++;
	        }
	        
	        for(int i = 0; i < 6; i++)
	        {
	            float actual = (float)counts[i]/numThrows;
	            float diff = Math.abs(actual - weights[i]);
	            Assert.assertTrue(diff <= errVal);
	        }
	    }
}
