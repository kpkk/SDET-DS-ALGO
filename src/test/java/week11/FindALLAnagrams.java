package week11;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FindALLAnagrams {
    /*
    Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
     */
    @Test
    public void test1(){
        String s="cbaebabacd";
        String p="abc";
        Assert.assertEquals(findAnangrams(s,p), Arrays.asList(0,6));
    }
    @Test
    public void test2(){
        String s="abab";
        String p="ab";
        Assert.assertEquals(findAnangrams(s,p), Arrays.asList(0,1,2));
    }

    private List<Integer> findAnangrams(String s, String p) {
        List<Integer>indices=new ArrayList<>();
        if(s.length()<p.length()) return indices;
        HashMap<Character,Integer>smap=new HashMap<>();
        HashMap<Character,Integer>pmap=new HashMap<>();
        for (int i=0;i<p.length();i++){
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
        }
        if(smap.equals(pmap)) indices.add(0);
        for (int i=p.length();i<s.length();i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
                if(smap.get(s.charAt(i-p.length()))>1){
                    smap.put(s.charAt(i-p.length()),smap.get(s.charAt(i-p.length()))-1);
                }else{
                    smap.remove(s.charAt(i-p.length()));
                }

            if(smap.equals(pmap))indices.add(i-p.length()+1);
        }

        return indices;
    }
    public List<Integer> findAnagrams(String s, String p) {

        /*
        input- two strings
        output- list of integer
        Solution:-
        - Initialize an int array of size 26 - pAscii
        - Intialize an arraylist to add the indices of the anagrams
        - iterate the string and initialize the indices of the char positions
        - initialize two pointers left=0, right=p.length();
        - iterate the string s, take the substring between the pointers
        - convert the substring into ascii
        - compare both the ascii arrays and if they are equal, add the index to the list
        - else remove the last char and add the next char from the string s
        - repeat this until the length of the string is reached

        */
        if(s.length()<p.length()) return new ArrayList();
        int left=0, right= p.length()-1;
        List<Integer> indices=new ArrayList();
        int[] pAscii=new int[26];
        for(int i=0;i<p.length();i++){
            pAscii[p.charAt(i)-'a']++;
        }

        while(right<s.length()){
            String subSet=s.substring(left,right+1); //cba
            int[] sAscii=new int[26];
            for(int i=0;i<subSet.length();i++){
                sAscii[subSet.charAt(i)-'a']++;
            }
            if(Arrays.equals(sAscii,pAscii)){
                indices.add(left);
            }

            left++;
            right++;
        }
        return indices;
    }
}
