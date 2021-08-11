package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class ValidateBrackets {

    /*
    Given a string of brackets validate proper brackets
    () ()() (()) (()()), ((()))
     */
    @Test
    public void test1(){
        String s="()";
        Assert.assertTrue(validateBrackets(s));
    }
    @Test
    public void test2(){
        String s="()(";
        Assert.assertFalse(validateBrackets(s));
    }
    @Test
    public void test3(){
        String s="((()))";
        Assert.assertTrue(validateBrackets(s));
    }
    @Test
    public void test4(){
        String s="[][[]";
        Assert.assertFalse(validateBrackets(s));
    }

    /*
    Input- String
    Output- boolean
    Approach: stack
    Solution:-
    - Initialize a stack of Character types
    - Initialize a hashmap with character as key and value
    - Put all the bracket combinations into hash map
    - Then iterate the string
        - check if the character at current index is present in map as key
        - if yes, check if the stack is empty & the stack.peek== map.get(ch) then pop
        - else, push the character
    - if the size of the stack is empty then return true else false


     */

    private boolean validateBrackets(String s) {
        HashMap<Character,Character>map=new HashMap<>();
        Stack<Character>stack=new Stack<>();
        map.put(')','(');
        map.put('>','<');
        map.put(']','[');
        map.put('}','{');
        char[] chars = s.toCharArray();
        for (char ch: chars){
            if(!map.containsKey(ch)){
                stack.push(ch);
            }else{
                if(!stack.isEmpty() && stack.peek()==map.get(ch))
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
