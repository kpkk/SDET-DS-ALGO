package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxLeaps {
    /*


     */
    @Test
    public void test1(){
        int[]nums={6,13,10,8,11,7,3,5,2};
        Assert.assertEquals(maxFrogJumps(nums),5);
    }
    @Test
    public void test2(){
        int[]nums={6,4,5,4,3,2,1};
        Assert.assertEquals(maxFrogJumps(nums),5);
    }
    @Test
    public void test3() {
        int[] nums = {5,7,11,9,10,7,6,3,5,2,1};
        System.out.println(maxFrogJumps(nums));
    }

    /*
    Solution:-
    - initialize variables jump=0, max=nums[0]
    - iterate the input array from starting index 0
    - iterate the array from index 1 (inner loop)
    - compare the value at index i and j
    - if j is less than i, then increment jump and update the current max
    - return the jump

     */

    private int findMaxLeaps(int[] nums) {
        int jumpCount=0, currentNumber=0, startNumber=0;
        for (int i=0;i<nums.length-1;i++){
            int tempJumCount=0;
            startNumber=nums[i];
            currentNumber=nums[i];
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]<currentNumber) {
                    tempJumCount++;
                    currentNumber = nums[j];
                }

                }
            jumpCount=Math.max(jumpCount,tempJumCount);
            }

        return jumpCount;
    }

    public static int maxFrogJumps(int[] nums){

        int[] data = new int[nums.length];
        Arrays.fill(data, 0);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j])
                    data[i] = Math.max(data[i], data[j]+1);
            }
        }

        int maxJumps = 0;
        for (int each : data) {
            maxJumps = Math.max(maxJumps, each);
        }

        return maxJumps;
    }
}

/*
 if(currentNumber<=nums[j+1] && nums[j+1]<startNumber){
                        jumpCount--;
                        currentNumber=nums[j+1];
                        jumpCount++;
                    }else break;
 */