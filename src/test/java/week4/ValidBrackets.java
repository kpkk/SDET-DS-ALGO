package week4;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class ValidBrackets {
    /*

Given a string of brackets validate proper brackets
     */

    @Test
    public void test1(){
        String str="()))";
        Assert.assertFalse(validateBrackets(str));
    }
    @Test
    public void test2(){
        String str="((()))";
        Assert.assertTrue(validateBrackets(str));
    }
    @Test
    public void test3(){
        String str="(((";
        Assert.assertFalse(validateBrackets(str));
    }
    @Test
    public void test4(){
        String str=")))";
        Assert.assertFalse(validateBrackets(str));
    }

    /*
    Approach : Stack and HashMap
    Solution:-
    - Initialize a stack of Character type
    - Initialize a hashmap with character as key and value
    - Traverse through the character array and
        - push the characters into the stack if it doesn't contain in map
        - if the character contains in the key then pop it
     - if the stack is empty return true
     - else return false

     */
    private boolean validateBrackets(String str) {
        HashMap<Character,Character>map=new HashMap<>();
        Stack<Character> stack=new Stack<>();
        map.put(')','(');
        map.put(']','[');
        map.put('>','<');
        map.put('}','{');
        char[] chars = str.toCharArray();
        for (char ch:chars){
            if(!map.containsKey(ch))
                stack.push(ch);
            else{
                if(stack.isEmpty() || stack.pop()!=map.get(ch))
                    return false;
            }

        }
        return stack.isEmpty();
    }


}
