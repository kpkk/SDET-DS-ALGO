package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P2_SmallestNegBalance {
    /*
    String s=[""]
     */

    /*
    - Initialize three variables asum-0, bsum=0, csum=0
    - iterate the string array
    - split the each string based on space delimiter
    - if the person at nums[0]==alex reduce alex sum, lly for other
    - if the person at nums[1]=alex add to the alex sum, lly for others
    - if no sum is less than 0 return "no negative"
    - if sum
    Collections.min(debtCalc.values())
     */
    @Test
    public void test1() {
        String[] str = {"Alex Blake 2", "Blake Alex 2", "Casey Alex 5", "Blake Casey 7", "Alex Blake 4", "Alex Casey 4"};
        Assert.assertEquals(findNegativeBalance(str), "Alex Blake");
    }

    private String findNegativeBalance(String[] str) {
        Map<String, Integer> map = new HashMap<>();
        String output = "";
        for (int i = 0; i < str.length; i++) {
            String[] split = str[i].split("\\s");
            map.put(split[0], map.getOrDefault(split[0], 0) - Integer.parseInt(split[2]));
            map.put(split[1], map.getOrDefault(split[1], 0) + Integer.parseInt(split[2]));
        }
        int minValue = Collections.min(map.values());
        if (minValue >= 0) {
            return "No body has negative balance";
        }
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == minValue) {
                list.add(entry.getKey());
            }
        }

        for (String names : list) {
            output += names + " ";
        }
        return output.trim();
    }

}
