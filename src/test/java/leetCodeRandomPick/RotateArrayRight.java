package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RotateArrayRight {
    /*
    Given an integer array perform right rotation a given number of times, N
and print the output. N < length of array.
Input: [4,6,3,8,2,9,1,36]
N = 4
Output: [2,9,1,36,4,6,3,8]
     */
    @Test
    public void test1(){
        int[] nums={4,6,3,8,2,9,1,36};
        int k=4;
        Assert.assertArrayEquals(rotateArray(nums,k),new int[]{2,9,1,36,4,6,3,8});
    }
    @Test
    public void test2(){
        int[] nums={1,2,3,4,5};
        int k=3;
        Assert.assertArrayEquals(rotateArray(nums,k),new int[]{3,4,5,1,2});
    }

    /*
    - Initialize two pointers left=k-1, right=nums.length-1
    - iterate from 0 until k,
    - swap elements at left and right positions
    - return the array

     */
    private int[] rotateArray(int[] nums, int k) {
        int left=k-1, right=nums.length-1;
        for (int i=0;i<k;i++){
            int temp=nums[left];
            nums[left--]=nums[right];
            nums[right--]=temp;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
