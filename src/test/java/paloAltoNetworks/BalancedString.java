package paloAltoNetworks;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class BalancedString {

    @Test
    public void test1(){
        String s="azABaabza";
        Assert.assertEquals(findBalancedFragment(s),5);
    }
    @Test
    public void test2(){
        String s="TacoCat";
        Assert.assertEquals(findBalancedFragment(s),-1);
    }
    @Test
    public void test3(){
        String s="AcZCbaBz";
        Assert.assertEquals(findBalancedFragment(s),8);
    }

    /*
    input - string
    output- length of the string (integer)
    Solution:- using hashmap
    - Initialize two hash sets one for smaller case letters and another upper case characters
    - iterate the string from start index until the end
    - store the smaller and upper chars in respective sets
    - initialize two pointers left, right=0
    - iterate the string until right reaches length
    - check if the current char is present in both the maps, then add to the new string
    - if any char is missing then reset the string and move the left pointer to right

     */
    private int findBalancedFragment(String s) {
        HashSet<Character>lowerSet=new HashSet<>();
        HashSet<Character>upperSet=new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if((int)chars[i]>=97 && (int)chars[i]<=122) lowerSet.add(chars[i]);
            else upperSet.add(chars[i]);
        }
        int left=0, right=0, length=0;
        String temp="";
        while (right<s.length()){
            if(lowerSet.contains(Character.toLowerCase(s.charAt(right)))&& upperSet.contains(Character.toUpperCase(s.charAt(right)))){
                temp+=s.charAt(right);
                length=Math.max(length,right-left+1);
                right++;
            }else{
                if(right==s.length()-1)return -1;
               left++;
               right=left;
               temp="";
            }
        }
        return length==1?-1:length;
    }
}
