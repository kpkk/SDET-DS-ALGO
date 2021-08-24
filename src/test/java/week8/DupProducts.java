package week8;

import org.junit.Test;

import java.util.HashSet;

public class DupProducts {


    @Test
    public void test1(){
        String[] names={"ball", "bat", "glove", "glove", "glove"};
        int[] prices={2,3,1,2,1};
        int[] weight={2,5,1,1,1};
        System.out.println(dups(names,prices,weight));
    }
    public int dups(String[] names, int[] prices, int[] weights){
        HashSet<String> set=new HashSet<>();
        String tempString="";
        for(int i=0;i<names.length;i++){
            tempString=names[i]+prices[i]+weights[i];
            set.add(tempString);
        }

        return names.length-set.size();
    }

}
