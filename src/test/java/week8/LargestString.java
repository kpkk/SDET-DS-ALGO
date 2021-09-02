package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LargestString {
    /*
    Given a string, re-arrange or delete characters as needed such that the largest alphabetically string cane be constructed, while
    no character is occurring more than the specified k
    ex: baccc, k=2 output:-  ccbca
    ex: azzzzz, k=2  output :-zzazz
    ex: azzxxx, k=2  output :-zzxxax
    ex: yuzzvuyzpv, k=1  output :-zyzyzvuvup
    ex: zxzuvozyzvzywvxyqxzxzyywyxwyzxxwzwzyzzzzyxzvzxxywx, k=4  output :-zzzzyzzzzyzzzzyzzzzyyyyxyyyxxxxwxxxxwxxwwwwvvvvuqo

     */
    @Test
    public void test1(){
        String s="baccc";
        int k=2;
        Assert.assertEquals(reArrangeString(s,k),"ccbca");
    }
    @Test
    public void test2(){
        String s="azzzzz";
        int k=2;
        Assert.assertEquals(reArrangeString(s,k),"zzazz");
    }
    @Test
    public void test3(){
        String s="yuzzvuyzpv";
        int k=1;
        Assert.assertEquals(reArrangeString(s,k),"zyzyzvuvup");
    }
    @Test
    public void test4(){
        String s="zxzuvozyzvzywvxyqxzxzyywyxwyzxxwzwzyzzzzyxzvzxxywx";
        int k=4;
        Assert.assertEquals(reArrangeString(s,k),"zzzzyzzzzyzzzzyzzzzyyyyxyyyxxxxwxxxxwxxwwwwvvvvuqo");
    }

    private String reArrangeString(String s, int k) {
        StringBuilder sb=new StringBuilder();
        TreeMap<Character,Integer>map=new TreeMap<>(Collections.reverseOrder());
        char[] chars = s.toCharArray();
        for (char c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int prevValue=0;
        char prevKey=' ';
        char currentChar=' ';
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry entry:entries){
            int value = (int)entry.getValue();
            int temp=k;
            while (value>0 && temp>0){
                currentChar=(char)entry.getKey();
                sb.append(entry.getKey());
                temp--;
                value--;
            }
            while (temp>0 && prevValue>0){
                sb.append(prevKey);
                prevValue--;
                temp--;
            }
            prevValue=value;
            prevKey=currentChar;
        }
        return sb.toString();
    }

    /*
    Add all characters in String to int array
Initialize a String
Iterate int array from reverse to get the max value first
If the current value count is > k,
	Add k times and decrement the count in int array
	Find the next char
		Add the char just once and then decrement its count
		if no char found, break
else if the count is between 1 and k, add all to String
else move to next char
     */
}
