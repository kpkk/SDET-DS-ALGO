package day1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {

    /*

    Two sum problem
    eg:
    int [] ={1, 4, 2, 8, 2, 6}
    int k=10

 Did i understand the problem? yes
          - If no ask to provide examples
          - if yes, proceed with the next steps
    1. what is the input? integer array,  target
    2. what should be the expected output? integer array
    3. Do i have any constraints - No constraints
    4. How big is your test data?
    5. test data set
    +ve, -ve and edge
    6. do i've all the information to solve the problem - convert into string and reverse it from end, recursion technique
    test data set
    +ve, -ve and edge

     */


    //+ve
    @Test
    public void test(){
        int [] nums={1,4,2,8,2,6};
        int k=10;
        int[] ints = twoSumMap(nums, k);
        System.out.println(Arrays.toString(ints));
    }
    //-ve
    @Test
    public void test1(){
        int [] nums={1,4,2,8,2,6};
        int k=110;
        int g=110;
        int[] ints = twoSumMap(nums, k);
        System.out.println(Arrays.toString(ints));

    }

    @Test
    public void test2(){
        int [] nums={1,4,2,8,2,6};
        int k=8;
        int[] ints = twoSumMap(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] returnIndex(int [] nums, int k){
        for (int i=0;i<nums.length;i++){
            int diff=k-nums[i];
            if (nums[i]==k)
                return new int[]{i,i};
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]==diff){
                    return new int[]{i,j};

                }
            }

        }
        return new int[]{-1,-1};
    }

    public int[] twoSum(int [] nums, int k){
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        while (left<right){
            if (nums[left]+nums[right]==k)
                return new int[]{left,right};
            else if(nums[left]+nums[right]>k)
                right--;
            else
                left++;
        }
        return new int[]{-1,-1};
    }

    private int[] twoSumMap(int[] nums, int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }



}
