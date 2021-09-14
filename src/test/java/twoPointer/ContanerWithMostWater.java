package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class ContanerWithMostWater {
    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

     */
    @Test
    public void test1(){
        int[] nums={1,8,6,2,5,4,8,3,7};
        Assert.assertEquals(findMaxContainerWidth(nums),49);
    }
    @Test
    public void test2(){
        int[] nums={4,3,2,1,4};
        Assert.assertEquals(findMaxContainerWidth(nums),16);
    }
    @Test
    public void test3(){
        int[] nums={1,2,1};
        Assert.assertEquals(findMaxContainerWidth(nums),2);
    }

    /*
    - Initialize two pointers with left=0, right=nums.length-1 and maxArea=0
    - Since the idea is to find the max width we need to get the min and with max width (distance between start and end indexes)
    - find the min height of the wall, between the two indices
    - find the maxArear= small wall height
    - keep finding the max area and return the maxarea
     */
    private int findMaxContainerWidth(int[] nums) {
        int left=0, right=nums.length-1,maxArea=0;
        while (left<=right){
            int minHeight=Math.min(nums[left],nums[right]);
            maxArea=Math.max(minHeight*(right-left),maxArea);
            if(nums[left]<nums[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
