package practise;

import org.junit.Assert;
import org.junit.Test;
import sun.jvm.hotspot.memory.Generation;

import java.util.Arrays;

public class subArrayThatAddsUptoSum {
    /*

    find the sub array that sums up to the desired target
     */

    @Test
    public void test1(){
        int[] nums={1,0,40,30,0,0,1,5,1};
        int k=7;
        Assert.assertTrue(Arrays.equals(findSubArray(nums,k),new int[]{4,8}));

    }

    private int[] findSubArray(int[] nums, int k) {
        int left=0, right=0, sum=0;
        while (right<nums.length){
            sum+=nums[right];
            if(sum==k) return new int[]{left,right};
            else if(sum>k){
                sum=sum-nums[left++];
            }
            right++;
        }
        return new int[]{-1,-1};
    }
}
