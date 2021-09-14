package week11;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class MisTypedPrices {
    /*
    You have an old grocery shop that instead of scanning their sold proudcts once sold, they type in the prices, which leaves room for mistyping sold prices.
     Given 4 lists: soldItems = ['eggs', 'milk', 'apple'], soldPrices = [1.00, 2.50, 2.1], productsAvailable = ['eggs', 'lemons', 'milk', 'apple'], productPrices = [1.01, 0.5, 2.50, 2.1],
     Find the number of items with mistyped prices
     */
    /*
    Problem understanding - 2 mins
    Test data- 1 min
    Logic - 2mins
    Pseudo code - 2mins
    Coding - 3 mins
    Debugging - 1 min
     */
    @Test
    public void test1(){
        String[] productsAvailable={"eggs", "lemons", "milk", "apple"};
        double[] productPrices={1.01, 0.5, 2.50, 2.1};
        String [] soldItems={"eggs", "milk", "apple"};
        double[] soldprices={1.00, 2.50, 2.1};
        Assert.assertEquals(findMistypedItemCount(productsAvailable,productPrices,soldprices,soldItems),1);
    }

    /*
    Solution- using map
    - push all the items and their prices into the map, init an int variable count=0
    - iterate the sold items array and compare the price items in the map and soldPrice array
    - if both are not equal then increment the count
    - return count
     */

    private int findMistypedItemCount(String[] productsAvailable, double[] productPrices, double[] soldprices, String[] soldItems) {
        int count=0;
        HashMap<String, Double>itemPriceMap=new HashMap<>();
        for (int i=0;i<productsAvailable.length;i++){
            itemPriceMap.put(productsAvailable[i],productPrices[i]);
        }
        for (int i=0;i<soldItems.length;i++){
            if(itemPriceMap.containsKey(soldItems[i])&& itemPriceMap.get(soldItems[i]).equals(soldprices[i]))continue;
            else count++;
        }
        return count;
    }
}