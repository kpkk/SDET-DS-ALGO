package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClosestSumUsingBinarySearch {
    /*

    P1) Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
 
Example 1:

Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.

Example 2:

Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.

Solve this in less than O(n) time complexity
     */

    @Test
    public void test1(){
        int[] nums={34,23,1,24,75,33,54,8};
        int k=60;
        Assert.assertEquals(findClosestSum(nums,k),58);
    }

    private int findClosestSum(int[] nums, int k) {

        int low=0,high=nums.length-1;
        Arrays.sort(nums);
        while (low<=high){
            int mid=(low+high)/2;
            if(nums[mid]+nums[mid-1]>k) high=mid-1;
            else if(nums[mid]+nums[mid+1]<k)low=mid+1;

        }
        return nums[low]+nums[low+1];
    }
}
