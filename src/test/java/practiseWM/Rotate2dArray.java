package practiseWM;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Rotate2dArray {


    @Test
    public void test1(){
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        Assert.assertEquals(rotate90(arr),new int[][]{{4,8,12,16},{3,7,11,15},{2,6,10,14},{1,5,9,13}});
    }
    @Test
    public void test2(){
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        Assert.assertEquals(rightRotate(arr),new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }



    private int[][] rotate90(int[][] arr) {

        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
      //  System.out.println(Arrays.deepToString(arr));

        for (int i=0;i<arr.length;i++){
            int j=0, k=arr.length-1;
            while (j<k){
                int temp=arr[j][i];
                arr[j][i]=arr[k][i];
                arr[k][i]=temp;
                j++;
                k--;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        return arr;
    }

    public int[][] rightRotate(int[] [] nums){

        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                int temp=nums[i][j];
                nums[i][j]=nums[j][i];
                nums[j][i]=temp;
            }
        }

      //  System.out.println(Arrays.deepToString(nums));

        for (int i=0;i<nums.length;i++){
            int j=0, k=nums[0].length-1;
            while (j<k){
                int temps=nums[i][j];
                nums[i][j]=nums[i][k];
                nums[i][k]=temps;
                j++;
                k--;
            }
        }
        System.out.println(Arrays.deepToString(nums));
        return nums;
    }

}
