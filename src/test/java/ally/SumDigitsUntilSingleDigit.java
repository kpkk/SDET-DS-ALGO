package ally;

import org.junit.Assert;
import org.junit.Test;

public class SumDigitsUntilSingleDigit {

    @Test
    public void test1(){
        int n=1234;
        Assert.assertEquals(sumDigits(n),1);
    }
    @Test
    public void test2(){
        int n=7852;
        Assert.assertEquals(sumDigits(n),4);
    }

    private int sumDigits(int n) {
        int sum=0;
        while (n!=0){
             sum+=n%10;
             n/=10;
        }
        if(sum>=10){
            return sumDigits(sum);
        }

        return sum;
    }
}
