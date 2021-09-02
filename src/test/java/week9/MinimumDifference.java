package week9;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinimumDifference {
    /*
    Input - [4,3,2,1]
    output- (4+1)-(3+2)=0

     */
    @Test
    public void test1(){
        int[]nums={4,3,2,1};
        Assert.assertEquals(canPartition(nums),0);
    }
    @Test
    public void test2(){
        int[]nums={3,5,1,9};
        Assert.assertEquals(canPartition(nums),2);
    }
    @Test
    public void test3(){
        int[]nums={3,5};
        Assert.assertEquals(canPartition(nums),2);
    }

    /*
    - Sort the array
    - initialize two pointers L=0, R=nums.length-1 also firstSetSum=0, secondSetSum=0
    - while left<right
    - add the values at left and right, increment left and decrement right
    - return the absolute diff
     */
    private int findDifference(int[] nums) {
        if(nums.length==2) return Math.abs(nums[0]-nums[1]);
        int leftSum=0, rightSum=0, left=0, right=nums.length-1;
        Arrays.sort(nums);
        while (left<right){
            leftSum+=nums[left++]+nums[right--];
            rightSum+=nums[left++]+nums[right--];
        }
        return Math.abs(leftSum-rightSum);
    }
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return false;
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        boolean dp[] = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[subSetSum];
    }

}
