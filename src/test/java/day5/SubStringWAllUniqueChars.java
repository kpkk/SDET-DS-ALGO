package day5;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SubStringWAllUniqueChars {
    /*

    Write a program to return the shortest substring having all the unique characters of the string
    input: "abbcafcb" Output: "bcaf"
     */


    @Test
    public void test1() {
        String st = "abbcafcb";
        String output = "bcaf";
        Assert.assertEquals(uniqueSubString(st), output);
    }

    @Test
    public void test2() {
        String st = "";
        String output = "";
        Assert.assertEquals(uniqueSubString(st), output);
    }
    @Test
    public void test3() {
        String st = "abcd";
        String output = "abcd";
        Assert.assertEquals(uniqueSubString(st), output);
    }
    @Test
    public void test4() {
        String st = "abbcafcbfcab";
        String output = "bcaf";
        Assert.assertEquals(uniqueSubString(st), output);
    }
    @Test
    public void test5() {
        String st = "aaaaaa";
        String output = "a";
        Assert.assertEquals(uniqueSubString(st), output);
    }
    @Test
    public void test6() {
        String st = "xxyyzzyyxxzzy";
        String output = "xy";
        Assert.assertEquals(uniqueSubString(st), output);
    }

    /*
    BruteForce-
    Time complexity- O(n)
    Space complexity - O(n)

    - Initialize two arrayLists, uniqueList, subStringList of character type
    - Initialize a string variable
    - If the length of the string is zero then return empty string
    - Traverse through the string  and add all the distinct characters of string to the uniqueList arraylist the sort the same
    - Traverse through the string and add every character of the string to the substringList
    - check if the size of the substringList matches the uniqueList
           - if matches, sort the collection and compare with uniqueList
                - if they are equal break the loop
                - add the characters from subStringList to string and return
           - else, clear the list and continue
    - return the output string

     */
    private String returnSubString(String st) {
        if(st.length()==0) return "";
        ArrayList<Character>uniqueList=new ArrayList<>();
        ArrayList<Character>subStringList=new ArrayList<>();
        String output="";
        for (int i=0;i<st.length();i++){
            if(!uniqueList.contains(st.charAt(i)))
              uniqueList.add(st.charAt(i));
        }

        Collections.sort(uniqueList);
        for (int i=0;i<st.length();i++){
            subStringList.add(st.charAt(i));
            if(subStringList.size()==uniqueList.size()){
                Collections.sort(subStringList);
                if(subStringList.equals(uniqueList))
                    break;
                else {
                    subStringList.clear();
                    continue;

                }
            }
        }
        for (char ch:subStringList)
            output+=ch;

        return output;
    }

    /*
    - Initialize two string variables uniqueEle="" and subStringele=""
    - Traverse the input string and add the distinct characters of the string to the string
    - Traverse the input string and add the character into the string until the string reaches the uniqueEle length
    - check if both the strings are equal
        - if yes, break the loop
    - else continue
    - return the string

     */

    //abbcafcb
    private String returnSubStringUniqueEle(String str){
        String uniqueEle=str.charAt(0)+"";
        String subStringEle="";
        for (int i=0;i<str.length();i++){
            if(!uniqueEle.contains(str.charAt(i)+""))
                uniqueEle+=str.charAt(i);
        }
        for (int i=0;i<uniqueEle.length();i++){
            subStringEle+=(str.charAt(i));
        }
        if(subStringEle.equals(uniqueEle))return subStringEle;
        for (int i=1;i<str.length()-uniqueEle.length();i++){
            subStringEle = subStringEle.substring(1, subStringEle.length());
            subStringEle+=str.charAt(i+uniqueEle.length()-1);
            if(subStringEle.length()==uniqueEle.length()){
                if(subStringEle.equals(uniqueEle)) return subStringEle;
            }
        }
        System.out.println(subStringEle);
        return "";
    }

    /*
    Approach:- hashing (map and set)
    Solution:-
    - Initialize a hashset and a hashmap
    - Initialize an empty string and integer variables left=0, right=0
    - traverse through the string add all the distinct characters to the set
    - while left less then or equals to right
        - add the characters to the map and continue to check the map keySet size is equals to the size of the hashset
        - if the size is equal, calculate the length right-length+1
        - store the substring in the outputString
        - Continue to remove characters as well and check if the size of the map is still equal to the set size, calculate the minimum length and return the substring of that length
    - return the outputString


     */

    //Time complexity- O(n)
    //space complexity-O(n)
    private String returnUniqueCharsUsingMap(String str){
        HashSet<Character> set=new HashSet<>();
        HashMap<Character,Integer>map=new HashMap<>();
        String outputString="";
        int left=0,right=0,minCount=Integer.MAX_VALUE;
        for (int i=0;i<str.length();i++)
            set.add(str.charAt(i));
        int size = set.size();
        while (right<str.length() && left<=str.length()-size){
            char currChar = str.charAt(right);
            map.put(currChar,map.getOrDefault(currChar,0)+1);
          while(map.keySet().size()==size){
                if(right-left+1<minCount){
                    minCount=right-left+1;
                    outputString=str.substring(left,right+1);
                }
               if(map.get(str.charAt(left))>1) map.put(str.charAt(left),map.getOrDefault(str.charAt(left++),0)-1);

              else map.remove(str.charAt(left++));
          }
          right++;
        }
        return outputString;
    }

    private String uniqueSubString(String str){
        int[] ascii=new int[128];
        int left=0, right=0, maxLength=0;
        String output="";
        while (right<str.length()){
            ascii[str.charAt(right)]++;
            while (ascii[str.charAt(right)]>1){
                ascii[str.charAt(left++)]--;
            }
            if(right-left+1>maxLength){
                maxLength=right-left+1;
                output=str.substring(left,right+1);
            }
            right++;
        }
        return output;
    }
}

