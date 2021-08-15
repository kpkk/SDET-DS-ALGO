package week7;

import org.junit.Assert;
import org.junit.Test;

public class RemoveParentheses {

    /*

    Remove minimum number of parenthesis to make it a valid string
    Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
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


Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
     */

/*
Input- String
output- String
Constraints - solve using the string /stack
Test data

 */
    @Test
    public void test1(){
        String s="lee(t(c)o)de)";
        String output="lee(t(c)o)de";
        Assert.assertEquals(removeParentheses(s),output);
    }
    @Test
    public void test2(){
        String s="a)b(c)d";
        String output="ab(c)d";
        Assert.assertEquals(removeParentheses(s),output);
    }
    @Test
    public void test3(){
        String s="))((";
        String output="";
        Assert.assertEquals(removeParentheses(s),output);
    }
    @Test
    public void test4(){
        String s="(a(b(c)d)";
        String output="a(b(c)d)";
        Assert.assertEquals(removeParentheses(s),output);
    }

    /*
    Solution:-
    -Initialize variable called, open=0, close=0
    - Initialize a string to hold the output
    - Traverse the character array and count the number closed brackets
    - traverse the array from left to right
        - if the character is (, then increment open
        - if the closed>0, close--
        - append the character to the string
        - if not continue
        - else if the character is ) then check if open is>0, then open--, close-- ,
        - append the character to the string
        - else, append the character to the string


     */
    private String removeParentheses(String s) {
        if(s.trim().length()==0) return s;
        int open=0, close=0;
        String output="";
        char[] chars = s.toCharArray();
        for (char ch:chars){
            if(ch==')') close++;
        }
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
                if(close>0){
                    close--;
                    output+=s.charAt(i);
                }
            }else if(s.charAt(i)==')'){
                if(open>0) {
                    open--;
                    output+=s.charAt(i);
                }else{
                    close--;
                }

            }else{
                output+=s.charAt(i);
            }
        }
        return output;
    }

}
