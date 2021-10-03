package customImplementation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductArray {
    @Test
    public void test1(){
        int[]nums={1,2,3};
        Assert.assertArrayEquals(productArray(nums),new int[]{5,8,9});
    }

    private int[] productArray(int[] nums) {
        int[] arr=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int sum=0;
           for (int j=0;j<nums.length;j++){
               if(i==j)continue;
               sum+=nums[j];
           }
            arr[i]=nums[i]*sum;
        }
        return arr;
    }

    public static List<Integer> productSum(List<Integer> list){
        List<Integer> output = new ArrayList<>();
        int sum = 0;
        for(Integer i : list) sum+=i;
        for(Integer i : list) output.add((sum - i) * i);
        return output;
    }
}
