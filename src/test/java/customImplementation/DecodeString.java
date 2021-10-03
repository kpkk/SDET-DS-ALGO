package customImplementation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DecodeString {

    @Test
    public void test1(){
        String s="2[a]3[bc]";
        Assert.assertEquals(decodeString(s),"aabcbcbc");
    }

    private String decodeString(String s) {
        Stack<Integer> countStack=new Stack();
        Stack<String>stack=new Stack<>();
        int index=0;
        String result="";
        while (index<s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count=0;
                while (Character.isDigit(s.charAt(index))){
                    count=count*10+Character.getNumericValue(s.charAt(index));
                    index++;
                }
                countStack.push(count);
            }
            else if(s.charAt(index)=='['){
                stack.push(result);
                result="";
                index++;
            }
            else if(s.charAt(index)==']'){
                StringBuilder sb=new StringBuilder(stack.pop());
                int value= countStack.pop();
                for (int i=0;i<value;i++){
                    sb.append(result);
                }
                result=sb.toString();
                index++;
            }
            else{
                result+=s.charAt(index++);
            }
        }

        return result;
    }
}
