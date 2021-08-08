package week6;

import org.junit.Assert;
import org.junit.Test;

public class CountSubStringInString {

    /*
    Count the occurrences of substring in given string

    Example: the man the cat-->
    str2- the
    output-2
     */
    @Test
    public void test1(){
        String s1="the man the cat";
        String s2="the";
        Assert.assertEquals(countOccurrences(s1,s2),2);
    }
    @Test
    public void test2(){
        String s1="man cat";
        String s2="the";
        Assert.assertEquals(countOccurrences(s1,s2),0);
    }
    @Test
    public void test3(){
        String s1="man cat aa";
        String s2="a";
        Assert.assertEquals(countOccurrences(s1,s2),4);
    }

    private int countOccurrences(String s1, String s2) {
        if(!s1.contains(s2)) return 0;
       return countOccurrences(s1.replaceFirst(s2,""),s2)+1;


    }
}
