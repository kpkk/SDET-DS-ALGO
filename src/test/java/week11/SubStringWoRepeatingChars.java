package week11;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubStringWoRepeatingChars {
    /*
    Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
     */
    @Test
    public void test1(){
        String str="abcabcbb";
        Assert.assertEquals(lengthOfLongestSubstrings(str),3);
    }
    @Test
    public void test2(){
        String str="pwwkew";
        Assert.assertEquals(lengthOfLongestSubstrings(str),3);
    }
    //problem understanding -2 mins
    // logic -
    //psedo code - 5 mins
    //code - 8 mins
        /*
        - Initialize two pointers left=0, right=0, maxLength
        - Intiialize an ascii array of 128 size
        - iterate the string from start index until end
        - initialize the index of the character
        - if duplicate is met, while that ascii count becomes 1 move the left pointer
        - calculate the max distance between the two pointer through out the traversal
        */
    @Test
    public void test3(){
        String str="abbccc";
        Assert.assertEquals(lengthOfLongestSubstrings(str),2);
    }
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0, maxLength=0;
        int[] ascii=new int[128];
        while(right<s.length()){
            ascii[s.charAt(right)]++;
            while(ascii[s.charAt(right)]>1){
                ascii[s.charAt(left++)]--;
            }
           maxLength=Math.max(maxLength,right-left+1);
           right++;

        }
        return maxLength;
    }



    /*
    Solution - using set
    - initialize a hashset of character type
    - iterate the array start index until the end
    - iterate the array (inner loop) from start until the duplicate is met
    - add every character to the set
    - If adding to the set fails, then calculate the max length (distance between chars) break the inner loop
    - clear the set then repeat the process
     */
    public int lengthOfLongestSubstringapproach2(String s){
        HashSet<Character>set=new HashSet<>();
        int length=0;
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                if(!set.add(s.charAt(j))){
                    length=Math.max(length,j-i);
                    break;
                }
            }
            set.clear();
        }

        return length;
    }

    public int SubStringWoDuplicatesHashSet(String s){
        int i=0, j=0, length=0;
        HashSet<Character>set=new HashSet<>();
        while (j<s.length()){
            if(!set.add(s.charAt(j))){
                set.remove(s.charAt(i++));
            }else{
                length=Math.max(length,set.size());
                j++;
            }

        }
        return length;
    }

    public int lengthOfLongestSubstrings(String s) {

        //problem understanding - 2 min
        //logic deriving -
        //pseudo code -
        //code -

        /*
          declare a maxCount variable as 0
          declare two pointers left at 0 and right at 0
          iterate throught the pointers till right pointer reach end
          add the count of value at right to map as key and value
          check the count of curr element is more than 1
          yes-> iterate the left pointer till the right count becomes 1
                while iterating decrement left count
          no-> do nothing

          get right-left+1
          check if the right-left+1 is greater than maxCount if yes set maxCount
          increment right


        */

        int maxCount = 0;
        int left = 0, right = 0;
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        while(right<s.length()){
            hm.put(s.charAt(right),hm.getOrDefault(s.charAt(right),0)+1);
            while(hm.get(s.charAt(right)) > 1){
                hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                left++;
            }
            maxCount = Math.max(maxCount, right-left+1);
            right++;
        }
        return maxCount;
    }
}
