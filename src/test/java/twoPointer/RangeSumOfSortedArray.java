package twoPointer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RangeSumOfSortedArray {
    /*
    Range Sum of Sorted Subarray Sums
    You are given the array nums consisting of n positive integers. You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 109 + 7.



Example 1:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
Example 2:

Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
Output: 6
Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
Example 3:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
Output: 50


Constraints:

n == nums.length
1 <= nums.length <= 1000
1 <= nums[i] <= 100
1 <= left <= right <= n * (n + 1) / 2
     */

    /*

     */
    @Test
    public void test1(){
        int[] nums={1,2,3,4};
        int n=4, left=1, right=5;
        Assert.assertEquals(findRangeSum(nums,n,left,right),13);
    }
    @Test
    public void test2(){
        int[] nums={1,2,3,4};
        int n=4, left=3, right=4;
        Assert.assertEquals(findRangeSum(nums,n,left,right),6);
    }

    /*
    - Initialize a new array of n*(n+1)/2 size
    - iterate the array from start index until end
    - iterate the array from next index to calculate the prefix sum
    - sort the array in ascending order
    - then iterate the new array from left index until right then return the sum
     */

    private int findRangeSum(int[] nums, int n, int left, int right) {
        final int MOD = 1_000_000_007;
        int[] sum=new int[n*(n+1)/2];
        int total=0;
        int index=0;
        for (int i=0;i<nums.length;i++){
            sum[index++]=nums[i];
            for (int j=i+1;j<nums.length;j++){
                int add=nums[j]+sum[index-1];
                sum[index++]=add;
            }
        }
        Arrays.sort(sum);
        for (int i=left-1;i<right;i++){
            total+=sum[i]%MOD;
        }
        return (int)total%MOD;
    }
}

