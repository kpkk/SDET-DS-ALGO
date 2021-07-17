package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class KthSmallestSum {
    /*

    Given an integer array nums of length n and an integer k, return the kth smallest subarray sum.
A subarray is defined as a non-empty contiguous sequence of elements in an array. A subarray sum is the sum of all elements in the subarray.

Example 1:
Input: nums = [2,1,3], k = 4
Output: 3
Explanation: The subarrays of [2,1,3] are:
- [2] with sum 2
- [1] with sum 1
- [3] with sum 3
- [2,1] with sum 3
- [1,3] with sum 4
- [2,1,3] with sum 6
Ordering the sums from smallest to largest gives 1, 2, 3, 3, 4, 6. The 4th smallest is 3.
Example 2:
Input: nums = [3,3,5,5], k = 7
Output: 10
Explanation: The subarrays of [3,3,5,5] are:
- [3] with sum 3
- [3] with sum 3
- [5] with sum 5
- [5] with sum 5
- [3,3] with sum 6
- [3,5] with sum 8
- [5,5] with sum 10
- [3,3,5], with sum 11
- [3,5,5] with sum 13
- [3,3,5,5] with sum 16
Ordering the sums from smallest to largest gives 3, 3, 5, 5, 6, 8, 10, 11, 13, 16. The 7th smallest is 10.
     */

    @Test
    public void test1(){
        int[] nums={2,1,3};
        int k=4;
        Assert.assertEquals(findSum(nums,k),4);
    }
    @Test
    public void test2(){
        int[] nums={3,3,5,5};
        int k=7;
        findSum(nums,k);
        Assert.assertEquals(findSum(nums,k),10);
    }

    /*

    Solution:-
    1. Initialize an array list of type integer
    2. Initialize the variables left=0, right=1 and sum=0
    3. Traverse through the array and sum all the elements and store it in max
    4. add the first index value and the sum into the list
    5. Traverse through the array from index 1 till the end
    6. reset the values of sum=nums[0] and left=0, right=1
    7. While right<length add the elements
    8. When the right crosses i (window size) then deduct the previous index value
    9. add the sum to the list
    10. Sort the list(Collections.sort()) and return the kth index
     */


    //Time complexity- O(n^2)
    //Space complexity- O(n)
    private int findSum(int[] nums, int k) {
        ArrayList<Integer>list=new ArrayList<>();
        int sum=0,left=0,right=1;

        for (int i=0;i<nums.length;i++)
            sum+=nums[i];
        list.add(sum);
        list.add(nums[0]);
        for (int i=1;i<nums.length;i++){
            left=0; right=1;
            sum=nums[0];
            while (right<nums.length){
                sum+=nums[right++];
                if (right>i) sum-=nums[left++];
                list.add(sum);
            }

        }


        Collections.sort(list);
        return list.get(k);
    }
}
