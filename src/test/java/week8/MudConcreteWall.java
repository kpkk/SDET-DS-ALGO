package week8;

import org.junit.Assert;
import org.junit.Test;

public class MudConcreteWall {

    /*
    Your company is designing a dam to be built across a stream to create a small lake. To reduce materials cost, it will be made of one or more concrete walls with mud packed in between them. Determine the maximum height of the mud segments in the dam with the following restrictions:

One unit width of the gap between walls will contain one segment of packed mud
The height of mud in a segment cannot exceed 1 unit more than an adjacent wall or mud segment.

Given the placement of a number of walls and their heights, determine the maximum height of a mud segment that can be built. If no mud segment can be built, return 0.

Example
wallPositions = [1, 2, 4, 7]
wallHeights = [4, 6, 8, 11]

     */
    private int maxMudHeight(int[] positions, int[] heights){
        return 0;
    }

    @Test
    public void test1(){
        int[] positions={1,3,7};
        int[] heights={4,3,3};
        Assert.assertEquals(findMaxMudWallheight(positions,heights),5);
    }
    @Test
    public void test2(){
        int[] positions={1,10};
        int[] heights={1,5};
        Assert.assertEquals(findMaxMudWallheight(positions,heights),7);
    }

    /*
    - init left=0, right=1, max=0
    - crete an array of size as last element of position array
    - fill the wall heights at the respective indices as per positions in the new array
    - iterate the new  array, left=0, right1, find the diff between right and left
    - if the right is 0 then add left+1 at right index, increment left and right
    - if the right no-zero find the diff between right-left,
        - if the diff is >1 then start incrementing from right towards left (left=right+1)--while
    - find the max and return

     */
    private int findMaxMudWallheight(int[] positions, int[] heights) {
        int left=0, right=1;
        int[] totalWalls=new int[positions[positions.length-1]];
        for (int i=0;i<positions.length;i++){
            totalWalls[positions[i]-1]= heights[i];
        }
       while (right<totalWalls.length){
           if(totalWalls[right]==0){
               totalWalls[right]=totalWalls[left]+1;
           }
           left++;
           right++;
       }
       right=totalWalls.length-1;
       left=right-1;
       while (left>=0){
           if(Math.abs(totalWalls[right]-totalWalls[left])>1){
               totalWalls[left]=totalWalls[right]+1;
           }
           left--;
           right--;
       }
       int max=totalWalls[0];
      for (int i=1;i<totalWalls.length;i++){
          if(totalWalls[i]>max){
              max=totalWalls[i];
          }
      }
      return max;
    }
/*
    int n = wallPositions.size();
    int result = 0;
		for (int i = 0; i < n - 1; i++) {
        int hDiff = Math.abs((wallHeights.get(i + 1) - wallHeights.get(i)));
        int gapLen = wallPositions.get(i + 1) - wallPositions.get(i) - 1;
        int localMax = 0;
        if (gapLen > hDiff) {
            int low = Math.max(wallHeights.get(i + 1), wallHeights.get(i)) + 1;
            int remGap = gapLen - hDiff - 1;
            localMax = low + remGap / 2;
        } else {
            localMax = Math.min(wallHeights.get(i + 1), wallHeights.get(i)) + gapLen;
        }
        result = Math.max(result, localMax);
    }
		return result;
*/
}
