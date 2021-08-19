package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;
import sun.awt.image.IntegerInterleavedRaster;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class UnifromString {

    /*
    Time taken:-
    Understand problem: 10 mins
    Pseudo code:- 45 mins
    coding:- 15 mins (not working initially)
    debugging/fixing errors:- 30 mins

    issues I had:-
    - Pseudo code was close enough, but wasn't able to think through the breaking conditions
    - Initially the sum value is not reset at the right place, so understood that during debug handled
    - Used wrong argument to check if the key present in map, complete oversight  - took time to debug and fix
    - didn't handle the case when right reached length initially, during debug understood that and handled

    Solution:-
    - Initialize an output array of boolean type of values length
    - Initialize a hashmap with integer as key(target_values) and index of target values as value
    - initialize two pointers left=0, right=0
    - convert the string into char array
    - check if the value of the sum of char at right index is present in map
        - if yes, get the value of that key and flip the output array value as true for that index
            - increment right to see, if the next character comes satisfies the uniform string
                - if yes, repeat above two steps else, make left=right
        - if no, increment right, check if char[left]==char[right]
             - increment right to see, if the next character comes satisfies the uniform string
                - if yes, repeat above two steps, else, make left=right
        - if yes, update the sum and check if the sum is present in map, then update in output array
         - if no, increment left and make right=left

    - return the output array
     */
    // coding: 9:47
    @Test
    public void test1() {
        String s = "abbccaadf";
        int[] targetValues = {4, 2, 5, 3, 7};
        boolean[] output = {true, true, false, true, false};
        Assert.assertTrue(Arrays.equals(findTargetValues(s, targetValues), output));
    }

    private boolean[] findTargetValues(String s, int[] targetValues) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] output = new boolean[targetValues.length];
        int left = 0, right = 0;
        // convert the string into char array
        char[] chars = s.toCharArray();
        // load all the target values and thier indices
        for (int i = 0; i < targetValues.length; i++)
            map.put(targetValues[i], i);

        // breaking condition
        while (right < chars.length) {
            // sum needs to be declared here, else it will not reset as required
            int sum = 0;
            char c = chars[right];
            // to get the mapping value as per problem statement (a=1, b=2, c=3)
            sum += (int) (c - 'a')+1; //96;
            if (map.containsKey(sum)) {
                // change the target value index to true
                output[map.get(sum)] = true;
                // condition to handle the case , when right is staying at the last index (other wise ArrayIndexOutOfBoundException be thrown)
                if (right == chars.length - 1) break;
                right++;
                // slide the window, check if the uniform string rule applicable
                while (chars[left] == chars[right]) {
                    int c1 = (int) chars[right] - 96;
                    sum += c1;
                    if (map.containsKey(sum))
                        output[map.get(sum)] = true;
                    right++;
                }
                //move the left value, once the unifomr string rule breaks
                left = right;
            } else {
                if (right == chars.length - 1)
                    break;
                right++;
                while (chars[left] == chars[right]) {
                    int c1 = (int) chars[right] - 96;
                    sum += c1;
                    if (map.containsKey(sum)) output[map.get(sum)] = true;
                    right++;
                }
                left = right;
            }
        }
        return output;
    }
}
