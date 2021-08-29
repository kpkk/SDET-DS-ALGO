package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P5_IntegerToRoman {
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
Given an integer, convert it to a roman numeral.



Example 1:

Input: num = 3
Output: "III"
Example 2:

Input: num = 4
Output: "IV"
Example 3:

Input: num = 9
Output: "IX"
Example 4:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= num <= 3999
     */

    /*
    Input - integer
    output- string

     */
    @Test
    public void test1(){
        int num=3;
        Assert.assertEquals(intToRomanConversion(num),"III");
    }
    @Test
    public void test2(){
        int num=4;
        Assert.assertEquals(intToRomanConversion(num),"IV");
    }
    @Test
    public void test3(){
        int num=9;
        Assert.assertEquals(intToRomanConversion(num),"IX");
    }
    @Test
    public void test4(){
        int num=54;
        Assert.assertEquals(intToRomanConversion(num),"LIV");
    }
    @Test
    public void test5(){
        int num=1994;
        Assert.assertEquals(intToRomanConversion(num),"MCMXCIV");
    }

    /*
    - Initialize a hashmap with integer as key and string as value
    - initialize a stringbuffer to construct and return the string from int
    - iterate the map, check if the num- map key>0, add the value to the string, subtract that value from inut number
    - return string

     */
    private String intToRomanConversion(int num) {
        StringBuffer sb=new StringBuffer();
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       for (int i=0;i<values.length;i++){
           while (num-values[i]>=0){
               sb.append(romans[i]);
               num-=values[i];
           }
       }
        return sb.toString();
    }
}
