package week6;

import org.junit.Assert;
import org.junit.Test;

public class FIndMinSumSubArray {

    /*
    Take an integer array as an input, find the subarray for a k value that has the  minimum sum

Eg : int[] nums={4,6,11,3,0,2}, int k=3
int[] nums={3,5}

Should I return in sorted way?
Will the array contain negative inputs

     */
    @Test
    public void test1(){
        int[] nums={4,6,11,3,0,2};
        int k=3;
        Assert.assertArrayEquals(findSubArray(nums,k),new int[]{3,5});
    }
    @Test(expected = RuntimeException.class)
    public void test2(){
        int[] nums={4,6,11,3,0,2};
        int k=8;
        Assert.assertArrayEquals(findSubArray(nums,k),new int[]{3,5});
    }
    @Test
    public void test3(){
        int[] nums={1,2,3,2,3,1};
        int k=3;
        Assert.assertArrayEquals(findSubArray(nums,k),new int[]{0,2});
    }
    @Test (expected = RuntimeException.class)
    public void test4(){
        int[] nums={};
        int k=3;
        Assert.assertArrayEquals(findSubArray(nums,k),new int[]{0,2});
    }

    /*
    - Initialize a variable minSum=0, currentSum=0
    - traverse the array until k then, add every number to currentSum
    - traverse the array from k until the end
        - remove the i-k value and add k value to the sum
        - check if the current sum is minimum than previous
            - if yes return the i,k indices into array
     */
    private int[] findSubArray(int[] nums, int k) {
        int currentSum=0, minSum=Integer.MAX_VALUE;
        int startIndex=0, endIndex=0;
        for (int i=0;i<k;i++){
            currentSum+=nums[i];
        }
        if (currentSum<minSum){
            minSum=currentSum;
            startIndex=0;
            endIndex=k-1;
        }

        for (int i=k;i<nums.length;i++){
            currentSum=currentSum+nums[i]-nums[i-k];
            if(currentSum<minSum){
                minSum=currentSum;
                startIndex=i-k+1;
                endIndex=i;
            }
        }
        return new int[]{startIndex,endIndex};
    }
}
