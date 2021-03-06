package day5;

import org.junit.Assert;
import org.junit.Test;
import sun.java2d.pipe.OutlineTextRenderer;

import java.util.Arrays;
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
        Assert.assertEquals(findElements(input,anagram),"cab");
    }
    @Test
    public void test2(){
        String input="abcd";
        String anagram="abcd";
        Assert.assertEquals(findElements(input,anagram),"abcd");
    }
    @Test
    public void test3(){
        String input="abcd";
        String anagram="agh";
        Assert.assertEquals(findElements(input,anagram),"");
    }
    @Test
    public void test4(){
        String input="";
        String anagram="";
        Assert.assertEquals(findElements(input,anagram),"");
    }
    @Test
    public void test5(){
        String input="aaaaa";
        String anagram="a";
        Assert.assertEquals(findElements(input,anagram),"a");
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
        String outputString="";
        if(input.length()==0) return "";
        if(input.length()==anagram.length() && input.equals(anagram)) return input;
        HashMap<Character,Integer>anagramMap=new HashMap<>();
        HashMap<Character,Integer>inputStringmap=new HashMap<>();

        for (int i=0;i<anagram.length();i++){
            anagramMap.put(anagram.charAt(i), anagramMap.getOrDefault(anagram.charAt(i),0)+1);
            inputStringmap.put(input.charAt(i), inputStringmap.getOrDefault(input.charAt(i),0)+1);
        }
        for (int i=1;i<input.length()-anagram.length();i++){
            inputStringmap.put(input.charAt(i+anagram.length()-1),inputStringmap.getOrDefault(input.charAt(i+anagram.length()-1),0)+1);
            if(inputStringmap.size()>=anagram.length()){
                if(inputStringmap.equals(anagramMap)) {
                    startIndex = Math.max(startIndex, i - 1);
                    endIndex = Math.max(endIndex, i + anagram.length() - 1);
                    outputString = input.substring(startIndex, endIndex);
                }
                    if(inputStringmap.get(input.charAt(i-1))>1)
                        inputStringmap.put(input.charAt(i-1),inputStringmap.getOrDefault(input.charAt(i-1),0)-1);
                    else
                        inputStringmap.remove(input.charAt(i-1));

            }

        }

        return outputString;

    }

    private String findLastSubStringAscii(String str, String anagram){
        int[] inputAscii=new int[128];
        int[] anagramAscii=new int[128];
        String outputString="";

        for (int i=0;i<anagram.length();i++){
            anagramAscii[anagram.charAt(i)]++;
          //  inputAscii[str.charAt(i)]++;
        }
      //  if(Arrays.equals(anagramAscii,inputAscii)) outputString=str.substring(0,anagram.length());
       int left=0, right=0;
       while (right<str.length()){
           inputAscii[str.charAt(right++)]++;
           if(right-left==anagram.length()){
               if(Arrays.equals(anagramAscii,inputAscii)) outputString=str.substring(left,right+1);
               inputAscii[str.charAt(left++)]--;
           }


        }

       return outputString;
    }


    private String findElements(String str, String pattern){
        int start=0, end=0,i=0;
        HashMap<Character,Integer>smap=new HashMap<>();
        HashMap<Character,Integer>pmap=new HashMap<>();
        for(i=0;i<pattern.length();i++){
            pmap.put(pattern.charAt(i),pmap.getOrDefault(pattern.charAt(i),0)+1);
            smap.put(str.charAt(i),smap.getOrDefault(str.charAt(i),0)+1);
        }
        if(smap.equals(pmap)){
            start=0;
            end=i-1;
        }
        for(i=1;i<str.length()-pattern.length()+1;i++){
            smap.put(str.charAt(i+pattern.length()-1),smap.getOrDefault(str.charAt(i+pattern.length()-1),0)+1);
            if(smap.get(str.charAt(i-1))>1){
                smap.put(str.charAt(i-1),smap.getOrDefault(str.charAt(i-1),0)-1);
            }else{
                smap.remove(str.charAt(i-1));
            }

            if(smap.equals(pmap)){
                start=i;
                end=i+pattern.length()-1;
            }
        }
        if(start==0 &&end==0) return "";
        return str.substring(start,end+1);
    }

}
