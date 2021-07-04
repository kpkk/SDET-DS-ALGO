package day1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FindFirstDuplicate {

    boolean isDuplicateExist=true;

    /*
find first duplicate in integer array

   Did i understand the problem?
    1. what is the input? integer array
    2. what should be the expected output? integer
    3. Do i have any constraints - solve by bruteforce- no constraints for now

    4. do i've all the information to solve the problem
    5. test data set
    +ve, -ve and edge
    int=[1,2,3,4,4,5,6,6]
     */

    //+ve

    @Test
    public void test(){
        int[] nums={1,2,3,4,5,6,6};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }
    //-ve
    @Test
    public void test1(){
        int[] nums={1,2,3,4,5,6};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    //edge
    @Test
    public void test2(){
        int[] nums={-1,1,2,3,4,5,6};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
        int approach = approach(nums);
        System.out.println(approach);
    }
    @Test
    public void test3(){
        int[] nums={-1,8,1,-1,1,1,2,7,4,5,6};
     //   int duplicate = findDuplicate(nums);
     //   System.out.println(duplicate);
        int approach = approach(nums);
        System.out.println(approach);
    }

    public int approach(int[] nums){
        ArrayList<Integer> al=new ArrayList();
        int count=0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]==nums[j])
                    al.add(j);
            }
        }
        Collections.sort(al);
        if (al.isEmpty()){
            isDuplicateExist=false;
            System.out.println("no duplicates");
            return 0;
        }


       return nums[al.get(0)];
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
