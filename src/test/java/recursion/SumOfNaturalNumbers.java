package recursion;

import org.junit.Assert;
import org.junit.Test;

public class SumOfNaturalNumbers {

    /*
    Find the sum of n natural numbers using recursion technique
     */
 /*
    Input: Integer
    Output: Integer
    Approach: recursion
    Test data:- positive, negative and edge

     */
    @Test
    public void test1(){
        int n=4;
        Assert.assertEquals(findSum(n),10);
    }
    @Test
    public void test2(){
        int n=10;
        Assert.assertEquals(findSum(n),55);
    }

    /*
    Approach: Recursion
    - Base condition, when n=1 return 1 and n=0 return 0
    - add the n to the recursive call of the method with n-1 as input
    - keep repeating the process until base case is reached

     */

    private int findSum(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return n+findSum(n-1);
    }
}
