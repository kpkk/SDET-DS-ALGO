package workshop;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;
import org.junit.Assert;
import org.junit.Test;

public class SearcInRotatedArray {
    /*
    Q2 ) Search in a rotated array


There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
     */
    @Test
    public void test1(){
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        Assert.assertEquals(findTheTargetIndex(nums,target),4);
    }
    @Test
    public void test2(){
        int[] nums={4,5,6,7,0,1,2};
        int target=3;
        Assert.assertEquals(findTheTargetIndex(nums,target),-1);
    }
    @Test
    public void test3(){
        int[] nums={5,1,2,3,4};
        int target=5;
        Assert.assertEquals(findTheTargetIndex(nums,target),0);
    }
    @Test
    public void test4(){
        int[] nums={3,1};
        int target=1;
        Assert.assertEquals(findTheTargetIndex(nums,target),1);
    }

    /*
    - initialize variables left=0, right=nums.length-1
    - while left less than right
    - find the mid point
    - if the value at mid matches return mid
    - check if the nums[left]<= nums[mid] ->left hand side sorted
        - if yes, check if the target lies between low and mid
            -  if yes move the high=mid-1
            - else move the low=mid+1
    - check if the nums[mid]<=nums[high]
        - if yes, check if the target lies within the mid and high
            - if yes move the low=mid+1
            - else move high=mid-1;
    - return -1;
     */
    private int findTheTargetIndex(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid])
                    high=mid-1;
                else low=mid+1;
            }
            if(nums[mid]<=nums[high]){
                if(target>nums[mid] && target<=nums[high])
                    low=mid+1;
                else high=mid-1;
            }
        }
        return -1;
    }

}
