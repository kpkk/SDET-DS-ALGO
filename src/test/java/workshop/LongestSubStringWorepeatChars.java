package workshop;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class LongestSubStringWorepeatChars {
    /*
    q1) Longest Substring without repeating character


Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
     */
    @Test
    public void test1(){
        String s="abcabcdbb";
        Assert.assertEquals(findLongestSubString(s),4);
    }
    @Test
    public void test2(){
        String s="bbbbb";
        Assert.assertEquals(findLongestSubString(s),1);
    }
    @Test
    public void test3(){
        String s="pwwkew";
        Assert.assertEquals(findLongestSubString(s),3);
    }

    /*
    Input - string
    output- integer

     */
    private int findLongestSubString(String s) {
       int [] ascii=new int[26];
       int length=0;
       int left=0, right=0;
       while (right<s.length()) {
           ascii[s.charAt(right) - 97]++;
           while (ascii[s.charAt(right) - 97] > 1) {
               ascii[s.charAt(left++) - 97]--;
           }
           length = Math.max(length, right - left+1) ;
           right++;
       }
       return length;

    }
}
