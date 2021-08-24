package leetCodeRandomPick;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToSellStocks {

    @Test
    public void test1(){
        int[] prices={7,1,5,3,6,4};
        Assert.assertEquals(5,maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int left=0, right=1, maxProfit=0;
        while(right<prices.length){
            if(prices[left]<prices[right]){
                if(maxProfit<Math.abs(prices[right]-prices[left]))
                    maxProfit=Math.abs(prices[right]-prices[left]);
                right++;
            }else{
                left++;
                right++;
            }
        }
        return maxProfit;
    }
}
