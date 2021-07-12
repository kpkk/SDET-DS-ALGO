package day3;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindClosestSum {
    /*

    Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.

Example 1:
Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
Example 2:
Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? integer array
        What is the expected output? integer
        Do I’ve constraints to solve the problem? yes, binary search
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
8. Start always with the Pseudo code
9. Test against different test data
10. If it fails then debug to solve it

     */

    @Test
    public void test1(){
        int[] nums={34,23,1,24,75,33,54,8};
        int k=60;
        int sum=58;
        int i = closestSum(nums, k);
        System.out.println(i);
    }
    @Test
    public void test2(){
        int[] nums={10,20,30};
        int k=15;
        int sum=-1;
        int i = closestSum(nums, k);
        System.out.println(i);
    }

    /*
    1. Initialize two pointers i=0, j=1 and max=0
    2. Traverse the array from start till the end i
    3. Another inner loop from j till the end
    4. sum values of i and j
    5. check if the sum is greater than 60, if yes continue
    6. if the sum is less than 60 then find the max value and return
    7. if no value closest to found thenn return -1
     */

    // Time complexity- O(n^2)
    // space complexity- O(1)

    private int closestSumbruteForce(int[]nums,int k){
        int max=0;
        boolean isLoopEntered=false;
        for (int i=0;i<nums.length;i++){
            for (int j=1;j<nums.length;j++){
                if(nums[i]+nums[j]>=k) continue;
                else if(nums[i]+nums[j]<k){
                    max=Math.max(max,nums[i]+nums[j]);
                    isLoopEntered=true;
                }
            }
        }
        return isLoopEntered? max :-1;
    }

    /*
    1. check if the length of the array is <=1, if yes return -1
    2. Intialize pointer variables left=0, right=nums.length-1, max=0, isLoopEntered=false
    3. Sort the array
    4. while left less than or equal to right, sum value at left and right indices
         a. if the sum is >=60 then decrement right
         b. if the sum is <60 then find the max value between previous max and current sum


     */

    // Time complexity- O(n)
    // space complexity- O(1)
    private int closestSum(int[] nums, int k){
        if(nums.length<=1) return -1;
        int max=0;
        boolean isLoopEntered=false;
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        while (left<=right) {
            if (nums[left] + nums[right] < k) {
                max = Math.max(max, nums[left] + nums[right]);
                left++;
                isLoopEntered=true;
            }else if(nums[left] + nums[right] >=k){
                right--;
            }

        }
        return isLoopEntered? max :-1;
    }

    /*

    Solution:
    1. Initialize an int variable max=0
    2.sort the given array
    3. Initialize two pointers low=0, high=nums.length-1
    4. calculate the mid point
        a. if the mid>= target then high=mid-1
        b. if the mid< target then low=mid+1
            - calculate the max value between previous sum and current sum using math.max()
    5. return the sum
     */

    private int closestSumusingBinarySearch(int[] nums,int k){

        int max=0, low=0, high=nums.length-1;
        int mid=(low+high)/2;
        Arrays.sort(nums);
        if(mid>=k){
            high=mid-1;
        }else if(mid<k){
            mid+=1;
        }
        return 0;
    }
}
