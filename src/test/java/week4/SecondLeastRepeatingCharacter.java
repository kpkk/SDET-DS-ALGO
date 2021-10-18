package week4;

import netscape.security.UserTarget;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SecondLeastRepeatingCharacter {
    /*

    Find the second least repeating character in
    input- amazon  a->2,m->1,z->1,o->1,n->1
    output-
     */

    @Test
    public void test1(){
        String str="amazon";
        Assert.assertEquals(findChar(str),'m' );
    }
    @Test
    public void test2(){
        String str="aabbbc";
        Assert.assertEquals(findChar(str),'a');
    }
    @Test
    public void test3(){
        String str="successes";
        Assert.assertEquals(findChar(str),'c');
    }

    private char findSeconLeastChar(String str) {
        int[] ascii=new int[128];
        for (int i=0;i<str.length();i++){
            ascii[str.charAt(i)]++;
        }
        int firstMax=0, secondMax=0;
        for (int i=0;i<ascii.length;i++){
            if(ascii[i]>ascii[firstMax]){
                secondMax=firstMax;
                firstMax=i;
            }else if(ascii[i]>secondMax && ascii[i]!=firstMax){
                secondMax=i;
            }
        }
       return (char)secondMax;
    }

    private char findChar(String str){
        TreeMap<Character,Integer>map=new TreeMap<>();
        char[] chars = str.toCharArray();
        for (char ch:chars){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int min=map.firstEntry().getValue(),secondMin= map.firstEntry().getValue();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry entry:entries){
            Integer value = (Integer) entry.getValue();
            if (min>value){
                secondMin=min;
                min=value;
            }

        }
        for(Map.Entry entry:entries){
            if((Integer) entry.getValue()==secondMin) {
                return (char)entry.getKey();
            }
        }


        return ' ';
    }
}


/*

Java t point code
 int[] freq = new int[str.length()];
        char minChar = str.charAt(0), maxChar = str.charAt(0);
        int i, j, min, max;

        //Converts given string into character array
        char string[] = str.toCharArray();

        //Count each word in given string and store in array freq
        for(i = 0; i < string.length; i++) {
            freq[i] = 1;
            for(j = i+1; j < string.length; j++) {
                if(string[i] == string[j] && string[i] != ' ' && string[i] != '0') {
                    freq[i]++;

                    //Set string[j] to 0 to avoid printing visited character
                    string[j] = '0';
                }
            }
        }

        //Determine minimum and maximum occurring characters
        min = max = freq[0];
        for(i = 0; i <freq.length; i++) {

            //If min is greater than frequency of a character
            //then, store frequency in min and corresponding character in minChar
            if(min > freq[i] && freq[i] != '0') {
                min = freq[i];
                minChar = string[i];
            }
            //If max is less than frequency of a character
            //then, store frequency in max and corresponding character in maxChar
            if(max < freq[i]) {
                max = freq[i];
                maxChar = string[i];
            }
        }
        System.out.println(minChar);
        System.out.println(maxChar);
        return minChar;
 */