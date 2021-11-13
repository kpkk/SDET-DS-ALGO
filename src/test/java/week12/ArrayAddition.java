package week12;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ArrayAddition {

    @Test
    public void test1(){
        int[] arr={3,5,-1,8,12};
        Assert.assertTrue(arrayAddition(arr));
    }
    @Test
    public void test2(){
        int[] arr={5,7,16,1,2};
        Assert.assertFalse(arrayAddition(arr));
    }

    private boolean arrayAddition(int[] arr) {


        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i]>max)max=arr[i];
        }
        int j=0, sum=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==max)continue;
            sum+=arr[i];
            while (sum>max){
                sum-=arr[j];
                if(sum==max) return true;
                else sum+=arr[j];
                j++;
            }
        }
        return false;
    }
}
