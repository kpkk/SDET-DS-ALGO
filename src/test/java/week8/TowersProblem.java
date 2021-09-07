package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TowersProblem {
    /*

Given heights of n towers and a value k. We have to either increase or decrease height of every tower by k (only once) where k > 0.
 The task is to minimise the difference between the heights of the longest and the shortest tower after modifications, and output this difference.
Examples:
Input : arr[] = {1, 15, 10}, k = 6
Output : Maximum difference is 5.
Explanation : We change 1 to 7, 15 to
9 and 10 to 4. Maximum difference is 5
(between 4 and 9). We can't get a lower
difference.
Input : arr[] = {1, 5, 15, 10}
k = 3
Output : Maximum difference is 8
arr[] = {4, 8, 12, 7}
Input : arr[] = {4, 6}
k = 10
Output : Maximum difference is 2
arr[] = {14, 16} OR {-6, -4}
Input : arr[] = {6, 10}
k = 3
Output : Maximum difference is 2
arr[] = {9, 7}
Input : arr[] = {1, 10, 14, 14, 14, 15}
k = 6
Output: Maximum difference is 5
arr[] = {7, 4, 8, 8, 8, 9}
Input : arr[] = {1, 2, 3}
k = 2
Output: Maximum difference is 2
arr[] = {3, 4, 5}

     */
    @Test
    public void test1() {
        int[] nums = {1, 15, 10};
        int k = 6;
        Assert.assertEquals(findDifference(nums, k), 5);
    }

    @Test
    public void test2() {
        int[] nums = {1, 5, 15, 10};
        int k = 3;
        Assert.assertEquals(findDifference(nums, k), 3);
    }

    @Test
    public void test3() {
        int[] nums = {4, 8, 12, 7};
        int k = 10;
        Assert.assertEquals(findDifference(nums, k), 2);
    }

    @Test
    public void test4() {
        int[] nums = {1, 10, 14, 14, 14, 15};
        int k = 6;
        Assert.assertEquals(findDifference(nums, k), 5);
    }


    /**
     * Two pointer approach
     * Sort the array
     * get the min and max numbers which are nums[0], nums[nums.length-1]
     * compute the difference between min and max
     * then consider the first element+k as currentMin, last element-k currentMax
     * compare the currentMin and currentMax abd swap them such that they are stored accordingly
     * iterate the array from index 1 until end-2
     * for every index and compute the value after subtract and value after addition
     * if subtracted vaue greater than small and added values lesser than big continue
     * else
     **/

    private int findDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        int minDiff = max - min;

        int small = nums[0] + k;
        int big = nums[nums.length - 1] - k;
        small = Math.min(small, big);
        big = Math.max(small, big);

        for (int i = 1; i < nums.length - 1; i++) {
            int add = nums[i] + k;
            int subtract = nums[i] - k;
            if (subtract >= small || add <= big) continue;
            if (big - subtract <= add - small)
                small = subtract;
                else big = add;

        }
        return Math.min(minDiff, big - small);
    }
}

/*
int max=0,min=Integer.MAX_VALUE,mindiff,newdiff = 0;
		Arrays.sort(arr);
		max = arr[arr.length-1];
		min = arr[0];
		mindiff = max-min;

		// Handle corner elements
        int small = arr[0] + k;
        int big = arr[arr.length-1] - k;
        int temp = 0;

        if (small > big)
        {
            temp = small;
            small = big;
            big = temp;
        }



		for (int i = 1; i < arr.length-1; i++) {
			 int subtract = arr[i] - k;
	         int add = arr[i] + k;
	      // If both subtraction and addition
          // do not change diff
          if (subtract >= small || add <= big)
              continue;

          if (big - subtract <= add - small)
              small = subtract;
          else
              big = add;
      }

		System.out.println(Math.min(mindiff, big - small));
      return Math.min(mindiff, big - small);
 */