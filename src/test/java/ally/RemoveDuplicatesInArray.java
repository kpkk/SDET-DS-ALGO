package ally;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesInArray {

    @Test
    public void test1(){
        int[] nums={1,3,4,5,1,3,6,2,4,1};
        Assert.assertArrayEquals(removeDups(nums),new int[]{1,2,3,4,5,6});
    }

    // this will only work for sorted array
    private int[] removeDups(int[] nums) {
        Arrays.sort(nums);
        int left=0, right=1;
        while (right<nums.length){
            if(nums[left]==nums[right]){
                right++;
            }else{
                nums[++left]=nums[right++];
            }
        }
        return Arrays.copyOfRange(nums,0,left+1);
    }
}
