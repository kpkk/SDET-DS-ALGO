package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class ReeturnUnCommonChars {

    @Test
    public void test1(){
        String s1="aabde";
        String s2="cbaz";
        Assert.assertEquals(returnUniqueCharsUsingMap(s1,s2),"decz");
    }

    private String returnUniqueChars(String s1, String s2) {
        String output="";
        int [] ascii=new int[26];
        for (int i=0;i<s1.length();i++){
            ascii[s1.charAt(i)-97]++;
        }
        for (int i=0;i<s2.length();i++){
            ascii[s2.charAt(i)-97]++;
        }
        for (int i=0;i<ascii.length;i++){
            if(ascii[i]==1){
                output+=(char) (i+97)+"";
            }
        }
        return output;
    }
    private String returnUniqueCharsUsingMap(String s1, String s2){
        String output="";
        HashSet<Character>s1Map=new HashSet<>();
        HashSet<Character> uniqueSet=new HashSet<>();
        HashSet<Character> dupSet=new HashSet<>();
        for (char c:s1.toCharArray()){
            s1Map.add(c);
        }
        for (char c: s2.toCharArray()){
            if(s1Map.contains(c) || uniqueSet.contains(c)){
                uniqueSet.remove(c);
                s1Map.remove(c);
            }
            uniqueSet.add(c);
           // s1Map.add(c);

        }
        output="";
       for (char c : uniqueSet){
           output+=c;
       }


        return output;
    }
}
