package week4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DailyTemperature {

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

    /*
    in class problem, if there is no increment we were asked to display -1
     */
    @Test
    public void test1(){
        int[] temperature={73,74,75,71,69,72,76,73};
        int[] output={1,1,4,2,1,1,-1,0};
        Assert.assertArrayEquals(dailyTempUsingStack(temperature),output);

    }
    @Test
    public void test2(){
        int[] temperature={30,40,50,60};
        int[] output={1,1,1,0};
        Assert.assertArrayEquals(findTemptwoPointer(temperature),output);

    }
    @Test
    public void test3(){
        int[] temperature={30,30,90,90};
        int[] output={2,1,-1,0};
        Assert.assertArrayEquals(findTemptwoPointer(temperature),output);
    }
    @Test
    public void test4(){
        int[] temperature={35,34,33,32,31,30};
        int[] output={-1,-1,-1,-1,-1,0};
        Assert.assertArrayEquals(findTemptwoPointer(temperature),output);
    }


    /*
    Approach:- bruteforce
    - Check if the length of the array is 0, if yes return the empty array
    - if the length of the array is 1, return 0 as there is no element to compare
    - Initialize an integer array of input length size to hold the difference of days
    - Traverse the array from start index=0 until end=length-1 (outer loop)
    - Traverse the same array from one position after the current index (inner loop)
    - compare both i& j
            - if j is greater than i then update output array index with the diffrence of i, j (j-i)
            - if the j is lesser than i, then continue
            - if no match found till the end then update with -1
    - if the element at index i is the last one of the array then update with 0

     */
    private int[] findIncrementInTemp(int[] temperature) {
        if(temperature.length==0) return temperature;
        int[] output=new int[temperature.length];
        for (int i=0;i<temperature.length;i++){
            if(i==temperature.length-1) output[i]=0;
            for (int j=i+1;j<temperature.length;j++){
                if(temperature[i]<temperature[j]){
                    output[i]=j-i;
                    break;
                }
                if(j==temperature.length-1) output[i]=-1;
            }

        }
        return output;
    }

    /*
    Approach:- two pointer
    - Initialize an integer array of input array length
    - Initialize two variables left=0, right=1
    - While the left reaches the length
    - If the left is at the length index then set the value as 0 (as there is no next element to compare)
    - compare the values at left and right
        - if the value at left is less than value at right
        - Assign the value right-left+1, into the array then increment both left and right
        - if the value at right is less than value at left, keep moving
        - check if the right reached length, if so set the value at left as -1 and increment left
        - else increment the right alone
     - return the output array
     */

    private int[] findTemptwoPointer(int[] nums){
        int left=0, right=1;
        int output[]=new int[nums.length];
        while (left<nums.length){
            if(left==nums.length-1){
                output[left]=0;
                break;
            }
            if(nums[left]<nums[right]){
                output[left++]=right-left+1;
                right=left+1;
            }else{
                if(right==nums.length-1) output[left++]=-1;
                else right++;
            }
        }
        return output;
    }

    /*
    Solution:-
    - Initialize a stack of integer type
    - Initialize an integer array of inout array length
    - Traverse the array from starting index (0) till the end (length-1)
    - if the stack is not empty and current number in array is less than the nums[stack.peek]
        - then pop the value and assign the difference of i-popped value into output array
     - return the output array
     */

    private int[] dailyTempUsingStack(int [] nums){

        if(nums.length==0) return nums;
        Stack<Integer>stack=new Stack<>();
        int[] output=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                int pop = stack.pop();
                output[pop]=i-pop;
            }
            stack.push(i);
        }

        return output;
    }
}
