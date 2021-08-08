package week6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CountOnesAndZeroesRecursion {

    /*
    given an array with ones and zeros (need not be a sorted one), find the number of ones and zeros
    [1,0,0,1,0] -->2
    - Base condition--> until the array length reaches 0
    - develop test data --> {1,1,1,1,1}{0,0,0,0},{1},{0}
    -
     */
    @Test
    public void test1(){
        int num=1010;
       // Problem 2: The input is integer and examples are 1010 … 1111
        Assert.assertEquals(recursion(num),2);

    }
    @Test
    public void test2(){
        int num=1111;
        // Problem 2: The input is integer and examples are 1010 … 1111
        Assert.assertEquals(recursion(num),4);

    }

    private int recursion(int num) {
        if(num==0) return 0; //1010
        int count=0;
        if(num%10==1) count++; //count=0
        count+=recursion(num/10); //101 1+ recursion(10)+0+recursion(1)+1-->count-2
        return count;
    }
}
