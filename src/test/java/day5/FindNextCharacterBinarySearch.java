package day5;

import com.sun.tools.javac.code.Attribute;
import org.junit.Assert;
import org.junit.Test;

public class FindNextCharacterBinarySearch {

    /*

    Given a sorted character array and the target find the character, find the next character
    char ch={'b','d','h'} char c=e
     */

    @Test
    public void test1() {
        char[] ch = {'b', 'd', 'h'};
        char c = 'e';
        Assert.assertEquals(findCharusingBinarySearch(ch, c), 'h');
    }

    @Test
    public void test2() {
        char[] ch = {'a', 'b', 'c', 'd', 'e'};
        char c = 'd';
        Assert.assertEquals(findCharusingBinarySearch(ch, c), 'e');
    }

    @Test
    public void test3() {
        char[] ch = {'b', 'd', 'h'};
        char c = 'h';
        Assert.assertEquals(findCharusingBinarySearch(ch, c), ' ');
    }

    @Test
    public void test4() {
        char[] ch = {'d', 'l', 'm'};
        char c = 'e';
        Assert.assertEquals(findCharusingBinarySearch(ch, c), 'l');
    }

    @Test
    public void test5() {
        char[] ch = {'a', 'b', 'd', 'l', 'm', 'p', 'z'};
        char c = 'c';
        Assert.assertEquals(findCharusingBinarySearch(ch, c), 'd');
    }

    /*
    Approach- Binary search
    Time complexity- O(logn)
    Space complexity- O(1)

    Solution:-

    -  Initialize variables low=0, mid=ch.length-1
    -  If the last character in the array is matching the character then throw an exception
    -  If the given character is lesser than the first character then return the first character
    - While low less than or equals high
        - compute mid value
        - if char at mid is matching w/ given char and is at the end return ch[mid+1]
        - if char at mid is greater than given char and is less than char at mid-1 then return mid
        - If the char at mid is greater than c then set high as mid-1
        - If the char at mid is less than c then set low as mid+1
     - return empty char i the end
     */
    private char findCharusingBinarySearch(char[] ch, char c) {
        int low = 0, high = ch.length - 1, mid = 0;
        if (c == ch[ch.length - 1]) throw new RuntimeException("No next greater character available");
        if (c < ch[0]) return ch[0];
        while (low <= high) {
            mid = (low + high) / 2;
            if (ch[mid] == c && mid != ch.length - 1) return ch[mid + 1];
             if (ch[mid] > c && ch[mid - 1] < c) return ch[mid];
             if (ch[mid] > c) high = mid - 1;
            else low = mid + 1;

        }
        return ' ';
    }
}
