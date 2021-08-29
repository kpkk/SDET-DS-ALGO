package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class p1_TwoSum {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     */
    /*
    Input- int array
    output- int array
    constraint- solve within O(n2)
    test data:- [5,8,3,2,3,2,6,] target=  {2,3} {3,2}

    Questions:-
    1. what should i return when the target doesn't present
    2. I shouldn't add the same number twice and return the index? is that understanding correct
    3. what if there are multiple matches?
    4. can it have negative numbers? why  not
    5. what if its an empty array? return -1,-1 (or) throw an exception

     */
    @Test
    public void test1(){
        int[] nums={2,7,11,15};
        int target=9;
        Assert.assertArrayEquals(twoSumOptimized(nums,target),new int[]{0,1});
    }
    @Test
    public void test2(){
        int[] nums={2,7,11,15,7,2};
        int target=9;
        Assert.assertArrayEquals(twoSumOptimized(nums,target),new int[]{0,1});
    }
    @Test
    public void test3(){
        int[] nums={5,2,3,5,6};
        int target=5;
        Assert.assertArrayEquals(twoSumOptimized(nums,target),new int[]{1,2});
    }
    @Test
    public void test4(){
        int[] nums={5,2,3,5,6};
        int target=50;
        Assert.assertArrayEquals(twoSumOptimized(nums,target),new int[]{-1,-1});
    }

    /*
    - Initialize a variable called diff to hold the diff between target and curent number
    - start traversing the array, from start index until end-1
    - start inner loop from one posyion after and see if the value is equal to diff
        - if yes return new int[]{i,j}
    - else return new int[] {-1,-1}
     */
    //TC- O(n2)
    //space- O(1)
    private int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length-1;i++){
            int diff=target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==diff) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }

    /*
    - Initialize a hashmap and of integer key and value
    - iterate the array from left to right
    - calculate the diff=target-nums[i]
    - if diff present in map return the index of that diff and current index
    - else store the num[i], i in the map
     */
    private int[] twoSumOptimized(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }else {
                map.put(nums[i],i);
            }
        }

        return new int[]{-1,-1};
    }
}
