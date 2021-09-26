package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString {
    /*
    Write a function that reverses a string. The input string is given as an array of characters s.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.


Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
     */

    @Test
    public void test1(){
        char[] ch={'h','e','l','l','o'};
        Assert.assertArrayEquals(ch,new char[]{'o','l','l','e','h'});
    }

    /*
    Solution :-
    - Initialize two pointers left=0, right=ch.length-1
    - while left less than or equals to right
    - swap the characters between them
    - return the char array
     */

    public char[] reverseString(char [] ch){
        int left=0, right=ch.length-1;
        while (left<=right){
            char temp=ch[left];
            ch[left++]=ch[right];
            ch[right--]=temp;
        }
        return ch;
    }
}
