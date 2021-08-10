package recursion;

import org.junit.Assert;
import org.junit.Test;

public class CountOccurrencesOfSubStringInS {

    /*
    Given a string and substring find the number of occurrences of substring in main string
    Eg:- s= the man the cat the animal, s1=the
    output=3 (the s2, has occurred 3 times in the main string)
     */

    /*
    Input: Integer
    Output: Integer
    Approach: recursion
    Test data:- positive, negative and edge
     */

    @Test
    public void test1(){
        String s1="the man the cat the animal";
        String s2="the";
        Assert.assertEquals(findOccurrences(s1,s2),3);
    }
    @Test
    public void test2(){
        String s1="welcome to java";
        String s2="the";
        Assert.assertEquals(findOccurrences(s1,s2),0);
    }
    @Test
    public void test3(){
        String s1="welcome";
        String s2="welcome";
        Assert.assertEquals(findOccurrences(s1,s2),1);
    }

    /*
    Solution:-
    base case- when s1 doesn't contain in s1
    - replace the first occurrence of the substring in the main string and recursively call the method with new string
     */
    private int findOccurrences(String s1, String s2) {
        if(!s1.contains(s2)) return 0;
        return findOccurrences(s1.replaceFirst(s2,""),s2)+1;
    }
}
