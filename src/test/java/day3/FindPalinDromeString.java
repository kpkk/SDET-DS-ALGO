package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class FindPalinDromeString {
    /*

   Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:
Input: s = "A man, a plan, a canal: Panama" \\W - alphabets, numerics
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.



1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?  String
        What is the expected output? boolean
        Do I’ve constraints to solve the problem? use two pointer
        Do Ive all the information to go to the next steps
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? --> brute force is known, trying two pointer
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this
5.  Do I know alternate solutions as well
        Yes- what are those?
        1. Brute force
             2. two pointer
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

6. If you know the alternate solution find out the O-notations (performance)

  brute force- O(n)  space- O(n)
  two pointer - O(n/2)-- space O(1)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code
9. Test against different test data
10. If it fails then debug to solve it
     */

    @Test
    public void test1() {
        String s = "A man, a plan, a canal: Panama";
        boolean result = true;
          Assert.assertEquals(checkpalinDromeusingTwoPointer(s), result);
       // Assert.assertEquals(palindromeStringusingBruteForce(s), result);

    }

    @Test
    public void test2() {
        String s = "race a car";
        boolean result = false;

          Assert.assertEquals(checkpalinDromeusingTwoPointer(s), result);
        //Assert.assertEquals(palindromeStringusingBruteForce(s), result);
    }

    @Test
    public void test3() {
        String s = "Malayalam";
        boolean result = true;

         Assert.assertEquals(checkpalinDromeusingTwoPointer(s), result);
      //  Assert.assertEquals(palindromeStringusingBruteForce(s), result);
    }

    @Test
    public void test4() {
        String s = "%$#&*(";
        boolean result = false;

          Assert.assertEquals(checkpalinDromeusingTwoPointer(s), result);
      //  Assert.assertEquals(palindromeStringusingBruteForce(s), result);
    }

    @Test
    public void test5() {
        String s = "a";
        boolean result = true;

          Assert.assertEquals(checkpalinDromeusingTwoPointer(s), result);
       // Assert.assertEquals(palindromeStringusingBruteForce(s), result);
    }
    @Test
    public void testcase6() {
        String s = " ";
        boolean result = false;

        Assert.assertEquals(checkpalinDromeusingTwoPointer(s), result);
        // Assert.assertEquals(palindromeStringusingBruteForce(s), result);
    }

   /*
   Pseudo code:-
   1. remove all the non-word characters from the strings using regex
   2. if the length of the string is zero throw an exception
   3. if the length is 1 and was a character or digit then return true
   4. convert the string into char array
   5. use two pointer opp direction, one at the start and other at the end
   6. if the characters/ digit at the specified indices is not same return false, else true

    */

    // Time complexity- O(n) --> may be more as it uses more because of replaceAll method
    // space complexity - O(n)
    public boolean palindromeStringusingBruteForce(String str) {
        String s = str.toLowerCase().replaceAll("\\W", "");
        if (s.trim().length() == 0) throw new RuntimeException("empty string");
        if (s.length() == 1 && Character.isLetterOrDigit(str.charAt(0))) return true;
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left++] != chars[right--]) return false;
        }
        return true;
    }

     /*
    1. convert the string into lower case, then into character array
    2.  Initialize two pointers in Oppostie directional left, right
    3. iterate the character arrays lng as   left<right and check if the character present at both the right and left is letter
    4. If yes, then compare the characters at the left and right indices, if same increment left and decrement right
    4. if no return false
    5. If any of left or right index character is not an alphabet then move the counter don't swap

     */

    // Time complexity- O(n/2)
    // space complexity- O(n) // holding char array

    public boolean checkpalinDromeusingTwoPointer(String str) {

        if (str.trim().length() == 0) throw new RuntimeException("empty string");
        if (str.length() == 1 && Character.isLetterOrDigit(str.charAt(0))) return true;
        int left = 0, right = str.length() - 1;
        while (left <right) {
            if (!Character.isLetterOrDigit(str.charAt(left))){
                left++;
            }
            if (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            if (Character.isLetterOrDigit(str.charAt(left)) && Character.isLetterOrDigit(str.charAt(right))) {
                if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))){
                    return false;
                }else{
                    left++;
                    right--;
                }
            }
        }
        return true;

    }
}
