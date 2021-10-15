package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class LogestSubStringWoRepeatingChars {
    /*
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
     */

    @Test
    public void test1() {
        String s = "abcabcbb";
        Assert.assertEquals(longestSubStringusingMap(s), 3);
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        Assert.assertEquals(longestSubStringusingMap(s), 1);
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        Assert.assertEquals(longestSubStringusingMap(s), 3);
    }
    /*

    Solution

    - Initialize an integer array of size 128
    - Initialize variables left=0, right=0, uniqueCount=0, max=Integer.MIN;
    - Traverse through the string and update the index of the ascii array of that character
            - if the value of the index is greater than 1 then decrement value of left character index in ascii array
            - increment left
    - Find the maximum length between max, right-left+1
    - return max
     */


    private int findLongestSubString(String s) {
        if(s.trim().length()==0) return 0;
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        int[] ascii = new int[128];
        while (right < s.length()) {
            ascii[s.charAt(right)]++;
            while (ascii[s.charAt(right)] > 1){
                ascii[s.charAt(left++)]--;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    private int longestSubStringusingMap(String s){
        HashMap<Character, Integer>map=new HashMap<>();
        int left=0, right=0, maxlength=0;
        while (right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while (map.get(s.charAt(right))>1){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
            right++;
        }
        return maxlength;
    }
}
