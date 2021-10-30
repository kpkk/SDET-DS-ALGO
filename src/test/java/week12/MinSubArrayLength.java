package week12;

import org.junit.Assert;
import org.junit.Test;

public class MinSubArrayLength {

    @Test
    public void test1(){
        int[] nums={1,3,3};
        int k=6;
        Assert.assertEquals(subArrayLength(nums,k),2);
    }

    private int subArrayLength(int[] nums, int k) {
        int sum=0, length=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            sum=nums[i];
            if(nums[i]==k) return 1;
            for (int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k){
                    length=Math.min(length,j-i+1);

                }
            }
        }
        return length;
    }
}
