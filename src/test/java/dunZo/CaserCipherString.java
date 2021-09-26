package dunZo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CaserCipherString {
    /*

Input - string , list
Output — string

*/
    @Test
    public void test1(){
        String s="abc";
        List<String> list = Arrays.asList("0 0 L", "2 2 L", "0 2 R");
        Assert.assertEquals(cipherString(s,list),"acc");
    }
    /*
    Pseudo code:-
1. Iterate the list strings, get the each string then split by space
2. Get the last index char of the string to know the operation
3. Then get the substring from the main string from I too j the index
4. Based on operation modify the string
5. Return the string

     */

    private String cipherString(String s,List<String>list) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split("\\s");
            if (split[2].equals('L' + "")) {
                for (int j = Integer.parseInt(split[0] + ""); j<=Integer.parseInt(split[1] + ""); j++) {
                    char c = sb.charAt(j);
                    if (c == 'a') sb.setCharAt(j, 'z');
                    else {
                        int ascii=c;
                        sb.setCharAt(j, (char)--ascii);
                    }
                }
            } else {
                for (int j = Integer.parseInt(split[0] + ""); j<= Integer.parseInt(split[1] + ""); j++) {
                    char c = sb.charAt(j);
                    if (c == 'z') sb.setCharAt(j, 'a');
                    else{
                        int ascii=c;
                        sb.setCharAt(j, (char)++ascii);
                    }
                }
            }
        }
        return sb.toString();
    }
}
