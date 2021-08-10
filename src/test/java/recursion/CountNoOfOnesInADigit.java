package recursion;

import org.junit.Assert;
import org.junit.Test;

public class CountNoOfOnesInADigit {

    /*
    Given a non-negative integer  filled with 0's and 1's find the number of 1s
   Eg:- arr=1010, output=2
     */

    /*
    Input: Integer
    Output: Integer
    Approach: recursion
    Test data:- positive, negative and edge

     */

    @Test
    public void test1(){
        int n=1010;
        Assert.assertEquals(countOnes(n),2);
    }
    @Test
    public void test2(){
        int n=000;
        Assert.assertEquals(countOnes(n),0);
    }
    @Test
    public void test3(){
        int n=1111;
        Assert.assertEquals(countOnes(n),4);
    }
    @Test
    public void test4(){
        int n=1010010001;
        Assert.assertEquals(countOnes(n),4);
    }

    /*
    Approach:-
    - base case-> when the number reaches zero return 0
    - get the last number using mod operator then call the method recursively with reduced number (n/10)

     */
    private int countOnes(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return n%10+countOnes(n/10);
    }
}
