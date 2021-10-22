package week12;

import org.junit.Assert;
import org.junit.Test;

public class FindOccurrenceOfAdjacentCharacters {

    @Test
    public void test1() {
        String input = "wwwaaaabbbcdwa";
        Assert.assertEquals(findAdjacentOccrences(input), "w3a4b3c1d1w1a1");
    }

    @Test
    public void test2() {
        String input = "wwwaaaabbbcdww";
        Assert.assertEquals(findAdjacentOccrences(input), "w3a4b3c1d1w2");
    }

    @Test
    public void test3() {
        String input = "aaaaaa";
        Assert.assertEquals(findAdjacentOccrences(input), "a6");
    }

    @Test
    public void test4() {
        String input = "abc";
        Assert.assertEquals(findAdjacentOccrences(input), "a1b1c1");
    }

    /*
    input- String
    output- string
    test data- abcd, ""

    Pseudo code:-
    - initialize two pointer left, right=0 and a string variable output=""
    - while right reaches length
    -  check if the character at left index and right index are same
        - if same keep moving the right alone
        - else, read the character at left position and calculate the distance between right and left
     - append to a string and return


     */

    private String findAdjacentOccrences(String input) {

        String output = "";
        int left = 0, right = 0;
        while (right < input.length()) {
            int count = 0;
            while (right < input.length() && input.charAt(left) == input.charAt(right)) {
                right++;
                count++;
            }
            if (right < input.length() && input.charAt(left) != input.charAt(right)) {
                char c = input.charAt(left);
                output += c + "" + count;
                left = right;
            }
            if (right == input.length()) {
                char c = input.charAt(left);
                output += c + "" + count;
                break;
            }

        }
        return output;
    }
}
