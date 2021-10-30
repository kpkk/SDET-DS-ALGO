package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BubbleSort {

    @Test
    public void test1(){
        int[] arr={4,1,5,2,9,8};
        Assert.assertArrayEquals(sortArray(arr),new int[]{1,2,4,5,8,9});

    }

    private int[] sortArray(int[] arr) {

        for (int i=0;i<arr.length;i++){
            for (int j=1;j<arr.length-1;j++){
                if(arr[j-1]>arr[j]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
//aaabbcssssstaaa - find the max length of char

}
