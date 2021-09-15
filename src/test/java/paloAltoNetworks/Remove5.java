package paloAltoNetworks;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class Remove5 {

    @Test
    public void test1(){
        int n=15958;
        Assert.assertEquals(remove5(n),1958);
    }
    /*
    input- integer
    output- integer
    Solution:-
    - Determine the integer to be negative or postive
    - Convert the given integer into a string
    - iterate the string from start index until the end
    - if the character at a particular index is 5 then take the substring until that and index and concatenate w/ another substring which is index after it until the length
    - Convert that into an integer and find the max value

     */
    public int remove5(int n){

        return 0;
    }





























   /* public int remove(int n){
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
        }
        String s = Integer.toString(n);
        int max = 0, min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '5') {
                String temp = s.substring(0, i) + s.substring(i + 1);
                int tempInt = Integer.parseInt(temp);
                if (isNegative)
                    min = Math.min(tempInt, max);
                else
                    max = Math.max(tempInt, max);
            }
        }
        return isNegative ? min : max;
    }

*/
}
