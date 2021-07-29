package practise;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayInterSection {
    /*
    /*
    3) Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
     */

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] integers = intersectionArr(nums1, nums2);
      //  Assert.assertEquals(integers,new Integer[]{2});
        System.out.println(Arrays.toString(integers));
        //  Integer[] output = findInterSection(nums1, nums2);
        //  Assert.assertEquals(output,new Integer[]{2});
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 2, 2, 1, 3, 4, 3};
        int[] nums2 = {2, 2, 3, 6, 4};
        //  Integer[] output = findInterSection(nums1, nums2);
        //  Assert.assertEquals(output, new Integer[]{2, 3, 4});
        int[] integers = intersectionArr(nums1, nums2);
        Assert.assertEquals(integers,new Integer[]{2,3,4});
        System.out.println(Arrays.toString(integers));
    }

    @Test
    public void test5() {
        int[] nums1 = {};
        int[] nums2 = {};
        int[] integers = intersectionArr(nums1, nums2);
      //  Assert.assertEquals(integers,new Integer[]{});
        System.out.println(Arrays.toString(integers));
        //  Integer[] output = findInterSection(nums1, nums2);
        //  Assert.assertEquals(output,new Integer[]{2});
    }

    private int[] intersectionArr(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length+nums2.length];
        int p1=0,p2=0;
        int index=0;
        while (p1<nums1.length &&p2< nums2.length){
            ArrayList list=new ArrayList(12);
            if(nums1[p1]==nums2[p2]){
                nums[index++]=nums1[p1];
                p1++;
                p2++;
            }

            else if(nums[p1]<nums2[p2]) p1++;
            else p2++;


        }
        return Arrays.copyOfRange(nums,0,index);
    }
}
