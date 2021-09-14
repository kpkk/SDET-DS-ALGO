package workshop;

import org.junit.Assert;
import org.junit.Test;
import sun.net.util.IPAddressUtil;

import java.util.HashMap;
import java.util.Map;

import static afu.org.checkerframework.checker.units.UnitsTools.K;

public class CountSubArraysDivisibleByK {

    /*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
2 <= k <= 104
     */
    @Test
    public void test1(){
        int [] nums={4,5,0,-2,-3,1};
        int k=5;
        Assert.assertEquals(findSubArraysUsingMap(nums,k),7);
    }
    @Test
    public void test2(){
        int [] nums={5};
        int k=9;
        Assert.assertEquals(findSubArraysUsingMap(nums,k),0);
    }

    /*
    Solution:- using hashmap and prefix sum
    - initialize a hashmap integer as key and value, two variables sum=0, count=0
    - put an initial entry as 0,1
    - iterate the array from start index until the end
    - add number at every index to i to sum and calculate the reminder
    - if map contains the reminder then increment the count
     */



    /*
    Solution:-
    - The idea behind this problem was to calculate the prefix sum of the array
    - since the ask is to find the number of subarrays divisible by k, we need to calculate the reminder of the running sum
    Note:- there can only be k diff reminder values possible, so create an additional space (array) of k size to keep track of the number of times each reminder value repeated

    Pseudo code:-
    - Initialize an integer array of k size
    - initialize variables called sum=0, reminder=0
    - iterate the array and append the value at the index to sum calculate the
    - get the reminder of the sum and append that to reminder (if the reminder is -ve, add k to it)
    - initialize the reminder value index of the new array
    - initialize a new variable called count and assign the first index value of new array to it
    - iterate the array from start until end and calculate the number of subarrays (subArrayCount[i]*subArrayCount[i]-1/2)
    - return the count

     */
    private int findSubArraysDivisibleByK(int[] nums, int k) {
        int[] subArrayCount=new int[k];
        int reminder=0, sum=0 ;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            reminder=sum<0?sum%k+k:sum%k;
            subArrayCount[reminder]++;
        }
        int count=subArrayCount[0];
        for (int i=0;i<subArrayCount.length;i++){
            count+=subArrayCount[i]*(subArrayCount[i]-1)/2;
        }
        return count;
    }

    /*
    - Initialize a hashmap,integer as key and value
    - initialize variables called sum=0, count=0
    - iterate the array from start index until the end, keep adding the number at index
    - calculate the reminder
    - if map has the reminder already then update the count else put the entry in the map

     */
    private int findSubArraysUsingMap(int[] nums, int k){
       HashMap<Integer,Integer>map=new HashMap<>();
       map.put(0,1);
       int count=0, sum=0, reminder=0;
       for (int i=0;i<nums.length;i++){
           sum+=nums[i];
           reminder=sum<0?(sum+k):sum%k;
           count+=map.getOrDefault(reminder,0);
           map.put(reminder,map.getOrDefault(reminder,0)+1);
       }
       return count;
    }
}
