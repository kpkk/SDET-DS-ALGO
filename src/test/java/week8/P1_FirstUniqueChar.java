package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class P1_FirstUniqueChar {

    /*
    Given a string find the index of first unique character's index
    eg: statistics
    output 3

     */
    @Test
    public void test1(){
        String s="statistics";
        Assert.assertEquals(firstUniqueChar(s),3);
    }
    @Test
    public void test2(){
        String s="abbcd";
        Assert.assertEquals(firstUniqueChar(s),1);
    }
    @Test
    public void test3(){
        String s="aabbccdd";
        Assert.assertEquals(firstUniqueChar(s),-1);
    }
    @Test
    public void test4(){
        String s="aabbc";
        Assert.assertEquals(firstUniqueChar(s),5);
    }
    @Test
    public void test5(){
        String s="";
        Assert.assertEquals(firstUniqueChar(s),-1);
    }
    /*
    - initialize a hash map ith character as key and occurrence as value
    - convert the string into char array, iterate the array and insert into map
    - iterate the array and check if the value of map for that key is 1
    - return i

     */

    //time complexity- O(n)
    //space complexity- O(n)
    private int findUnique(String s) {
        if(s.length()==0) return -1;
        if(s.length()==1) return 1;
        HashMap<Character,Integer> map=new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i+1;
            }
        }
        return -1;
    }

    private int firstUniqueChar(String s){
        if(s.length()==0) return -1;
        if(s.length()==1) return 1;
        for (int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))) return i+1;
        }
        return -1;
    }
}
