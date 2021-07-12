package day3;

import org.junit.Test;

public class NiceString {

    /*
    A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.



Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
Example 4:

Input: s = "dDzeE"
Output: "dD"
Explanation: Both "dD" and "eE" are the longest nice substrings.
As there are multiple longest nice substrings, return "dD" since it occurs earlier.


Constraints:

1 <= s.length <= 100
s consists of uppercase and lowercase English letters.

Solution:-
 1. Initialize two pointers start=0, end=1, substringLength=0, subStringStart=s, subStringEnd
 2. Repeat the below end<=length-1
    compare start and end value (using charAt)  case
    if yes,
        end++  (increment end by one)
    if No,
        subStringStart=start and subStringEnd=end
        compare substringLength and ((end-start)-1) store the max (Math.max)
        start=end, end=end+1
3. return the substring subStringEnd-substringstart


     */

    @Test
    public void test1() {
        String s = "YazaAay";
        String output = "aAa";
        String s1 = niceString(s);
        System.out.println(s1);

    }

    @Test
    public void test2() {
        String s = "Bb";
        String output = "Bb";
        String s1 = niceString(s);
        System.out.println(s1);

    }

    @Test
    public void test3() {
        String s = "c";
        String output = "";
        String s1 = niceString(s);
        System.out.println(s1);

    }

    @Test
    public void test4() {
        String s = "dDzeE";
        String output = "dD";
        String s1 = niceString(s);
        System.out.println(s1);

    }

    @Test
    public void test5() {
        String s = "yzdaaAAbcaAA";
        String output = "aaAA";
        String s1 = niceString(s);
        System.out.println(s1);

    }

    @Test
    public void test6() {
        String s = "aAabaA";
        String output = "aAa";
        String s1 = niceString(s);
        System.out.println(s1);

    }

    private String niceString(String s) {

        int start = 0, end = 1, substringLength = 1, subStringStart = 0, subStringEnd = 0;
        char firstChar = ' ';

        if (s.length() == 2) {
            if (s.charAt(start) == s.charAt(end) || s.toLowerCase().charAt(start) == s.charAt(end) || s.charAt(start) == s.toLowerCase().charAt(end))
                return s;
        }

        while (end < s.length()) {
            if (s.toLowerCase().charAt(start) == s.toLowerCase().charAt(end)) end++;
            else {
                //yzdaaAAbcaAA z-4, y-3
                //01234567891011  aAabbaA
                if (substringLength < (end - start)) {
                    int asciiValue = (int) s.charAt(start);

                    // aaa ,AAA,aAa, AaA, aAAbB, aAAbb
                    if (97 <= asciiValue && asciiValue <= 122) firstChar = s.toUpperCase().charAt(start);
                    else firstChar = s.toLowerCase().charAt(start);

                    if (s.substring(start + 1, end).contains(firstChar + "")) {
                        subStringStart = start;
                        subStringEnd = end;
                        substringLength = subStringEnd - subStringStart;
                    }


                }
                start = end;
                end += 1;


            }
        }
        System.out.println(s.substring(subStringStart, subStringEnd));
        return s.substring(subStringStart, subStringEnd);

    }
/*

  if (s.charAt(start) == s.charAt(end) || s.toLowerCase().charAt(start) == s.charAt(end) || s.charAt(start) == s.toLowerCase().charAt(end))
 */


/*
	Given an array of integers and an integer k, find out whether there are two
	distinct indices i and j in the array such that nums[i] = nums[j]
	and the absolute difference between i and j is at most k.
	Example 1:
	Input: nums = [1,2,3,1], k = 3
	Output: true
	Example 2:
	Input: nums = [1,0,1,1], k = 1
	Output: true
	Example 3:
	Input: nums = [1,2,3,1,2,3], k = 2
	Output: false
	Example 3:
	Input: nums = [1,2,3,2,2,3], k = 2
	Output: true
*/


}
