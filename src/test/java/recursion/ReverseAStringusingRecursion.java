package recursion;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAStringusingRecursion {

    /*

    Given a string s ="hello" reverse it using recursion
    Eg: s=hello
    output=olleh
     */
    @Test
    public void test1(){
        String s="hello";
        String output="olleh";
        Assert.assertEquals(reverseString(s),output);
    }
    @Test
    public void test2(){
        String s="ab bc d";
        String output="d cb ba";
        Assert.assertEquals(reverseString(s),output);
    }

    /*
    Approach: recursion
    - base case if the string length becomes zero return empty string
    - Initialize an output string outside method (if its within the method, it will be overridden)
    - call the method recursively wth reduced length
     */
    String output="";
    private String reverseString(String s) {
        if(s.length()==0) return "";
        output+=s.charAt(s.length()-1);
        reverseString(s.substring(0,s.length()-1));
        return output;
    }
}
