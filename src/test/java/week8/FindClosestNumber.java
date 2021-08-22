package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindClosestNumber {

    /*
    Question 2:
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 
Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

     */
    @Test
    public void test1(){
        int[] nums={1,2,3,4,5};
        int k=4, x=3;
        Assert.assertTrue(Arrays.equals(findclosest(nums,k,x),new int[]{1,2,3,4}));
    }
    @Test
    public void test2(){
        int[] nums={1,2,3,4,5};
        int k=4, x=-1;
        Assert.assertTrue(Arrays.equals(findclosest(nums,k,x),new int[]{1,2,3,4}));
    }
    @Test
    public void test3(){
        int[] nums={8, 17, 24, 25, 28};
        int k=3, x=23;
        Assert.assertTrue(Arrays.equals(findclosest(nums,k,x),new int[]{24,25,28}));
    }



    /*

     */
    private int[] findclosestNumber(int[] nums, int k, int x) {
        int left=0, right=nums.length-1;
        int [] output=new int[k];
        int leftIndex=0, rightIndex=k-1;
        while (left<right){
            if(Math.abs(nums[left]-x)>Math.abs(nums[right]-x)) output[rightIndex--]=nums[right--];
            else if(Math.abs(nums[left]-x)<Math.abs(nums[right]-x)) output[leftIndex++]=nums[left++];
            else if(Math.abs(nums[left]-x)==Math.abs(nums[right]-x)){
                if(nums[left]<nums[right]) output[leftIndex++]=nums[left++];
                else output[rightIndex++]=nums[right++];
            }
        }

        return output;
    }


    /*
    Binary search
     */
    private int[] findclosest(int[] nums, int k, int x) {
        int low=0, high=nums.length-k;
        while (low<high){
            int mid=(low+high)/2;
            if(x-nums[mid]>nums[mid+k]-x){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        int[] output=new int[k];
        int index=0;
        for (int i=low;i<low+k;i++){
            output[index++]=nums[i];
        }
        return output;
    }
}
