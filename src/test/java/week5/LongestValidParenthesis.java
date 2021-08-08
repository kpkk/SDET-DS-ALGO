package week5;

import org.junit.Assert;
import org.junit.Test;

import java.io.CharArrayReader;
import java.util.HashMap;
import java.util.Stack;

public class LongestValidParenthesis {
    /*

    32. Longest Valid Parentheses
Hard

5746

198

Add to List

Share
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.



Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
     */

    @Test
    public void test1(){
        String str=")()())";
        Assert.assertEquals(subStringLength(str),4);
    }
    @Test
    public void test2(){
        String str="))()(((()()())";
        Assert.assertEquals(subStringLength(str),8);
    }
    @Test
    public void test3(){
        String str="))))";
        Assert.assertEquals(subStringLength(str),0);
    }
    @Test
    public void test4(){
        String str="((((((()";
        Assert.assertEquals(subStringLength(str),2);
    }

    /*
    Approach:- hashmap +stack+sliding window
    Solution:-
    - Initialize a hashmap and store the valid character combinations
    - Initialize a stack of character type
    - Initialize variables left=0, right=0, maxLength=Integer.MIN_VALUE
    - iterate the character array from starting index until end
    - push the character into the stack when the map doesn't contains character, move right pointer
    - pop the character if the map contains key and value of it matches, move the right pointer
    - move the left pointer when the map contains key but the value doesn't match or stack is empty
    - find the max length of right-left+1
    - return the maxLength

     */

    private int findSubStringLength(String str) {
        HashMap<Character, Character>map=new HashMap<>();
        map.put(')','(');
        Stack<Character>stack=new Stack<>();
        char[] chars = str.toCharArray();
        int left=0, right=0, maxLength=Integer.MIN_VALUE;
        while (left<chars.length && right<chars.length){
            if(!map.containsKey(chars[right])){
                stack.push(chars[right++]);
            }else if(map.containsKey(chars[right])&& !stack.isEmpty()){
                stack.pop();
                maxLength=Math.max(maxLength,right-left+1);
                right++;
            }else{
                left++;
                right++;
            }
        }
        return maxLength;
    }

    /*
    Approach:- Stack
    - Initialize a stack of intege type and push the element -1
    - Initialize an int variable maxLength=Integer.MIN_VALUE
    - traverse the string from starting index until the end
    - if the character at the index is '(' then push the index into the stack
    - if the character at index is not '(' then pop from stack
        - check if the stack is empty
        - if empty then push the current index into stack
        - else calculate the max of maxLength and i-stack.peek
    - return maxLength
     */

    private int subStringLength(String str){
        Stack<Integer>stack=new Stack<>();
        int maxLength=Integer.MIN_VALUE;
        stack.push(-1);
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else maxLength=Math.max(maxLength,i-stack.peek());
            }
        }
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}
