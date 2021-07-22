package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AppendOccurrencesOfCharToString {

    /*
    given a string containing only alphabets ex=aabbccddde , return -->a2b2c2d3e1
     */

    @Test
    public void test1() {
        String s = "aabbccddde";
        String output = "a2b2c2d3e1";
        Assert.assertEquals(AppendOccurrences(s), output);
    }

    @Test
    public void test2() {
        String s = "";
        String output = "";
        Assert.assertEquals(AppendOccurrences(s), output);
    }

    @Test
    public void test3() {
        String s = "a";
        String output = "a1";
        Assert.assertEquals(AppendOccurrences(s), output);
    }

    /*
    Approach- using hasMap
    Time complexity- O(n)
    Space complexity- O(n)

    Solution:-
    - Initialize a hashMap with character as key and occurrence as value, an empty String output=""
    - Traverse through string and put them in map
    - Iterate the map and append the key and value to the string and return

     */
    private String AppendOccurrences(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        String output = "";
        if (s.length() == 0) return output;
        if (s.length() == 1) return output += s + "1";
        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry eachEntry : entries)
            output += eachEntry.getKey() + String.valueOf(eachEntry.getValue());
        return output;


    }
}
