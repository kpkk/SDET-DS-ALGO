package day5;

import org.junit.Test;

public class findmaxSum {

    /*

    Given an array of integers, return the highest sum of any consecutive elements in the array.

    {1,-5,2,-3,7,1}
     */
    @Test
    public void test1(){
        int[] nums={1,-5,2,-3,7,1};
        int output=8;
        System.out.println(findMaxSum(nums));
    }
    @Test
    public void test2(){
        int[] nums={1,1,2,3,7,1};
        int output=15;
        System.out.println(findMaxSum(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,-5,6,7,-8,3,2,6};
        int output=14;
        System.out.println(findMaxSum(nums));
    }

    private int findMaxSum(int nums[]){
       int maxSum=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            int sum=0;
            for (int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                maxSum=Math.max(sum,maxSum);
            }
        }
        return maxSum;
    }
    @Test
    public void test5(){
        int[] nums={1,-5,2,-3,7,1};
        int k=3;
        int output=8;
        System.out.println(maxSum(nums,k));
    }
    @Test
    public void test6(){
        int[] nums={20,-5,-1};
        int k=3;
        int output=8;
        System.out.println(maxSum(nums,k));
    }
    @Test
    public void test4(){
        int[] nums={1,-5,6,7,-8,3,2,6};
        int output=14;
        int k=3;
        System.out.println(maxSum(nums,k));
    }
    public int maxSum(int[] nums, int k){
        int maxSum=Integer.MIN_VALUE, sum=0;
        for (int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxSum=Math.max(maxSum,sum);
        for (int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
