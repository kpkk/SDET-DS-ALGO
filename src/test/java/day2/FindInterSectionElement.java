package day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FindInterSectionElement {

    /*
    3) Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Problem solving template

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? - two input arrays
        What is the expected output? - integer array without duplicates
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
        Integer[] integers = intersectionArr(nums1, nums2);
        Assert.assertEquals(integers,new Integer[]{2});
        System.out.println(Arrays.toString(integers));
        //  Integer[] output = findInterSection(nums1, nums2);
        //  Assert.assertEquals(output,new Integer[]{2});
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 2, 2, 1, 3, 4, 3};
        int[] nums2 = {2, 2, 3, 6, 4};
      //  Integer[] output = findInterSection(nums1, nums2);
      //  Assert.assertEquals(output, new Integer[]{2, 3, 4});
        Integer[] integers = intersectionArr(nums1, nums2);
        Assert.assertEquals(integers,new Integer[]{2,3,4});
        System.out.println(Arrays.toString(integers));
    }

    @Test
    public void test5() {
        int[] nums1 = {};
        int[] nums2 = {};
        Integer[] integers = intersectionArr(nums1, nums2);
        Assert.assertEquals(integers,new Integer[]{});
        System.out.println(Arrays.toString(integers));
        //  Integer[] output = findInterSection(nums1, nums2);
        //  Assert.assertEquals(output,new Integer[]{2});
    }

    /*

    Pseudo code:-
    1. Initialize a hashset to hold the intersection elements
    2. iterate the two arrays using two for loops
    3. if the number at a specified index is equal in both the arrays add to the set
    4. Convert the set into an integer array and return the same

     */
    @Test
    public void test3() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {3, 4, 5, 6};
        Integer[] output = findInterSection(nums1, nums2);
        Assert.assertEquals(output, new Integer[]{});
    }

    @Test
    public void test4() {
        int[] nums1 = {14, 8, 3};
        int[] nums2 = {8, 14, 8, 12, 6};
        Integer[] output = findInterSection(nums1, nums2);
        Assert.assertEquals(output, new Integer[]{8, 14});
    }

    // Time complexity- O(n^2)
    // Space complexity- O(n)
    private Integer[] findInterSection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
      //  int[] i1 = nums1.length < nums2.length ? nums1: nums2;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums2[j]);
                    break;
                }
            }
        }
        System.out.println(set);
        Integer[] arr = new Integer[set.size()];
        return set.toArray(arr);
    }


    /*
    Solution:
    1. Sort the given two arrays
    2. Initialize a hashset to store the common elements
    3. Initialize two pointers to traverse in both the arrays (equi-directional)
    4. if (nums1[p1]==nums2[p2]) then add the nums[p1] to set
          if (nums1[p1]<nums2[p2]) increment p1
          if (nums1[p1]>nums2[p2]) increment p2
    5. Convert the set into an integer array then return

     */

    //Time complexity- O(n)
    //space complexity- O(n)
    private Integer[] intersectionArr(int[] nums1, int[] nums2) {
        if (nums1.length==0 && nums2.length==0) return new Integer[]{};

        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
               set.add(nums1[p1]);
                p1++;
                p2++;

            } else if(nums1[p1] < nums2[p2]) {
                p1++;
            }
                else{
                    p2++;
                }
            }
        Integer [] arr=new Integer[set.size()];
        return set.toArray(arr);

        }


        @Test
        public void test(){
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
            int[] intersect = intersect(nums1, nums2);
            System.out.println(Arrays.toString(intersect));
        }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0, p2=0, index=0;
      //  if(nums1.length==0 && nums2.length==0) return new int[]{-1,-1};
        if(nums1.length==0 || nums2.length==0) return new int[]{-1,-1};

        int minLength= nums1.length<nums2.length?nums1.length:nums2.length;
        int [] intersectionArray=new int[minLength];
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]<nums2[p2]) p1++;
            else if(nums1[p1]>nums2[p2]) p2++;
            else if(nums1[p1]==nums2[p2]){
                intersectionArray[index++]=nums1[p1];
                p1++;
                p2++;
            }
        }
        return Arrays.copyOfRange(intersectionArray,0,index);

    }

    }


