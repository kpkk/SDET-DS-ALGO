package day5;

import org.junit.Assert;
import org.junit.Test;

public class FindIndexOfNumber {

    /*

    P3) There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4


1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? integer
        What is the expected output?  integer
        Do I’ve constraints to solve the problem? solve using binary search
        Do Ive all the information to go to the next steps yes
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this
5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data
10. If it fails then debug to solve it
11. Optimize the code and remove unnecessary code

     */
    @Test
    public void test1(){
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        Assert.assertEquals(findTargetElementIndex(nums,target),4);
    }
    @Test
    public void test2(){
        int[] nums={4,5,6,0,1,2,3};
        int target=2;
        Assert.assertEquals(findTargetElementIndex(nums,target),5);
    }
    @Test
    public void test3(){
        int[] nums={4,5,6,0,1,2,3};
        int target=4;
        Assert.assertEquals(findTargetElementIndex(nums,target),0);
    }
    @Test
    public void test4(){
        int[] nums={4,5,6,9,1,2,3};
        int target=11;
        Assert.assertEquals(findTargetElementIndex(nums,target),-1);
    }


    /*
    Solution:-
    - Initialize variables low=0, high=length-1
    - as long as the low doesn't crosses right
            - calculate mid
            - if the number at mid matches target return mid
            - else if the number at mid >= target and <=low then set  high as mid-1;
            - else low= mid+1
     - return -1

     */

    // Time complexity- O(logn)
    //space complexity- O(1)
    private int findTargetElementIndex(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (nums[mid]==target) return mid;
            else if(target<=nums[mid] && target>=nums[low]) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }

}
