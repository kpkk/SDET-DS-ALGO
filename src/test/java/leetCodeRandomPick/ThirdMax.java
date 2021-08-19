package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ThirdMax {
    /*

    414. Third Maximum Number
Easy

1220

1961

Add to List

Share
Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.



Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
     */

    /*

     /*
        Initialize three variables called firstMaxnums=[0], secondMax=nums[1], thirdMax=Integer.MIN_VALUE;

        find the first and second max
        start the loop from i=2, index
        if the number is greater than max then
            - update the max as second max and second max as third max
        - else if the number is less than max
            - check if its greater than secondmax
                - if yes, then update secondmax as thirdmax and update the current as secind max
        - else current number is third max
        - if the second max and third max are same return max else third max

        */


    @Test
    public void test(){
        int[] nums={1,2,2,5,3,5};
        Assert.assertEquals(thirdMax(nums),2);
    }
    @Test
    public void test1(){
        int[] nums={1,2,2};
        Assert.assertEquals(thirdMax(nums),2);
    }
    @Test
    public void test2(){
        int[] nums={1,1,2};
        Assert.assertEquals(thirdMax(nums),2);
    }
    @Test
    public void test3(){
        int[] nums={1,2,Integer.MIN_VALUE};
        Assert.assertEquals(thirdMaxUsingPq(nums),Integer.MIN_VALUE);
    }
    @Test
    public void test4(){
        int[] nums={2,2,3,1};
        Assert.assertEquals(thirdMaxUsingPq(nums),1);
    }
    public int thirdMax(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        Arrays.sort(nums);
        int fMax=nums[0], sMax=nums[1],tMax=nums[2];
        fMax=Math.max(nums[0],nums[1]);
        sMax=Math.min(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            if(nums[i]>fMax){
                tMax=sMax;
                sMax=fMax;
                fMax=nums[i];
            }else if(nums[i]<fMax && nums[i]>sMax){
                tMax=sMax;
                sMax=nums[i];
            }
            }
        if(fMax==sMax) return fMax;
        if(sMax==tMax)return fMax;
        return tMax;
        }

   private int thirdMaxUsingPq(int[] nums){
       PriorityQueue<Integer> pq=new PriorityQueue();
       HashSet<Integer>set=new HashSet<>();
       for (int i=0;i<nums.length;i++){
           if(!pq.contains(nums[i])){
               pq.offer(nums[i]);
           }
           if(pq.size()>3) pq.poll();
       }
       if(pq.size()<3){
           while (pq.size()>1){
               pq.poll();
           }
       }
       return pq.poll();
    }
}


/*
if(nums.length==1) return nums[0];
        int firstMax=nums[0], secondMax=nums[1], thirdMax=Integer.MIN_VALUE;
        firstMax=Math.max(nums[0],nums[1]);
        secondMax=Math.min(nums[0], nums[1]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>firstMax){
                secondMax=firstMax;
                firstMax=nums[i];
            }
            if(firstMax==secondMax && nums[i]<secondMax){
                secondMax=nums[i];
            }
            if(nums[i]<firstMax && nums[i]>secondMax){
                secondMax=nums[i];
            }

        }
        if(nums.length==2) return firstMax;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>firstMax){
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax=nums[i];
            }else if(nums[i]<firstMax && nums[i]> secondMax){
                thirdMax=secondMax;
                secondMax=thirdMax;
            }else{
                if(nums[i]>thirdMax && nums[i]<secondMax)
                thirdMax=nums[i];
            }
        }
        return secondMax==thirdMax?firstMax:thirdMax;
 */