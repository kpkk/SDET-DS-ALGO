package day5;

import org.junit.Assert;
import org.junit.Test;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.HashSet;

public class RomanNumerals {
    /*
    1.Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    @Test
    public void test1(){
        String str="III";
        Assert.assertEquals(convertRomanIntegralToNumber(str),3);
    }
    @Test
    public void test2(){
        String str="IV";
        Assert.assertEquals(convertRomanIntegralToNumber(str),4);
    }
    @Test
    public void test3(){
        String str="IX";
        Assert.assertEquals(convertRomanIntegralToNumber(str),9);
    }
    @Test
    public void test4(){
        String str="LVIII";
        Assert.assertEquals(convertRomanIntegralToNumber(str),58);
    }
    @Test
    public void test5(){
        String str="MCMXCIV";
        Assert.assertEquals(convertRomanIntegralToNumber(str),1994);
    }
    @Test
    public void test6(){
        String str="CCCCCCCCCLXXXXIX";
        Assert.assertEquals(convertRomanIntegralToNumber(str),999);
    }

    /*
    Solution:-
    Approach: hash map + sliding window

    - Initialize a hashMap and load all the roman characters and associated values
    - Initialize a sum variable with first character value
    - Traverse through the string from left to right
        - check if the current index character value greater than prev index
            - subtract the prev index value from sum and add the difference of current and prev character
        - if the current index is smaller than prev index then sum it
     - return the sum


     */

    //Time complexity- O(n)
    //Space complexity- O(n)
    private int convertRomanIntegralToNumber(String str){
        HashMap<Character,Integer>map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum= map.get(str.charAt(0));
        for (int i=1;i<str.length();i++){
            char c = str.charAt(i);
            if(map.get(c)>map.get(str.charAt(i-1))){
                sum=sum-map.get(str.charAt(i-1))+map.get(c)-map.get(str.charAt(i-1));
            }else{
                sum+=map.get(str.charAt(i));
            }
        }
        return sum;
    }
}
