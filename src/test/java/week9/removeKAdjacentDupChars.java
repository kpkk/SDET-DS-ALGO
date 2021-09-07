package week9;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class removeKAdjacentDupChars {
/*
    You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
    We repeatedly make k duplicate removals on s until we no longer can.
    Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
             
    Example 1:
    Input: s = "abcd", k = 2
    Output: "abcd"
    Explanation: There's nothing to delete.
    Example 2:
    Input: s = "deeedbbcccbdaa", k = 3
    Output: "aa"
    Explanation:
    First delete "eee" and "ccc", get "ddbbbdaa"
    Then delete "bbb", get "dada"
    Finally delete "ddd", get "aa"*/

    @Test
    public void test1() {
        String s = "abcd";
        int k = 2;
        Assert.assertEquals(recursion(s, k), "abcd");
    }

    @Test
    public void test2() {
        String s = "deeedbbcccbdaa";
        int k = 3;
        Assert.assertEquals(removeDups(s, k), "aa");
    }

    @Test
    public void test3() {
        String s = "deeedbbcccbdaa";
        int k = 3;
        Assert.assertEquals(removeDups(s, k), "aa");
    }

    /*
    Solution-
    - Initialize two stacks one of character type and another integer type
    - iterate the string from start until end
    - push the character to charStack and its occurrence to other stack, if it doesn't present
    - compare the stack.peek element with current character also compare the count value withk
        - if the value is matching with k and chars are same then pop for k times
    - push remaining chars to string buffer and return

     */

    private String removeDups(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int temp = k;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if(!countStack.isEmpty() && ch==charStack.peek())
                countStack.push(countStack.peek() + 1);
            else countStack.push(1);
            charStack.push(ch);

            if (!charStack.isEmpty() && ch == charStack.peek() && countStack.peek() == k) {
                while (temp > 0) {
                    countStack.pop();
                    charStack.pop();
                    temp--;
                }
                temp = k;
            }
        }
        while (!charStack.isEmpty())
            sb.insert(0,charStack.pop());

        return sb.toString();
    }

    private String recursion(String s, int k){
        int left=0, right=left+1;
        StringBuffer sb=new StringBuffer(s);
        int count=0;
        if(right==s.length()-1) return s;
        while (right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                count++;
                right++;
            }else{
                left++;
                right++;
            }
            if(count==k){
                recursion(sb.replace(left,right+1,"").toString(),k);
            }
        }
        return sb.toString();
    }
}
