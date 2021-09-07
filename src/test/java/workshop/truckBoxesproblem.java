package workshop;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class truckBoxesproblem {

    /*
    You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.



Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91
5*10+ 3*9+ 2*7-->91
     */

    /*
    input- integer two dimensional array
    output- integer
     */

    /*
    Solution:-
    - Sort the array based on number of units per box (descending order)
    - initialize a variable called maxUnits=0
    - iterate the array from start until the end
    - if the total boxes is not zero
    - get the number of boxes count
    - while the number of boxes>0 and totalBoxes>0
        - Keep adding the number of units to the sum
        - decrement totalBoxes--, numberOfboxes--;
    - return the maxUnits
     */
    @Test
    public void test1(){
        int[][] nums={{1,3},{2,2},{3,1}};
        Assert.assertEquals(findTotalMaxBoxes(nums,4),8);
    }
    @Test
    public void test2(){
        int[][] nums={{5,10},{2,5},{4,7},{3,9}};
        Assert.assertEquals(findTotalMaxBoxes(nums,10),91);
    }

    private int findTotalMaxBoxes(int[][] nums,int totalBoxes) {
        int maxUnits=0;
        Arrays.sort(nums,(a,b)-> {if (b[1]!=a[1]) return b[1]-a[1]; else return b[0]-a[0];});
        for (int i=0;i<nums.length;i++){
            if(totalBoxes!=0){
                int numberOfBoxes=nums[i][0];
                while (numberOfBoxes>0 && totalBoxes!=0){
                    maxUnits+=nums[i][1];
                    totalBoxes--;
                    numberOfBoxes--;
                }
            }
        }
      return maxUnits;
    }
}

