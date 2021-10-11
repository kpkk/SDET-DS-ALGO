package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

public class FindMaxSubString {

    /*
    find the max substring in the given string of k max occurrences


    //eceba k=2
    Solution:-
    initialize the variables left=0, right=0, max=1
    initialize a hashmap<Integer, Integer>
    Traverse the string and add each ascii value of the character as key and index as value to map until map.size is<=k
    When the map size crosses k
        - remove the least index that was found
        - move left by minIndex+1
        - compare the max value between the max and right-left
     return max

     */

    @Test //+ve
    public void test1(){
        String s="eceba";
        int k=2;
        Assert.assertEquals(subStringLength(s,k),3);
    }
    @Test
    public void test2(){
        String s="aabab";
        int k=2;
        Assert.assertEquals(subStringLength(s,k),5);
    }
    @Test //-ve
    public void test3(){
        String s="eceba";
        int k=6;
        Assert.assertEquals(findSubString(s,k),5);
    }
    @Test //edge - must have been clarified before
    public void test4(){
        String s="ceEba";
        int k=3;
        Assert.assertEquals(findSubString(s,k),3);
    }


    //Time complexity- O(n)
    //Space complexity- O(n)
    private int findSubString(String s, int k) {

        if(s.trim().length()==0) return 0;
        if(s.trim().length()<k) return s.length();
        int left=0, right=0, max=1;
        HashMap<Character, Integer>map=new HashMap<>();
        while (right< s.length()){
            map.put(s.charAt(right),right++);
            if(map.size()>k){
                Integer minIndex = Collections.min(map.values());
                map.remove(s.charAt(minIndex));
                left=minIndex+1;
            }
           max= Math.max(max,right-left);
        }
        return max;
    }
    /*

    Solution:-
    Initialize variables called uniqueCount=0, max=0, left=0, right=0
    Initialize an integer array of length 128
    Traverse the given string and update the ascii array index based upon the value of the character at specified index and increment unique until unique<=k
    When unique crosses k
        - Check if the value of the left character in ascii array is greater than zero, if yes decrement the value
    Compare the max and right-left
    return max
     */

    private int findSubStringusingAscii(String s, int k) {

       int left=0,right=0, max=0, uniqueCount=0;
       int[] ascii=new int[128];
       for (right=0;right<s.length();right++){
           if(ascii[s.charAt(right)]==0) {
               ascii[s.charAt(right)]++;
               uniqueCount++;
           }
           else ascii[s.charAt(right)]++;

           if(uniqueCount>k){
               while (--ascii[s.charAt(left++)]>0);
               uniqueCount--;
           }
          max= Math.max(max,right-left+1);
       }
        return max;
    }


    private int subStringLength(String s, int k){
        int left=0, right=0, maxLength=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while (right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while (map.size()>k){
                if (map.get(s.charAt(left))>1){
                    map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)+1);
                }else map.remove(s.charAt(left));
                left++;
            }
           maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }

}
