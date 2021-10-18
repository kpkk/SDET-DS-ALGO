package week4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class WordDictionaryProblem {
    /*

    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 Note that the same word in the dictionary may be reused multiple times in the segmentation.
  
 Example 1:
 Input: s = "leetcode", wordDict = ["leet","code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:
 Input: s = "applepenapple", wordDict = ["apple","pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:
 Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 Output: false
     */

    @Test
    public void test1(){
        String s="leetcode";
        String[]words={"leet","code"};
        Assert.assertTrue(checkAllDictionaryWordsPresent(s,words));
    }
    @Test
    public void test2(){
        String s="applepenapple";
        String[]words={"apple","pen"};
        Assert.assertTrue(checkAllDictionaryWordsPresent(s,words));
    }
    @Test
    public void test3(){
        String s="catsandog";
        String[]words={"cats","dog","sand","and","cat"};
        Assert.assertFalse(checkAllDictionaryWordsPresent(s,words));
    }

    /*
    Approach: hashing
    Solution:-
     - Initialize variables left=0, right=1,count=0 and a String checkStr=""
     - Initialize a hashmap with String as key and Integer as value
     - Add all the dictionary elements into hashmap
     - While right reaches the length of the string
     - Add the character to the checkStr and check if that word conatains in map
        - if it matches then update the value of that key as 1
        - also increment the counter
     - when counter is equal to map.size return true else false


     */

    private boolean checkAllDictionaryWordsPresent(String s, String[] words) {

        int left=0, right=0,counter=0;
        String tempStr="";
        HashMap<String,Integer>map=new HashMap<>();
        for (String eachStr:words){
            map.put(eachStr,0);
        }
        while(right<s.length()){
            tempStr+=s.charAt(right++);
            if(map.containsKey(tempStr)){
                if(map.get(tempStr)==0){
                    map.put(tempStr,1);
                    counter++;
                    tempStr="";
                }else{
                    map.put(tempStr,map.getOrDefault(tempStr,0)+1);
                    tempStr="";
                }
            }
            left=right;
        }
        if(counter==map.size() &&left==right) return true;

        return false;
    }


    @Test
    public void test4(){
        String s="leetcode";
        List<String>words= Arrays.asList("leet","code");
        Assert.assertTrue(wordBreakProblem(s,words));
    }
    @Test
    public void test5(){
        String s="applepenapple";
        List<String>words= Arrays.asList("apple","pen");
        Assert.assertTrue(wordBreakProblem(s,words));
    }
    @Test
    public void test6(){
        String s="catsandog";
        List<String>words= Arrays.asList("cats","dog","sand","and","cat");
        Assert.assertFalse(wordBreakProblem(s,words));
    }

    private boolean wordBreakProblem(String s, List<String> words){

        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        int maxLen=0;
        for (String str: words){
            maxLen=Math.max(maxLen,str.length());
        }
        for (int i=0;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if(i-j>maxLen){
                    continue;
                }
                if(dp[j] && words.contains(s.substring(j,i))) dp[i]=true;
            }
        }
        return dp[s.length()];
    }
}
