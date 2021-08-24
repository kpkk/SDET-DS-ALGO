package week8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MeetingRooms {

    /*

    String[][] meetingTimes = {{"09 00", "09 45"},{"09 30", "10 30"},{"10 40", "12 00"},{"11 00", "13 00"},{"11 45", "14 00"},{"16 00", "17 00"}};


   */
    @Test
    public void test1(){
        String[][] meetingTimes={{"09 00", "09 45"},{"09 30", "10 30"},{"10 40", "12 00"},{"11 00", "13 00"},{"11 45", "14 00"},{"16 00", "17 00"}};
        Assert.assertEquals(findMinMeetingRooms(meetingTimes),3);
    }

    /*
    Solution
    - Initialize two variables, availableRooms=0, meetingRooms=1
    - get the end time of meeting one and compare with the start time of subsequent meeting
    - if the value is lesser and availableRooms count =0 then increment meetingRoom
    - if the value is greater then continue
    - compare end times of consecutive meetings, if prev meeting end time is lesser than current meeting increment availablerooms by 1
    - return maxRooms
     */
    private int findMeetingRooms(String[][] meetingTimes) {
        int availableRooms=6, minRooms=1;

        Arrays.sort(meetingTimes, (a,b)->{ if (a[0]!=b[0]) return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
            else return Integer.parseInt(a[1])-Integer.parseInt(b[1]);
        });
        for (int i=0;i<meetingTimes.length-1;i++){
            int firstMeetEndTime= Integer.parseInt(meetingTimes[i][1].replaceAll(" ",""));
            int secondMeetStartTime= Integer.parseInt(meetingTimes[i+1][0].replaceAll(" ",""));
            int secondMeetEndTime=Integer.parseInt(meetingTimes[i+1][1].replaceAll(" ",""));

            if(firstMeetEndTime>secondMeetStartTime && availableRooms==0){
                minRooms++;
                availableRooms--;
            }
            else{
                availableRooms--;
            }
           /* if(secondMeetEndTime>firstMeetEndTime){
                availableRooms++;
            }*/

        }
        return minRooms;
    }

    private int findMinMeetingRooms(String[][] meetingRooms){
        int rooms[][]=new int[meetingRooms.length][2];
        for (int i=0;i<rooms.length;i++){
            rooms[i][0]=Integer.parseInt(meetingRooms[i][0].replaceAll(" ",""));
            rooms[i][1]=Integer.parseInt(meetingRooms[i][1].replaceAll(" ",""));
        }
        Arrays.sort(rooms,(a,b)->{if (a[1]!=b[1]) return a[1]-b[1]; else return a[0]-b[0]; });

        int start=0, end=0, minRooms=rooms.length;
       while (start<rooms.length){
           if(rooms[start++][0]>=rooms[end][1]){
               minRooms--;
               end++;
           }
       }

       return minRooms;
    }
}
