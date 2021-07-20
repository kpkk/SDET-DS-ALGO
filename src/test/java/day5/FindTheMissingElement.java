package day5;

import org.junit.Assert;
import org.junit.Test;

public class FindTheMissingElement {

    /*

    You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
Follow up: Your solution should run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

     */

    @Test
    public void test1(){
        int[] nums={1,1,2,3,3,4,4,8,8};
        int result=2;
       Assert.assertEquals(findMissing(nums),result);
    }
    @Test
    public void test2(){
        int[] nums={1,1,2,2,3,3,4,4,8,8};
        int result=-1;
        Assert.assertEquals(findMissing(nums),result);
    }
    @Test
    public void test3(){
        int[] nums={1,1,2,2,3,3,4,4,8};
        int result=8;
        Assert.assertEquals(findMissing(nums),result);
    }
    @Test
    public void test4(){
        int[] nums={1,2,2,3,3,4,4,8,8};
        int result=1;
        Assert.assertEquals(findMissing(nums),result);
    }

    /*

    Solution:-
    1. Initialize low=0, high=length-1
    2. while low< high
        - calculate mid
        - if value at mid and mid+1 are not same and values at mid, mid-1 then -->return value at mid
        - If the values at [mid and mid-1 ]are same but [mid and mid+1 ]are not same
               - calculate the length from mid-1 to low, if its odd move high= mid-1
         - If the values at [mid and mid-1] are not same but [mid and mid+1] are same
               -  check if the length between high to mid+1 is odd then move low=mid+1
    3. return value at mid
     */

    private int findMissing(int[] nums) {

        int low=0, high=nums.length-1, mid=0;
        while (low<=high){
            mid=(low+high)/2;
            if(mid==nums.length-1) return nums[mid];
            if(mid==nums[0]) return nums[0];
            if(nums[mid]!=nums[mid+1]&&nums[mid]!=nums[mid-1]) return nums[mid];
            else if(nums[mid]==nums[mid+1]){
                if((mid-low)%2==1)
                    high=mid-1;
                else
                    low=mid+2;


            }else if(nums[mid]==nums[mid-1])
                if((high-mid)%2==1)
                    low=mid+1;

                else
                    high=mid-2;

            }

        return -1;
    }

}
