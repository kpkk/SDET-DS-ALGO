package dunZo;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumSubArray {

    /*
    2) Find the subarray with max sum
Input={-2,1,-3,4,-1,2,1,-5,4}
Output=6
     */
    @Test
    public void test(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(findSum(nums),6);
    }

    private int findSum(int[] nums) {
        int windowSum=nums[0], maxSum=nums[0];
        for (int i=1;i<nums.length;i++){
            windowSum=Math.max(nums[i],windowSum+nums[i]);
            maxSum=Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
}
