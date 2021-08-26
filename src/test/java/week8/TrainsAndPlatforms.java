package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TrainsAndPlatforms {

    /*

    Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.


Example 1:

Input: n = 6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation:
Minimum 3 platforms are required to
safely arrive and depart all trains.
Example 2:

Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to
safely manage the arrival and departure
of all trains.

     */
    @Test
    public void test1(){
        String[] arrival={"0900", "0940", "0950", "1100", "1500", "1800"};  //6
        String[] departure={"0910", "1200", "1120", "1130", "1900", "2000"};
        Assert.assertEquals(findPlatforms(arrival,departure),3);
    }
    @Test
    public void test2(){
        String[] arrival={"0900", "1100", "1235"};
        String[] departure={"1000", "1200", "1240"};
        Assert.assertEquals(findPlatforms(arrival,departure),1);
    }

    private int findPlatforms(String[] arrival, String[] departure) {
        int[][] trainTimings=new int[arrival.length][2];
        for (int i=0;i<trainTimings.length;i++){
            trainTimings[i][0]=Integer.parseInt(arrival[i]);
            trainTimings[i][1]=Integer.parseInt(departure[i]);
        }
        Arrays.sort(trainTimings,(a,b)->{if(a[1]!=b[1]) return a[1]-b[1]; else return a[0]-b[0];});
        int start=0, end=0,platforms=arrival.length;
        while (start<trainTimings.length-1){
            if(trainTimings[start+1][0]>trainTimings[end][1]){
                platforms--;
                end++;
            }
            start++;
        }
        return platforms;
    }
}
