package week11;

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
        Assert.assertEquals(reverseWords1(s),"example good a");
    }
    @Test
    public void test2(){
        String s="tit  for tat";
        Assert.assertEquals(reverseWords1(s),"example good a");
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

    public String reverseWords1(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' '){
                i++; // skip spaces
            }
            while (j < i || j < n && a[j] != ' ') {
                j++; // skip non spaces
            }
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}
