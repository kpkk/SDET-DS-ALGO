package week9;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ReArrangeStringUsingPriorityQueue {
    @Test
    public void test1(){
        String input="aab";
        Assert.assertEquals(reArrangeChars(input),"aba");
    }
    @Test
    public void test2() {
        String input = "aab";
        Assert.assertEquals(reArrangeChars(input), "aba");
    }
    @Test
    public void test3() {
        String input = "";
        Assert.assertEquals(reArrangeChars(input), "");
    }
    @Test
    public void test4() {
        String input = "cxmmwm";
        Assert.assertEquals(reArrangeChars(input), "mcmwmx");
    }

    private String reArrangeChars(String input) {
        HashMap<Character,Integer>map=new HashMap<>();
        for (char ch:input.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        StringBuffer sb=new StringBuffer();
        Map.Entry<Character,Integer> prevEntry=null;
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> currentEntry = pq.poll();
            if(prevEntry!=null && prevEntry.getValue()>0){
                pq.offer(prevEntry);
            }
           sb.append(currentEntry.getKey());
          currentEntry.setValue(currentEntry.getValue()-1);
          prevEntry=currentEntry;

        }
        return sb.toString().length()==input.length()?sb.toString():"";
    }
}
