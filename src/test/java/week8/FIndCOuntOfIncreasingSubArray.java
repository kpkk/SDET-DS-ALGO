package week8;

import org.junit.Assert;
import org.junit.Test;

public class FIndCOuntOfIncreasingSubArray {
    /*
    Question 1:
Count the number of strictly increasing subarray of a specified size k in an array of size N .
Example 1:
int[] nums = [ 5,3,5,7,8] and k=3 ,
The answer is 2 as [3,5,7] and [5,7,8] are the sub arrays.
Example 2:
int[] nums = [ 5,3,5,7,8] and k=2 ,
The answer is 3 as [3,5] and [5,7] and [7,8] are the sub arrays.
     */

    /*
    Input- integer array
    Output- integer
    constraints- time box, used optimized technique
    test data

     */
    @Test
    public void test1(){
        int[] nums={5,3,5,7,8};
        int k=3;
        Assert.assertEquals(findSubArray(nums,k),2);
    }
    @Test
    public void test2(){
        int[] nums={5,3,5,7,8};
        int k=2;
        Assert.assertEquals(findSubArray(nums,k),3);
    }
    @Test
    public void test3(){
        int[] nums={5,4,3,2,1};
        int k=2;
        Assert.assertEquals(findSubArray(nums,k),0);
    }
    @Test
    public void test4(){
        int[] nums={1,2,3,4};
        int k=6;
        Assert.assertEquals(findSubArray(nums,k),0);
    }
    @Test
    public void test5(){
        int[] nums={1,2,3,4,2,1,3}; //7-2+1//6
        int k=2;
        Assert.assertEquals(findSubArray(nums,k),4);
    }
    @Test
    public void test6(){
        int[] nums={1,2,3,3,4,5}; //7-2+1//6
        int k=3;
        Assert.assertEquals(findSubArraySinglePass(nums,k),2);
    }
    /*
    Approach: two pointer equi-directional, sliding window
    Solution:-
    -  initialize two pointers left=0, right=left+k-1, subArraycount=0
    - while right less than length of the array
    - compare  if left+1 is greater than left
        - if yes, increment left
        - else, left++, right++
        - if left== right increment count
     - return count

     */

    // Time complexity - O(n*m)
    // space complexity- O(1)
    private int findSubArray(int[] nums, int k) {
        int left=0, right=left+k-1, subArrayCount=0;
        if(k==1) return nums.length;
        while (right<nums.length){
            int counter=1, index=left;
            while (nums[index]<nums[index+1]){
                index++;
                counter++;
                if(counter==k){
                    subArrayCount++;
                    break;
                }
            }
            left++;
            right++;
        }
        return subArrayCount;
    }

    /*
    - if k is higher then length return 0
    - if k=1, then return nums.length
    - initialize variables counter=1, result=0
    - iterate the array from index 1 until the length
    - if the value at prev index an current index are same then--> counter++
    - else, check if the counter is greater than k
        - if yes, add the counter-(k-1) to the result, set the counter=1
    - if counter not equals to 1  the add the result with counter-(k-1)
    - return result
     */
    // Time complexity - O(n)
    // space complexity- O(1)
    private int findSubArraySinglePass(int[] nums, int k){
        if(k>nums.length) return 0;
        if(k==1) return nums.length;
        int counter=1, result=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]) counter++;
            else{
                if(counter>=k){
                    result+=counter-(k-1);
                    counter=1;
                }
            }
        }

       if(counter!=1) result+=counter-(k-1);
        return result;
    }
}

