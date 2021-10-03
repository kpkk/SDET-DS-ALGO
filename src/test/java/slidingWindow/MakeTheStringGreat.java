package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.io.RandomAccessFile;
import java.util.Stack;

public class MakeTheStringGreat {

    /*
    Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.



Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "s"
Output: "s"


Constraints:

1 <= s.length <= 100
s contains only lower and upper case English letters.
     */
    @Test
    public void test1(){
        String s="leEeetcode";
        Assert.assertEquals(usingRecursion(s),"leetcode");
    }
    @Test
    public void test2(){
        String s="abBAcC";
        Assert.assertEquals(makeGood(s),"");
    }
    @Test
    public void test3(){
        String s="Pp";
        Assert.assertEquals(makeGood(s),"");
    }
    public String makeGood(String s) {
        if(s.length()==0 || s.length()==1)  return s;
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        char[] chars = s.toCharArray();
        for(char ch: chars){
            if(!stack.isEmpty() && Character.isUpperCase(ch) && stack.peek()==Character.toLowerCase(ch)) stack.pop();
            else if(!stack.isEmpty() && Character.isLowerCase(ch) && stack.peek()==Character.toUpperCase(ch))stack.pop();
            else stack.push(ch);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public String usingRecursion(String s){
      //  if(s.length()==0 || s.length()==1) return s;
        for (int i=0;i<s.length()-1;i++){
            if(Math.abs(s.charAt(i))-Math.abs(s.charAt(i+1))==32)
                return usingRecursion(s.substring(0,i)+ s.substring(i+2));
        }
        return s;
    }
}
