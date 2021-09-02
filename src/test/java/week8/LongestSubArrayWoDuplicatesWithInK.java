package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Test
    public void test5(){
        int[]nums={1,1,1,1,5,4,6,7};
        int k=2;
        Assert.assertEquals(findSubArrayWoDups(nums,k),5);
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
    /*
    - Initialize a hashmap of integer as key and value
    - initialize two pointers i=0, j=0
    - iterate the array from start index until the end-k
    - if map doesn't contain the current value then add that to the map
    - else, calculate the difference between map value (prev index) and current index
        - if the difference is <=k then store the indices and continue to the next iteration

     */
    //1 2 1 3 2  k=2
    @Test
    public void test6(){
        int[]nums={1,2,1,3,2};
        int k=1;
        Assert.assertArrayEquals(findLoingestSubArray(nums,k),new int[]{1,2,1,3,2});
    }
    @Test
    public void test7(){
        int[]nums={1,2,1,3,2};
        int k=2;
        Assert.assertArrayEquals(findLoingestSubArray(nums,k),new int[]{2,1,3,2});
    }
    @Test
    public void test8(){
        int[]nums={1,2,1,2};
        int k=2;
        Assert.assertArrayEquals(findLoingestSubArray(nums,k),new int[]{});
    }
    @Test
    public void test9(){
        int[]nums={1,1};
        int k=2;
        Assert.assertArrayEquals(findLoingestSubArray(nums,k),new int[]{});
    }
    @Test
    public void test10(){
        int[]nums={1,1,1,1,5,4,6,7};
        int k=2;
        Assert.assertArrayEquals(findLoingestSubArray(nums,k),new int[]{1,5,4,6,7});
    }
    // 1 2 1 3 2 k=2
    private int[] returnMaxSubArray(int[] nums, int k){
        if(nums.length<=k) return new int[]{};
        int startIndex=0,endIndex=0, maxLength=0;
        for (int i=0;i<nums.length-k;i++){
            HashMap<Integer,Integer>map=new HashMap<>();
            for (int j=i;j<nums.length;j++){
                if(map.containsKey(nums[j]) && j-map.get(nums[j])<=k){
                    if(endIndex-startIndex<j-i && j-i>k){
                        startIndex=i;
                        endIndex=j;
                    }
                    break;
                }
                else{
                    map.put(nums[j],j);
                    if(endIndex-startIndex<j-i && j-i>k){
                        startIndex=i;
                        endIndex=j;
                    }
                }
            }
        }
        if(startIndex==0 && endIndex==0) return new int[]{};
        return Arrays.copyOfRange(nums,startIndex,endIndex+1);
    }
    /*
    - Initialize a hashmap integer as key and value
    - Initialize an arraylist of integer type
    - iterate the array from start index until end
    - if map doesn't contain the current value, then add to the map and list
    - if map contains element compute the difference of indices between the current and prev
        - if it lies within k then remove that element from list and add again and also replace the new occurrence in map
    - convert the list into an array and return
     */

    // 1 2 2 3 2 k=2
    @Test
    public void test11(){
        int[]nums={1,2,2,3,2};
        int k=2;
        Assert.assertArrayEquals(findLoingestSubArray(nums,k),new int[]{1,3,2});
    }
    private int[] findLoingestSubArray(int[] nums, int k){
        if(nums.length<=k) return new int[]{};
        HashMap<Integer,Integer>map=new HashMap<>();
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k){
                list.remove((Integer)nums[i]);
                map.put(nums[i],i);
                list.add(nums[i]);
            }else{
                map.put(nums[i],i);
                list.add(nums[i]);
            }
        }
       if(list.size()<=k) return new int[]{};
        int[] output=new int[list.size()];
        for (int i=0;i<list.size();i++){
            output[i]=list.get(i);
        }
        return output;
    }
}
