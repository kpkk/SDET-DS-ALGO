package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P4_ProductSort {
    /*
    Given a list of items, sort the array based on number of items first then by values
    eg: int[]={4,5,6,5,4,3}
    output- [3,6,4,4,5,5]

    input- Integer array
    Output- integer array

     */
    @Test
    public void test1(){
        int[] nums={4,5,6,5,4,3};
        Assert.assertTrue(Arrays.equals(sortProducts(nums),new int[]{3,6,4,4,5,5}));
    }
    @Test
    public void test2(){
        int[] nums={3,2,1,4};
        Assert.assertTrue(Arrays.equals(sortProducts(nums),new int[]{1,2,3,4}));
    }
    @Test
    public void test3(){
        int[] nums={4,2,2,2};
        Assert.assertTrue(Arrays.equals(sortProducts(nums),new int[]{4,2,2,2}));
    }
    @Test
    public void test4(){
        int[] nums={};
        Assert.assertTrue(Arrays.equals(sortProducts(nums),new int[]{}));
    }

    /*
    - Initialize a tree map, integer as key and value as occurrence
    - create an int array of input length
    - iterate the array and push the entries into map
    - Load the entry set into an arraylist
    - then sort the list items based on values
    - add the keys alone, the value times into an array then return array

    		Collections.sort(collect, Map.Entry.comparingByValue());
     */
    // Time complexity- O(n*m)
    //Space complexity- O(n)
    private int[] sortProducts(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int[] resultArray=new int[nums.length];
        int  index=0;
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Map.Entry<Integer, Integer>> sortedEntries=new ArrayList<>(map.entrySet());
        Collections.sort(sortedEntries,Map.Entry.comparingByValue());
        ArrayList<Integer>output=new ArrayList<>();
        for (int i=0;i<sortedEntries.size();i++){
            Integer value = sortedEntries.get(i).getValue();
            while (value>0){
                output.add(sortedEntries.get(i).getKey());
                value--;
            }

        }
        for (int i=0;i<output.size();i++){
            resultArray[i]=output.get(i);
        }
        return resultArray;

    }
}
