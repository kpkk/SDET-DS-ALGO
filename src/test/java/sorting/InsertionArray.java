package sorting;

import org.junit.Assert;
import org.junit.Test;

public class InsertionArray {

    @Test
    public void test1(){
        int[] nums = {18, 17, 4, 1, 2, 22, 11, 8,};
        Assert.assertArrayEquals(sortArray(nums), new int[]{1, 2, 4, 8, 11, 17, 18, 22});
    }

    private int[] sortArray(int[] nums) {

        for (int i=1;i<nums.length;i++){
            int j=i-1;
            int number=nums[i];
            while (j>=0 && nums[j]>number){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=number;
        }
        return nums;
    }
}
