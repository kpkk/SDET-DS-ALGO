package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindClosestNumber {

    /*
    Question 2:
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 
Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

     */
    @Test
    public void test1(){
        int[] nums={1,2,3,4,5};
        int k=4, x=3;
//        int[] output=
//        Assert.assertTrue(Arrays.equals(findclosest(nums,k,x),new int[]{1,2,3,4}));
    }
    @Test
    public void test2(){
        int[] nums={1,2,3,4,5};
        int k=4, x=-1;
      //  Assert.assertTrue(Arrays.equals(findclosest(nums,k,x),new int[]{1,2,3,4});
    }

    /*

     */
    /*private int[] findclosest(int[] nums, int k, int x) {
        int left=0, right=nums.length-1
    }*/
}
