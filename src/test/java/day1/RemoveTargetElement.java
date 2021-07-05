package day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveTargetElement {

    /*

    int[] nums={2,3,5,4,5};
    int target=5;

    Pseudo code:-
    1.convert the array into list
    2. iterate through the list
    3. check if the value is equal to target, then remove it
    4. convert the list into array then return the array
     */

    //	{2,3,4,5,6}
//	target = 5
//	{2,3,4,6}
//
//	{2,3,4,5,5,6}
//	target = 5
//	{2,3,4,6}
    // Remove target element from the given array


    @Test
    public void test1() {
        int[] input = {2, 3, 4, 5, 6};
        int target = 5;

        Assert.assertArrayEquals(removeTargetElement(input, target), new int[]{2, 3, 4, 6});
    }

    @Test
    public void test2() {
        int[] input = {2, 3, 4, 5, 5, 6};
        int target = 5;

        Assert.assertArrayEquals(removeTargetElement(input, target), new int[]{2, 3, 4, 6});
    }

    @Test
    public void test3() {
        int[] input = {2, 3, 4, 6};
        int target = 5;
        Assert.assertArrayEquals(removeTargetElement(input, target), input);
    }

    @Test
    public void test4() {
        int[] input = {6, 6, 6, 6};
        int target = 6;
        Assert.assertArrayEquals(removeTargetElement(input, target), new int[]{});
    }

    // PSeudocode
    /*

    1. Iterate through the array
    2. check the count of occurrence of the given target
    3. create a new array of length input.length-count
    4. itrate through the array again and add the value to the new array if the value doesn't match with target
    5. return the array
     */


    // Create a array list
    // Iterate the input array
    // If current element in the array not matches the target
    //  Ad
    // from Kishore to everyone in this breakout session:    12:32  PM
    // PSeudocode
    // Create a array list
    // Iterate the input array
    // If current element in the array not matches the target
    //  Add to the list
    // Create a new array and push the items in list to new array
    // Return the created array
    private int[] removeTargetElement(int[] input, int target) {

        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == target) count++;
        }
        if (count == 0) return input;

        int[] nums = new int[input.length - count];
        count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != target) {
                nums[count++] = input[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    /*
    Pseudo code:-
    1. initialize two pointers called i=0 and j=0
    2. Then iterate the array from left to right both i, j starting at 0 index
    3. if the element at the current index is equal to the target then swap the number and increment both i,j
    4. if the element at index is not the target then move one of the pointers j
    5. then copy the 

     */

    @Test
    public void test5() {
        int[] input = {2, 3, 4, 5, 5, 6};
        int target = 5;

        Assert.assertArrayEquals(removetarget(input, target), new int[]{2, 3, 4, 6});
    }
    @Test
    public void test6() {
        int[] input = {5,5,5};
        int target = 5;

        Assert.assertArrayEquals(removetarget(input, target), new int[]{2, 3, 4, 6});
    }


    // Time complexity- O[N]
    //space complexity- O[N]
    public int[] removetarget(int[] nums, int target) {
        int index = 0; //o[1]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                int temp = nums[i]; //o[1]
                nums[i] = nums[index];
                nums[index++] = temp;

            }
        }
        System.out.println(Arrays.toString(nums));
        return Arrays.copyOfRange(nums, 0,index); //O[N]

    }
}
