package dunZo;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DamDesignproblem {

    @Test
    public void test1(){
        List<Integer> wallHeights= Arrays.asList(1,2,4,7);
       List<Integer> wallPositions=Arrays.asList(4,6,8,11);
        Assert.assertEquals(maxheight(wallHeights,wallPositions),10);
    }

    private int maxHeight(int[] wallHeights, int[] wallPositions) {
        int n=wallHeights.length;
        int result=0;
        for (int i=0;i<n-1;i++){
            int hDiff= Math.abs(wallHeights[i+1]-wallHeights[i]);
            int gapLen=wallPositions[i+1]-wallPositions[i]-1;
            int currentMax=0;
            if(gapLen>hDiff){
                int low =Math.max(wallHeights[i+1],wallHeights[i])+1;
                int remGap=gapLen-hDiff-1;
                currentMax=low+remGap/2;

            }else{
                currentMax=Math.min(wallHeights[i+1],wallHeights[i])+gapLen;
            }
            result=Math.max(currentMax,result);
        }
        return result;
    }

    public int maxheight(List<Integer>wallPositions,List<Integer> wallHeights){
      int n=wallHeights.size();
      int result=0;
      for (int i=0;i<n-1;i++){
          int hDiff=Math.abs(wallHeights.get(i+1)-wallHeights.get(i));
          int gapLen= wallPositions.get(i+1)-wallPositions.get(i)-1;
          int currentMax=0;
          if(gapLen>hDiff){
              int low=Math.max(wallHeights.get(i+1),wallHeights.get(i))+1;
              int remGap= gapLen-hDiff-1;
              currentMax=(low+remGap)/2;
          }else{
              currentMax=Math.min(wallHeights.get(i+1),wallHeights.get(i))+gapLen;
          }
          result=Math.max(result,currentMax);
      }
      return result;
    }
}
