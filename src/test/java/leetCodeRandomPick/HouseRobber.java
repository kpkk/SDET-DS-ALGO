package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

public class HouseRobber {
    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
     */
    @Test
    public void test1(){
        int[] nums={1,2,3,1};
        Assert.assertEquals(rob(nums),4);
    }
    @Test
    public void test3(){
        int[] nums={2,7,9,3,1};
        Assert.assertEquals(rob(nums),12);
    }
    @Test
    public void test4(){
        int[] nums={1,3,1};
        Assert.assertEquals(rob(nums),3);
    }
    @Test
    public void test5(){
        int[] nums={2,1,1,2};
        Assert.assertEquals(rob(nums),4);
    }


    public int rob(int[] nums) {
        int [] dp= new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i+1]=Math.max(dp[i],dp[i-1]+nums[i]);
        }
        return dp[dp.length-1];
    }

    public int bruteForce(int[] nums) {
      int maxSum=0;
      for (int i=0;i<nums.length-2;i++){
          int currentSum=nums[i];
          for (int j=i+2;j<nums.length;j+=2){
              currentSum+=nums[j];
          }
          maxSum=Math.max(maxSum,currentSum);
      }
      return maxSum;
    }
}
