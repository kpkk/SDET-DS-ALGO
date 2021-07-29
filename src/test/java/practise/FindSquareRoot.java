package practise;

import org.junit.Assert;
import org.junit.Test;

public class FindSquareRoot {

    @Test
    public void test(){
        int number=25;
        Assert.assertEquals(findSquareRoot(number),5);
    }

    private int findSquareRoot(int number) {
        int low=0,high=number/2;
        while (low<=high){
            int mid=(low+high)/2;
            if(mid*mid==number || mid*mid<number &&(mid+1)*(mid+1)>number) return mid;
            else if(mid*mid>number) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }

}
