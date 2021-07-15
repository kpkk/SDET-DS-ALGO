package day3;

import org.junit.Test;

public class MaxAvg {

    /*

    You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.



Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000


Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? integer array, target
        What is the expected output? --> double
        Do I’ve constraints to solve the problem? use sliding window
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
    public void test1(){
        int[] nums={1,12,-5,-6,50,3};
        int target=4;
        double maxAvg = findMaxAvg(nums, target);
        System.out.println(maxAvg);
    }
    @Test
    public void test2(){
        int[] nums={5};
        int target=1;
        double maxAvg = findMaxAvg(nums, target);
        System.out.println(maxAvg);
    }

    /*

    solution:-
    1. initialize a variable max=0
    2. Traverse through the array until k and find the sum and store in max
    3. Traverse through the array from target+1 until the nums.length-1
    4. remove the last value from the max and add the current index value
         a. check if the the current sum is max than previous sum (Math.max)

     5. Then divide the sum by k and return the value

     */

    //Time complexity- O(n)
    //Space complexity- O(1)
    private double findMaxAvg(int nums[], int target){
        if (nums.length==0) throw new RuntimeException("empty array");
        if (nums.length==1) return nums[0];
        double max=0;
        for (int i=0;i<target;i++){
            max+=nums[i];
        }
        for (int i=target;i<nums.length;i++){
            double currentMax=max-nums[i-target]+nums[i];
            max=Math.max(max,currentMax);
        }
        return max/target;
    }
}
