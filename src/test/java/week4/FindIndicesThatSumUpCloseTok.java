package week4;

import org.junit.Assert;
import org.junit.Test;

public class FindIndicesThatSumUpCloseTok {

    /*
    Given an integer array, find a sum of any two numbers less than given target value, find the max or closest sum which is less than k

Int [] = {12, 15, 20}
Int k = 18
Return the indices of the values {-1,-1}

Int [] = {25, 15, 10, 40}
Int k= 35
New int[]{1,2}

Int []={}
Return new int[]{-1,-1}


     */
    @Test
    public void test1(){
        int[] nums={12,15,20,10,45,39};
        int k=40;
        int[] ans={1,2};
        Assert.assertArrayEquals(findIndices(nums,k),ans);
    }
    @Test
    public void test2(){
        int[] nums={};
        int k=40;
        int[] ans={-1,-1};
        Assert.assertArrayEquals(findIndices(nums,k),ans);
    }
    @Test
    public void test3(){
        int[] nums={2,3,1,4,6,8};
        int k=6;
        int[] ans={0,1};
        Assert.assertArrayEquals(findIndices(nums,k),ans);
    }
    @Test
    public void test4(){
        int[] nums={2,-3,-1,4,-6,8};
        int k=1;
        int[] ans={0,1};
        Assert.assertArrayEquals(findIndices(nums,k),ans);
    }

    private int[] findIndices(int[] nums, int k) {
        int max=Integer.MIN_VALUE, currentMax=Integer.MIN_VALUE;
        int[] indices=new int[2];
        boolean isSumEverLessThanTarget=false;
        for (int i=0;i<nums.length-1;i++){
            for (int j=0;j<nums.length-1;j++){
                int current_sum=nums[i]+nums[j];
                if(current_sum<k && current_sum>max){
                    isSumEverLessThanTarget=true;
                    max=Math.max(max,current_sum);
                    indices[0]=i;
                    indices[1]=j;
                }
            }
        }
        return (!isSumEverLessThanTarget)?new int[]{-1,-1}:indices;
    }
}
