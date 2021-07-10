package day2;

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
    public void test1() {
        int[] nums = {3, 0, 1};
        int k = 2;
        Assert.assertEquals(findMissing(nums), k);
        Assert.assertEquals(bruteForce2(nums), k);
        Assert.assertEquals(findMissingusingSum(nums), k);

    }


    @Test // throw a message saying none is missing
    public void test2() {
        int[] nums = {1, 0, 2, 3, 4};
        int k = 5;
     //   Assert.assertEquals(findMissing(nums), k);
        Assert.assertEquals(bruteForce2(nums), k);
        Assert.assertEquals(findMissingusingSum(nums), 0);
    }

    @Test // throw an exception
    public void test3() {
        int[] nums = {};
        int k = 2;
        Assert.assertEquals(findMissing(nums), k);
        Assert.assertEquals(bruteForce2(nums), 0);
    }
    @Test // throw an exception
    public void test78() {
        int[] nums = {20,23,22,24};
        int k = 21;
       // Assert.assertEquals(bruteForce(nums), k);
      // Assert.assertEquals(bruteForce2(nums), k);
        Assert.assertEquals(findMissingusingSum(nums), k);
    }


    /*

    Pseudo code:- bruteforce didn't work
    1. create an array of length n
    2. Iterate the loop from left to right and add the i values
    3. Then compare the arrays then return the first missing value

     */

    // Time complexity - O(n log n)
    //Space complexity - O(1)
    private int findMissing(int[] nums) {
        if (nums.length == 0)
            throw new RuntimeException("empty array found");
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > i) {
                return i;
            }
        }
        return -1;
    }

       /*

    Pseudo code:-
    1. sort the given array
    2. Then iterate the given array using two pointers forward direction
    3. if number doesn't present then return the element
     */

    // Time Complexity- O(n logn)
    //space complexity- O(1)
    public int bruteForce2(int[] nums){

        if (nums.length<=1)
            throw new RuntimeException("empty array");
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]!=1) return nums[i]-1;
        }
        return 0;
    }

    @Test
    public void test5() {
        int[] nums = {};
        int i = bruteForce(nums);
        System.out.println(i);
    }

    @Test
    public void test6() {
        int[] nums = {0};
        int i = bruteForce(nums);
        System.out.println(i);
    }

    @Test
    public void test7() {
        int[] nums = {1};
        int i = bruteForce(nums);
        System.out.println(i);
    }

    @Test
    public void test4() {
        int[] nums = {0, 2, 1, 3};
        int i = bruteForce(nums);
        System.out.println(i);
    }

    @Test
    public void test8() {
        int[] nums = {3};
        int i = bruteForce(nums);
        System.out.println(i);
    }

    @Test
    public void test9() {
        int[] nums = {3, 0, 1};
        int k = 2;
        Assert.assertEquals(bruteForce(nums), k);
    }
    @Test
    public void test10() {
        int[] nums = {0,1,6,8,5,4,3,2};
        int k = 7;
        Assert.assertEquals(bruteForce(nums), k);
    }

    //Time complexity- O(n)
    //space complexity - O(1)
    private int bruteForce(int[] nums) {
        int length = nums.length; //0[1]
        // condition to check for empty array
        if (length == 0)
            throw new RuntimeException("empty array");
        // condition to check when length is 1 and element is 0 --> need to clarify, as what exactly needs to be referred
        if (length == 1 && nums[0] == 0)
            return -1;
        // condition when the length is 1 and element is 1 --> need to clarify, as what exactly needs to be referred
        if (length == 1 && nums[0] == 1)
            return 0;
        int min = Integer.MAX_VALUE; //0[1]
        int max = Integer.MIN_VALUE; //0[1]
        int actualSum = 0;
        int expectedSum = (length) * (length + 1) / 2;
        for (int i = 0; i < length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
            actualSum += nums[i];
        }
       int  missingEle = expectedSum - actualSum;

        // condition to validate the multiple duplicates
        if (length < max)
            throw new RuntimeException("invalid input array");
        if (missingEle > min && missingEle <max)
            return missingEle;
        if (expectedSum - actualSum == 0 && min == 0)
            return 0;
        if (expectedSum - actualSum == 0 && min != 0)
            return 0; //run in debug mode

        return 0;
    }

    /*

    Pseduo code:-
    1. iterate the array and find the min and max
    2. also calculate the sum of all the values present in an array
    3. then in another loop starting from min to max and count the sum
    4. return the difference
     */

    private int findMissingusingSum(int [] nums){
        if (nums.length==0) throw new RuntimeException(" empty array");
        int min=Integer.MAX_VALUE;
        int max=0, arrSum=0, expSum=0;
        for (int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            max= Math.max(max,nums[i]);
            arrSum+=nums[i];
        }

        for (int j=min;j<=max;j++){
            expSum+=j;
        }
        return expSum-arrSum;
    }


}
