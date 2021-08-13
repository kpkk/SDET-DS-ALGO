package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.IconUIResource;
import java.util.HashSet;

public class ArrayNesting {
    /*
    ou are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].

You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:

The first element in s[k] starts with the selection of the element nums[k] of index = k.
The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
We stop adding right before a duplicate element occurs in s[k].
Return the longest length of a set s[k].



Example 1:

Input: nums = [5,4,0,3,1,6,2]
Output: 4
Explanation:
nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
One of the longest sets s[k]:
s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
Example 2:

Input: nums = [0,1,2]
Output: 1


Constraints:

1 <= nums.length <= 105
0 <= nums[i] < nums.length
All the values of nums are unique.
     */

    @Test
    public void test1(){
        int[] nums={5,4,0,3,1,6,2};
        Assert.assertEquals(findNestedEle(nums),4);
    }
    @Test
    public void test2(){
        int[] nums={0,1,2};
        Assert.assertEquals(findNestedEle(nums),1);
    }
    @Test
    public void test3(){
        int[] nums={};
        Assert.assertEquals(findNestedEle(nums),0);
    }

    /*
    - initialize a variable called maxLength, counter=1
    - iterate the array from start index until end
    - get the number
    - while the nums[number] !=nums[i]
    - get the nums[number]
    - increment the counter
    - update the maxLength of the counter
    - return maxLength

     */

    private int findNestedEle(int[] nums) {
        int  maxLength=0;
        for (int i=0;i<nums.length;i++){
            int counter=1;
            int number = nums[i];
            while (nums[number]!=nums[i]){
                number=nums[number];
                counter++;
            }
            maxLength=Math.max(maxLength,counter);
        }
        return maxLength;
    }
}
