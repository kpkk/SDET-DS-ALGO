package customImplementation;

import org.junit.Assert;
import org.junit.Test;

public class PrimeNum {

    @Test
    public void test1(){
        int n=17;
        Assert.assertEquals(prime(n),true);
    }
    public boolean prime(int n){
        n=5;
        int count=0;
        for (int i=2;i<n;i++){
            if(n%i==0)count++;
        }
        if(count==0) return true;
        else return false;
    }

}
