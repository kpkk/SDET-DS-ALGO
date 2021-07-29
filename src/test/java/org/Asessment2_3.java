package org;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class Asessment2_3 {

    /*
    Minimum difference sum
     */
    @Test
    public void test(){
        int[] arr={1,3,3,2,4};
        int sum=3;
        Assert.assertEquals(findMinDifference(arr),sum);
    }
    @Test
    public void test1(){
        int[] arr={1,2,3,4};
        int sum=3;
        Assert.assertEquals(findMinDifference(arr),sum);
    }
    private int findMinDifference(int[] arr) {
        Arrays.sort(arr);
        int diff=0;
       for (int i=0;i<arr.length-1;i++){
           diff+=Math.abs( arr[i] - arr[i + 1]);
       }
       return diff;
    }
}
