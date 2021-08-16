package week7;

import org.junit.Assert;
import org.junit.Test;

public class KSubArrays {
    /*

    Given an array of integers and k, find the number of subarrays , whose sum is divisible by k
    eg:[5,10,11,9,5] k=5
    sub arrays:- [5],[5,10],[5,10,11,9],[5,10,11,9,5],[10],[10,11,9],[10,11,9,5],[11,9],[11,9,5],[5]
    output=10
     */

    @Test
    public void test1(){
        int[] nums={5,10,11,9,5};
        int k=5;
        Assert.assertEquals(findSubArays(nums,k),10);
    }

    private int findSubArays(int[] nums, int k) {
        int count=0;
        for (int i=0;i<nums.length;i++){
            int sum=nums[i];
            if(nums[i]%k==0) count++;
            for (int j=i+1;j<nums.length;j++){
               sum+=nums[j];
               if(sum%k==0)count++;
            }
        }
        return count;
    }
}
