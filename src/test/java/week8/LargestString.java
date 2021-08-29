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

    private String reArrangeString(String s, int k) {
        StringBuilder sb=new StringBuilder();
        TreeMap<Character,Integer>map=new TreeMap<>(Collections.reverseOrder());
        char[] chars = s.toCharArray();
        for (char c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry entry:entries){
            int value = (int)entry.getValue();
            while (value>0){
                sb.append(entry.getKey());
            }
            sb.append(entry.getKey());
        }
        return sb.toString();
    }

}
