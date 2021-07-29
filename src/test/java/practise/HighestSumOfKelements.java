package practise;

import org.junit.Assert;
import org.junit.Test;

public class HighestSumOfKelements {

    /*
    find the highest sum of k consecutive elements

     */

    @Test
    public void test1(){
        int[] nums={1,5,2,3,7,1};
        int target=3;
        Assert.assertEquals(slidingWindow(nums,target),12);
    }

    private int slidingWindow(int[] nums,int k){
        int sum=0, maxSum=0;
        for (int i=0;i<k;i++){
            sum+=nums[i];
        }
        for (int i=1;i<nums.length-k;i++){
            sum+=nums[i+k-1]-nums[i-1];
            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;
    }
}
