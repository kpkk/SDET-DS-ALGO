package day1;

import org.junit.Test;

import javax.script.ScriptContext;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindFirstDuplicate {

    boolean isDuplicateExist = true;

    /*
find first duplicate in integer array
eg:-  int=[1,2,3,4,4,5,6,6]

   Did i understand the problem?
       - If no ask to provide examples
       - if yes, proceed with the next steps
    1. what is the input? integer array
    2. what should be the expected output? integer
    3. Do i have any constraints - solve by bruteforce- no constraints for now
    4. How big is your test data?
    5. test data set
    +ve, -ve and edge
    6. do i've all the information to solve the problem

     */

    //+ve

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 6};
        int duplicate = findDupUsingTempArray(nums);
        System.out.println(duplicate);
    }

    //-ve
    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    //edge
    @Test
    public void test2() {
        int[] nums = {-1, 1, 2, 3, 4, 5, 6};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
        int approach = approach(nums);
        System.out.println(approach);


    }

    @Test
    public void test3() {
        int[] nums = {-1, 8, 1, -1, 1, 1, 2, 7, 4, 5, 6};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
        int approach = approach(nums);
        System.out.println(approach);
    }

    /*
    1. declare an arraylist
    2. iterate the outer loop starting from 0th index
    3. iterate inner loop starting at a position after i
    4. compare if the numbers are same
    5. If same then add the index to the list
    6. sort the list then get the first element to ensure its the first encountered duplicate
     */
    public int approach(int[] nums) {
        ArrayList<Integer> al = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    al.add(j);
            }
        }
        Collections.sort(al);
        System.out.println(al);
        if (al.isEmpty()) {
            isDuplicateExist = false;
            System.out.println("no duplicates");
            return 0;
        }

        return nums[al.get(0)];
    }


    /*
    Pseduo code:-

    1. initialize the hashset
    2. iterate the array from left to right
    3. Add each character to the set and check if it results in false
    4. if at all the add method returns false, that's the duplicate hence return the integer
     */

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return nums[i];
        }
        return 0;
      //  String s=new String();

    }

    /*
    Note: this approach will not work if array has negative numbers
    - iterate the given array from start index and until the end
    - find the max number
    - create a new temp array of max+1 size
    - traverse the input array, get the number,  initialize the index of that number in the temp array
    - iterate the temp array and, where ever the value is >1 return that index
     */

    private int findDupUsingTempArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
        }
        int[] temp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 1) return i;
        }

        return -1;
    }


}
