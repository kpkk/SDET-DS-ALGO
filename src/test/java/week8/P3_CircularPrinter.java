package week8;

import org.junit.Assert;
import org.junit.Test;

public class P3_CircularPrinter {

    /*
    Calculate the min time needed to print a string
    - circular printer, A-Z wraps
    - it takes only one second to move to adjacent char
    Eg: BZA output-->4

    Input- String
    output- integer
    Approach- ascii value
     */
    @Test
    public void test1(){
        String s="BZA";
        Assert.assertEquals(4,findTimeToPrint(s));
    }
    @Test
    public void test2(){
        String s="ACDEF";
        Assert.assertEquals(5,findTimeToPrint(s));
    }
    @Test
    public void test3(){
        String s="FEC";
        Assert.assertEquals(8,findTimeToPrint(s));
    }

    /*
    Solution:-
    - convert the string into char array
    - iterate the array from start index to end
    - check the distance between the current character and A, also in reverse direction take the min of it add it to sum
    - return the sum
    ABCD, ZAZ
     */

    // Time complexity- O(n)
    //space complexitty - O(n)
    private int findTimeToPrint(String s) {
        char[] chars = s.toCharArray();
        int sum=Math.min(chars[0]-'A',26-(chars[0]-'A'));
        for (int i=1;i<s.length();i++){
            int diff=Math.abs(chars[i]-chars[i-1]);
            sum+=Math.min(diff,26-diff);
        }
        return sum;
    }

}
