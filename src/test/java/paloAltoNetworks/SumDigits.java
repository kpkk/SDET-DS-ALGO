package paloAltoNetworks;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SumDigits {

    @Test
    public void test1(){
        int [] nums={51,17,71,42};
        Assert.assertEquals(sumDigits(nums),93);
    }
    @Test
    public void test2(){
        int [] nums={42,33,60};
        Assert.assertEquals(sumDigits(nums),102);
    }
    @Test
    public void test3(){
        int [] nums={51,32,43};
        Assert.assertEquals(sumDigits(nums),-1);
    }

    /*
    two pointers opp direction
    get the each number and sum the digits
    if they are equal sum them, move the poointers
     */

    private int sumDigits(int[] nums) {

        int left=0, right=nums.length-1,maxSum=Integer.MIN_VALUE;
        while (left<=right){
            int leftNumber=nums[left];
            int leftsum = digitSums(nums[left]);

            int rightNumber=nums[right];
            int rightSum=digitSums(nums[right]);

            if(rightSum!=leftsum) return -1;
            else{
                maxSum=Math.max(leftNumber+rightNumber,maxSum);
            }

            left++;
            right--;
        }
        return maxSum;
    }
    public int digitSums(int number){
        int sum=0;
        while (number!=0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }





    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        for(int num : A){
            int sum = digitSum(num);
            if(map.containsKey(sum)){
                maxSum = Math.max(maxSum, map.get(sum) + num);
                if(map.get(sum) < num){
                    map.put(sum, num);
                }
            }else{
                map.put(sum, num);
            }
        }
        return maxSum;
    }
    public int digitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }

}

