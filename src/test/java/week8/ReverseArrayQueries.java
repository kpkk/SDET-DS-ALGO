package week8;

import org.junit.Assert;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReverseArrayQueries {
    /*
    int=
     */
    @Test
    public void test1(){
        int[]nums={5,3,2,1,3};
        int[] [] operations={{0,1},{1,3}};
        Assert.assertArrayEquals(reverseArray(nums,operations),new int[]{3,1,2,5,3});
    }
    @Test
    public void test2(){
        int[]nums={1,2,3};
        int[] [] operations={{0,2},{1,2},{0,2}};
        Assert.assertArrayEquals(reverseArray(nums,operations),new int[]{2,1,3});
    }
    @Test
    public void test3(){
        int[]nums={5,2,5,1};
        int[] [] operations={{1,2},{1,1}};
        Assert.assertArrayEquals(reverseArray(nums,operations),new int[]{5,5,2,1});
    }

    private int[] reverseArray(int[] nums, int[][] operations) {
        for (int i=0;i<operations.length;i++){
            int startIndex=operations[i][0];
            int endIndex=operations[i][1];
            while (startIndex<endIndex){
                int temp=nums[startIndex];
                nums[startIndex++]=nums[endIndex];
                nums[endIndex--]=temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
    @Test
    public void test4(){
       List<Integer> nums=Arrays.asList(5,3,2,1,3);
        List<List<Integer>>operations= Arrays.asList(Arrays.asList(0,1),Arrays.asList(1,3));
        Assert.assertEquals(reverseArrayUsingStack(nums,operations),Arrays.asList(3,1,2,5,3));
    }
    private List<Integer> reverseArray2(List<Integer> nums, List<List<Integer>> operations){
        for (int i=0;i<operations.size();i++){
            int startIndex=operations.get(i).get(0);
            int endIndex=operations.get(i).get(1);
            while (startIndex<endIndex){
                int firstNumber=nums.get(startIndex);
                int secondNumber=nums.get(endIndex);
                nums.set(startIndex,secondNumber);
                nums.set(endIndex,firstNumber);
                startIndex++;
                endIndex--;
            }
        }
        return nums;
    }
    private List<Integer> reverseArrayUsingStack(List<Integer> nums, List<List<Integer>> operations){
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<operations.size();i++){
            int startIndex=operations.get(i).get(0);
            int endIndex=operations.get(i).get(1);
            for (int k=startIndex;k<=endIndex;k++){
                stack.push(nums.get(k));
            }
            for (int j=startIndex;j<=endIndex;j++){
                nums.set(j,stack.pop());
            }
        }
        return nums;
    }
}
