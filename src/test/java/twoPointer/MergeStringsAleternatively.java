package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class MergeStringsAleternatively {
    /*
    You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.



Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d


Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
     */
    @Test
    public void test1(){
        String word1="abc";
        String word2="pqr";
        Assert.assertEquals(mergeStrings(word1,word2),"apbqcr");
    }
    @Test
    public void test2(){
        String word1="ab";
        String word2="pqrs";
        Assert.assertEquals(mergeStrings(word1,word2),"apbqrs");
    }
    @Test
    public void test3(){
        String word1="abcd";
        String word2="pq";
        Assert.assertEquals(mergeStrings(word1,word2),"apbqcd");
    }

    /*
       - input- two String
       - output- string
       Solution:- two pointer
       - initialize two pointers, p1=0, p2=0
       - iterate both the strings until they reach thier length
       - if any of the string is left over then append those chars
       - return the string
       */
    private String mergeStrings(String word1, String word2) {
        int left=0, right=0;
        StringBuffer sb=new StringBuffer();
        while (left<word1.length()||right<word2.length()){
            if(left<word1.length()) sb.append(word1.charAt(left++));
            if(right<word2.length()) sb.append(word2.charAt(right++));
        }
        return sb.toString();
    }
}
