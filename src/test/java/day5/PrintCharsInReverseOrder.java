package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class PrintCharsInReverseOrder {
    /*

    1) Given an array of characters, print the unique characters in reverse order
     */
    @Test
    public void test1() {
        char[] ch = {'a', 'b', 'b', 'e', 'e', 'e', 'g'};
        char[] unique = {'g', 'a'};
        Assert.assertTrue(Arrays.equals(reverseUniqueCharacters(ch), unique));
    }

    @Test
    public void test2() {
        char[] ch = {'a', 'b', 'g'};
        char[] unique = {'g', 'b', 'a'};
        Assert.assertTrue(Arrays.equals(returnCharsInRevOrder(ch), unique));
    }

    @Test
    public void test3() {
        char[] ch = {};
        char[] unique = {};
        Assert.assertTrue(Arrays.equals(reverseUniqueCharacters(ch), unique));
    }

    @Test
    public void test4() {
        char[] ch = {'a', 'a', 'a', 'a'};
        char[] unique = {};
        Assert.assertTrue(Arrays.equals(reverseUniqueCharacters(ch), unique));
    }

    /*
    Approach- brute force
    Time complexity- O(n)
    Space complexity - O(n)

    Solution:-
     - initialize two ArrayLists uniqueList, dupList and  int variable index=0
     - Traverse through the array from start till the end
     - If the character doesn't contain in the uniqueList, dupList then add that to uniqueList
     - If the character present in either of the lists, then remove from uniqueList and add to dupList
     - Create a temp array uniqueChars to copy the unique elements
     - Then add the uniqueList elements in reverse order to the array
     - return the array

     */
    private char[] reverseUniqueCharacters(char[] ch) {

        if (ch.length == 0) return new char[]{};
        int index = 0;
        ArrayList<Character> uniqueList = new ArrayList<>();
        ArrayList<Character> dupList = new ArrayList<>();
        for (char c : ch) {
            if (uniqueList.contains(c) || dupList.contains(c)) {
                uniqueList.remove((Character) c);
                dupList.add(c);
            } else uniqueList.add(c);

        }
        char[] uniquechars = new char[uniqueList.size()];
        for (int i = uniqueList.size() - 1; i >= 0; i--)
            uniquechars[index++] = uniqueList.get(i);


        return uniquechars;
    }

    private char[] returnCharsInRevOrder(char[] ch) {
        int[] ascii = new int[128];
        String str = "";
        int left = 0, right = ch.length - 1;
        while (left <= right) {
            if (left == right) {
                ascii[ch[left++]]++;
            } else {
                ascii[ch[left++]]++;
                ascii[ch[right--]]++;
            }
        }
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ascii[ch[i]] == 1) {
                str += ch[i];
            }
        }
        return str.toCharArray();
    }
}
