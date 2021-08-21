package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FindSubArrayOfEleSumMulipleOfK {

    /*
    Question 3:
Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise. An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 
Example 1:
Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:
Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:
Input: nums = [23,2,6,4,7], k = 13
Output: false

     */

    @Test
    public void test1() {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        Assert.assertTrue(isSubArrayPresent(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 13;
        Assert.assertTrue(isSubArrayPresent(nums, k));
    }

    /*
    - Initialize two pointers left=0, right=0 and sum=0
    - iterate the array from start until the end
    - keep adding the value at the index to the sum
    - if the difference between right-left>0.
        - divide the sum /6 and see if reminder zero then return true
    - else move left by one and set the right as left
     */

    private boolean isSubArrayExists(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) return true;

            }
        }
        return false;
    }

    private boolean isSubArrayPresent(int[] nums, int k) {
       int sum=0;
       HashMap<Integer,Integer>map=new HashMap<>();
       map.put(0,-1);
       for (int i=0;i<nums.length;i++){
           sum+=nums[i];
           int rem= sum%k<0? sum%k+k: sum%k;
           if(map.containsKey(rem) && i-map.get(rem)>=1){
               return true;
           }else {
               map.put(rem,i);
           }
       }
       return false;
    }

}
