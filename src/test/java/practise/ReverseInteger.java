package practise;

import org.junit.Test;

public class ReverseInteger {

    @Test
    public void test1(){
        int n=001200;
        int i = reverseInteger(n);
        System.out.println(i);
    }

    /*
    - initialize a variable reverse=0
    - get the last digit from the number- using mod
    - add the last digit to the rev*10
    - divide the number to redce it place value
    - return the number
     */

    private int reverseInteger(int n) {

        if(n<0) n=n*-1;
        int rev=0;
        while (n>0){
            rev=rev*10+n%10;
            n/=10;
        }
        return rev;
    }
}
