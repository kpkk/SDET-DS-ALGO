package practise;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class practise {

    @Test
    public void test(){
        int[]nums={1,2,5,3,4,5,6};
        remveTargetElement(nums,5);
    }

    public void remveTargetElement(int[] nums, int k){
        int j=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=k){
                nums[j++]=nums[i];
            }
        }
        int[] ts = Arrays.copyOfRange(nums, 0, nums.length-2);
        System.out.println(Arrays.toString(ts));
    }
}
