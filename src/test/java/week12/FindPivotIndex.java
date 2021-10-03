package week12;

import org.junit.Assert;
import org.junit.Test;

public class FindPivotIndex {

    @Test
    public void test1(){
        int[] nums={1,7,3,6,5,6};
        Assert.assertEquals(pivotIndex(nums),3);
    }

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
