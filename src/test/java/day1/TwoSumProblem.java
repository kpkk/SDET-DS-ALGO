package day1;

import org.junit.Test;

import java.util.Arrays;

public class TwoSumProblem {

    /*


 Did i understand the problem? yes
    what is the input? integer array,  target
    what should be the expected output? integer array
    test data set
    +ve, -ve and edge

    int [] ={1, 4, 2, 8, 2, 6}
    int k=10
     */

    @Test
    public void test(){
        int [] nums={1,4,2,8,2,6};
        int k=10;
        int[] ints = returnIndex(nums, 10);
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
}
