package practise;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ThreePointers {
    /*

    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Example 3:

Input: nums = [0]
Output: [0]
     */

    @Test
    public void test1(){
        int[] nums={2,0,2,1,1,0};
        int[] output={0,0,1,1,2,2};
        Assert.assertTrue(Arrays.equals(swapColors(nums),output));
    }

    /*
    mid as current index
    if mid ==0 swap low and mid and increment both
    if mid==1 increment mid alone, dont swap
    if mid==2 swap mid and high and decrement high

     */
    private int[] swapColors(int[] nums) {
        int low=0, mid=0, high=nums.length-1, temp=0;

        while (mid<=high){
            if(nums[mid]==0){
                 temp=nums[low];
                nums[low++]=nums[mid];
                nums[mid++]=temp;
            }
            else if(nums[mid]==1) mid++;
            else{
                temp=nums[mid];
                nums[mid]=nums[high];
                nums[high--]=temp;
            }
        }
        return nums;
    }


}
