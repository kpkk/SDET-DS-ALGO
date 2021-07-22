package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindIndexOfTarget {

    /*
    Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
     */

    @Test
    public void test1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int k = 8;
        Assert.assertTrue(Arrays.equals(findIndexUsingBinarySearch(nums, k), new int[]{3, 4}));
    }

    @Test
    public void test2() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int k = 6;
        Assert.assertTrue(Arrays.equals(findIndexUsingBinarySearch(nums, k), new int[]{-1, -1}));
    }

    @Test
    public void test3() {
        int[] nums = {7, 7, 7, 7};
        int k = 7;
        Assert.assertTrue(Arrays.equals(findIndexUsingBinarySearch(nums, k), new int[]{0, 3}));
    }
    @Test
    public void test4() {
        int[] nums = {5, 7, 7, 8, 8,8,8, 10};
        int k = 8;
        Assert.assertTrue(Arrays.equals(findIndexUsingBinarySearch(nums, k), new int[]{3, 6}));
    }

    /*
    Approach: Binary search
    Time complexity- O(logn)
    Space complexity- 0(1)
     Solution:-
     - Initialize low=0,high=length-1, startIndex=Integer.MAX_VALUE, endIndex=0 and boolean isMidMatched=false
     - while low<=high
     - if the mid==target
            - check if mid+1== target
                - Then assign startIndex with mid value and low=mid+1
            - if mid-1 == target
                - Then assign endIndex= mid value and high=mid-1
     - else if mid> target high=mid-1
     - else mid < target low=mid+1
     - return the integer array with startIndex and endIndex

*/
    private int[] findIndexUsingBinarySearch(int[] nums, int k) {

        int low = 0, high = nums.length - 1, mid = 0, startIndex = Integer.MAX_VALUE, endIndex = 0;
        boolean isMidMatched = false;
        if (nums[0] == k && nums[nums.length - 1] == k) return new int[]{0, nums.length - 1};
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == k) {
                isMidMatched = true;
                if(nums[mid-1]==k && nums[mid+1]==k && startIndex!=0){
                    low=mid+1;
                }
               else if (nums[mid - 1] == k) {
                    endIndex = Math.max(mid,endIndex);
                    high = mid - 1;
                }
                else if (nums[mid + 1] == k) {
                    startIndex = Math.min(mid,startIndex);
                    low = mid + 1;
                }

            } else if (nums[mid] < k) low = mid + 1;
            else high = mid - 1;

        }
        if (!isMidMatched) return new int[]{-1, -1};

        return new int[]{startIndex, endIndex};
    }
}

