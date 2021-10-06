package week12;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindrome {

    @Test
    public void test1(){
        String s="A man, a plan, a canal: Panama";
        Assert.assertEquals(isPalindrome(s),true);
    }
    @Test
    public void test2(){
        String s="race a car";
        Assert.assertEquals(isPalindrome(s),false);
    }

    public boolean isPalindrome(String s) {
        char[] ch= s.toLowerCase().toCharArray();
        int left=0, right=ch.length-1;
        while(left<=right){
            if(Character.isLetterOrDigit(ch[left]) && Character.isLetterOrDigit(ch[right])){
                if(ch[left]==ch[right]){
                    left++;
                    right--;
                }else{
                    return false;
                }
            }else if(!Character.isLetterOrDigit(ch[left])) left++;
            else if(!Character.isLetterOrDigit(ch[right]))right--;
        }
        return true;
    }
}
