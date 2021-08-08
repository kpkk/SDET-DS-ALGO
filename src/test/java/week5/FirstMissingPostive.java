package week5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FirstMissingPostive {
    
    /*
    Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
     */
    
    @Test
    public void test1(){
        int[] nums={1,2,0};
        Assert.assertEquals(3,findMissingValueConstantSpace(nums));
    }
    @Test
    public void test2(){
        int[] nums={7,8,9,11,12};
        Assert.assertEquals(1,findMissingValueConstantSpace(nums));
    }
    @Test
    public void test3(){
        int[] nums={3,4,-1,1};
        Assert.assertEquals(2,findMissingValueConstantSpace(nums));
    }
    @Test
    public void test4(){
        int[] nums={-3,-4,-1,-11};
        Assert.assertEquals(1,findMissingValueConstantSpace(nums));
    }
    @Test
    public void test5(){
        int[] nums={3,4,1,6,2};
        Assert.assertEquals(5,findMissingValueConstantSpace(nums));
    }

    /*
    Approach:- ArrayList
    Solution:-
    - Initialize an arraylist of integer type
    - Traverse the input array from start index until end
    - find the max number
    - iterate until the max number and from 1 and add every element into list
    - Traverse the input array then check if the value of index is present in list
    - if not return the number
    - if the current index value is 0 just continue
    - if all the elements present in the list then return max+1

     */

    // Time complexity- O(n)
    //space complexity - O(n)
    private int findMissingvalue(int[] nums) {
        ArrayList<Integer>list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        if(max<0) return 1;
        for (int i=1;i<=max;i++){
            list.add(i);
        }
        for (int i=0;i<nums.length;i++){
            if(nums[i]==0)continue;
            else if(list.contains(nums[i])){
                list.remove((Integer)nums[i]);
            }

        }
        if(list.isEmpty()) return max+1;
        else return list.get(0);
    }

    /*
    -Solution:-
    - Traverse the array from left (start index) until end
    - if the number at index is either less than zero or greater then length just make them n+1 (because we can return 1, if everything is in outer range)
    - traverse the array from start index until the end
    - get the absolute value of the particular index
    - check if the abs is greater than length of array, if yes continue
    - else, decrement abs by 1 (abs--)
    - if number at index abs is greater than zero them multiply by -1 (to make it negative)
    - traverse the array from left to right
    - check if the number at index is greater than 0
    - if yes, return the index plus 1 i+1
    - else return the nums.length+1
     */
    private int findMissingValueConstantSpace(int[] nums){
        for(int i=0;i<nums.length;i++) {
            if (nums[i] < 0 || nums[i] > nums.length) nums[i] = nums.length + 1;
        }
            for (int i=0;i<nums.length;i++){
                int abs = Math.abs(nums[i]);
                if(abs>nums.length)continue;
                abs--;
                if(nums[abs]>0){
                    nums[abs]*=-1;
                }
            }
            for (int i=0;i<nums.length;i++){
                if(nums[i]>0){
                    return i+1;
                }
            }
        return nums.length+1;
    }
}
