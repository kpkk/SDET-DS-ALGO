package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class DecodeAstring {
    /*
    Given an encoded string, decode into a word
    Example:- String input= "2[a3[bc]]", output= abcbcbcabcbcbc
     */

    @Test
    public void test1() {
        String input = "2[a3[bc]]";
        Assert.assertEquals(decodeString(input), "abcbcbcabcbcbc");
    }

    @Test
    public void test2() {
        String input = "3[[bc]]";
        Assert.assertEquals(decodeString(input), "bcbcbc");
    }

    @Test
    public void test3() {
        String input = "aa";
        Assert.assertEquals(decodeString(input), "aa");
    }

    /*
    Approach:- using stack and arrayList
    Solution:-
    - Initialize a stack of character type
    - convert the string into char array
    - iterate the array from start index until end
    - keep pushing the characters until the end bracket is met
    - when the char at index is ']' start popping the chars until the first '[' is met into an array list
    - ignore the [ bracket and validate if the previous character is a digit
    - get numeric value and concatenate the string with same strings the times of the digit value
    - push the concatenated string back into stack
    - then pop all of them into a string buffer and reverse then return

     */
    private String decodeString(String input) {
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                ArrayList<Character> list = new ArrayList<>();
                while (stack.peek() != '[') {
                    list.add(stack.pop());
                }
                stack.pop();
                int k = 1;
                if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = Character.getNumericValue(stack.pop());
                }
                while (k > 0) {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        stack.push(list.get(i));
                    }
                    k--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
