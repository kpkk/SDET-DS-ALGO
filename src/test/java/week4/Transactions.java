package week4;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Transactions {

    @Test
    public void test(){
        List<String> strings = Arrays.asList("bin", "can", "bin", "can");
        groupTransactions(strings);

    }

    public static List<String> groupTransactions(List<String> transactions) {

        TreeMap<String, Integer>map=new TreeMap<>();
        List<String> output=new ArrayList<>();
        for (String str: transactions){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        ArrayList<Map.Entry<String,Integer>>al=new ArrayList<>(map.entrySet());
        Collections.sort(al,(a,b)->b.getValue().compareTo(a.getValue()));

        for (Map.Entry entry:al){
            output.add(entry.getKey()+" "+entry.getValue());
        }
        System.out.println(output);
        return output;
    }
}

/*
 Map<String,Integer> map=new HashMap<>();
        List<String> outputTransactions=new ArrayList<String>();

        Iterator<String> itr=transactions.iterator();
        while(itr.hasNext()){
            map.put(itr.next(), map.getOrDefault(itr.next(), 0)+1);

        }
        Set<Map.Entry<String,Integer>> entries= map.entrySet();
        for(Map.Entry eachEntry: entries){
            outputTransactions.add(eachEntry.getKey()+" "+String.valueOf(eachEntry.getValue()));
        }
        System.out.println(outputTransactions);

        return outputTransactions;
 */