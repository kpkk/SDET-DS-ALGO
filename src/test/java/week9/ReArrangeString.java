package week9;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ReArrangeString {
    /*
    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.



Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
     */
    /*
    Input- String
    Output- String

     */
    @Test
    public void test1(){
        String input="aab";
        Assert.assertEquals(reArrangeChars(input),"aba");
    }
    @Test
    public void test2() {
        String input = "aab";
        Assert.assertEquals(reArrangeChars(input), "aba");
    }
    @Test
    public void test3() {
        String input = "";
        Assert.assertEquals(reArrangeChars(input), "");
    }
    @Test
    public void test4() {
        String input = "cxmmwm";
        Assert.assertEquals(reArrangeChars(input), "mcmwmx");
    }

    /*
    Solution:-
    - Initialize a hashmap to hold the chars and occurrences
    - initialize a stringBuffer to form result string
    - get the entry set, do a custom sort (sort by value-descending)
    - iterate the entry set, add one character to the string then decrement its value
    - keep track of the prev key and value ifs more than 1
    - add the nex character for once and then add the prev key and decrement its occurrence by 1
    - return the string

     */
    private String reArrangeChars(String input) {
        int[] ascii=new int[26];
        for (int i=0;i<input.length();i++){
            ascii[input.charAt(i)-97]++;
        }
        int maxvalue=ascii[0],maxIndex=0;
        for(int i=0;i<ascii.length;i++){
            if(maxvalue<ascii[i]){
                maxvalue=ascii[i];
                maxIndex=i;
            }
        }
        if(maxvalue>(input.length()+1)/2) return "";
        char[] output=new char[input.length()];
        int index=0;
        while (ascii[maxIndex]>0){
            output[index]=(char) (maxIndex+'a');
            index+=2;
            ascii[maxIndex]--;

        }
        for (int i=0;i<ascii.length;i++){
            if (ascii[i]>0){
                if(index>=output.length) index=1;
                output[index]=(char) (i+'a');
                index+=2;
                ascii[i]--;
            }
        }

        return String.valueOf(output);
    }
}


/*
HashMap<Character,Integer>map=new HashMap<>();
        char prevChar=' '; int prevValue=0;
        StringBuffer sb=new StringBuffer();
        for (char ch:input.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries,(a,b)->b.getValue()-a.getValue());
        if(input.length()%2==0){
            if(entries.get(0).getValue()>input.length()/2) return "";
        }else{
           if( entries.get(0).getValue()>(input.length()+1)/2) return "";
        }
        int index=0;
        while (entries.size()!=0){
            Map.Entry<Character, Integer> currentEntry = entries.get(index);
            if(currentEntry.getValue()>1){
                sb.append(currentEntry.getKey());
                currentEntry.setValue(currentEntry.getValue()-1);
                prevChar=(char)currentEntry.getKey();
                prevValue=currentEntry.getValue();
                if(index<entries.size()-1){
                    Map.Entry<Character, Integer> nextEntry = entries.get(index+1);
                    sb.append(nextEntry.getKey());
                    nextEntry.setValue(nextEntry.getValue()-1);
                    if(nextEntry.getValue()==0) entries.remove(nextEntry);
                }
            }else if(currentEntry.getValue()==1){
                sb.append(currentEntry.getKey());
                entries.remove(currentEntry);
            }else{
                index++;
            }
        }

        return sb.toString();
 */