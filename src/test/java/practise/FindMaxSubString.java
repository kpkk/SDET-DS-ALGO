package practise;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

public class FindMaxSubString {
    /*
     find the max substring in the given string of k max occurrences


    //eceba k=2
     */

    @Test
    public void test(){
        String str="eceba";
        int k=2;
        Assert.assertEquals(findMaxSubStringLength(str,k),3);
    }

    private int findMaxSubStringLength(String str, int k) {
        int max=1, left=0,right=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while (right<str.length()){
            map.put(str.charAt(right),right++);
            if(map.size()>k){
                Integer min = Collections.min(map.values());
                map.remove(str.charAt(min));
                left=min+1;
            }
           max= Math.max(max,right-left);
        }

        return max;
    }
}
