package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

int[] nums;
    @Test
    public void test1(){
        int[] nums={11,4,17, 18, 2,22,1,8};
        Assert.assertArrayEquals(quickSort(nums), new int[]{1,2,4,8,11,17,18,22});
    }
    @Test
    public void test2(){
        int[] nums={8, 5 ,1, 8, 4};
      //  Assert.assertArrayEquals(findPivot(nums,0, nums.length-1), new int[]{1,4,5,8,8});
    }


    /*
    Pseudo
    1) get the Pivot (left most)
2) Set 2 pointers: left->0, right -> length-1
3) Increment left until you find that number >=pivot
4) decrement thr right until you find number<=pivot
5) swap left and right
6) continue with step 3 &4 until the left crosses right

     */

    /*
    /* Partitioning
	 * 1. Take the first element as Pivot
	 * 2. Set pointer left as 0 and right as length -1
	 * 3. Iterate till left < right
	 *    a) Increment left till left value is >= pivot
	 *    b) Decrement right value till right <= pivot
	 *    c) Swap left and right
	 * 4. Swap pivot and right

     */

    private int[] quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right) {
        if(left>right) return;
       int midPoint= findPivot(nums,left,right);
       quickSort(nums,0,midPoint);
       quickSort(nums,midPoint+1,right);
    }


    private int findPivot(int[] arr, int left, int right){

        int pivot=arr[left];
        int pivotIndex=left;
        while (left<right){
            while (left<=right &&arr[left]<=pivot)
                left++;
            while (left<=right && arr[right]>=pivot)
                right--;
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

        }
        int temp=arr[right];
        arr[right]=arr[pivotIndex];
        arr[pivotIndex]=temp;

        System.out.println(Arrays.toString(arr));
        return right;
    }
}
