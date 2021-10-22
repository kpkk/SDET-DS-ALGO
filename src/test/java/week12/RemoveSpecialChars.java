package week12;

import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

public class RemoveSpecialChars {

    @Test
    public void test1(){
        String s="";
        Assert.assertEquals(removeSpecialChars("asdfdsfs&*%"),"asdfdsfs");
    }

    public String removeSpecialChars(String s){

        String output="";
        char[] chars = s.toCharArray();
        for (char ch:chars){
            if(Character.isAlphabetic(ch))
            output+=ch;
        }
return output;
    }
}
