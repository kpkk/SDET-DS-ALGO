package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortColors {

    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


Example 1:

Input: nums = [2,0,2,1,1,0]   chars[white]<=2 && chars[blue]<=2
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Example 3:

Input: nums = [0]
Output: [0]

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? integer array
        What is the expected output? integer array
        Do I’ve constraints to solve the problem? don't use built in  sort function
        Do Ive all the information to go to the next steps
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this
5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code
9. Test against different test data
10. If it fails then debug to solve it
     */

    @Test
    public void test1() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] output = {0, 0, 1, 1, 2, 2};
        Assert.assertTrue(Arrays.equals(sortColors(nums),output));
    }

    @Test
    public void test2() {
        int[] nums = {2, 0, 1};
        int[] output = {0, 1, 2};
        Assert.assertTrue(Arrays.equals(sortColors(nums),output));
    }

    @Test
    public void test3() {
        int[] nums = {0};
        int[] output = {0};
        Assert.assertTrue(Arrays.equals(sortColors(nums),output));
    }

    /*
    Solution:-
    1. Initialize three variables called redCount, whiteCount, blueCount with 0 value
    2. Traverse the input array from start to the end index
    3. increment the respective color count variable when there is a match
    4. create an output array of same size as that of input
    5. copy the white, blue elements and decrement thier count,
         a. repeat step 5 until each counter is reduced to 0

     */

    private int[] sortColors(int[] nums) {
        if(nums.length<2) return nums;
       int whiteCount = 0, blueCount = 0;
        int[] outputArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) whiteCount++;
            if (nums[i] == 2) blueCount++;
        }
        int index = (outputArray.length) - (whiteCount + blueCount);
            while (whiteCount != 0) {
                outputArray[index++] = 1;
                whiteCount--;
            }
            while (blueCount != 0) {
                outputArray[index++] = 2;
                blueCount--;
            }

        return outputArray;
    }
}
