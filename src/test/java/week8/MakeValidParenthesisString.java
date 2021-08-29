package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class MakeValidParenthesisString {
    /*
    1) Find the minimum number of moves required to make a String with valid paranthesis
     */
    @Test
    public void test1(){
        String s="())";
        Assert.assertEquals(validParenthesisUsingStack(s),1);
    }
    @Test
    public void test2(){
        String s="))))";
        Assert.assertEquals(validParenthesisUsingStack(s),4);
    }
    @Test
    public void test3(){
        String s=")(";
        Assert.assertEquals(validParenthesisUsingStack(s),0);
    }
    @Test
    public void test4(){
        String s="(((";
        Assert.assertEquals(validParenthesisUsingStack(s),3);
    }

    /*
    - initialize two variables to count the open and close braces
    - iterate the string from start index until end
    - return the absolute difference of open and close counters
     */
    private int makeValidParenthesis(String s) {

        if(s.length()==0) return 0;
        if(s.length()==1)return 1;
        int open=0, close=0;
        for (char c:s.toCharArray()){
            if(c=='(') open++;
            else{
                close++;
            }
        }
        return Math.abs(open-close);
    }

    private int validParenthesisUsingStack(String s){
        HashMap<Character,Character>map=new HashMap<Character,Character>(){
            {
                put(')','(');
                put(']','[');
                put('}','{');
                put('>','<');
            }
        };
        Stack<Character>st=new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch:chars) {
            if (!st.isEmpty() && map.containsKey(ch) && st.peek() == map.get(ch))
                st.pop();
            else st.push(ch);
        }
        return st.size();
        }
}
