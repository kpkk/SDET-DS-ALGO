package day5;

import org.junit.Assert;
import org.junit.Test;

public class FindMinUsingkandane {
    /*

    find min sum of sub array using kandane algorithm
     */
    @Test
    public void test1(){
        int[] nums={1,2,-5,-3,2,1,7};
        int result= -8;
        Assert.assertEquals(findMinusingKandane(nums),result);
    }
    @Test
    public void test2(){
        int[] nums={-1,-2,-5,-3,-12};
        int result= -23;
        Assert.assertEquals(findMinusingKandane(nums),result);
    }
    @Test
    public void test3(){
        int[] nums={1,2,5,3,12,1};
        int result= 1;
        Assert.assertEquals(findMinusingKandane(nums),result);
    }
    @Test
    public void test4(){
        int[] nums={1};
        int result= 1;
        Assert.assertEquals(findMinusingKandane(nums),result);
    }
    @Test
    public void test5(){
        int[] nums={-1,-2,-5,3,-12,1};
        int result= -17;
        Assert.assertEquals(findMinusingKandane(nums),result);
    }

    private int findMinusingKandane(int[] nums) {
        if(nums.length==0)
            throw new RuntimeException("Empty array");
        if(nums.length==1) return nums[0];
        int windowSum=nums[0], minSum=nums[0];
        for (int i=1;i<nums.length;i++){
           windowSum= Math.min(windowSum+nums[i],nums[i]);
           minSum=Math.min(minSum,windowSum);

        }
        return minSum;
    }

    /*
    low=1, high=100 eggs=2

    mid=50
     -> if it breaks --> high-->mid-1--> 1+49/2-->25-->
                --> if it doesn't break at 25-->low=mid+1-->  (26+50)/-->38--> 39+50-->89/2-->44-->45+50/2--> 47--> 48+50-->49
     --> if it doesn't break--> low=mid+1;  (51+100)/2  -->75--> 76+100/2->88--> 189/2-> 94--> 195/2-->97-->198/2-->99--> 100+100/2---100
     --> if it brea




     */
}
