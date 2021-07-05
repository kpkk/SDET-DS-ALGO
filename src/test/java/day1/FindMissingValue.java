package day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindMissingValue {

    /*

    4) Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Input: nums = [3,0,1]
Output: 2

 not sorted


1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? -> array
        What is the expected output? - integer element
        Do I’ve constraints to solve the problem? -  can we sort this?

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
        int[] nums={3,0,1};
        int k= 2;
        Assert.assertEquals(findMissing(nums),k);
    }


    @Test // throw a message saying none is missing
    public void test2(){
        int[] nums={1,0,2,3,4};
        int k= 5;
        Assert.assertEquals(findMissing(nums),k);
    }
    @Test // throw an exception
    public void test3(){
        int[] nums={};
        int k= 2;
        Assert.assertEquals(findMissing(nums),k);
    }


    /*

    Pseudo code:- bruteforce didn't work
    1. create an array of length n
    2. Iterate the loop from left to right and add the i values
    3. Then compare the arrays then return the first missing value

     */
    private int findMissing(int[] nums) {
        if(nums.length==0)
            throw new RuntimeException("empty array found");
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if(nums[i]>i){
                return i;
            }
        }
        return 0;
    }
}
