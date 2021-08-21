package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

public class HackerRankInString {

    @Test
    public void test1() {
        String s = "hereiamstackerrank";
        Assert.assertEquals(hackerrankInString(s),"YES");
    }
    public String hackerrankInString(String s) {
        // Write your code here

    /*
    - Initialize a string called p-hackerrank
    - initialize two pointers p1=0, p2=0
    - iterate through the input string and p string
    - check if the character at index of both the strings are equal
            - IF yes, keep moving the pointers p1, p2 by 1
            - else move only p2
    - if p1 reaches the length return yes, else No
    */
        String p="hackerrank";
        int s1=0, p1=0;
        while(s1<s.length() && p1<p.length()){
            if(s.toLowerCase().charAt(s1)==p.charAt(p1)){
                p1++;
                s1++;
            }else{
                s1++;
            }
            if(p1==p.length()-1) return "YES";
        }
        return "NO";
    }

}
/*

 int s1=0, p1=0;
        while(s1<s.length() && p1<p.length()){
            if(s.toLowerCase().charAt(s1)==p.charAt(p1)){
                p1++;
                s1++;
            }else{
                s1++;
            }
            if(p1==p.length()-1) return "YES";
        }
        return "NO";
 */
