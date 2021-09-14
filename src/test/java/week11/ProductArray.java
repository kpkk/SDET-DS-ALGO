package week11;

import org.junit.Assert;
import org.junit.Test;

public class ProductArray {

    @Test
    public void test1(){
        int [] nums={41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        Assert.assertEquals(arraySign(nums),-1);
    }

    public int arraySign(int[] nums) {
        int product=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) return 0;
            else if(nums[i]<0) nums[i]=-1;
            else if(nums[i]>0) nums[i]=1;
            product*=nums[i];
            //try the unary operator
        }
        if(product<0) return -1;
        else if(product>0) return 1;
        else return 0;
    }
}
