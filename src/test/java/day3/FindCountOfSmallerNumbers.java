package day3;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class FindCountOfSmallerNumbers {

    /*

    Example 1:

Input: nums = [8,1,2,2,3] 1,2,2,3,8-->   8-1, 1-1, 2-2, 3-1
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]


Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100

1. Did I understand the problem? -->yes
  Q. Do we need to return the array in sorted order or the way it is given in problem?

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?  --> integer array
        What is the expected output? integer array
        Do I’ve constraints to solve the problem?  [array length >2, <500 , elements in an array >0<100], solve in O(n)
        Do Ive all the information to go to the next steps
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this
5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code
9. Test against different test data
10. If it fails then debug to solve it

     */



    /*
    1->1
    2->2
    3->1 [1,2,1,1]
    8->1

    1. sort the array O(n log n) + O(n)
    2. find the occurrences of each ele using hashmap
    3. get the value set into an array , and start from reverse direction
     */

    @Test
    public void test1(){
        int [] nums={8,1,2,2,3};
        int[] output={4,0,1,1,3};
      //  Assert.assertTrue(Arrays.equals(bruteForce(nums),output));
        Assert.assertTrue(Arrays.equals(countSmallerNumbersInArray(nums),output));



    }
    @Test
    public void test2(){
        int [] nums={1,1,1,1,1};
        int[] output={0,0,0,0,0};
        Assert.assertTrue(Arrays.equals(bruteForce(nums),output));
    }
    @Test
    public void test3(){
        int [] nums={-1,0, 1, -2, 2};
        int[] output={1,2,3,0,4};
        Assert.assertTrue(Arrays.equals(bruteForce(nums),output));
    }

    /*
    Pseudo code:-

    1. sort the input array
    2. iterate the array from start from 1 st position, not 0th
    3. initialize an output array to hold the smaller elements
    4. check nums[i-1]< nums[i] if yes add index to the output array
    5. if nums[i-1]== nums[i] then add the element of output array which is at previous index
    6. return the array
     */

    // Time Complexity- O(n^2)
    //Space complexity - O(n)

    public int[] bruteForce(int[] nums){
        int [] arr=new int[nums.length];
        int index=0;
        if (nums.length<2 || nums.length>500) throw new RuntimeException("invalid input");
        for (int i=0;i<nums.length;i++){
            int count=0;
            for (int j=0;j<nums.length;j++){
                if (nums[i]>nums[j] && i!=j) count++;
            }
            arr[index++]=count;
        }
        return arr;
    }

    public int[] findSmallerEleusingMap(int[]nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        Integer [] arr=new Integer[nums.length];
        int []eleCount=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        map.values().toArray(arr);

        int count=0, index=0;
        for (int i=arr.length-1;i>0;i--){
            if(arr[i]==1) {
                count+= arr[i-1];
                eleCount[index++]=count;
            }
            else {
                while (arr[i]>=1){
                    count++;
                }
                eleCount[index++]=count;
            }
        }
       return eleCount;
    }

    public int[] countSmaller(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[nums.length];
        for(int i = nums.length - 1; i>= 0; i--){
            if(map.containsKey(nums[i])){
                arr[i] = map.get(nums[i]);
            }
            else{
                arr[i] = -1;
            }
            map.put(nums[i], i);
        }
        int[] result = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            int count = 0;
            if(arr[i] == -1){
                for(int j = i; j < nums.length; j++){
                    if(nums[i] > nums[j]) count++;
                }
                result[i] = count;
            }else{
                for(int j = i; j < arr[i]; j++){
                    if(nums[i] > nums[j]) count++;
                }
                result[i] = count + result[arr[i]];
            }
        }
        List<Integer> res = new LinkedList<>();
        for(int n : result) res.add(n);
        System.out.println(res);
        return arr;
    }

    /*
    Solution:-
    - initialize an integer array of length-->101, as the max value at any given index would be 100
    - initialize an integer array result of given input array length
    - iterate the input array and initialize the indices in count array with input array values respectively
    - iterate from the number 1 to 100, then update the indices in count array
    - iterate the input array and if the value at index is zero update the result index as zero
        - else update the count array index value
     */
    private int[] countSmallerNumbersInArray(int[] nums){
        int[] count=new int[101];
        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        for (int i=1;i<=100;i++){
            count[i]=count[i]+count[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) result[i]=0;
            else{
                result[i]=count[nums[i]-1];
            }
        }
        return result;
    }

}
