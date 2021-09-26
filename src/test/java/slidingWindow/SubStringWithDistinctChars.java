package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashSet;

public class SubStringWithDistinctChars {

    /*
    A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.



Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
The only good substring of length 3 is "xyz".
Example 2:

Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".


Constraints:

1 <= s.length <= 100
sconsists of lowercase English letters.
     */
    @Test
    public void test1(){
        String s="xyzzaz";
        Assert.assertEquals(countGoodSubstrings(s),1);
    }
    @Test
    public void test2(){
        String s="aababcabc";
        Assert.assertEquals(countGoodSubstrings(s),4);
    }
     /*
        input- String
        output- String
        Solution:-
        - Initialize a hashset of charactetr type
        - Initialize two pointers l=0, r=0, total
        - add 3 characters to the set and keep moving the right and left for 3 window length
        - if the set size is equals to the right-left+1 then add that to the total
        - retun total
        */

    public int countGoodSubstrings(String s) {

        LinkedHashSet<Character> set=new LinkedHashSet();
        int total=0;
        int left=0, right=left+2;
        while(right<s.length()){
            String substring = s.substring(left, right + 1);
            char[] chars = substring.toCharArray();
            for (char ch:chars){
                set.add(ch);
            }
            if(set.size()==3) total++;
            left++;
            right++;
            set.clear();
        }

        return total;
    }
}

/*
 for(int i=0;i<3;i++){
            set.add(s.charAt(i));
        }
        if(set.size()==3) total++;
        for(int i=3;i<s.length();i++){
            set.remove(s.charAt(i-3));
            set.add(s.charAt(i));
            if(set.size()==3) total++;
        }
 */