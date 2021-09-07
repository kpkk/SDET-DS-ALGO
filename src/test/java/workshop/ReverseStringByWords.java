package workshop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class ReverseStringByWords {
    /*
    reverse the input string by word
    - input- today is beautiful day
    - output - day beautiful a is today
     */

    /*
    input- string
    output- string
    constraint, solve in less than O(n)
     */
    @Test
    public void test1(){
        String s="today is a beautiful day";
        Assert.assertEquals(reverseString(s),"day beautiful a is today");
    }
    @Test
    public void test2(){
        String s="madam";
        Assert.assertEquals(reverseString(s),"madam");
    }
    /*
    Solution:-
    - split the string into array of strings based on space delimiter
    - initialize two pointers, lef=0, right=last index of the array
    - swap the strings  at i and j
    - return the string value of newly formed array
     */
    private String reverseString(String s) {
        String[] str = s.split(" ");
        if(str.length==1) return str[0];
        String output="";
        int left=0, right=str.length-1;
        while (left<right){
            String temp=str[left];
            str[left++]=str[right];
            str[right--]=temp;
        }
        for (int i=0;i<str.length;i++){
            output+=str[i]+" ";
        }
        return output.trim();
    }
}
