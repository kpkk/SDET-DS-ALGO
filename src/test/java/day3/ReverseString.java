package day3;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString {

    /*
    Given a string s, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

Example 1:
Input: s = "ab-cd"
Output: "dc-ba"
Example 2:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? String
        What is the expected output? String
        Do I’ve constraints to solve the problem? use two pointer
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
        String s = "ab-cd";
        String output = "dc-ba";
        Assert.assertEquals(output,reverseString(s));
    }

    @Test
    public void test2() {
        String s = " a-bC-dEf-ghIj";
        String output = "j-Ih-gfE-dCba";
        Assert.assertEquals(output,reverseString(s));
    }
    @Test
    public void test3() {
        String s = "Test1ng-Leet=code-Q!";
        String output = "Qedo1ct-eeLg=ntse-T!";
        Assert.assertEquals(output,reverseString(s));
    }

    /*
    Solution:
    1. Initialize two pointers left=0, right=length-1
    2. check if the characters at the left and right indices are alphabets
         a. swap them and increment left and decrement right
         b. if the character on left is not an alphabet then increment left
         c. if the character on right is not an alphabet then decrement right
     */

    //Time complexity- O(n)
    // space complexity- O(n)

    private String reverseString(String str) {
        if (str.trim().length() == 0) throw new RuntimeException("empty string");
        if (str.length() == 1) return str;
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!Character.isAlphabetic(chars[left]))
                left++;
            if (!Character.isAlphabetic(chars[right]))
                right--;
            if (Character.isAlphabetic(chars[left]) && Character.isAlphabetic(chars[right])) {
                char c = chars[left];
                chars[left++] = chars[right];
                chars[right--] = c;
            }
        }
        String s = "";
        for (char ch : chars) {
            s += ch;
        }
        return s;
    }

}
