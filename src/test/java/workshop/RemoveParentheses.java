package workshop;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class RemoveParentheses {
    /*
    Problem 1:

Remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 
Example 1:

Input: s = “abc(a(c)e)de)"
Output: “abc(a(c)e)de"
Explanation: “abc(a(ce)de)" , “abc(a(c)ede)" would also be accepted.

Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"

     */
    @Test
    public void test1(){
        String s="abc(a(c)e)de)";
        Assert.assertEquals(removeparentheses(s),"abc(a(c)e)de");
    }
    @Test
    public void test2(){
        String s="a)b(c)d";
        Assert.assertEquals(removeparentheses(s),"ab(c)d");
    }
    @Test
    public void test3(){
        String s="))((";
        Assert.assertEquals(removeparentheses(s),"");
    }
    /*
    Solution:-
    - Initialize two stacks one of character type another integer type
    - iterate the character array from start until end
    - if the current character is alphabet add to the character stack
    - if the current character is open, then push the character to its index and its index to integer type
    - if the current character is closed then
        - check if the other stack has the open bracket then
            - if yes pop the character and add to the stack
            - else skip the character
     */

    private String removeparentheses(String s) {
       Stack<Character>stack=new Stack<>();
       Stack<Integer>index=new Stack<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++) {
           if(chars[i]=='('){
               stack.push(chars[i]);
               index.push(i);
           }
           else if(chars[i]==')' ){
               if(!stack.isEmpty() && !index.isEmpty() && stack.peek()=='('){
                   stack.pop();
                   index.pop();
               }else{
                   index.push(i);
               }

           }
       }
        StringBuilder sb=new StringBuilder(s);
       while (!index.isEmpty()){
           sb.deleteCharAt(index.pop());
       }
       return sb.toString();
       }

}

/*

 Stack<Character>stringStack=new Stack<>();
        Stack<Integer>braceStack=new Stack<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if(Character.isLetterOrDigit(chars[i])){
                stringStack.push(chars[i]);
            }
           else if(chars[i]=='('){
                stringStack.push(chars[i]);
                braceStack.push(i);
            }
           else if(chars[i]==')' && !braceStack.isEmpty()){
                braceStack.pop();
                stringStack.push(chars[i]);
            }else{
               continue;
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stringStack.isEmpty()){
            sb.append(stringStack.pop());
        }
        System.out.println(sb);
        System.out.println(braceStack);
        while (!braceStack.isEmpty()){
            sb.deleteCharAt(braceStack.pop());
        }
        return sb.reverse().toString();
 */