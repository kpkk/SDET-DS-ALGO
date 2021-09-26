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

    /**
    input - string
    output- length of the string (integer)
    Solution:- using hashset
    - Initialize two hash sets one for smaller case letters and another upper case characters
    - iterate the string from start index until the end
    - store the smaller and upper chars in respective sets
    - initialize two pointers left, right=0
    - iterate the string until right reaches length
    - check if the current char is present in both the maps, then add to the new string
    - if any char is missing then reset the string and move the left pointer to right

     **/
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
               left=left+2;
               right=left;
               temp="";
            }
        }
        return length==1?-1:length;
    }

    /*
    private int findBalanced(String s) {
		Set<Character> lower = new HashSet<>();
		Set<Character> upper = new HashSet<>();
		Set<Character> lowerTemp = new HashSet<>();
		Set<Character> upperTemp = new HashSet<>();
		for(char c : s.toCharArray()) {
			if(Character.isUpperCase(c)) upper.add(c);
			else lower.add(c);
		}
		if(lower.isEmpty() || upper.isEmpty()) return -1;
		int left = 0, right = 0;
		while(right<s.length()) {
			char current = s.charAt(right);
			if(lower.contains(Character.toLowerCase(current)) && upper.contains(Character.toUpperCase(current))) {
				if(Character.isLowerCase(current)) lowerTemp.add(current);
				else upperTemp.add(Character.toLowerCase(current));
			}
			else{
				while(left <= right) {
					char remove = s.charAt(left);
					if(Character.isLowerCase(remove)) lowerTemp.remove(remove);
					else upperTemp.remove(Character.toLowerCase(remove));
					left++;
				}
			}
			if(!lowerTemp.isEmpty() && !upperTemp.isEmpty() && lowerTemp.e
from Vidhya to Everyone:    10:42  AM
if(!lowerTemp.isEmpty() && !upperTemp.isEmpty() && lowerTemp.equals(upperTemp)) return right-left+1;
			right++;
		}
		return -1;
	}

     */
}
