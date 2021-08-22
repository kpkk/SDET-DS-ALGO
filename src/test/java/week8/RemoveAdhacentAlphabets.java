package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class RemoveAdhacentAlphabets {

    /*
    You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together. We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 
Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

     */

    @Test
    public void test1(){
        String s="abcd";
        int k=2;
        Assert.assertEquals(removeAlphabets(s,k),"abcd");
    }
    @Test
    public void test2(){
        String s="deeedbbcccbdaa";
        int k=3;
        Assert.assertEquals(removeAlphabets(s,k),"aa");
    }
    @Test
    public void test3(){
        String s="pbbcggttciiippooaais";
        int k=2;
        Assert.assertEquals(removeAlphabets(s,k),"ps");
    }

    /*
    Approach- using stack
    - Initialize two stacks one of character type and other as integer type
    - convert the string into character array
    - if stack is not empty and the stack.peek== current char then push the incremented value in other stack
    - else push the character into char stack and 1 into the other count stack
    - when the count.peek()==3 pop those many times from both the stacks
     */
    private String removeAlphabets(String s, int k) {
        int windowSize=k;
        Stack<Character>st=new Stack<>();
        Stack<Integer> count=new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch:chars){
            if(st.isEmpty() || !st.isEmpty() && ch!=st.peek()){
                st.push(ch);
                count.push(1);
            }
            else if(!st.isEmpty() && !count.isEmpty() && ch==st.peek()){
                st.push(ch);
                count.push(count.peek()+1);
                if(count.peek()==k){
                    while (k>0){
                        count.pop();
                        st.pop();
                        k--;
                    }
                    k=windowSize;
                }
            }

        }
        StringBuffer sb=new StringBuffer();
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
