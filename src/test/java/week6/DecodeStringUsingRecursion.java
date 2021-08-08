package week6;

import org.junit.Assert;
import org.junit.Test;

public class DecodeStringUsingRecursion {

    /*
  // Find the first index of the closing bracket

		// If the index is -1 (no match), return the entire string as it is

		// Then, find the associated opening bracket index

		// Find the substring (content) between the open and close

		// Find the number before the open bracket

		// Put inside a String Buffer, expand the content

		// StringBuilder insert (String before the number) before the expanded content
		// StringBuilder append (String after the closing bracket)

		// Recursively call the String (StringBuilder)
     */

    @Test
    public void test1(){
        String str="2[a]3[b]";
        String output="aabbb";
        Assert.assertEquals(decodeString(str),output);
    }
    @Test
    public void test2(){
        String str="2[a]2[a3[bc]]";
        String output="aaabcbcbcabcbcbc";
        Assert.assertEquals(decodeString(str),output);
    }

    public String decodeString(String input) {
        if(!input.contains("]")) return input;
        String output ="";// digit ="";
        int number= 0, count=1;
        int firstClosingIndex =input.indexOf(']');
        int lastOpenIndex =input.substring(0, firstClosingIndex).lastIndexOf('[');
        String substring = input.substring(lastOpenIndex+1,firstClosingIndex);
        while(lastOpenIndex-count>=0 && Character.isDigit(input.charAt(lastOpenIndex-count))) {
            number = Character.isDigit(input.charAt(lastOpenIndex-count)) ? Character.getNumericValue(input.charAt(lastOpenIndex-1)):1;
          //  digit= input.substring(lastOpenIndex-count,lastOpenIndex);
            count++;
        }
      //  number=Integer.parseInt(digit);
      //  lastOpenIndex=lastOpenIndex-count+2;

        while(number>0){
            output+=substring;
            number--;
        }
        input=input.substring(0,lastOpenIndex-1)+output+input.substring(firstClosingIndex+1);

        return decodeString(input);


    }
}
