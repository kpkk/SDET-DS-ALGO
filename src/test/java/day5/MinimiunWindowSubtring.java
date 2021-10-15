package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimiunWindowSubtring {
    /*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?

     */

    @Test
    public void test1(){
        String s="ADOBECODEBANC";
        String t="ABC";
        Assert.assertEquals(findSubStringMin(s,t),"BANC");
    }
    @Test
    public void test2(){
        String s="a";
        String t="a";
        Assert.assertEquals(findSubStringMin(s,t),"a");
    }
    @Test
    public void test3(){
        String s="aa";
        String t="aa";
        Assert.assertEquals(findSubStringMin(s,t),"aa");
    }



    /*
    Pseudo code:-
    - Initialize a hashmap with character as key and value as its occurrence, also a string variable
    - Initialize a minCount variables with Integer.MAX_VALUE and left=0 and right=1
    - Traverse through the string t and add all the characters into the map
        -check if the map contains every character that's present in the t string, if matches store the length and substring
    - Traverse the input string and add the characters in the map check for all the characters present or not
        - if yes, calculate the minimum length and update the length also the substring
     - keep checking the above steps until the entire string is traversed then return the final minimum length string
     */

    private String findMinSubString(String s, String t) {

        if(s.length()<t.length()) return "";

        Map<Character,Integer> map=new HashMap<>();
        String outputStr=""; int minCount=Integer.MAX_VALUE, left=0, right=1;

        for (int i=0;i<t.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        if(isAllCharsPresent(map,t)){
            minCount=t.length();
            outputStr=s.substring(0,t.length());
        }
        while (right<=s.length()-t.length()){
            char ch=s.charAt(right+t.length()-1);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while (isAllCharsPresent(map, t)){
                if(right+left-1<minCount){
                    minCount=right+left-1;
                    outputStr=s.substring(left,right+t.length());
                }
                if(map.get(s.charAt(left))>1){
                    map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                }else{
                    map.remove(s.charAt(left));
                }
                left++;
            }
            right++;

        }

        return outputStr;

    }

    private boolean isAllCharsPresent(Map<Character,Integer> map, String t){
        int left=0, right=t.length()-1;
        while (left<=right){
            if(left==right){
                if(!map.containsKey(t.charAt(left++))) return false;
            }else{
                if(!map.containsKey(t.charAt(left++))) return false;
                if(!map.containsKey(t.charAt(right--))) return false;
            }

        }

        return true;

    }


    private String findSubStringMin(String s, String t){
        HashMap<Character, Integer>map=new HashMap<>();
        int left=0, right=0;
        String output=""; int length=Integer.MAX_VALUE;
        while (right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if (right-left+1>=t.length()){
                while (isCharactersPresent(map,t)){
                    if((right-left)+1<length){
                        output=s.substring(left,right+1);
                        length=output.length();
                    }
                    if(map.get(s.charAt(left))>1){
                        map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                    }
                    else map.remove(s.charAt(left));
                    left++;
                }
            }
            right++;
        }
        return output;
    }

    private boolean isCharactersPresent(HashMap<Character, Integer> map, String t) {
        int left=0, right=t.length()-1;
        while (left<=right){
            if(left==right){
                if(!map.containsKey(t.charAt(left))) return false;
            }
           else if(!map.containsKey(t.charAt(left))) return false;
           else if(!map.containsKey(t.charAt(right))) return false;
           left++;
           right--;
        }
        return true;
    }

}
