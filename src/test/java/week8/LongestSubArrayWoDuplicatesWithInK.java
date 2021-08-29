package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

public class LongestSubArrayWoDuplicatesWithInK {
    /*
    You are given an array 𝐴 of of integers, length 𝑁. What is the longest ("sub") array you can generate from 𝐴, such that there are no duplicates within distance 𝐾 of one another. The ("sub") array must be constructed by removing values from 𝐴, i.e., the order must be preserved, but any entry may be skipped/ignored/removed.
Trivial example: For 𝐾=1, 𝐴=[1,2,1,3,2], the answer is: 5 ([1,2,1,3,2]).
Non-trivial example: For 𝐾=2, 𝐴=[1,2,1,3,2], the answer is: 4 ([2,1,3,2]).
Note that in the non-trivial example, we had to skip the first element, such that we could add both 2's; else we would have had [1,2,3].
Desired solution is O(N).

Hashmap, index- sliding window

     */
    /*
    Input- Integer array, int value
    output- Integer

     */
    @Test
    public void test1(){
        int[]nums={1,2,1,3,2};
        int k=1;
        Assert.assertEquals(findSubArrayWoDups(nums,k),5);
    }
    @Test
    public void test2(){
        int[]nums={1,2,1,3,2};
        int k=2;
        Assert.assertEquals(findSubArrayWoDups(nums,k),4);
    }
    @Test
    public void test3(){
        int[]nums={1,2,1,2};
        int k=2;
        Assert.assertEquals(findSubArrayWoDups(nums,k),2);
    }
    @Test
    public void test4(){
        int[]nums={1,1};
        int k=2;
        Assert.assertEquals(findSubArrayWoDups(nums,k),1);
    }

    /*
    - Initialize two pointers left=0, right=0, maxLength=Integer.MIN_VALUE
    - Initialize a hashmap with integer as key and value
    - Iterate the array from start index until end
    - if the number present in map, then calculate the distance between the prev index and curent index
        - if the distance is less than or equals to key then calculate the length and move the pointer left and right=left+1
        - else put the netry in map and continue
    - return the ma length

     */
    private int findSubArrayWoDups(int[] nums, int k) {
        int left=0, right=0, maxLength= Integer.MIN_VALUE;
        if(nums.length==0) return 0;
        if(k>nums.length) throw new RuntimeException("Invalid input combination, k is higher than array length");
        HashMap<Integer,Integer>map=new HashMap<>();
        for (right=0;right<nums.length;right++){
            if(map.containsKey(nums[right]) && right-map.get(nums[right])<=k){
                map.put(nums[right],right);
                left++;
            }else{
                map.put(nums[right],right);
                maxLength=Math.max(maxLength,right-left+1);
            }
        }
        return maxLength;
    }
}
