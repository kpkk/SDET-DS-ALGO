package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxMeetings {

    @Test
    public void test1(){
        int[][]meetings ={{1,3},{1,2},{2,4}};
        Assert.assertEquals(findMaxMetingsToAttend(meetings),2);
    }
    @Test
    public void test2(){
        int[][]meetings ={{1,2},{1,3},{2,3},{3,4}};
        Assert.assertEquals(findMaxMetingsToAttend(meetings),3);
    }
    @Test
    public void test3(){
        int[][]meetings ={{6,8},{1,3},{2,3},{3,4}};
        Assert.assertEquals(findMaxMetingsToAttend(meetings),3);
    }

    /*
    - initialize two variables called count=1, currentEnd=0
    - sort the two dimensional array based on the end time
    - iterate the array, and compare if the first meeting end time is less than next meeting's start time
    - if yes increment count and update the meeting end time as current meetings end time
    - return count

     */
    private int findMaxMetingsToAttend(int[][] meetings) {
        int count=1, currentEnd=0;
        Arrays.sort(meetings,(a,b)->{if(a[1]!=b[1])return a[1]-b[1];
        else return a[0]-b[0];});
        for (int i=0;i<meetings.length-1;i++){
            if(meetings[currentEnd][1]<=meetings[i+1][0]){
                currentEnd++;
                count++;
            }
        }
        return count;
    }
}
