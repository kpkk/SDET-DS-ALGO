package practise;

import com.sun.media.sound.SF2InstrumentRegion;
import org.junit.Assert;
import org.junit.Test;

public class SecondMax {

    @Test
    public void test(){
        int[] nums={1,2,3,4,4};
        Assert.assertEquals(findSecondMax(nums),3);
    }
    @Test
    public void test1(){
        int[] nums={2,2,2,1};
        Assert.assertEquals(findSecondMax(nums),1);
    }
    @Test
    public void test2(){
        int[] nums={1,2,2,5,3,5};
        Assert.assertEquals(findSecondMax(nums),3);
    }

    private int findSecondMax(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int seconmax = Math.min(nums[0], nums[1]);
        for (int i=1;i<nums.length;i++){
            if(nums[i]>max){
                seconmax=max;
                max=nums[i];
            }
            if(max==seconmax && nums[i]<seconmax){
                seconmax=nums[i];
            }
            if(nums[i]<max && nums[i]>seconmax){
                seconmax=nums[i];
            }
        }
        return seconmax;
    }
}
