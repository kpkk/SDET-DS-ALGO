package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayByParity {
    /*
    Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.



Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
     */

    /*
       input- integer array
       output- integer array
       Solution:-
       - Iterate the array from start index until end
       - check every number at every index, if its divisible by 2
       - if so then swap the value
       - repeat this until the end of the array
       - return the array
       */

    @Test
    public void test1(){
        int[] nums={3,1,2,4};
        Assert.assertArrayEquals(sortArrayByParity(nums),new int[]{2,4,3,1});
    }

    public int[] sortArrayByParity(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                int temp=nums[index];
                nums[index++]=nums[i];
                nums[i]=temp;
            }
        }
        return nums;
    }
}
