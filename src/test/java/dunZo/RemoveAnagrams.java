package dunZo;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class RemoveAnagrams {

    @Test
    public void test1(){
        List<String> str= Arrays.asList("code","doce","ocde","framer","frame");
        List<String> list = removeAnagrams(str);
        System.out.println(list);
    }
    private List<String> removeAnagrams(List<String> list) {
        HashSet<String>set=new HashSet<>();
        List<String> output=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            char[] chars = list.get(i).toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if(!set.contains(s))output.add(list.get(i));
            set.add(s);
        }

        Collections.sort(output);
        return output;
    }


 private List<String> funAnagram(List<String> input){
        List<String> op = new ArrayList<>();
        Set<Map<Character,Integer>> set = new HashSet<>();
        for (String each : input) {
            Map<Character, Integer> map = new HashMap<>();
            for(char c : each.toCharArray())
                map.put(c, map.getOrDefault(c, 0)+1);
            if(!set.contains(map)) {
                op.add(each);
                set.add(map);
            }
        }
        Collections.sort(op);
        return op;
    }


}
