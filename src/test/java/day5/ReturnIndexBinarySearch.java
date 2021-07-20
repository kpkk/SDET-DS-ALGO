package day5;

import org.junit.Assert;
import org.junit.Test;

public class ReturnIndexBinarySearch {
    /*

    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:
Input: nums = [1,3,5,6], target = 0
Output: 0

     */

    /*

    1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? --> integer array, target
        What is the expected output? --> integer
        Do I’ve constraints to solve the problem? --> solve using binary search
        Do Ive all the information to go to the next steps
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
        int[]nums={1,3,5,6};
        int k=5;
        Assert.assertEquals(findIndexUsingBinarySearch(nums,k),2);
    }
    @Test
    public void test2(){
        int[]nums={1,3,5,6};
        int k=7;
        Assert.assertEquals(findIndexUsingBinarySearch(nums,k),4);
    }

    @Test
    public void test3(){
        int[]nums={1,4,11,12};
        int k=10;
        Assert.assertEquals(findIndexUsingBinarySearch(nums,k),2);
    }

    /*

    Approach: Binary solution
    Time complexity- O(logn)
    Space complexity- O(1)

    Solution:-
    - Initialize variables low=0, high=length-1
    - As long as low is less than high
        - calculate mid value
        - if mid value matches the target return mid
        - else if mid less than target low=mid+1
        - else high=mid-1
     - return low

     */
    private int findIndexUsingBinarySearch(int[] nums, int k) {

        int low=0, high=nums.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==k) return mid;
            else if(nums[mid]>k) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}
