package queuPratcise;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class DecodeString {

    @Test
    public void test1(){
        String s="3[a]2[bc]";
        Assert.assertEquals(decodeString1(s),"aaabcbc");
    }
    @Test
    public void test2(){
        String s="100[a]";
        Assert.assertEquals(decodeString1(s),"aaabcbc");
    }

    public String decodeString(String s) {
        /*
        - init a stack
        - push the elements into it, until the char is ]
        - then pop the chars until the char [ is met
        - get the char after [, check if its a numeric, if yes then convert that into int, multiply the string
        - push that back into stack, repeat the same process
        */

        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch!=']'){
                st.push(ch);
            }else{
                ArrayList<Character> list=new ArrayList<>();
                while(!st.isEmpty() && st.peek()!='['){
                    list.add(st.pop());
                }
                st.pop();
                int k=1;
                while (!st.isEmpty() && Character.isDigit(st.peek())){
                    k+= Character.getNumericValue(st.pop())*10+k;
                }
                while(k>0){
                    for(int i=list.size()-1;i>=0;i--){
                        st.push(list.get(i));
                    }
                    k--;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public String decodeString1(String s)
    {
        Stack<Integer> nums = new Stack<>();
        Stack<String> res = new Stack<>();

        res.push("");

        for (int i = 0; i < s.length(); i++)
        {
            char chr = s.charAt(i);

            if (Character.isDigit(chr))
            {
                int start = i;
                while (Character.isDigit(s.charAt(i + 1))) i++;
                nums.push(Integer.parseInt(s.substring(start, i + 1)));
            }
            else if (chr == '[')
            {
                res.push("");
            }
            else if (chr == ']')
            {
                String str = res.pop();
                StringBuilder sb = new StringBuilder();
                int times = nums.pop();

                while (times-- > 0) sb.append(str);
                res.push(res.pop() + sb.toString());
            }
            else
            {
                res.push(res.pop() + chr);
            }
        }

        return res.pop();
    }
}

