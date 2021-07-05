package day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class findUniqueoccurrences {

    /*

    5) Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true

Problem solving template

1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        What is the expected output?
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
    public void test1(){
        int[] nums={1,2,2,3,3,3};
        boolean result= true;
       Assert.assertTrue( checkUniqueOccurrence(nums));
    }
    @Test
    public void test2(){
        int[] nums={1,2,2,3,3,3,4,1};
        boolean result= false;
        Assert.assertFalse(checkUniqueOccurrence(nums));
    }
    @Test
    public void test3(){
        int[] nums={2,2,2,2};
        boolean result= false;
        Assert.assertTrue(checkUniqueOccurrence(nums));
    }
    public boolean checkUniqueOccurrence(int[] nums){
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(map.get(nums[i]),0)+1);
        }
        if(map.size()==1)
            return true;
       return map.size() == new HashSet<Integer>(map.values()).size();
    }
}
