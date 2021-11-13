package day3;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicates {

    /*

    2) Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3]
Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the returned length.

Example 2:
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3]
Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.

     */

    @Test
    public void test1(){
        int[] nums={1,1,1,2,2,3}; //1,2 dup=3; left
        int result=5;
        Assert.assertTrue(removeDuplicates(nums)==5);
    }
    @Test
    public void test2(){
        int[] nums={0,0,1,1,1,1,2,3,3};
        int result=7;
        Assert.assertTrue(removeDuplicates(nums)==7);
    }
    @Test
    public void test3(){
        int[] nums={0,0,1,1,2,3,3};
        int result=7;
        Assert.assertTrue(removeDuplicates(nums)==7);
    }

    /*
    Solution:-
    1. Initialize variables left=0, right=1, index=1, dup=1
    2. check if the left and right are same
            - if yes, increment the dup
            - if dup is less than or equal to two then insert right at the nums[index++]
            - if no, then reset the dup to 1 then assign the right value to nums[index++]
     3. increment left and right
     4. return the index


     */
    private int removeDuplicates(int[] nums) {
        int index=1, dup=1, left=0, right=1;
        while (right<nums.length){
            if(nums[left]==nums[right]) dup++;
            else dup=1;
            if(dup<=2) nums[index++]=nums[right];

            right++;left++;
        }
        return index;
    }

    private int removeDups(int[] nums){
        int j=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
            }
        }
        return j;
    }

}
