package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class PermutationString {

    @Test
    public void test1(){
        String s1="adc";
        String s2="dcda";
        Assert.assertTrue(checkInclusion(s1,s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        HashMap<Character, Integer>s1Map=new HashMap<>();
        HashMap<Character, Integer>s2Map=new HashMap<>();
        int left=0, right=s1.length();
        for(int i=0;i<s1.length();i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i),0)+1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i),0)+1);
        }
        if(s1Map.equals(s2Map)) return true;
        while(right<s2.length()){
            s2Map.put(s2.charAt(right),s2Map.getOrDefault(s2.charAt(right),0)+1);
            if(s2Map.get(s2.charAt(left))>1){
                s2Map.put(s2.charAt(left),s2Map.getOrDefault(s2.charAt(left),0)-1);
                left++;
            }else{
                s2Map.remove(s2.charAt(left++));
            }
            if(s1Map.equals(s2Map)) return true;
            right++;
        }
        return false;
    }
}
