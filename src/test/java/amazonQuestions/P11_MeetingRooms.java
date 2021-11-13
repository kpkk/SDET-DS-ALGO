package amazonQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P11_MeetingRooms {
    /*

     String[][] meetingTimes = {{"09 00", "09 45"},{"09 30", "10 30"},{"10 40", "12 00"},{"11 00", "13 00"},{"11 45", "14 00"},{"16 00", "17 00"}};


    */
    @Test
    public void test1(){
        String[][] meetingTimes={{"09 00", "09 45"},{"09 30", "10 30"},{"10 40", "12 00"},{"11 00", "13 00"},{"11 45", "14 00"},{"16 00", "17 00"}};
        Assert.assertEquals(findMinMeetingRooms(meetingTimes),3);
    }
    @Test
    public void test2(){
        //{"09 30", "10 00"}, {"11 00", "11 10"}, {"09 00", "11 20"}, {"10 40", "11 40"}
        String[][] meetingTimes={{"09 30", "10 00"}, {"11 00", "11 10"}, {"09 00", "11 20"}, {"10 40", "11 40"}};
        //{{"09 00", "09 45"},{"09 30", "10 30"},{"10 40", "12 00"},{"11 00", "13 00"},{"11 45", "14 00"},{"16 00", "17 00"}};
        Assert.assertEquals(findMinMeetingRooms(meetingTimes),3);
    }

    /*
    Solution:-
    - first convert the string array into a int array by removing the spaces
    - get the end time of first meeting, start time of next meeting
    - if the start of next meeting is less than the end time of first meeting then increment the minrooms count
    -
     */
    private int findMinMeetingRooms(String[][] meetingTimes) {
        int[][] meetings=new int[meetingTimes.length][2];
        for (int i=0;i<meetingTimes.length;i++){
            meetings[i][0]=Integer.parseInt(meetingTimes[i][0].replaceAll(" ",""));
            meetings[i][1]=Integer.parseInt(meetingTimes[i][1].replaceAll(" ",""));
        }
        Arrays.sort(meetings,(a,b)->{if(a[1]!=b[1])return a[1]-b[1];else return a[0]-b[0];});
        int start=0, end=0, minRooms=meetings.length;
       while (start<meetings.length){
           if(meetings[start++][0]>=meetings[end][1]){
               minRooms--;
               end++;
           }
       }

       return minRooms;
    }

    private int meetingRooms(String[][] meetings){
        int[][] meeting=new int[meetings.length][2];
        for (int i=0;i<meetings.length;i++){
            meeting[i][0]=Integer.parseInt(meetings[i][0].replaceAll(" ",""));
            meeting[i][1]=Integer.parseInt(meetings[i][1].replaceAll(" ",""));
        }
        int start=0, end=0, meetingRooms=meeting.length;
        while (start<meeting.length){
            if(meeting[start++][0]>=meeting[end][1]){
                meetingRooms--;
                end++;
            }
        }
        return meetingRooms;
    }
}
