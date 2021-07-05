package day2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSumProblemOptimized {

    /*

    Two sum Problem, return the indices of the elements that sums up to the target
    Problem solving template

1. Did I understand the problem? -->yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? --> Integer array
        What is the expected output? --> int [] array of indices
        Do I’ve constraints to solve the problem? - use single pass and map
        Do Ive all the information to go to the next steps yes
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? use hashmap using single pass/ double pass
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

    //+ve
    @Test
    public void test(){
        int [] nums={1,4,2,8,2 ,6};
        int k=10;
        int[] ints = twoSumSinglePass(nums, k);
        System.out.println(Arrays.toString(ints));
    }
    //-ve
    @Test
    public void test1(){
        int [] nums={1,4,2,8,2,6};
        int k=110;
        int g=110;
        int[] ints = twoSumSinglePass(nums, k);
        System.out.println(Arrays.toString(ints));

    }

    @Test
    public void test2(){
        int [] nums={1,2,3,2,3,8};
        int k=10;
        int[] ints = twoSumSinglePass(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    /*
    1. Initialize the hashmap with integer as key and value
    2. iterate the array from left to right
    3. get the diffence at every index then check if the map contains that difference
    4. if present then return the value of the key and index i as array
    5. else put that entry into map
    6. if no match found after iterated the whole array, return the arary {-1,-1}

     */
   public int[] twoSumSinglePass(int [] nums, int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i=0; i<nums.length;i++){
            int diff=target-nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff),i};
            else
                map.put(nums[i],i);
        }
        return new int[]{-1,-1};

   }

}
