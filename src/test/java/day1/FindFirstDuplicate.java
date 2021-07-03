package day1;

import org.junit.Test;

import java.util.HashSet;

public class FindFirstDuplicate {

    /*

    int=[1,2,3,4,4,5,6,6]
     */

    @Test
    public void test(){
        int[] nums={1,2,3,4,5,6,6};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }
    @Test
    public void test1(){
        int[] nums={1,2,3,4,5,6};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }
    @Test
    public void test2(){
        int[] nums={-1,1,2,3,4,5,6,-1};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
        int approach = approach(nums);
        System.out.println(approach);
    }

    public int approach(int[] nums){
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]==nums[j])
                    return nums[j];
            }
        }
        return 0;
    }
    public int findDuplicate(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (!set.add(nums[i]))
                return nums[i];
        }
        return 0;
    }


}
