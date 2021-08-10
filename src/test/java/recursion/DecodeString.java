package recursion;

import org.junit.Assert;
import org.junit.Test;

public class DecodeString {

    /*
    Given a string s, decode into the form such that the alphabets get repeated number of times of the number present before the open bracket
    Eg- s= 2[a]3[b]
    output- aabbb
     */

    @Test
    public void test1(){
        String s= "2[a]3[b]";
        Assert.assertEquals(decodeString(s),"aabbb");
    }
    @Test
    public void test2(){
        String s= "[a][b]";
        Assert.assertEquals(decodeString(s),"ab");
    }
    @Test
    public void test3(){
        String s= "2[[a][b]]";
        Assert.assertEquals(decodeString(s),"abab");
    }
    @Test
    public void test4(){
        String s= "1[a][b]";
        Assert.assertEquals(decodeString(s),"ab");
    }

    /*
    Approach:- recursion
    - base case when the string doesn't contain ] then return the strung
    - find the index of first closing bracket
    - take the substring from start until the index of first closing bracket
    - identify the index of last opening bracket
    - take the substring between the brackets and store it in a string
    - check if the previous index before the open bracket is a digit
        - if yes, in a while loop append the substring number of times of that value of digit
        - if no digit available treat that to be 1
    - append the substring to the main string and call the method recursively until the whole string is decoded

     */
    private String decodeString(String s) {
        if(!s.contains("]")) return s;
        String output="";
        int k=1;
        // count=1, number=1;
      //  String digit="";
        int closingIndex = s.indexOf(']');
        int openIndex= s.substring(0, closingIndex).lastIndexOf('[');
        String subString = s.substring(openIndex + 1, closingIndex);

        if(openIndex==0) k=1;
        else if(openIndex-1>=0 &&s.charAt(openIndex-1)=='[') k=1;


        else if(Character.isDigit(s.charAt(openIndex-1))){
            k= Character.getNumericValue(s.charAt(openIndex - 1));
        }
        /*while (openIndex-count>=0 && Character.isDigit(s.charAt(openIndex-count))){
            digit=s.substring(openIndex-count,openIndex);
            count++;
        }*/
       // number= Integer.parseInt(digit);
        while (k>0){
            output+=subString;
            k--;
        }

        int index=openIndex==0 || !Character.isDigit(s.charAt(openIndex-1)) ?openIndex:openIndex-1;
        s=s.substring(0,index)+output+s.substring(closingIndex+1);
        return decodeString(s);
    }
}
