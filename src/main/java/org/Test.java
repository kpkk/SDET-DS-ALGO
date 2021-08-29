package org;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test {

    @org.junit.Test
    public void tets1(){
        List<String> products= Arrays.asList("chocolate","cheese","tomato");
        List<Float>prices=Arrays.asList(15F,300.90F,23.44F);
        List<String> soldProducts=Arrays.asList("cheese", "tomato","chocolate");
        List<Float>soldPrices=Arrays.asList(300.90F,23.44F,10F);
        findPriceMisMatch(products,prices,soldProducts,soldPrices);
    }


    public int findPriceMisMatch(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice){
        int errorCount=0;
        HashMap<String,Float> ProductAndPricesmap=new HashMap<>();
        for(int i=0;i<products.size();i++){
            ProductAndPricesmap.put(products.get(i),productPrices.get(i));
        }
        for(int i=0;i<productSold.size();i++){
            if(ProductAndPricesmap.get(productSold.get(i)).equals(soldPrice.get(i))){
                continue;
            }else{
                errorCount++;
                List<Integer>list=Arrays.asList(5,3,1,2);
            }

        }
        System.out.println(errorCount);
        return errorCount;


}
}
