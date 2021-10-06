package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWoRepeatingChars {

    @Test
    public void test1(){
        String s="abcabcbb";
        Assert.assertEquals(usingMap(s),3);
    }

    /*
    - initialize two pointers left=0, right=0, maxLength=0
    - initialize an ascii array of 128 length
    - iterate the string, add initialize the index of ascii array, based on the char
    - when the count at a particular index >1, then move left char until this index comes to 1
    - calculate the max length
     */
    private int longestDistinctChars(String s) {
        int left=0, right=0, maxLength=0;
        int[] ascii=new int[128];
        while (right<s.length()){
            ascii[s.charAt(right)]++;
            while (ascii[s.charAt(right)]>1){
                ascii[s.charAt(left++)]--;
            }
            maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
    private int bruteForce(String s){
        int maxLength=0, j;
        HashSet<Character>set=new HashSet<>();
        for (int i=0;i<s.length();i++){
            for (j=i;j<s.length();j++){
                if(!set.add(s.charAt(j))){
                    break;
                }
            }
            maxLength=Math.max(maxLength,j-i);
        }
        return maxLength;
    }
    private int usingMap(String s){
        int left=0, right=0, maxLength=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while (right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while (map.get(s.charAt(right))>1){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
            maxLength=Math.max(maxLength,(right-left)+1);
            right++;
        }
        return maxLength;
    }
}
