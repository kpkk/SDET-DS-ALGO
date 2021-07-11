package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class HappyNumber {
    /*

    Write an algorithm to determine if a number n is happy. A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19 1+81-->82
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Example 2:
Input: n = 2
Output: false'

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? Integer
        What is the expected output? boolean
        Do I’ve constraints to solve the problem? use two pointer
        Do Ive all the information to go to the next steps
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? using bruteforce
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
    public void testCase() {
        int n = 19;
        Assert.assertTrue(happyNumber(n));
    }

    @Test
    public void testCase1() {
        int n = 25;
        Assert.assertFalse(happyNumber(n));
    }

    @Test
    public void testCase3() {
        int n = 0;
        Assert.assertFalse(happyNumber(n));
    }

    @Test
    public void testCase4() {
        int n = -19;
        Assert.assertTrue(happyNumber(n));
    }

    /*
    Solution:
    1. initialize an integer variable sum
    2.for each digit in the inputNumber (using modulo)
        a.Compute the square and add it to the sum
    3. If sumOfsquares is 1
        a.return true
    4. Repeat 2,3 till adding sum to the set is true (using do-while)
    5. return false

     */

    public boolean happyNumber(int n) {
        if (n == 0) return false;
        int sum = n;
        HashSet<Integer> set = new HashSet<>();
        //  int sumOfSquares = 0;
        do {
            n = sum;
            sum = 0;
            while (n != 0) {
                int digit = n % 10;
                digit*= digit;
                sum += digit;
                n /= 10;

            }
            if (!set.add(sum)) return false;
        } while (sum != 1);

        return true;
    }


}
