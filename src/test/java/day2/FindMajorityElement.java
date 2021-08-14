package day2;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class FindMajorityElement {

    /*

    2) Given an array nums of size n, return the majority element. ou may assume that the majority element always exists in the array.The majority element is the element that appears more than ⌊n / 2⌋ times.


1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? --> Integer array of size n
        What is the expected output?  --> integer
        Do I’ve constraints to solve the problem?  --> single pass
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
        int[] nums = {1, 2, 2, 2};
        Integer n = 2;
      //  Assert.assertEquals(findMajorityEle(nums), n);
      //  Assert.assertEquals(findMajorityEleSinglePass(nums), 2);
       // Assert.assertEquals(bruteForce(nums), 2);
        Assert.assertEquals(majorityElementBoyreMooreVoting(nums), 2);

    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 4, 4, 4, 4};
        Integer n = 4;
        //Assert.assertEquals(findMajorityEle(nums), n);
      //  Assert.assertEquals(findMajorityEleSinglePass(nums), 4);
      //  Assert.assertEquals(bruteForce(nums), 4);
        Assert.assertEquals(majorityElementBoyreMooreVoting(nums), 4);
    }

    @Test
    public void test3() {
        int[] nums = {1,1, 4, 4};
        Integer n = 4;
     //   Assert.assertEquals(findMajorityEle(nums), n);
      //  Assert.assertEquals(findMajorityEleSinglePass(nums), 4);
       // Assert.assertEquals(bruteForce(nums), 4);
        Assert.assertEquals(majorityElementBoyreMooreVoting(nums), 4);
    }

    @Test
    public void test4() {
        int[] nums = {};
        Integer n = 2;
       // Assert.assertEquals(findMajorityEle(nums), n);
       // Assert.assertEquals(findMajorityEleSinglePass(nums), 0);
       // Assert.assertEquals(bruteForce(nums), 2);
        Assert.assertEquals(majorityEleusingMidValue(nums), 2);
    }

    /*
    Pseudo code:-
    1. Initialize the hashmap and add all the array elements (key) and occurrences (values)
    2. iterate the entry set and get the value of each key
    3. If the value  of a specific key is more than n/2 return true, else false
     */

    // Time complexity- O(n)
    //space complexity- O(n)
    public Integer findMajorityEle(int[] nums) {
        if (nums.length == 0) throw new RuntimeException("empty array");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
      //  Integer max = Collections.max(map.values());
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            Integer value = (Integer) entry.getValue();
            if (value > nums.length >> 1) {
                return (Integer) entry.getKey();
            }
        }

        return 0;
    }

    // Time complexity- O(n)
    //Space Complexity- O(n)
    private int findMajorityEleSinglePass(int[] nums) {
        if (nums.length == 0) throw new RuntimeException("empty array given");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > (nums.length) / 2) {
                return nums[i];
            }
        }
        return 0;
    }


    private int bruteForce(int[] nums) {
        int max = 0, count = 0, majorityele = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                majorityele = nums[i];
            }
        }
        if (max > (nums.length) / 2) {
            return majorityele;
        }
        return 0;
    }

    //{1,2,2,2} --> 2, >n/2
    //{1,2,2}-->3
    // time complexity- O(n)
    // space complexity - O(1)
    private int majorityEleusingMidValue(int nums[]){
        Arrays.sort(nums);
        int mid=nums.length/2;
        if (nums.length %2 ==1){
            return nums[mid];
        }
        else {
            if(nums[mid]==nums[mid-1])
                return nums[mid];

        }
        throw new RuntimeException("invalid input");
    }

    /*
    Approach: Boyre moore voting algorithm
    - Initialize variables majorityEle and counter=0
    - Assign the first element in the array to majorityEle
    - traverse through the array from the index 1
    - check if the current index number is equal to majorityEle
        - if yes increase the counter
        - else decrease the counter
     - check if the counter is zero change the majorityEle as that particular index ele
     */
    private int majorityElementBoyreMooreVoting(int[] nums) {
        int majorityEle=nums[0],counter=1;
        for (int i=1;i<nums.length;i++){
            if (counter==0) majorityEle=nums[i];
            if(nums[i]==majorityEle)counter++;
            else counter--;

        }return majorityEle;
    }
}
