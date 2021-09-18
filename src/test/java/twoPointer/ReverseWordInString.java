package twoPointer;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class ReverseWordInString {
    /*
    Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
Example 4:

Input: s = "  Bob    Loves  Alice   "
Output: "Alice Loves Bob"
Example 5:

Input: s = "Alice does not even like bob"
Output: "bob like even not does Alice"


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
     */
    @Test
    public void test1(){
        String s="a good   example";
        Assert.assertEquals(reverseWords(s),"example good a");
    }
    @Test
    public void test2(){
        String s="tit  for tat";
        Assert.assertEquals(revereseWordsInplace(s),"tat for tit");
    }
    /*
           input- String
           output- String
           Solution- two pointer

           - Initialize two pointers left=0, right=s.length()-1
           - split the string based on " "(space) delimiter
           - while left less than right
           - swap the characters at left and right indices
           - Initialize a string buffer
           - iterate the split array and append all the strings
           - if the string is empty continue
           - return the string buffer as a string
           */
    private String reverseWords(String s) {
        String[] strs=s.trim().split(" ");
        int left=0, right=strs.length-1;
        while(left<right){
            String temp=strs[left];
            strs[left++]=strs[right];
            strs[right--]=temp;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<strs.length-1;i++){
            if(strs[i].isEmpty())continue;
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.append(strs[strs.length-1]);
        return sb.toString();
    }
    /*
    Solution:-
    - reverse the string
    - then reverse the words
    - then remove the extra spaces
     */
    private String revereseWordsInplace(String s){
        char[] chars = s.toCharArray();
        int left=0,right=chars.length-1;
        while (left<=right){
            char temp=chars[left];
            chars[left++]=chars[right];
            chars[right--]=temp;
        }
        left=0; right=0;
        while (left<s.length()){
            while (left<right|| left<s.length() && chars[left]==' ') {
                left++;
            }
            while (right<left|| right<s.length() && chars[right]!=' ') {
                right++;
            }
            int i=left, j=right-1;
            while (i<=j){
                char temp=chars[i];
                chars[i++]=chars[j];
                chars[j--]=temp;
            }
        }
        left=0;right=0;
        while (right<s.length()){
            while (right<s.length() && chars[right]==' '){
                right++;
            }
            while (right<s.length() && chars[right]!=' '){
               chars[left++]=chars[right++];
            }
            while (right<s.length() && chars[right]==' '){
                right++;
            }
            if (right<s.length()){
                chars[left++]=' ';
            }
        }

        return new String(chars).substring(0,left);
    }
}
