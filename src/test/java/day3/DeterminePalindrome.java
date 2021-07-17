package day3;

import org.junit.Assert;
import org.junit.Test;
import sun.text.normalizer.UCharacter;

import java.util.HashSet;

public class DeterminePalindrome {
    /*
    P2) Valid Palindrome after deleting one or zero character

Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 
Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? --> String
        What is the expected output? -- boolean
        Do I’ve constraints to solve the problem?
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
        String s="aba";
        boolean result=true;
        Assert.assertTrue(isPalindrome(s));
    }
    @Test
    public void test2(){
        String s="abca";
        boolean result=true;
        Assert.assertTrue(isPalindrome(s));
    }
    @Test
    public void test3(){
        String s="abcakcba";
        boolean result=true;
        Assert.assertFalse(isPalindrome(s));
    }
    @Test
    public void test4(){
        String s="malayalam";
        boolean result=true;
        Assert.assertTrue(isPalindrome(s));
    }

    /*

    Solution:-
    1. Initialize a hashset to hold all the characters
    2. Traverse through the string from start till end and add each character
    3. if the set size is either 0 or 1 we can consider that to be a palindrome return true
    4. else return false
     */

    private boolean isPalindrome(String s){
        HashSet<Character> set=new HashSet<>();
        for (char ch:s.toCharArray()){
           if(!set.add(ch))
               set.remove(ch);
        }
        if (set.size()<=2)
            return true;
        return false;
    }
}

