package week5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseKElements {

    /*
    Given an integer array, reverse first k elements
    example:- int[] nums={2,4,6,8,10} k=3
    output={6,4,2,8,10}
     */

    /*
    Solution:-
    - Initialize a stack of integer type
    - Initialize an ArrayDeque (queue) of integer type
    - Iterate the array until k and add elements to the stack
    - traverse the stack and pop the elements into queue
    - traverse through the array from k until the end of the array
    - offer the elements into queue

     */
    @Test
    public void test1(){
        int[] nums={2,4,6,8,10};
        int[] output={6,4,2,8,10};
        int k=3;
        Assert.assertArrayEquals(reverseKElements(nums,k),output);

    }

    //Time complexity- O(n)
    //Space complexity- O(n)
    private int[] reverseKElements(int[] nums, int k) {
        Stack<Integer>stack=new Stack<>();
        ArrayDeque<Integer>queue=new ArrayDeque<>();
        for (int i=0;i<k;i++){
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }
        for (int i=k;i<nums.length;i++){
            queue.offer(nums[i]);
        }

       for (int i=0;i<nums.length;i++){
           nums[i]=queue.poll();
       }
        return nums;
    }



}
