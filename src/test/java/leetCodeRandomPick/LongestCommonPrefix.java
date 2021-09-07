package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonPrefix {

    /*
    14. Longest Common Prefix
    Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
     */

    @Test
    public void test1() {
        String[] input = {"flower", "flow", "flight"};
        Assert.assertEquals(longestCommonPrefix(input), "fl");
    }

    @Test
    public void test2() {
        String[] input = {"flower", "flower", "flower"};
        Assert.assertEquals(longestCommonPrefix(input), "flower");
    }

    @Test
    public void test3() {
        String[] input = {"a", "aca", "accb", "b"};
        Assert.assertEquals(longestCommonPrefix(input), "");
    }
    @Test
    public void test4() {
        String[] input = {"caa", "", "a", "acb"};
        Assert.assertEquals(longestCommonPrefix(input), "");
    }
    @Test
    public void test5() {
        String[] input = {"ca", "c", "bba", "bacb","bcb"};
        Assert.assertEquals(longestCommonPrefix(input), "");
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /*
    - initialize three strings output, prevSubString, tempString
    - iterate the array from start index until the end
    - get the strings ate the indices i, i+1 then convert them into character array
    - initialize two pointers, p1=0, p2=0
    - compare the character at index p1, p2 from both char arrays
        - keep moving the pointers as ling as they match
        - when they don;t match anymore get the substring until the index
        - append that to the prev string and output string for the first time
        - from next iterations compare the length of the prev substring with current substring, consider the minimum one
    - return the outputstring
     */
    public String longestCommonPrefix1(String[] strs) {
        String outputStr = "", prevStr = "";
        if(strs.length==1) return strs[0];
        for (int i = 0; i < strs.length-1; i++) {
            char[] s1 = strs[i].toCharArray();
            char[] s2 = strs[i + 1].toCharArray();
            if(s1.length ==0 || s2.length==0) return "";
            int p1 = 0, p2 = 0;
            StringBuilder sb = new StringBuilder();
            while (p1 < s1.length && p2 < s2.length) {
                if (s1[p1] == s2[p2]) {
                    sb.append(s1[p1]);
                }
                else {
                    if (i == 0 && sb.length() == 0) return "";
                    else if (i == 0) {
                        prevStr = sb.toString();
                        outputStr = sb.toString();
                        break;
                    } else {
                        if (sb.length() < outputStr.length()) {
                            if (sb.toString().equals(outputStr.substring(0, sb.length()))) {
                                outputStr = outputStr;
                                prevStr = prevStr;
                                break;
                            }
                        }
                        else if(sb.length()==outputStr.length()){
                            if(!sb.toString().equals(outputStr))return "";
                            else break;
                        }
                        else {
                            if (outputStr.equals(sb.toString().substring(0, outputStr.length()))) {
                                outputStr = sb.reverse().toString();
                                prevStr = sb.reverse().toString();
                                break;
                            }
                        }
                    }
                }
                p1++;
                p2++;
            }
            if(!sb.toString().isEmpty()){
                prevStr = sb.toString();
                outputStr = sb.toString();
            }
            if(sb.length()==outputStr.length() && sb.toString().equals(outputStr)) return "";




        }
        return outputStr;

    }
}

/*
  if(strs.length==1) return strs[0];
        String output="";
        for(int i=0;i<strs.length-1;i++){
            StringBuilder sb=new StringBuilder();
            int p1=0, p2=0;
            char[] s1=strs[i].toCharArray();
            char[]s2=strs[i+1].toCharArray();
            while(p1<s1.length && p2<s2.length){
                if(s1[p1]==s2[p2]){
                    sb.insert(0,s1[p1]);
                }else{
                    if(output.length()!=0 && sb.length()<output.length()){
                        output=sb.toString();
                        break;
                    }
                    else if(output.length()==0) {
                        output=sb.toString();
                        break;
                    }
                }
                p1++;
                p2++;
            }
            output=sb.reverse().toString();
            if(output.isEmpty()) return "";
        }
        return output;

 */