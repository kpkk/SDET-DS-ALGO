package day5;

import org.junit.Assert;
import org.junit.Test;

public class FindKthMissingEleBinarySearch {

    /*
    P2) Given an array arr of positive integers sorted in a strictly increasing order, and an integer k. Find the kth positive integer that is missing from this array.
 
Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

     */

    /*

    1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? --> integer array, target
        What is the expected output? --> integer
        Do I’ve constraints to solve the problem? - binary search
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
        int[] nums={2,3,4,7,11};
        int k=5;
        Assert.assertEquals(findMissingNumberusingBinarySearch(nums,k),9);
    }
    @Test
    public void test2(){
        int[] nums={1,2,3,4};
        int k=2;
        Assert.assertEquals(findMissingNumberusingBinarySearch(nums,k),6);
    }

    /*

    Solution
    - Initialize low=0, high=nums.length
    - as long as low is less than or equals to high
        - calculate mid
        - If the difference of nums[mid] and (mid)-1 is less than k
            - low=mid+1
         - else high=mid-1
     - return high+k+1
     */

    private int findMissingNumberusingBinarySearch(int[] nums, int k) {
        int low=0, high=nums.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if((nums[mid]-mid)-1<k)low=mid+1;
            else high=mid-1;
        }
        return high+k+1;
    }
}
