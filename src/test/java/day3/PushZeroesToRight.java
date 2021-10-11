package day3;

import org.junit.Assert;
import org.junit.Test;

public class PushZeroesToRight {

    /*

    Given an integer array push all the zeroes to the end
1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? --> integer array
        What is the expected output?--> integer array
        Do I’ve constraints to solve the problem?--> solve using two pointer
        Do Ive all the information to go to the next steps -->yes
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? brute force and two pointer
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
    public void test(){
        int [] nums={1,0,2,0,3,0,4,5};
        int[] output={1,2,3,4,5,0,0,0};
        Assert.assertArrayEquals(moveZeroes(nums),output);
    }
    @Test
    public void test2(){
        int [] nums={0,0,0,0};
        int[] output={0,0,0,0};
        Assert.assertArrayEquals(moveZeroes(nums),output);
    }
    @Test
    public void test3(){
        int [] nums={1,5,34,7,3};
        int[] output={1,5,34,7,3};
        Assert.assertArrayEquals(moveZeroes(nums),output);
    }

    /*

    Solution:
    1. Initialize an array of same length as that of input
    2.
     */
    private int[] moveZeroes(int[] nums){
        int j=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j++]=temp;
            }

        }
        return nums;
    }
}
