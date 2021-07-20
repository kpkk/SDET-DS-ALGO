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
        char[] ch = {'b', 'b', 'h'};
        char c = 'h';
        Assert.assertEquals(findCharusingBinarySearch(ch, c), 'e');
    }
    @Test
    public void test4() {
        char[] ch = {'k', 'l', 'm'};
        char c = 'e';
        Assert.assertEquals(findCharusingBinarySearch(ch, c), 'e');
    }

    private char findCharusingBinarySearch(char[] ch, char c) {
        int low = 0, high = ch.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (ch[mid] == c && ch[mid]<ch.length-1) return ch[mid + 1];
            if (ch[mid] > c && ch[mid] < c) return ch[mid];
            else if (ch[mid] < c) low = mid + 1;

        }
        return ch[mid];
    }
}
