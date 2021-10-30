package sorting;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSort {

    @Test
    public void test1() {
        int[] nums = {18, 17, 4, 1, 2, 22, 11, 8,};
        Assert.assertArrayEquals(sortArray(nums), new int[]{1, 2, 4, 8, 11, 17, 18, 22});
    }

    /*
    - iterate the array from start index until the last but one element
    - consider the current index (i)as minIndex
    - iterate the array in inner loop from i+1 until the end
    - check if the number at index j is less than the number at minIndex
        - if yes update minIndex with j
    - swap the numbers at index i and minIndex
    - keep doing about the steps until the whole array is sorted

     */
    private int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex=i;
            for (int j = i + 1; j < nums.length; j++) {
               if(nums[j]<nums[minIndex]) minIndex=j;
            }
            int temp=nums[minIndex];
            nums[minIndex]=nums[i];
            nums[i]=temp;
        }
        return nums;
    }
}
