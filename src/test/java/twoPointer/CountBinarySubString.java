package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class CountBinarySubString {

    /*
    Count Binary Substrings
    Give a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.



Example 1:

Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:

Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.


Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
     */
    @Test
    public void test1(){
        String s="00110011";
        Assert.assertEquals(groupBinaryStringTwoPointer(s),6);
    }
    @Test
    public void test2(){
        String s="10101";
        Assert.assertEquals(groupBinaryStringTwoPointer(s),4);
    }

    /*
    Solution:-
    - create an int array of string size
    - fill the positions with the count of same group of elements
    - first element will join its own group, if the current number doesn't matches with the previous number then it adds up to a new group
    - then initialize a variable called count=0
    - iterate the array from index-1 add the min value to count
    - return count
     */
    private int findgroupSubStrings(String s) {
        int count=0, index=0;
        int[] group=new int[s.length()];
        group[0]=1;
        for (int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)) group[++index]=1;
            else group[index]++;
        }
        for (int i=1;i<group.length;i++){
            count+=Math.min(group[i],group[i-1]);
        }
        return count;
    }

    private int groupBinaryStringTwoPointer(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            int left=i,right=i+1;
            while (left>=0 && right<s.length() && s.charAt(left)=='0' && s.charAt(right)=='1'){
                count++;
                left--;
                right++;
            }
            left=i; right=i+1;
            while (left>=0 && right<s.length() && s.charAt(left)=='1' && s.charAt(right)=='0'){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
