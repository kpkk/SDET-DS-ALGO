package week4;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    /*

    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
     */

    @Test
    public void test1(){
        int[] nums={100,4,200,1,3,2};
        int output=4;
        Assert.assertEquals(findConsecutive(nums),output);
    }
    @Test
    public void test2(){
        int[] nums={0,3,7,2,5,8,4,6,0,1};
        int output=9;
        Assert.assertEquals(findConsecutive(nums),output);
    }

    /*
    Approach- using hashset

    Solution:-

    - Initialize a hashset of Integer type
    - Initialize variables currentNumber, currentLength=1, maxLength=0
    - Iterate the given array and all numbers to the set
    -  Iterate the set,
           - check if the number-1 is present in the set
                - if present, set the currentNumber=num
                - set the current length as 1
                - also validate if the set has next numbers in it
                        - if present add that to the current number and current length
            - if not calculate the max length and return

     */

    private int findConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        int maxLength=0;
        for (int eachNum: nums){
            set.add(eachNum);
        }
        for (int number:set){
            if(!set.contains(number-1)){
                int currentNumber=number;
                int currentLength=1;
                while (set.contains(currentNumber+1)){
                    currentNumber+=1;
                    currentLength+=1;
                }
                maxLength=Math.max(currentLength,maxLength);
            }
        }

        return maxLength;
    }
}
