package dunZo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DecodeString {

    @Test
    public void test1(){
        String s="2[a]3[bc]";
        Assert.assertEquals(decodeString(s),"aabcbcbc");
    }

    public String decodeString(String s) {
       Stack<Integer>countStack=new Stack<>();
       Stack<String>stringStack=new Stack<>();
       int index=0;
       String result="";
       while (index<s.length()){
           if(Character.isDigit(s.charAt(index))){
               int count=0;
               while (Character.isDigit(s.charAt(index))){
                   count=10 * count+Character.getNumericValue(s.charAt(index));
                   index++;
               }
               countStack.push(count);
           }
           else if(s.charAt(index)=='['){
               stringStack.push(result);
               result="";
               index++;
           }
           else if(s.charAt(index)==']'){
               StringBuilder sb=new StringBuilder(stringStack.pop());
               int temp=countStack.pop();
               for (int i=0;i<temp;i++){
                   sb.append(result);
               }
               result=sb.toString();
               index++;
           }else{
               result+=s.charAt(index++);
           }
       }
       return result;
    }
}
/*
 String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
 */