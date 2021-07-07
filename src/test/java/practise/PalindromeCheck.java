package practise;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeCheck {

    //  121, -2147483647, 2147483647, 2147483648

    @Test
    public void test1() {
        int n = 2147483647;
        Assert.assertTrue(palindrome(n));
        //  Assert.assertTrue(checkPalindrome(n));
        //  Assert.assertTrue(checkPalindromusingUsingString(n));

    }

    @Test
    public void test2() {
        int n = 1765;
        // Assert.assertFalse(checkPalindrome(n));
        Assert.assertFalse(palindrome(n));
       // Assert.assertFalse(checkPalindromusingUsingString(n));
    }

    //997799
    @Test
    public void test3() {
        int n = 00100;
        //  Assert.assertTrue(checkPalindrome(n));
        Assert.assertTrue(palindrome(n));
        //  Assert.assertTrue(checkPalindromusingUsingString(n));
    }

    //010
    // biggest palindrome that exists in integer range
    @Test
    public void test4() {
        int n = -1765;
        // Assert.assertFalse(checkPalindrome(n));
        Assert.assertFalse(palindrome(n));
        //   Assert.assertFalse(checkPalindromusingUsingString(n));
    }

    @Test
    public void test5() {
        int n = 997799;
        // Assert.assertTrue(checkPalindrome(n));
        Assert.assertTrue(palindrome(n));
        //   Assert.assertTrue(checkPalindromusingUsingString(n));
    }

    @Test
    public void test6() {
        int n = 4;
        // Assert.assertTrue(checkPalindrome(n));
        Assert.assertTrue(palindrome(n));
        // Assert.assertTrue(checkPalindromusingUsingString(n));
    }


    public boolean palindrome(int n) {
        int neg = -1;
        int div = 1;
        if (n < 0)
            n *= neg;
        if (n > 0 && n < 10)
            return true;
        while (n / div >= 10) {
            div *= 10;
        }
        while (n > 0) {
            int left = n / div;
            int right = n % 10;
            if (left != right) return false;
            n = (n % div) / 10;
            div = div / 100;
        }
        return true;

    }
}
