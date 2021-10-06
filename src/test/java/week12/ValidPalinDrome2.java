package week12;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalinDrome2 {

    @Test
    public void test1(){
        String s="aba";
        Assert.assertEquals(ispalindrome(s),true);
    }
    @Test
    public void test2(){
        String s="tebbem";
        Assert.assertEquals(ispalindrome(s),false);
    }
    @Test
    public void test3(){
        String s="abca";
        Assert.assertEquals(ispalindrome(s),true);
    }

    private boolean ispalindrome(String s) {
        int left=0, right=s.length()-1;
        while (left<right && s.charAt(left)==s.charAt(right)){
            left++;
            right--;
        }
        if(left>=right)return true;
        if(ispalin(s,left+1,right)|| ispalin(s,left,right-1))return true;
        return false;
    }
    private boolean ispalin(String s, int left, int right){
        while (left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }


}
