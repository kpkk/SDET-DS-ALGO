package day2;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeNumber {

    /*

    1) Given an integer x, return true if x is palindrome integer.

    1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? -->integer
        What is the expected output? --->boolean
        Do I’ve constraints to solve the problem? --> use swaping
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
        int n = 121;
        Assert.assertTrue(palinDromeUsingMod(n));
        //  Assert.assertTrue(checkPalindrome(n));
      //  Assert.assertTrue(checkPalindromusingUsingString(n));

    }

    @Test
    public void test2() {
        int n = 1765;
        // Assert.assertFalse(checkPalindrome(n));
        Assert.assertFalse(palinDromeUsingMod(n));
        Assert.assertFalse(checkPalindromusingUsingString(n));
    }

    //997799
    @Test
    public void test3() {
        int n = 00100;
        //  Assert.assertTrue(checkPalindrome(n));
        Assert.assertTrue(palinDromeUsingMod(n));
      //  Assert.assertTrue(checkPalindromusingUsingString(n));
    }

    //010
    // biggest palindrome that exists in integer range
    @Test
    public void test4() {
        int n = -1765;
        // Assert.assertFalse(checkPalindrome(n));
        Assert.assertFalse(palinDromeUsingMod(n));
     //   Assert.assertFalse(checkPalindromusingUsingString(n));
    }

    @Test
    public void test5() {
        int n = 997799;
        // Assert.assertTrue(checkPalindrome(n));
        Assert.assertTrue(palinDromeUsingMod(n));
     //   Assert.assertTrue(checkPalindromusingUsingString(n));
    }

    @Test
    public void test6() {
        int n = 4;
        // Assert.assertTrue(checkPalindrome(n));
        Assert.assertTrue(palinDromeUsingMod(n));
       // Assert.assertTrue(checkPalindromusingUsingString(n));
    }


    /*

    Pseudo code:-
    1. Create a temp variables then store the value of n for final comparision
    2. Initialize another variable called rev=0, to hold the reversed digit
    3. If the value of the integer is single digit, the return true
    4. If the value is less than 0 return false
    5. Then while n>0 get the last digit, using mod and multiply with the value which is initialized with zero
    6. compare the value of temp and rev, if they are equal return true else false
     */


    // Time complexity -O(n)
    // space complexity- O(1) drop constants
    public boolean checkPalindrome(int n) {
        int temp = n;
        if (n < 0) return false;
        if (n >= 0 && n < 10) return true;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        if (temp == rev) return true;
        return false;
    }

    /*
    Pseudo code:-
    1. check if the given integer is less than 0, if yes return false
    2. check if the integer is single digit value, if yes return true
    3. initialize a variable div=1, and keep multiplying it with 10 to know the value of the digit in places
    4. while x!=0 get the last digit and first digit and compare if they are not equal then return false, else true
     */

    // Time complexity- O(n)
    //Space complexity- O(1)
    public boolean palinDromeUsingMod(int n) {
        if (n < 0) return false;
        if (n >= 0 && n < 10) return true; //1221
        int div = 1;
        // get the value of the number in terms of places
        while (n / div >= 10) { //121/100==1
            div *= 10; //10*10-100
        }
        while (n > 0) { //2
            int left = n / div;  //121/100->1
            int right = n % 10; //12%10-->1  2%10
            if (left != right) return false;
            n = (n % div) / 10; // 121%100-->21/10-->2
            div = div / 100; //1
        }
        return true;
    }

    // Time complexity- O(n/2)
    //Space complexity- O(n)
    public boolean checkPalindromusingUsingString(int n) {
        if (n < 0) return false;
        if (n >= 0 && n < 10) return true;
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int left=0, right=chars.length-1;
        while (left<=right){
            if (chars[left++]!=chars[right--])
                return false;
        }
        return true;

    }
}
