package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SwapDigits {

    /*
    Input: num = 2736.
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: num = 9973
Output: 9973
Explanation: No swap.
     */
    @Test
    public void test1(){
        int num=2736;
        Assert.assertEquals(swapDigits(num),7236);
    }
    @Test
    public void test2(){
        int num=9973;
        Assert.assertEquals(swapDigits(num),9973);
    }

    /*
    - 1st loop, find the range index, start from first index of the array
        - check if the prev number is smaller than current number then break
    - consider the value at range index to be the max value
    - 2nd loop, start from the range index until the length and find the biggest number and index
    - swap the 

     */

    private int swapDigits(int num) {
        int maxValue=0, rangeIndex=0, maxIndex=0, minIndex=0;
        char[] chars = String.valueOf(num).toCharArray();
        // to find the first raise of value, range index
        for (int i=1;i<chars.length;i++){
            if(Integer.valueOf(chars[i])>Integer.valueOf(chars[i-1])){
                rangeIndex=i;
                break;
            }
        }
        // if range index is sitting at the last, return number
        if(rangeIndex==chars.length-1) return num;
        maxValue=Character.getNumericValue(chars[rangeIndex]);
        for (int i=rangeIndex;i<chars.length;i++){
            if(Integer.valueOf(chars[i])>maxValue){
                maxValue=Integer.valueOf(chars[i]);
                maxIndex=i;
            }
        }
        for (int i=0;i<chars.length;i++){
            if(Character.getNumericValue(chars[i])<maxValue){
                minIndex=i;
                break;
            }
        }
        char temp=chars[maxIndex];
        chars[maxIndex]=chars[minIndex];
        chars[minIndex]=temp;

        return Integer.parseInt(String.valueOf(chars));
    }

}
