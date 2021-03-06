package day5;

import org.junit.Assert;
import org.junit.Test;

import javax.jnlp.IntegrationService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindPeakElement {

    /*
    A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
     */

    @Test
    public void test1(){
        int[] nums={1,2,3,1};
        int output=2;
        Assert.assertEquals(findPeakElement(nums),output);
    }
    @Test
    public void test2(){
        int[] nums={1,2,1,3,5,6,4};
        int output=5;
        Assert.assertEquals(findPeakElement(nums),output);
    }
    @Test
    public void test3(){
        int[] nums={1,2,1,3,5,6,7};
        int output=1;
        Assert.assertEquals(findPeakElement(nums),output);
    }
    @Test
    public void test4(){
        int[] nums={2,1};
        int output=0;
        Assert.assertEquals(findPeakElement(nums),output);
    }

    private int findPeakElementq(int[] nums){
        int low=0, high=nums.length-1;
        HashMap<String, Integer> map=new HashMap<>();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        while (low<high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[mid+1]) high=mid;
            else low=mid+1;
        }
        return low;
    }

    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums.length==2){
            if(nums[0]>nums[1]) return 0;
            else return 1;
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
        }
        return -1;
    }
}
