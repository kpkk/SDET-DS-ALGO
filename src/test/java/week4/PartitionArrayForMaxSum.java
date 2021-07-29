package week4;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageTranscoder;

public class PartitionArrayForMaxSum {
    /*

    1043. Partition Array for Maximum Sum
Medium

1494

163

Add to List

Share
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.



Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]
Example 2:

Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83
Example 3:

Input: arr = [1], k = 1
Output: 1
     */

    @Test
    public void test1(){
        int[] nums={1,15,7,9,2,5,10};
        int k=3;
        Assert.assertEquals(maxSumAfterPartitioning(nums,k),84);
    }
    @Test
    public void test2(){
        int[] nums={1,4,1,5,7,3,6,1,9,9,3};
        int k=4;
        Assert.assertEquals(maxSumAfterPartitioning(nums,k),83);
    }
    @Test
    public void test3(){
        int[] nums={1};
        int k=1;
        Assert.assertEquals(findMaxSum(nums,k),1);
    }

    /*
    Approach:- sliding window

    Solution:-
    - Initialize a variable sum=0
    - Traverse through the array from start index until k elements
    - find the max value of the window and consider it to be sum
    - Iterate the array from k, when the window size becomes more than k
            - discard the last element
            - add the next element
            - calculate the max and append it to the sum
     - return the sum

     */

    private int findMaxSum(int[] nums, int k) {
        if(nums.length==1) return nums[0];
        int sum=0, maxValue=Integer.MIN_VALUE;
        for (int i=0;i<k;i++){
            maxValue=Math.max(nums[i],maxValue);
        }
        sum+=maxValue;
        for (int i=k;i<nums.length;i++){
            maxValue= Math.max(nums[i-k+1],nums[i]);
            sum+=maxValue;
        }
        return sum;
    }

    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length, dp[] = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            int curMax = 0, best = 0;
            for (int k = 1; k <= K && i - k >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k]);
                best = Math.max(best, dp[i - k] + curMax * k);
            }
            dp[i] = best;
        }
        return dp[N];
    }
}
