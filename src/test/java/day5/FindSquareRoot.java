package day5;

import com.sun.jdi.connect.Connector;
import org.junit.Assert;
import org.junit.Test;

public class FindSquareRoot {

    /*
    Find the square root of any given number using brute force and
     */

    @Test
    public void test1(){
        int number=25;
        Assert.assertEquals(bruteForce(number),5);
    }
    @Test
    public void test2(){
        int number=17;
        Assert.assertEquals(bruteForce(number),4);
    }
    @Test
    public void test3(){
        int number=168;
        Assert.assertEquals(findSquareRootUsingBinary(number),12);
    }
    @Test
    public void test4(){
        int number=-17;
        Assert.assertEquals(findSquareRootUsingBinary(number),4);
    }
    @Test
    public void test5(){
        int number=4;
        Assert.assertEquals(mySqrt(number),2);
    }

    /*
    BruteForce
    -If the input is negative then throw an exception
    -Iterate from the number 1 until the number/2
      - multiply each number by itself then compare with the target
            - if matches the target return i
            - else


     */
    private int findSqureRoot(int number) {
        if(number<0) throw new RuntimeException("invalid input");
        for (int i=1;i<number/2+1;i++){
            if(i*i==number) return i;
            else if(i*i> number) return i-1;
        }
        return -1;
    }

    /*
    Binary search:-
    - If the given number is less than zero throw an exception
    - Initialize variables low=1, high=number/2
    - while low less than or equals to high
        - calculate the mid point
        - if mid * mid is target return mid
        - else if mid > target then high = mid-1
        - else low=mid+1
     - return mid

     */

    private int findSquareRootUsingBinary(int number){
        if(number<0) throw new RuntimeException("negative input");
        int low=2, high=number/2,mid=0;
        while (low<=high){
             mid= (low+high)/2;
            if(mid*mid==number|| (mid* mid<number && (mid+1)* (mid+1)>number ))return mid;
            else if(mid* mid<number) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    public int mySqrt(int x) {
        int low=1, high=x, ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid<=x/mid){
                low=mid+1;
                ans=mid;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    public int bruteForce(int x){
        for(int i=1;i<=x;i++){
            if(i<=x/i && (i+1)>x/(i+1)) return i;
        }
        return -1;
    }
}
