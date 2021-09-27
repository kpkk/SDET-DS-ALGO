package dunZo;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SellingProducts {

    @Test
    public void test1() {
        int[] nums = {1, 1,1, 2, 3, 2};
        Assert.assertEquals(removeNums(nums,2), 2);
    }
    private int removeNums(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Integer min = Collections.min(map.values());
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries,Map.Entry.comparingByValue());
        for (int i=0;i<entries.size();i++){
            while (k>0){
                Map.Entry<Integer, Integer>eachEntry = entries.get(i);
                while (eachEntry.getValue()>0){
                    Integer key = eachEntry.getKey();
                    map.put(key,map.getOrDefault(key,0)-1);
                }

            }
        }
     return 1;
    }

}

/*
 //  Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry entry:entries){
            if((int)entry.getValue()==min && k!=0){
                if(entry.getValue().equals(1)) {
                    map.remove(entry.getKey());
                    k--;
                }
                else {
                    map.put((Integer) entry.getKey(),map.getOrDefault(entry.getKey(),0)-1);
                    k--;
                }

               if(k==0) break;
            }
        }
        if(k>0){
            Integer secondMin = Collections.min(map.values());
            for (Map.Entry entry:entries){
                if((int)entry.getValue()==min && k!=0){
                    if(entry.getValue().equals(1)) {
                        map.remove(entry);
                        k--;
                    }
                    else {
                        map.put((Integer) entry.getKey(),map.getOrDefault(entry.getKey(),0)-1);
                        k--;
                    }

                    if(k==0) break;
                }
            }
        }
        return map.keySet().size();
 */