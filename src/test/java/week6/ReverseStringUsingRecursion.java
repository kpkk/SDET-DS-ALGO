package week6;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringUsingRecursion {
    String  output="";

    /*
    reverse a string using recursion
     */
    @Test
    public void test1(){
        String s="hello";
        Assert.assertEquals(reverseString(s),"olleh");
    }
    @Test
    public void test2(){
        String s="aa bbc";
        Assert.assertEquals(reverseString(s),"cbb aa");
    }

    private String reverseString(String s) {
        if(s.length()==0) return "";
        output+=s.charAt(s.length()-1);
        reverseString(s.substring(0,s.length()-1));
        return output;
    }

    /*





Cards = {1,7,3} -> P1 (1+3) -> P2 (7) -> false
Cards = {1,6,23,7} -> P1 (1+23) -> P2 (6+7) -> true
Cards = {1,2,2,1} ->  P1 (1+2) -> P2 (2+1) -> true
 2 Persons are playing the open cards and Person always need to pick the first card
Rules
1) Rule 1 - The person can pick only card on the either end (0, Len-1)
2) Second Person can pick the card only after Person 1 picks it
3) Again, Person 1 can pick only after Person 2 picks
Outcome
1) If the points taken by Person 1 => Person 2 -> return true
2) If the points taken by Person 2 > Person 1 -> return false
     */
}
