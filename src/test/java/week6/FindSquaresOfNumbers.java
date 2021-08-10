package week6;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class FindSquaresOfNumbers {

    /*
    Given a sorted array in ascending order, return the square of the digits in ascending order. The array can contain negative integers also
    eg: {4,5,6}
   output:- {16,25,36}
     */
    /*
    Input- integer array
    Output- output array
    constraint - O(n)
    test data
     */

    @Test
    public void test1(){
        int[] nums={4,5,6};
        Assert.assertArrayEquals(findSquaresOptimized(nums),new int[]{16,25,36});
    }
    @Test
    public void test2(){
        int[] nums={};
        Assert.assertArrayEquals(findSquaresOptimized(nums),new int[]{});
    }
    @Test
    public void test3(){
        int[] nums={-4,-3,-2,0,1,2,3,4};
        Assert.assertArrayEquals(findSquaresOptimized(nums),new int[]{0,1,4,4,9,9,16,16});
    }
    @Test
    public void test4(){
        int[] nums={-2,0,4};
        Assert.assertArrayEquals(findSquaresOptimized(nums),new int[]{0,4,16});
    }

    /*
    Brute force:-
    1. traverse the array from left to right
    2. multiply every number at index i with itself
    3. sort the array and return
     */
    // time complexity- O(n logn)
    //space complexity - O(1)
    private int[] findSquares(int[] nums) {
        if(nums.length==0) return nums;
        for (int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;

    }

    /*
    - Initialize an integer array
    - Initialize two pointers left=0, right=nums.length-1
    - while left<=right
    - compare the absolute values of right and left
        - which ever is maximum we can put the square of that number at the end index
    - return the output array
     */
    private int[] findSquaresusingSwap(int[] nums) {
        if(nums.length==0) return nums;
        int[] output=new int[nums.length];
        int left=0, right=nums.length-1;
        for (int i=output.length-1;i>=0;i--){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                output[i]=nums[left]*nums[left];
                left++;
            }else{
                output[i]=nums[right]*nums[right];
                right--;
            }
        }
       return output;
    }

    private int[] findSquaresOptimized(int[] nums){
        if(nums.length==0) return nums;
        int left=0, right=nums.length-1;
        while (left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
            }else{
                nums[right]=nums[right];
                right--;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        return nums;
    }
}
