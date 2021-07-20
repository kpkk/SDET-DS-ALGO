package day5;

import org.junit.Assert;
import org.junit.Test;

public class MinSubArraySum {
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

     */

    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        Assert.assertEquals(minSubArrayLengthBruteForce(nums, target), 2);
    }

    @Test
    public void test2() {
        int[] nums = {1, 4, 4};
        int target = 1;
        Assert.assertEquals(minSubArrayLengthBruteForce(nums, target), 1);
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int target = 11;
        Assert.assertEquals(minSubArrayLengthBruteForce(nums, target), 0);
    }

    /*
    Solution-
    - Check if the length of the array is 0, if yes return 0
    - If the length of the array is 1 and the element is greater than or equal to target return 1
    - Initialize int variables min=Integer.MAX_VALUE,sum=0, left=0, right=0 and a boolean isTargetEverMet
    - Traverse the array until right< nums.length and keep adding the numbers to the sum
    - if the sum is greater than target
            - subtract left value
            - flip the flag isTargetEverMet to true
            - increment left value as long as the sum is greater than the target
     - Find the min length between min, right-left+1
     - if isTargetEverMet is false return 0 else return min
     */


    //Time complexity- O(n)
    //Space complexity- O(1)
    private int findSubArrayLength(int[] nums, int target) {
        if (nums.length == 0) return 0;
        boolean isTargetEverMet = false;
        if (nums.length == 1 && nums[0] >= target) return 1;
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                isTargetEverMet = true;
                sum -= nums[left++];
            }
            min = Math.min(min, right - left + 1);
        }
        if (!isTargetEverMet) return 0;
        return min;
    }

    /*
    Solution:-
    1. If the length of the array is zero return 0
    2. If the length of the array is one and the element is greater than 7 return 1
    3. Initialize variables min=Integer.MAX, sum=0
    4. traverse through the array from start index until the end
    5. traverse the array(inner loop) starting from i and sum the elements
    6. if the sum is greater than or target then find the min value  between mon and j-i+1
    7. return min


     */

    private int minSubArrayLengthBruteForce(int[] nums, int target) {
        if(nums.length==0) return 0;
        if(nums.length==1 && nums[0]>=7) return 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }
        return (min!=Integer.MAX_VALUE)?min:0;
    }

}
