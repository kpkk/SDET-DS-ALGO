package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class MeasureIncrementInDailyTemperatures {

    /*
     Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
     */
    @Test
    public void test1(){
        int[] temp={73,74,75,71,69,72,76,73};
        Assert.assertArrayEquals(findIncreaseInTemerature(temp),new int[]{1,1,4,2,1,1,0,0});
    }
    @Test
    public void test2(){
        int[] temp={30,40,50,60};
        Assert.assertArrayEquals(findIncreaseInTemerature(temp),new int[]{1,1,1,0});
    }
    @Test
    public void test3(){
        int[] temp={30,60,90};
        Assert.assertArrayEquals(findIncreaseInTemerature(temp),new int[]{1,1,0});
    }

    /*
    Input:- integer array
    Output:- integer array
    Constraints: solve using stack
    Solution:-
    - Initialize a stack of integer type
    - Initialize an integer array of input length
    - Iterate the array from start till the end
    - check if the stack is not empty and current number is greater than stack.peek
        - if yes pop the number from the stack
        - subtract from i and add that into the array and move array index
    - else push the number into the stack
    - return the output array

     */
    //Time complexity - O(n)
    //Space complexity- O(n)
    private int[] findIncreaseInTemerature(int[] temp) {
        Stack<Integer>stack=new Stack<>();
        int[] output=new int[temp.length];
        for (int i=0;i<temp.length;i++){
            while (!stack.isEmpty() && temp[i]>temp[stack.peek()]){
                Integer pop = stack.pop();
                output[pop]=i-pop;
            }
            stack.push(i);
        }
        return output;
    }
}
