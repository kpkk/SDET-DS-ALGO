package day3;

import org.junit.Test;

import java.util.Arrays;

public class PlusOne {

    /*

    Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? Integer array
        What is the expected output? Integer array
        Do I’ve constraints to solve the problem?
        Do Ive all the information to go to the next steps
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it? yes using brute force
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
    public void test() {
        int[] nums = {1, 2, 3};
        int[] output = {1, 2, 4};
        int[] ints = plusOne(nums);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test2() {
        int[] nums = {9};
        int[] output = {1, 0};
        int[] ints = plusOne(nums);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test3() {
        int[] nums = {0};
        int[] output = {1};
        int[] ints = plusOne(nums);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test4() {
        int[] nums = {4, 3, 2, 1};
        int[] output = {4, 3, 2, 2};
        int[] ints = plusOne(nums);
        System.out.println(Arrays.toString(ints));
    }
    @Test
    public void test5() {
        int[] nums = {9,9,9,9};
        int[] output = {1,0,0,0,0};
        int[] ints = plusOne(nums);
        System.out.println(Arrays.toString(ints));
    }
    @Test
    public void test6() {
        int[] nums = {9,8,7,6,5,4,3,2,1,0};
        int[] output = {9,8,7,6,5,4,3,2,1,1};
        int[] ints = plusOne(nums);
        System.out.println(Arrays.toString(ints));
    }

    /*
    Solution:
    1. Initialize variables number=0, div =1, and placevalue=1
    2. form a number from Array elements
    3. calculate the placeValue then create an array of that length
    4. In a while loop get the last digit and put it in the array in reverse order
    5. return the array

     */

    // Time complexity- O(n)
    //space complexity- O(n)
    public int[] plusOne(int[] digits) {
        int number = 0, div = 1, PlaceValue = 1;
        for (int i = 0; i < digits.length; i++) {
            number = number * 10 + digits[i];
        }
        number += 1;

        while (number / div >= 10) {
            PlaceValue++;
            div *= 10;
        }
        int[] nums = new int[PlaceValue];
        int index = PlaceValue - 1;
        while (number != 0) {
            nums[index--] = number % 10;
            number /= 10;
        }
        return nums;
    }
}
