package week11;

import org.junit.Assert;
import org.junit.Test;

public class RepeatedStringSelection {

    /*
    Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.



Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.


Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

     */
    @Test
    public void test1(){
        String s="abab";
        Assert.assertEquals(repeatString(s),true);
    }
    @Test
    public void test2(){
        String s="aba";
        Assert.assertEquals(repeatString(s),false);
    }
    @Test
    public void test3(){
        String s="abcabcabcabc";
        Assert.assertEquals(repeatString(s),true);
    }
    @Test
    public void test4(){
        String s="abac";
        Assert.assertEquals(repeatString(s),false);
    }
    @Test
    public void test5(){
        String s="abaababaab";
        Assert.assertEquals(repeatedSubstringPattern(s),true);
    }
    @Test
    public void test6(){
        String s="aaaa";
        Assert.assertEquals(repeatString(s),true);
    }

    public boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    private boolean repeatString(String s) {
        int j=0;String subString="";
        for(int i=(s.length())/2;i>=0;i--){
            if(s.lastIndexOf(s.charAt(i))==s.length()-1){
                subString= s.substring(j,i);
                break;
            }
        }
        if(subString.isEmpty()) return false;
        String temp="";
        while(temp.length()!=s.length()){
            temp+=subString;
        }
        System.out.println(temp);
        if(temp.equals(s)) return true;
        else return false;
    }
}
