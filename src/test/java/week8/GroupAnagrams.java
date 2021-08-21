package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    /*
    Question 5:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
List<List<String>>
 
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]
     */
    @Test
    public void test1(){
        String strings[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Assert.assertEquals(groupAnagrams1(strings),"[[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]");
    }

    /*
    - Initialize two hashmaps to store two strings, list of list of strings
    - iterate the given array from start index=0
    - put all the characters of string at index i into map1
    - iterate the same input array from one position after i (inner loop)
    - put all the characters into hashmap
    - check if both the maps are equal, if true then add both the strings to the list
    - add them to the final list of list strings
     */
    private List<List<String>> groupAnagrams(List<String> strings) {
        List<List<String>>listOfGroupedAnagrams=new ArrayList<>();
        ArrayList<String>list=null;
        for (int i=0;i<strings.size();i++){
            HashMap<Character,Integer> outerStringmap=new HashMap<>();
            list=new ArrayList<>();
            list.add(strings.get(i));
            char[] chars = strings.get(i).toCharArray();
            for (char ch: chars){
                outerStringmap.put(ch,outerStringmap.getOrDefault(ch,0)+1);
            }
            for(int j=i+1;j<strings.size();j++){
                HashMap<Character,Integer> innerStringmap=new HashMap<>();
                if(strings.get(j).length()!=strings.get(i).length()) break;

                char[] innerStringChars = strings.get(j).toCharArray();
                for (char ch: innerStringChars){
                    innerStringmap.put(ch,innerStringmap.getOrDefault(ch,0)+1);
                }
                if(innerStringmap.equals(outerStringmap)){
                    if(!list.contains(strings.get(j))) list.add(strings.get(j));

                }
            }
            if(!listOfGroupedAnagrams.contains(list))
            listOfGroupedAnagrams.add(list);
        }

       return listOfGroupedAnagrams;
    }
    
    private List<List<String>> groupAnagrams1(String[] str){
        HashMap<String,List<String>>map=new HashMap<>();
        for (int i=0;i<str.length;i++){
            int[] ascii=new int[26];
            String s = str[i];
            for (int j=0;j<s.length();j++){
                char c = s.charAt(j);
                ascii[c-'a']++;
            }
            ArrayList<String>list=new ArrayList<>();
            String asciiString = Arrays.toString(ascii);
            if(map.containsKey(asciiString)){
                list.addAll(map.get(asciiString));
                list.add(s);
                map.put(asciiString,list);
            }else{
                list.add(s);
                map.put(asciiString,list);
            }

        }
       return new ArrayList<>(map.values());
    }
}
