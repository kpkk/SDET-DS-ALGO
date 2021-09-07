package workshop;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    /*
    Given a string that has brackets, determine the valid parentheses
    input- {{())}}
     */

    /*
    input -string
    output- boolean
    constraint - solve using stack or string builder/ buffer
     */
    @Test
    public void test1(){
        String str="{{())}}";
        Assert.assertEquals(validparetheses(str),false);
    }
    @Test
    public void test2(){
        String str="{}()[]";
        Assert.assertEquals(validparetheses(str),true);
    }
    @Test
    public void test3(){
        String str=")(";
        Assert.assertEquals(validparetheses(str),false);
    }

    /*
    Solution- using stack
    - Initialize a hashmap with character as key and value
    - load all the open close bracket mappings
    - iterate the sting from start index until end
    - check if the map contains character
        - if yes, check if the value of the key matches the char, if yes pop the value
    - else push the character into the map
    - return stack is empty or not status
     */
    private boolean validparetheses(String str) {
        HashMap<Character,Character>map=new HashMap<Character,Character>(){
            {
                put('}','{');
                put(')','(');
                put(']','[');
            }
        };
        Stack<Character> stack=new Stack<>();
        char[] chars = str.toCharArray();
        for (char ch:chars){
            if(!stack.isEmpty() && map.containsKey(ch) && map.get(ch)==stack.peek()) stack.pop();
            else stack.push(ch);
        }
        return stack.isEmpty();
    }
    /*
    Solution- stringBuffer
    - iterate the string from start index until end
    - Initialize a hashmap character as key and value, push the mappings
    - Initialize the stringBuffer
    - iterate the string from start until end
    - if the character is open append that to string
    - if the character is close, then check if the prev character is open then remove that character and continue
      - else return false
    - return true

     */
}
