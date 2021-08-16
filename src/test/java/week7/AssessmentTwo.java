package week7;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AssessmentTwo {


    @Test
    public void test1(){
        List<Long> nums= Arrays.asList(3l,5l,4l,3l);
        Assert.assertEquals(cutThemAll(nums,9),"Possible");
    }
    @Test
    public void test2(){
        List<Long> nums= Arrays.asList(4l,3l,2l);
        Assert.assertEquals(cutThemAll(nums,7),"Possible");
    }
    @Test
    public void test3(){
        List<Long> nums= Arrays.asList(4l,2l,3l);
        Assert.assertEquals(cutThemAll(nums,7),"Impossible");
    }
    public static String cutThemAll(List<Long> lengths, long minLength) {

       long  max=0;
        for (int i=0;i<lengths.size()-1;i++){
            max=Math.max(max,lengths.get(i)+lengths.get(i+1));

        }
        if(max>=minLength) return "Possible";
        else return "Impossible";

    }

}

/*

 long totalSum=0, minCutLength=Integer.MAX_VALUE;
    int left=0, right=lengths.size()-1;
    for(int i=0;i<lengths.size();i++){
        totalSum+=lengths.get(i);
    }
    while(left<=right){
       minCutLength= Math.min(lengths.get(left), lengths.get(right));
       if(minCutLength==lengths.get(left)){
           left++;
       }else{
           right--;
       }
       totalSum-=minCutLength;
        if(totalSum<minLength) return "Impossible";
        else if(totalSum>minLength){
            continue;
        }else{
            return "Possible";
        }
    }

return "";
 */