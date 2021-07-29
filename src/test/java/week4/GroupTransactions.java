package week4;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class GroupTransactions {

    /*
    grouping transaction item by names
     */
    @Test
    public void test(){
        List<String> list= Arrays.asList("notebook","notebook","mouse","keyboard","mouse");
       groupItems(list);
    }


    private List<String> groupItems(List<String> list){
        Map<String,Integer> map=new TreeMap<>();
        ArrayList<String>al=new ArrayList<>();
       ArrayList<Map.Entry<String,Integer>> values=null;
        // add all elements into treemap
        for (String str:list){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        //
        ArrayList<Map.Entry<String,Integer>> all=new ArrayList<>(map.entrySet());

        Collections.sort(all,(i1,i2) -> i2.getValue().compareTo(i1.getValue()));
        System.out.println(all);
        for (Map.Entry entry:all){
            al.add(entry.getKey()+" "+entry.getValue());
        }
        System.out.println(al);
        return al;
    }

    /*


        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry eachEntry:entries){
            values = new ArrayList<>();
            values.add(eachEntry);
        }

     */
}
