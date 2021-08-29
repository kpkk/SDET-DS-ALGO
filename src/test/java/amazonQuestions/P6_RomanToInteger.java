package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class P6_RomanToInteger {
    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

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


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

    /*
    Input- String
    output- integer
     */

    @Test
    public void test1(){
        String s="III";
        Assert.assertEquals(convertRomanToInt(s),3);
    }
    @Test
    public void test2(){
        String s="IV";
        Assert.assertEquals(convertRomanToInt(s),4);
    }
    @Test
    public void test3(){
        String s="IX";
        Assert.assertEquals(convertRomanToInt(s),9);
    }
    @Test
    public void test4(){
        String s="LVIII";
        Assert.assertEquals(convertRomanToInt(s),58);
    }
    @Test
    public void test5(){
        String s="MCMXCIV";
        Assert.assertEquals(convertRomanToInt(s),1994);
    }

    /*
    - Initialize a hashmap and the add the mapping entries of roman symbols and integer values, an int variable sum=0
    - iterate the string from left to right
    - if the map contains the character and the next is char is lesser add to the sum
    - if the current char value is greater than prev value then subtract the current from prev and from sum
    - return the sum

     */
    private int convertRomanToInt(String s) {
        int sum=0;
        HashMap<Character,Integer>map=new HashMap<Character,Integer>(){
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
            }
        };
        char[] chars = s.toCharArray();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(i!=0 && map.get(chars[i])>map.get(chars[i-1])){
                sum=sum-map.get(chars[i-1])+map.get(chars[i])-map.get(chars[i-1]);

            }else{
                sum+=map.get(chars[i]);
            }

        }
        return sum;
    }

}
