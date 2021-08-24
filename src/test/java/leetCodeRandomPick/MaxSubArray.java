package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubArray {

    @Test
    public void test1(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(maxSubArray(nums),6);

    }

    public int maxSubArray(int[] nums) {
        int windowSum=nums[0], maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            windowSum=Math.max(nums[i],windowSum+nums[i]);
            maxSum=Math.max(windowSum,maxSum);
        }
        return maxSum;
    }
}
