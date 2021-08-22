package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class EvenStringLength {

    /*

     */

    @Test
    public void test1(){
        String s="Time to write great code";
        Assert.assertEquals("Time",findLongestEvenString(s));
    }
    @Test
    public void test2(){
        String s="Time to write greats code";
        Assert.assertEquals("greats",findLongestEvenString(s));
    }

    private String findLongestEvenString(String s) {
        int longestEven=Integer.MIN_VALUE;
        String longest="";
        String[] split = s.split("\\s");
        for (String str:split){
            if(str.length()%2==0 && str.length()>longestEven){
                    longestEven=str.length();
                    longest=str;
            }
        }
        return longest;
    }
}
