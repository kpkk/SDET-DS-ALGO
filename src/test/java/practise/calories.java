package practise;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.IconUIResource;

public class calories {
    /*

Example 1:
Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
Output: 0
Explaination: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.

     */

    @Test
    public void test(){
        int[] nums={1,2,3,4,5};
        int k=1, lower=3, upper=3;
        Assert.assertEquals(calories(nums,lower,upper,k),0);
    }
    @Test
    public void test1(){
        int[] nums={3,2};
        int k=2, lower=0, upper=1;
        Assert.assertEquals(calories(nums,lower,upper,k),1);
    }

    private int calories(int[] nums, int lower, int upper, int k){
        int sum=0,  left=0, right=0, calories=0;
        if(k>nums.length) throw new RuntimeException("invalid length");
        for (int i=0;i<k;i++){
            sum+=nums[i];
        }
        if(sum>upper) calories++;
        if(sum<lower)calories--;
        if(nums.length==k) return calories;
      for (int i=1;i<nums.length;i++){
          sum+=nums[i+k-1]-nums[i-1];
          if(sum> upper){
              calories++;
          }else if(sum<lower) calories--;

      }
        return calories;
    }
}
