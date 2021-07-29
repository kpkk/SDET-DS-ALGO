package week4;

import org.junit.Test;

import java.util.*;

public class Transactions {

    @Test
    public void test(){
        List<String> strings = Arrays.asList("bin", "can", "bin", "can");
        groupTransactions(strings);

    }

    public static List<String> groupTransactions(List<String> transactions) {
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

        return outputTransactions;
    }
}
