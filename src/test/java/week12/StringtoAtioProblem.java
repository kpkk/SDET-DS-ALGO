package week12;

import org.junit.Assert;
import org.junit.Test;

public class StringtoAtioProblem {
    @Test
    public void test1(){
        String s="42";
        Assert.assertEquals(myAtoi(s),42);
    }
    @Test
    public void test2(){
        String s="   -42";
        Assert.assertEquals(myAtoi(s),-42);
    }
    @Test
    public void test3(){
        String s="4193 with words";
        Assert.assertEquals(myAtoi(s),4193);
    }

    /*
    Solution:-
    - trim the given string to eliminate the leading and trailing white spaces
    - convert the string into a char array
    - check if the first character is '-' , if yes declare and turn flag as true
    - iterate the character and get the each character and append that to an integer only if its a digit
    - if its not a digit then break
    - return the newly formed integer
     */
    private int myAtoi(String s) {
        boolean isNegative=false;
        double result=0.0;
        char[] chars = s.trim().toCharArray();
        if(chars[0]=='-') isNegative=true;
        for (int i=0;i<chars.length;i++){
            if(chars[0]=='-' && i==0)isNegative=true;
            else if(chars[0]=='+' && i==0)continue;
            else if(Character.isDigit(chars[i])){
                result=result*10+Character.getNumericValue(chars[i]);
            }
            else{
                break;
            }
        }
        if(isNegative)result=result*-1;
        if(result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;
    }
}
