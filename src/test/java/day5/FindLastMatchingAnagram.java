package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FindLastMatchingAnagram {

    /*
    given a string and a target string find the last matching anagram

    Input- String
    output-String
    constraint- O(n)--> time complexity
     */

    @Test
    public void test1(){
        String input="abcdeghcbahjcab";
        String anagram="abc";
        Assert.assertEquals(findLastAnagram(input,anagram),"cab");
    }
    @Test
    public void test2(){
        String input="abcd";
        String anagram="abcd";
        Assert.assertEquals(findLastAnagram(input,anagram),"abcd");
    }
    @Test
    public void test3(){
        String input="abcd";
        String anagram="agh";
        Assert.assertEquals(findLastAnagram(input,anagram),"");
    }
    @Test
    public void test4(){
        String input="";
        String anagram="";
        Assert.assertEquals(findLastAnagram(input,anagram),"");
    }
    @Test
    public void test5(){
        String input="aaaaa";
        String anagram="a";
        Assert.assertEquals(findLastAnagram(input,anagram),"a");
    }

    //Time complexity-O(n)
    //Space complexity-O(n)
    /*
    Solution:-

    - Initialize a two hashMaps to store anagram and string chars
    - traverse through the string and add all the characters of anagram string
           - also add the first anagram length chars into the another map
           - check if the maps are equal if so store the indices
    - Traverse through the array from index 1 and add the characters to the map
        - if the map length goes beyond the anagram length remove the last character and compare maps
        - when there is a match store the current indices and return the substring

     */
    private String findLastAnagram(String input, String anagram) {
        int startIndex=0,endIndex=0;
        if(input.length()==0) return "";
        if(input.length()==anagram.length() && input.equals(anagram)) return input;
        HashMap<Character,Integer>anagramMap=new HashMap<>();
        HashMap<Character,Integer>inputStringmap=new HashMap<>();

        for (int i=0;i<anagram.length();i++){
            anagramMap.put(anagram.charAt(i), anagramMap.getOrDefault(anagram.charAt(i),0)+1);
            inputStringmap.put(input.charAt(i), inputStringmap.getOrDefault(input.charAt(i),0)+1);
           /* if(anagramMap.equals(inputStringmap)){
                startIndex=0;
                endIndex=i;
            }*/

        }
        for (int i=1;i<input.length()-anagram.length();i++){
            inputStringmap.put(input.charAt(i),inputStringmap.getOrDefault(input.charAt(i),0)+1);
            if(inputStringmap.size()==anagram.length()){
                while(inputStringmap.equals(anagramMap)){
                    startIndex=Math.max(startIndex,i);
                    endIndex=Math.max(endIndex,i+anagram.length()-1);
                    String s=input.substring(startIndex,endIndex);

                    if(inputStringmap.get(input.charAt(i))>1)
                        inputStringmap.put(input.charAt(i),inputStringmap.getOrDefault(input.charAt(i),0)-1);
                    else
                        inputStringmap.remove(input.charAt(i));
                }
            }
        }

        return input.substring(startIndex,endIndex+1);

    }

}
