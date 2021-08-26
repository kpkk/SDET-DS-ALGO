package week7;

import org.junit.Assert;
import org.junit.Test;

public class TrapWater {

    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
     */

    @Test
    public void test1(){
        int[] nums={0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(trap(nums),6);
    }
    @Test
    public void test2(){
        int[] nums={4,2,0,3,2,5};
        Assert.assertEquals(trapWater(nums),9);
    }

    /*
    Solution- brute force
    - Initialize variable called sum=0;
    - initialize two pointers leftHeight=0, rightHeight=0;
    - Iterate the array from start index until end
    - for every index calculate the leftMax and rightMax height
        - iterate in an inner loop from start index until i to find the lefMax height
        - iterate in another inner loop from i till the end to find the max right Height
    - add the min of leftHeight and rightHeight and add to the sum, subtract the current index value
    - return sum
     */

    //Time complexity- O(n)
    //space complexity- O(1)

    private int trapWater(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
           int leftHeight=0, rightheight=0;
            for (int j=0;j<=i;j++){
                leftHeight=Math.max(leftHeight,nums[j]);
            }
            for (int j=i;j<nums.length;j++){
                rightheight=Math.max(rightheight,nums[j]);
            }
            sum+=Math.min(leftHeight,rightheight)-nums[i];
        }
        return sum;
    }

    public int trap(int[] height) {
        int sum=0;
        int[] leftHeight=new int[height.length];
        int[] rightHeight=new int[height.length];
        leftHeight[0]=height[0];
        rightHeight[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++){
            leftHeight[i]=Math.max(leftHeight[i-1],height[i]);
        }
        for(int i=height.length-2;i>=0;i--){
            rightHeight[i]=Math.max(height[i],rightHeight[i+1]);
        }
        for(int i=0;i<height.length;i++){
            sum+=(Math.min(leftHeight[i],rightHeight[i])-height[i]);
        }
        return sum;
    }
}
