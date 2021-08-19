package week7;

import org.junit.Assert;
import org.junit.Test;

public class FindTargetSum {

    /*
    Problem 1)
Given an int array [1,4,20,3,10,5] and target sum 33.
If target subarray sum is found, return true else false
Time : 20 Minutes
- Write another 2 test data (edge and neg)
- Pseudo Code for Optimised Solution
- Code, Debug
- Time everything
- Do it yourself !!
     */
    /*
    8:03
    Input- integer array, int value
    output- boolean type
    test data- [1,4,5,10,2,3,8,2] k=15 //edge, multiple matches
     [1,2,3,4,5] k=50// ni match
     8:05 -
     8:11-pseudo code
     8:16- coding
     8:23- debug and completed

     Time analysis:-
     problem understanding- 3 mins
     Test data- 2mins
     Pseudo code: 10 mins
     coding: 8 mins
     refactoring & debug: 5 mins

     */
    @Test
    public void test1(){
        int[] nums={1,4,20,3,10,5};
        int k=33;
        Assert.assertTrue(findTragetSum(nums,k));
    }
    @Test
    public void test2(){
        int[] nums={1,4,5,10,2,3,8,2};
        int k=15;
        Assert.assertTrue(findTragetSum(nums,k));
    }
    @Test
    public void test3(){
        int[] nums={1,2,3,4,5};
        int k=50;
        Assert.assertFalse(findTragetSum(nums,k));
    }
    @Test
    public void test4(){
        int[] nums={3,3,3,3};
        int k=3;
        Assert.assertTrue(findTragetSum(nums,k));
    }

    /*


    Solution:-
    Sliding window:-
    - Initialize a variable called sum= nums[0]
    - iterate the array first element in one pass
    - second pass, add the next element and check sum
        - if its greater then subtract the last one else keep adding
     */
//1 4 20 3 10 5

    // Time complexity- O(n)
    //space complexity- O(1)
    private boolean findTragetSum(int[] nums, int k) {
        int sum=nums[0];
        int j=0;
        for (int i=1;i<nums.length;i++){
            if(sum==k) return true;
            sum+=nums[i];
            while (sum>k) {
                sum-=nums[j];
                j++;
            }
            if(sum<k)continue;
        }
        return false;
    }
}
