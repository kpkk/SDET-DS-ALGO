package week4;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;

public class CountMissingBrackets {

    /*

    Find out how many missing brackets to make a valid parentheses !!
Input can have only open and closing brackets ( )
String st = “((((” -> 4 brackets
String st = “(()))” -> 1 bracket
     */
    @Test
    public void test1(){
        String str="((((";
        Assert.assertEquals(findMissingBrackets(str),4);
    }
    @Test
    public void test2(){
        String str="(()))";
        Assert.assertEquals(findMissingBrackets(str),1);
    }
    @Test
    public void test3(){
        String str="((()))";
        Assert.assertEquals(findMissingBrackets(str),0);
    }
    @Test
    public void test4(){
        String str="[";
        Assert.assertEquals(findMissingBrackets(str),1);
    }

    /*
    Approach: Using stack+ hashmap

    Solution:-
    - If the length of the string is 1 then we return as 1
    - Initialize a hashmap with character as key and value
    - Initialize a stack to push the characters
    - Traverse through the char array and check if the char is present in the map
      - if it doesn't present we push it
      - if it is there, we check the size of the stack to be not empty we pop and compare with the char value (popped value)
    - return the stack size



     */

    private int countMissedBrackets(String str) {
        HashMap<Character,Character>map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        map.put('>','<');
        Stack<Character> stack=new Stack<>();
        char[] chars = str.toCharArray();
        for (char ch:chars){
            if(!map.containsKey(ch)){
                stack.push(ch);
            }else if(!stack.isEmpty() && stack.pop()==map.get(ch)){
            }else if(stack.isEmpty() && map.containsKey(ch)){
                stack.push(ch);
            }
        }

        return stack.size();
    }

    private int findMissingBrackets(String str){
        int open=0, close=0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)=='(' ||str.charAt(i)=='['||str.charAt(i)=='{'||str.charAt(i)=='<'){
                open++;
            }else{
                close++;
            }
        }
        return Math.abs(open-close);
    }
}
