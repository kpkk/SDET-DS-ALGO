package practise;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class palindromeString {

    /*
    given a string determine whether its a palindrome or not
    A man, a plan, a canal: Panama
     */

    @Test
    public void test1(){
        String s="A man, a plan, a canal: Panama";
      //  boolean result=false;
        Assert.assertTrue(palindromeCheck(s));
    }
    @Test
    public void test2(){
        String s="race a car";
        Assert.assertFalse(palindromeCheck(s));
    }

    private boolean palindromeCheck(String str){
        if(str.length()==0) throw new RuntimeException("empty string");
        if(str.length()==1) return true;

        int left=0, right=str.length()-1;
        while (left<=right){
            if(Character.isAlphabetic(str.charAt(left)) && Character.isAlphabetic(str.charAt(right))){
                if(str.toLowerCase().charAt(left)==str.toLowerCase().charAt(right)) {
                    left++;
                    right--;
                }
                else return false;

            }else if(!Character.isAlphabetic(str.charAt(left)))left++;
            else right--;

        }
        return true;
    }

    @Test
    public void test(){
        String s="race a car";
        Assert.assertEquals(reverseString(s),"rac a ecar");
    }

    private String reverseString(String str){
        if(str.length()==0) return "";
        if(str.length()==1) return str;
        int left=0, right= str.length()-1;
        char[] chars = str.toCharArray();
        while (left<=right){
           /* if(!Character.isLetterOrDigit(str.charAt(left))) left++;
            else if(!Character.isLetterOrDigit(str.charAt(right)))right--;*/

         //   if(Character.isLetterOrDigit(str.charAt(left))&&Character.isLetterOrDigit(str.charAt(right))){
                char temp=chars[left];
                chars[left++]=chars[right];
                chars[right--]=temp;
          //  }
        }
        return String.valueOf(chars);
    }
}
