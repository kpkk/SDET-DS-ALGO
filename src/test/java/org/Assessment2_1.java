package org;

import org.junit.Assert;
import org.junit.Test;

public class Assessment2_1 {

    /*

    Character re-programming
     */

    @Test
    public void test1(){
        String str="UDRL";
        Assert.assertEquals(getMaxdeletions(str),4);
    }
    @Test
    public void test3(){
        String str="URDR";
        Assert.assertEquals(getMaxdeletions(str),2);
    }
    @Test
    public void test4(){
        String str="RRRR";
        Assert.assertEquals(getMaxdeletions(str),0);
    }
    @Test
    public void test5(){
        String str="UDRLRRRLLLL";
        Assert.assertEquals(getMaxdeletions(str),10);
    }

    /*
    Solution:-
    - Initialize an int variable called count=0
    - Iterate the string from start till the end
    - Check if the character at index i is either 'U' or 'D' then increment the count
    - else decrement the count
    - if the count is zero return the length of the string
    - else return length - count
     */
    private int getMaxdeletions(String str) {

        if(str.length()==0) throw new RuntimeException("empty string");
        int count=0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)=='U'|| str.charAt(i)=='R')count++;
            else count--;
        }
        count= Math.abs(count);

        return count==0?str.length():str.length()-count;
    }
}
