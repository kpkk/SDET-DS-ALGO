package practise;

import org.junit.Assert;
import org.junit.Test;

public class StrStr {
    /*

    Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
     */
    
    @Test
    public void test1(){
        String haystack="hello";
        String needle="ll";
        Assert.assertEquals(findIndex(haystack,needle),2);
    }
    @Test
    public void test2(){
        String haystack="aaaaa";
        String needle="bba";
        Assert.assertEquals(findIndex(haystack,needle),-1);
    }

    private int findIndex(String haystack, String needle) {

       for (int i=0;i<haystack.length()-needle.length();i++){
           if(haystack.substring(i,i+needle.length()).equals(needle)){
               return i;
           }
       }
       return -1;
    }
}

/*

 */