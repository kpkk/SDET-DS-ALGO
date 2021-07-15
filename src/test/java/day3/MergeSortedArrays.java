package day3;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortedArrays {

    /*

    P1) Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 
Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? two sorted integer arrays
        What is the expected output? integer array
        Do I’ve constraints to solve the problem? use two pointer
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
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m=3, n=3;
        int[] output = {1, 2, 2, 3, 5, 6};
        int[] ints = mergeArraysOptimized(nums1, nums2,m,n);
        System.out.println(Arrays.toString(ints));

    }
    @Test
    public void test2() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int[] output = {1};
        int m=0,n=1;
        int[] ints = mergeArraysOptimized(nums1, nums2,m,n);
        System.out.println(Arrays.toString(ints));

    }
    @Test
    public void test3() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,2,2};
        int[] output = {1,2,2,2,2,3};
        int m=3,n=3;
        int[] ints = mergeArraysOptimized(nums1, nums2,m,n);
        System.out.println(Arrays.toString(ints));

    }




    /*
    Solution:-
    1. Initialize variables p1=0, p2=nums1.length, index=0, temp=0
    2. If the length of nums1 is 0 the return nums2
    3. traverse the array from mid index until the end and copy the nums2 elements into nums1
    4. while p1<p2 check if
            - nums1[p1]<nums1[p2]--> dont swap just do p1++, p2--
            - nums1[p1]>nums1[p2]--> swap the values then p1++, p2--
    5. return the nums1
     */

    // Time complexity- O(n)
    //Space complexity- O(1)
    private int[] mergeArraysTwoPointer(int[] nums1, int[] nums2) {
        if (nums1.length==0) return nums2;
        int index = 0;
        for (int i = nums1.length/2; i < nums1.length; i++) {
            nums1[i] = nums2[index++];
        }
        int p1 = 0, p2 = nums1.length - 1;
        while (p1 < p2) {
            if (nums1[p1] <nums1[p2]) {
                p1++;
                p2--;
            } else if (nums1[p1] > nums1[p2]) {
                int temp = nums1[p1];
                nums1[p1] = nums1[p2];
                nums1[p2] = temp;
                p1++;
                p2--;
            }

        }
        return nums1;
    }

    /*
    Solution:-
    1. initialize a variable index =m+n-1
    2. While (m>0 and n>0)
    3. compare the numbers on nums1[m] and nums2[n]
            -If nums1[m] is greater than nums[n]--> replace the nums1[index] with nums1[m] decrement m, index
            -If nums1[m] is lesser than nums[n]--> replace the nums1[index] with nums2[n] decrement n, index
     4.while m>=0 set the nums[index] with nums1[m]
     5. If n>=0 set the nums[index] with nums2[n]
     6. return the array
     */


    private int[] mergeArraysOptimized(int[] nums1, int nums2[], int m, int n){

        int index=m+n-1;
        m--; n--;
        while (m>=0 && n>=0){
            if(nums1[m]>nums2[n]) nums1[index--]=nums1[m--];
            else nums1[index--]=nums2[n--];
        }
        while (m>=0){
            nums1[index--]=nums1[m--];
        }
        while (n>=0){
            nums1[index--]=nums2[n--];
        }
        return nums1;
    }
}
