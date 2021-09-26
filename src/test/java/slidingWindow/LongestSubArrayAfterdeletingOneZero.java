package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubArrayAfterdeletingOneZero {

    /*
    Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.



Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
Example 4:

Input: nums = [1,1,0,0,1,1,1,0,1]
Output: 4
Example 5:

Input: nums = [0,0,0]
Output: 0


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
     */
    @Test
    public void test1(){
        int[] nums={1,1,0,1};
        Assert.assertEquals(longestSubarray(nums),3);
    }
    @Test
    public void test2(){
        int[] nums={0,1,1,1,0,1,1,0,1};
        Assert.assertEquals(longestSubarray(nums),5);
    }
    @Test
    public void test3(){
        int[] nums={1,1,0,1};
        Assert.assertEquals(longestSubarray(nums),3);
    }
    @Test
    public void test4(){
        int[] nums={1,1,1};
        Assert.assertEquals(longestSubarray(nums),2);
    }

    public int longestSubarray(int[] nums) {
        int zeroCount = 0, maxLength = 0, j=0;
        for (int i = 0; i < nums.length; i++) {
            zeroCount = 0;
            for (j = i; j < nums.length; j++) {
                if (nums[j] == 0) zeroCount++;
                if(zeroCount==2){
                    break;
                }
            }
            maxLength=Math.max(maxLength,((j-i)-zeroCount));

        }
        return zeroCount==0?maxLength-1:maxLength;
    }
}
