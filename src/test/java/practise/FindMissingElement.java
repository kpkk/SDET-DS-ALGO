package practise;

import org.junit.Assert;
import org.junit.Test;

public class FindMissingElement {
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
    public void test(){
        int[] nums={1,1,2,3,3,4,4,8,8};
        Assert.assertEquals(findMissingEle(nums),2);
    }

    private int findMissingEle(int[] nums) {
        int low=0, high=nums.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(nums[mid]!=nums[mid-1]&& nums[mid]!=nums[mid+1]) return nums[mid];
            else if(nums[mid]==nums[mid-1]){
                if(high-mid%2==1){
                    low=mid+1;
                }else{
                    high=mid-2;
                }
            }else if(nums[mid]==nums[mid+1]){
                if((mid-low)%2==1){
                    high=mid-1;
                }else{
                    low=mid+2;
                }
            }
        }
        return -1;
    }
}
