package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AttendAllMeetings {
    /*
    Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true
     */
    @Test
    public void test1(){
        int[][] intervals= {{0,30},{5,10},{15,20}};
        Assert.assertFalse(canApersonAttendALlMeetings(intervals));
    }
    @Test
    public void test2(){
        int[][] intervals= {{7,10},{2,4}};
        Assert.assertTrue(canApersonAttendALlMeetings(intervals));
    }


    /*
    - sort the array based on endtime
    - iterate the array, compute the end time of current meeting and start time of next meeting
    - if start time of next meeting less than current meeting end time then return false
    - return true

     */
    private boolean canApersonAttendALlMeetings(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->{if (a[1]!=b[1]) return a[1]-b[1];
        else return a[0]-b[0];});
        for (int i=0;i<intervals.length-1;i++){
            if(intervals[i][1]>intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
