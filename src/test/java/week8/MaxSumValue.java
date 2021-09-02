package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxSumValue {
    /*


Given an array of integers, return the minimum possible contiguous array with maximum sum value.
Examples:
int[] nums = {2,4,-11,0,3,7}
Output {3,7}
Explanation: Sum of 3+7 is the biggest sum of all elements in the array. Though 0+3+7 gives the same value, it is expected to return the min possible contiguous array, hence it is {3,7}

     */

    /*
    Input- integer array
    Output- integer array


     */
    @Test
    public void test1(){
        int[] nums={2,4,-11,0,3,7};
        Assert.assertArrayEquals(findMaxSum(nums),new int[]{3,7});
    }
    @Test
    public void test2(){
        int[] nums={2,-3,-8,-6,-1};
        Assert.assertArrayEquals(findMaxSum(nums),new int[]{2});
    }
    @Test
    public void test3(){
        int[] nums={2,-3,-8,-6,-1,10};
        Assert.assertArrayEquals(findMaxSum(nums),new int[]{10});
    }
    @Test
    public void test4(){
        int[] nums={-2,-3,-8,-6,-1,-10};
        Assert.assertArrayEquals(findMaxSum(nums),new int[]{-1});
    }
    @Test
    public void test5(){
        int[] nums={};
        Assert.assertArrayEquals(findMaxSum(nums),new int[]{});
    }
    @Test
    public void test6(){
        int[] nums={4,6,8,-10,1,2,3};
        Assert.assertArrayEquals(findMaxSum(nums),new int[]{4,6,8});
    }
    @Test
    public void test7(){
        int[] nums={5,5,10};
        Assert.assertArrayEquals(findMaxSum(nums),new int[]{5,5,10});
    }

    /*
    - initialize two variables called currentSum=nums[0], and maxSum=nums[0]
    - iterate the array from index 1 until the end
    - for every index get the current max sum and compare with max sum
    - store the indices
    - in the end return the subarray whose sum is max


     */

    private int[] findMaxSum(int[] nums) {
        //if empty array return empty array
        if(nums.length==0) return new int[]{};
        int currentSum=nums[0], maxSum=nums[0],j=0, startIndex=0,endIndex=0;
        for(int i=1;i<nums.length;i++){
            // if the sum goes negative reset the sum=0, move j to i+1
            if(currentSum+nums[i]<=0){
                currentSum=0;
                j=i+1;
            }
            // if currentSUm<preSum and currentSum>0 then move j to i+1, reset the currentSum=0;
            else if(currentSum>currentSum+nums[i] && currentSum+nums[i]>0){
                j=i+1;
                currentSum=0;
            }
            // update the current sum with max value
            else currentSum=Math.max(currentSum,currentSum+nums[i]);
            // update the ultimate maxSum and hold the indices to return
            if(maxSum<currentSum){
                maxSum=currentSum;
                startIndex=j;
                endIndex=i;
            }
        }
        return Arrays.copyOfRange(nums,startIndex,endIndex+1);
    }

}

/*
 // if empty array return empty array
        if(nums.length==0) return new int[]{};
        int currentSum=nums[0], maxSum=nums[0],j=0, startIndex=0,endIndex=0;
        for(int i=1;i<nums.length;i++){
            // if the sum goes negative reset the sum=0, move j to i+1
            if(currentSum+nums[i]<=0){
                currentSum=0;
                j=i+1;
            }
            // if currentSUm<preSum and currentSum>0 then move j to i+1, reset the currentSum=0;
            else if(currentSum>currentSum+nums[i] && currentSum+nums[i]>0){
                j=i+1;
                currentSum=0;
            }
            // update the current sum with max value
            else currentSum=Math.max(currentSum,currentSum+nums[i]);
            // update the ultimate maxSum and hold the indices to return
            if(maxSum<currentSum){
                maxSum=currentSum;
                startIndex=j;
                endIndex=i;
            }
        }
        return Arrays.copyOfRange(nums,startIndex,endIndex+1);
 */



/*

 if(nums.length==0) return new int[]{};
       int currentSum=nums[0], maxSum=nums[0], prevSum=nums[0];
       int i=0, j=0, startIndex=0,endIndex=0;
       for(j=1;j<nums.length;j++){
          // prevSum=nums[i]+currentSum;
           currentSum=Math.max(currentSum+nums[j],nums[j]);
           if(prevSum>currentSum){
              // prevSum=currentSum;
               i=j+1;
           }
           if(maxSum<currentSum){
               maxSum=currentSum;
               startIndex=i;
               endIndex=j;

           }
           prevSum=currentSum;
       }
       return Arrays.copyOfRange(nums,startIndex,endIndex+1);
    }
 */