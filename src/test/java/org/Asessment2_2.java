package org;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Asessment2_2 {

    /*
    Grouping transactions
     */

    @Test
    public void test(){
        String[] transactions={"notebook","notebook","mouse", "keyboard","mouse"};
        String [] groups={"mouse 2","notebook 2","keyboard 1"};
        System.out.println(groupsStrings(transactions));
    }

    /*
    - Initialize a treemap with String as key and Integer as value
    - Consider an array list to add all the elements of treemap
    - Traverse the array from left to right add every element into the tree map
    -  Add the entry set of the treemap into the list
    - Sort the list using comparator (custom sort) based on the value
    - Traverse the list and append the key and value with a space in between
    - return the character array

     */
    private List<String> groupsStrings(String[] str){
        TreeMap<String,Integer>map=new TreeMap<>();
        ArrayList<String>list=new ArrayList<>();
        for (String s:str){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        System.out.println(map);
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries,(i1,i2)->i2.getValue().compareTo(i1.getValue()));

        for (Map.Entry entry:entries){
            list.add(entry.getKey()+" "+entry.getValue());
        }

        return list;
    }
}
