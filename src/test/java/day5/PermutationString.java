package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PermutationString {
    /*

    Given two strings s1 and s2, return true if s2 contains the permutation of s1.

In other words, one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
     */

    @Test
    public void test1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Assert.assertTrue(findPermutationStringusingBruteForce(s1,s2));

    }



    @Test
    public void test2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Assert.assertFalse(findPermutationStringusingBruteForce(s1,s2));

    }


    @Test
    public void test3() {
        String s1 = "";
        String s2 = "";
        Assert.assertFalse(findPermutationStringusingBruteForce(s1,s2));
    }
    @Test
    public void test4() {
        String s1 = "abcd";
        String s2 = "eidboaoocdba";
        Assert.assertFalse(findPermutationStringusingBruteForce(s1,s2));

    }

    /*

    Solution:-
    1. If the length of the string s1 is greater than s2, return false
    2. if either of the strings length is 0 then return false
    3. Initialize two hashmaps character as key and its occurrence as value
    4. traverse the string s1 and add the characters to subStringMap also store first set elements from s2 (until s1.length()) into map
    5. compare if maps are equal if yes, return true
    6. traverse the for loop from index 1 until s2.length-s1.length
    6. Add the next chacter and deduct the count of prev character if it has occurred more than once else remove it
    7. compare if two maps are equal, if yes return true else false

     */
    private boolean findSubString(String s1, String s2) {
        if (s1.length()>s2.length()) return false;
        if (s1.trim().length()==0 || s2.trim().length()==0) return false;
        HashMap<Character,Integer>map=new HashMap<Character,Integer>();
        HashMap<Character,Integer>subStringMap=new HashMap<Character,Integer>();

        for (int i=0;i<s1.length();i++){
            subStringMap.put(s1.charAt(i),subStringMap.getOrDefault(s1.charAt(i),0)+1);
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0)+1);
        }
        if (map.equals(subStringMap)) return true;
        for (int i=1;i<s2.length()-s1.length();i++){
            map.put(s2.charAt(i+s1.length()-1),map.getOrDefault(s2.charAt(i+s1.length()-1),0)+1);
            if(map.size()>s1.length()){
                if(map.get(s2.charAt(i-1))>1)  map.put(s2.charAt(i-1),map.getOrDefault(s2.charAt(i-1),0)-1);
                else map.remove(s2.charAt(i-1));
                if(map.equals(subStringMap)) return true;
            }

        }
        return false;
    }

    /*
    Solution:
    1. Check if the string s1 length is greater than s2 then return false
    2. Initialize two integer arrays of length 128 (s1Array, s2 Array) to hold ascii values
    3. Traverse through the string s1 and update the ascii array index for every element
          - Similarly update s2 ascii array with s2 elements until s1 length
    4. Traverse through s2 from index=1 until s2.length-s1.length add update s2Ascii array indices
    5. if the value of i goes greater than s1 length then remove prev character add next character
    6. compare if both the arrays are equal, if yes return true else false

     */

    //ab
    //eidbaooo
    private boolean findSubStringUsingAscii(String s1, String s2){

        if(s1.length()>s2.length()) return false;
        if (s2.length()==0 || s2.length()==0) return false;
        int[] s1Ascii=new int[128];
        int[]s2Ascii=new int[128];
        for (int i=0;i<s1.length();i++){
            s1Ascii[s1.charAt(i)]++;
            s2Ascii[s2.charAt(i)]++;
        }
        if(Arrays.equals(s1Ascii,s2Ascii)) return true;
        for (int i=s1.length()-1;i<s2.length()-s1.length();i++){
            s2Ascii[s2.charAt(i+s1.length()-1)]++;
            s2Ascii[s2.charAt(i-1)]--;
           if(Arrays.equals(s1Ascii,s2Ascii)) return true;
        }

        return false;
    }

    private boolean findPermutationStringusingBruteForce(String s1, String s2){
        if(s1.length()>s2.length()) return false;
        if(s1.length()==0 || s2.length()==0) return false;
        ArrayList<Character>s1list=new ArrayList<>();
        ArrayList<Character>s2list=new ArrayList<>();
        for (int i=0;i<s1.length();i++){
            s1list.add(s1.charAt(i));
        }
        Collections.sort(s1list);
        for (int i=0;i<s2.length();i++){
           s2list.add(s2.charAt(i));
            if (s2list.size()==s1.length()){
                Collections.sort(s2list);
                if(s2list.equals(s1list))
                    return true;
                else
                    s2list.clear();
                    i--;
            }
        }
        return false;
    }

}