package workshop;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort {

    @Test
    public void test1(){
        int[] arr={5,4,1,7,9,2,3};
        Assert.assertArrayEquals(bubbleSort(arr),new int[]{1,2,3,4,5,7,9});
    }

    private int[] bubbleSort(int[] arr) {
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
