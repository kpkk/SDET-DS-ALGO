package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class MinSizeSubArray {
    /*
    Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
     */
    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int k = 7;
        Assert.assertEquals(subArrayLength(nums, k), 2);
    }

    @Test
    public void test2() {
        int[] nums = {1, 4, 4};
        int k = 4;
        Assert.assertEquals(subArrayLength(nums, k), 1);
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 11;
        Assert.assertEquals(minSubArrayLen(k, nums), 0);
    }

    /*
         input - integer array
        output- integer
        Solution:- Sliding window
        - initialize two pointers left=0, right=0
        - initialize a variable called sum=0
        - while right reaches length, add th value at index right to sum
        - keep checking if the sum is >=k
        - of its equals k then store the left and right indices values
        - if the sum if greater than k, then move left pointer until the sum<=k
        - if any match (sub array) then compare the length update the indices only when the length is less
        - return the length
     */
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int subArrayLength(int[] nums, int target) {
        int sum = 0, minLength = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left++];
            }

        }
        return minLength==Integer.MAX_VALUE?0:minLength ;
    }
}
