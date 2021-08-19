package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class AppleQuestion {

    /*
    , Introductions
2. Testing questions based on experience: have you done API level testing? Have you done GUI testing?
3. Give an example of how to test an interactive control (like a dropdown,checkbox etc)
4. Why are you leaving present company?
5. Why Apple?
6. How strong are you in python
7. What is the testing process( test strategy, plan, execution etc)
8. One coding question : https://leetcode.com/problems/fizz-buzz/
9. Any questions for us?

    https://leetcode.com/problems/fizz-buzz/

    Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i if non of the above conditions are true.


Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]


Constraints:

1 <= n <= 104

    Input- integer
    Output- String array
    Constraints:- USe hashmap with two pointer
    test data:- n=
    Solution:-
    - Initialize a hashmap, integer as key and strings as value
    - Initialize an output array of String type, which is of length n
    - Initialize two pointers left=1, right=n
    - while left<=right
    - check if the number at left index is divisible by 3/5/3&5 , get the value for the key and update the output array
    - if not, update the output array with  left value (converted string)
    - return output array

    Time analysis : bruteforce was solved in <15 mins
    for hashmap
    - Pseudo code:- 15
    - Coding- 10
    - debug - 5 mins

     */

    @Test
    public void test1(){
        int n=3;
        String[] result={"1","2","Fizz"};
        Assert.assertEquals(returnStringArray(n),result);
    }

    @Test
    public void test2(){
        int n=5;
        String[] result={"1","2","Fizz","4","Buzz"};
        Assert.assertEquals(fizzBuZZmapApproach(n),result);
    }
    @Test
    public void test3(){
        int n=15;
        String[] result={"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"};
        Assert.assertEquals(fizzBuZZmapApproach(n),result);
    }
    @Test
    public void test4(){
        int n=4;
        String[] result={"1","2","Fizz","4"};
        Assert.assertEquals(returnStringArray(n),result);
    }

    private String[] fizzBuzz(int n){
        String[] output=new String[n];
        while (n>0){
            if(n%3==0 && n%5==0){
                output[n-1]="FizzBuzz";
            }else if(n%3==0){
                output[n-1]="Fizz";
            }else if(n%5==0){
                output[n-1]="Buzz";
            }else{
                output[n-1]=n+"";
            }
            n--;
        }
        return output;
    }

    /*

    - Initialize two pointers left=1, right-=n
    - create an output array of n length
    - Initialize a hash map with key as number and String as value
    - check if the number at pointer is present in map
        - if it is equal to 3--> get the  value add it to string
        - if its 5, get its value and add it to output array
    - if the value doesn't present in map and is divisible by both 3 and 5 add fizzbuzz
    - return the array

     */


    private String[] returnStringArray(int n) {
        HashMap<Integer,String>map=new HashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");
        map.put(15,"FizzBuzz");
        String[] output=new String[n];
        int left=1, right=n;
        while (left<=right){
            if(left%3==0 && left%5==0){
                output[left-1]=map.get(15);
            }
            else if(left%3==0){
                output[left-1]=map.get(3);
            }
            else if(left%5==0){
                output[left-1]=map.get(5);
            }else {
                output[left-1]=left+"";
            }
            if(right %3==0 && right%5==0){
                output[right-1]=map.get(15);
            }
            else if(right%3==0){
                output[right-1]=map.get(3);
            }
            else if(right%5==0){
                output[right-1]=map.get(5);
            }else {
                output[right-1]=right+"";
            }

            left++;
            right--;
        }
        return output;
    }

    /*
    - Initialize hashmap Integer as key an value as string
    - Initialize a string array of input length
    - load the mappings into the map
    - iterate from 1 until the given number
    -  for every i value
        - get the keyset of map
        - check if the number is divisible by the value then update the value with corresponding value
    - return the ouput array
     */
    private String[] fizzBuZZmapApproach(int n){
        String output[]=new String[n];

        HashMap<Integer,String>map=new HashMap<Integer,String >(){
            {
                put(3,"Fizz");
                put(5,"Buzz");

            }
        };
        for (int i=1;i<=n;i++){
            String numStr="";
            Set<Integer> integers = map.keySet();
            for (int setvalue:integers){
                if(i%setvalue==0) numStr+=map.get(setvalue);
            }
            if(numStr.equals("")){
                output[i-1]=Integer.toString(i);
            }else{
                output[i-1]=numStr;
            }
        }

        return output;
    }


}
