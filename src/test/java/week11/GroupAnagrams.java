package week11;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GroupAnagrams {
    /*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
     */
    @Test
    public void test1(){
        List<String>list= Arrays.asList("eat","tea","tan","ate","nat","bat");
        System.out.println(groupAnagrams(list));
        List<List<String>> lists = groupAnagrams(list);
         Assert.assertEquals(groupAnagrams(list),lists);
    }
    /*
       - Initialize a hashmap of String as key and List of string as values
       - Intialize an list to keep adding the values
       - iterate the array from start index until end
       - initialize an ascii array of size 26
       - Initialize the ascii postions of each character (so as to find the occurrence)
       - convert the array into string
       - update the map with the key and list of strings as value
       - return the map values
       */
    public List<List<String>> groupAnagrams(List<String> strs){

        HashMap<String,List<String>> map=new HashMap();
        for(int i=0;i<strs.size();i++){
            List<String> list=new ArrayList();
            list.add(strs.get(i));
            int[] ascii=new int[128];
            char[] chars=strs.get(i).toCharArray();
            for(int j=0;j<chars.length;j++){
                ascii[chars[j]]++;
            }
            String key=Arrays.toString(ascii);
            if(map.containsKey(key)){
                List<String>mapValue=map.get(key);
                mapValue.addAll(list);
                map.put(key, mapValue);
            }else{
                map.put(key,list);
            }

        }
     //   Collection<List<String>> values = map.values();
        System.out.println(map.values());

        return new ArrayList<>(map.values());

    }
}
