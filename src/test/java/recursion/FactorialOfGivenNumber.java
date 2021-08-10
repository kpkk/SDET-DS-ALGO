package recursion;

import org.junit.Assert;
import org.junit.Test;

public class FactorialOfGivenNumber {

    /*
    For any given non-negative integer valuee find its factorial using recursion technique
    Eg: input-5, output-120

     */

    /*
   Input: Integer
   Output: Integer
   Approach: recursion
   Test data:- positive, negative and edge

    */
    @Test
    public void test1(){
        int input=5;
        Assert.assertEquals(findFactorial(input),120);
    }
    @Test
    public void test2(){
        int input=2;
        Assert.assertEquals(findFactorial(input),2);
    }

    /*
    Approach: recursion:-
    The base case would be when input==1 return 1
    - call recursively the function with n-1, until the base condition reaches and mutliply with n

     */
    private int findFactorial(int input) {
        if(input<0) return 0;
        if (input==1) return 1;
        return input*findFactorial(input-1);
    }
}
