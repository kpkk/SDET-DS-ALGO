package day5;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageTranscoder;
import java.util.HashMap;
import java.util.HashSet;

public class FindSecondMaxNumber {

    /*
    given an integer array find the second max number

    what if multiple matches present?

     */
    @Test
    public void test1(){
        int[] nums={1,2,3,4};
        Assert.assertEquals(findSecondMaxBruteForce(nums),3);

 }
    @Test
    public void test2(){
        int[] nums={1,2,3,3,4,4};
        Assert.assertEquals(findSecondMaxBruteForce(nums),3);

    }
    @Test(expected = RuntimeException.class)
    public void test3(){
        int[] nums={2,2,2,2};
        Assert.assertEquals(findSecondMax(nums),-1);

    }
    @Test(expected = RuntimeException.class)
    public void test4(){
        int[] nums={};
        Assert.assertEquals(findSecondMax(nums),-1);

    }

    /*
    Solution:-
    - If the length of the array is zero throw an exception
    - Initialize variables left=0, right=length-1
    - sort the array
    - If the first element and last element are same then return -1 (no second max)
    - else return the last but one element

     */


    private int findSecondMax(int [] nums){
        int max = Math.max(nums[0], nums[1]);
        int secondMax= Math.min(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            if(nums[i]>max){
                secondMax=max;
                max=nums[i];
            }else{
                Math.max(secondMax,nums[i]);
            }
        }
        if(secondMax==max) throw new RuntimeException("no second max");
        return secondMax;
    }

    private int findSecondMaxBruteForce(int[] nums) {
        if(nums.length==0) throw new RuntimeException("empty array");
        int left=0, right=nums.length-1;
        while (left<right){
            if(nums[left]>nums[right]){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
            left++;
            right--;
        }
        if(nums[0]==nums[nums.length-1]) throw new RuntimeException("no second max available");
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[i-1]) return nums[i-1];
        }
        return -1;
    }
}

/*
 private int findSecondMax(int[] nums) {
        if(nums.length==0) throw new RuntimeException("empty array");
        HashSet<Integer>set=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
       int left=0, right=nums.length-1;
       while (left>=right){
           if(nums[left]>nums[right]){
               int temp=nums[left];
               nums[left++]=nums[right];
               nums[right--]=temp;
           }
        }
       if(nums[0]==nums[nums.length-1]) throw new RuntimeException("no second max available");
       return nums[nums.length-2];
    }
 */
