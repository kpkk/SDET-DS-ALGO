package day3;

import org.junit.Assert;
import org.junit.Test;
import sun.jvm.hotspot.types.CIntegerField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MoveOddNumbers {

    /*
    Given an integer array move all the odd number towards right
     did i understand the problem - yes
     what are inputs- integer array
     what is output- integer array
     do i've any constraints- No, output can be returned in anyway
     test data- 3 set (+ve,-ve, edge)
     do i know to solve it- yes, using two pointer approach
     any alternate solution- one with additional space , another way re-arranging the same array
     What are O-notations- Time complexity- O(n), space Complexity- O(1)
     write pseudo code


     */

    @Test
    public void test1(){
        int[] numbers={1,2,3,4,5,6,8,10};
        int[] output={2,4,6,8,10,1,3,5};
        Assert.assertTrue(Arrays.equals(moveOddsOppPointers(numbers),output));
    }
    @Test
    public void test2(){
        int[] numbers={1,1,2,4,1,6,8,10};
        int[] output={2,4,6,8,10,1,1,1};
        Assert.assertTrue(Arrays.equals(moveOddsOppPointers(numbers),output));
    }
    @Test
    public void test3(){
        int[] numbers={2,4,6,8};
        int[] output={2,4,6,8};
        Assert.assertTrue(Arrays.equals(moveOddsOppPointers(numbers),output));
    }

    /*
    Solution:-
    1. Initialize two pointers i=0, index=0 --> uni-directional
    2. Traverse through the array and check if the current index is even move that towards left (swap)
    3. return the array

     */

    //Time complexity- O(n)
    //space complexity- O(1)
    private int[] moveOddNumbersToRight(int[] numbers) {
        int j=0;
        for (int i=0;i<numbers.length;i++){
            if(numbers[i]%2==0){
                int temp=numbers[i];
                numbers[i]=numbers[j];
                numbers[j]=temp;
                j++;
            }
        }
        return numbers;

    }

    /*

    Solution2
    1. Initialize two array lists of integer type to hold even, odd values and an integer variable index=0
    2. Traverse the array from left (start) to right(till end)
            - add even elements to list 1
            - add odd elements to list2
    3. merge both lists, into a single list -->(addAll method)
    4. convert that into an array and return



     */

    @Test
    public void test4(){
        int[] numbers={1,2,3,4,5,6,8,10};
        int[] output={2,4,6,8,10,1,3,5};
       // moveOddNumbersBruteForce(numbers);
        Assert.assertTrue(Arrays.equals(moveOddNumbersBruteForce(numbers),output));
    }

    //Time complexity- O(2n)--> O(n)
    //space complexity- O(3n)-->(n)
    private int[] moveOddNumbersBruteForce(int[] nums){

        int index=0;
        ArrayList<Integer>evenNums=new ArrayList<>();
        ArrayList<Integer>oddNums=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if(nums[i]%2==0)
                evenNums.add(nums[i]);
            else
                oddNums.add(nums[i]);
        }
        evenNums.addAll(oddNums);
        int[] outputArr=new int[evenNums.size()];
        Iterator<Integer> iterator = evenNums.iterator();
        while (iterator.hasNext()){
            outputArr[index++]=iterator.next();
        }
        return outputArr;


    }

    private int[] moveOddsOppPointers(int[] nums){
        int left=0, right=nums.length-1;
        while (left<right){
            if(nums[left]%2==1 && nums[right]%2==0) {
                int temp = nums[left];
                nums[left++]=nums[right];
                nums[right--]=temp;
            }
            else if(nums[left]%2==0)
                left++;
            else if(nums[right]%2==1)
                 right--;


        }
        return nums;
    }
}
