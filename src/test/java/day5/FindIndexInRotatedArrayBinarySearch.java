package day5;

import org.junit.Assert;
import org.junit.Test;

public class FindIndexInRotatedArrayBinarySearch {

    /*

    P3) There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

     */

    @Test
    public void test1(){
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        Assert.assertEquals(findIndexUsingBinarySearch(nums,target),4);
    }

    private int findIndexUsingBinarySearch(int[] nums, int target) {

        int low=0, high=nums.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target) return mid;

            if(nums[low]<=nums[mid]){
                if(nums[low]<=target&& nums[mid] >target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(target>nums[mid]&& target<=nums[high])
                    low=mid+1;
                else {
                    high=mid-1;
                }
            }

        }
        return -1;
    }
}
