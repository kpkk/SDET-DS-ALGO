package week6;

import org.junit.Test;

public class FibonacciSeriesUsingRecursion {
    /*
    find fibonacci series for n terms
    input-3
    n=0, n=1, 0+1-->1 1+2-->3 (n-1)+(n-2), 3+2-->5, 5+3-->8
    0 +1, 1+2= 3
    - base condition- n=0 return 0, n=1 return 1
    - develop test data- 5,8
    - edge cases-
    - relate with hard cases
    - apply the pattern
     n+recursion(1)+recursion(0);
    3+2+1+0-->6
     */
    @Test
    public void test1(){  //0 1 1 2 3 5
        int input=6;
        System.out.println(recursion(input));
    }
    @Test
    public void test2(){
        int input=5;
        System.out.println(recursion(input));
    }

    private int recursion(int input){
        if (input==0) return 0;
        if (input==1)return 1;
        int sum= recursion(input-1)+ recursion(input-2);
        return sum;
    }
}
