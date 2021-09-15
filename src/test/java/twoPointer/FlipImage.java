package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class FlipImage {


    @Test
    public void test1(){
        int[][] image={{1,1,0},{1,0,1},{0,0,0}};
        Assert.assertArrayEquals(flipAndInvertImage(image),new int[][]{{1,0,0},{0,1,0},{1,1,1}});
    }
     /*
         input - two dimensional array
         output- two dimensional array

         Solution:-
         - iterate the array from start index until end
         - get the first row, assign that to a new array
         - reverse the array then traverse through the array then flip 1s with 0 and vice versa
         - return the array
        */
    // time complexity O(n*k)
    // space complexity- O(1)
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int[] arr=image[i];
            int left=0, right=arr.length-1;
            while(left<=right){
                int temp=arr[left];
                arr[left++]=arr[right];
                arr[right--]=temp;
            }
            for(int j=0;j<arr.length;j++){
                if(arr[j]==0) arr[j]=1;
                else arr[j]=0;
            }

        }
        return image;
    }
}
