package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CountElements {

    /*
    Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them separately.

Example 1:
Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:
Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:
Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:
Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.
Example 5:
Input: arr = [1,1,2]
Output: 2
Explanation: Both 1s are counted because 2 is in the array.

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? -->integer array
        What is the expected output? -->integer
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
        int[] arr = {1, 2, 3};
        int output = 2;
        Assert.assertEquals(countElements(arr),output);
     //   Assert.assertEquals(countEleBruteForce(arr),output);

    }

    @Test
    public void test2() {
        int[] arr = {1, 1, 3, 3, 5, 5, 7, 7};
        int output = 0;
        Assert.assertEquals(countElements(arr),output);
      //  Assert.assertEquals(countEleBruteForce(arr),output);
    }
    @Test
    public void test3() {
        int[] arr = { 1,3,2,3,5,0}; //0,1,2,3,4,5
        int output = 3;
        Assert.assertEquals(countElements(arr),output);
      //  Assert.assertEquals(countEleBruteForce(arr),output);
    }
    @Test
    public void test4() {
        int[] arr = { 1,1,2,2};
        int output = 2;
        Assert.assertEquals(countElements(arr),output);
        //Assert.assertEquals(countEleBruteForce(arr),output);
    }
    @Test
    public void test5() {
        int[] arr = { 1,1,2};
        int output = 2;
        Assert.assertEquals(countElements(arr),output);
        Assert.assertEquals(countEleBruteForce(arr),output);
    }
    @Test
    public void test6() {
        int[] arr = { 1,3,2,3,5,0,4}; //0,1,2,3,4,5
        int output = 5;
        Assert.assertEquals(countElements(arr),output);
        //  Assert.assertEquals(countEleBruteForce(arr),output);
    }

    /*

    Pseudo code:-
    1. sort the array
    1. iterate the loop from the start to the end
    2. iterate another inner loop from one position after for comparision
    3. if(nums[j]-nums[i]==1) then increment the count
    4. return the count

     */

    public int countEleBruteForce(int[] nums){
        Arrays.sort(nums);
        int count=0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]-nums[i]==1) count++;
            }
        }
        return count;
    }
    /*

    Pseudo code:-
    1. push all the array elements into a list
    2. then iterate the loop from start to the end
    3. Check if the current number+1 is exists in the list or not, if yes increment count
    4. return count
     */

    // Time  complexity- O(n)
    //space complexity - O(n)
    public int countElements(int[] nums) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
       /* for (int eachInt: list){
            if (eachInt)
        }*/
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
        //  if(i>0 && nums[i]==nums[i-1])continue;
            if (list.contains(nums[i] + 1)) count++;
        }
        return count;
    }


}
