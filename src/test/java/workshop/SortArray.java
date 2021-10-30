package workshop;

import org.junit.Assert;
import org.junit.Test;

public class SortArray {

    @Test
    public void test1(){
        int[] arr={1,4,3,2,7,9,6,3};
        Assert.assertArrayEquals(insertionSortArray(arr),new int[]{1,2,3,3,4,6,7,9});
    }

    private int[] insertionSortArray(int[] arr) {
       for (int i=1;i<arr.length;i++){
           int current=arr[i];
           int j=i-1;
           while (j>=0 && arr[j]>current){
               arr[j+1]=arr[j];
               j--;
           }
           arr[j+1]=current;
       }
       return arr;
    }
}
