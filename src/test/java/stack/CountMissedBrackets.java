package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class CountMissedBrackets {

    /*
       Find out how many missing brackets to make a valid parentheses !!
Input can have only open and closing brackets ( ) / all brackets can also be considered
String st = “((((” -> 4 brackets
String st = “(()))” -> 1 bracket
     */
    @Test
    public void test1() {
        String s = "((((";
        Assert.assertEquals(bracketCount(s), 4);
    }

    @Test
    public void test2() {
        String s = "()()";
        Assert.assertEquals(bracketCount(s), 0);
    }

    @Test
    public void test3() {
        String s = ")))";
        Assert.assertEquals(bracketCount(s), 3);
    }

    /*
    Input- String
    Output- int
    Solution:-
    - Initialize a hashmap with character as key and value
    - Load all the keys into the map
    - Initialize a stack of character type
    - Iterate the string from left to right
    - if the character does not present as a key in map
        - then push to the stack
     -else if, stack is not empty, stack.pop==map.get(ch) then pop
     - else if, stack is empty, map contains key then push into the stack
     - return stack.size


     */

    //Time complexity - O(n)
    //space complexity - O(n)
    private int findBracketCount(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        map.put('>','<');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek() == map.get(ch)) {
                stack.pop();
            } else
                stack.push(ch);
        }
        return stack.size();
    }

    /*
    Linear approach
    - Initialize two variables called open=0, close=0
    - Iterate the character array from start index until end
    - If the character at a specified index is any of the opening bracket, then increment the open count
    - Else increment the close
    - return the absolute of open and close
     */
    private int bracketCount(String s){
        int open=0, close=0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if(chars[i]=='(') open++;
            else close++;
        }
        return Math.abs(open-close);

    }
}
