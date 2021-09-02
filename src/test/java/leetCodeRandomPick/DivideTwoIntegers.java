package leetCodeRandomPick;

import com.sun.xml.internal.bind.v2.util.EditDistance;
import org.junit.Assert;
import org.junit.Test;

public class DivideTwoIntegers {

    /*

    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.



Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
Example 3:

Input: dividend = 0, divisor = 1
Output: 0
Example 4:

Input: dividend = 1, divisor = 1
Output: 1


Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
     */
    /*
    Input- integer
    output- integer
     */

    @Test
    public void test1(){
       int dividend=10;
       int divisor=3;
        Assert.assertEquals(divideTwoIntegers(divisor,dividend),3);
    }
    @Test
    public void test2(){
        int dividend=7;
        int divisor=-3;
        Assert.assertEquals(divideTwoIntegers(divisor,dividend),-2);
    }
    @Test
    public void test3(){
        int dividend=1<<31;
        int divisor=-1;
        System.out.println(dividend/divisor);
        Assert.assertEquals(divideTwoIntegers(divisor,dividend),-2);
    }



    /*
    - While the divisor can be subtracted from dividend
    - double the divisor and increment the count
    - if the divisor value goes beyond the dividend then add the count to result and reset the count
    - now subtract the temp variable from dividend then repeat the above process
     */

    private int divideTwoIntegers(int divisor, int dividend) {
        if(dividend==1<<31 && divisor==-1) return Integer.MAX_VALUE;
        boolean sign= (dividend>=0) ==( divisor>=0)?true:false;
        int result=0;
        dividend=Math.abs(dividend);
       divisor=Math.abs(divisor);
        while (dividend-divisor>=0){
            int count=0;
            while (dividend- (divisor<<1<<count)>=0){
                count++;
            }
            result+=1<<count;
            dividend-=divisor<<count;
        }
        return sign?result:-result;
    }

}
