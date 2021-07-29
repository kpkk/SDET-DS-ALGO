package practise;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class DecodeString {
     /*
    Given a string decode a2[bc] that as "abcbc"

     */

    @Test
    public void test1(){
        String str="a2[bc]";
        String output="abcbc";
        Assert.assertEquals(decodeString(str),output);
    }
    @Test
    public void test2(){
        String str="2[ab3[b]]";   //abbbbabbbb
        String output="abbbbabbbb";
        Assert.assertEquals(decodeString(str),output);
    }
    @Test
    public void test3(){
        String str="ac";
        String output="ac";
        Assert.assertEquals(decodeString(str),output);
    }
    @Test
    public void test4(){
        String str="4[a3[b2[c]]]";
        String output="abccbccbccabccbccbccabccbccbccabccbccbcc";
        Assert.assertEquals(decodeString(str),output);
    }

    /*
    Approch: Stack + arrayList
    - Initialize a stack of character type
    - Initialize an arraylist of character type
    - Traverse through the string and store each character into stack unless it is ']'
        - if the character is ] then start popping then add them to the list
        -  when the character is [ then do nothing
        - if the next character right after [ is numeric then push as many times as that number into the stack
     - append the stack into a string builder then return the same

     */
    private String decodeString(String str) {

        if(str.length()==0) throw new RuntimeException("empty string");
        Stack<Character>stack=new Stack<>();
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)!=']'){
                stack.push(str.charAt(i));
            }else{
                ArrayList<Character>list=new ArrayList<>();
                while (stack.peek()!='['){

                    list.add(stack.pop());
                }
                stack.pop();
                int k=1;
                if(!stack.isEmpty() && Character.isDigit(stack.peek())){
                   k= Character.getNumericValue(stack.pop());
                   while (k>0){
                       for (int j=list.size()-1;j>=0;j--){
                           stack.push(list.get(j));
                       }
                       k--;
                   }
                }
            }
        }
        StringBuffer sb=new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
       return sb.reverse().toString();

    }

}
