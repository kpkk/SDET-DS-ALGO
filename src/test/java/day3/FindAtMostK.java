package day3;

import org.junit.Assert;
import org.junit.Test;

public class FindAtMostK {
    /*

    10. Given an array of integers and an integer k, find out whether there are two   distinct indices i and j in the array such that nums[i] = nums[j]  and the absolute difference between i and j is at most k.
     Example 1:   Input: nums = [1,2,3,1], k = 3    Output: true
      Example 2:    Input: nums = [1,0,1,1], k = 1    Output: true
      Example 3:    Input: nums = [1,2,3,1,2,3], k = 2 Output: false
      Example 3:    Input: nums = [1,2,3,2,2,3], k = 2    Output: true

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? integer array
        What is the expected output? boolean
        Do I’ve constraints to solve the problem? yes, use sliding window
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
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data
10. If it fails then debug to solve it
11. Optimize the code and remove unnecessary code
     */

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean result = true;
        Assert.assertEquals(result, isDistanceAtmostK(nums, k));

    }

    @Test
    public void test2() {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        boolean result = true;
        Assert.assertEquals(result, isDistanceAtmostK(nums, k));

    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean result = false;
        Assert.assertEquals(result, isDistanceAtmostK(nums, k));

    }

    @Test
    public void test4() {
        int[] nums = {7, 8, 13, 6, 7, 14, 3};
        int k = 4;
        boolean result = true;
        Assert.assertEquals(result, isDistanceAtmostK(nums, k));

    }
    /*
    solution:-
    1. Traverse through the array from start using point i -0 index
    2. traverse through the array from next index using j i--> 1 index
    3. Compare if the value at index i and j are same
        a. if yes, calculate the difference between j and i
            - if th difference is less than k then return true
            - else return false

     */

    //Time complexity- O(n^2)
    //space complexity- O(1)
    private boolean isDistanceAtmostK(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (j - i <= k) return true;
                }
            }
        }
        return false;
    }

    private boolean isDistanceAtmostKOptimized(int[] nums, int k) {

        return false;
    }

}
