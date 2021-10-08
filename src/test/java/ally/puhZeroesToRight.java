package ally;

import org.junit.Assert;
import org.junit.Test;

public class puhZeroesToRight {

    @Test
    public void test1(){
        int[] nums={0,1,2,0,3,0,4,6};
        Assert.assertArrayEquals(pushZeros(nums), new int[]{1,2,3,4,6,0,0,0});
    }

    private int[] pushZeros(int[] nums) {
        int index=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index++]=temp;
            }
        }
        return nums;
    }
}
