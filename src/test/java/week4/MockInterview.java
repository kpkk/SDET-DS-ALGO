package week4;

import org.junit.Assert;
import org.junit.Test;

public class MockInterview {

    /*
    given an integer array which is not -sorted, need to find max difference between any 2 values and return their indices
     */

    /*
     Input:- Integer array
     Output:- integer array
     Constraints:-
     test data- {2,1,5,7,4,8}, {6},{},{1,2,3,4,5}
     Approach:-
     Pseudo code:-
     - Initialize variables left=0, right=1, maxDifference=Integer.MINVALUE and an integer array
     - Iterate the array from start index till the end using two pointer
        - start left at 0
        - start right at 1
     - get the absolute difference of two value and check with max
     - store the indices into the new array and return the same

     O-notations
     */

    @Test
    public void test1(){
        int[] arr={2,1,5,7,4,8};
        int[] indices={1,5};
        Assert.assertArrayEquals(findIndices(arr),indices);

    }
    @Test
    public void test2(){
        int[] arr={2,1,5,7,4,8};
        int[] indices={1,5};
        Assert.assertArrayEquals(findIndices(arr),indices);

    }
    @Test
    public void test3(){
        int[] arr={2,1,5,7,4,8};
        int[] indices={1,5};
        Assert.assertArrayEquals(findIndices(arr),indices);

    }

    private int[] findIndices(int[] arr) {
        int []indices=new int[2];
       int min=arr[0];
       int max=arr[0];
       for (int i=1;i<arr.length;i++){
           if(arr[i]<min){
               indices[0]=i;
           }
           if(arr[i]>max){
               indices[1]=i;
           }
       }
        return indices;
    }
}
