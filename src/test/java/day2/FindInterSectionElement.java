package day2;

import org.junit.Test;

import java.util.HashSet;

public class FindInterSectionElement {

    /*
    3) Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Problem solving template

1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? - two input arrays
        What is the expected output? - integer array
        Do I’ve constraints to solve the problem?
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
    public void test1() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Integer[] output = findInterSection(nums1, nums2);
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {3, 4, 5, 6};
        Integer[] output = findInterSection(nums1, nums2);
    }

        private Integer[] findInterSection (int[] nums1, int[] nums2){
            HashSet<Integer>set=new HashSet<>();
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if (nums1[i]==nums2[j]){
                    set.add(nums2[j]);
                }
            }
        }
            System.out.println(set);
        Integer[] arr=new Integer[set.size()];
        return set.toArray(arr);
        }

}
