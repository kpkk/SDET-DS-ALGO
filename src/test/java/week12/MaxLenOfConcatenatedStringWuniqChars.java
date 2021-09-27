package week12;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaxLenOfConcatenatedStringWuniqChars {
    /*
    You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26


Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
     */
    @Test
    public void test1(){
        List<String> s= Arrays.asList("un","iq","ue");
       Assert.assertEquals(maxLength(s),4);
    }
    @Test
    public void test2(){
        List<String> s= Arrays.asList("cha","r","act","ers");
        Assert.assertEquals(maxLength(s),6);
    }
    @Test
    public void test3(){
        List<String> s= Arrays.asList("abcdefghijklmnopqrstuvwxyz");
        Assert.assertEquals(maxLength(s),26);
    }
    @Test
    public void test4(){
        List<String> s= Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p");
        Assert.assertEquals(maxLength(s),16);
    }

    /*
       - input- String array
       - Output - integer

       solution:-
       - initialize varialbles called maxLength=0
       - iterate the array from start index=0
       - initialize variable called currentLength and assign the value of length of string at i
       - iterate the for loop from next index inner loop
       - convert the string into char arry, iterate the char array
       - check if the character in the current string is present in the prev string
           - if yes ignore the duplicates and form a new string w/o duplictes by concatinating
       - keep doing the same process , until all the checks are done

       */
    public int maxLength(List<String> arr) {
      return 0;

    }
}


/*
 int maxLength=0;
        HashSet<Character>set=new HashSet<>();
        if(arr.size()==1) return arr.get(0).length();
        for(int i=0;i<arr.size()-1;i++){
            String str=arr.get(i);
            int currentLength=str.length();
            StringBuilder sb=new StringBuilder(str);
            for(int j=i+1;j<arr.size();j++){
                char[] ch=arr.get(j).toCharArray();
                for(char c:ch){
                    if(str.contains(c+""))continue;
                    else sb.append(c);
                }
                currentLength=Math.max(sb.length(),currentLength);
            }
            maxLength=Math.max(currentLength,maxLength);

        }
        return maxLength;
 */