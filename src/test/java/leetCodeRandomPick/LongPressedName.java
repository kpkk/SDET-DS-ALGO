package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

public class LongPressedName {

    @Test
    public void test1(){
        String name="rick";
        String typed="kric";
        Assert.assertFalse(isLongPressedName(name,typed));
    }
    @Test
    public void test2(){
        String name="alex";
        String typed="aaleexa";
        Assert.assertFalse(isLongPressedName(name,typed));
    }
    @Test
    public void test3(){
        String name="alex";
        String typed="aaleexa";
        Assert.assertFalse(isLongPressedName(name,typed));
    }

    public boolean isLongPressedName(String name, String typed) {
        int p1=0, p2=0;
        if(typed.length()<name.length()) return false;
        while(p2<typed.length()){
            if(name.charAt(p1)==typed.charAt(p2)){
                if(p1==name.length()-1 && p2==typed.length()-1) return true;
                else if(p1==name.length()-1 && p2<typed.length()-1) {
                    while (p2<typed.length()){
                        if(typed.charAt(p2)==typed.charAt(p2+1)){
                            break;
                        }
                    }
                    return true;

                }
                p1++;
                p2++;

            }else{
                p2++;
            }
        }
        return false;

    }
}
