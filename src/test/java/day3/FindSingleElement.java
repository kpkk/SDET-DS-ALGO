package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindSingleElement {

    /*

    1) Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.


Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4


1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? Integer array
        What is the expected output?  integer
        Do I’ve constraints to solve the problem? constant space O(1 )and linear time O(n)
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
    public void test1(){
        int[] nums={2,2,1};
        int element=1;
        Assert.assertEquals(findUniqueElement(nums),element);
    }
    @Test
    public void test2(){
        int[] nums={4,1,2,1,2};
        int element=4;
        Assert.assertEquals(findUniqueElement(nums),element);
    }
    @Test
    public void test3(){
        int[] nums={5};
        int element=5;
        Assert.assertEquals(findUniqueElement(nums),element);
    }

    /*
    Solution:-

    1. Sort the given array (nums)
    2. Initialize two pointers p1=0 and p2=1
    3. Compare the values at p1 and p2 if they are not equal then return nums[p1]
    4. if both are equal increment p1 and p2 by 2 positions and keep moving

     */

    // Time complexity- O(n)
    //space complexity- O(n) --since the sort function is called
    private int findUniqueElement(int[] nums){
        Arrays.sort(nums);
        int p1=0, p2=1;
        while (p2<nums.length-1){
            if(nums[p1]==nums[p2]) {
                p1=p2+1;
                p2=p1+1;
            }else {
                return nums[p1];
            }
        }
        System.out.println(nums[p1]);
        return nums[p1];
    }
}
