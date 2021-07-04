package day1;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import org.junit.Assert;
import org.junit.Test;

public class FindTheHighestValue {

    /*
    Find the highest integer value in the given integer array


1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? --> Integer Array
        What is the expected output? --> integer
        Do I’ve constraints to solve the problem? do not sort the array
        Do Ive all the information to go to the next steps---> yes
               - if there are more occurrences maximum values, return the first one
               - if the array is empty make sure to throw a runtime exception

        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        int [] = {1,2,56,78,13, 5};
        int []={} // throw exception
        int[]={1,5,5,4,3,5};
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? yes, may be solve using map
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

    /*

    Pseudo code:-
    1. initialize the variable called max with minimum value in integer range
    2. Then iterate the array from left to right
    3. Compare the max value with the current value and update the max value if it is greater
    4. after iterating the whole length then return the max value
     */

    @Test
    public void test1(){
        int []nums={1,2,35,4,5,13,78,6};
        Assert.assertEquals(findHighestNumber(nums),78);
    }
    @Test
    public void test2(){
        int []nums={};
        Assert.assertEquals(findHighestNumber(nums), 0);
    }
    @Test
    public void test3(){
        int []nums={11,8,2,11,7,8};
        Assert.assertEquals(findHighestNumber(nums),11);
    }

    private int findHighestNumber(int[] nums) {
        if (nums.length==0)
            throw new RuntimeException("empty array given , no max element");
        int max=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        return max;
    }
}
