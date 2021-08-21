package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringToInteger {

    /*
    8. String to Integer (atoi)
Medium

576

1565

Add to List

Share
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
     */

    @Test
    public void test1(){
        String s="   -42";
        Assert.assertEquals(myAtoi(s),-42);
    }
    @Test
    public void test2(){
        String s="words and 987";
        Assert.assertEquals(myAtoi(s),0);
    }
    @Test
    public void test3(){
        String s="-91283472332";
        Assert.assertEquals(myAtoi(s),Integer.MIN_VALUE);
    }
    @Test
    public void test4(){
        String s="+-12";
        Assert.assertEquals(myAtoi(s),0);
       Character.isLowerCase('c');

    }

    /*
      - trim the given string to remove whitespaces
      - convert the string into char array
      - iterate the char array
      - check if the start char is - or +, if -ve update the flad
      - check if the character is digit
          - if yes, extend to the next character and start appening to the result string
      - if the non digit is met break
      - convert the output string into an Integer then return
      */
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        StringBuffer sb=new StringBuffer();
        boolean isNegative=false;
        char[] chars= s.trim().toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='-' &&i==0) {
                isNegative=true;
                continue;
            }if(chars[i]=='+' && i==0){
                continue;
            }
            if(Character.isDigit(chars[i])){
                sb.append(chars[i]);
                continue;
            }if(!Character.isDigit(chars[i])){
                break;
            }
        }
        if(sb.length()==0) return 0;
        long value= Long.valueOf(sb.toString());
        if(isNegative) value=value *-1;
        if(value>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(value<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) value;
    }
}
