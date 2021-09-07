package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P8_ReArrangeString {
    /*
    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.



Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""


Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
     */
    /*
    Input- String
    output- string
     */
    @Test
    public void test1(){
        String s="aab";
        Assert.assertEquals(reOrganizeString(s),"aba");
    }
    @Test
    public void test2(){
        String s="aaab";
        Assert.assertEquals(reOrganizeString(s),"");
    }
    @Test
    public void test3(){
        String s="abc";
        Assert.assertEquals(reOrganizeString(s),"acb");
    }
    @Test
    public void test4(){
        String s="cxmwmmm";
        Assert.assertEquals(reOrganizeString(s),"mcmwmxm");
    }

    /*
    - Initialize an array of 26 chars length, to count the occurrences of each string
    - get the max value and the index
    - if the value is greater than (s.length()+1)/2 then return empty string
    - then create an array of output length to return
    - initially fill the maximum times occurred character into 0,2,4,6... indices and reduce its occurrences in ascii array
    - then iterate the ascii array from start until end
    - if the ascii[i] is greater than 0 then fill the remaining odd positions
    - return the array as string

     */
    //aab
    private String reArrangeString(String s) {
        if(s.length()==0 || s.length()==1) return s;
        int[] ascii=new int[26];
        int maxValue=0, index=0;
        // count the frequency  of characters
        for (int i=0;i<s.length();i++){
            ascii[s.charAt(i)- 97]++;
        }
        // count the max value of frequency and the index
        for(int i=0;i<ascii.length;i++){
            if(maxValue<ascii[i]){
                maxValue=ascii[i];
                index=i;
            }
        }
        if(maxValue>(s.length()+1)/2)return "";
        // fill the maxValue in the new array in even indices starting from 0 and reduce in ascii array
        char[] output=new char[s.length()];
        int i=0;
        while (ascii[index]>0){
            output[i]=(char)(index+'a');
            i+=2;
            ascii[index]--;
        }
        // fill the other elements in the gaps
        for(int j=0;j<ascii.length;j++){
            if(ascii[j]>0){
                if(i>=output.length)i=1;
                output[i]=(char)(j+'a');
                i+=2;
                ascii[j]--;
            }
        }
        return String.valueOf(output);

    }
    //aab
    public String reOrganizeString(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch: chars){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>>pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        StringBuffer sb=new StringBuffer();
        Map.Entry<Character,Integer> prevEntry=null;
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> currentEntry = pq.poll();
            if(currentEntry.getValue()>(s.length()+1)/2) return "";
            if(prevEntry!=null && prevEntry.getValue()>0){
                pq.offer(prevEntry);
            }
            sb.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue()-1);
            prevEntry=currentEntry;

        }
        return sb.toString();
    }
}
