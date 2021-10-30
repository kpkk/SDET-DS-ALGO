package week12;

import org.junit.Assert;
import org.junit.Test;

public class SortArray {

    @Test
    public void test1(){
        String s="face";
        Assert.assertEquals(sortString(s),"acef");
    }
    private String sortString(String s) {
        char[] chars = s.toCharArray();

        for (int i=0;i<chars.length;i++){
            for (int j=i+1;j<chars.length;j++){
                if(chars[i]>chars[j]){
                    char temp=chars[i];
                    chars[i]=chars[j];
                    chars[j]=temp;
                }
            }
        }
        return String.valueOf(chars);
    }
}
