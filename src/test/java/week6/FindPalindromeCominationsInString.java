package week6;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class FindPalindromeCominationsInString {
    /*
    Given a string find all the possible palindromes that exist in the main string
    String s= "abc"
    output= {"a","b","c"}
     */
    @Test
    public void test1(){
        String s="abc";
        Assert.assertArrayEquals(new String[]{"a","b","c"},findpalindromesInStringBruteForce(s));
    }
    @Test
    public void test2(){
        String s="aab";
        Assert.assertArrayEquals(new String[]{"aa","a","b"},findpalindromesInStringBruteForce(s));
    }
    @Test
    public void test3(){
        String s="";
        Assert.assertArrayEquals(new String[]{},findpalindromesInStringBruteForce(s));
    }
    @Test
    public void test4(){
        String s="x";
        Assert.assertArrayEquals(new String[]{"x"},findpalindromesInStringBruteForce(s));
    }

    /*
    Input- String
    Output- String array
    Appraoch: bruteforce

    Solution:-
    - Initialize a hashset of string type to hold the palindrome strings
    - iterate the char array from start index (outer loop)
    - add the character at index i to the set, as every single element by itself a palindrome
    - traverse the array from i+1 (inner loop)
    - get the substring reverse it then compare with the original substring
        - if both are equal then add that to set

    - convert the set into a string array and return

     */

    private Object[] findpalindromesInStringBruteForce(String s) {
        if(s.length()==0) return new String[]{};
        if(s.length()==1) return new String[]{s};
        HashSet<String>set=new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            set.add(chars[i]+"");
            for (int j=i+1;j<chars.length;j++){
                String substring = s.substring(i, j + 1);
                StringBuffer sb=new StringBuffer(substring);

                if(sb.reverse().toString().equals(substring)) set.add(substring);
            }
        }
        System.out.println(set);
        String output[]=new String[set.size()];
        set.toArray(output);
        return output;
    }
}
