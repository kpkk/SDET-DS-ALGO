package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class P7_ValidParenthesis {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
     */
    /*
    Input- String
    output- boolean
     */
    @Test
    public void test1(){
        String s="()";
        Assert.assertTrue(determineValidparentheses(s));
    }
    @Test
    public void test2(){
        String s="()[]{}";
        Assert.assertTrue(determineValidparentheses(s));
    }
    @Test
    public void test3(){
        String s="(]";
        Assert.assertFalse(determineValidparentheses(s));
    }
    @Test
    public void test4(){
        String s="([)]";
        Assert.assertFalse(determineValidparentheses(s));
    }
    @Test
    public void test5(){
        String s="{[]}";
        Assert.assertTrue(determineValidparentheses(s));
    }

    /*
    - Initialize a stack of character type
    - Initialize a hashmap of character,character type to map the values
    - iterate the string from start index until end
    - if the stack is not empty and character is )/]/} and stack.peek() is open then pop
    - else push to the stack
    - return the if stack.isempty or not
     */
    private boolean determineValidparentheses(String s) {
        Stack<Character>st=new Stack<>();
        HashMap<Character,Character>map=new HashMap<Character,Character>(){
            {
                put(')','(');
                put(']','[');
                put('}','{');
                put('>','<');
            }
        };
        char[] chars = s.toCharArray();
        for (char ch:chars){
            if(!st.isEmpty()&& map.containsKey(ch)&& map.get(ch)== st.peek()) st.pop();
            else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
