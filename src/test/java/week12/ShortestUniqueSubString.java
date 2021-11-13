package week12;

import org.junit.Assert;
import org.junit.Test;

import javax.jnlp.ClipboardService;
import java.util.*;

public class ShortestUniqueSubString {

    @Test
    public void test1(){
        String s="abaaba";
        Assert.assertEquals(findUniqueShortSubString(s),2);
    }
    @Test
    public void test2(){
        String s="zyzyzyz";
        Assert.assertEquals(findUniqueShortSubString(s),5);
    }

    private int findUniqueShortSubString(String S) {
        ArrayList<String> list=new ArrayList<>();
        HashMap<String,Integer>map=new HashMap<>();
        HashMap<String, Integer> newMap=new HashMap<>();
        ArrayList<String> freshList=new ArrayList<>();

        for(int i=0;i<S.length();i++){
            for(int j=i;j<S.length();j++){
                String shortSubString= S.substring(i,j+1);
                list.add(shortSubString);
            }
        }

        for (String str: list){
            map.put(str,map.getOrDefault(str,0)+1);
        }
       for (Map.Entry<String, Integer> entry: map.entrySet()){
           if(entry.getValue()==1)
               freshList.add(entry.getKey());
       }
       for (String s: freshList){
           newMap.put(s,s.length());
       }
        ArrayList<Integer>newList=new ArrayList<>();
       for (Map.Entry<String, Integer> entry:newMap.entrySet()){
           newList.add(entry.getValue());
       }
        Integer reduce = newList.stream().reduce(Integer.MAX_VALUE, Integer::min);
        return reduce;
    }
}
