package practise;

import com.sun.tracing.dtrace.ArgsAttributes;
import org.junit.Assert;
import org.junit.Test;

public class LongSubArrayLength {
    /*
     Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.



Example 1:

Input: nums = [8,2,4,7], limit = 4
Output: 2
Explanation: All subarrays are:
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4.
Therefore, the size of the longest subarray is 2.
Example 2:

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
Example 3:

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3
     */

@Test
public void test1(){
    int[] nums={10,1,2,4,7,2};
    int limit=5;
    int output=4;
    Assert.assertEquals(findlength(nums,limit),output);
}

/*
- initialize variables maxLength=Integer.MIN_VALUE, min=Integer.MAX_VALUE and max=Integer.MIN_VALUE
- initialize two pointers left=0, right=0
- while left and right reaches length
- find the min between left, right and min between current min and found min
- find the max between left, right and max between current max and found max
- check if the absolute difference between min and max is<=k
    - if yes, keep moving the right pointer
    - update the max of maxLength
    - if No, increment left and assign it to right
    - set the min and max with nums[left]
- return the maxLength

 */
    private int findlength(int[] nums,int k) {

        int maxLength=Integer.MIN_VALUE, min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int left=0,right=0;
        while (left<nums.length && right<nums.length){
            min=Math.min(min,Math.min(nums[left],nums[right]));
            max=Math.max(max,Math.max(nums[left],nums[right]));
            if(Math.abs(max-min)<=k){
               maxLength=Math.max(maxLength,right-left+1);
                right++;
            }else{
                right=++left;
                min=nums[left];
                max=nums[left];
            }
        }
    return maxLength;
    }
}
