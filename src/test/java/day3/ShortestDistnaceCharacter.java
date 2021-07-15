package day3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ShortestDistnaceCharacter {

    /*

    Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.



Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 3.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]


Constraints:

1 <= s.length <= 104
s[i] and c are lowercase English letters.
It is guaranteed that c occurs at least once in s.
     */


    @Test
    public void test1() {
        String s = "loveleetcode";
        char c = 'e';
        Assert.assertTrue(Arrays.equals(closestOccurrenceOfChar2(s, c), new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}));

    }
    @Test
    public void test2() {
        String s = "aaab";
        char c = 'b';
        Assert.assertTrue(Arrays.equals(closestOccurrenceOfChar2(s, c), new int[]{3, 2, 1, 0}));

    }
    @Test
    public void test3() {
        String s = "abaa";
        char c = 'b';
        Assert.assertTrue(Arrays.equals(closestOccurrenceOfChar2(s, c), new int[]{1,0,1,2}));

    }
    @Test
    public void test7() {
        String s = "bbbbbb";
        char c = 'b';
        Assert.assertTrue(Arrays.equals(closestOccurrenceOfChar2(s, c), new int[]{0,0,0,0,0,0}));

    }

    /*
    Solution:
    1. If the input s.length== 1 & character is c return array with value {0}
    2. Initialize an integer array  answer,  int a variable min=Integer.MAX_VALUE
    3. Convert the string into a character array
    4. Traverse through the char array from start index=0
           - if character at index i is c then set the answer index as 0, continue
    5.  Traverse the array(inner loop ) from j=0
    6. If the char[j]==c then calculate the absolute difference -->Math.abs(j-i)
            - find the minimum distance between the current index and closest char index--> using Math.min()
    7. set the min value to the answer[i],
    8. Repeat steps fro 4-7 ,finally return the answer array.
     */


    // Time complexity- O(n^2)
    //Space complexity- O(n)
    private int[] closestOccurrenceOfChar(String s, char c) {

        if(s.length()==1 && s.charAt(0)==c) return new int[]{0};
        char[] chars = s.toCharArray();
        int[] answer = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int min = Integer.MAX_VALUE;
            if (chars[i] == c) continue;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c)
                    min = Math.min(Math.abs(j - i), min);
            }
            answer[i] = min;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }


     /*

    Solution:-
    1. Initialize an arrayList to hold the occurrences of character, an integer array ->answer[]
    2. Traverse through the character array(input string), get the index of the character and store in list
    3. Traverse the array using for loop
    4. inside the for loop traverse through the list and calculate the difference between the current index and all the array elements
          - find the min difference and set it as final index
    5. Finally return the answer array array
     */

    // Time complexity- O(n)+ O(n^2)-->O(n^2)
    //space complexity- O(n)
    private int[] closestOccurrenceOfChar2(String s, char c) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) list.add(i);
        }
        Integer previousIndex = list.remove(0);
        int currentIndex=previousIndex;
        for (int i = 0; i < chars.length; i++) {
            int min = Integer.MAX_VALUE;
            if(i>previousIndex && !list.isEmpty()){

                currentIndex= list.remove(0);
            }
            Iterator<Integer> iterator = list.iterator();
          /*  while (iterator.hasNext()){
                Integer next = iterator.next();
                min = Math.min(Math.abs(i - next),min);
            }*/
            answer[i] = min;
        }
        return answer;
    }

    /*
    Two pointer solution:-
    1. Convert the string into a character array
    2.initialize two pointers start=0, start=0 and initialize an integer array of input string length
    3. while start<chars.length
        - if start==c , if yes then set the answer[start]==0 and start++, end=0
        - if end==c, calculate the difference between end-start--> Math.abs() and reset start=0
        - determine the min difference and set the answer[i]
    4. return the answer array

     */

    @Test
    public void test4() {
        String s = "loveleetcode";
        char c = 'e';
        Assert.assertTrue(Arrays.equals(closestCharusingtwoPassApproach(s, c), new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}));

    }
    @Test
    public void test5() {
        String s = "welcome";
        char c = 'e';
        Assert.assertTrue(Arrays.equals(closetCharUsingTwoPointer(s, c), new int[]{1,0,1,2,2,1,0}));

    }
    @Test
    public void test6() {
        String s = "abaa";
        char c = 'b';
        Assert.assertTrue(Arrays.equals(closetCharUsingTwoPointer(s, c), new int[]{1,0,1,2}));

    }

    /*
    Solution:-
    1. Initialize an integer array os string length size
    2. Initialize pointer variables start=0, end=0, min=0 and lastFoundIndex=0
    3. if the character at start index is is c then  start++
    4. If the character at end index is c && end>start
            - set the variable lasFoundIndex with end index
            - calculate the min distance between the start index to the current end index and lastFound index -->(Math.min, Math.abs)
            - which ever is min set in the answer[start]
     5. increment end (end++),f 3,4 doesn't match
     6. return the anser array

     */

    // Time complexity- O(n)
    //Space complexity- O(n)
    private int[] closetCharUsingTwoPointer(String s, char c){
        if(s.length()==1 && s.charAt(0)==c) return new int[]{0};
        int[] answer=new int[s.length()];
        int start=0, end=0, min=0, lastFoundIndex=0;
        char[] chars = s.toCharArray();
        while (start<s.length() && end<s.length()){
            if (chars[start]==c) {
                start++;
            }
            else if(chars[end]==c && end>start) {
                    lastFoundIndex = end;
                min = Math.min(Math.abs(start - end), Math.abs(lastFoundIndex - start));
                answer[start] = min;
                start++;
                if (end < start) end++;
            }else{
                end++;
            }
            }
        System.out.println(Arrays.toString(answer));
        return answer;
        }

        private int[] closestCharusingtwoPassApproach(String s, char c){

        int prevCount=s.length();
        int[] answer=new int[s.length()];
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)==c) prevCount=0;
            answer[i]=prevCount++;
        }
        prevCount=s.length();
        for (int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==c) prevCount=0;
            answer[i]=Math.min(answer[i],prevCount++);
        }
            System.out.println(Arrays.toString(answer));
        return answer;
        }

    }
