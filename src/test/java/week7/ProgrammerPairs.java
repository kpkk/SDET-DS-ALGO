package week7;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ProgrammerPairs {

    /*
    given an array of programmers rating, pair them in such a way that the difference of their ratings  is minimal as possible
     */

    @Test
    public void test1(){
        int[] nums={1,3,6,6};
        Assert.assertEquals(findDifference(nums),2);
    }
    @Test
    public void test2(){
        int[] nums={2,5,6,10,7,6,7,9,7,7};
        Assert.assertEquals(findDifference(nums),4);
    }

    private int findDifference(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        int p1=0, p2=1;
        while (p2<nums.length){
            sum+=Math.abs(nums[p1]-nums[p2]);
            p1=p1+2;
            p2=p2+2;
        }
        return sum;
    }
}
