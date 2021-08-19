package leetCodeRandomPick;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
     */

    /*
    Input- Integer Array
    Output: List of Arrays
    Constraint - i!=j, j!=k,i!=k

    Solution:-
    - Sort the list
    - Initialize three pointers i=0, j=i+1, k=nums.length
    - while i<nums.length

     */
    @Test
    public void test1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /*
    Sort+ three pointer
    - Sort the given array
    - iterate the array from start index until length-2
    - if i>0 and nums[i] and nums[i-1] are same then
    - Initialize pointers j=i+1, k=length-1
    - initialize variable called diff= target- nums[i] // we know target is 0 in this sum
    - while j<k (apply two pointer technique)
    - if nums[j]+nums[k]= diff, then ad the i,j, k values to the list
    - move j,k
    - if the sum is less than diff,then do j++;
    - else if the sum is greater than diff then do k--
    - return the list

     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>result=new ArrayList<>();
        for (int i=0;i<nums.length-2;i++){
            if(i>0&& nums[i]==nums[i-1])continue;
            int j=i+1, k= nums.length-1;
            // the expected target is 0 (sum of nums[i]+nums[j]+nums[k]==0)
            int diff=0-nums[i];
            while (j<k){
                if(nums[j]+nums[k]==diff){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                    while (j<k && nums[j]==nums[j-1])j++;
                    while (j<k && nums[k]==nums[k+1])k--;
                }else if(nums[j]+nums[k]<diff){
                    j++;
                }else{
                    k--;
                }
            }
        }

        return result;
    }
}
