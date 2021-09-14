package workshop;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class CountSubArrays {
    /*
    Problem 2:

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 
Example 1:

Input: nums = [1,1,1], k = 2

Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Problem 3:

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 
Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6

Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
     */
    /*
    Input- integer array, int value
    output- int

     */
    @Test
    public void test1(){
        int[] nums={1,1,1};
        int k=2;
        Assert.assertEquals(countSubArraysusingMap(nums,k),2);
    }
    @Test
    public void test2(){
        int[] nums={1,2,3};
        int k=3;
        Assert.assertEquals(countSubArraysusingMap(nums,k),2);
    }
    @Test
    public void test3(){
        int[] nums={1,2,3};
        int k=7;
        Assert.assertEquals(countSubArraysusingMap(nums,k),0);
    }
    @Test
    public void test4(){
        int[] nums={1,1,1};
        int k=1;
        Assert.assertEquals(countSubArraysusingMap(nums,k),3);
    }
    @Test
    public void test5(){
        int[] nums={1};
        int k=0;
        Assert.assertEquals(countSubArraysusingMap(nums,k),0);
    }

    /*
    - Initialize two pointers left=0, right=0
    - initialize an int variable called sun
    - iterate the input array from start until end
    -  keep adding the numbers at right index to sum
        - if sum>k , increment left and decrease the sum
        - if sum matches the k value increment count
     - return count

     */
    private int countSubArrays(int[] nums, int k) {
        int sum=0, count=0;
        int j=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            while (sum>=k){
                if(sum==k) count++;
                sum-=nums[j];
                j++;

            }
        }
        return count;
    }
    private int countSubArraysBruteForce(int[] nums, int k){
        int count=0;
        for (int i=0;i<nums.length;i++){
            int sum=0;
            for (int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
    /*
    Pseudo code:-
    - Initialize a hashmap, of integer as key and value and an int variable sum=0
    - put an entry into the map with key as 0 and value as 1
    - iterate the array from start index until the end
    - check if the difference of sum and k present in the map
    - if yes, increment the count
    - else put the entry into the map
    - return the count
     */
    private int countSubArraysusingMap(int [] nums, int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0, count=0;
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)) count++;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}