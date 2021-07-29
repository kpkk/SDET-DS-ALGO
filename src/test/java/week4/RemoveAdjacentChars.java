package week4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.Stack;

public class RemoveAdjacentChars {

    /*
uestion : remove adjacent characters
from Aadhithya to Everyone:    10:54  AM
ex abbacd - cd
from Kamalakannan S to Everyone:    10:54  AM
Remove the adjacent duplicates in a string
abbaaba = aba
abccba  = empty string

abccba-empty
abbaaba-aba
aabbaacbbc-bcb
abbabba--a

     */

    @Test
    public void test1(){
        String str="abccba";
        Assert.assertEquals(removeChars(str),"");
    }
    @Test
    public void test2(){
        String str="abbaaba";
        Assert.assertEquals(removeChars(str),"aba");
    }
    @Test
    public void test3(){
        String str="aabbaacbbc";
        Assert.assertEquals(removeChars(str),"");
    }
    @Test
    public void test4(){
        String str="abbabba";
        Assert.assertEquals(removeChars(str),"a");
    }
    @Test
    public void test5(){
        String str="abc";
        Assert.assertEquals(removeChars(str),"abc");
    }
    /*
    Approach;- stack
    - Initialize a stack of character type and initialize and empty string
    - Convert the string into char array
    - check if the character is present in stack (peek)
        - pop it
     - if character is not present push to the stack
     - now add all the stack characters back into the string (peek)

     */

    private String removeChars(String str) {

        Stack<Character>stack=new Stack<>();
        StringBuffer outputString=new StringBuffer();
        char[] chars = str.toCharArray();
        for (char ch:chars){
            if(!stack.isEmpty()&& stack.peek()==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()){
            outputString.append(stack.pop());
        }

        return outputString.reverse().toString();
    }



}
