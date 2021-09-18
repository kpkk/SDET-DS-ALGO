package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInSentence {
    /*
    Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"


Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
     */
    @Test
    public void test1() {
        String s = "Let's take LeetCode contest";
        Assert.assertEquals(reverseWords(s), "s'teL ekat edoCteeL tsetnoc");
    }

    @Test
    public void test2() {
        String s = "God Ding";
        Assert.assertEquals(reverseWords(s), "doG gniD");
    }

    private String reverseWords(String s) {
        int i = 0, j = 0;
        char[] ch = s.toCharArray();
        while (j < s.length()) {
            while (i < j || i < s.length() && ch[i] == ' ') {
                i++;
            }
            while (j < i || j < s.length() && ch[j] != ' ') {
                j++;
            }
            int left = i, right = j - 1;
            while (left <=right) {
                char c = ch[left];
                ch[left++] = ch[right];
                ch[right--] = c;
            }
        }
        return new String(ch);
    }
}
