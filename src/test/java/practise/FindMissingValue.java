package practise;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindMissingValue {

    @Test
    public void test1() {
        int[] nums = {3, 0, 1};
        int k = 2;
        Assert.assertEquals(bruteForce(nums), k);
    }

    @Test // throw a message saying none is missing
    public void test2() {
        int[] nums = {1, 0, 2, 3, 4};
        int k = 5;
        Assert.assertEquals(bruteForce(nums), k);
    }

    @Test // throw an exception
    public void test3() {
        int[] nums = {20,22,24};
        int k = 21;
        Assert.assertEquals(bruteForce(nums), k);
    }
    @Test
    public void test4() {
        int[] nums = {};
        int i = bruteForce(nums);
        System.out.println(i);
    }


    @Test
    public void test5() {
        int[] nums = {0, 2, 1, 3};
        int i = bruteForce(nums);
        System.out.println(i);
    }

    @Test
    public void test6() {
        int[] nums = {3};
        int i = bruteForce(nums);
        System.out.println(i);
    }

    @Test
    public void test7() {
        int[] nums = {3, 0, 1};
        int k = 2;
        Assert.assertEquals(bruteForce(nums), k);
    }
    @Test
    public void test8() {
        int[] nums = {0,1,6,8,5,4,3,2};
        int k = 7;
        Assert.assertEquals(bruteForce(nums), k);
    }


    /*

    Pseudo code:-
    1. Add the n elements into a list
    2. Then iterate the given array
    3. if number doesn't present then return the element
     */

    // Time Complexity- O(n2)
    //space complexity- O(1)
    public int bruteForce(int[] nums){

        if (nums.length<=1)
            throw new RuntimeException("empty array");
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[j]-nums[i]>1)
                    return nums[j]-1;
                else
                    break;

            }
        }
       return 0;
    }
}
