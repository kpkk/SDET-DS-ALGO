package week4;

import netscape.security.UserTarget;
import org.junit.Assert;
import org.junit.Test;
import sun.tools.jstack.JStack;

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
        Assert.assertEquals(decode(str),output);
    }
    @Test
    public void test2(){
        String str="2[ab3[b]]";   //abbbbabbbb
        String output="abbbbabbbb";
        Assert.assertEquals(decode(str),output);
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
    Approach:- Stack and ArrayList

    Solution:-
    - Initialize a stack of character type
    - Initialize an arrayList of character type
    - Traverse through the string
            - push all the character into the stack until the close bracket is found
            - Once the closed bracket is found--> start popping until the open bracket if found--> add to arrayList
            - when the character '[' is popped just continue
            - then get the integer value of the character and multiply the arrayList
     - return the stack


     */

    private String decodeString(String str) {
        Stack<Character>stack=new Stack<>();
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++){
            if(chars[i]!=']'){
                stack.push(chars[i]);
            }else{
                ArrayList<Character>list=new ArrayList();
                while (stack.peek()!='['){
                    list.add(stack.pop());
                }
                stack.pop();
                int k=1;
                if(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = Character.getNumericValue(stack.pop());
                }
                while (k>0){
                    for (int j=list.size()-1;j>=0;j--){
                        stack.push(list.get(j));
                    }
                    k--;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());

        }
        return sb.reverse().toString();

    }

    private String decode(String s){
        //2[ab3[b]]
        Stack<String> stringStack=new Stack<>();
        Stack<Integer> countStack=new Stack<>();
        String result="";
        int right=0;
        while (right<s.length()){
            if(Character.isDigit(s.charAt(right))){
                int sum=0;
                while (Character.isDigit(s.charAt(right))){
                    sum=sum*10+Character.getNumericValue(s.charAt(right));
                    right++;
                }
                countStack.push(sum);
            }
            else if(s.charAt(right)=='['){
                stringStack.push(result);
                result="";
                right++;
            }
            else if(s.charAt(right)==']'){
                StringBuilder sb=new StringBuilder(stringStack.pop());
                Integer pop = countStack.pop();
                for (int i=0;i<pop;i++){
                    sb.append(result);
                }
                result=sb.toString();
                right++;
            }
            else{
                result+=s.charAt(right++)+"";
            }
        }
        return result;
    }
}
