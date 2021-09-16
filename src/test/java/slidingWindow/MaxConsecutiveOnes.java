package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnes {
    /*
    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
     */

    @Test
    public void test1(){
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        Assert.assertEquals(findMaxOnes(nums,k),6);
    }
    @Test
    public void test2(){
        int[] nums={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        Assert.assertEquals(findMaxOnes(nums,k),10);
    }

    /*
    - Brute force
    - iterate the array from start index until the end (outer loop)
    - iterate the array from the ith index and traverse until the end (inner loop)
    - initialize variables, zeroCounter=0, maxOnes=0
    - keep computing the maxOnes and consider the maxOnes until we meet the k number of zeroes
    - if number of zeroes goes beyond k then break the loop
    - repeat the above steps for all indices in outer loop
    - return the maxOnes
     */
    private int findMaxOnesBruteForce(int[] nums, int k) {
       int maxOnes=0;
        for (int i=0;i< nums.length;i++){
            int zeroCount=0;
            for (int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    zeroCount++;
                }
                if(zeroCount>k) break;
                maxOnes=Math.max(maxOnes,j-i+1);

            }
        }
        return maxOnes;
    }
    private int findMaxOnes(int[] nums, int k) {
       int zeroCount=0, maxOnes=0;
       int left=0, right=0;
       while(right<nums.length){
           if(nums[right]==0){
               zeroCount++;
           }
           while (zeroCount>k){
               if(nums[left]==0){
                   zeroCount--;
               }
               left++;
           }
           maxOnes=Math.max(maxOnes,right-left+1);
           right++;
       }
       String s="";
       s.lastIndexOf('a');
       return maxOnes;
    }
}
