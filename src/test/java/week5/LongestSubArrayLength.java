package week5;

import org.junit.Assert;
import org.junit.Test;
import sun.java2d.pipe.OutlineTextRenderer;

import java.util.*;

public class LongestSubArrayLength {

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

    /*[8,2,4,7], limit = 4
    Aproach: brute force

    - Traverse the array from index=0, initialize a variable called max=0;
    - calculate the absolute diff between nums[i]-nums[i] and store that in indices array
    - traverse the array from one position after(i+1) (inner loop)
    - calculate the abs difference between i and j
        - if the value is less than or equals to limit, grow
        - while growing check if the nums [i] & and nums[j] difference is also within or equals to limit, if yes, grow
            - else break, and calculate j-i+1
        - if the value is greater than limit then break and store the length as j-i+1, break
    - return the max subarray length


     */

    @Test
    public void test1(){
        int[]nums={8,2,4,7};
        int limit=4;
        Assert.assertEquals(longestSubArray(nums,limit),2);
    }
    @Test
    public void test2(){
        int[]nums={10,1,2,4,7,2};
        int limit=5;
        Assert.assertEquals(longestSubArray(nums,limit),4);
    }
    @Test
    public void test3(){
        int[]nums={4,2,2,2,4,4,2,2};
        int limit=0;
        Assert.assertEquals(longestSubArray(nums,limit),3);
    }
    @Test
    public void test4(){
        int[]nums={1,5,6,7,8,10,6,5,6};
        int limit=4;
        Assert.assertEquals(longestSubarray(nums,limit),5);
    }
    public int longestSubarray(int[] A, int limit) {
        int i = 0, j;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (j = 0; j < A.length; j++) {
            m.put(A[j], 1 + m.getOrDefault(A[j], 0));
            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(A[i], m.get(A[i]) - 1);
                if (m.get(A[i]) == 0)
                    m.remove(A[i]);
                i++;
            }
        }
        return j - i;
    }


    private int findSubArrayLength(int[] nums, int limit) {
        int maxLength=0;
        for (int i=0;i<nums.length;i++){
            maxLength=Math.max(maxLength,1);
            for (int j=i+1;j<nums.length;j++){
                if(Math.abs(nums[j]-nums[i])<=limit) maxLength=Math.max(maxLength,j-i+1);
                else break;
            }
        }
        return maxLength;
    }

    /*
    Approach:- Queue+ sliding window
    - Initialize a queue of integer type, an integer variable max=0 also pointers left=0, right=1
    - while left reaches the length
    - offer the element at left into queue, then move left
    - then check the difference between, queue.peek() and value at right is <=limit then offer to queue, right++
    - keep calculating the max queue size (sub array length)
    - If the absolute difference goes beyond
        - while the queue is not empty poll the elements
    - return maxlength

     */
    private int findLengthUsingQueue(int[] nums, int limit) {

        int left = 0, right = 0, maxLength = 1;
        ArrayDeque<Integer> minQueue = new ArrayDeque<>();
        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
        minQueue.offer(Integer.MAX_VALUE);
        maxQueue.offer(Integer.MIN_VALUE);
        while (left < nums.length && right < nums.length) {
            minQueue.offer(Math.min(minQueue.poll(),Math.min(nums[left],nums[right])));
            maxQueue.offer(Math.max(maxQueue.poll(),Math.max(nums[left],nums[right])));

            if(Math.abs(maxQueue.peek()-minQueue.peek())<=limit){
                maxLength= Math.max(maxLength,right-left+1);
                right++;
            }else{
                right=++left;
                minQueue.poll();
                maxQueue.poll();
                minQueue.offer(nums[left]);
                maxQueue.offer(nums[right]);
            }

        }
        return maxLength;
    }






    private int longestSubArray(int[] nums, int limit) {

        int left = 0, right = 0;
        int longest = Integer.MIN_VALUE, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while(left < nums.length && right < nums.length) {

            // find the min and max for the absolute difference
            min = Math.min(min, Math.min(nums[left], nums[right]));
            max = Math.max(max, Math.max(nums[left], nums[right]));

            // Check with the limit
            if(Math.abs(max-min) <= limit) {
                longest = Math.max(longest, right-left+1);
                right++;
            } else {
                right = ++left;
                min = nums[left];
                max = nums[left];
            }

        }
        return longest;

    }
}
