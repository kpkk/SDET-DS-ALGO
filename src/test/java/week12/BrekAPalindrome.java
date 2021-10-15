package week12;

import org.junit.Assert;
import org.junit.Test;

public class BrekAPalindrome {

    @Test
    public void test1() {
        String s = "aaa";
        Assert.assertEquals(breakPalindrome(s), "");
    }

    public String breakPalindrome(String palindrome) {
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (chars[i] > 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        chars[chars.length - 1] = 'b';
        return chars.length <= 1 ? "" : String.valueOf(chars);
    }
}
