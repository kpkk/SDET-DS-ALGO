package ally;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class RemoveDuplicatesFromArray {

    @Test
    public void test1(){
        int[] nums={4,8,-3,-4};
        Assert.assertArrayEquals(removeDuplicates(nums),new int[]{8,-3});
    }


    private int[] removeDuplicates(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int[] output=new int[nums.length];
        int index=0;
        for (int i=0;i<nums.length;i++){
            map.put(Math.abs(nums[i]),map.getOrDefault(Math.abs(nums[i]),0)+1);
        }
       for (int i=0;i<nums.length;i++){
           if(map.containsKey(Math.abs(nums[i])) && map.get(Math.abs(nums[i]))==1)
               output[index++]=nums[i];
       }

        return Arrays.copyOfRange(output,0,index);
    }
}
