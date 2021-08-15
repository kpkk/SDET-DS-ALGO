package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindAnagrams {

    /*

    P5) Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

1. Did I understand the problem? yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)? string input, string anagram
        What is the expected output? integer array
        Do I’ve constraints to solve the problem? use sliding window
        Do Ive all the information to go to the next steps
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ? yes,
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
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data
10. If it fails then debug to solve it
11. Optimize the code and remove unnecessary code
     */

    @Test
    public void test1(){
        String s="cbaebabacd";
        String p="abc";
        Arrays.equals(findAnagramsIndices(s,p),new int[]{0,6});
    }
    @Test
    public void test2(){
        String s="cbaebabacd";
        String p="dba";
    }
    @Test
    public void test3(){
        String s="abccbaacb";
        String p="abc";
    }
    /*
    Solution
    1. Initialize an integer array of input string length, an int variable index=0
    2. Initialize a hashmap called strMap <Character, Integer> to store all the string character
    3. Initialize a hashmap called ptnMap <Character, Integer> to store all the pattern character
    4. Traverse through the pattern and add all the characters to the ptnMap
    5. Traverse through string and add ptn length characters then compare the two map objects
            - if the maps are equal add the index i-ptn.length() to the output array
            - else continue
    6. Return the array

     */

    //cbaebabacd   a-1
    public int[] findAnagramsIndices(String str, String ptn){
        int pLength = ptn.length();
        int sLength = str.length();
        int[] indices=new int[sLength];
        HashMap<Character,Integer>ptnMap=new HashMap<>();
        HashMap<Character,Integer>strMap=new HashMap<>();
        int index=0;
        for (char ch:ptn.toCharArray()){
            ptnMap.put(ch, ptnMap.getOrDefault(ch,0)+1);
        }
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            strMap.put(c, strMap.getOrDefault(c,0)+1);
            if(i>=pLength){
                if(strMap.get(str.charAt(i-pLength))>1)
                    strMap.put(str.charAt(i-pLength), strMap.getOrDefault(str.charAt(i-pLength),0)-1);
                else
                    strMap.remove(str.charAt(i-pLength));
            }
            if(strMap.equals(ptnMap))
                indices[index++]=i-pLength+1;
        }
        return Arrays.copyOf(indices,index);
    }

    public int[] slidingWindow(String s, String p){
        if(p.length()>s.length()) throw new RuntimeException("invalid input");

        int index=0;
        int[] indices=new int[s.length()];
        HashMap<Character,Integer>pmap=new HashMap<>();
        HashMap<Character,Integer>smap=new HashMap<>();
        for (int i=0;i<p.length();i++) {
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
        }
        if (pmap.equals(smap)){
            indices[index++]=0;
        }

        //cbaebabacd aab
        for (int i=1;i<=s.length()-p.length();i++){
            if(smap.get(s.charAt(i - 1))>1)
                smap.put(s.charAt(i-1), smap.getOrDefault(s.charAt(i-1),0)-1);
            else
                smap.remove(s.charAt(i-1));

            smap.put(s.charAt(i+p.length()-1),smap.getOrDefault(s.charAt(i+p.length()-1),0)+1);
            if (smap.equals(pmap)) indices[index++]=i;

        }



        return Arrays.copyOf(indices,index);


    }


}




