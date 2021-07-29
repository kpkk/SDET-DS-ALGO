package week4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDupsFromSortedArray {
    /*

    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

    Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

     */

    @Test
    public void test1(){
        int[] nums={1,1,2};
        int[] output={1,2};
        Assert.assertTrue(Arrays.equals(sortNumbers(nums),output));
    }
    @Test
    public void test3(){
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        int[] output={0,1,2,3,4};
        Assert.assertTrue(Arrays.equals(sortNumbers(nums),output));
    }

    private int[] sortNumbers(int[] nums) {
        int left=0, right=1;
        while (right<nums.length){
            if(nums[left]!=nums[right]){
                left++;
                nums[left]=nums[right];
            }
            right++;

        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,left+1)));
        return Arrays.copyOfRange(nums,0,left+1);
    }


}
