package practise;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class validateBrackets {

    @Test
    public void test1(){
        String s="(()))";
        boolean result=false;
        Assert.assertFalse(verifyBrackets(s));
    }

    /*
    - Initialize a stack of character type
    - Initialize a hashmap character as key and value
    - traverse the string and push to the stack only if it doesn;t match with any of the keys
    - If matches verify if stack is empty or the value is diff, if yes return false
    - else return stack.size

     */
    private boolean verifyBrackets(String s) {
        Stack<Character>stack=new Stack<>();
        HashMap<Character,Character>map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('>','<');
        map.put('}','{');


        for (char ch:s.toCharArray()){
            if(!map.containsKey(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty() && map.get(ch)!=stack.pop())
                    return false;
            }
        }
        return stack.isEmpty();
    }


}
