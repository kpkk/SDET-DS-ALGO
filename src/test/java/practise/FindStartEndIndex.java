package practise;

import org.junit.Assert;
import org.junit.Test;

public class FindStartEndIndex {
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
    public void test(){
        int[] nums={5,7,7,8,8,10};
        int target=7;
        Assert.assertEquals(findStartEndIndices(nums,target),new int[]{1,2});
    }

    private int[] findStartEndIndices(int[] nums, int target) {

        int low=0, high=nums.length-1, startIndex=Integer.MAX_VALUE, endIndex=0;
        while (low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                if(nums[mid-1]==target && nums[mid+1]==target && startIndex!=0){
                    low=mid+1;
                }
                else if(nums[mid-1]==target){
                    endIndex=Math.max(mid, endIndex);
                    high=mid-1;
                }
                else if(nums[mid+1]==target){
                    startIndex=Math.min(startIndex,mid);
                    low=mid+1;
                }
            }else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return new int[]{startIndex,endIndex};
    }
}
